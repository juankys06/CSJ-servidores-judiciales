<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri = "http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri = "http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri = "http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri = "http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri = "http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@page import = "com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import = "com.liferay.portal.kernel.util.ListUtil"%>
<%@page import = "java.util.List"%>
<%@page import = "java.text.DateFormat" %>
<%@page import = "java.text.SimpleDateFormat" %>
<%@page import = "co.com.csj.model.Docencia" %>
<%@page import = "co.com.csj.model.tipo" %>
<%@page import = "co.com.csj.model.usuario" %>
<%@page import = "co.com.csj.modelos.consultas"%>
<%@page import = "co.com.csj.modelos.localizacion"%>
<%@page import = "co.com.csj.service.DocenciaLocalServiceUtil" %>
<%@page import = "co.com.csj.service.usuarioLocalServiceUtil" %>
<%@page import = "co.com.csj.model.permisos"%>
<%@page import = "co.com.csj.service.permisosLocalServiceUtil"%>

<portlet:defineObjects />

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/servidoresjudiciales/verDocencias.jsp"/>
</liferay-portlet:renderURL>
<portlet:actionURL name="filtroDocencias" var="filtroDocencia"></portlet:actionURL>
<portlet:resourceURL var="exportarExcel">
	<portlet:param name="action" value="docenciasbyUserToExcel" />
</portlet:resourceURL>

<%
	Date hoy = new Date();
	int quarter = ((hoy.getMonth()-1) / 6) + 1;
	permisos login = permisosLocalServiceUtil.getByUser(request.getRemoteUser());
	List<permisos> loginR = permisosLocalServiceUtil.getByUserR(request.getRemoteUser());
	if(login != null){
		List<Docencia> permisosAux = (List<Docencia>)renderRequest.getPortletSession().getAttribute("docencias");
		List<Docencia> permisos = new ArrayList<Docencia>();
		for(Docencia p : permisosAux){
			for(permisos l : loginR){
				if(l.getD_m().equalsIgnoreCase(p.getDespacho().substring(0, l.getD_m().length()))){
					permisos.add(p);
				}
			}
		}
%>
<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/servidoresjudiciales/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<liferay-ui:success key="eliminado" message="La Docecia ha sido eliminada." />
	<liferay-ui:success key="correctoExcelD" message="El archivo Excel de docencias se a cargado satisfactoriamente" />
	<div class="container">
		<div class="row">
			<form method="post" action="${ filtroDocencia }">
				<div class="col-lg-3">
					<div class="col-lg-12">
						<label class="label-form" for="fechaInicial">Fecha Inicial</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" type="date" name="fechaInicial" id="fechaInicial">
					</div>
				</div>
				<div class="col-lg-3">
					<div class="col-lg-12">
						<label class="label-form" for="fechaFinal">Fecha Final</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" type="date" name="fechaFinal" id="fechaFinal">
					</div>
					<input style="display: none" type="text" name="validarF" id="validarF" required>
				</div>
				<div class="col-lg-3">
					<div class="col-lg-12">
						<label class="label-form" for="municipio">Municipio</label>
					</div>
					<div class="col-lg-12">
						<select name="municipio" id="municipio">
							<option value>Seleccione el municipio</option>
							<%
							if(login.getD_m().length() > 2){
								%><option value="<%= login.getD_m() %>"><%= consultas.getMunicipio(login.getD_m()) %></option><%	
							}else{
								for(localizacion municipio : consultas.obtenerMunicipiosR(login.getUsuario())){ %>
									<option value="<%= municipio.getCod_dane() %>"><%= municipio.getNombre() %></option>
								<%}
							}
							%>
						</select>
					</div>
				</div>
				<div class="col-lg-12" style="text-align: center;">
					<input type="submit" class="btn" value="Buscar" onclick="validarFechas()">
				</div> 
			</form>
		</div>
		<div class="row">
			<div class="col-md-12">
				<liferay-ui:search-container   delta="10" deltaConfigurable="true"  emptyResultsMessage="No hay Resultados" iteratorURL="<%=iteratorURL%>">
					<liferay-ui:search-container-results>
						<%
							String keywords =	ParamUtil.getString(request, "keywords");
												results = ListUtil.subList(permisos,
														searchContainer.getStart(),
														searchContainer.getEnd());
							total = permisos.size();
							searchContainer.setTotal(permisos.size());
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
						%>
					</liferay-ui:search-container-results>    
					<liferay-ui:search-container-row className="co.com.csj.model.Docencia" keyProperty="id" modelVar="permiso">
						<%
							usuario persona = usuarioLocalServiceUtil.getusuario(permiso.getUsuario_fk());
							String userName = persona.getNomb() + " " + persona.getApe();
							SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
						%>
							<liferay-ui:search-container-column-text name="Código"	value="<%= String.valueOf(permiso.getId()) %>"/>
							<liferay-ui:search-container-column-text name="Nombre Completo"	value="<%= userName %>"/>
							<liferay-ui:search-container-column-text name="Cédula de Ciudadanía" value="<%= permiso.getUsuario_fk() %>" />
							<liferay-ui:search-container-column-text name="Materia" value="<%= permiso.getMateria() %>" />
							<liferay-ui:search-container-column-text name="Institución"	value="<%= permiso.getInstitucion() %>"/>
							<liferay-ui:search-container-column-text name="Fecha Inicial"	value="<%= formato.format(permiso.getFechaInicial()) %>"/>
							<liferay-ui:search-container-column-text name="Fecha Final" value="<%= formato.format(permiso.getFechaFinal()) %>"/>
							<liferay-ui:search-container-column-text name="Distrito" value="<%= consultas.obtenerDistrito(permiso.getDespacho()) %>" />
							<liferay-ui:search-container-column-text name="Departamento" value="<%= consultas.obtenerDepartamento(permiso.getDespacho().substring(0, 2)) %>" />
							<liferay-ui:search-container-column-text name="Municipio" value="<%= consultas.getMunicipio(permiso.getDespacho().substring(0, 5)) %>" />
							<liferay-ui:search-container-column-text name="Despacho" value="<%= consultas.obtenerDespachoSel(permiso.getDespacho()).getNombre() %>" />
							<liferay-ui:search-container-column-jsp  name="Accion"	path="/html/servidoresjudiciales/accionDocencia.jsp"></liferay-ui:search-container-column-jsp>
							<%-- <%
								int aux = ((permiso.getFechaFinal().getMonth()-1) / 6) + 1;
								if(quarter == aux && hoy.getYear()==permiso.getFechaFinal().getYear()){
							%>
							<liferay-ui:search-container-column-jsp  name="Accion"	path="/html/servidoresjudiciales/accionDocencia.jsp"></liferay-ui:search-container-column-jsp>
							<%
								}else{
							%>
								<liferay-ui:search-container-column-text name="Accion" value="Fuera del semestre actual" />
							<%
								}
							%> --%>
					  </liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
				</liferay-ui:search-container>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-12" style="text-align: center;">
				<aui:button onClick="${ exportarExcel }" value="Exportar"></aui:button>
			</div>
		</div>
	</div>
</div>
<%}else{ %>
<div style="text-align: center; color: #19325b; font-size: 22px;">
	Para dar cumplimiento al Acuerdo PCSJA18-11160, debe acceder mediante usuario y contraseña diligenciando el respectivo formulario y enviarlo al correo electrónico <a href="mailto:soportepaginaweb@cendoj.ramajudicial.gov.co">soportepaginaweb@cendoj.ramajudicial.gov.co</a>.
	<br><br>
	Está solicitud se debe realizar por correo electrónico institucional.
	<br><br>
	<a href="http://actosadministrativos.ramajudicial.gov.co/web/Acto%20Administrativo/Default.aspx?ID=10966">Descargue formulario aquí</a>
</div>
<%} %>
<script type="text/javascript">
$(document).ready( function(){
	$("#menu-docenciasUsuario").addClass("active");
});
function validarFechas(){
	document.getElementById("validarF").value="";
	var fechaInicial = new Date();
	var fechaFinal = new Date();
	if(document.getElementById("fechaInicial").value != ''){
		var fechaInicial_aux = document.getElementById("fechaInicial").value.split("-");
		
	 	fechaInicial = new Date(parseInt(fechaInicial_aux[0]),parseInt(fechaInicial_aux[1]-1),parseInt(fechaInicial_aux[2]),parseInt("00"),parseInt("00"));
	}
	if(document.getElementById("fechaFinal").value != ''){
		var fechaFinal_aux = document.getElementById("fechaFinal").value.split("-");
	 	fechaFinal = new Date(parseInt(fechaFinal_aux[0]),parseInt(fechaFinal_aux[1]-1),parseInt(fechaFinal_aux[2]),parseInt("23"),parseInt("59"));
	}
	
 	if(document.getElementById("fechaInicial").value != '' && document.getElementById("fechaFinal").value != ''){
 		if(fechaInicial>fechaFinal){
 			alert("La fecha inicial no puede ser mayor que la fecha final");
 		}else{
 			document.getElementById("validarF").value="1";
 		}
 	}else{
 		document.getElementById("validarF").value="1";
 	}
 	
 }
</script>
