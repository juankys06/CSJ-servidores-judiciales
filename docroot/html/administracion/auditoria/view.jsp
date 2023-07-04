<%@page import="java.text.Format"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.com.csj.service.auditoriaPLocalServiceUtil"%>
<%@page import="co.com.csj.model.auditoriaP"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<portlet:defineObjects />
<%
	List<auditoriaP> auditoria = new ArrayList<auditoriaP>();
	List<auditoriaP> aux = (List<auditoriaP>) renderRequest.getPortletSession().getAttribute("auditoria");
	if(aux!=null){
		auditoria = aux;
	}
%>


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/administracion/auditoria/view.jsp"/>
</liferay-portlet:renderURL>

<portlet:resourceURL var="reporte">
	<portlet:param name="action" value="reporteAuditoria"/>
</portlet:resourceURL>

<portlet:actionURL name="buscarAuditoria" var="buscarAuditoria" />

<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/administracion/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<div class="content">
		<form action="${buscarAuditoria }" method="post" id="form1">
			<div class="row">
				<div class="col-lg-4">
					<div class="col-lg-12">
						<label class="label-form" for="tipoRecurso">Tipo de recurso</label>
					</div>
					<div class="col-lg-12">
						<select class="select-option" name="tipoRecurso" id="tipoRecurso">
							<option value="">Seleccione...</option>
							<option value="1">Solicitante</option>
							<option value="2">Permisos</option>
							<option value="3">Docencias</option>
							<option value="4">Usuario</option>
						</select>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="col-lg-12">
						<label class="label-form" for="fechaInicial">Fecha inicial</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" type="date" name="fechaInicial" id="fechaInicial">
					</div>
				</div>
				<div class="col-lg-4">
					<div class="col-lg-12">
						<label class="label-form" for="fechaFinal">Fecha final</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" type="date" name="fechaFinal" id="fechaFinal">
						<input style="display: none" type="text" name="validarF" id="validarF" required>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="col-lg-12">
						<label class="label-form" for="idRecusro">Código del recurso/Cédula del usuario asociado al Permiso o Docencia</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" type="text" name="idRecurso" id="idRecurso">
					</div>
				</div>
				<div class="col-lg-6">
					<div class="col-lg-12">
						<label class="label-form" for="correo">Correo del registrador</label>
					</div>
					<div class="col-lg-12">
						<input class="select-option" type="text" name="correo" id="correo">
					</div>
				</div>
				<div class="col-lg-5" style="text-align: center;">
				</div> 
				<div class="col-lg-1" style="text-align: center;">
					<input type="reset" class="btn" value="Limpiar" onclick="Flimpiar();">
					<input style="display: none" type="text" id="limpiar" name="limpiar">
				</div> 
				<div class="col-lg-1" style="text-align: center;">
					<input type="submit" class="btn" value="Buscar" onclick="validarFechas();">
				</div> 
				<div class="col-lg-5" style="text-align: center;">
				</div> 
			</div>		
		</form>
		<br>
		<br>
		<div class="row">
				<div class="col-md-12">
					<liferay-ui:search-container   delta="10" deltaConfigurable="true"  emptyResultsMessage="No hay Resultados" iteratorURL="<%=iteratorURL%>">
						<liferay-ui:search-container-results>
							<%
								String keywords =	ParamUtil.getString(request, "keywords");
													results = ListUtil.subList(auditoria,
															searchContainer.getStart(),
															searchContainer.getEnd());
								total = auditoria.size();
								searchContainer.setTotal(auditoria.size());
								pageContext.setAttribute("results", results);
								pageContext.setAttribute("total", total);
							%>
						</liferay-ui:search-container-results>    
						<liferay-ui:search-container-row className="co.com.csj.model.auditoriaP" keyProperty="id" modelVar="audi">
							<%
								String recurso = "";
								String modificado = "";
								Format formato = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
								if(audi.getTipo_recurso()==1)
									recurso="Solisitante";
								if(audi.getTipo_recurso()==2)
									recurso="Permiso";
								if(audi.getTipo_recurso()==3)
									recurso="Docencia";
								if(audi.getTipo_recurso()==4)
									recurso="Usuario";
								
							%>
							<liferay-ui:search-container-column-text name="Tipo Recurso"	value="<%=recurso %>" />
							<liferay-ui:search-container-column-text name="Fecha"	value="<%=formato.format(audi.getFecha()) %>" />
							<liferay-ui:search-container-column-text name="Código del Recurso"	value="<%=audi.getId_recurso_modificado() %>" />
							<liferay-ui:search-container-column-text name="Accion"	value="<%=audi.getTipo_operacion() %>" />
							<liferay-ui:search-container-column-text name="Modificado por"	value="<%=audi.getCorreo() %>" />
							<liferay-ui:search-container-column-text name="Modificacion"	value="<%=audi.getModificacion() %>" />	
						</liferay-ui:search-container-row>
						<liferay-ui:search-iterator />
				</liferay-ui:search-container>
				</div>
				<div class="col-md-12" style="text-align: center;">
				<aui:button value="Exportar" onClick="<%= reporte %>"></aui:button>
			</div>
			</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready( function(){
	$("#btn-1").addClass("active");
});

function Flimpiar(){
	document.getElementById("limpiar").value="1";
	document.getElementById("form1").submit();
}

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
 			alert("La fecha inicial no puede ser mayor que la fecha final");
 		}else{
 			document.getElementById("validarF").value="1";
 		}
 	}else{
 		document.getElementById("validarF").value="1";
 	}
 	
 }
</script>