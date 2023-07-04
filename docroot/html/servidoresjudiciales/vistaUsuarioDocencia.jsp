<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import ="java.util.List" %> 
<%@page import ="co.com.csj.model.tipo_documento" %>
<%@page import = "co.com.csj.service.tipo_documentoLocalServiceUtil" %>
<%@page import ="co.com.csj.model.permisos" %>
<%@page import = "co.com.csj.service.permisosLocalServiceUtil" %>
<%@page import = "com.liferay.portal.model.Role" %>
<%@page import = "com.liferay.portal.service.UserLocalServiceUtil" %>

<portlet:defineObjects />

<%	List<tipo_documento> tipoDocumento = tipo_documentoLocalServiceUtil.gettipo_documentos(-1, -1); 
	permisos login = permisosLocalServiceUtil.getByUser(request.getRemoteUser());
	boolean isAdmin = false;
	for(Role role : UserLocalServiceUtil.getUser(Long.parseLong(request.getRemoteUser())).getRoles())
		if(role.getName().equals("Administrator"))
			isAdmin = true;
%>


<portlet:actionURL name="buscar_docencia" var="buscar_docencia"></portlet:actionURL>

<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/servidoresjudiciales/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<div class="container">
		 <div class="row"> 
			<div class="col-lg-12 col-md-12 col-xs-12 text-center">
				<h1>Ingrese Número de Documento del Solicitante de la Docencia</h1>
			</div>
		<!-- </div> -->
		<!-- <div class="row"> -->
			
				<form action="<%= buscar_docencia %>" id="buscar_usuario" name="buscar_usuario" method="post">
					<div class="col-lg-2 col-md-2 col-xs-12"></div>
					<div class="col-lg-4 col-md-4 col-xs-12">
					<div class="col-lg-12 col-md-12 col-xs-12">
						<label class="label-form">Tipo de Documento...</label>
					</div>
					<div class="col-lg-12 col-md-12 col-xs-12">
						<select name="tipo_doc" id="tipo_doc" class="select-option" required="required">
							<%
							for(tipo_documento tp : tipoDocumento){
								%>
								<option value="<%= tp.get_id()%>" <%= tp.get_id()==1?"selected":"" %>><%= tp.getDesc() %> </option>
								<%
							}
							%>
						</select>
					</div>
					</div>
					<div class="col-lg-4 col-md-4 col-xs-12">
					<div class="col-lg-12 col-md-12 col-xs-12">
						<label class="label-form">Número de Documento...</label>
					</div>
					<div class="col-lg-12 col-md-12 col-xs-12">
					<input type="text" required="required" name="cedula" id="cedula" class="select-option" pattern="\d*" placeholder="123456789"/>
					</div>
					</div>
					<div class="row block-margintop-3em">
						<div class="col-md-12 text-center block-btn-filter">
							<input type="submit" value="Siguiente" class="btn  btn-green"/>
						</div>
					</div>
				</form>
			
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready( function(){
	$("#menu-cargarDocencias").addClass("active");
});
</script>
