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
<%@page import ="co.com.csj.model.Docencia" %>
<%@page import ="co.com.csj.model.tipo" %>
<%@page import ="co.com.csj.model.usuario" %>
<%@page import="co.com.csj.model.permisos"%>
<%@page import = "com.liferay.portal.model.Role" %>
<%@page import = "com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import="co.com.csj.modelos.localizacion"%>
<%@page import="co.com.csj.service.permisosLocalServiceUtil"%>
<%@page import = "co.com.csj.service.DocenciaLocalServiceUtil" %>
<%@page import = "co.com.csj.service.tipoLocalServiceUtil" %>
<%@page import = "co.com.csj.service.usuarioLocalServiceUtil" %>

<portlet:defineObjects />

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/servidoresjudiciales/reportesDocencia.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL name="reportesDocencia" var="ReportesDocencia"></portlet:actionURL>

<portlet:resourceURL var="reportToExcel">
	<portlet:param name="action" value="reporteDocencia"/>
</portlet:resourceURL>
<%
	permisos login = permisosLocalServiceUtil.getByUser(request.getRemoteUser());
	boolean isAdmin = false;
	for(Role role : UserLocalServiceUtil.getUser(Long.parseLong(request.getRemoteUser())).getRoles())
		if(role.getName().equals("Administrator"))
			isAdmin = true;
	List<Docencia> permisos ;
	List<localizacion> departamentos = consultas.obtenerMDepartamentos();
	
	if(renderRequest.getPortletSession().getAttribute("permisosDocencia")!=null)
		permisos= (List<Docencia>) renderRequest.getPortletSession().getAttribute("permisosDocencia");
	else
		permisos = DocenciaLocalServiceUtil.getAll();
	
	renderRequest.setAttribute("permisosDocencia", permisos);
	renderRequest.getPortletSession().setAttribute("permisosDocencia", permisos);
%>

<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/servidoresjudiciales/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<liferay-ui:success key="eliminado" message="El permiso ha sido eliminado." />
	<div class="container">
		<div class="row">
			<form method="post" action="<%= ReportesDocencia %>">
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
						<label class="label-form" for="email">Usuario (correo)</label>
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
						<input class="select-option" type="date" name="fi" value="<%= (String)renderRequest.getPortletSession().getAttribute("fiD")%>">
					</div>
				</div>
				<div class="col-lg-3">
					<div class="col-lg-12">
						<label class="label-form" for="ff">Fecha Fin</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" type="date" name="ff" value="<%= (String)renderRequest.getPortletSession().getAttribute("ffD")%>">
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
					<liferay-ui:search-container-row className="co.com.csj.model.Docencia" keyProperty="id" modelVar="permiso">
						<%
							usuario persona = usuarioLocalServiceUtil.getusuario(permiso.getUsuario_fk());
							String userName = persona.getNomb() + " " + persona.getApe();
							DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
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
	$("#menu-reportesDocencias").addClass("active");
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