<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@page import ="java.util.List" %>
<%@page import ="java.util.ArrayList"  %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="co.com.csj.modelos.consultas"%>
<%@page import ="co.com.csj.model.licencia_permiso" %>
<%@page import ="co.com.csj.model.tipo" %>
<%@page import ="co.com.csj.model.usuario" %>
<%@page import="co.com.csj.model.permisos"%>
<%@page import = "com.liferay.portal.model.Role" %>
<%@page import = "com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import="co.com.csj.modelos.localizacion"%>
<%@page import="co.com.csj.service.permisosLocalServiceUtil"%>
<%@page import = "co.com.csj.service.licencia_permisoLocalServiceUtil" %>
<%@page import = "co.com.csj.service.tipoLocalServiceUtil" %>
<%@page import = "co.com.csj.service.usuarioLocalServiceUtil" %>

<portlet:defineObjects />

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/servidoresjudiciales/reportes.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL name="reports" var="Reportes"></portlet:actionURL>

<portlet:resourceURL var="reportToExcel">
	<portlet:param name="action" value="ReporteExcel"/>
</portlet:resourceURL>
<%
	permisos login = permisosLocalServiceUtil.getByUser(request.getRemoteUser());
	boolean isAdmin = false;
	for(Role role : UserLocalServiceUtil.getUser(Long.parseLong(request.getRemoteUser())).getRoles())
		if(role.getName().equals("Administrator"))
			isAdmin = true;
	
	List<licencia_permiso> permisos ;
	List<localizacion> departamentos = consultas.obtenerMDepartamentos();
	if(renderRequest.getPortletSession().getAttribute("permisos")!=null)
		permisos= (List<licencia_permiso>) renderRequest.getPortletSession().getAttribute("permisos");
	else
		permisos = licencia_permisoLocalServiceUtil.getAll();
	
	renderRequest.setAttribute("permisos", permisos);
	renderRequest.getPortletSession().setAttribute("permisos", permisos);
%>
<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/servidoresjudiciales/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<liferay-ui:success key="eliminado" message="El permiso ha sido eliminado." />
	<div class="container">
		<div class="row">
			<form method="post" action="<%= Reportes %>">
				<div class="col-lg-3">
					<div class="col-lg-12">
						<label class="label-form" for="departamento">Departamento</label>
					</div>
					<select class="select-option" id="departamento" name="departamento">
						<option value selected>Seleccione...</option>
						<% for(localizacion departamento: departamentos){ %>
							<option value="<%= departamento.getCod_dane_departamento() %>"><%= departamento.getNombre() %></option>
						<% } %>
					</select>
				</div>
				<div class="col-lg-3">
					<div class="col-lg-12">
						<label class="label-form" for="municipio">Municipio</label>
					</div>
					<select class="select-option" id="municipio" name="municipio">
						<option value selected>Seleccione...</option>
					</select>
				</div>
				<div class="col-lg-3">
					<div class="col-lg-12">
						<label class="label-form" for="despacho">Despacho</label>
					</div>
					<div class="col-lg-12">
						<select class="select-option" id="despacho" name="despacho">
							<option value selected>Seleccione...</option>
						</select>
					</div>
				</div>
				<div class="col-lg-3">
					<div class="col-lg-12">
						<label class="label-form" for="nombre">Usuario (correo)</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" type="email" name="email">
					</div>
				</div>
				<div class="col-lg-3">
				</div>
				<div class="col-lg-3">
					<div class="col-lg-12">
						<label class="label-form" for="fi">Fecha Inicio</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" type="date" name="fi" value="<%= (String)renderRequest.getPortletSession().getAttribute("fiP")%>">
					</div>
				</div>
				<div class="col-lg-3">
					<div class="col-lg-12">
						<label class="label-form" for="ff">Fecha Fin</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" type="date" name="ff" value="<%= (String)renderRequest.getPortletSession().getAttribute("ffP")%>">
					</div>
				</div>
				<div class="col-lg-3">
				</div>
				<div class="col-lg-12" style="text-align: center;">
					<input type="submit" class="btn" value="Buscar"> 
				</div>
				
			</form>
		</div>
		<div class="row">
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
					<liferay-ui:search-container-row className="co.com.csj.model.licencia_permiso" keyProperty="id" modelVar="permiso">
						<%
							String tipoPermiso = tipoLocalServiceUtil.gettipo(permiso.getTipofk()).getDescripcion(); ;
							usuario persona = usuarioLocalServiceUtil.getusuario(permiso.getUsuariofk());
							String userName = persona.getNomb() + " " + persona.getApe();
							DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
						%>
						
						<% if(permiso.getEstatus()==0){ %>
								<liferay-ui:search-container-column-text cssClass="permiso-cancelado" name="Código"	value="<%= String.valueOf(permiso.getId()) %>" />
								<liferay-ui:search-container-column-text cssClass="permiso-cancelado" name="Acto Administrativo" value="<%= permiso.getActoadmin() %>" />
								<liferay-ui:search-container-column-text cssClass="permiso-cancelado" name="Nombre Completo"	value="<%= userName %>" />
								<liferay-ui:search-container-column-text cssClass="permiso-cancelado" name="Cédula de Ciudadanía" value="<%= permiso.getUsuariofk() %>" />
								<liferay-ui:search-container-column-text cssClass="permiso-cancelado" name="Tipo de Permiso"	value="<%= tipoPermiso %>" />
								<liferay-ui:search-container-column-text cssClass="permiso-cancelado" name="Fecha Inicial"	value="<%= formato.format(permiso.getFechainicio()) %>" />
								<liferay-ui:search-container-column-text cssClass="permiso-cancelado" name="Fecha Final" value="<%= formato.format(permiso.getFechafin()) %>" />
								<liferay-ui:search-container-column-text cssClass="permiso-cancelado" name="Distrito" value="<%= consultas.obtenerDistrito(permiso.getDespacho()) %>" />
								<liferay-ui:search-container-column-text cssClass="permiso-cancelado" name="Departamento" value="<%= consultas.obtenerDepartamento(permiso.getDespacho().substring(0, 2)) %>" />
								<liferay-ui:search-container-column-text cssClass="permiso-cancelado" name="Municipio" value="<%= consultas.getMunicipio(permiso.getDespacho().substring(0, 5)) %>" />
								<liferay-ui:search-container-column-text cssClass="permiso-cancelado" name="Despacho" value="<%= consultas.obtenerDespachoSel(permiso.getDespacho()).getNombre() %>" />
								<liferay-ui:search-container-column-jsp  name="Accion"	path="/html/servidoresjudiciales/accionRegistro.jsp"></liferay-ui:search-container-column-jsp>
							<%}else{ %>
								<liferay-ui:search-container-column-text name="Código"	value="<%= String.valueOf(permiso.getId()) %>" />
								<liferay-ui:search-container-column-text name="Acto Administrativo" value="<%= permiso.getActoadmin() %>" />
								<liferay-ui:search-container-column-text name="Nombre Completo"	value="<%= userName %>" />
								<liferay-ui:search-container-column-text name="Cédula de Ciudadanía" value="<%= permiso.getUsuariofk() %>" />
								<liferay-ui:search-container-column-text name="Tipo de Permiso"	value="<%= tipoPermiso %>" />
								<liferay-ui:search-container-column-text name="Fecha Inicial"	value="<%= formato.format(permiso.getFechainicio()) %>" />
								<liferay-ui:search-container-column-text name="Fecha Final" value="<%= formato.format(permiso.getFechafin()) %>" />
								<liferay-ui:search-container-column-text name="Distrito" value="<%= consultas.obtenerDistrito(permiso.getDespacho()) %>" />
								<liferay-ui:search-container-column-text name="Departamento" value="<%= consultas.obtenerDepartamento(permiso.getDespacho().substring(0, 2)) %>" />
								<liferay-ui:search-container-column-text name="Municipio" value="<%= consultas.getMunicipio(permiso.getDespacho().substring(0, 5)) %>" />
								<liferay-ui:search-container-column-text name="Despacho" value="<%= consultas.obtenerDespachoSel(permiso.getDespacho()).getNombre() %>" />
								<liferay-ui:search-container-column-jsp  name="Accion"	path="/html/servidoresjudiciales/accionRegistro.jsp"></liferay-ui:search-container-column-jsp>
							<%} %>
							
					  </liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
		<div class="row">
			<aui:button value="Exportar a Excel" onClick="<%= reportToExcel %>"></aui:button>
		</div>
	</div>
</div>
<portlet:resourceURL var="filtro">
	<portlet:param name="action" value="filtroReportes"/>
</portlet:resourceURL>
<script type="text/javascript">
$(document).ready( function() {
	$("#menu-reportesPermisos").addClass("active");
	$('#departamento').change( function(){
		$.ajax({
			url: '<%= filtro %>',
	        type:  'post',
	        dataType: 'json',
	        data:  { tipo_filtro : 'departamento' , departamento : $(this).val() },
	        success:  function (response) {
	        	var data = response;
	        	$('#municipio').html('');
	        	$('#municipio').append(new Option('Seleccione...', ""));
	        	$.each(data, function(i, des) {
	        		$('#municipio').append(new Option(des.nombre, des.id));
	            });
	        }
		});
	});
	
	$('#municipio').change( function(){
		$.ajax({
			url: '<%= filtro %>',
	        type:  'post',
	        dataType: 'json',
	        data:  { tipo_filtro : 'municipio' , departamento: $("#departamento").val() , municipio : $(this).val() },
	        success:  function (response) {
	        	var data = response;
	        	$('#despacho').html('');
	        	$('#despacho').append(new Option('Seleccione...', ""));
	        	$.each(data, function(i, des) {
	        		$('#despacho').append(new Option(des.nombre, des.id));
	            });
	        }
		});
	});
});
</script>