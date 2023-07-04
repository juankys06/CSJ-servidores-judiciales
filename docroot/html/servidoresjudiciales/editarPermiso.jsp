<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>

<%@page import="co.com.csj.model.licencia_permiso" %>
<%@page import ="co.com.csj.model.tipo" %>
<%@page import = "co.com.csj.service.tipoLocalServiceUtil" %>
<%@page import="co.com.csj.service.permisosLocalServiceUtil"%>

<portlet:defineObjects />
<portlet:actionURL name="editarPermiso2" var="editarPermiso"></portlet:actionURL>
<%	licencia_permiso permiso = (licencia_permiso)renderRequest.getAttribute("permiso");
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
%>


<script>
$( function() {
   	$( "#f_inicial" ).datepicker({
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
	$( "#f_final" ).datepicker({
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
	<div class="container">
		<liferay-ui:success key="editado" message="El permiso ha sido actualizado en la base de datos." />
		<liferay-ui:error key="noEditado" message="Hubo un error al intentar editar el permiso." />
		<liferay-ui:error key="noEncontrado" message="No se encontró el permiso." />
		<div class="row">
			<div class="col-md-12">
				<form method="post" action="<%= editarPermiso %>">
					<input type="hidden" name="id" value="<%= permiso.getId() %>">
					<div class="form-group">
						<label>Beneficiaro del Permiso:</label>
						<input type="text" class="form-control input-sm" disabled value="<%= renderRequest.getPortletSession().getAttribute("userName") %>">
					</div>
					<div class="form-group">
						<label>Número de Identificación:</label>
						<input class="form-control input-sm" disabled value="<%= renderRequest.getPortletSession().getAttribute("identificacion") %>">
					</div>
					<div class="form-group">
						<label>Tipo de Permiso:</label>
						<select class="form-control" name="tipo">
							<%	for(tipo elemento: tipoLocalServiceUtil.gettipos(-1, -1)){ 
									if(elemento.getId() == permiso.getTipofk()){ %>
										<option selected value="<%= elemento.getId() %>"><%= elemento.getDescripcion() %></option>
									<% }else {%>
										<option value="<%= elemento.getId() %>"><%= elemento.getDescripcion() %></option>
							<% }} %>
						</select>
					</div>
					<div class="form-group">
						<label>Acto Administrativo: </label>
						<input class="form-control input-sm" name="actoAdmin" value="<%= permiso.getActoadmin() %>">
					</div>
					<div class="form-group">
						<label>Inicio del Permiso:</label>
						<input type="text" name="f_inicial" id="f_inicial" value="<%= formato.format(permiso.getFechainicio()) %>" placeholder="dd/mm/yyyy" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}">
					</div>
					<div class="form-group">
						<label>Fin del Permiso:</label>
						<input type="text" name="f_final" id="f_final" value="<%= formato.format(permiso.getFechafin()) %>" placeholder="dd/mm/yyyy" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}">
						<input style="display: none" type="text" name="validarF" id="validarF" required>
					</div>
					<div class="form-group">
						<label>Horas Laborales: </label>
						<input type="number" min="0" step="1" name="horas" value="<%= permiso.getHoras() %>">
					</div>
					<div class="form-group">
						<label>Minutos Laborales: </label>
						<input type="number" min="0" step="1" name="minutos" value="<%= permiso.getMinutos() %>" max="59">
					</div>
					<div class="form-group">
						<label>Cancelar Permiso:</label>
						<input style="width: 20px; height: 20px;" type="checkbox" name="cancelar" id="cancelar" value="cancelado" <%if(permiso.getEstatus()==0){%><%="checked"%><%} %>>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-default btn-buscar" onclick="validarFechas()">Actualizar</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
function validarFechas(){
	document.getElementById("validarF").value="";
	var fechaInicial = new Date();
	var fechaFinal = new Date();
	var fechaInferior = new Date(2018, 10 , 22);
	var hayFS = false;
	if(document.getElementById("f_inicial").value != ''){
		var fechaInicial_aux = document.getElementById("f_inicial").value.split("/");
		fechaInicial = new Date(parseInt(fechaInicial_aux[2]),parseInt(fechaInicial_aux[1]-1),parseInt(fechaInicial_aux[0]),parseInt("00"),parseInt("00"));
		
		if( fechaInicial < fechaInferior ){
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
	if(document.getElementById("f_final").value != ''){
		var fechaFinal_aux = document.getElementById("f_final").value.split("/");
	 	fechaFinal = new Date(parseInt(fechaFinal_aux[2]),parseInt(fechaFinal_aux[1]-1),parseInt(fechaFinal_aux[0]),parseInt("23"),parseInt("59"));
	 	if(fechaFinal.getDay()==0 || fechaFinal.getDay()==6){
			if(confirm("La fecha final ingresada es un fin de semana esta seguro que desea seleccionar esa fecha?")){
	 			
	 		}else{
	 			hayFS=true;
	 		}
		}
	}
	
 	if(document.getElementById("f_inicial").value != '' && document.getElementById("f_final").value != ''){
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