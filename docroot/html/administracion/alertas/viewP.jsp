<%@page import="java.util.Calendar"%>
<%@page import="co.com.csj.service.alertaLocalServiceUtil"%>
<%@page import="co.com.csj.model.alerta"%>
<%@page import="java.text.Format"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="co.com.csj.modelos.localizacion"%>
<%@page import="co.com.csj.service.auditoriaPLocalServiceUtil"%>
<%@page import="co.com.csj.model.auditoriaP"%>
<%@page import="co.com.csj.modelos.consultas"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<portlet:defineObjects />
<%
	Date hoy = new Date();
	int trimestreActual = (hoy.getMonth()/3)+1;
	if(renderRequest.getPortletSession().getAttribute("trimestreP")!=null){
		String a = (String) renderRequest.getPortletSession().getAttribute("trimestreP");
		trimestreActual=Integer.parseInt(a);
	}
	List<User> noRegistraron = consultas.getUsuariosNoRegistran(trimestreActual);
	List<localizacion> departamentos = consultas.obtenerMDepartamentos();
	List<localizacion> municipios = consultas.obtenerTodosMuni();
	alerta alertP = alertaLocalServiceUtil.getalerta("permisos");
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/administracion/alertas/viewP.jsp"/>
</liferay-portlet:renderURL>

<portlet:resourceURL var="Exportar">
	<portlet:param name="action" value="exportarNoReportan"/>
	<portlet:param name="trimestre" value="<%=String.valueOf(trimestreActual) %>"/>
</portlet:resourceURL>

<portlet:resourceURL var="alerta">
	<portlet:param name="action" value="alertaGuardarP" />
</portlet:resourceURL>

<portlet:actionURL var="enviarAlertaP" name="enviarAlertaP">
	<portlet:param name="trimestre" value="<%=String.valueOf(trimestreActual) %>"/>
</portlet:actionURL>

<portlet:actionURL var="trimestreActualP" name="trimestreActualP">
</portlet:actionURL>

<portlet:actionURL var="trimestreAnteriorP" name="trimestreAnteriorP">
	<portlet:param name="trimestre" value="<%=String.valueOf(trimestreActual-1) %>"/>
</portlet:actionURL>

<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/administracion/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<div class="content">
		<div class="row">
			<div class="col-lg-12" style="text-align: center;">
				<%if(renderRequest.getPortletSession().getAttribute("trimestreP")==null || renderRequest.getPortletSession().getAttribute("trimestreP").equals("")){ %>
					<h1 style="font-size: 3em; margin: 0 0;">Trimestre en Curso</h1>
					<%if(trimestreActual==1){ %>
						<h1 style="color: red;">Enero - Marzo</h1>
					<% } %>
					<%if(trimestreActual==2){ %>
						<h1 style="color: red;">Abril - Junio</h1>
					<% } %>
					<%if(trimestreActual==3){ %>
						<h1 style="color: red;">Julio - Septiembre</h1>
					<% } %>
					<%if(trimestreActual==4){ %>
						<h1 style="color: red;">Octubre - Diciembre</h1>
					<% } %>
					<a style="background: #19325b;color: #fff; border-radius: 0;" class="btn" href="${trimestreAnteriorP}">Trimestre Anterior</a>
					<br>
					<br>
				<%}else{ %>
					<h1 style="font-size: 3em; margin: 0 0;">Trimestre Anterior</h1>
					<%if(trimestreActual==1){ %>
						<h1 style="color: red;">Enero - Marzo</h1>
					<% } %>
					<%if(trimestreActual==2){ %>
						<h1 style="color: red;">Abril - Junio</h1>
					<% } %>
					<%if(trimestreActual==3){ %>
						<h1 style="color: red;">Julio - Septiembre</h1>
					<% } %>
					<%if(trimestreActual==4){ %>
						<h1 style="color: red;">Octubre - Diciembre</h1>
					<% } %>
					<a style="background: #19325b;color: #fff; border-radius: 0;" class="btn" href="${trimestreActualP}">Trimestre Actual</a>
					<br>
					<br>
				<%} %>
			</div>
		</div>
		<div class="row">
			<div class="col-mg-12" style="text-align: center;">
				<a style="background: #19325b;color: #fff; border-radius: 0;" class="btn" href="${enviarAlertaP}">Enviar Alerta</a>
				<a style="background: #19325b;color: #fff; border-radius: 0;" class="btn" data-toggle="modal" href="#mi_modal">Editar Alerta</a>
			</div>
				
		</div>
		<br>
		<br>
		<div class="row">
			<div class="col-md-12">
				<h2 style="color:red;">Usuarios que no han registrado permisos en el trimestre en curso</h2>
			</div>
			<div class="col-md-12">
				<liferay-ui:search-container   delta="10" deltaConfigurable="true"  emptyResultsMessage="No hay Resultados" iteratorURL="<%=iteratorURL%>">
					<liferay-ui:search-container-results>
						<%
							String keywords =	ParamUtil.getString(request, "keywords");
												results = ListUtil.subList(noRegistraron,
														searchContainer.getStart(),
														searchContainer.getEnd());
							total = noRegistraron.size();
							searchContainer.setTotal(noRegistraron.size());
							pageContext.setAttribute("results", results);
							pageContext.setAttribute("total", total);
						%>
					</liferay-ui:search-container-results>    
					<liferay-ui:search-container-row className="com.liferay.portal.model.User" keyProperty="UserId" modelVar="usu">
						<liferay-ui:search-container-column-text name="Nombre"	value="<%=usu.getFullName() %>" />
						<liferay-ui:search-container-column-text name="Correo Electronico"	value="<%=usu.getEmailAddress() %>" />
						<liferay-ui:search-container-column-text name="Cargo"	value="<%=consultas.getCargoUsuario(usu.getUserId()) %>" />
						<%
								String despar = "";
						       	String muni = "";
						       	if(consultas.getCargoUsuario(usu.getUserId()).equalsIgnoreCase("Magistrado") || consultas.getCargoUsuario(usu.getUserId()).equalsIgnoreCase("Magistrado Seccional") || consultas.getCargoUsuario(usu.getUserId()).equalsIgnoreCase("Permisos por Distrito") || consultas.getCargoUsuario(usu.getUserId()).equalsIgnoreCase("Permisos y Docencia por Distrito"))
						       		for(localizacion d : departamentos)
						       			for(String l : consultas.getUsuarioAsociado(usu.getUserId()))
							       			if(d.getCod_dane().equalsIgnoreCase(l) && d.getCod_dane_departamento().equalsIgnoreCase(l))
							       				despar+=d.getNombre()+"<br>";
		
						       	if(consultas.getCargoUsuario(usu.getUserId()).equalsIgnoreCase("Juez")){
						       		for(localizacion departamento : departamentos)
						       			for(String l : consultas.getUsuarioAsociado(usu.getUserId()))
							       			if(departamento.getCod_dane().equalsIgnoreCase(l.substring(0, 2)) && departamento.getCod_dane_departamento().equalsIgnoreCase(l.substring(0, 2)))
							       				despar = departamento.getNombre();
						       		
						       		for(localizacion d : municipios)
						       			for(String l : consultas.getUsuarioAsociado(usu.getUserId()))
							       			if(l.equalsIgnoreCase(d.getCod_dane_departamento()+d.getCod_dane()))
							       				muni=d.getNombre();
						       	}
						    %>
						    <liferay-ui:search-container-column-text name="Departamento" value="<%=despar %>"></liferay-ui:search-container-column-text>
					        <liferay-ui:search-container-column-text name="Municipio" value="<%=muni %>"></liferay-ui:search-container-column-text>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
			</liferay-ui:search-container>
			</div>
			<div class="col-md-12" style="text-align: center;">
				<aui:button value="Exportar" onClick="<%= Exportar %>"></aui:button>
			</div>
		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="mi_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">
            <span aria-hidden="true">&times;</span><span class="sr-only">Cerrar</span>
          </button>
          <h4 class="modal-title" id="myModalLabel">Contenido de la Alerta</h4>
        </div>
        <div class="modal-body">
          <div class="row" style="padding:15px">
            <div class="col-mg-12" align="left">
    			<div class="form-group">
		           	<label for="recipient-name" class="control-label">Asunto del Correo:</label>
		         	<input type="text" class="form-control" id="asunto" value="<%=alertP.getAsunto()%>">
		         </div>
		         <div class="form-group">
		           	<label for="recipient-name" class="control-label">Contenido:</label>
		         	<textarea rows="15" class="form-control" id="aletaTexto"><%=alertP.getMensaje()%></textarea> 
		         </div>
            </div>                  
          </div>
        </div>
        <div class="modal-footer">
          <a class="btn" style="background: #19325b;color: #fff; border-radius: 0;" data-dismiss="modal" onclick="alertaGuardar()">Guardar</a>
        </div>
      </div>
    </div>
  </div>
<script type="text/javascript">
$(document).ready( function(){
	$("#btn-3").addClass("active");
});

function alertaGuardar(){
	var asunto = document.getElementById('asunto').value;
	var contenido = document.getElementById('aletaTexto').value;
	$.ajax({
		url: '<%=alerta%>',
        type:  'post',
        dataType: 'json',
        data:  {asuntoAP : asunto, contenidoAP : contenido },
        success:  function (response) {
        }
	});
}

</script>