<%@page import="co.com.csj.modelos.consultas"%>
<%@page import="co.com.csj.modelos.localizacion"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="co.com.csj.service.permisosLocalServiceUtil"%>
<%@page import="co.com.csj.model.permisos"%>
<%@page import="java.util.List"%>
<%@page import ="java.util.ArrayList"  %>
<%@page import="com.liferay.portal.kernel.exception.PortalException" %>
<%@page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/administracion/usuariospermisos/view.jsp"/>
</liferay-portlet:renderURL>

<portlet:actionURL name="asignarUsuario" var="asignarUsuario"/>
<portlet:actionURL name="buscar" var="buscarUsuario" />
<portlet:resourceURL var="Exportar">
	<portlet:param name="action" value="exportar"/>
</portlet:resourceURL>

<%

	List<permisos> usuariosPermiso = (List<permisos>)renderRequest.getPortletSession().getAttribute("usuariosPermisos");
	if(usuariosPermiso == null)
		usuariosPermiso = permisosLocalServiceUtil.getpermisoses(-1, -1);
	List<User> usuPermisos = new ArrayList<User>();
	
	DynamicQuery dynamicQuery=DynamicQueryFactoryUtil.forClass(Role.class, PortalClassLoaderUtil.getClassLoader());
	dynamicQuery.add(PropertyFactoryUtil.forName("name").like("permisos"));
	List<Role> roles = RoleLocalServiceUtil.dynamicQuery(dynamicQuery);
	for(Role rol:roles){
		System.out.println("rol " + rol.getRoleId());
		usuPermisos=UserLocalServiceUtil.getRoleUsers(rol.getRoleId());
	}

	List<localizacion> departamentos = consultas.obtenerMDepartamentos();
	List<localizacion> municipios = consultas.obtenerTodosMuni();
%>
<style>
	.bloque {
		display: inline-block;
		vertical-align: top;
	}
</style>
<liferay-ui:error key="yaEsta" message="Usuario ya esta registrado"></liferay-ui:error>
<liferay-ui:success key="guardo" message="Usuario registrado exitosamente"></liferay-ui:success>
<liferay-ui:success key="eliminado" message="Usuario eliminado exitosamente"></liferay-ui:success>

<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/administracion/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<div class="container">
		<div class="row" style="text-align: center;">
			<h3>Gestion de Usuarios de Permisos</h3>
		</div>
		<aui:form action="${asignarUsuario }" method="post">
		<div class="row">
			<div class="bloque" style="width: 19%; text-align: left;">
				<aui:select name="usuarios" id="usuarios" label="Usuarios" required="true" style="width: 99%;">
					<aui:option>Seleccione un usuario</aui:option>
					<%if(usuPermisos!=null){ %>
						<%for(User us : usuPermisos){ %>
							<aui:option value="<%=us.getUserId() %>"><%=us.getEmailAddress() %></aui:option>
						<%} %>
					<%} %>
				</aui:select>
			</div>
			<div class="bloque" style="width: 19%; text-align: left;">
				<aui:select name="cargo" id="cargo" label="Cargo" required="true" style="width: 99%;" onChange="cargos()">
					<aui:option>Seleccione un cargo</aui:option>
					<aui:option value="Juez">Juez</aui:option>
					<aui:option value="Magistrado">Magistrado</aui:option>
					<aui:option value="Magistrado Seccional">Magistrado Seccional</aui:option>
					<aui:option value="Permisos por Distrito">Permisos por Distrito</aui:option>
					<aui:option value="Permisos y Docencia por Distrito">Permisos y Docencia por Distrito</aui:option>
					<aui:option value="Permisos y Docencia Nacional">Permisos y Docencia Nacional</aui:option>
				</aui:select>
			</div>
			<div class="bloque" style="width: 19%; text-align: left; display: none;" id="1">
				<aui:select name="departamento" id="departamento" label="Departamento" style="width: 99%;" onChange="filtromuni()">
					<aui:option>Seleccione un departamento</aui:option>
					<%if(departamentos!=null){ %>
						<%for(localizacion us : departamentos){ %>
							<aui:option value="<%=us.getCod_dane_departamento() %>"><%=us.getNombre() %></aui:option>
						<%} %>
					<%} %>
				</aui:select>
			</div>
			<div class="bloque" style="width: 19%; text-align: left; display: none;" id="2">
				<aui:select name="municipio" id="municipio" label="Municipio"  style="width: 99%;">
					<aui:option>Seleccione un municipio</aui:option>
				</aui:select>
			</div>
			<br>
			<br>
			<div class="row" style="text-align: center;">
				<aui:button name="guardar" id="guardar" value="Asignar" type="submit" style="padding: 4px 2%;"></aui:button>
			</div>
		</div>
		</aui:form>
		<div class="row">
			<aui:form action="${ buscarUsuario }">
				<div class="bloque" style="width: 23%; text-align: left;">
					<aui:select name="cargo" label="Cargo">
						<aui:option>Seleccione un cargo</aui:option>
						<aui:option value="Juez">Juez</aui:option>
						<aui:option value="Magistrado">Magistrado</aui:option>
						<aui:option value="Magistrado Seccional">Magistrado Seccional</aui:option>
						<aui:option value="Permisos por Distrito">Permisos por Distrito</aui:option>
						<aui:option value="Permisos y Docencia por Distrito">Permisos y Docencia por Distrito</aui:option>
						<aui:option value="Permisos y Docencia Nacional">Permisos y Docencia Nacional</aui:option>
					</aui:select>
				</div>
				<div class="bloque" style="width: 19%; text-align: left;">
					<aui:input type="email" class="form-control" name="email" placeholder="pedro.perez@ejemplo.com"></aui:input>
				</div>
				<div class="bloque" style="width: 19%; text-align: left;">
					<aui:input type="text" class="form-control" name="nombre" placeholder="pedro perez"></aui:input>
				</div>
				<div class="row" style="text-align: center;">
					<input type="submit" class="btn" value="Buscar">
				</div>
			</aui:form>
		</div>
		<br>
		<br>
		<div class="row">
			<liferay-ui:search-container delta="10" deltaConfigurable="true"  emptyResultsMessage="No hay usuarios asignados" iteratorURL="<%=iteratorURL%>">
			    <liferay-ui:search-container-results>
			        <%				
					 	String keywords = ParamUtil.getString(request, "keywords");		
						results = ListUtil.subList(usuariosPermiso, searchContainer.getStart(), searchContainer.getEnd());
						total = usuariosPermiso.size();
						searchContainer.setTotal(usuariosPermiso.size());
						pageContext.setAttribute("results", results);
						pageContext.setAttribute("total", total);			
					%>
			    </liferay-ui:search-container-results>
					<liferay-ui:search-container-row className="co.com.csj.model.permisos" keyProperty="id" modelVar="userGene">
							<%
							String userName = "Usuario eliminado del portal";
							String userEmail = "Usuario eliminado del portal";
						    try {
								User usuario = UserLocalServiceUtil.getUser(Long.parseLong(userGene.getUsuario())); 
								userName = usuario.getFirstName() + " " + usuario.getLastName();
								userEmail = usuario.getEmailAddress();
							} catch (PortalException e) {
								
							} catch (SystemException e){
								
							}
							%>
								<liferay-ui:search-container-column-text name="Nombre" value="<%= userName %>"/>
							    <liferay-ui:search-container-column-text name="Correo electrónico" value="<%= userEmail %>" />
							    <liferay-ui:search-container-column-text name="Cargo" value="<%= userGene.getCargo() %>"></liferay-ui:search-container-column-text>
							<%
								String despar = "";
						       	String muni = "";
						       	if(userGene.getCargo().equalsIgnoreCase("Magistrado") || userGene.getCargo().equalsIgnoreCase("Magistrado Seccional") || userGene.getCargo().equalsIgnoreCase("Permisos por Distrito") || userGene.getCargo().equalsIgnoreCase("Permisos y Docencia por Distrito"))
						       		for(localizacion d : departamentos)
						       			if(d.getCod_dane().equalsIgnoreCase(userGene.getD_m()) && d.getCod_dane_departamento().equalsIgnoreCase(userGene.getD_m()))
						       				despar=d.getNombre();
		
						       	if(userGene.getCargo().equalsIgnoreCase("Juez")){
						       		for(localizacion departamento : departamentos)
						       			if(departamento.getCod_dane().equalsIgnoreCase(userGene.getD_m().substring(0, 2)) && departamento.getCod_dane_departamento().equalsIgnoreCase(userGene.getD_m().substring(0, 2)))
						       				despar = departamento.getNombre();
						       		
						       		for(localizacion d : municipios)
						       			if(userGene.getD_m().equalsIgnoreCase(d.getCod_dane_departamento()+d.getCod_dane()))
						       				muni=d.getNombre();
						       	}
						    %>
						    <liferay-ui:search-container-column-text name="Departamento" value="<%=despar %>"></liferay-ui:search-container-column-text>
					        <liferay-ui:search-container-column-text name="Municipio" value="<%=muni %>"></liferay-ui:search-container-column-text>
					        <liferay-ui:search-container-column-jsp  name="Acciones"  path="/html/administracion/usuariospermisos/actions.jsp" />
						    <%
							
						    %>
					  </liferay-ui:search-container-row>
			  	<liferay-ui:search-iterator />
			</liferay-ui:search-container>
		</div>
		<div class="row" style="text-align: center;">
			<aui:button value="Exportar" onClick="<%= Exportar %>"></aui:button>
		</div>
	</div>
</div>
<portlet:resourceURL var="filtro">
	<portlet:param name="action" value="filtrar" />
</portlet:resourceURL>
<script type="text/javascript">
$(document).ready( function(){
	$("#btn-2").addClass("active");
});

function cargos(){
	var cargo = document.getElementById('<portlet:namespace/>cargo').value;
	if( cargo === "Magistrado" || cargo === "Magistrado Seccional" || cargo === "Permisos por Distrito" || cargo === "Permisos y Docencia por Distrito" ){
		document.getElementById('1').style.display='inline-block';
		document.getElementById('2').style.display='none';
		document.getElementById('<portlet:namespace/>departamento').required = true;
		document.getElementById('<portlet:namespace/>municipio').required = false;
	}
	if(cargo=="Juez"){
		document.getElementById('1').style.display='inline-block';
		document.getElementById('2').style.display='inline-block';
		document.getElementById('<portlet:namespace/>departamento').required = false;
		document.getElementById('<portlet:namespace/>municipio').required = true;
	}
	if(cargo=="" || cargo=="Permisos y Docencia Nacional"){
		document.getElementById('1').style.display='none';
		document.getElementById('2').style.display='none';
		document.getElementById('<portlet:namespace/>departamento').required = false;
		document.getElementById('<portlet:namespace/>municipio').required = false;
	}
}

function filtromuni(){
	var departamento = document.getElementById('<portlet:namespace/>departamento').value;
	$.ajax({
		url: '<%=filtro%>',
        type:  'post',
        dataType: 'json',
        data:  {departamento : departamento },
        success:  function (response) {
        	var data = response;
        	$('#<portlet:namespace/>municipio').html('');
        	$('#<portlet:namespace/>municipio').append($('<option>').text('Seleccione un municipio').attr('value', ''));
        	$.each(data, function(i, des) {
        		$('#<portlet:namespace/>municipio').append($('<option>').text(des.nombre).attr('value', des.id));
            });
        }
	});
}
</script>