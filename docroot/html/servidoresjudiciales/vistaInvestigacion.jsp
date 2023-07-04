<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="co.com.csj.modelos.entidad"%>
<%@page import="co.com.csj.service.permisosLocalServiceUtil"%>
<%@page import="co.com.csj.model.permisos"%>
<%@page import = "com.liferay.portal.model.Role" %>
<%@page import = "com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import="co.com.csj.modelos.consultas"%>
<%@page import="co.com.csj.modelos.localizacion"%>
<%@page import="co.com.csj.modelos.Area"%>
<%@page import ="co.com.csj.model.cargo" %>
<%@page import ="co.com.csj.model.tipo_documento" %>
<%@page import ="java.util.ArrayList"  %>
<%@page import ="java.util.List" %> 
<%@page import = "co.com.csj.service.cargoLocalServiceUtil" %>
<%@page import = "co.com.csj.service.tipo_documentoLocalServiceUtil" %>

<portlet:defineObjects />

<portlet:actionURL name="addDocentePermiso" var="addDocentePermiso"></portlet:actionURL>
<% 
	permisos login = permisosLocalServiceUtil.getByUser(request.getRemoteUser());
	List<Area> areas = consultas.obtenerAreas();

	List<localizacion> ciudadesList = new ArrayList<localizacion>();
	List<localizacion> departamentosList = new ArrayList<localizacion>();
	boolean isAdmin = false;
	for(Role role : UserLocalServiceUtil.getUser(Long.parseLong(request.getRemoteUser())).getRoles())
		if(role.getName().equals("Administrator"))
			isAdmin = true;
	
	if(login.getCargo().equalsIgnoreCase("Juez"))
		ciudadesList = consultas.obtenerMunicipio(login.getD_m());

	if(login.getCargo().equalsIgnoreCase("Magistrado") || login.getCargo().equalsIgnoreCase("Magistrado Seccional"))
		ciudadesList = consultas.obtenerMunicipios(login.getD_m());
	
	if(login.getCargo().equalsIgnoreCase("Permisos por Distrito") || login.getCargo().equalsIgnoreCase("Permisos y Docencia por Distrito"))
		ciudadesList = consultas.obtenerMunicipiosR(login.getUsuario());
	
	if(login.getCargo().equalsIgnoreCase("Permisos y Docencia Nacional"))
		departamentosList = consultas.obtenerMDepartamentos();
	
	List<entidad> entidades = consultas.obtenerEntidades();
	List<cargo> cargos = cargoLocalServiceUtil.getcargos(-1, -1);
	List<tipo_documento> tipoDocumento = tipo_documentoLocalServiceUtil.gettipo_documentos(-1, -1);
	String cedula = (String)renderRequest.getAttribute("cedula");
	long tipo_doc = (Long)renderRequest.getAttribute("tipo_doc");
	
%>
<script>
$( function() {
   	$( "#fecha_inicio" ).datepicker({
									/* beforeShowDay: $.datepicker.noWeekends, */
									dateFormat: 'dd/mm/yy' ,
									minDate: '22/11/2018',
									monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
								   	monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
								   	dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
								   	dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
								   	dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá']
									});
 } );
$( function() {
	$( "#fecha_fin" ).datepicker({
								/* beforeShowDay: $.datepicker.noWeekends, */
								dateFormat: 'dd/mm/yy' ,
								minDate: '22/11/2018',
								monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
							   	monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
							   	dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
							   	dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
							   	dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá']
								});
 } );
</script>
<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/servidoresjudiciales/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<liferay-ui:error key="errorDocente" message="Error al registrar al usuario." />
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
		 		<h1>REGISTRO  DE INFORMACIÓN COMPLEMENTARIA DE SERVIDORES JUDICIALES<br>DATOS DEL FUNCIONARIO/A O EMPLEADO/A JUDICIAL</h1>
		 	</div>
		<form method="post" action="<%= addDocentePermiso %>">
			<div class="row form-div">
				<div class="col-lg-12">
					<div class=row>
						<div class="col-lg-3">
							<div class="col-lg-12">
								<label class="label-form" for="nombre">Nombre</label>
							</div>
							<div class="col-lg-12">
							<input class=" select-option" name="nombre" id="nombre" type="text" placeholder="Nombre" required="required"/>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="col-lg-12">
								<label class="label-form" for="apellido">Apellido</label>
							</div>
							<div class="col-lg-12">
								<input class=" select-option" name="apellido" id="apellido" type="text" placeholder="Apellido" required="required"/>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="col-lg-12">
								<label class="label-form" for="tipo_doc">Tipo de Documento</label>
							</div>
							<div class="col-lg-12">
								<select name="tipo_doc" id="tipo_doc" class="select-option" required>
									<option value>Seleccione...</option>
									<%
										for(tipo_documento tp : tipoDocumento){
											if(tp.get_id() == tipo_doc){%>
											<option value="<%= tp.get_id()%>" selected><%= tp.getDesc() %> </option>
											<%
												
											}else{
											%>
											<option value="<%= tp.get_id()%>"><%= tp.getDesc() %> </option>
											<%
												}
										}
									%>
								</select>
							</div>
						</div>
						
						<div class="col-lg-3">
							<div class="col-lg-12">
								<label class="label-form" for="cedula">Número de Documento</label>
							</div>
							<div class="col-lg-12">
								<input class="select-option" name="cedula" id="cedula" type="text" placeholder="Número de Cédula" required="required" value="<%= cedula %>"/>
							</div>
						</div>
						
					</div>
					
					<%
						if(login.getCargo().equalsIgnoreCase("Permisos y Docencia Nacional")){
					%>
							<div class=row>
								<div class="col-lg-3">
									<div class="col-lg-12">
										<label class="label-form" for="djudicial">Distrito Judicial</label>
									</div>
									<div class="col-lg-12">
										<input class="select-option" name="djudicial" id="djudicial" type="text" placeholder="Distrito Judicial" disabled />
									</div>
								</div>
								<div class="col-lg-3">
									<div class="col-lg-12">
										<label class="label-form" for="departamento">Departamento</label>
									</div>
									<div class="col-lg-12">
										<select class="select-option" name="departamento" id="departamento" onchange="filtromuni()" required>
											<option value>Seleccione...</option>
											<% for(localizacion cc : departamentosList){
												%>
												  <option value="<%= cc.getCod_dane_departamento()%>"><%= cc.getNombre() %></option>
												<% 
											} %>
										</select>
									</div>
								</div>
								<div class="col-lg-3">
									<div class="col-lg-12">
										<label class="label-form" for="ciudad">Ciudad/Municipio</label>
									</div>
									<div class="col-lg-12">
										<select class="select-option" name="ciudad" id="ciudad" onchange="despachofiltro()" required>
											<option value>Seleccione...</option>
											<% for(localizacion cc : ciudadesList){
												%>
												  <option value="<%= cc.getCod_dane_departamento()+cc.getCod_dane()%>"><%= cc.getNombre() %></option>
												<% 
											} %>
										</select>
									</div>
								</div>
								
								<div class="col-lg-3">
									<div class="col-lg-12">
										<label class="label-form" for="entidad">Entidad</label>
									</div>
									<div class="col-lg-12">
										<select class="select-option" name="entidad" id="entidad" onchange="despachofiltro()">
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
							<div class="row">
								<div class="col-lg-3">
									<div class="col-lg-12">
										<label class="label-form" for="area">Área</label>
									</div>
									<div class="col-lg-12">
										<select class="select-option" name="area" id="area" onchange="despachofiltro()">
											<option value>Seleccione...</option>
											<% for(Area area: areas){
												%><option value="<%= area.getId() %>"><%= area.getNombre() %></option><%
											} %>
										</select>
									</div>
								</div>
								<div class="col-lg-3">
									<div class="col-lg-12">
										<label class="label-form" for="especialidad">Especialidad</label>
									</div>
									<div class="col-lg-12">
										<select class="select-option" name="especialidad" id="especialidad" onchange="despachofiltro()">
											<option value>Seleccione...</option>
										</select>
									</div>
								</div>
								<div class="col-lg-3">
									<div class="col-lg-12">
										<label class="label-form" for="despacho">Despacho Judicial</label>
									</div>
									<div class="col-lg-12">
										<select class="select-option" required name="despacho" id="despacho" onchange="distritofiltro()" >
											<option value>Seleccione...</option>
										</select>
									</div>
								</div>
								<div class="col-lg-3">
									<div class="col-lg-12">
										<label class="label-form" for="cargo">Cargo</label>
									</div>
									<div class="col-lg-12">
										<select class="select-option" name="cargo" id="cargo" type="text" placeholder="Cargo" required>
											<option value>Seleccione...</option>
											<%
												for(cargo cc: cargos){
													%>
													<option value = "<%= cc.get_id()%>"><%= cc.getDesc()%></option>
													<%
												}
											%>
										</select>
									</div>
								</div>
							</div>
					<%
						}else{
					%>
							<div class=row>
								<div class="col-lg-3">
									<div class="col-lg-12">
										<label class="label-form" for="djudicial">Distrito Judicial</label>
									</div>
									<div class="col-lg-12">
										<input class="select-option" name="djudicial" id="djudicial" type="text" placeholder="Distrito Judicial" disabled />
									</div>
								</div>
								<div class="col-lg-3">
									<div class="col-lg-12">
										<label class="label-form" for="ciudad">Ciudad/Municipio</label>
									</div>
									<div class="col-lg-12">
										<select class="select-option" name="ciudad" id="ciudad" onchange="despachofiltro()" required>
											<option value>Seleccione...</option>
											<% for(localizacion cc : ciudadesList){
												%>
												  <option value="<%= cc.getCod_dane_departamento()+cc.getCod_dane()%>"><%= cc.getNombre() %></option>
												<% 
											} %>
										</select>
									</div>
								</div>
								
								<div class="col-lg-3">
									<div class="col-lg-12">
										<label class="label-form" for="entidad">Entidad</label>
									</div>
									<div class="col-lg-12">
										<select class="select-option" name="entidad" id="entidad" onchange="despachofiltro()">
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
										<select class="select-option" name="area" id="area" onchange="despachofiltro()">
											<option value>Seleccione...</option>
											<% for(Area area: areas){
												%><option value="<%= area.getId() %>"><%= area.getNombre() %></option><%
											} %>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-4">
									<div class="col-lg-12">
									<label class="label-form" for="especialidad">Especialidad</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="especialidad" id="especialidad" onchange="despachofiltro()">
										<option value>Seleccione...</option>
									</select>
								</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-12">
									<label class="label-form" for="despacho">Despacho Judicial</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" required name="despacho" id="despacho" onchange="distritofiltro()">
										<option value>Seleccione...</option>
									</select>
								</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-12">
									<label class="label-form" for="cargo">Cargo</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="cargo" id="cargo" type="text" placeholder="Cargo" required>
										<option value>Seleccione...</option>
										<%
											for(cargo cc: cargos){
												%>
												<option value = "<%= cc.get_id()%>"><%= cc.getDesc()%></option>
												<%
											}
										%>
									</select>
								</div>
								</div>
							</div>
					<%		
						}
					%>		
				</div>
			</div>
			<div class="row form-div">
				<div class="col-lg-12">
					<h2>Docencia/Investigación</h2>
				</div>
				<div class="col-lg-12">
					<div class=row>
						<div class="col-lg-4">
							<div class="col-lg-12">
								<label class="label-form" for="fecha_inicio">Fecha de Inicio</label>
							</div>
							<div class="col-lg-12">
								<input class="select-option" required name="fecha_inicio" id="fecha_inicio" type="text" placeholder="dd/mm/yyyy" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}"/>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="col-lg-12">
								<label class="label-form" for="fecha_fin">Fecha Final</label>
							</div>
							<div class="col-lg-12">
								<input class="select-option" required name="fecha_fin" id="fecha_fin" type="text" placeholder="dd/mm/yyyy" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}"/>
							</div>
							<input style="display: none" type="text" name="validarF" id="validarF" required>
						</div>
						<div class="col-lg-4">
							<div class="col-lg-12">
								<label class="label-form" for="horas">Horas Docencia/Investigacion</label>
							</div>
							<div class="col-lg-12">
								<input class="select-option" required name="horas" id="horas" type="number" step="1" min="0" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4">
							<div class="col-lg-12">
								<label class="label-form" for="minutos">Minutos Docencia/Investigacion</label>
							</div>
							<div class="col-lg-12">
								<input class="select-option" required name="minutos" id="minutos" type="number" min="0" max="59" step="1"/>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="col-lg-12">
								<label class="label-form">Materia o Tema de Investigación</label>
							</div>
							<div class="col-lg-12">
								<input type="text" required class="select-option" name="materia">
							</div>
						</div>
						<div class="col-lg-4">
							<div class="col-lg-12">
								<label class="label-form">Institución</label>
							</div>
							<div class="col-lg-12">
								<input type="text" required class="select-option" name="institucion">
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row block-margintop-3em">
				<div class="col-md-12 text-center block-btn-filter">
					<input type="submit" value="Registrar" class="btn  btn-green" onclick="validarFechas()"/>
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
        data:  {tipo_sol : 1 , despachos : despacho, area: document.getElementById('area').value },
        success:  function (response) {
        	var data = response;
        	$('#despacho').html('');
        	$('#despacho').append(new Option('Seleccione un despacho', ""));
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

$(document).ready( function() {	
	$("#menu-cargarDocencias").addClass("active");
	$('#entidad').change( function(){
		var entidad = document.getElementById('entidad').value;
		$.ajax({
			url: '<%=filtro%>',
	        type:  'post',
	        dataType: 'json',
	        data:  {tipo_sol : 2 , entidad : entidad },
	        success:  function (response) {
	        	var data = response;
	        	$('#especialidad').html('');
	        	$('#especialidad').append(new Option('Seleccione...', ""));
	        	$.each(data, function(i, des) {
	        		$('#especialidad').append(new Option(des.nombre, des.id));
	            });
	        }
		});
	});
});

function validarFechas(){
	document.getElementById("validarF").value="";
	var fechaInicial = new Date();
	var fechaFinal = new Date();
	var fechaInferior = new Date(2018, 10 , 22);
	var hayFS = false;
	if(document.getElementById("fecha_inicio").value != ''){
		var fechaInicial_aux = document.getElementById("fecha_inicio").value.split("/");
		fechaInicial = new Date(parseInt(fechaInicial_aux[2]),parseInt(fechaInicial_aux[1]-1),parseInt(fechaInicial_aux[0]),parseInt("00"),parseInt("00"));
		if(fechaInicial < fechaInferior){
			hayFS=true;
			alert("Fecha inicial del rango no puede ser inferior al (22/11/2018)");
		}
		if(fechaInicial.getDay()==0 || fechaInicial.getDay()==6){
	 		if(confirm("La fecha inicial ingresada es un fin de semana esta seguro que desea seleccionar esa fecha?")){
	 			
	 		}else{
	 			hayFS=true;
	 		}
		}		
	}
	if(document.getElementById("fecha_fin").value != ''){
		var fechaFinal_aux = document.getElementById("fecha_fin").value.split("/");
	 	fechaFinal = new Date(parseInt(fechaFinal_aux[2]),parseInt(fechaFinal_aux[1]-1),parseInt(fechaFinal_aux[0]),parseInt("23"),parseInt("59"));
	 	if(fechaFinal.getDay()==0 || fechaFinal.getDay()==6){
			if(confirm("La fecha final ingresada es un fin de semana esta seguro que desea seleccionar esa fecha?")){
	 			
	 		}else{
	 			hayFS=true;
	 		}
		}
	}
	
 	if(document.getElementById("fecha_inicio").value != '' && document.getElementById("fecha_fin").value != ''){
 		if(fechaInicial>fechaFinal){
 			alert("La fecha inicial no puede ser mayor que la fecha final");
		}else{
 			document.getElementById("validarF").value="1";
 		}
 		if(hayFS==true){
 			document.getElementById("validarF").value="";
 		}
 	}else{
 		document.getElementById("validarF").value="1";
 	}
 	
 }
</script>
