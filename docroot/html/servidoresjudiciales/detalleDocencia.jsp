<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="co.com.csj.model.Docencia" %>
<%@page import="co.com.csj.model.usuario" %>
<%@page import="co.com.csj.service.permisosLocalServiceUtil"%>

<portlet:defineObjects />
<%	Docencia permiso = (Docencia)renderRequest.getAttribute("permiso");
	usuario user = (usuario)renderRequest.getAttribute("user");
%>

<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/servidoresjudiciales/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<label>Beneficiaro de la Docencia: </label><span><%= user.getNomb() + " " + user.getApe() %></span>
				<br>
				<label>Número de Identificación: </label><span><%= user.getId() %></span>
				<br>
				<label>Inicio de la Docencia: </label><span><%= renderRequest.getAttribute("fecha_inicial") %></span>
				<br>
				<label>Fin de la Docencia: </label><span><%= renderRequest.getAttribute("fecha_final") %></span>
				<br>
				<label>Materia: </label><span><%= permiso.getMateria() %></span>
				<br>
				<label>horas de Docencia: </label><span><%= String.valueOf(permiso.getHoras())+" horas y "+String.valueOf(permiso.getMinutos())+" minutos" %></span>
				<br>
				<label>Institución: </label><span><%= permiso.getInstitucion() %></span>
				<br>
				<label>Despacho: </label><span><%= renderRequest.getAttribute("nombreDespacho") %></span>
				<br>
				<label>Municipio: </label><span><%= renderRequest.getAttribute("municipio") %></span>
				<br>
				<label>Distrito: </label><span><%= renderRequest.getAttribute("distrito") %></span>
				<br>
				<label>Departamento: </label><span><%= renderRequest.getAttribute("departamento") %></span>
				<br>
				<label>Agregado por: </label><span><%= renderRequest.getAttribute("creator_username") %></span>
				<br>
				<label>Modificado por: </label><span><%= renderRequest.getAttribute("mod_username") %></span>
			</div>
		</div>
	</div>
</div>