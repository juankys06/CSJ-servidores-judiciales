<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="co.com.csj.modelos.despacho"%>
<%@page import="co.com.csj.modelos.entidad"%>
<%@page import="co.com.csj.modelos.especialidad"%>
<%@page import="co.com.csj.modelos.consultas"%>
<%@page import="co.com.csj.modelos.localizacion"%>
<%@page import = "co.com.csj.modelos.Area"%>
<%@page import="co.com.csj.service.permisosLocalServiceUtil"%>
<%@page import="co.com.csj.model.permisos"%>
<%@page import = "com.liferay.portal.model.Role" %>
<%@page import = "com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import ="co.com.csj.model.tipo" %>
<%@page import ="co.com.csj.model.licencia_permiso" %>
<%@page import ="co.com.csj.model.cargo" %>
<%@page import ="co.com.csj.model.usuario" %>
<%@page import ="co.com.csj.model.tipo_documento" %>
<%@page import ="java.util.ArrayList"  %>
<%@page import ="java.util.List" %> 
<%@page import = "co.com.csj.service.tipoLocalServiceUtil" %>
<%@page import = "co.com.csj.service.licencia_permisoLocalServiceUtil" %>
<%@page import = "co.com.csj.service.cargoLocalServiceUtil" %>
<%@page import = "co.com.csj.service.usuarioLocalServiceUtil" %>
<%@page import = "co.com.csj.service.tipo_documentoLocalServiceUtil" %>

<portlet:defineObjects />
<portlet:renderURL var="home" >
	<portlet:param name="mvcPath" value="/html/servidoresjudiciales/view.jsp"/>
</portlet:renderURL>
<portlet:actionURL var="cargarExcelP" name="cargarExcelP"></portlet:actionURL>

<%	
	permisos login = permisosLocalServiceUtil.getByUser(request.getRemoteUser());
	if(login!=null){
		List<localizacion> ciudadesList = new ArrayList<localizacion>();
		List<localizacion> departamentosList = new ArrayList<localizacion>();
		List<Area> areas = consultas.obtenerAreas();
		List<especialidad> especialidades = new ArrayList<especialidad>();
		List<entidad> entidades = new ArrayList<entidad>();
		List<cargo> cargos = new ArrayList<cargo>();
		
		if(login.getCargo().equalsIgnoreCase("Juez"))
			ciudadesList = consultas.obtenerMunicipio(login.getD_m());

		if(login.getCargo().equalsIgnoreCase("Magistrado") || login.getCargo().equalsIgnoreCase("Magistrado Seccional"))
			ciudadesList = consultas.obtenerMunicipios(login.getD_m());
		
		if(login.getCargo().equalsIgnoreCase("Permisos por Distrito") || login.getCargo().equalsIgnoreCase("Permisos y Docencia por Distrito"))
			ciudadesList = consultas.obtenerMunicipiosR(login.getUsuario());
		
		especialidades = consultas.obtenerEspecialidades();
		entidades = consultas.obtenerEntidades();
		departamentosList = consultas.obtenerMDepartamentos();
		cargos = cargoLocalServiceUtil.getcargos(-1, -1);
		List<String> ErroresP = (List<String>) renderRequest.getPortletSession().getAttribute("ErroresExcelP");
		renderRequest.getPortletSession().removeAttribute("ErroresExcelP");
		
%>
<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/servidoresjudiciales/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<liferay-ui:error key="errorExcelP" message="Error en el archivo Exccel suministrado." />
	<%if(ErroresP!=null)if(ErroresP.size()>0){ %>
		<div class="portlet-msg-error">
			<%for(String e : ErroresP){ %>
				<%=e %>
				<br>
			<%} %>
		</div>
	<%} %>
	<div class="container">
		 <div class="row"> 
			<div class="col-lg-12 col-md-12 col-xs-12 text-center">
				<h1>Importar permisos desde en archivo Excel</h1>
			</div>
			<div class="col-lg-12 col-md-12 col-xs-12 text-left">
				<h3>Seleccione el despacho al cual va a cargar los permisos</h3>
			</div>
			<br>
			<form action="${cargarExcelP }" method="post" enctype="multipart/form-data">
				<div class="row">
					<% 
					if(login.getCargo().equalsIgnoreCase("Permisos y Docencia Nacional")){
					%>
						<div class="row">
						 	<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Distrito Judicial</label>
								</div>
								<div class="col-lg-12">
									<input class="select-option" name="djudicial" id="djudicial" type="text" placeholder="Distrito Judicial" disabled />
								</div>
							</div> 
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Departamento</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="departamento" id="departamento" onchange="filtromuni()" required>
										<option value>Seleccione...</option>
										<% 
											for(localizacion cc : departamentosList){
										%>
												<option value="<%= cc.getCod_dane_departamento()%>"><%= cc.getNombre() %></option>
										<%
											} 
										%>
									</select>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Ciudad/Municipio</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="ciudad" id="ciudad" onchange="despachofiltro()" required>
										<option value>Seleccione...</option>
										<% 
											for(localizacion cc : ciudadesList){
										%>
												<option value="<%= cc.getCod_dane_departamento()+cc.getCod_dane()%>"><%= cc.getNombre() %></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Entidad</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="entidad" id="entidad" onchange="despachofiltro()" required>
										<option value>Seleccione...</option>
										<%
											for(entidad en : entidades){
										%>
												<option value="<%= en.getId()%>"> <%= en.getNombre() %></option>
										<%
											}
										%>
									</select>
								</div>
							</div> 
						</div>
						<div class=row>
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form" for="area">Área</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" id="area" name="area" onchange="despachofiltro()">
										<option value>Seleccione...</option>
										<% 
											for(Area area: areas){
										%>
												<option value="<%= area.getId() %>"><%= area.getNombre() %></option>
										<%	
											}
										%>
									</select>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Especialidad</label>
								</div>
								<div class="col-lg-12">
									<select class=" select-option" name="especialidad" id="especialidad" onchange="despachofiltro()">
										<option value>Seleccione...</option>
										<% 
											for(especialidad e : especialidades){
										%>
												<option value="<%= e.getId() %>"> <%= e.getNombre() %></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="col-lg-12">
									<label class="label-form">Despacho Judicial</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="despacho" id="despacho" required onchange="distritofiltro()">
										<option value="" ></option>
									</select>
								</div>
							</div>
						</div>
					<%
					}else{
					%>
						<div class="row">
						 	<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Distrito Judicial</label>
								</div>
								<div class="col-lg-12">
									<input class="select-option" name="djudicial" id="djudicial" type="text" placeholder="Distrito Judicial" disabled />
								</div>
							</div> 
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Ciudad/Municipio</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="ciudad" id="ciudad" onchange="despachofiltro()" required>
										<option value>Seleccione...</option>
										<% 
											for(localizacion cc : ciudadesList){
										%>
												<option value="<%= cc.getCod_dane_departamento()+cc.getCod_dane()%>"><%= cc.getNombre() %></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Entidad</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="entidad" id="entidad" onchange="despachofiltro()" required>
										<option value>Seleccione...</option>
										<%
											for(entidad en : entidades){
										%>
												<option value="<%= en.getId()%>"> <%= en.getNombre() %></option>
										<%
											}
										%>
									</select>
								</div>
							</div> 
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form" for="area">Área</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" id="area" name="area" onchange="despachofiltro()">
										<option value>Seleccione...</option>
										<% 
											for(Area area: areas){
										%>
												<option value="<%= area.getId() %>"><%= area.getNombre() %></option>
										<%	
											}
										%>
									</select>
								</div>
							</div>
						</div>
						<div class=row>
							<div class="col-lg-4">
								<div class="col-lg-12">
									<label class="label-form">Especialidad</label>
								</div>
								<div class="col-lg-12">
									<select class=" select-option" name="especialidad" id="especialidad" onchange="despachofiltro()">
										<option value>Seleccione...</option>
										<% 
											for(especialidad e : especialidades){
										%>
												<option value="<%= e.getId() %>"> <%= e.getNombre() %></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="col-lg-12">
									<label class="label-form">Despacho Judicial</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="despacho" id="despacho" required onchange="distritofiltro()">
										<option value="" ></option>
									</select>
								</div>
							</div>
						</div>
					<%
					} 
					%>
				</div>
				<br>
				<div class="col-lg-12 col-md-12 col-xs-12 text-left">
					<h3>Seleccione el archivo de Excel en formato (.xlsx)</h3>
				</div>
				<br>
				<div class="col-lg-6">
					<div class="col-lg-12">
						<label class="label-form">Archivo</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" name="archivo" id="archivo" required type="file" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" >
					</div>
				</div>
				<div class="col-lg-6">
					<div class="block-btn text-center">
						<input type="submit" value="Cargar" class="btn btn-default btn-buscar">
					</div>
				</div>
			</form>
			
		</div>
	</div>
</div>
<portlet:resourceURL var="filtro">
	<portlet:param name="action" value="getDespachos"/>
</portlet:resourceURL>
<script type="text/javascript">

function filtromuni(){
	var departamento = document.getElementById('departamento').value;
	$.ajax({
		url: '<%=filtro%>',
        type:  'post',
        dataType: 'json',
        data:  {tipo_sol : 4 ,departamento : departamento },
        success:  function (response) {
        	var data = response;
        	$('#ciudad').html('');
        	$('#ciudad').append($('<option>').text('Seleccione...').attr('value', ''));
        	$.each(data, function(i, des) {
        		$('#ciudad').append($('<option>').text(des.nombre).attr('value', des.id));
            });
        }
	});
}

function despachofiltro(){
	var ciudad = document.getElementById('ciudad').value;
	var entidad = document.getElementById('entidad').value;
	var especialidad = document.getElementById('especialidad').value;
	
	if(entidad.length === 1)
		entidad = "0" + entidad;
	
	if(especialidad.length === 1)
		especialidad = "0" + especialidad;
	
	var despacho = ciudad + entidad + especialidad;
	
	$.ajax({
		url: '<%=filtro%>',
        type:  'post',
        dataType: 'json',
        data:  {tipo_sol : 1 ,despachos : despacho, area: document.getElementById('area').value },
        success:  function (response) {
        	var data = response;
        	$('#despacho').html('');
        	$('#despacho').append(new Option('Seleccione...', ""));
        	$.each(data, function(i, des) {
        		$('#despacho').append(new Option(des.nombre, des.id));
            });
        }
	});
}

function distritofiltro(){
	var ciudad = document.getElementById('despacho').value;
	
	$.ajax({
		url: '<%=filtro%>',
        type:  'post',
        dataType: 'json',
        data:  {tipo_sol : 3 ,ciudad : ciudad },
        success:  function (response) {
        	var data = response;
        	document.getElementById('djudicial').value = '';
        	document.getElementById('djudicial').value = data[0].distrito;
        }
	});
}
</script>
<%
	}else{
%>
<script type="text/javascript">
$(document).ready( function(){
	window.location.href = '<%=home%>';
});
</script>
<%	
	}
%>
<script type="text/javascript">
$(document).ready( function(){
	$("#menu-permisosexcel").addClass("active");
});
</script>
