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

<portlet:resourceURL var="reporteDespachos" >
	<portlet:param name="action" value="reporteDespachos"/>
</portlet:resourceURL>

<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/servidoresjudiciales/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<liferay-ui:success key="eliminado" message="El permiso ha sido eliminado." />
	<div class="container">
		<div class="row">
			<form method="post" action="<%= reporteDespachos %>">
				<div class="col-lg-4">
					<div class="col-lg-12">
						<label class="label-form" for="tipo">Tipo Permisos/Docencias</label>
					</div>
					<div class="col-lg-12">
						<select class="select-option" name="tipo" id="tipo" required>
							<option value="" selected>Seleccione...</option>
							<option value="1">Permisos</option>
							<option value="2">Docencias</option>
						</select>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="col-lg-12">
						<label class="label-form" for="fechaInicial">Fecha Inicial</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" type="date" name="fechaInicial" id="fechaInicial">
					</div>
				</div>
				<div class="col-lg-4">
					<div class="col-lg-12">
						<label class="label-form" for="fechaFinal">Fecha Final</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" type="date" name="fechaFinal" id="fechaFinal">
					</div>
					<input style="display: none" type="text" name="validarF" id="validarF" required>
				</div>
				<div class="col-lg-12" style="text-align: center;">
					<input type="submit" class="btn" onclick="validarFechas()" value="Generar reporte" formtarget="_blank">
				</div>
				 
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">

function validarFechas(){
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
 			document.getElementById("validarF").value="";
 			alert("La fecha inicial no puede ser mayor que la fecha final");
 		}else{
 			document.getElementById("validarF").value="1";
 		}
 	}else{
 		document.getElementById("validarF").value="1";
 	}
 	
 }
</script>