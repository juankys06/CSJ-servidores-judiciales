package co.com.csj;


import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

import co.com.csj.model.Docencia;
import co.com.csj.model.auditoriaP;
import co.com.csj.model.licencia_permiso;
import co.com.csj.model.usuario;
import co.com.csj.modelos.consultas;
import co.com.csj.service.DocenciaLocalServiceUtil;
import co.com.csj.service.auditoriaPLocalServiceUtil;
import co.com.csj.service.licencia_permisoLocalServiceUtil;
import co.com.csj.service.tipoLocalServiceUtil;
import co.com.csj.service.usuarioLocalServiceUtil;

public final class decoArchivo {
	
    private static DateFormat formatoS = new SimpleDateFormat("dd/MM/yyyy");
	
	public static List<String> readExcelP(InputStream archivo,String despacho,String usuarioAgrego) throws IOException, NumberFormatException, PortalException, SystemException{
		XSSFWorkbook wb = new XSSFWorkbook(archivo);
		boolean correcto = true;
		List<String> errores = new ArrayList<String>();
        XSSFSheet sheet = wb.getSheetAt(0);
        
        int rows = sheet.getLastRowNum();
        System.out.println(rows);
        //Validacion del archivo
        for (int i = 1; i <= rows; ++i) {
        	boolean huboError = false;
        	System.out.println("Linea "+(i+1));
        	String erroresEncontrados = "Linea "+(i+1)+":";
            XSSFRow row = sheet.getRow(i);

            XSSFCell nombreCell = row.getCell(0);
            XSSFCell apellidoCell = row.getCell(1);
            XSSFCell tipoDocumentoCell = row.getCell(2);
            XSSFCell numeroDocumentoCell = row.getCell(3);
            XSSFCell cargoCell = row.getCell(4);
            XSSFCell tipoPermisoCell = row.getCell(5);
            XSSFCell desdeCell = row.getCell(6);
            XSSFCell hastaCell = row.getCell(7);
            XSSFCell actoAdministrativoCell = row.getCell(8);
            XSSFCell horasCell = row.getCell(9);
            XSSFCell minutosCell = row.getCell(10);

            String nombre = "";
            String apellido = "";
            String tipoDocumento = "";
            String numeroDocumento = "";
            String cargo = "";
            String tipoPermiso = "";
            Date desde = null;
            Date hasta = null;
            String actoAdministrativo = "";
            int horas = 0;
            int minutos = 0;
            
            try{
            	nombre = nombreCell.getStringCellValue();
            }catch (Exception e) {}
            try{
	        	apellido = apellidoCell.getStringCellValue();
        	}catch (Exception e) {}
            try{
	        	tipoDocumento = tipoDocumentoCell.getStringCellValue();
			}catch (Exception e) {}
            try{
	        	numeroDocumento = String.valueOf( (int)numeroDocumentoCell.getNumericCellValue() );
            }catch (Exception e) {}
	        try{
	        	cargo = cargoCell.getStringCellValue();
	        }catch (Exception e) {}
	        try{
	        	tipoPermiso = tipoPermisoCell.getStringCellValue();
	       	}catch (Exception e) {}
	       	try{
	        	desde = desdeCell.getDateCellValue();
	       	}catch (Exception e) {}
	       	try{
            	hasta = hastaCell.getDateCellValue();
	       	}catch (Exception e) {}
           	try{
	        	actoAdministrativo = actoAdministrativoCell.getStringCellValue();
           	}catch (Exception e) {}
	       	try{
	        	horas = (int) horasCell.getNumericCellValue();
	       	}catch (Exception e) {}
	       	try{
	        	minutos = (int) minutosCell.getNumericCellValue();
        	}catch (Exception e) {}
            if(nombre.isEmpty()){
            	erroresEncontrados+=" El nombre no puede ser vacio,";
            	correcto = false;
            	huboError = true;
            }
            if(apellido.isEmpty()){
            	erroresEncontrados+=" El apellido no puede ser vacio,";
            	correcto = false;
            	huboError = true;
            }
            if(tipoDocumento.isEmpty()){
            	erroresEncontrados+=" El tipo de documento no puede ser vacio,";
            	correcto = false;
            	huboError = true;
            }
            if(numeroDocumento.isEmpty()){
            	erroresEncontrados+=" El numero de documento no puede ser vacio,";
            	correcto = false;
            	huboError = true;
            }
            if(cargo.isEmpty()){
            	erroresEncontrados+=" El cargo no puede ser vacio,";
            	correcto = false;
            	huboError = true;
            }
            if(tipoPermiso.isEmpty()){
            	erroresEncontrados+=" El tipo de permiso no puede ser vacio,";
            	correcto = false;
            	huboError = true;
            }
            if(desde == null){
            	erroresEncontrados+=" La fecha de inicio no puede ser vacia,";
            	correcto = false;
            	huboError = true;
            }
            if(hasta == null){
            	erroresEncontrados+=" La fecha de fin no puede ser vacia,";
            	correcto = false;
            	huboError = true;
            }
            if(desde != null && hasta != null)
	            if(hasta.before(desde)){
	            	erroresEncontrados+=" La fecha de inicio no puede ser menor a la fecha de fin";
	            	correcto = false;
	            	huboError = true;
	            }
            if(huboError){
            	errores.add(erroresEncontrados);
            }            
            
        }
        if(correcto){
        	for (int i = 1; i <= rows; ++i) {
        		XSSFRow row = sheet.getRow(i);

                XSSFCell nombreCell = row.getCell(0);
                XSSFCell apellidoCell = row.getCell(1);
                XSSFCell tipoDocumentoCell = row.getCell(2);
                XSSFCell numeroDocumentoCell = row.getCell(3);
                XSSFCell cargoCell = row.getCell(4);
                XSSFCell tipoPermisoCell = row.getCell(5);
                XSSFCell desdeCell = row.getCell(6);
                XSSFCell hastaCell = row.getCell(7);
                XSSFCell actoAdministrativoCell = row.getCell(8);
                XSSFCell horasCell = row.getCell(9);
                XSSFCell minutosCell = row.getCell(10);

                String nombre = "";
                String apellido = "";
                String tipoDocumento = "";
                String numeroDocumento = "";
                String cargo = "";
                String tipoPermiso = "";
                Date desde = null;
                Date hasta = null;
                String actoAdministrativo = "";
                int horas = 0;
                int minutos = 0;
                
                try{
                	nombre = nombreCell.getStringCellValue();
                }catch (Exception e) {}
                try{
    	        	apellido = apellidoCell.getStringCellValue();
            	}catch (Exception e) {}
                try{
    	        	tipoDocumento = tipoDocumentoCell.getStringCellValue();
    			}catch (Exception e) {}
                try{
    	        	numeroDocumento = String.valueOf( (int)numeroDocumentoCell.getNumericCellValue() );
                }catch (Exception e) {}
    	        try{
    	        	cargo = cargoCell.getStringCellValue();
    	        }catch (Exception e) {}
    	        try{
    	        	tipoPermiso = tipoPermisoCell.getStringCellValue();
    	       	}catch (Exception e) {}
    	       	try{
    	        	desde = desdeCell.getDateCellValue();
    	       	}catch (Exception e) {}
    	       	try{
                	hasta = hastaCell.getDateCellValue();
    	       	}catch (Exception e) {}
               	try{
    	        	actoAdministrativo = actoAdministrativoCell.getStringCellValue();
               	}catch (Exception e) {}
    	       	try{
    	        	horas = (int) horasCell.getNumericCellValue();
    	       	}catch (Exception e) {}
    	       	try{
    	        	minutos = (int) minutosCell.getNumericCellValue();
            	}catch (Exception e) {}
    	       	
    	       	try {
					usuario user = usuarioLocalServiceUtil.getusuario(numeroDocumento);
					if(!nombre.equalsIgnoreCase("") && !apellido.equalsIgnoreCase("") && !despacho.equalsIgnoreCase("") && !cargo.equalsIgnoreCase("")){
				        try {
				            String log = "";
				            if (!user.getNomb().equalsIgnoreCase(nombre)) {
				                log = String.valueOf(log) + "Se ha modificado el nombre del usuario de: " + user.getNomb() + " por: " + nombre;
				            }
				            if (!user.getApe().equalsIgnoreCase(apellido)) {
				                log = String.valueOf(log) + " Se ha modificado el apellido del usuario de: " + user.getApe() + " por: " + apellido;
				            }
				            if (!user.getDespachofk().equalsIgnoreCase(despacho)) {
				                log = String.valueOf(log) + " Se ha modificado el despacho del usuario de: " + consultas.obtenerNombreDespacho((String)user.getDespachofk()) + " con codigo: " + user.getDespachofk() + " por: " + consultas.obtenerNombreDespacho(despacho) + " con codigo: " + despacho;
				            }
				            if (user.getCargofk() != consultas.getCargoPorNombre(cargo)) {
				                log = String.valueOf(log) + " Se ha modificado el cargo del usuario de: " + consultas.getCargo((String)String.valueOf(user.getCargofk())) + " por: " + consultas.getCargo(String.valueOf(cargo));
				            }
				            if (log.length() > 1) {
				                user.setNomb(nombre);
				                user.setApe(apellido);
				                user.setCargofk(consultas.getCargoPorNombre(cargo));
				                user.setDespachofk(despacho);
				                user = usuarioLocalServiceUtil.updateusuario((usuario)user);
				                auditoriaP audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
				                audi.setFecha(new Date());
				                audi.setTipo_recurso(1);
				                audi.setTipo_operacion("MODIFICAR");
				                audi.setId_recurso_modificado(user.getId());
				                audi.setUsuario_modifico(usuarioAgrego);
				                audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(usuarioAgrego)).getEmailAddress());
				                audi.setModificacion(log);
				                auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
				            }
				        }
				        catch (SystemException e) {
				            System.err.println("Error al guardar el permiso: " + e.getMessage());
				        }
				        try {
				            licencia_permiso lp = licencia_permisoLocalServiceUtil.createlicencia_permiso(0L);
				            lp.setTipofk((long)consultas.getTipoPermisoPorNombre(tipoPermiso));
				            lp.setFechainicio(desde);
				            lp.setFechafin(hasta);
				            lp.setActoadmin(actoAdministrativo);
				            lp.setHoras(horas);
				            lp.setMinutos(minutos);
				            lp.setCreadoPor(Long.parseLong(usuarioAgrego));
				            lp.setModificadoPor(Long.parseLong(usuarioAgrego));
				            lp.setEstatus(1);
				            lp.setUsuariofk(user.getId());
				            lp.setDespacho(user.getDespachofk());
				            lp.setCargo((int)user.getCargofk());
				            licencia_permisoLocalServiceUtil.addlicencia_permiso((licencia_permiso)lp);
				            auditoriaP audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
				            audi.setFecha(new Date());
				            audi.setTipo_recurso(2);
				            audi.setTipo_operacion("AGREGAR");
				            audi.setId_recurso_modificado(String.valueOf(lp.getId()));
				            audi.setUsuario_modifico(usuarioAgrego);
				            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(usuarioAgrego)).getEmailAddress());
				            String log = "";
				            log = String.valueOf(log) + "Ser creo un permiso con los siguientes datos. ";
				            log = String.valueOf(log) + " ID:" + lp.getId();
				            log = String.valueOf(log) + " tipo de permiso:" + tipoPermiso;
				            log = String.valueOf(log) + " acto administrativo:" + actoAdministrativo;
				            log = String.valueOf(log) + " fecha inicio:" + formatoS.format(desde);
				            log = String.valueOf(log) + " fecha fin:" + formatoS.format(hasta);
				            log = String.valueOf(log) + " horas laborales:" + horas;
				            log = String.valueOf(log) + " minutos laborales:" + minutos;
				            log = String.valueOf(log) + " Asociado al usuario con ";
				            if (user.getTipo_doc() == 0L) {
				                log = String.valueOf(log) + "tipo de documento: Pasaporte";
				            }
				            if (user.getTipo_doc() == 1L) {
				                log = String.valueOf(log) + "tipo de documento: C\u00e9dula de Ciudadan\u00eda";
				            }
				            log = String.valueOf(log) + " de numero: " + user.getId();
				            audi.setModificacion(log);
				            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
				        }
					
				        catch (SystemException e) {
				            System.err.println("Error al guardar el permiso: " + e.getMessage());
				        }
					}
				} catch (PortalException e) {
					if(!numeroDocumento.equalsIgnoreCase("") && !nombre.equalsIgnoreCase("") && !apellido.equalsIgnoreCase("") && !despacho.equals("") && consultas.getCargoPorNombre(cargo) !=0 ){
				    	
				        auditoriaP audi;
				        String log;
				        
			            usuario uso = usuarioLocalServiceUtil.createusuario(numeroDocumento);
			            uso.setNomb(nombre);
			            uso.setApe(apellido);
			            uso.setCargofk((long)consultas.getCargoPorNombre(cargo));
			            uso.setDespachofk(despacho);
			            uso.setTipo_doc((long)consultas.getTipoDocumentoPorNombre(tipoDocumento));
			            uso = usuarioLocalServiceUtil.addusuario((usuario)uso);
			            audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
			            audi.setFecha(new Date());
			            audi.setTipo_recurso(1);
			            audi.setTipo_operacion("AGREGAR");
			            audi.setId_recurso_modificado(numeroDocumento);
			            audi.setUsuario_modifico(usuarioAgrego);
			            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(usuarioAgrego)).getEmailAddress());
			            log = "";
			            if ((long)consultas.getTipoDocumentoPorNombre(tipoDocumento) == 0L) {
			                log = String.valueOf(log) + "Se creo un usuario con tipo de documento: Pasaporte";
			            }
			            if ((long)consultas.getTipoDocumentoPorNombre(tipoDocumento) == 1L) {
			                log = String.valueOf(log) + "Se creo un usuario con tipo de documento: C\u00e9dula de Ciudadan\u00eda";
			            }
			            log = String.valueOf(log) + " Con el numero: " + numeroDocumento;
			            log = String.valueOf(log) + " Con el nombre: " + nombre;
			            log = String.valueOf(log) + " Con el apellido: " + apellido;
			            log = String.valueOf(log) + " agregado al despacho: " + consultas.obtenerNombreDespacho(despacho);
			            log = String.valueOf(log) + " con el codigo: " + despacho;
			            log = String.valueOf(log) + " y con el cargo de: " + cargo;
			            audi.setModificacion(log);
			            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
				        
				        try {
				            licencia_permiso lp = licencia_permisoLocalServiceUtil.createlicencia_permiso(0L);
				            lp.setUsuariofk(numeroDocumento);
				            lp.setTipofk((long)consultas.getTipoPermisoPorNombre(tipoPermiso));
				            lp.setFechainicio(desde);
				            lp.setFechafin(hasta);
				            lp.setActoadmin(actoAdministrativo);
				            lp.setHoras(horas);
				            lp.setMinutos(minutos);
				            lp.setCreadoPor(Long.parseLong(usuarioAgrego));
				            lp.setModificadoPor(Long.parseLong(usuarioAgrego));
				            lp.setDespacho(despacho);
				            lp.setEstatus(1);
				            lp.setCargo(consultas.getCargoPorNombre(cargo));
				            lp = licencia_permisoLocalServiceUtil.addlicencia_permiso((licencia_permiso)lp);
				            audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
				            audi.setFecha(new Date());
				            audi.setTipo_recurso(2);
				            audi.setTipo_operacion("AGREGAR");
				            audi.setId_recurso_modificado(String.valueOf(lp.getId()));
				            audi.setUsuario_modifico(usuarioAgrego);
				            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(usuarioAgrego)).getEmailAddress());
				            log = "";
				            log = String.valueOf(log) + "Ser creo un permiso con los siguientes datos. ";
				            log = String.valueOf(log) + " ID:" + lp.getId();
				            log = String.valueOf(log) + " tipo de permiso:" + tipoPermiso;
				            log = String.valueOf(log) + " acto administrativo:" + actoAdministrativo;
				            log = String.valueOf(log) + " fecha inicio:" + formatoS.format(desde);
				            log = String.valueOf(log) + " fecha fin:" + formatoS.format(hasta);
				            log = String.valueOf(log) + " horas laborales:" + horas;
				            log = String.valueOf(log) + " minutos laborales:" + minutos;
				            log = String.valueOf(log) + " Asociado al usuario con ";
				            if (consultas.getTipoDocumentoPorNombre(tipoDocumento) == 0L) {
				                log = String.valueOf(log) + "tipo de documento: Pasaporte";
				            }
				            if (consultas.getTipoDocumentoPorNombre(tipoDocumento) == 1L) {
				                log = String.valueOf(log) + "tipo de documento: C\u00e9dula de Ciudadan\u00eda";
				            }
				            log = String.valueOf(log) + " de numero: " + numeroDocumento;
				            audi.setModificacion(log);
				            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
				        }
				        catch (SystemException ee) {
				        } catch (NumberFormatException ee) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (PortalException ee) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	}
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
        return errores;
	}
	
	public static List<String> readExcelD(InputStream archivo,String despacho,String usuarioAgrego) throws IOException, NumberFormatException, PortalException, SystemException{
		XSSFWorkbook wb = new XSSFWorkbook(archivo);
		boolean correcto = true;
		List<String> errores = new ArrayList<String>();
        XSSFSheet sheet = wb.getSheetAt(1);
        
        int rows = sheet.getLastRowNum();
        //Validacion del archivo
        for (int i = 1; i <= rows; ++i) {
        	boolean huboError = false;
        	String erroresEncontrados = "Linea "+(i+1)+":";
            XSSFRow row = sheet.getRow(i);

            XSSFCell nombreCell = row.getCell(0);
            XSSFCell apellidoCell = row.getCell(1);
            XSSFCell tipoDocumentoCell = row.getCell(2);
            XSSFCell numeroDocumentoCell = row.getCell(3);
            XSSFCell cargoCell = row.getCell(4);
            XSSFCell desdeCell = row.getCell(5);
            XSSFCell hastaCell = row.getCell(6);
            XSSFCell horasCell = row.getCell(7);
            XSSFCell minutosCell = row.getCell(8);
            XSSFCell materiaCell = row.getCell(9);
            XSSFCell institucionCell = row.getCell(10);

            String nombre = "";
            String apellido = "";
            String tipoDocumento = "";
            String numeroDocumento = "";
            String cargo = "";
            Date desde = null;
            Date hasta = null;
            int horas = 0;
            int minutos = 0;
            String materia = "";
            String institucion = "";
            
            try{
            	nombre = nombreCell.getStringCellValue();
            }catch (Exception e) {}
            try{
	        	apellido = apellidoCell.getStringCellValue();
        	}catch (Exception e) {}
            try{
	        	tipoDocumento = tipoDocumentoCell.getStringCellValue();
			}catch (Exception e) {}
            try{
	        	numeroDocumento = String.valueOf( (int)numeroDocumentoCell.getNumericCellValue() );
            }catch (Exception e) {}
	        try{
	        	cargo = cargoCell.getStringCellValue();
	        }catch (Exception e) {}
	       	try{
	        	desde = desdeCell.getDateCellValue();
	       	}catch (Exception e) {}
	       	try{
            	hasta = hastaCell.getDateCellValue();
	       	}catch (Exception e) {}
	       	try{
	        	horas = (int) horasCell.getNumericCellValue();
	       	}catch (Exception e) {}
	       	try{
	        	minutos = (int) minutosCell.getNumericCellValue();
        	}catch (Exception e) {}
	       	try{
	        	materia = materiaCell.getStringCellValue();
	        }catch (Exception e) {}
	       	try{
	        	institucion = institucionCell.getStringCellValue();
	        }catch (Exception e) {}
	       	
            if(nombre.isEmpty()){
            	erroresEncontrados+=" El nombre no puede ser vacio,";
            	correcto = false;
            	huboError = true;
            }
            if(apellido.isEmpty()){
            	erroresEncontrados+=" El apellido no puede ser vacio,";
            	correcto = false;
            	huboError = true;
            }
            if(tipoDocumento.isEmpty()){
            	erroresEncontrados+=" El tipo de documento no puede ser vacio,";
            	correcto = false;
            	huboError = true;
            }
            if(numeroDocumento.isEmpty()){
            	erroresEncontrados+=" El numero de documento no puede ser vacio,";
            	correcto = false;
            	huboError = true;
            }
            if(cargo.isEmpty()){
            	erroresEncontrados+=" El cargo no puede ser vacio,";
            	correcto = false;
            	huboError = true;
            }
            if(desde == null){
            	erroresEncontrados+=" La fecha de inicio no puede ser vacia,";
            	correcto = false;
            	huboError = true;
            }
            if(hasta == null){
            	erroresEncontrados+=" La fecha de fin no puede ser vacia,";
            	correcto = false;
            	huboError = true;
            }
            if(desde != null && hasta != null)
	            if(hasta.before(desde)){
	            	erroresEncontrados+=" La fecha de inicio no puede ser menor a la fecha de fin";
	            	correcto = false;
	            	huboError = true;
	            }
            if(materia.isEmpty()){
            	erroresEncontrados+=" La materia o tema de investigacion no puede ser vacio,";
            	correcto = false;
            	huboError = true;
            }
            if(institucion.isEmpty()){
            	erroresEncontrados+=" La institucion no puede ser vacia,";
            	correcto = false;
            	huboError = true;
            }
            if(huboError){
            	errores.add(erroresEncontrados);
            }            
            
        }
        if(correcto){
        	for (int i = 1; i <= rows; ++i) {
        		XSSFRow row = sheet.getRow(i);

                XSSFCell nombreCell = row.getCell(0);
                XSSFCell apellidoCell = row.getCell(1);
                XSSFCell tipoDocumentoCell = row.getCell(2);
                XSSFCell numeroDocumentoCell = row.getCell(3);
                XSSFCell cargoCell = row.getCell(4);
                XSSFCell desdeCell = row.getCell(5);
                XSSFCell hastaCell = row.getCell(6);
                XSSFCell horasCell = row.getCell(7);
                XSSFCell minutosCell = row.getCell(8);
                XSSFCell materiaCell = row.getCell(9);
                XSSFCell institucionCell = row.getCell(10);

                String nombre = "";
                String apellido = "";
                String tipoDocumento = "";
                String numeroDocumento = "";
                String cargo = "";
                Date desde = null;
                Date hasta = null;
                int horas = 0;
                int minutos = 0;
                String materia = "";
                String institucion = "";
                
                try{
                	nombre = nombreCell.getStringCellValue();
                }catch (Exception e) {}
                try{
    	        	apellido = apellidoCell.getStringCellValue();
            	}catch (Exception e) {}
                try{
    	        	tipoDocumento = tipoDocumentoCell.getStringCellValue();
    			}catch (Exception e) {}
                try{
    	        	numeroDocumento = String.valueOf( (int)numeroDocumentoCell.getNumericCellValue() );
                }catch (Exception e) {}
    	        try{
    	        	cargo = cargoCell.getStringCellValue();
    	        }catch (Exception e) {}
    	       	try{
    	        	desde = desdeCell.getDateCellValue();
    	       	}catch (Exception e) {}
    	       	try{
                	hasta = hastaCell.getDateCellValue();
    	       	}catch (Exception e) {}
    	       	try{
    	        	horas = (int) horasCell.getNumericCellValue();
    	       	}catch (Exception e) {}
    	       	try{
    	        	minutos = (int) minutosCell.getNumericCellValue();
            	}catch (Exception e) {}
    	       	try{
    	        	materia = materiaCell.getStringCellValue();
    	        }catch (Exception e) {}
    	       	try{
    	        	institucion = institucionCell.getStringCellValue();
    	        }catch (Exception e) {}
    	       	
    	       	try {
					usuario user = usuarioLocalServiceUtil.getusuario(numeroDocumento);
					if(!nombre.equalsIgnoreCase("") && !apellido.equalsIgnoreCase("") && !despacho.equalsIgnoreCase("") && !cargo.equalsIgnoreCase("")){
						try {
				            String log = "";
				            if (!user.getNomb().equalsIgnoreCase(nombre)) {
				                log = String.valueOf(log) + "Se ha modificado el nombre del usuario de: " + user.getNomb() + " por: " + nombre;
				            }
				            if (!user.getApe().equalsIgnoreCase(apellido)) {
				                log = String.valueOf(log) + " Se ha modificado el apellido del usuario de: " + user.getApe() + " por: " + apellido;
				            }
				            if (!user.getDespachofk().equalsIgnoreCase(despacho)) {
				                log = String.valueOf(log) + " Se ha modificado el despacho del usuario de: " + consultas.obtenerNombreDespacho((String)user.getDespachofk()) + " con codigo: " + user.getDespachofk() + " por: " + consultas.obtenerNombreDespacho(despacho) + " con codigo: " + despacho;
				            }
				            if (user.getCargofk() != consultas.getCargoPorNombre(cargo)) {
				                log = String.valueOf(log) + " Se ha modificado el cargo del usuario de: " + consultas.getCargo((String)String.valueOf(user.getCargofk())) + " por: " + cargo;
				            }
				            if (log.length() > 1) {
				                user.setNomb(nombre);
				                user.setApe(apellido);
				                user.setCargofk((long)consultas.getCargoPorNombre(cargo));
				                user.setDespachofk(despacho);
				                user = usuarioLocalServiceUtil.updateusuario((usuario)user);
				                auditoriaP audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
				                audi.setFecha(new Date());
				                audi.setTipo_recurso(1);
				                audi.setTipo_operacion("MODIFICAR");
				                audi.setId_recurso_modificado(user.getId());
				                audi.setUsuario_modifico(usuarioAgrego);
				                audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(usuarioAgrego)).getEmailAddress());
				                audi.setModificacion(log);
				                auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
				            }
				        }
				        catch (SystemException e) {
				            System.err.println("Error al guardar el permiso: " + e.getMessage());
				        }
				        try {
				            Docencia temp = DocenciaLocalServiceUtil.createDocencia(0L);
				            temp.setFechaInicial(desde);
				            temp.setFechaFinal(hasta);
				            temp.setCreadoPor(Long.parseLong(usuarioAgrego));
				            temp.setModificadoPor(Long.parseLong(usuarioAgrego));
				            temp.setEstatus(1);
				            temp.setMateria(materia);
				            temp.setInstitucion(institucion);
				            temp.setUsuario_fk(user.getId());
				            temp.setDespacho(user.getDespachofk());
				            temp.setHoras(horas);
				            temp.setMinutos(minutos);
				            temp.setCargo((int)user.getCargofk());
				            DocenciaLocalServiceUtil.addDocencia((Docencia)temp);
				            auditoriaP audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
				            audi.setFecha(new Date());
				            audi.setTipo_recurso(3);
				            audi.setTipo_operacion("AGREGAR");
				            audi.setId_recurso_modificado(String.valueOf(temp.getId()));
				            audi.setUsuario_modifico(usuarioAgrego);
				            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(usuarioAgrego)).getEmailAddress());
				            String log = "";
				            log = String.valueOf(log) + "Ser creo una docencia con los siguientes datos. ";
				            log = String.valueOf(log) + " ID:" + temp.getId();
				            log = String.valueOf(log) + " materia:" + materia;
				            log = String.valueOf(log) + " horas de docencia:" + horas;
				            log = String.valueOf(log) + " minutos de docencia:" + minutos;
				            log = String.valueOf(log) + " institucion:" + institucion;
				            log = String.valueOf(log) + " fecha inicio:" + formatoS.format(desde);
				            log = String.valueOf(log) + " fecha fin:" + formatoS.format(hasta);
				            log = String.valueOf(log) + " Asociado al usuario con ";
				            if (user.getTipo_doc() == 0L) {
				                log = String.valueOf(log) + "tipo de documento: Pasaporte";
				            }
				            if (user.getTipo_doc() == 1L) {
				                log = String.valueOf(log) + "tipo de documento: C\u00e9dula de Ciudadan\u00eda";
				            }
				            log = String.valueOf(log) + " de numero: " + user.getId();
				            audi.setModificacion(log);
				            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
				        }
				        catch (SystemException e) {
				            System.err.println("Error al guardar el permiso: " + e.getMessage());
				        }
					}
				} catch (PortalException e) {
					if(!numeroDocumento.equalsIgnoreCase("") && !nombre.equalsIgnoreCase("") && !apellido.equalsIgnoreCase("") && !despacho.equals("") && consultas.getCargoPorNombre(cargo) !=0 ){
				    	
						auditoriaP audi;
				        String log;
			            
				        usuario uso = usuarioLocalServiceUtil.createusuario(numeroDocumento);
			            uso.setNomb(nombre);
			            uso.setApe(apellido);
			            uso.setCargofk(consultas.getCargoPorNombre(cargo));
			            uso.setDespachofk(despacho);
			            uso.setTipo_doc(consultas.getTipoDocumentoPorNombre(tipoDocumento));
			            uso = usuarioLocalServiceUtil.addusuario((usuario)uso);
			            audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
			            audi.setFecha(new Date());
			            audi.setTipo_recurso(1);
			            audi.setTipo_operacion("AGREGAR");
			            audi.setId_recurso_modificado(numeroDocumento);
			            audi.setUsuario_modifico(usuarioAgrego);
			            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(usuarioAgrego)).getEmailAddress());
			            log = "";
			            if (consultas.getTipoDocumentoPorNombre(tipoDocumento) == 0L) {
			                log = String.valueOf(log) + "Se creo un usuario con tipo de documento: Pasaporte";
			            }
			            if (consultas.getTipoDocumentoPorNombre(tipoDocumento) == 1L) {
			                log = String.valueOf(log) + "Se creo un usuario con tipo de documento: C\u00e9dula de Ciudadan\u00eda";
			            }
			            log = String.valueOf(log) + " Con el numero: " + numeroDocumento;
			            log = String.valueOf(log) + " Con el nombre: " + nombre;
			            log = String.valueOf(log) + " Con el apellido: " + apellido;
			            log = String.valueOf(log) + " agregado al despacho: " + consultas.obtenerNombreDespacho(despacho);
			            log = String.valueOf(log) + " con el codigo: " + despacho;
			            log = String.valueOf(log) + " y con el cargo de: " + cargo;
			            audi.setModificacion(log);
			            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
				        
				        try {
				            Docencia temp = DocenciaLocalServiceUtil.createDocencia(0L);
				            temp.setUsuario_fk(numeroDocumento);
				            temp.setFechaInicial(desde);
				            temp.setFechaFinal(hasta);
				            temp.setMateria(materia);
				            temp.setInstitucion(institucion);
				            temp.setDespacho(despacho);
				            temp.setEstatus(1);
				            temp.setCreadoPor(Long.parseLong(usuarioAgrego));
				            temp.setModificadoPor(Long.parseLong(usuarioAgrego));
				            temp.setHoras(horas);
				            temp.setMinutos(minutos);
				            temp.setCargo(consultas.getCargoPorNombre(cargo));
				            temp = DocenciaLocalServiceUtil.addDocencia((Docencia)temp);
				            audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
				            audi.setFecha(new Date());
				            audi.setTipo_recurso(3);
				            audi.setTipo_operacion("AGREGAR");
				            audi.setId_recurso_modificado(String.valueOf(temp.getId()));
				            audi.setUsuario_modifico(usuarioAgrego);
				            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(usuarioAgrego)).getEmailAddress());
				            log = "";
				            log = String.valueOf(log) + "Ser creo una docencia con los siguientes datos. ";
				            log = String.valueOf(log) + " ID:" + temp.getId();
				            log = String.valueOf(log) + " materia:" + materia;
				            log = String.valueOf(log) + " horas de docencia:" + horas;
				            log = String.valueOf(log) + " minutos de docencia:" + minutos;
				            log = String.valueOf(log) + " institucion:" + institucion;
				            log = String.valueOf(log) + " fecha inicio:" + formatoS.format(desde);
				            log = String.valueOf(log) + " fecha fin:" + formatoS.format(hasta);
				            log = String.valueOf(log) + " Asociado al usuario con ";
				            if ((long)consultas.getTipoDocumentoPorNombre(tipoDocumento) == 0L) {
				                log = String.valueOf(log) + "tipo de documento: Pasaporte";
				            }
				            if ((long)consultas.getTipoDocumentoPorNombre(tipoDocumento) == 1L) {
				                log = String.valueOf(log) + "tipo de documento: C\u00e9dula de Ciudadan\u00eda";
				            }
				            log = String.valueOf(log) + " de numero: " + numeroDocumento;
				            audi.setModificacion(log);
				            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
				        }
				        catch (SystemException ee) {
				            System.err.println("Error al intentar guardar el permiso docente: " + e.getMessage());
				        }
			    	}
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
        return errores;
	}

}
