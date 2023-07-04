package co.com.csj;

import co.com.csj.model.Docencia;
import co.com.csj.model.auditoriaP;
import co.com.csj.model.licencia_permiso;
import co.com.csj.model.permisos;
import co.com.csj.model.tipo;
import co.com.csj.model.usuario;
import co.com.csj.modelos.consultas;
import co.com.csj.modelos.despacho;
import co.com.csj.modelos.localizacion;
import co.com.csj.persistence.PersistenceUtil;
import co.com.csj.service.tipoLocalServiceUtil;
import co.com.csj.service.usuarioLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public enum ExporterUtil {
    INSTANCE;
    
    private static String BDPortal = "lportalramaprod";
    private static String BDApps = "APPsPortal";
    
    private static DateFormat formato,formato1,formato2,formato3;
    private static String dias[] = {"domingo","lunes","martes","miercoles","jueves","viernes","sabado"};
    private static String meses[] = {"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
    private static String trimestres[] = {"Enero a Marzo","Abril a Junio","Julio a Septiembre","Octubre a Diciembre"};

    static {
        formato = new SimpleDateFormat("yyyy-MM-dd");
        formato1 = new SimpleDateFormat("dd/MM/yyyy");
        formato2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        formato3 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
    }

    public Workbook exportPermissionsToExcel(List<licencia_permiso> permisos2) {
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Permisos");
        this.addHeaders((Object)sheet);
        this.generateTableRecords((Object)sheet, permisos2);
        for (int columnNumber = 0; columnNumber <= 21; ++columnNumber) {
            sheet.autoSizeColumn(columnNumber);
        }
        return wb;
    }
    
    public Workbook exportNoReportanPermisosToExcel(int trimestre) throws SystemException, PortalException {
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("NoReportanPermisos");
        CellStyle styleCc = wb.createCellStyle();
        styleCc.setAlignment(HorizontalAlignment.CENTER);
        this.addNoReportanPermisosCabecera((Object)sheet,styleCc,trimestre);
        this.generateTableNoReportanPermisos((Object)sheet,trimestre);
        for (int columnNumber = 0; columnNumber <= 4; ++columnNumber) {
            sheet.autoSizeColumn(columnNumber);
        }
        return wb;
    }
    
    public Workbook exportNoReportanDocenciasToExcel(int semestre) throws SystemException, PortalException {
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("NoReportanDocencias");
        CellStyle styleCc = wb.createCellStyle();
        styleCc.setAlignment(HorizontalAlignment.CENTER);
        this.addNoReportanDocenciasCabecera((Object)sheet,styleCc,semestre);
        this.generateTableNoReportanDocencias((Object)sheet,semestre);
        for (int columnNumber = 0; columnNumber <= 4; ++columnNumber) {
            sheet.autoSizeColumn(columnNumber);
        }
        return wb;
    }

    public Workbook exportCargosToExcel(List<permisos> permisos2) {
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Cargos de Usuarios");
        this.addHeadersCargos((Object)sheet);
        this.generateTableCargos((Object)sheet, permisos2);
        for (int columnNumber = 0; columnNumber <= 5; ++columnNumber) {
            sheet.autoSizeColumn(columnNumber);
        }
        return wb;
    }

    public Workbook exportDocentesToExcel(List<Docencia> permisosDocencia) throws ParseException {
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Permisos");
        this.addHeadersDocencia((Object)sheet);
        this.generateTableRecordsDocencia((Object)sheet, permisosDocencia);
        for (int columnNumber = 0; columnNumber <= 14; ++columnNumber) {
            sheet.autoSizeColumn(columnNumber);
        }
        return wb;
    }

    public Workbook exportReporteDespachos(int tipo, String fi, String ff) throws ParseException {
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Despachos");
        this.addHeadersDespachos((Object)sheet, tipo);
        this.generateTableRecordsDespachos((Object)sheet, tipo, fi, ff);
        for (int columnNumber = 0; columnNumber <= 3; ++columnNumber) {
            sheet.autoSizeColumn(columnNumber);
        }
        return wb;
    }

    private void addHeaders(Object element) {
        if (element instanceof Sheet) {
            Row headerRow = ((Sheet)element).createRow(0);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("C\u00f3digo"));
            headerRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString("Acto Administrativo"));
            headerRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("Usuario"));
            headerRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString("C\u00e9dula de Ciudadan\u00eda"));
            headerRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString("Cargo"));
            headerRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString("Tipo de Situación Administrativa"));
            headerRow.createCell(6).setCellValue((RichTextString)new HSSFRichTextString("Horas Laborales"));
            headerRow.createCell(7).setCellValue((RichTextString)new HSSFRichTextString("Fecha Inicial"));
            headerRow.createCell(8).setCellValue((RichTextString)new HSSFRichTextString("Fecha Final"));
            headerRow.createCell(9).setCellValue((RichTextString)new HSSFRichTextString("Duración en días hábiles"));
            headerRow.createCell(10).setCellValue((RichTextString)new HSSFRichTextString("Año"));
            headerRow.createCell(11).setCellValue((RichTextString)new HSSFRichTextString("Mes"));
            headerRow.createCell(12).setCellValue((RichTextString)new HSSFRichTextString("Día"));
            headerRow.createCell(13).setCellValue((RichTextString)new HSSFRichTextString("Trimestre"));
            headerRow.createCell(14).setCellValue((RichTextString)new HSSFRichTextString("Departamento"));
            headerRow.createCell(15).setCellValue((RichTextString)new HSSFRichTextString("Distrito"));
            headerRow.createCell(16).setCellValue((RichTextString)new HSSFRichTextString("Municipio"));
            headerRow.createCell(17).setCellValue((RichTextString)new HSSFRichTextString("Despacho"));
            headerRow.createCell(18).setCellValue((RichTextString)new HSSFRichTextString("Dependencia"));
            headerRow.createCell(19).setCellValue((RichTextString)new HSSFRichTextString("Especialidad"));
            headerRow.createCell(20).setCellValue((RichTextString)new HSSFRichTextString("Usuario que Registro"));
            headerRow.createCell(21).setCellValue((RichTextString)new HSSFRichTextString("Estado del Permiso"));
        }
    }

    private void addNoReportanPermisosCabecera(Object element,CellStyle style, int trimestre) {
        if (element instanceof Sheet) {
        	
            Row headerRow = ((Sheet)element).createRow(0);
            Row headerRow1 = ((Sheet)element).createRow(1);
            Row headerRow2 = ((Sheet)element).createRow(2);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Usuarios que no han reportado permisos en el trimestre actual"));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
            if(trimestre==1){
            	headerRow1.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Enero - Marzo"));
            	((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
            }
            if(trimestre==2){
            	headerRow1.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Abril - Junio"));
            	((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
            }
            if(trimestre==3){
            	headerRow1.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Julio - Septiembre"));
            	((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
            }
            if(trimestre==4){
            	headerRow1.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Octubre - Diciembre"));
            	((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
            }
            headerRow2.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Nombre"));
            headerRow2.createCell(1).setCellValue((RichTextString)new HSSFRichTextString("Correo Electronico"));
            headerRow2.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("Cargo"));
            headerRow2.createCell(3).setCellValue((RichTextString)new HSSFRichTextString("Departamento"));
            headerRow2.createCell(4).setCellValue((RichTextString)new HSSFRichTextString("Municipio"));
            headerRow.getCell(0).setCellStyle(style);
            headerRow1.getCell(0).setCellStyle(style);
            headerRow2.getCell(0).setCellStyle(style);
            headerRow2.getCell(1).setCellStyle(style);
            headerRow2.getCell(2).setCellStyle(style);
            headerRow2.getCell(3).setCellStyle(style);
            headerRow2.getCell(4).setCellStyle(style);
            
        }
    }
    
    private void addNoReportanDocenciasCabecera(Object element,CellStyle style, int semestre) {
        if (element instanceof Sheet) {
        	
            Row headerRow = ((Sheet)element).createRow(0);
            Row headerRow1 = ((Sheet)element).createRow(1);
            Row headerRow2 = ((Sheet)element).createRow(2);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Usuarios que no han reportado docencia e investigacion en el semestre actual"));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
            if(semestre==1){
            	headerRow1.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Enero - Junio"));
            	((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
            }
            if(semestre==2){
            	headerRow1.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Julio - Diciembre"));
            	((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 4));
            }
            headerRow2.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Nombre"));
            headerRow2.createCell(1).setCellValue((RichTextString)new HSSFRichTextString("Correo Electronico"));
            headerRow2.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("Cargo"));
            headerRow2.createCell(3).setCellValue((RichTextString)new HSSFRichTextString("Departamento"));
            headerRow2.createCell(4).setCellValue((RichTextString)new HSSFRichTextString("Municipio"));
            headerRow.getCell(0).setCellStyle(style);
            headerRow1.getCell(0).setCellStyle(style);
            headerRow2.getCell(0).setCellStyle(style);
            headerRow2.getCell(1).setCellStyle(style);
            headerRow2.getCell(2).setCellStyle(style);
            headerRow2.getCell(3).setCellStyle(style);
            headerRow2.getCell(4).setCellStyle(style);
            
        }
    }
    
    private void addHeadersDocencia(Object element) {
        if (element instanceof Sheet) {
            Row headerRow = ((Sheet)element).createRow(0);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("C\u00f3digo"));
            headerRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString("Usuario"));
            headerRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("C\u00e9dula de Ciudadan\u00eda"));
            headerRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString("Cargo"));
            headerRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString("Materia"));
            headerRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString("Horas de Docencia"));
            headerRow.createCell(6).setCellValue((RichTextString)new HSSFRichTextString("Instituci\u00f3n"));
            headerRow.createCell(7).setCellValue((RichTextString)new HSSFRichTextString("Fecha Inicial"));
            headerRow.createCell(8).setCellValue((RichTextString)new HSSFRichTextString("Fecha Final"));
            headerRow.createCell(9).setCellValue((RichTextString)new HSSFRichTextString("Departamento"));
            headerRow.createCell(10).setCellValue((RichTextString)new HSSFRichTextString("Distrito"));
            headerRow.createCell(11).setCellValue((RichTextString)new HSSFRichTextString("Municipio"));
            headerRow.createCell(12).setCellValue((RichTextString)new HSSFRichTextString("C\u00f3digo del Despacho"));
            headerRow.createCell(13).setCellValue((RichTextString)new HSSFRichTextString("Nombre del Despacho"));
            headerRow.createCell(14).setCellValue((RichTextString)new HSSFRichTextString("Usuario que Registro"));
        }
    }

    private void addHeadersCargos(Object element) {
        if (element instanceof Sheet) {
            Row headerRow = ((Sheet)element).createRow(0);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("C\u00f3digo"));
            headerRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString("Nombre Completo"));
            headerRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("Correo"));
            headerRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString("Cargo"));
            headerRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString("Departamento"));
            headerRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString("Municipio"));
        }
    }

    private void addHeadersDespachos(Object element, int tipo) {
        if (element instanceof Sheet) {
            Row headerRow = ((Sheet)element).createRow(0);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("C\u00f3digo Despacho"));
            headerRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString("Nombre Despacho"));
            if (tipo == 1) {
                headerRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("Permisos Reportados"));
            }
            if (tipo == 2) {
                headerRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("Docencias Reportadas"));
            }
            headerRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString("Fecha del ultimo registro"));
        }
    }

    private void generateTableCargos(Object element, List<permisos> permisos2) {
        if (element instanceof Sheet) {
            Sheet sheet = (Sheet)element;
            for (int i = 0; i < permisos2.size(); ++i) {
                permisos usuarioPermiso = permisos2.get(i);
                Row contentRow = sheet.createRow(i + 1);
                contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(usuarioPermiso.getId())));
                try {
                    String userName = String.valueOf(UserLocalServiceUtil.getUser((long)Long.parseLong(usuarioPermiso.getUsuario())).getFirstName()) + " " + UserLocalServiceUtil.getUser((long)Long.parseLong(usuarioPermiso.getUsuario())).getLastName();
                    String correo = UserLocalServiceUtil.getUser(Long.parseLong(usuarioPermiso.getUsuario())).getEmailAddress();
                    contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString(userName));
                    contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString(correo));
                }
                catch (NumberFormatException e) {
                	contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString("Usuario Eliminado del Portal"));
                    contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("Usuario Eliminado del Portal"));
                }
                catch (PortalException e) {
                	contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString("Usuario Eliminado del Portal"));
                    contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("Usuario Eliminado del Portal"));
                }
                catch (SystemException e) {
                	contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString("Usuario Eliminado del Portal"));
                    contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("Usuario Eliminado del Portal"));
                }
                contentRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(usuarioPermiso.getCargo())));
                if(!usuarioPermiso.getCargo().equalsIgnoreCase("Permisos y Docencia Nacional")){
	                contentRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString(consultas.obtenerDepartamento((String)usuarioPermiso.getD_m().substring(0, 2))));
	                if (usuarioPermiso.getD_m().length() > 2) {
	                    contentRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString(consultas.getMunicipio((String)usuarioPermiso.getD_m())));
	                    continue;
	                }
	                contentRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString(""));
                }else{
                	contentRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString(""));
                	contentRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString(""));
                }
            }
        }
    }

    private void generateTableRecords(Object element, List<licencia_permiso> permisos2) {
        if (element instanceof Sheet) {
            Sheet sheet = (Sheet)element;
            String ids="";
            for (int i = 0; i < permisos2.size(); ++i) {
                licencia_permiso permiso = permisos2.get(i);
//                if(permisos2.size()-1==i){
//                	ids+=permiso.getId();
//                }else{
//                	ids+=permiso.getId()+",";
//                }
                try {
					PersistenceUtil.realizaConsulta("insert into SJ_busqueda values ("+permiso.getId()+")", false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            String sql = 	"SELECT permisos.id,permisos.acto_admin,usu.nombre+' '+usu.apellido nombre,usu.cedula_id,carg.descripcion,tipo.Descripcion,permisos.fecha_inicio,permisos.fecha_fin,  "+
	                		"year(permisos.fecha_inicio) anhio,month(permisos.fecha_inicio) mes,datepart(dw,permisos.fecha_inicio) dia,datepart(quarter,permisos.fecha_inicio) trimestre, "+
	                		"depa.nombre departemento,dist.nombre distrito,muni.nombre municipio,desp.nombre despacho,d.dependencia entidad,e.especialidad especialidad,usuario.emailAddress registro, "+
	                		"permisos.horas_permiso horas, permisos.estatus, permisos.minutos_permiso minutos "+
	                		"from SJ_licencia_permiso permisos  join SJ_busqueda bus on (permisos.id = bus.id)  "+
	                		"join SJ_tipo tipo on (tipo.ID = permisos.tipo_fk)  "+
	                		"left join "+BDPortal+".dbo.User_ usuario on (usuario.userId=permisos.created_by)  "+
	                		"join DESPACHO_PRU.dbo.ADM_LOCALIZACION depa on (depa.cod_dane = SUBSTRING(permisos.despacho_fk, 1, 2) )  "+
	                		"join DESPACHO_PRU.dbo.ADM_LOCALIZACION muni on (muni.cod_dane_departamento = SUBSTRING(permisos.despacho_fk, 1, 2)and muni.cod_dane = SUBSTRING(permisos.despacho_fk, 3, 3))  "+
	                		"join SJ_usuario usu on (usu.cedula_id=permisos.usuario_fk)  "+
	                		"join SJ_cargo carg on (carg.id=permisos.cargo_fk)  "+
	                		"join DESPACHO_PRU.dbo.fun_despacho_info desp on (permisos.despacho_fk=desp.CODIGO)  "+
	                		"join DESPACHO_PRU.dbo.ADM_ENTIDAD ent on (SUBSTRING(desp.CODIGO,6,2)=ent.CODIGO)  "+
	                		"join DESPACHO_PRU.dbo.ADM_ESPECIALIDAD esp on (SUBSTRING(desp.CODIGO,8,2)=esp.CODIGO)  "+
	                		"join DESPACHO_PRU.dbo.ADM_JURISDICCION jur on (jur.ID=ent.FK_ENTIDAD_TO_JURIDICCION)  "+
	                		"left join DESPACHO_PRU.dbo.ADM_MAPA_JUDICIAL mj on (mj.FK_DANEDEPAR_TO_MAPA=depa.cod_dane and mj.FK_DANEMUNI_TO_MAPA=muni.COD_DANE and mj.FK_JURIDICCION_TO_MAPA=jur.ID)  "+
	                		"left join DESPACHO_PRU.dbo.ADM_CIRCUITO circuito on (circuito.ID=mj.FK_CIRCUITO_TO_MAPA)  "+
	                		"left join DESPACHO_PRU.dbo.ADM_DISTRITO dist on (dist.ID=circuito.FK_DISTRITO_TO_CIRCUITO)  "+
	                		"left join DESPACHO_PRU.dbo.SJ_despacho_dependencia_especialidad dde on (permisos.despacho_fk = dde.codigo_despacho) "+
	                		"left join DESPACHO_PRU.dbo.SJ_dependencia d on (dde.id_dependencia = d.id) "+
	                		"left join DESPACHO_PRU.dbo.SJ_especialidad e on (dde.id_especialidad = e.id) ";
                try {
                	int i =0;
                	ResultSet result = PersistenceUtil.realizaConsulta((String)sql, (boolean)false);
                	if (result != null) {
                		
                        while (result.next()) {
                        	Row contentRow = sheet.createRow(i + 1);
                            contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString(result.getString(1)));
							contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString(result.getString(2)));
							contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString(result.getString(3)));
							contentRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString(result.getString(4)));
							contentRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString(result.getString(5)));
							contentRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString(result.getString(6)));
							String horas = "0";
							String minutos = "0";
							if(result.getString(20) != null )
								horas = result.getString(20);
							if(result.getString(22)!=null )
								minutos = result.getString(22);
							contentRow.createCell(6).setCellValue((RichTextString)new HSSFRichTextString(horas+" horas y "+minutos+" minutos"));
							Date inicio = formato.parse(result.getString(7));
							Date fin = formato.parse(result.getString(8));
							contentRow.createCell(7).setCellValue((RichTextString)new HSSFRichTextString(formato1.format(inicio)));
							contentRow.createCell(8).setCellValue((RichTextString)new HSSFRichTextString(formato1.format(fin)));
							
							contentRow.createCell(9).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(diasHabiles(inicio, fin))));
							contentRow.createCell(10).setCellValue((RichTextString)new HSSFRichTextString(result.getString(9)));
							contentRow.createCell(11).setCellValue((RichTextString)new HSSFRichTextString(meses[result.getInt(10)-1]));
							contentRow.createCell(12).setCellValue((RichTextString)new HSSFRichTextString(dias[result.getInt(11)-1]));
							contentRow.createCell(13).setCellValue((RichTextString)new HSSFRichTextString(trimestres[result.getInt(12)-1]));
							contentRow.createCell(14).setCellValue((RichTextString)new HSSFRichTextString(result.getString(13)));
							String distrito = "";
							if(result.getString(14)==null || result.getString(14).isEmpty())
								distrito = "Distrito no encontrado";
							else
								distrito = result.getString(14);
							contentRow.createCell(15).setCellValue((RichTextString)new HSSFRichTextString(distrito));
							contentRow.createCell(16).setCellValue((RichTextString)new HSSFRichTextString(result.getString(15)));
							contentRow.createCell(17).setCellValue((RichTextString)new HSSFRichTextString(result.getString(16)));
							contentRow.createCell(18).setCellValue((RichTextString)new HSSFRichTextString(result.getString(17)));
							contentRow.createCell(19).setCellValue((RichTextString)new HSSFRichTextString(result.getString(18)));
							String registro = "";
							if(result.getString(19)==null || result.getString(19).isEmpty())
								registro = "Usuario eliminado del portal";
							else
								registro = result.getString(19);
							contentRow.createCell(20).setCellValue((RichTextString)new HSSFRichTextString(registro));
							if (result.getInt(21) == 0) {
			                    contentRow.createCell(21).setCellValue((RichTextString)new HSSFRichTextString("Permiso Cancelado"));
			                }else{
			                contentRow.createCell(21).setCellValue((RichTextString)new HSSFRichTextString(" "));
			                }
							i++;
                        }
                    }
                	PersistenceUtil.realizaConsulta("delete SJ_busqueda", false);
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            
        }
    }
    
    private int diasHabiles(Date fechaI,Date fechaF){
    	int dias = 0;
    	Calendar inicio = Calendar.getInstance();
    	Calendar fin = Calendar.getInstance();
    	inicio.setTime(fechaI);
    	fin.setTime(fechaF);
    	while(inicio.before(fin) || inicio.equals(fin)){
    		if(inicio.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && inicio.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
    			dias++;
    		}
    		inicio.add(Calendar.DATE, 1);
    	}
    	
    	return dias;
    }

    private void generateTableRecordsDocencia(Object element, List<Docencia> permisos2) throws ParseException {
        if (element instanceof Sheet) {
            Sheet sheet = (Sheet)element;
            String ids="";
            for (int i = 0; i < permisos2.size(); ++i) {
            	Docencia permiso = permisos2.get(i);
//                if(permisos2.size()-1==i){
//                	ids+=permiso.getId();
//                }else{
//                	ids+=permiso.getId()+",";
//                }
            	try {
					PersistenceUtil.realizaConsulta("insert into SJ_busqueda values ("+permiso.getId()+")", false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            }
            String sql = 	"select "+
							"docencia.id,usu.nombre+' '+usu.apellido,usu.cedula_id,carg.descripcion,docencia.materia,docencia.horas_docencia,docencia.institucion, "+
							"docencia.fecha_inicial,docencia.fecha_final,depa.NOMBRE,dist.NOMBRE,muni.NOMBRE,docencia.despacho_fk,desp.NOMBRE,usuario.emailAddress,docencia.minutos_docencia "+
							"from SJ_DOCENCIA docencia  join SJ_busqueda bus on (docencia.id = bus.id)  "+
							"left join "+BDPortal+".dbo.User_ usuario on (usuario.userId=docencia.created_by) "+
							"join DESPACHO_PRU.dbo.ADM_LOCALIZACION depa on (depa.cod_dane = SUBSTRING(docencia.despacho_fk, 1, 2) ) "+
							"join DESPACHO_PRU.dbo.ADM_LOCALIZACION muni on (muni.cod_dane_departamento = SUBSTRING(docencia.despacho_fk, 1, 2)and muni.cod_dane = SUBSTRING(docencia.despacho_fk, 3, 3)) "+
							"join SJ_usuario usu on (usu.cedula_id=docencia.usuario_fk) "+
							"join SJ_cargo carg on (carg.id=docencia.cargo_fk) "+
							"join DESPACHO_PRU.dbo.fun_despacho_info desp on (docencia.despacho_fk=desp.CODIGO) "+
							"join DESPACHO_PRU.dbo.ADM_ENTIDAD ent on (SUBSTRING(desp.CODIGO,6,2)=ent.CODIGO) "+
							"join DESPACHO_PRU.dbo.ADM_JURISDICCION jur on (jur.ID=ent.FK_ENTIDAD_TO_JURIDICCION) "+
							"join DESPACHO_PRU.dbo.ADM_MAPA_JUDICIAL mj on (mj.FK_DANEDEPAR_TO_MAPA=depa.cod_dane and mj.FK_DANEMUNI_TO_MAPA=muni.COD_DANE and mj.FK_JURIDICCION_TO_MAPA=jur.ID) "+
							"join DESPACHO_PRU.dbo.ADM_CIRCUITO circuito on (circuito.ID=mj.FK_CIRCUITO_TO_MAPA) "+
							"join DESPACHO_PRU.dbo.ADM_DISTRITO dist on (dist.ID=circuito.FK_DISTRITO_TO_CIRCUITO) ";
                
                try {
                	int i= 0;
					ResultSet result = PersistenceUtil.realizaConsulta((String)sql, (boolean)false);
					if (result != null) {
                		
                        while (result.next()) {
                        	Row contentRow = sheet.createRow(i + 1);
                            contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString(result.getString(1)));
							contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString(result.getString(2)));
							contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString(result.getString(3)));
							contentRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString(result.getString(4)));
							contentRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString(result.getString(5)));
							String horas = "0";
							String minutos = "0";
							if(result.getString(6) != null )
								horas = result.getString(6);
							if(result.getString(16)!=null )
								minutos = result.getString(16);
							contentRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString(horas+" horas y "+minutos+" minutos"));
							contentRow.createCell(6).setCellValue((RichTextString)new HSSFRichTextString(result.getString(7)));
							Date inicio = formato.parse(result.getString(8));
							Date fin = formato.parse(result.getString(9));
							contentRow.createCell(7).setCellValue((RichTextString)new HSSFRichTextString(formato1.format(inicio)));
							contentRow.createCell(8).setCellValue((RichTextString)new HSSFRichTextString(formato1.format(fin)));
							contentRow.createCell(9).setCellValue((RichTextString)new HSSFRichTextString(result.getString(10)));
							contentRow.createCell(10).setCellValue((RichTextString)new HSSFRichTextString(result.getString(11)));
							contentRow.createCell(11).setCellValue((RichTextString)new HSSFRichTextString(result.getString(12)));
							contentRow.createCell(12).setCellValue((RichTextString)new HSSFRichTextString(result.getString(13)));
							contentRow.createCell(13).setCellValue((RichTextString)new HSSFRichTextString(result.getString(14)));
							String registro = "";
							if(result.getString(15)==null || result.getString(15).isEmpty())
								registro = "Usuario eliminado del portal";
							else
								registro = result.getString(15);
							contentRow.createCell(14).setCellValue((RichTextString)new HSSFRichTextString(registro));
							i++;
                        }
                    }
					PersistenceUtil.realizaConsulta("delete SJ_busqueda", false);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
        }
    }

    private void generateTableRecordsDespachos(Object element, int tipo2, String fi, String ff) throws ParseException {
        if (element instanceof Sheet) {
            Sheet sheet = (Sheet)element;
            List despacho2 = new ArrayList();
            if (tipo2 == 1) {
                despacho2 = consultas.reporteDespachosPermisos((String)fi, (String)ff);
            }
            if (tipo2 == 2) {
                despacho2 = consultas.reporteDespachosDocencia((String)fi, (String)ff);
            }
            for (int i = 0; i < despacho2.size(); ++i) {
                despacho des = (despacho)despacho2.get(i);
                Row contentRow = sheet.createRow(i + 1);
                contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString(des.getCodigo()));
                contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString(des.getNombre()));
                contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(des.getArea())));
                Date fechaR = null;
                if(!des.getFecha().equalsIgnoreCase("")){
                	fechaR = formato2.parse(des.getFecha());
                	contentRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString(formato3.format(fechaR)));
                }else{
                	contentRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString(""));
                }
            }
        }
    }

    private void generateTableNoReportanPermisos(Object element, int trimestre) throws SystemException, PortalException {
        if (element instanceof Sheet) {
            Sheet sheet = (Sheet)element;
            List<User> user = consultas.getUsuariosNoRegistran(trimestre);
            int i = 3;
            List<localizacion> departamentos = consultas.obtenerMDepartamentos();
        	List<localizacion> municipios = consultas.obtenerTodosMuni();
            		
            for(User u : user) {
            	Row contentRow = sheet.createRow(i);
                contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString(u.getFullName()));
                contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString(u.getEmailAddress()));
                contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString(consultas.getCargoUsuario(u.getUserId())));
                String despar = "";
		       	String muni = "";
		       	if(consultas.getCargoUsuario(u.getUserId()).equalsIgnoreCase("Magistrado") || consultas.getCargoUsuario(u.getUserId()).equalsIgnoreCase("Magistrado Seccional") || consultas.getCargoUsuario(u.getUserId()).equalsIgnoreCase("Permisos por Distrito") || consultas.getCargoUsuario(u.getUserId()).equalsIgnoreCase("Permisos y Docencia por Distrito"))
		       		for(localizacion d : departamentos)
		       			for(String l : consultas.getUsuarioAsociado(u.getUserId()))
			       			if(d.getCod_dane().equalsIgnoreCase(l) && d.getCod_dane_departamento().equalsIgnoreCase(l))
			       				despar+=d.getNombre()+"/";

		       	if(consultas.getCargoUsuario(u.getUserId()).equalsIgnoreCase("Juez")){
		       		for(localizacion departamento : departamentos)
		       			for(String l : consultas.getUsuarioAsociado(u.getUserId()))
			       			if(departamento.getCod_dane().equalsIgnoreCase(l.substring(0, 2)) && departamento.getCod_dane_departamento().equalsIgnoreCase(l.substring(0, 2)))
			       				despar = departamento.getNombre();
		       		
		       		for(localizacion d : municipios)
		       			for(String l : consultas.getUsuarioAsociado(u.getUserId()))
			       			if(l.equalsIgnoreCase(d.getCod_dane_departamento()+d.getCod_dane()))
			       				muni=d.getNombre();
		       	}
		       	contentRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString(despar));
		       	contentRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString(muni));
				i++;
            }

                
            
        }
    }
    
    private void generateTableNoReportanDocencias(Object element, int semestre) throws SystemException, PortalException {
        if (element instanceof Sheet) {
            Sheet sheet = (Sheet)element;
            List<User> user = consultas.getUsuariosNoRegistranD(semestre);
            int i = 3;
            List<localizacion> departamentos = consultas.obtenerMDepartamentos();
        	List<localizacion> municipios = consultas.obtenerTodosMuni();
            		
            for(User u : user) {
            	Row contentRow = sheet.createRow(i);
                contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString(u.getFullName()));
                contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString(u.getEmailAddress()));
                contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString(consultas.getCargoUsuario(u.getUserId())));
                String despar = "";
		       	String muni = "";
		       	if(consultas.getCargoUsuario(u.getUserId()).equalsIgnoreCase("Magistrado") || consultas.getCargoUsuario(u.getUserId()).equalsIgnoreCase("Magistrado Seccional") || consultas.getCargoUsuario(u.getUserId()).equalsIgnoreCase("Permisos por Distrito") || consultas.getCargoUsuario(u.getUserId()).equalsIgnoreCase("Permisos y Docencia por Distrito"))
		       		for(localizacion d : departamentos)
		       			for(String l : consultas.getUsuarioAsociado(u.getUserId()))
			       			if(d.getCod_dane().equalsIgnoreCase(l) && d.getCod_dane_departamento().equalsIgnoreCase(l))
			       				despar+=d.getNombre()+"/";

		       	if(consultas.getCargoUsuario(u.getUserId()).equalsIgnoreCase("Juez")){
		       		for(localizacion departamento : departamentos)
		       			for(String l : consultas.getUsuarioAsociado(u.getUserId()))
			       			if(departamento.getCod_dane().equalsIgnoreCase(l.substring(0, 2)) && departamento.getCod_dane_departamento().equalsIgnoreCase(l.substring(0, 2)))
			       				despar = departamento.getNombre();
		       		
		       		for(localizacion d : municipios)
		       			for(String l : consultas.getUsuarioAsociado(u.getUserId()))
			       			if(l.equalsIgnoreCase(d.getCod_dane_departamento()+d.getCod_dane()))
			       				muni=d.getNombre();
		       	}
		       	contentRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString(despar));
		       	contentRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString(muni));
				i++;
            }

                
            
        }
    }

    public Workbook exportReporteAuditoria(String tipor , String fi, String ff, String correo, String id, List<auditoriaP> audi) throws SystemException, ParseException {
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet1 = wb.createSheet("Auditoria Permisos y Doccencias");
        
        CellStyle styleC = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        styleC.setFont(font);
        
        CellStyle styleCc = wb.createCellStyle();
        styleCc.setBorderBottom(BorderStyle.THIN);
        styleCc.setBorderTop(BorderStyle.THIN);
        styleCc.setBorderRight(BorderStyle.THIN);
        styleCc.setBorderLeft(BorderStyle.THIN);
    	
    	String fechaInicial = "";
    	String fechaFinal = "";
    	
    	fechaInicial = fi+" 00:00";
    	fechaFinal =  ff+" 23:59";
    	
    	SimpleDateFormat SIMPLE_DATE_FORMAT=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	Date fInicial, fFinal;
    	try{
    		fInicial=SIMPLE_DATE_FORMAT.parse(fechaInicial);
    	}catch(Exception e){
    		fInicial=SIMPLE_DATE_FORMAT.parse("1900-01-01 00:00");
    	}
    	try{
    		fFinal=SIMPLE_DATE_FORMAT.parse(fechaFinal);
    	}catch(Exception e){
    		fFinal=SIMPLE_DATE_FORMAT.parse("2050-12-31 23:59");
    	}

        
        this.addHeadersEstadisticosGenero((Object)sheet1,fInicial,fFinal,tipor,correo,id,audi,styleC);
        this.generateTableRecordsEstadisticosGeneroCat((Object)sheet1, audi,styleCc);
        for (int columnNumber = 0; columnNumber <= 5; ++columnNumber) {
            sheet1.autoSizeColumn(columnNumber);
        }
        
        return wb;
    }
    
    private void addHeadersEstadisticosGenero(Object element, Date ini , Date fin, String tipor, String correo, String id, List<auditoriaP> audi, CellStyle sty) {
        if (element instanceof Sheet) {
        	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        	
            Row headerRow = ((Sheet)element).createRow(0);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Filtros Utilizados"));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
            headerRow.getCell(0).setCellStyle(sty);
            
            if(tipor.equalsIgnoreCase("1")){
	            headerRow = ((Sheet)element).createRow(1);
	            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Tipo de recurso: Solicitante"));
	            ((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 5));
            }else if(tipor.equalsIgnoreCase("2")){
                headerRow = ((Sheet)element).createRow(1);
                headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Tipo de recurso: Permisos"));
                ((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 5));
            }else if(tipor.equalsIgnoreCase("3")){
                headerRow = ((Sheet)element).createRow(1);
                headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Tipo de recurso: Docencias"));
                ((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 5));
            }else if(tipor.equalsIgnoreCase("4")){
                headerRow = ((Sheet)element).createRow(1);
                headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Tipo de recurso: Usuario"));
                ((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 5));
            }else if(tipor.equalsIgnoreCase("0") || tipor==null){
                headerRow = ((Sheet)element).createRow(1);
                headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Tipo de recurso: Todos"));
                ((Sheet) element).addMergedRegion(new CellRangeAddress(1, 1, 0, 5));
            }
            String fi ="";
            String ff="";
            if(!formato.format(ini).equals("1900-01-01")){
            	fi=formato.format(ini);
            }
            if(!formato.format(fin).equals("2050-12-31")){
            	ff=formato.format(fin);
            }
            headerRow = ((Sheet)element).createRow(2);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Fecha Inicio: "+fi));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(2, 2, 0, 5));
            
            headerRow = ((Sheet)element).createRow(3);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Fecha Final: "+ff));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(3, 3, 0, 5));
            
            headerRow = ((Sheet)element).createRow(4);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Código del recurso/Cédula del usuario asociado al Permiso o Docencia: "+id));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(4, 4, 0, 5));
            
            headerRow = ((Sheet)element).createRow(5);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Correo del registrador: "+correo));
            ((Sheet) element).addMergedRegion(new CellRangeAddress(5, 5, 0, 5));
            
        }
    }
    
    private void generateTableRecordsEstadisticosGeneroCat(Object element, List<auditoriaP> audi, CellStyle sty) {
        if (element instanceof Sheet) {
        	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        	
        	int i = 0;
        	
            Sheet sheet = (Sheet)element;
            
            Row headerRow = ((Sheet)element).createRow(6);
            headerRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Tipo Recurso"));
            headerRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString("Fecha"));
            headerRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString("Código del Recurso"));
            headerRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString("Acción"));
            headerRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString("Modificado por"));
            headerRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString("Modificacion"));
            headerRow.getCell(0).setCellStyle(sty);
            headerRow.getCell(1).setCellStyle(sty);
            headerRow.getCell(2).setCellStyle(sty);
            headerRow.getCell(3).setCellStyle(sty);
            headerRow.getCell(4).setCellStyle(sty);
            headerRow.getCell(5).setCellStyle(sty);
            
            for (auditoriaP a : audi) {
                Row contentRow = sheet.createRow(i + 7);
                
                if(a.getTipo_recurso()==1){
                	contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Solicitante"));
                }else if(a.getTipo_recurso()==2){
                	contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Permisos"));
                }else if(a.getTipo_recurso()==3){
                	contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Docencias"));
                }else if(a.getTipo_recurso()==4){
                	contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString("Usuario"));
                }
                
                contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString(formato.format(a.getFecha())));
                contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString(a.getId_recurso_modificado()));
                contentRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString(a.getTipo_operacion()));
                contentRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString(a.getCorreo()));
                contentRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString(a.getModificacion()));
                contentRow.getCell(0).setCellStyle(sty);
                contentRow.getCell(1).setCellStyle(sty);
                contentRow.getCell(2).setCellStyle(sty);
                contentRow.getCell(3).setCellStyle(sty);
                contentRow.getCell(4).setCellStyle(sty);
                contentRow.getCell(5).setCellStyle(sty);
                i++;
            }
        }
    }
    
    public Workbook exportPermissionsToExcelAdmin(List<licencia_permiso> permisos2,String dep,String mun,String desp,String email,String fi, String ff) {
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Permisos");
        this.addHeaders((Object)sheet);
        this.generateTableRecordsAdmin((Object)sheet, permisos2,dep,mun,desp,email,fi,ff);
        for (int columnNumber = 0; columnNumber <= 21; ++columnNumber) {
            sheet.autoSizeColumn(columnNumber);
        }
        return wb;
    }
    
    private void generateTableRecordsAdmin(Object element, List<licencia_permiso> permisos2,String dep,String mun,String desp,String email,String fi, String ff) {
        if (element instanceof Sheet) {
            Sheet sheet = (Sheet)element;
            
            String sql = 	"SELECT permisos.id,permisos.acto_admin,usu.nombre+' '+usu.apellido nombre,usu.cedula_id,carg.descripcion,tipo.Descripcion,permisos.fecha_inicio,permisos.fecha_fin,  "+
	                		"year(permisos.fecha_inicio) anhio,month(permisos.fecha_inicio) mes,datepart(dw,permisos.fecha_inicio) dia,datepart(quarter,permisos.fecha_inicio) trimestre, "+
	                		"depa.nombre departemento,dist.nombre distrito,muni.nombre municipio,desp.nombre despacho,d.dependencia entidad,e.especialidad especialidad,usuario.emailAddress registro, "+
	                		"permisos.horas_permiso horas, permisos.estatus, permisos.minutos_permiso minutos "+
	                		"from SJ_licencia_permiso permisos "+
	                		"join SJ_tipo tipo on (tipo.ID = permisos.tipo_fk)  "+
	                		"left join "+BDPortal+".dbo.User_ usuario on (usuario.userId=permisos.created_by)  "+
	                		"join DESPACHO_PRU.dbo.ADM_LOCALIZACION depa on (depa.cod_dane = SUBSTRING(permisos.despacho_fk, 1, 2) )  "+
	                		"join DESPACHO_PRU.dbo.ADM_LOCALIZACION muni on (muni.cod_dane_departamento = SUBSTRING(permisos.despacho_fk, 1, 2)and muni.cod_dane = SUBSTRING(permisos.despacho_fk, 3, 3))  "+
	                		"join SJ_usuario usu on (usu.cedula_id=permisos.usuario_fk)  "+
	                		"join SJ_cargo carg on (carg.id=permisos.cargo_fk)  "+
	                		"join DESPACHO_PRU.dbo.fun_despacho_info desp on (permisos.despacho_fk=desp.CODIGO)  "+
	                		"join DESPACHO_PRU.dbo.ADM_ENTIDAD ent on (SUBSTRING(desp.CODIGO,6,2)=ent.CODIGO)  "+
	                		"join DESPACHO_PRU.dbo.ADM_ESPECIALIDAD esp on (SUBSTRING(desp.CODIGO,8,2)=esp.CODIGO)  "+
	                		"join DESPACHO_PRU.dbo.ADM_JURISDICCION jur on (jur.ID=ent.FK_ENTIDAD_TO_JURIDICCION)  "+
	                		"left join DESPACHO_PRU.dbo.ADM_MAPA_JUDICIAL mj on (mj.FK_DANEDEPAR_TO_MAPA=depa.cod_dane and mj.FK_DANEMUNI_TO_MAPA=muni.COD_DANE and mj.FK_JURIDICCION_TO_MAPA=jur.ID)  "+
	                		"left join DESPACHO_PRU.dbo.ADM_CIRCUITO circuito on (circuito.ID=mj.FK_CIRCUITO_TO_MAPA)  "+
	                		"left join DESPACHO_PRU.dbo.ADM_DISTRITO dist on (dist.ID=circuito.FK_DISTRITO_TO_CIRCUITO)  "+
	                		"left join DESPACHO_PRU.dbo.SJ_despacho_dependencia_especialidad dde on (permisos.despacho_fk = dde.codigo_despacho) "+
	                		"left join DESPACHO_PRU.dbo.SJ_dependencia d on (dde.id_dependencia = d.id) "+
	                		"left join DESPACHO_PRU.dbo.SJ_especialidad e on (dde.id_especialidad = e.id) "+
	                		"where permisos.estatus != 2 ";
            if (dep != null && !dep.equals("")) {
            	sql = String.valueOf(sql) + " AND SUBSTRING(permisos.despacho_fk, 1, 2) = '" + dep + "'";
            }
            if (mun != null && !mun.equals("")) {
            	sql = String.valueOf(sql) + " AND SUBSTRING(permisos.despacho_fk, 3, 3) = '" + mun + "'";
            }
            if (desp != null && !desp.equals("")) {
            	sql = String.valueOf(sql) + " AND permisos.despacho_fk = '" + desp + "'";
            }
            if (email != null && !email.equals("")) {
            	sql = String.valueOf(sql) + " AND usuario.emailAddress = '" + email + "'";
            }
            if(fi != "" && ff != "")
    		{
            	sql += " AND ( CONVERT(date, fecha_inicio, 23) >= CONVERT(date, '"+fi+"', 23) "+
    					" AND CONVERT(date, fecha_inicio, 23) <= CONVERT(date, '"+ff+"', 23) ) ";
    			
            	sql += " OR ( CONVERT(date, fecha_fin, 23) >= CONVERT(date, '"+fi+"', 23) "+
    					" AND CONVERT(date, fecha_fin, 23) <= CONVERT(date, '"+ff+"', 23) ) ";
    		}
                try {
                	int i =0;
                	ResultSet result = PersistenceUtil.realizaConsulta((String)sql, (boolean)false);
                	if (result != null) {
                		
                        while (result.next()) {
                        	Row contentRow = sheet.createRow(i + 1);
                            contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString(result.getString(1)));
							contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString(result.getString(2)));
							contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString(result.getString(3)));
							contentRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString(result.getString(4)));
							contentRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString(result.getString(5)));
							contentRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString(result.getString(6)));
							String horas = "0";
							String minutos = "0";
							if(result.getString(20) != null )
								horas = result.getString(20);
							if(result.getString(22)!=null )
								minutos = result.getString(22);
							contentRow.createCell(6).setCellValue((RichTextString)new HSSFRichTextString(horas+" horas y "+minutos+" minutos"));
							Date inicio = formato.parse(result.getString(7));
							Date fin = formato.parse(result.getString(8));
							contentRow.createCell(7).setCellValue((RichTextString)new HSSFRichTextString(formato1.format(inicio)));
							contentRow.createCell(8).setCellValue((RichTextString)new HSSFRichTextString(formato1.format(fin)));
							
							contentRow.createCell(9).setCellValue((RichTextString)new HSSFRichTextString(String.valueOf(diasHabiles(inicio, fin))));
							contentRow.createCell(10).setCellValue((RichTextString)new HSSFRichTextString(result.getString(9)));
							contentRow.createCell(11).setCellValue((RichTextString)new HSSFRichTextString(meses[result.getInt(10)-1]));
							contentRow.createCell(12).setCellValue((RichTextString)new HSSFRichTextString(dias[result.getInt(11)-1]));
							contentRow.createCell(13).setCellValue((RichTextString)new HSSFRichTextString(trimestres[result.getInt(12)-1]));
							contentRow.createCell(14).setCellValue((RichTextString)new HSSFRichTextString(result.getString(13)));
							String distrito = "";
							if(result.getString(14)==null || result.getString(14).isEmpty())
								distrito = "Distrito no encontrado";
							else
								distrito = result.getString(14);
							contentRow.createCell(15).setCellValue((RichTextString)new HSSFRichTextString(distrito));
							contentRow.createCell(16).setCellValue((RichTextString)new HSSFRichTextString(result.getString(15)));
							contentRow.createCell(17).setCellValue((RichTextString)new HSSFRichTextString(result.getString(16)));
							contentRow.createCell(18).setCellValue((RichTextString)new HSSFRichTextString(result.getString(17)));
							contentRow.createCell(19).setCellValue((RichTextString)new HSSFRichTextString(result.getString(18)));
							String registro = "";
							if(result.getString(19)==null || result.getString(19).isEmpty())
								registro = "Usuario eliminado del portal";
							else
								registro = result.getString(19);
							contentRow.createCell(20).setCellValue((RichTextString)new HSSFRichTextString(registro));
							if (result.getInt(21) == 0) {
			                    contentRow.createCell(21).setCellValue((RichTextString)new HSSFRichTextString("Permiso Cancelado"));
			                }else{
			                contentRow.createCell(21).setCellValue((RichTextString)new HSSFRichTextString(" "));
			                }
							i++;
                        }
                    }
                	
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
            
        }
    }

    public Workbook exportDocentesToExcelAdmin(List<Docencia> permisosDocencia,String dep,String mun,String desp,String email,String fi, String ff) throws ParseException {
        HSSFWorkbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Permisos");
        this.addHeadersDocencia((Object)sheet);
        this.generateTableRecordsDocenciaAdmin((Object)sheet, permisosDocencia,dep,mun,desp,email,fi,ff);
        for (int columnNumber = 0; columnNumber <= 14; ++columnNumber) {
            sheet.autoSizeColumn(columnNumber);
        }
        return wb;
    }

    private void generateTableRecordsDocenciaAdmin(Object element, List<Docencia> permisos2,String dep,String mun,String desp,String email,String fi, String ff) throws ParseException {
        if (element instanceof Sheet) {
            Sheet sheet = (Sheet)element;
            
            String sql = 	"select "+
							"docencia.id,usu.nombre+' '+usu.apellido,usu.cedula_id,carg.descripcion,docencia.materia,docencia.horas_docencia,docencia.institucion, "+
							"docencia.fecha_inicial,docencia.fecha_final,depa.NOMBRE,dist.NOMBRE,muni.NOMBRE,docencia.despacho_fk,desp.NOMBRE,usuario.emailAddress,docencia.minutos_docencia "+
							"from SJ_DOCENCIA docencia "+
							"left join "+BDPortal+".dbo.User_ usuario on (usuario.userId=docencia.created_by) "+
							"join DESPACHO_PRU.dbo.ADM_LOCALIZACION depa on (depa.cod_dane = SUBSTRING(docencia.despacho_fk, 1, 2) ) "+
							"join DESPACHO_PRU.dbo.ADM_LOCALIZACION muni on (muni.cod_dane_departamento = SUBSTRING(docencia.despacho_fk, 1, 2)and muni.cod_dane = SUBSTRING(docencia.despacho_fk, 3, 3)) "+
							"join SJ_usuario usu on (usu.cedula_id=docencia.usuario_fk) "+
							"join SJ_cargo carg on (carg.id=docencia.cargo_fk) "+
							"join DESPACHO_PRU.dbo.fun_despacho_info desp on (docencia.despacho_fk=desp.CODIGO) "+
							"join DESPACHO_PRU.dbo.ADM_ENTIDAD ent on (SUBSTRING(desp.CODIGO,6,2)=ent.CODIGO) "+
							"join DESPACHO_PRU.dbo.ADM_JURISDICCION jur on (jur.ID=ent.FK_ENTIDAD_TO_JURIDICCION) "+
							"join DESPACHO_PRU.dbo.ADM_MAPA_JUDICIAL mj on (mj.FK_DANEDEPAR_TO_MAPA=depa.cod_dane and mj.FK_DANEMUNI_TO_MAPA=muni.COD_DANE and mj.FK_JURIDICCION_TO_MAPA=jur.ID) "+
							"join DESPACHO_PRU.dbo.ADM_CIRCUITO circuito on (circuito.ID=mj.FK_CIRCUITO_TO_MAPA) "+
							"join DESPACHO_PRU.dbo.ADM_DISTRITO dist on (dist.ID=circuito.FK_DISTRITO_TO_CIRCUITO) "+
							"where docencia.estatus = 1 ";
            if (dep != null && !dep.equals("")) {
            	sql = String.valueOf(sql) + " AND SUBSTRING(docencia.despacho_fk, 1, 2) = '" + dep + "'";
            }
            if (mun != null && !mun.equals("")) {
            	sql = String.valueOf(sql) + " AND SUBSTRING(docencia.despacho_fk, 3, 3) = '" + mun + "'";
            }
            if (desp != null && !desp.equals("")) {
            	sql = String.valueOf(sql) + " AND docencia.despacho_fk = '" + desp + "'";
            }
            if (email != null && !email.equals("")) {
            	sql = String.valueOf(sql) + " AND usuario.emailAddress = '" + email + "'";
            }
            if(fi != "" && ff != "")
    		{
            	sql += " AND ( CONVERT(date, fecha_inicial, 23) >= CONVERT(date, '"+fi+"', 23) "+
    					" AND CONVERT(date, fecha_inicial, 23) <= CONVERT(date, '"+ff+"', 23) ) ";
    			
            	sql += " OR ( CONVERT(date, fecha_final, 23) >= CONVERT(date, '"+fi+"', 23) "+
    					" AND CONVERT(date, fecha_final, 23) <= CONVERT(date, '"+ff+"', 23) ) ";
    		}    
                try {
                	int i= 0;
					ResultSet result = PersistenceUtil.realizaConsulta((String)sql, (boolean)false);
					if (result != null) {
                		
                        while (result.next()) {
                        	Row contentRow = sheet.createRow(i + 1);
                            contentRow.createCell(0).setCellValue((RichTextString)new HSSFRichTextString(result.getString(1)));
							contentRow.createCell(1).setCellValue((RichTextString)new HSSFRichTextString(result.getString(2)));
							contentRow.createCell(2).setCellValue((RichTextString)new HSSFRichTextString(result.getString(3)));
							contentRow.createCell(3).setCellValue((RichTextString)new HSSFRichTextString(result.getString(4)));
							contentRow.createCell(4).setCellValue((RichTextString)new HSSFRichTextString(result.getString(5)));
							String horas = "0";
							String minutos = "0";
							if(result.getString(6) != null )
								horas = result.getString(6);
							if(result.getString(16)!=null )
								minutos = result.getString(16);
							contentRow.createCell(5).setCellValue((RichTextString)new HSSFRichTextString(horas+" horas y "+minutos+" minutos"));
							contentRow.createCell(6).setCellValue((RichTextString)new HSSFRichTextString(result.getString(7)));
							Date inicio = formato.parse(result.getString(8));
							Date fin = formato.parse(result.getString(9));
							contentRow.createCell(7).setCellValue((RichTextString)new HSSFRichTextString(formato1.format(inicio)));
							contentRow.createCell(8).setCellValue((RichTextString)new HSSFRichTextString(formato1.format(fin)));
							contentRow.createCell(9).setCellValue((RichTextString)new HSSFRichTextString(result.getString(10)));
							contentRow.createCell(10).setCellValue((RichTextString)new HSSFRichTextString(result.getString(11)));
							contentRow.createCell(11).setCellValue((RichTextString)new HSSFRichTextString(result.getString(12)));
							contentRow.createCell(12).setCellValue((RichTextString)new HSSFRichTextString(result.getString(13)));
							contentRow.createCell(13).setCellValue((RichTextString)new HSSFRichTextString(result.getString(14)));
							String registro = "";
							if(result.getString(15)==null || result.getString(15).isEmpty())
								registro = "Usuario eliminado del portal";
							else
								registro = result.getString(15);
							contentRow.createCell(14).setCellValue((RichTextString)new HSSFRichTextString(registro));
							i++;
                        }
                    }
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
        }
    }

}