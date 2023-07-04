package co.com.csj;

import co.com.csj.ExporterUtil;
import co.com.csj.model.Docencia;
import co.com.csj.model.auditoriaP;
import co.com.csj.model.licencia_permiso;
import co.com.csj.model.usuario;
import co.com.csj.modelos.consultas;
import co.com.csj.modelos.despacho;
import co.com.csj.modelos.especialidad;
import co.com.csj.modelos.localizacion;
import co.com.csj.service.DocenciaLocalServiceUtil;
import co.com.csj.service.auditoriaPLocalServiceUtil;
import co.com.csj.service.licencia_permisoLocalServiceUtil;
import co.com.csj.service.tipoLocalServiceUtil;
import co.com.csj.service.usuarioLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class ServidoresJudiciales
extends MVCPortlet {
    private static DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    private static DateFormat formatoS = new SimpleDateFormat("dd/MM/yyyy");

    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
        HttpServletRequest request = PortalUtil.getOriginalServletRequest((HttpServletRequest)PortalUtil.getHttpServletRequest((PortletRequest)resourceRequest));
        HttpServletResponse response = PortalUtil.getHttpServletResponse((PortletResponse)resourceResponse);
        String cmd = ParamUtil.getString((PortletRequest)resourceRequest, (String)"action");
        if (cmd.equals("reporteDespachos")) {
            int tipo = ParamUtil.getInteger((PortletRequest)resourceRequest, (String)"tipo");
            String FI = ParamUtil.getString((PortletRequest)resourceRequest, (String)"fechaInicial");
            String FF = ParamUtil.getString((PortletRequest)resourceRequest, (String)"fechaFinal");
            FileOutputStream fichero = new FileOutputStream("C:\\reportes\\reporteDespachos.xls");
            HSSFWorkbook wb = new HSSFWorkbook();
            try {
                wb = (HSSFWorkbook) ExporterUtil.INSTANCE.exportReporteDespachos(tipo, FI, FF);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
            wb.write((OutputStream)fichero);
            resourceResponse.setContentType("application/vnd.ms-excel");
            HttpServletResponse res = PortalUtil.getHttpServletResponse((PortletResponse)resourceResponse);
            res.setHeader("Content-Disposition", "attachment; filename=reporteDespachos.xls");
            OutputStream out = resourceResponse.getPortletOutputStream();
            FileInputStream in = new FileInputStream(new File("C:\\reportes\\reporteDespachos.xls"));
            IOUtils.copy((InputStream)in, (OutputStream)out);
            out.flush();
            ((InputStream)in).close();
            out.close();
        } else if (cmd.equals("ReporteExcel")) {
            if (resourceRequest.getPortletSession().getAttribute("permisos") != null) {
                List<licencia_permiso> permisos2 = (List<licencia_permiso>)resourceRequest.getPortletSession().getAttribute("permisos");
                String departamento = (String) resourceRequest.getPortletSession().getAttribute("departamentoP");
                String municipio = (String) resourceRequest.getPortletSession().getAttribute("municipioP");
                String despacho = (String) resourceRequest.getPortletSession().getAttribute("despachoP");
                String email = (String) resourceRequest.getPortletSession().getAttribute("emailP");
                String fi = (String) resourceRequest.getPortletSession().getAttribute("fiP");
                String ff = (String) resourceRequest.getPortletSession().getAttribute("ffP");
                FileOutputStream fichero = new FileOutputStream("C:\\reportes\\reportePermisos.xls");
                Workbook wb = ExporterUtil.INSTANCE.exportPermissionsToExcelAdmin(permisos2,departamento,municipio,despacho,email,fi,ff);
                wb.write((OutputStream)fichero);
                resourceResponse.setContentType("application/vnd.ms-excel");
                HttpServletResponse res = PortalUtil.getHttpServletResponse((PortletResponse)resourceResponse);
                res.setHeader("Content-Disposition", "attachment; filename=reportePermisos.xls");
                OutputStream out = resourceResponse.getPortletOutputStream();
                FileInputStream in = new FileInputStream(new File("C:\\reportes\\reportePermisos.xls"));
                IOUtils.copy((InputStream)in, (OutputStream)out);
                out.flush();
                ((InputStream)in).close();
                out.close();
            } else {
                System.err.println("No hay permisos para imprimir.");
            }
        } else if (cmd.equals("reporteDocencia")) {
            if (resourceRequest.getPortletSession().getAttribute("permisosDocencia") != null) {
                List<Docencia> permisos3 = (List<Docencia>)resourceRequest.getPortletSession().getAttribute("permisosDocencia");
                String departamento = (String) resourceRequest.getPortletSession().getAttribute("departamentoD");
                String municipio = (String) resourceRequest.getPortletSession().getAttribute("municipioD");
                String despacho = (String) resourceRequest.getPortletSession().getAttribute("despachoD");
                String email = (String) resourceRequest.getPortletSession().getAttribute("emailD");
                String fi = (String) resourceRequest.getPortletSession().getAttribute("fiD");
                String ff = (String) resourceRequest.getPortletSession().getAttribute("ffD");
                FileOutputStream fichero = new FileOutputStream("C:\\reportes\\reporteDocencias.xls");
                Workbook wb;
				try {
					wb = ExporterUtil.INSTANCE.exportDocentesToExcelAdmin(permisos3,departamento,municipio,despacho,email,fi,ff);
					wb.write((OutputStream)fichero);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                resourceResponse.setContentType("application/vnd.ms-excel");
                HttpServletResponse res = PortalUtil.getHttpServletResponse((PortletResponse)resourceResponse);
                res.setHeader("Content-Disposition", "attachment; filename=reporteDocencias.xls");
                OutputStream out = resourceResponse.getPortletOutputStream();
                FileInputStream in = new FileInputStream(new File("C:\\reportes\\reporteDocencias.xls"));
                IOUtils.copy((InputStream)in, (OutputStream)out);
                out.flush();
                ((InputStream)in).close();
                out.close();
            } else {
                System.err.println("No hay permisos docencia para imprimir.");
            }
        } else if (cmd.equals("permisosbyUserToExcel")) {
            if (resourceRequest.getPortletSession().getAttribute("permisos") != null) {
                List permisos4 = (List)resourceRequest.getPortletSession().getAttribute("permisos");
                FileOutputStream fichero = new FileOutputStream("C:\\reportes\\permisosPorUsuarios.xls");
                Workbook wb = ExporterUtil.INSTANCE.exportPermissionsToExcel(permisos4);
                wb.write((OutputStream)fichero);
                resourceResponse.setContentType("application/vnd.ms-excel");
                HttpServletResponse res = PortalUtil.getHttpServletResponse((PortletResponse)resourceResponse);
                res.setHeader("Content-Disposition", "attachment; filename=permisosPorUsuarios.xls");
                OutputStream out = resourceResponse.getPortletOutputStream();
                FileInputStream in = new FileInputStream(new File("C:\\reportes\\permisosPorUsuarios.xls"));
                IOUtils.copy((InputStream)in, (OutputStream)out);
                out.flush();
                ((InputStream)in).close();
                out.close();
            } else {
                System.err.println("No hay permisos para imprimir.");
            }
        } else if (cmd.equals("docenciasbyUserToExcel")) {
            if (resourceRequest.getPortletSession().getAttribute("docencias") != null) {
                List permisos5 = (List)resourceRequest.getPortletSession().getAttribute("docencias");
                FileOutputStream fichero = new FileOutputStream("C:\\reportes\\docenciasPorUsuario.xls");
                Workbook wb;
				try {
					wb = ExporterUtil.INSTANCE.exportDocentesToExcel(permisos5);
					wb.write((OutputStream)fichero);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                resourceResponse.setContentType("application/vnd.ms-excel");
                HttpServletResponse res = PortalUtil.getHttpServletResponse((PortletResponse)resourceResponse);
                res.setHeader("Content-Disposition", "attachment; filename=docenciasPorUsuario.xls");
                OutputStream out = resourceResponse.getPortletOutputStream();
                FileInputStream in = new FileInputStream(new File("C:\\reportes\\docenciasPorUsuario.xls"));
                IOUtils.copy((InputStream)in, (OutputStream)out);
                out.flush();
                ((InputStream)in).close();
                out.close();
            } else {
                System.err.println("No hay permisos docencia para imprimir.");
            }
        } else if (cmd.equals("getDespachos")) {
            JSONArray arra;
            int tipo_sol = ParamUtil.getInteger((HttpServletRequest)request, (String)"tipo_sol");
            if (tipo_sol == 1) {
                String despachos = ParamUtil.getString((HttpServletRequest)request, (String)"despachos");
                String area = ParamUtil.getString((HttpServletRequest)request, (String)"area");
                if (despachos.length() >= 5) {
                    List<despacho> despacho2 = consultas.obtenerDespacho((String)despachos, (String)area);
                    JSONArray arra2 = JSONFactoryUtil.createJSONArray();
                    for (despacho d : despacho2) {
                        JSONObject json = JSONFactoryUtil.createJSONObject();
                        json.put("id", d.getCodigo());
                        json.put("nombre", d.getNombre());
                        arra2.put(json);
                    }
                    response.getWriter().println(arra2.toString());
                }
            }
            if (tipo_sol == 2) {
                String entidad = ParamUtil.getString((HttpServletRequest)request, (String)"entidad");
                List<especialidad> Especialidad = consultas.obtenerEspecialidad((String)entidad);
                arra = JSONFactoryUtil.createJSONArray();
                for (especialidad ee : Especialidad) {
                    JSONObject json = JSONFactoryUtil.createJSONObject();
                    json.put("id", ee.getId());
                    json.put("nombre", ee.getNombre());
                    arra.put(json);
                }
                response.getWriter().println(arra.toString());
            }
            if (tipo_sol == 3) {
                String cod = ParamUtil.getString((HttpServletRequest)request, (String)"ciudad");
                String distrito = consultas.obtenerDistrito((String)cod);
                arra = JSONFactoryUtil.createJSONArray();
                JSONObject json = JSONFactoryUtil.createJSONObject();
                json.put("distrito", distrito);
                arra.put(json);
                response.getWriter().println(arra.toString());
            }
            if (tipo_sol == 4) {
                String departamento = ParamUtil.getString((HttpServletRequest)request, (String)"departamento");
                JSONArray arra3 = JSONFactoryUtil.createJSONArray();
                for (localizacion d : consultas.obtenerMunicipios((String)departamento)) {
                    JSONObject json = JSONFactoryUtil.createJSONObject();
                    json.put("id", String.valueOf(d.getCod_dane_departamento()) + d.getCod_dane());
                    json.put("nombre", d.getNombre());
                    arra3.put(json);
                }
                response.getWriter().println(arra3.toString());
            }
        } else if (cmd.equals("filtroReportes")) {
            String tipo_filtro = ParamUtil.getString((HttpServletRequest)request, (String)"tipo_filtro");
            if (tipo_filtro.equals("departamento")) {
                String id = ParamUtil.getString((HttpServletRequest)request, (String)"departamento");
                List<localizacion> municipios = consultas.getMunicipios((String)id);
                JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
                for (localizacion elemento : municipios) {
                    JSONObject json = JSONFactoryUtil.createJSONObject();
                    json.put("id", elemento.getCod_dane());
                    json.put("nombre", elemento.getNombre());
                    jsonArray.put(json);
                }
                response.getWriter().println(jsonArray.toString());
            } else if (tipo_filtro.equals("municipio")) {
                String departamento = ParamUtil.getString((HttpServletRequest)request, (String)"departamento");
                String municipio = ParamUtil.getString((HttpServletRequest)request, (String)"municipio");
                List<despacho> despachos = consultas.getDespachos((String)departamento, (String)municipio);
                JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
                for (despacho elemento : despachos) {
                    JSONObject json = JSONFactoryUtil.createJSONObject();
                    json.put("id", elemento.getCodigo());
                    json.put("nombre", elemento.getNombre());
                    jsonArray.put(json);
                }
                response.getWriter().println(jsonArray.toString());
            }
        }
    }

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) {
        try {
            List<licencia_permiso> permisos2 = consultas.filtroPermisos((long)Long.parseLong(renderRequest.getRemoteUser()), (String)"", (String)"", (long)-1L, null);
            renderRequest.setAttribute("permisos", (Object)permisos2);
            renderRequest.getPortletSession().setAttribute("permisos", (Object)permisos2);
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
        try {
            super.doView(renderRequest, renderResponse);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (PortletException e) {
            e.printStackTrace();
        }
    }

    public void verPermisos(ActionRequest request, ActionResponse response) {
        try {
            List<licencia_permiso> permisos2 = consultas.filtroPermisos((long)Long.parseLong(request.getRemoteUser()), (String)"", (String)"", (long)-1L, null);
            request.setAttribute("permisos", (Object)permisos2);
            request.getPortletSession().setAttribute("permisos", (Object)permisos2);
            SessionMessages.add((PortletRequest)request, (String)"notiene");
            response.setRenderParameter("mvcPath", "/html/servidoresjudiciales/view.jsp");
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void verDocencias(ActionRequest request, ActionResponse response) throws ParseException {
        try {
            List<Docencia> docencias = consultas.filtroDocencia((long)Long.parseLong(request.getRemoteUser()), (String)"", (String)"", null);
            request.setAttribute("docencias", (Object)docencias);
            request.getPortletSession().setAttribute("docencias", (Object)docencias);
            SessionMessages.add((PortletRequest)request, (String)"notiene");
            response.setRenderParameter("mvcPath", "/html/servidoresjudiciales/verDocencias.jsp");
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void filtroPermisos(ActionRequest actionRequest, ActionResponse actionResponse) {
        String fechaInicio = ParamUtil.getString((PortletRequest)actionRequest, (String)"fechaInicial");
        String fechaFinal = ParamUtil.getString((PortletRequest)actionRequest, (String)"fechaFinal");
        long tipo = ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo", (long)-1L);
        String municipio = ParamUtil.getString((PortletRequest)actionRequest, (String)"municipio");
        List permisos2 = consultas.filtroPermisos((long)Long.parseLong(actionRequest.getRemoteUser()), (String)fechaInicio, (String)fechaFinal, (long)tipo, (String)municipio);
        actionRequest.setAttribute("permisos", (Object)permisos2);
        actionRequest.getPortletSession().setAttribute("permisos", (Object)permisos2);
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/view.jsp");
    }

    public void filtroDocencias(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, ParseException {
        String fechaInicio = ParamUtil.getString((PortletRequest)actionRequest, (String)"fechaInicial");
        String fechaFinal = ParamUtil.getString((PortletRequest)actionRequest, (String)"fechaFinal");
        String municipio = ParamUtil.getString((PortletRequest)actionRequest, (String)"municipio");
        List docencias = consultas.filtroDocencia((long)Long.parseLong(actionRequest.getRemoteUser()), (String)fechaInicio, (String)fechaFinal, (String)municipio);
        actionRequest.setAttribute("docencias", (Object)docencias);
        actionRequest.getPortletSession().setAttribute("docencias", (Object)docencias);
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/verDocencias.jsp");
    }

    public void addDocentePermiso(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, PortalException {
        auditoriaP audi;
        String log;
        try {
            usuario uso = usuarioLocalServiceUtil.createusuario((String)ParamUtil.getString((PortletRequest)actionRequest, (String)"cedula"));
            uso.setNomb(ParamUtil.getString((PortletRequest)actionRequest, (String)"nombre"));
            uso.setApe(ParamUtil.getString((PortletRequest)actionRequest, (String)"apellido"));
            uso.setCargofk(ParamUtil.getLong((PortletRequest)actionRequest, (String)"cargo"));
            uso.setDespachofk(ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho"));
            uso.setTipo_doc(ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo_doc"));
            uso = usuarioLocalServiceUtil.addusuario((usuario)uso);
            audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
            audi.setFecha(new Date());
            audi.setTipo_recurso(1);
            audi.setTipo_operacion("AGREGAR");
            audi.setId_recurso_modificado(ParamUtil.getString((PortletRequest)actionRequest, (String)"cedula"));
            audi.setUsuario_modifico(actionRequest.getRemoteUser());
            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
            log = "";
            if (ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo_doc") == 0L) {
                log = String.valueOf(log) + "Se creo un solicitante con tipo de documento: Pasaporte";
            }
            if (ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo_doc") == 1L) {
                log = String.valueOf(log) + "Se creo un solicitante con tipo de documento: C\u00e9dula de Ciudadan\u00eda";
            }
            log = String.valueOf(log) + " Con el numero: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"cedula");
            log = String.valueOf(log) + " Con el nombre: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"nombre");
            log = String.valueOf(log) + " Con el apellido: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"apellido");
            log = String.valueOf(log) + " agregado al despacho: " + consultas.obtenerNombreDespacho((String)ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho"));
            log = String.valueOf(log) + " con el codigo: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho");
            log = String.valueOf(log) + " y con el cargo de: " + consultas.getCargo((String)ParamUtil.getString((PortletRequest)actionRequest, (String)"cargo"));
            audi.setModificacion(log);
            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
            actionRequest.getPortletSession().setAttribute("usuario", (Object)uso);
        }
        catch (SystemException e) {
            System.err.println("Error al intentar guardar el docente: " + e.getMessage());
            SessionErrors.add((PortletRequest)actionRequest, (String)"errorDocente");
            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaInvestigacion.jsp");
        }
        try {
            Docencia temp = DocenciaLocalServiceUtil.createDocencia(0L);
            temp.setUsuario_fk(ParamUtil.getString((PortletRequest)actionRequest, (String)"cedula"));
            temp.setFechaInicial(ParamUtil.getDate((PortletRequest)actionRequest, (String)"fecha_inicio", (DateFormat)formatoS));
            temp.setFechaFinal(ParamUtil.getDate((PortletRequest)actionRequest, (String)"fecha_fin", (DateFormat)formatoS));
            temp.setMateria(ParamUtil.getString((PortletRequest)actionRequest, (String)"materia"));
            temp.setInstitucion(ParamUtil.getString((PortletRequest)actionRequest, (String)"institucion"));
            temp.setDespacho(ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho"));
            temp.setEstatus(1);
            temp.setCreadoPor(Long.parseLong(actionRequest.getRemoteUser()));
            temp.setModificadoPor(Long.parseLong(actionRequest.getRemoteUser()));
            temp.setHoras(ParamUtil.getInteger(actionRequest, "horas"));
            temp.setMinutos(ParamUtil.getInteger(actionRequest, "minutos"));
            temp.setCargo(ParamUtil.getInteger((PortletRequest)actionRequest, (String)"cargo"));
            temp.setFechaRegistro(new Date());
            temp = DocenciaLocalServiceUtil.addDocencia((Docencia)temp);
            audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
            audi.setFecha(new Date());
            audi.setTipo_recurso(3);
            audi.setTipo_operacion("AGREGAR");
            audi.setId_recurso_modificado(String.valueOf(temp.getId()));
            audi.setUsuario_modifico(actionRequest.getRemoteUser());
            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
            log = "";
            log = String.valueOf(log) + "Ser creo una docencia con los siguientes datos. ";
            log = String.valueOf(log) + " ID:" + temp.getId();
            log = String.valueOf(log) + " materia:" + ParamUtil.getString((PortletRequest)actionRequest, (String)"materia");
            log = String.valueOf(log) + " horas de docencia:" + ParamUtil.getInteger(actionRequest, "horas");
            log = String.valueOf(log) + " minutos de docencia:" + ParamUtil.getInteger(actionRequest, "minutos");
            log = String.valueOf(log) + " institucion:" + ParamUtil.getString((PortletRequest)actionRequest, (String)"institucion");
            log = String.valueOf(log) + " fecha inicio:" + formatoS.format(ParamUtil.getDate((PortletRequest)actionRequest, (String)"fecha_inicio", (DateFormat)formatoS));
            log = String.valueOf(log) + " fecha fin:" + formatoS.format(ParamUtil.getDate((PortletRequest)actionRequest, (String)"fecha_fin", (DateFormat)formatoS));
            log = String.valueOf(log) + " Asociado al solicitante con ";
            if (ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo_doc") == 0L) {
                log = String.valueOf(log) + "tipo de documento: Pasaporte";
            }
            if (ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo_doc") == 1L) {
                log = String.valueOf(log) + "tipo de documento: C\u00e9dula de Ciudadan\u00eda";
            }
            log = String.valueOf(log) + " de numero: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"cedula");
            audi.setModificacion(log);
            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
            SessionMessages.add((PortletRequest)actionRequest, (String)"addedPermiso");
            actionRequest.setAttribute("docenciaPermisos", (Object)DocenciaLocalServiceUtil.porDocente((String)temp.getUsuario_fk()));
            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaInvestigacion2.jsp");
        }
        catch (SystemException e) {
            System.err.println("Error al intentar guardar el permiso docente: " + e.getMessage());
            SessionErrors.add((PortletRequest)actionRequest, (String)"errorPermiso");
            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaInvestigacion2.jsp");
        }
    }

    public void addDocencia(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, PortalException {
        usuario user = (usuario)actionRequest.getPortletSession().getAttribute("usuario");
        try {
            String log = "";
            if (!user.getNomb().equalsIgnoreCase(ParamUtil.getString((PortletRequest)actionRequest, (String)"nombre"))) {
                log = String.valueOf(log) + "Se ha modificado el nombre del solicitante de: " + user.getNomb() + " por: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"nombre");
            }
            if (!user.getApe().equalsIgnoreCase(ParamUtil.getString((PortletRequest)actionRequest, (String)"apellido"))) {
                log = String.valueOf(log) + " Se ha modificado el apellido del solicitante de: " + user.getApe() + " por: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"apellido");
            }
            if (!user.getDespachofk().equalsIgnoreCase(ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho"))) {
                log = String.valueOf(log) + " Se ha modificado el despacho del solicitante de: " + consultas.obtenerNombreDespacho((String)user.getDespachofk()) + " con codigo: " + user.getDespachofk() + " por: " + consultas.obtenerNombreDespacho((String)ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho")) + " con codigo: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho");
            }
            if (user.getCargofk() != ParamUtil.getLong((PortletRequest)actionRequest, (String)"cargo")) {
                log = String.valueOf(log) + " Se ha modificado el cargo del solicitante de: " + consultas.getCargo((String)String.valueOf(user.getCargofk())) + " por: " + consultas.getCargo((String)ParamUtil.getString((PortletRequest)actionRequest, (String)"cargo"));
            }
            if (log.length() > 1) {
                user.setNomb(ParamUtil.getString((PortletRequest)actionRequest, (String)"nombre"));
                user.setApe(ParamUtil.getString((PortletRequest)actionRequest, (String)"apellido"));
                user.setCargofk(ParamUtil.getLong((PortletRequest)actionRequest, (String)"cargo"));
                user.setDespachofk(ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho"));
                user = usuarioLocalServiceUtil.updateusuario((usuario)user);
                auditoriaP audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
                audi.setFecha(new Date());
                audi.setTipo_recurso(1);
                audi.setTipo_operacion("MODIFICAR");
                audi.setId_recurso_modificado(user.getId());
                audi.setUsuario_modifico(actionRequest.getRemoteUser());
                audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
                audi.setModificacion(log);
                auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
                actionRequest.getPortletSession().setAttribute("usuario", (Object)user);
            }
        }
        catch (SystemException e) {
            System.err.println("Error al guardar el permiso: " + e.getMessage());
            SessionErrors.add((PortletRequest)actionRequest, (String)"errorPermiso");
        }
        try {
            Docencia temp = DocenciaLocalServiceUtil.createDocencia(0L);
            temp.setFechaInicial(ParamUtil.getDate((PortletRequest)actionRequest, (String)"fecha_inicio", (DateFormat)formatoS));
            temp.setFechaFinal(ParamUtil.getDate((PortletRequest)actionRequest, (String)"fecha_fin", (DateFormat)formatoS));
            temp.setCreadoPor(Long.parseLong(actionRequest.getRemoteUser()));
            temp.setModificadoPor(Long.parseLong(actionRequest.getRemoteUser()));
            temp.setEstatus(1);
            temp.setMateria(ParamUtil.getString((PortletRequest)actionRequest, (String)"materia"));
            temp.setInstitucion(ParamUtil.getString((PortletRequest)actionRequest, (String)"institucion"));
            temp.setUsuario_fk(user.getId());
            temp.setDespacho(user.getDespachofk());
            temp.setHoras(ParamUtil.getInteger(actionRequest, "horas"));
            temp.setMinutos(ParamUtil.getInteger(actionRequest, "minutos"));
            temp.setCargo((int)user.getCargofk());
            temp.setFechaRegistro(new Date());
            DocenciaLocalServiceUtil.addDocencia((Docencia)temp);
            auditoriaP audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
            audi.setFecha(new Date());
            audi.setTipo_recurso(3);
            audi.setTipo_operacion("AGREGAR");
            audi.setId_recurso_modificado(String.valueOf(temp.getId()));
            audi.setUsuario_modifico(actionRequest.getRemoteUser());
            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
            String log = "";
            log = String.valueOf(log) + "Ser creo una docencia con los siguientes datos. ";
            log = String.valueOf(log) + " ID:" + temp.getId();
            log = String.valueOf(log) + " materia:" + ParamUtil.getString((PortletRequest)actionRequest, (String)"materia");
            log = String.valueOf(log) + " horas de docencia:" + ParamUtil.getInteger(actionRequest, "horas");
            log = String.valueOf(log) + " minutos de docencia:" + ParamUtil.getInteger(actionRequest, "minutos");
            log = String.valueOf(log) + " institucion:" + ParamUtil.getString((PortletRequest)actionRequest, (String)"institucion");
            log = String.valueOf(log) + " fecha inicio:" + formatoS.format(ParamUtil.getDate((PortletRequest)actionRequest, (String)"fecha_inicio", (DateFormat)formatoS));
            log = String.valueOf(log) + " fecha fin:" + formatoS.format(ParamUtil.getDate((PortletRequest)actionRequest, (String)"fecha_fin", (DateFormat)formatoS));
            log = String.valueOf(log) + " Asociado al solicitante con ";
            if (user.getTipo_doc() == 0L) {
                log = String.valueOf(log) + "tipo de documento: Pasaporte";
            }
            if (user.getTipo_doc() == 1L) {
                log = String.valueOf(log) + "tipo de documento: C\u00e9dula de Ciudadan\u00eda";
            }
            log = String.valueOf(log) + " de numero: " + user.getId();
            audi.setModificacion(log);
            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
            SessionMessages.add((PortletRequest)actionRequest, (String)"addedPermiso");
        }
        catch (SystemException e) {
            System.err.println("Error al guardar el permiso: " + e.getMessage());
            SessionErrors.add((PortletRequest)actionRequest, (String)"errorPermiso");
        }
        actionRequest.setAttribute("docenciaPermisos", (Object)DocenciaLocalServiceUtil.porDocente((String)user.getId()));
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaInvestigacion2.jsp");
    }

    public void addPermiso(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
    	String nombre = ParamUtil.getString(actionRequest, "nombre");
    	String apellido = ParamUtil.getString(actionRequest, "apellido");
    	String despacho = ParamUtil.getString(actionRequest, "despacho");
    	long cargo = ParamUtil.getLong(actionRequest, "cargo");
    	
        usuario user = (usuario)actionRequest.getPortletSession().getAttribute("usuario");
        if(!nombre.equalsIgnoreCase("") && !apellido.equalsIgnoreCase("") && !despacho.equalsIgnoreCase("") && cargo != 0){
	        try {
	            String log = "";
	            if (!user.getNomb().equalsIgnoreCase(ParamUtil.getString((PortletRequest)actionRequest, (String)"nombre"))) {
	                log = String.valueOf(log) + "Se ha modificado el nombre del solicitante de: " + user.getNomb() + " por: " + nombre;
	            }
	            if (!user.getApe().equalsIgnoreCase(ParamUtil.getString((PortletRequest)actionRequest, (String)"apellido"))) {
	                log = String.valueOf(log) + " Se ha modificado el apellido del solicitante de: " + user.getApe() + " por: " + apellido;
	            }
	            if (!user.getDespachofk().equalsIgnoreCase(ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho"))) {
	                log = String.valueOf(log) + " Se ha modificado el despacho del solicitante de: " + consultas.obtenerNombreDespacho((String)user.getDespachofk()) + " con codigo: " + user.getDespachofk() + " por: " + consultas.obtenerNombreDespacho(despacho) + " con codigo: " + despacho;
	            }
	            if (user.getCargofk() != ParamUtil.getLong((PortletRequest)actionRequest, (String)"cargo")) {
	                log = String.valueOf(log) + " Se ha modificado el cargo del solicitante de: " + consultas.getCargo((String)String.valueOf(user.getCargofk())) + " por: " + consultas.getCargo(String.valueOf(cargo));
	            }
	            if (log.length() > 1) {
	                user.setNomb(nombre);
	                user.setApe(apellido);
	                user.setCargofk(cargo);
	                user.setDespachofk(despacho);
	                user = usuarioLocalServiceUtil.updateusuario((usuario)user);
	                auditoriaP audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
	                audi.setFecha(new Date());
	                audi.setTipo_recurso(1);
	                audi.setTipo_operacion("MODIFICAR");
	                audi.setId_recurso_modificado(user.getId());
	                audi.setUsuario_modifico(actionRequest.getRemoteUser());
	                audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
	                audi.setModificacion(log);
	                auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
	                actionRequest.getPortletSession().setAttribute("usuario", (Object)user);
	            }
	        }
	        catch (SystemException e) {
	            System.err.println("Error al guardar el permiso: " + e.getMessage());
	            SessionErrors.add((PortletRequest)actionRequest, (String)"errorPermiso");
	        }
	        try {
	            licencia_permiso lp = licencia_permisoLocalServiceUtil.createlicencia_permiso(0L);
	            lp.setTipofk(ParamUtil.getLong((PortletRequest)actionRequest, (String)"t_permiso"));
	            lp.setFechainicio(ParamUtil.getDate((PortletRequest)actionRequest, (String)"desde", (DateFormat)formatoS));
	            lp.setFechafin(ParamUtil.getDate((PortletRequest)actionRequest, (String)"hasta", (DateFormat)formatoS));
	            lp.setActoadmin(ParamUtil.getString((PortletRequest)actionRequest, (String)"aadmin"));
	            lp.setHoras(ParamUtil.getInteger(actionRequest, "horas"));
	            lp.setMinutos(ParamUtil.getInteger(actionRequest, "minutos"));
	            lp.setCreadoPor(Long.parseLong(actionRequest.getRemoteUser()));
	            lp.setModificadoPor(Long.parseLong(actionRequest.getRemoteUser()));
	            lp.setEstatus(1);
	            lp.setUsuariofk(user.getId());
	            lp.setDespacho(user.getDespachofk());
	            lp.setCargo((int)user.getCargofk());
	            lp.setFechaRegistro(new Date());
	            licencia_permisoLocalServiceUtil.addlicencia_permiso((licencia_permiso)lp);
	            auditoriaP audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
	            audi.setFecha(new Date());
	            audi.setTipo_recurso(2);
	            audi.setTipo_operacion("AGREGAR");
	            audi.setId_recurso_modificado(String.valueOf(lp.getId()));
	            audi.setUsuario_modifico(actionRequest.getRemoteUser());
	            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
	            String log = "";
	            log = String.valueOf(log) + "Ser creo un permiso con los siguientes datos. ";
	            log = String.valueOf(log) + " ID:" + lp.getId();
	            log = String.valueOf(log) + " tipo de permiso:" + tipoLocalServiceUtil.gettipo((long)ParamUtil.getLong((PortletRequest)actionRequest, (String)"t_permiso")).getDescripcion();
	            log = String.valueOf(log) + " acto administrativo:" + ParamUtil.getString((PortletRequest)actionRequest, (String)"aadminp");
	            log = String.valueOf(log) + " fecha inicio:" + formatoS.format(ParamUtil.getDate((PortletRequest)actionRequest, (String)"desde", (DateFormat)formatoS));
	            log = String.valueOf(log) + " fecha fin:" + formatoS.format(ParamUtil.getDate((PortletRequest)actionRequest, (String)"hasta", (DateFormat)formatoS));
	            log = String.valueOf(log) + " horas laborales:" + ParamUtil.getInteger(actionRequest, "horas");
	            log = String.valueOf(log) + " minutos laborales:" + ParamUtil.getInteger(actionRequest, "minutos");
	            log = String.valueOf(log) + " Asociado al solicitante con ";
	            if (user.getTipo_doc() == 0L) {
	                log = String.valueOf(log) + "tipo de documento: Pasaporte";
	            }
	            if (user.getTipo_doc() == 1L) {
	                log = String.valueOf(log) + "tipo de documento: C\u00e9dula de Ciudadan\u00eda";
	            }
	            log = String.valueOf(log) + " de numero: " + user.getId();
	            audi.setModificacion(log);
	            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
	            SessionMessages.add((PortletRequest)actionRequest, (String)"addedPermiso");
	        }
	        catch (SystemException e) {
	            System.err.println("Error al guardar el permiso: " + e.getMessage());
	            SessionErrors.add((PortletRequest)actionRequest, (String)"errorPermiso");
	        }
        }else{
        	System.out.println(">>>>Algun dato llego vacio para poder registrar el permiso<<<<");
        	SessionErrors.add((PortletRequest)actionRequest, (String)"errorPermiso");
        }
        
        actionRequest.setAttribute("lista_permisos", (Object)licencia_permisoLocalServiceUtil.porPersona((String)user.getId()));
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaPermisos2.jsp");
    }

    public void addPermisoPersona(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException {
    	
    	String cedula = ParamUtil.getString(actionRequest, "cedula");
    	String nombre = ParamUtil.getString(actionRequest, "nombre");
    	String apellido = ParamUtil.getString(actionRequest, "apellido");
    	String despacho = ParamUtil.getString(actionRequest, "despacho");
    	long cargo = ParamUtil.getLong(actionRequest, "cargo");
    	long tipo_doc = ParamUtil.getLong(actionRequest, "tipo_doc");
    	
    	if(!cedula.equalsIgnoreCase("") && !nombre.equalsIgnoreCase("") && !apellido.equalsIgnoreCase("") && !despacho.equals("") && cargo !=0 ){
    	
	        auditoriaP audi;
	        String log;
	        try {
	            usuario uso = usuarioLocalServiceUtil.createusuario((String)ParamUtil.getString((PortletRequest)actionRequest, (String)"cedula"));
	            uso.setNomb(nombre);
	            uso.setApe(apellido);
	            uso.setCargofk(cargo);
	            uso.setDespachofk(despacho);
	            uso.setTipo_doc(tipo_doc);
	            uso = usuarioLocalServiceUtil.addusuario((usuario)uso);
	            audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
	            audi.setFecha(new Date());
	            audi.setTipo_recurso(1);
	            audi.setTipo_operacion("AGREGAR");
	            audi.setId_recurso_modificado(ParamUtil.getString((PortletRequest)actionRequest, (String)"cedula"));
	            audi.setUsuario_modifico(actionRequest.getRemoteUser());
	            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
	            log = "";
	            if (ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo_doc") == 0L) {
	                log = String.valueOf(log) + "Se creo un solicitante con tipo de documento: Pasaporte";
	            }
	            if (ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo_doc") == 1L) {
	                log = String.valueOf(log) + "Se creo un solicitante con tipo de documento: C\u00e9dula de Ciudadan\u00eda";
	            }
	            log = String.valueOf(log) + " Con el numero: " + cedula;
	            log = String.valueOf(log) + " Con el nombre: " + nombre;
	            log = String.valueOf(log) + " Con el apellido: " + apellido;
	            log = String.valueOf(log) + " agregado al despacho: " + consultas.obtenerNombreDespacho(despacho);
	            log = String.valueOf(log) + " con el codigo: " + despacho;
	            log = String.valueOf(log) + " y con el cargo de: " + consultas.getCargo(String.valueOf(cargo));
	            audi.setModificacion(log);
	            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
	            actionRequest.getPortletSession().setAttribute("usuario", (Object)uso);
	        }
	        catch (SystemException e) {
	            System.err.println("Error al intentar guardar la persona: " + e.getMessage());
	            SessionErrors.add((PortletRequest)actionRequest, (String)"errorUsuario");
	            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaPermisos.jsp");
	        }
	        try {
	            licencia_permiso lp = licencia_permisoLocalServiceUtil.createlicencia_permiso(0L);
	            lp.setUsuariofk(cedula);
	            lp.setTipofk(ParamUtil.getLong((PortletRequest)actionRequest, (String)"t_permiso"));
	            lp.setFechainicio(ParamUtil.getDate((PortletRequest)actionRequest, (String)"desdep", (DateFormat)formatoS));
	            lp.setFechafin(ParamUtil.getDate((PortletRequest)actionRequest, (String)"hastap", (DateFormat)formatoS));
	            lp.setActoadmin(ParamUtil.getString((PortletRequest)actionRequest, (String)"aadminp"));
	            lp.setHoras(ParamUtil.getInteger(actionRequest, "horas"));
	            lp.setMinutos(ParamUtil.getInteger(actionRequest, "minutos"));
	            lp.setCreadoPor(Long.parseLong(actionRequest.getRemoteUser()));
	            lp.setModificadoPor(Long.parseLong(actionRequest.getRemoteUser()));
	            lp.setDespacho(despacho);
	            lp.setEstatus(1);
	            lp.setCargo((int) cargo);
	            lp.setFechaRegistro(new Date());
	            lp = licencia_permisoLocalServiceUtil.addlicencia_permiso((licencia_permiso)lp);
	            audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
	            audi.setFecha(new Date());
	            audi.setTipo_recurso(2);
	            audi.setTipo_operacion("AGREGAR");
	            audi.setId_recurso_modificado(String.valueOf(lp.getId()));
	            audi.setUsuario_modifico(actionRequest.getRemoteUser());
	            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
	            log = "";
	            log = String.valueOf(log) + "Ser creo un permiso con los siguientes datos. ";
	            log = String.valueOf(log) + " ID:" + lp.getId();
	            log = String.valueOf(log) + " tipo de permiso:" + tipoLocalServiceUtil.gettipo((long)ParamUtil.getLong((PortletRequest)actionRequest, (String)"t_permiso")).getDescripcion();
	            log = String.valueOf(log) + " acto administrativo:" + ParamUtil.getString((PortletRequest)actionRequest, (String)"aadminp");
	            log = String.valueOf(log) + " fecha inicio:" + formatoS.format(ParamUtil.getDate((PortletRequest)actionRequest, (String)"desdep", (DateFormat)formatoS));
	            log = String.valueOf(log) + " fecha fin:" + formatoS.format(ParamUtil.getDate((PortletRequest)actionRequest, (String)"hastap", (DateFormat)formatoS));
	            log = String.valueOf(log) + " horas laborales:" + ParamUtil.getInteger(actionRequest, "horas");
	            log = String.valueOf(log) + " minutos laborales:" + ParamUtil.getInteger(actionRequest, "minutos");
	            log = String.valueOf(log) + " Asociado al solicitante con ";
	            if (ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo_doc") == 0L) {
	                log = String.valueOf(log) + "tipo de documento: Pasaporte";
	            }
	            if (ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo_doc") == 1L) {
	                log = String.valueOf(log) + "tipo de documento: C\u00e9dula de Ciudadan\u00eda";
	            }
	            log = String.valueOf(log) + " de numero: " + cedula;
	            audi.setModificacion(log);
	            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
	            SessionMessages.add((PortletRequest)actionRequest, (String)"addedPermiso");
	            actionRequest.setAttribute("lista_permisos", (Object)licencia_permisoLocalServiceUtil.porPersona((String)lp.getUsuariofk()));
	            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaPermisos2.jsp");
	        }
	        catch (SystemException e) {
	            System.err.println("Error al intentar guardar el permiso: " + e.getMessage());
	            SessionErrors.add((PortletRequest)actionRequest, (String)"errorPermiso");
	            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaPermisos2.jsp");
	        }
    	}else{
    		System.out.println(">>>>Algun dato llego vacio para poder registrar el permiso<<<<");
    		actionRequest.setAttribute("cedula", cedula);
            actionRequest.setAttribute("tipo_doc", String.valueOf(tipo_doc));
            SessionErrors.add((PortletRequest)actionRequest, (String)"errorUsuario");
            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaPermisos.jsp");
    	}
    }

    public void buscar_usuario(ActionRequest actionRequest, ActionResponse actionResponse) {
        String cedula = "";
        String aux = "";
        cedula = ParamUtil.getString((PortletRequest)actionRequest, (String)"cedula");
        aux = ParamUtil.getString((PortletRequest)actionRequest, (String)"tipo_doc");
        try {
            usuario usuarios = usuarioLocalServiceUtil.getusuario((String)cedula);
            actionRequest.getPortletSession().setAttribute("usuario", (Object)usuarios);
            actionRequest.setAttribute("lista_permisos", (Object)licencia_permisoLocalServiceUtil.porPersona((String)usuarios.getId()));
            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaPermisos2.jsp");
        }
        catch (PortalException e) {
            actionRequest.setAttribute("cedula", (Object)cedula);
            actionRequest.setAttribute("tipo_doc", (Object)aux);
            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaPermisos.jsp");
        }
        catch (SystemException e) {
            System.err.println("ERROR: no se puedo ejecutar la acci\u00f3n.\n " + e.getMessage());
            SessionErrors.add((PortletRequest)actionRequest, (String)"errorBuscar");
        }
        SessionMessages.add((PortletRequest)actionRequest, (String)"No tiene");
    }

    public void buscar_docencia(ActionRequest actionRequest, ActionResponse actionResponse) {
        String cedula = ParamUtil.getString((PortletRequest)actionRequest, (String)"cedula");
        long t_doc = ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo_doc");
        try {
            usuario usuarios = usuarioLocalServiceUtil.getusuario((String)cedula);
            actionRequest.getPortletSession().setAttribute("usuario", (Object)usuarios);
            actionRequest.setAttribute("docenciaPermisos", (Object)DocenciaLocalServiceUtil.porDocente((String)usuarios.getId()));
            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaInvestigacion2.jsp");
        }
        catch (PortalException e) {
            actionRequest.setAttribute("cedula", (Object)cedula);
            actionRequest.setAttribute("tipo_doc", (Object)t_doc);
            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaInvestigacion.jsp");
        }
        catch (SystemException e) {
            System.err.println("ERROR: no se puedo ejecutar la acci\u00f3n.\n " + e.getMessage());
            SessionErrors.add((PortletRequest)actionRequest, (String)"errorBuscar");
        }
        SessionMessages.add((PortletRequest)actionRequest, (String)"No tiene");
    }

    public void actualizar_persona(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, PortalException {
        try {
            usuario usu = (usuario)actionRequest.getPortletSession().getAttribute("usuario");
            String log = "";
            if (!usu.getNomb().equalsIgnoreCase(ParamUtil.getString((PortletRequest)actionRequest, (String)"nombre"))) {
                log = String.valueOf(log) + "Se ha modificado el nombre del solicitante de: " + usu.getNomb() + " por: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"nombre");
            }
            if (!usu.getApe().equalsIgnoreCase(ParamUtil.getString((PortletRequest)actionRequest, (String)"apellido"))) {
                log = String.valueOf(log) + " Se ha modificado el apellido del solicitante de: " + usu.getApe() + " por: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"apellido");
            }
            if (!usu.getDespachofk().equalsIgnoreCase(ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho"))) {
                log = String.valueOf(log) + " Se ha modificado el despacho del solicitante de: " + consultas.obtenerNombreDespacho((String)usu.getDespachofk()) + " con codigo: " + usu.getDespachofk() + " por: " + consultas.obtenerNombreDespacho((String)ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho")) + " con codigo: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho");
            }
            if (usu.getCargofk() != ParamUtil.getLong((PortletRequest)actionRequest, (String)"cargo")) {
                log = String.valueOf(log) + " Se ha modificado el cargo del solicitante de: " + consultas.getCargo((String)String.valueOf(usu.getCargofk())) + " por: " + consultas.getCargo((String)ParamUtil.getString((PortletRequest)actionRequest, (String)"cargo"));
            }
            usu.setNomb(ParamUtil.getString((PortletRequest)actionRequest, (String)"nombre"));
            usu.setApe(ParamUtil.getString((PortletRequest)actionRequest, (String)"apellido"));
            usu.setCargofk(ParamUtil.getLong((PortletRequest)actionRequest, (String)"cargo"));
            usu.setDespachofk(ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho"));
            usu = usuarioLocalServiceUtil.updateusuario((usuario)usu);
            auditoriaP audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
            audi.setFecha(new Date());
            audi.setTipo_recurso(1);
            audi.setTipo_operacion("MODIFICAR");
            audi.setId_recurso_modificado(usu.getId());
            audi.setUsuario_modifico(actionRequest.getRemoteUser());
            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
            audi.setModificacion(log);
            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
            actionRequest.getPortletSession().setAttribute("usuario", (Object)usu);
            SessionMessages.add((PortletRequest)actionRequest, (String)"usuarioModificado");
        }
        catch (SystemException e) {
            System.err.println("Error al intentar guardar los datos del solicitante: " + e.getMessage());
            SessionErrors.add((PortletRequest)actionRequest, (String)"errorModificando");
        }
    }

    public void consulta_permisos(ActionRequest actionRequest, ActionResponse actionResponse) throws ParseException, SystemException {
        usuario user = (usuario)actionRequest.getPortletSession().getAttribute("usuario");
        String fechainicio = ParamUtil.getString((PortletRequest)actionRequest, (String)"fechaini");
        String fechafin = ParamUtil.getString((PortletRequest)actionRequest, (String)"fechafin");
        if (!fechainicio.equals("") && !fechafin.equals("")) {
            ArrayList<licencia_permiso> auxPermisos = new ArrayList<licencia_permiso>();
            List<licencia_permiso> permisos2 = licencia_permisoLocalServiceUtil.getAll();
            Date inicio = formato.parse(fechainicio);
            Date fin = formato.parse(fechafin);
            for (licencia_permiso lp : permisos2) {
                if (!inicio.after(lp.getFechainicio()) && !inicio.equals(lp.getFechainicio()) || !fin.before(lp.getFechafin()) && !fin.equals(lp.getFechafin()) || !lp.getUsuariofk().equals(user.getId())) continue;
                auxPermisos.add(lp);
            }
            actionRequest.setAttribute("lista_permisos", auxPermisos);
        } else if (!fechainicio.equals("")) {
            ArrayList<licencia_permiso> auxPermisos = new ArrayList<licencia_permiso>();
            List<licencia_permiso> permisos3 = licencia_permisoLocalServiceUtil.getAll();
            Date inicio = formato.parse(fechainicio);
            for (licencia_permiso lp : permisos3) {
                if (!inicio.after(lp.getFechainicio()) && !inicio.equals(lp.getFechainicio()) || !lp.getUsuariofk().equals(user.getId())) continue;
                auxPermisos.add(lp);
            }
            actionRequest.setAttribute("lista_permisos", auxPermisos);
        } else if (!fechafin.equals("")) {
            ArrayList<licencia_permiso> auxPermisos = new ArrayList<licencia_permiso>();
            List<licencia_permiso> permisos4 = licencia_permisoLocalServiceUtil.getAll();
            Date fin = formato.parse(fechafin);
            for (licencia_permiso lp : permisos4) {
                if (!fin.before(lp.getFechafin()) && !fin.equals(lp.getFechafin()) || !lp.getUsuariofk().equals(user.getId())) continue;
                auxPermisos.add(lp);
            }
            actionRequest.setAttribute("lista_permisos", auxPermisos);
        } else {
            ArrayList<licencia_permiso> auxPermisos = new ArrayList<licencia_permiso>();
            List<licencia_permiso> permisos5 = licencia_permisoLocalServiceUtil.getAll();
            for (licencia_permiso lp : permisos5) {
                if (!lp.getUsuariofk().equals(user.getId())) continue;
                auxPermisos.add(lp);
            }
            actionRequest.setAttribute("lista_permisos", auxPermisos);
        }
        SessionMessages.add((PortletRequest)actionRequest, (String)"No tiene");
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/vistaPermisos2.jsp");
    }

    public void reports(ActionRequest actionRequest, ActionResponse actionResponse) {
        String departamento = ParamUtil.getString((PortletRequest)actionRequest, (String)"departamento");
        String municipio = ParamUtil.getString((PortletRequest)actionRequest, (String)"municipio");
        String despacho2 = ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho");
        String email = ParamUtil.getString((PortletRequest)actionRequest, (String)"email");
        String fi = ParamUtil.getString(actionRequest, "fi");
        String ff = ParamUtil.getString(actionRequest, "ff");
        if(ff.isEmpty() || fi.isEmpty()){
        	ff="";
        	fi="";
        }
        List<licencia_permiso> permisos2 = consultas.getPermisos((String)departamento, (String)municipio, (String)despacho2, (String)email,fi,ff);
        actionRequest.getPortletSession().setAttribute("departamentoP", departamento);
        actionRequest.getPortletSession().setAttribute("municipioP", municipio);
        actionRequest.getPortletSession().setAttribute("despachoP", despacho2);
        actionRequest.getPortletSession().setAttribute("emailP", email);
        actionRequest.getPortletSession().setAttribute("fiP", fi);
        actionRequest.getPortletSession().setAttribute("ffP", ff);
        actionRequest.setAttribute("permisos", (Object)permisos2);
        actionRequest.getPortletSession().setAttribute("permisos", (Object)permisos2);
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/reportes.jsp");
        SessionMessages.add((PortletRequest)actionRequest, (String)"No tiene");
    }

    public void eliminarPermiso(ActionRequest actionRequest, ActionResponse actionResponse) {
        long id = ParamUtil.getLong((PortletRequest)actionRequest, (String)"id");
        try {
            licencia_permiso permiso = licencia_permisoLocalServiceUtil.getlicencia_permiso((long)id);
            permiso.setEstatus(2);
            auditoriaP audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
            audi.setFecha(new Date());
            audi.setId_recurso_modificado(String.valueOf(id));
            audi.setTipo_operacion("ELIMINAR");
            audi.setTipo_recurso(2);
            audi.setUsuario_modifico(actionRequest.getRemoteUser());
            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
            audi.setModificacion("Se elimino el permiso con el id: " + id);
            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
            licencia_permisoLocalServiceUtil.updatelicencia_permiso((licencia_permiso)permiso);
            List<licencia_permiso> permisos2 = consultas.filtroPermisos((long)Long.parseLong(actionRequest.getRemoteUser()), (String)"", (String)"", (long)-1L, null);
            actionRequest.setAttribute("permisos", (Object)permisos2);
            actionRequest.getPortletSession().setAttribute("permisos", (Object)permisos2);
            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/view.jsp");
            SessionMessages.add((PortletRequest)actionRequest, (String)"eliminado");
        }
        catch (PortalException e) {
            e.printStackTrace();
        }
        catch (SystemException e) {
            e.printStackTrace();
        }
    }

    public void eliminarDocencia(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, ParseException {
        long id = ParamUtil.getLong((PortletRequest)actionRequest, (String)"id");
        try {
            Docencia permiso = DocenciaLocalServiceUtil.getDocencia((long)id);
            permiso.setEstatus(0);
            auditoriaP audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
            audi.setFecha(new Date());
            audi.setId_recurso_modificado(String.valueOf(id));
            audi.setTipo_operacion("ELIMINAR");
            audi.setTipo_recurso(3);
            audi.setUsuario_modifico(actionRequest.getRemoteUser());
            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
            audi.setModificacion("Se elimino la docencia con el id: " + id);
            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
            DocenciaLocalServiceUtil.updateDocencia((Docencia)permiso);
            List<Docencia> docencias = consultas.filtroDocencia((long)Long.parseLong(actionRequest.getRemoteUser()), (String)"", (String)"", null);
            actionRequest.setAttribute("docencias", (Object)docencias);
            actionRequest.getPortletSession().setAttribute("docencias", (Object)docencias);
            actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/verDocencias.jsp");
            SessionMessages.add((PortletRequest)actionRequest, (String)"eliminado");
        }
        catch (PortalException e) {
            e.printStackTrace();
        }
        catch (SystemException e) {
            e.printStackTrace();
        }
    }

    public void detallePermiso(ActionRequest actionRequest, ActionResponse actionResponse) {
        long id = ParamUtil.getLong((PortletRequest)actionRequest, (String)"id");
        licencia_permiso permiso = null;
        String tipo_permiso = null;
        User creator = null;
        User mod_user = null;
        usuario user = null;
        try {
            permiso = licencia_permisoLocalServiceUtil.getlicencia_permiso((long)id);
            tipo_permiso = tipoLocalServiceUtil.gettipo((long)permiso.getTipofk()).getDescripcion();
            user = usuarioLocalServiceUtil.getusuario((String)permiso.getUsuariofk());
            creator = UserLocalServiceUtil.getUser((long)permiso.getCreadoPor());
            actionRequest.setAttribute("permiso", (Object)permiso);
            actionRequest.setAttribute("tipo_permiso", (Object)tipo_permiso);
            actionRequest.setAttribute("user", (Object)user);
            actionRequest.setAttribute("creator_username", (Object)(String.valueOf(creator.getContact().getFirstName()) + " " + creator.getContact().getLastName()));
            actionRequest.setAttribute("fecha_inicial", (Object)formatoS.format(permiso.getFechainicio()));
            actionRequest.setAttribute("fecha_final", (Object)formatoS.format(permiso.getFechafin()));
        }
        catch (PortalException e) {
            e.printStackTrace();
        }
        catch (SystemException e) {
            e.printStackTrace();
        }
        try {
            mod_user = UserLocalServiceUtil.getUser((long)permiso.getModificadoPor());
            actionRequest.setAttribute("mod_username", (Object)(String.valueOf(mod_user.getContact().getFirstName()) + " " + mod_user.getContact().getLastName()));
        }
        catch (PortalException e) {
            e.printStackTrace();
        }
        catch (SystemException e) {
            e.printStackTrace();
        }
        despacho Despacho = consultas.obtenerDespachoSel((String)permiso.getDespacho());
        String municipio = consultas.getMunicipio((String)Despacho.getCodigo().substring(0, 5));
        String distrito = consultas.obtenerDistrito((String)Despacho.getCodigo());
        String departamento = consultas.obtenerDepartamento((String)Despacho.getCodigo().substring(0, 2));
        actionRequest.setAttribute("nombreDespacho", (Object)Despacho.getNombre());
        actionRequest.setAttribute("municipio", (Object)municipio);
        actionRequest.setAttribute("distrito", (Object)distrito);
        actionRequest.setAttribute("departamento", (Object)departamento);
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/detallePermiso.jsp");
        SessionMessages.add((PortletRequest)actionRequest, (String)"No tiene");
    }

    public void detalleDocencia(ActionRequest actionRequest, ActionResponse actionResponse) {
        long id = ParamUtil.getLong((PortletRequest)actionRequest, (String)"id");
        Docencia permiso = null;
        User creator = null;
        User mod_user = null;
        usuario user = null;
        try {
            permiso = DocenciaLocalServiceUtil.getDocencia((long)id);
            user = usuarioLocalServiceUtil.getusuario((String)permiso.getUsuario_fk());
            creator = UserLocalServiceUtil.getUser((long)permiso.getCreadoPor());
            actionRequest.setAttribute("permiso", (Object)permiso);
            actionRequest.setAttribute("user", (Object)user);
            actionRequest.setAttribute("creator_username", (Object)(String.valueOf(creator.getContact().getFirstName()) + " " + creator.getContact().getLastName()));
            actionRequest.setAttribute("fecha_inicial", (Object)formatoS.format(permiso.getFechaInicial()));
            actionRequest.setAttribute("fecha_final", (Object)formatoS.format(permiso.getFechaFinal()));
        }
        catch (PortalException e) {
            e.printStackTrace();
        }
        catch (SystemException e) {
            e.printStackTrace();
        }
        try {
            mod_user = UserLocalServiceUtil.getUser((long)permiso.getModificadoPor());
            actionRequest.setAttribute("mod_username", (Object)(String.valueOf(mod_user.getContact().getFirstName()) + " " + mod_user.getContact().getLastName()));
        }
        catch (PortalException e) {
            e.printStackTrace();
        }
        catch (SystemException e) {
            e.printStackTrace();
        }
        despacho Despacho = consultas.obtenerDespachoSel((String)user.getDespachofk());
        String municipio = consultas.getMunicipio((String)Despacho.getCodigo().substring(0, 5));
        String distrito = consultas.obtenerDistrito((String)Despacho.getCodigo().substring(0, 5));
        String departamento = consultas.obtenerDepartamento((String)Despacho.getCodigo().substring(0, 2));
        actionRequest.setAttribute("nombreDespacho", (Object)Despacho.getNombre());
        actionRequest.setAttribute("municipio", (Object)municipio);
        actionRequest.setAttribute("distrito", (Object)distrito);
        actionRequest.setAttribute("departamento", (Object)departamento);
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/detalleDocencia.jsp");
        SessionMessages.add((PortletRequest)actionRequest, (String)"No tiene");
    }

    public void editarPermiso(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException, SystemException {
        long id = ParamUtil.getLong((PortletRequest)actionRequest, (String)"id");
        licencia_permiso permiso = licencia_permisoLocalServiceUtil.getlicencia_permiso((long)id);
        usuario user = usuarioLocalServiceUtil.getusuario((String)permiso.getUsuariofk());
        actionRequest.setAttribute("permiso", (Object)permiso);
        actionRequest.getPortletSession().setAttribute("userName", (Object)(String.valueOf(user.getNomb()) + " " + user.getApe()));
        actionRequest.getPortletSession().setAttribute("identificacion", (Object)user.getId());
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/editarPermiso.jsp");
        SessionMessages.add((PortletRequest)actionRequest, (String)"No tiene");
    }

    public void editarPermiso2(ActionRequest actionRequest, ActionResponse actionResponse) {
        long id = ParamUtil.getLong((PortletRequest)actionRequest, (String)"id");
        String log = "";
        try {
            licencia_permiso permiso = licencia_permisoLocalServiceUtil.getlicencia_permiso((long)id);
            int Status = 1;
            if (ParamUtil.getString((PortletRequest)actionRequest, (String)"cancelar").equalsIgnoreCase("cancelado")) {
                Status = 0;
            }
            if (permiso.getTipofk() != ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo")) {
                log = String.valueOf(log) + "Se cambio el tipo de permiso de: " + tipoLocalServiceUtil.gettipo((long)permiso.getTipofk()).getDescripcion().toUpperCase() + " por: " + tipoLocalServiceUtil.gettipo((long)ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo")).getDescripcion().toUpperCase();
            }
            if (!permiso.getActoadmin().equalsIgnoreCase(ParamUtil.getString((PortletRequest)actionRequest, (String)"actoAdmin"))) {
                log = String.valueOf(log) + " Se cambio el acto administrativo de: " + permiso.getActoadmin() + " por: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"actoAdmin");
            }
            if (!permiso.getFechainicio().equals(ParamUtil.getDate((PortletRequest)actionRequest, (String)"f_inicial", (DateFormat)formatoS))) {
                log = String.valueOf(log) + " Se cambio la fecha inicial del permiso de: " + formatoS.format(permiso.getFechainicio()) + " por: " + formatoS.format(ParamUtil.getDate((PortletRequest)actionRequest, (String)"f_inicial", (DateFormat)formatoS));
            }
            if (!permiso.getFechafin().equals(ParamUtil.getDate((PortletRequest)actionRequest, (String)"f_final", (DateFormat)formatoS))) {
                log = String.valueOf(log) + " Se cambio la fecha final del permiso de: " + formatoS.format(permiso.getFechafin()) + " por: " + formatoS.format(ParamUtil.getDate((PortletRequest)actionRequest, (String)"f_final", (DateFormat)formatoS));
            }
            if(permiso.getHoras()!=ParamUtil.getInteger(actionRequest, "horas")){
            	log = String.valueOf(log) + " Se cambiaron las horas laborales de: " + permiso.getHoras() + " por: " + ParamUtil.getInteger(actionRequest, "horas");
            }
            if(permiso.getMinutos()!=ParamUtil.getInteger(actionRequest, "minutos")){
            	log = String.valueOf(log) + " Se cambiaron los minutos laborales de: " + permiso.getMinutos() + " por: " + ParamUtil.getInteger(actionRequest, "minutos");
            }
            if (permiso.getEstatus() != Status) {
                log = String.valueOf(log) + " Se cancelo el permiso";
            }
            permiso.setActoadmin(ParamUtil.getString((PortletRequest)actionRequest, (String)"actoAdmin"));
            permiso.setTipofk(ParamUtil.getLong((PortletRequest)actionRequest, (String)"tipo"));
            permiso.setFechainicio(ParamUtil.getDate((PortletRequest)actionRequest, (String)"f_inicial", (DateFormat)formatoS));
            permiso.setFechafin(ParamUtil.getDate((PortletRequest)actionRequest, (String)"f_final", (DateFormat)formatoS));
            permiso.setHoras(ParamUtil.getInteger(actionRequest, "horas"));
            permiso.setMinutos(ParamUtil.getInteger(actionRequest, "minutos"));
            permiso.setModificadoPor(Long.parseLong(actionRequest.getRemoteUser()));
            permiso.setEstatus(Status);
            permiso.setFechaRegistro(new Date());
            permiso = licencia_permisoLocalServiceUtil.updatelicencia_permiso((licencia_permiso)permiso);
            actionRequest.setAttribute("permiso", (Object)permiso);
            auditoriaP auditoria = auditoriaPLocalServiceUtil.createauditoriaP(0L);
            auditoria.setFecha(new Date());
            auditoria.setTipo_recurso(2);
            auditoria.setId_recurso_modificado(String.valueOf(id));
            auditoria.setTipo_operacion("MODIFICAR");
            auditoria.setUsuario_modifico(actionRequest.getRemoteUser());
            auditoria.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
            auditoria.setModificacion(log);
            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)auditoria);
            SessionMessages.add((PortletRequest)actionRequest, (String)"editado");
        }
        catch (PortalException e) {
            SessionErrors.add((PortletRequest)actionRequest, (String)"noEncontrado");
            e.printStackTrace();
        }
        catch (SystemException e) {
            SessionErrors.add((PortletRequest)actionRequest, (String)"noEditado");
            e.printStackTrace();
        }
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/editarPermiso.jsp");
    }

    public void editarDocencia(ActionRequest actionRequest, ActionResponse actionResponse) {
        long id = ParamUtil.getLong((PortletRequest)actionRequest, (String)"id");
        try {
            Docencia permiso = DocenciaLocalServiceUtil.getDocencia((long)id);
            usuario user = usuarioLocalServiceUtil.getusuario((String)permiso.getUsuario_fk());
            actionRequest.setAttribute("permiso", (Object)permiso);
            actionRequest.getPortletSession().setAttribute("userName", (Object)(String.valueOf(user.getNomb()) + " " + user.getApe()));
            actionRequest.getPortletSession().setAttribute("identificacion", (Object)user.getId());
        }
        catch (PortalException e) {
            e.printStackTrace();
        }
        catch (SystemException e) {
            e.printStackTrace();
        }
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/editarDocencia.jsp");
        SessionMessages.add((PortletRequest)actionRequest, (String)"No tiene");
    }

    public void editarDocencia2(ActionRequest actionRequest, ActionResponse actionResponse) {
        long id = ParamUtil.getLong((PortletRequest)actionRequest, (String)"id");
        String log = "";
        try {
            Docencia permiso = DocenciaLocalServiceUtil.getDocencia((long)id);
            if (!permiso.getFechaInicial().equals(ParamUtil.getDate((PortletRequest)actionRequest, (String)"f_inicial", (DateFormat)formatoS))) {
                log = String.valueOf(log) + " Se cambio la fecha inicial de la docencia de: " + formatoS.format(permiso.getFechaInicial()) + " por: " + formatoS.format(ParamUtil.getDate((PortletRequest)actionRequest, (String)"f_inicial", (DateFormat)formatoS));
            }
            if (!permiso.getFechaFinal().equals(ParamUtil.getDate((PortletRequest)actionRequest, (String)"f_final", (DateFormat)formatoS))) {
                log = String.valueOf(log) + " Se cambio la fecha final de la docencia de: " + formatoS.format(permiso.getFechaFinal()) + " por: " + formatoS.format(ParamUtil.getDate((PortletRequest)actionRequest, (String)"f_final", (DateFormat)formatoS));
            }
            if (!permiso.getMateria().equalsIgnoreCase(ParamUtil.getString((PortletRequest)actionRequest, (String)"materia"))) {
                log = String.valueOf(log) + " Se cambio la materia de la docencia de: " + permiso.getMateria() + " por: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"materia");
            }
            if (permiso.getHoras() != ParamUtil.getInteger(actionRequest, "horas")) {
                log = String.valueOf(log) + " Se cambio las horas de docencia de: " + permiso.getHoras() + " por: " + ParamUtil.getInteger(actionRequest, "horas");
            }
            if (permiso.getMinutos() != ParamUtil.getInteger(actionRequest, "minutos")) {
                log = String.valueOf(log) + " Se cambio los minutos de docencia de: " + permiso.getMinutos() + " por: " + ParamUtil.getInteger(actionRequest, "minutos");
            }
            if (!permiso.getInstitucion().equalsIgnoreCase(ParamUtil.getString((PortletRequest)actionRequest, (String)"institucion"))) {
                log = String.valueOf(log) + " Se cambio la institucion de la docencia de: " + permiso.getInstitucion() + " por: " + ParamUtil.getString((PortletRequest)actionRequest, (String)"institucion");
            }
            permiso.setMateria(ParamUtil.getString((PortletRequest)actionRequest, (String)"materia"));
            permiso.setInstitucion(ParamUtil.getString((PortletRequest)actionRequest, (String)"institucion"));
            permiso.setFechaInicial(ParamUtil.getDate((PortletRequest)actionRequest, (String)"f_inicial", (DateFormat)formatoS));
            permiso.setFechaFinal(ParamUtil.getDate((PortletRequest)actionRequest, (String)"f_final", (DateFormat)formatoS));
            permiso.setHoras(ParamUtil.getInteger(actionRequest, "horas"));
            permiso.setMinutos(ParamUtil.getInteger(actionRequest, "minutos"));
            permiso.setModificadoPor(Long.parseLong(actionRequest.getRemoteUser()));
            permiso.setFechaRegistro(new Date());
            permiso = DocenciaLocalServiceUtil.updateDocencia((Docencia)permiso);
            actionRequest.setAttribute("permiso", (Object)permiso);
            auditoriaP auditoria = auditoriaPLocalServiceUtil.createauditoriaP(0L);
            auditoria.setFecha(new Date());
            auditoria.setTipo_recurso(3);
            auditoria.setId_recurso_modificado(String.valueOf(id));
            auditoria.setTipo_operacion("MODIFICAR");
            auditoria.setUsuario_modifico(actionRequest.getRemoteUser());
            auditoria.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
            auditoria.setModificacion(log);
            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)auditoria);
            SessionMessages.add((PortletRequest)actionRequest, (String)"editado");
        }
        catch (PortalException e) {
            SessionErrors.add((PortletRequest)actionRequest, (String)"noEncontrado");
            e.printStackTrace();
        }
        catch (SystemException e) {
            SessionErrors.add((PortletRequest)actionRequest, (String)"noEditado");
            e.printStackTrace();
        }
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/editarDocencia.jsp");
    }

    public void reportesDocencia(ActionRequest actionRequest, ActionResponse actionResponse) {
        String departamento = ParamUtil.getString((PortletRequest)actionRequest, (String)"departamento");
        String municipio = ParamUtil.getString((PortletRequest)actionRequest, (String)"municipio");
        String despacho2 = ParamUtil.getString((PortletRequest)actionRequest, (String)"despacho");
        String email = ParamUtil.getString((PortletRequest)actionRequest, (String)"email");
        String fi = ParamUtil.getString((PortletRequest)actionRequest, (String)"fi");
        String ff = ParamUtil.getString((PortletRequest)actionRequest, (String)"ff");
        if(ff.isEmpty() || fi.isEmpty()){
        	ff="";
        	fi="";
        }
        List<Docencia> permisosDocencia = consultas.getPermisosDocencia((String)departamento, (String)municipio, (String)despacho2, (String)email,fi,ff);
        actionRequest.getPortletSession().setAttribute("departamentoD", departamento);
        actionRequest.getPortletSession().setAttribute("municipioD", municipio);
        actionRequest.getPortletSession().setAttribute("despachoD", despacho2);
        actionRequest.getPortletSession().setAttribute("emailD", email);
        actionRequest.getPortletSession().setAttribute("fiD", fi);
        actionRequest.getPortletSession().setAttribute("ffD", ff);
        actionRequest.setAttribute("permisosDocencia", (Object)permisosDocencia);
        actionRequest.getPortletSession().setAttribute("permisosDocencia", (Object)permisosDocencia);
        actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/reportesDocencia.jsp");
        SessionMessages.add((PortletRequest)actionRequest, (String)"No tiene");
    }

    public void cargarExcelP(ActionRequest actionRequest, ActionResponse actionResponse) throws FileUploadException, IOException, NumberFormatException, PortalException, SystemException{
    	if(PortletFileUpload.isMultipartContent(actionRequest)){
    		List<String> Errores = new ArrayList<String>();
    		String usuarioAgrego = actionRequest.getRemoteUser();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20000000); // bytes

			File repositoryPath = new File("/tmp");
			factory.setRepository(repositoryPath);
			PortletFileUpload upload = new PortletFileUpload(factory);
			upload.setSizeMax(20000000); // bytes
			
			List fileItemsList = upload.parseRequest(actionRequest);
			
			
			if(fileItemsList.size()==7){
				FileItem fileItem = (FileItem) fileItemsList.get(5);
				String despacho = fileItem.getString("UTF-8");
				fileItem = (FileItem) fileItemsList.get(6);
				InputStream archivo = (InputStream) fileItem.getInputStream();
				Errores = decoArchivo.readExcelP(archivo,despacho,usuarioAgrego);
			}
			if(fileItemsList.size()==6){
				FileItem fileItem = (FileItem) fileItemsList.get(4);
				String despacho = fileItem.getString("UTF-8");
				fileItem = (FileItem) fileItemsList.get(5);
				InputStream archivo = (InputStream) fileItem.getInputStream();
				Errores = decoArchivo.readExcelP(archivo,despacho,usuarioAgrego);
			}
			
			if(Errores.size()>0){
				SessionErrors.add((PortletRequest)actionRequest, (String)"errorExcelP");
				actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/permisosexcel.jsp");
				actionRequest.getPortletSession().setAttribute("ErroresExcelP", Errores);
			}else{
				SessionMessages.add((PortletRequest)actionRequest, (String)"correctoExcelP");
			}
			
    	}
    }
    
    public void cargarExcelD(ActionRequest actionRequest, ActionResponse actionResponse) throws FileUploadException, IOException, NumberFormatException, PortalException, SystemException{
    	if(PortletFileUpload.isMultipartContent(actionRequest)){
    		List<String> Errores = new ArrayList<String>();
    		String usuarioAgrego = actionRequest.getRemoteUser();
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20000000); // bytes

			File repositoryPath = new File("/tmp");
			factory.setRepository(repositoryPath);
			PortletFileUpload upload = new PortletFileUpload(factory);
			upload.setSizeMax(20000000); // bytes
			
			List fileItemsList = upload.parseRequest(actionRequest);
			
			
			if(fileItemsList.size()==7){
				FileItem fileItem = (FileItem) fileItemsList.get(5);
				String despacho = fileItem.getString("UTF-8");
				fileItem = (FileItem) fileItemsList.get(6);
				InputStream archivo = (InputStream) fileItem.getInputStream();
				Errores = decoArchivo.readExcelD(archivo,despacho,usuarioAgrego);
			}
			if(fileItemsList.size()==6){
				FileItem fileItem = (FileItem) fileItemsList.get(4);
				String despacho = fileItem.getString("UTF-8");
				fileItem = (FileItem) fileItemsList.get(5);
				InputStream archivo = (InputStream) fileItem.getInputStream();
				Errores = decoArchivo.readExcelD(archivo,despacho,usuarioAgrego);
			}
			
			if(Errores.size()>0){
				SessionErrors.add((PortletRequest)actionRequest, (String)"errorExcelD");
				actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/docenciasexcel.jsp");
				actionRequest.getPortletSession().setAttribute("ErroresExcelD", Errores);
			}else{
				List<Docencia> docencias = consultas.filtroDocencia((long)Long.parseLong(actionRequest.getRemoteUser()), (String)"", (String)"", null);
				actionRequest.setAttribute("docencias", (Object)docencias);
				actionRequest.getPortletSession().setAttribute("docencias", (Object)docencias);
				SessionMessages.add((PortletRequest)actionRequest, (String)"correctoExcelD");
				actionResponse.setRenderParameter("mvcPath", "/html/servidoresjudiciales/verDocencias.jsp");
			}
			
    	}
    }
}