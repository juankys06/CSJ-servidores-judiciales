package co.com.csj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;

import co.com.csj.model.alerta;
import co.com.csj.model.auditoriaP;
import co.com.csj.model.permisos;
import co.com.csj.modelos.consultas;
import co.com.csj.modelos.localizacion;
import co.com.csj.service.alertaLocalServiceUtil;
import co.com.csj.service.auditoriaPLocalServiceUtil;
import co.com.csj.service.permisosLocalServiceUtil;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class administracion
 */
public class administracion extends MVCPortlet {

 	public void buscarAuditoria(ActionRequest request, ActionResponse response) {
        int tipoR = ParamUtil.getInteger((PortletRequest)request, (String)"tipoRecurso");
        String FI = ParamUtil.getString((PortletRequest)request, (String)"fechaInicial");
        String FF = ParamUtil.getString((PortletRequest)request, (String)"fechaFinal");
        String correo = ParamUtil.getString((PortletRequest)request, (String)"correo");
        String id = ParamUtil.getString((PortletRequest)request, (String)"idRecurso");
        int limpiar = ParamUtil.getInteger((PortletRequest)request, (String)"limpiar");
        System.out.println(">>>>>>>>>>limpiar" + limpiar);
        List<auditoriaP> audi = new ArrayList<auditoriaP>();
        if (limpiar != 1) {
            try {
                audi = consultas.getAuditoria((int)tipoR, (String)FI, (String)FF, (String)id, (String)correo);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        request.getPortletSession().setAttribute("tipoR", String.valueOf(tipoR));
        request.getPortletSession().setAttribute("fi", FI);
        request.getPortletSession().setAttribute("ff", FF);
        request.getPortletSession().setAttribute("correo", correo);
        request.getPortletSession().setAttribute("id", id);
        request.getPortletSession().setAttribute("auditoria", audi);
        response.setRenderParameter("mvcPath", "/html/administracion/auditoria/view.jsp");
    }
 
 @ProcessAction(name="asignarUsuario")
	public void asignarUsuario(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException, NumberFormatException, PortalException {
		
		String userid = ParamUtil.getString(actionRequest, "usuarios");
		String cargo = ParamUtil.getString(actionRequest, "cargo");
		String departamento = ParamUtil.getString(actionRequest, "departamento");
		String municipio = ParamUtil.getString(actionRequest, "municipio");
		boolean bandera = false;
		
		try {
			List<permisos> lista = permisosLocalServiceUtil.getpermisoses(-1, -1);
			for(permisos gu : lista){
				if(cargo.equalsIgnoreCase("Permisos por Distrito") || cargo.equalsIgnoreCase("Permisos y Docencia por Distrito")){
					if(gu.getUsuario().equalsIgnoreCase(userid) && !gu.getCargo().equalsIgnoreCase(cargo)){
						bandera=true;
						break;
					}
					if( (gu.getUsuario().equalsIgnoreCase(userid) && gu.getCargo().equalsIgnoreCase("Permisos por Distrito") && gu.getD_m().equalsIgnoreCase(departamento)) || (gu.getUsuario().equalsIgnoreCase(userid) && gu.getCargo().equalsIgnoreCase("Permisos y Docencia por Distrito") && gu.getD_m().equalsIgnoreCase(departamento))){
						bandera=true;
						break;
					}
				}else{
					if(gu.getUsuario().equalsIgnoreCase(userid)){
						bandera=true;
						break;
					}
				}
			}
			
			if(bandera){
				SessionErrors.add(actionRequest, "yaEsta");
				actionResponse.setRenderParameter("mvcPath", "/html/administracion/usuariospermisos/view.jsp");
			}else{
				permisos usuario = permisosLocalServiceUtil.createpermisos(0L);
				usuario.setUsuario(userid);
				usuario.setCargo(cargo);
				if(cargo.equalsIgnoreCase("Juez"))
					usuario.setD_m(municipio);
				if(cargo.equalsIgnoreCase("Magistrado") || cargo.equalsIgnoreCase("Magistrado Seccional") || cargo.equalsIgnoreCase("Permisos por Distrito") || cargo.equalsIgnoreCase("Permisos y Docencia por Distrito"))
					usuario.setD_m(departamento);
				usuario.setCreacion(new Date());
				
				String log = "";
				auditoriaP audi;
				audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
	            audi.setFecha(new Date());
	            audi.setTipo_recurso(4);
	            audi.setTipo_operacion("AGREGAR");
	            audi.setId_recurso_modificado(usuario.getUsuario());
	            audi.setUsuario_modifico(actionRequest.getRemoteUser());
	            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
	            
	            String despar = "";
		       	String muni = "";
		       	List<localizacion> departamentos = consultas.obtenerMDepartamentos();
		    	List<localizacion> municipios = consultas.obtenerTodosMuni();
		       	if(usuario.getCargo().equalsIgnoreCase("Magistrado") || usuario.getCargo().equalsIgnoreCase("Magistrado Seccional") || usuario.getCargo().equalsIgnoreCase("Permisos por Distrito") || usuario.getCargo().equalsIgnoreCase("Permisos y Docencia por Distrito"))
		       		for(localizacion d : departamentos)
		       			if(d.getCod_dane().equalsIgnoreCase(usuario.getD_m()) && d.getCod_dane_departamento().equalsIgnoreCase(usuario.getD_m()))
		       				despar=d.getNombre();

		       	if(usuario.getCargo().equalsIgnoreCase("Juez")){
		       		for(localizacion d : departamentos)
		       			if(d.getCod_dane().equalsIgnoreCase(usuario.getD_m().substring(0, 2)) && d.getCod_dane_departamento().equalsIgnoreCase(usuario.getD_m().substring(0, 2)))
		       				despar = d.getNombre();
		       		
		       		for(localizacion d : municipios)
		       			if(usuario.getD_m().equalsIgnoreCase(d.getCod_dane_departamento()+d.getCod_dane()))
		       				muni=d.getNombre();
		       	}
	            
	            log = "Se creo un usuario";
	            log = String.valueOf(log) + " Con el Cargo: " + usuario.getCargo();
	            log = String.valueOf(log) + " asignado al usuario con correo: " + UserLocalServiceUtil.getUser(Long.parseLong(usuario.getUsuario())).getEmailAddress();
	            log = String.valueOf(log) + " Con Departamento: " + despar;
	            log = String.valueOf(log) + " y con Municipio: " + muni;
	            audi.setModificacion(log);
	            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
				
				permisosLocalServiceUtil.addpermisos(usuario);
				SessionMessages.add(actionRequest, "guardo");
				actionResponse.setRenderParameter("mvcPath", "/html/administracion/usuariospermisos/view.jsp");
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	@ProcessAction(name="eliminarUsuario")
	public void eliminarUsuario(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException, NumberFormatException, PortalException, SystemException {
		
		String id = ParamUtil.getString(actionRequest, "id");
		try {
			permisos usu = permisosLocalServiceUtil.getpermisos(Integer.parseInt(id));
			
			String log = "";
			auditoriaP audi;
			audi = auditoriaPLocalServiceUtil.createauditoriaP(0L);
            audi.setFecha(new Date());
            audi.setTipo_recurso(4);
            audi.setTipo_operacion("ELIMINAR");
            audi.setId_recurso_modificado(usu.getUsuario());
            audi.setUsuario_modifico(actionRequest.getRemoteUser());
            audi.setCorreo(UserLocalServiceUtil.getUser((long)Long.parseLong(actionRequest.getRemoteUser())).getEmailAddress());
            
            log = "Se Elimino al usuario";
            log = String.valueOf(log) + " Con el Cargo: " + usu.getCargo();
            log = String.valueOf(log) + " y con correo: " + UserLocalServiceUtil.getUser(Long.parseLong(usu.getUsuario())).getEmailAddress();
            audi.setModificacion(log);
            auditoriaPLocalServiceUtil.addauditoriaP((auditoriaP)audi);
			
			permisosLocalServiceUtil.deletepermisos(usu);
			SessionMessages.add(actionRequest, "eliminado");
			actionResponse.setRenderParameter("mvcPath", "/html/administracion/usuariospermisos/view.jsp");
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException,PortletException {
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
		String cmd = ParamUtil.getString(resourceRequest, "action");
		
		if(cmd.equals("filtrar")){
			String departamento = ParamUtil.getString(request, "departamento");
			
			JSONArray arra = JSONFactoryUtil.createJSONArray();
			for(localizacion d : consultas.obtenerMunicipios(departamento)){
					JSONObject json = JSONFactoryUtil.createJSONObject();
					json.put("id", d.getCod_dane_departamento()+d.getCod_dane());
					json.put("nombre", d.getNombre());
					arra.put(json);
				
			}
			response.getWriter().println(arra.toString());
		}else if(cmd.equals("exportar")){
			List<permisos> usuariosPermisos = (List<permisos>) resourceRequest.getPortletSession().getAttribute("usuariosPermisos");
			System.out.println(usuariosPermisos.size());
			FileOutputStream fichero = new FileOutputStream("C:\\reportes\\usuariosCargos.xls");
			Workbook wb = ExporterUtil.INSTANCE.exportCargosToExcel(usuariosPermisos);
			wb.write(fichero);
			resourceResponse.setContentType("application/vnd.ms-excel");
			
			HttpServletResponse res = PortalUtil.getHttpServletResponse(resourceResponse);
			res.setHeader("Content-Disposition", "attachment; filename=usuariosCargos.xls");
			OutputStream out = resourceResponse.getPortletOutputStream();
			InputStream in = new FileInputStream(new File("C:\\reportes\\usuariosCargos.xls"));
			IOUtils.copy(in, out);
			out.flush();
			in.close();
			out.close();
		}else if(cmd.equals("exportarNoReportan")){
			int trimestre = ParamUtil.getInteger(resourceRequest, "trimestre");
			System.out.println(trimestre);
			FileOutputStream fichero = new FileOutputStream("C:\\reportes\\UsuariosNoReportanPermisosTrimestreActual.xls");
			Workbook wb;
			try {
				wb = ExporterUtil.INSTANCE.exportNoReportanPermisosToExcel(trimestre);
				wb.write(fichero);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resourceResponse.setContentType("application/vnd.ms-excel");
			
			HttpServletResponse res = PortalUtil.getHttpServletResponse(resourceResponse);
			res.setHeader("Content-Disposition", "attachment; filename=UsuariosNoReportanPermisosTrimestreActual.xls");
			OutputStream out = resourceResponse.getPortletOutputStream();
			InputStream in = new FileInputStream(new File("C:\\reportes\\UsuariosNoReportanPermisosTrimestreActual.xls"));
			IOUtils.copy(in, out);
			out.flush();
			in.close();
			out.close();
		}else if(cmd.equals("exportarNoReportanD")){
			int semestre = ParamUtil.getInteger(resourceRequest, "semestre");
			FileOutputStream fichero = new FileOutputStream("C:\\reportes\\UsuariosNoReportanDocenciasTrimestreActual.xls");
			Workbook wb;
			try {
				wb = ExporterUtil.INSTANCE.exportNoReportanDocenciasToExcel(semestre);
				wb.write(fichero);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resourceResponse.setContentType("application/vnd.ms-excel");
			
			HttpServletResponse res = PortalUtil.getHttpServletResponse(resourceResponse);
			res.setHeader("Content-Disposition", "attachment; filename=UsuariosNoReportanDocenciasTrimestreActual.xls");
			OutputStream out = resourceResponse.getPortletOutputStream();
			InputStream in = new FileInputStream(new File("C:\\reportes\\UsuariosNoReportanDocenciasTrimestreActual.xls"));
			IOUtils.copy(in, out);
			out.flush();
			in.close();
			out.close();
		}else if(cmd.equals("alertaGuardarP")){
			String asunto = ParamUtil.getString(resourceRequest, "asuntoAP");
			String contenido = ParamUtil.getString(resourceRequest, "contenidoAP");
			
			try {
				alerta alertaP = alertaLocalServiceUtil.getalerta("permisos");
				alertaP.setAsunto(asunto);
				alertaP.setMensaje(contenido);
				alertaLocalServiceUtil.updatealerta(alertaP);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("alertaGuardarD")){
			String asunto = ParamUtil.getString(resourceRequest, "asuntoAP");
			String contenido = ParamUtil.getString(resourceRequest, "contenidoAP");
			
			try {
				alerta alertaP = alertaLocalServiceUtil.getalerta("docencias");
				alertaP.setAsunto(asunto);
				alertaP.setMensaje(contenido);
				alertaLocalServiceUtil.updatealerta(alertaP);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(cmd.equals("reporteAuditoria")){
			
			String tipor = (String) resourceRequest.getPortletSession().getAttribute("tipoR");
			String fi = (String) resourceRequest.getPortletSession().getAttribute("fi");
			String ff = (String) resourceRequest.getPortletSession().getAttribute("ff");
			String correo = (String) resourceRequest.getPortletSession().getAttribute("correo");
			String id = (String) resourceRequest.getPortletSession().getAttribute("id");
			List<auditoriaP> audi = (List<auditoriaP>) resourceRequest.getPortletSession().getAttribute("auditoria");
			
			FileOutputStream fichero = new FileOutputStream("C:\\reportes\\ReporteAuditoriaPermisos.xls");
			Workbook wb;
			try {
				wb = ExporterUtil.INSTANCE.exportReporteAuditoria(tipor,fi,ff,correo,id,audi);
				wb.write(fichero);
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resourceResponse.setContentType("application/vnd.ms-excel");
			
			HttpServletResponse res = PortalUtil.getHttpServletResponse(resourceResponse);
			res.setHeader("Content-Disposition", "attachment; filename=ReporteAuditoriaPermisos.xls");
			OutputStream out = resourceResponse.getPortletOutputStream();
			InputStream in = new FileInputStream(new File("C:\\reportes\\ReporteAuditoriaPermisos.xls"));
			IOUtils.copy(in, out);
			out.flush();
			in.close();
			out.close();
		}
	}
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse){
		try {
			List<permisos> usuariosPermisos = permisosLocalServiceUtil.getpermisoses(-1, -1);
			renderRequest.setAttribute("usuariosPermisos", usuariosPermisos);
			renderRequest.getPortletSession().setAttribute("usuariosPermisos", usuariosPermisos);
			super.doView(renderRequest, renderResponse);
		} catch (SystemException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PortletException e) {
			e.printStackTrace();
		}
	}
	
	public void buscar(ActionRequest actionRequest, ActionResponse actionResponse){
		String cargo = ParamUtil.getString(actionRequest, "cargo");
		String email = ParamUtil.getString(actionRequest, "email");
		String nombre = ParamUtil.getString(actionRequest, "nombre");
		
		actionRequest.setAttribute("usuariosPermisos", consultas.getUsuariosPermisos(cargo, email, nombre));
		actionRequest.getPortletSession().setAttribute("usuariosPermisos", consultas.getUsuariosPermisos(cargo, email, nombre));
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/usuariospermisos/view.jsp");
	}

	public void enviarAlertaP(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException{
		int trimestre = ParamUtil.getInteger(actionRequest, "trimestre");
		List<User> usuarios = consultas.getUsuariosNoRegistran(trimestre);
		List<String> emails = new ArrayList<String>();
		String correo = "";
		alerta alertP = alertaLocalServiceUtil.getalerta("permisos");
		boolean esta = false;
		for(User u :usuarios){
			esta =false;
			correo = u.getEmailAddress().replaceAll("-[0-9]+@", "@");
			for(String s : emails){
				if(s.equalsIgnoreCase(correo)){
					esta = true;
					break;
				}
			}
			if(!esta)
				emails.add(correo);
		}
		for(String s : emails){
			MailMessage mensaje = new MailMessage();
			try {
				mensaje.setFrom(new InternetAddress("soportepaginaweb@cendoj.ramajudicial.gov.co", "Rama Judicial"));
				mensaje.setTo(new InternetAddress(s));
				mensaje.setSubject(alertP.getAsunto());
				mensaje.setBody(alertP.getMensaje());
				/*mensaje.setHTMLFormat(true);*/
				MailServiceUtil.sendEmail(mensaje);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/alertas/viewP.jsp");
	}
	
	public void enviarAlertaD(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException{
		int trimestre = ParamUtil.getInteger(actionRequest, "trimestre");
		List<User> usuarios = consultas.getUsuariosNoRegistranD(trimestre);
		List<String> emails = new ArrayList<String>();
		String correo = "";
		alerta alertP = alertaLocalServiceUtil.getalerta("docencias");
		boolean esta = false;
		for(User u :usuarios){
			esta =false;
			correo = u.getEmailAddress().replaceAll("-[0-9]+@", "@");
			for(String s : emails){
				if(s.equalsIgnoreCase(correo)){
					esta = true;
					break;
				}
			}
			if(!esta)
				emails.add(correo);
		}
		for(String s : emails){
			MailMessage mensaje = new MailMessage();
			try {
				mensaje.setFrom(new InternetAddress("soportepaginaweb@cendoj.ramajudicial.gov.co", "Rama Judicial"));
				mensaje.setTo(new InternetAddress(s));
				mensaje.setSubject(alertP.getAsunto());
				mensaje.setBody(alertP.getMensaje());
				/*mensaje.setHTMLFormat(true);*/
				MailServiceUtil.sendEmail(mensaje);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/alertas/viewD.jsp");
	}
	
	public void trimestreActualP(ActionRequest actionRequest, ActionResponse actionResponse){
		actionRequest.getPortletSession().removeAttribute("trimestreP");
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/alertas/viewP.jsp");	
	}
	
	public void semestreActualD(ActionRequest actionRequest, ActionResponse actionResponse){
		actionRequest.getPortletSession().removeAttribute("semestreD");
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/alertas/viewD.jsp");
	}
	
	public void trimestreAnteriorP(ActionRequest actionRequest, ActionResponse actionResponse){
		int trimestreP = ParamUtil.getInteger(actionRequest, "trimestre");
		if(trimestreP==0)
			trimestreP=4;
		actionRequest.getPortletSession().setAttribute("trimestreP", String.valueOf(trimestreP));
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/alertas/viewP.jsp");	
		
	}
	
	public void semestreAnteriorD(ActionRequest actionRequest, ActionResponse actionResponse){
		int semestreD = ParamUtil.getInteger(actionRequest, "semestre");
		if(semestreD==0)
			semestreD=2;
		actionRequest.getPortletSession().setAttribute("semestreD", String.valueOf(semestreD));
		actionResponse.setRenderParameter("mvcPath", "/html/administracion/alertas/viewD.jsp");
		
	}
}
