<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="co.com.csj.model.licencia_permiso" %>
<%@page import="co.com.csj.model.usuario" %>
<%@page import="co.com.csj.service.permisosLocalServiceUtil"%>

<portlet:defineObjects />
<%	licencia_permiso permiso = (licencia_permiso)renderRequest.getAttribute("permiso");
	usuario user = (usuario)renderRequest.getAttribute("user");
%>

<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/servidoresjudiciales/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<%if(permiso.getEstatus()==0){ %>
				<label class="permiso-cancelado" style="font-size: 2em">PERMISO CANCELADO</label>
				<br>
				<%} %>
				<label>Beneficiaro del Permiso: </label><span><%= user.getNomb() + " " + user.getApe() %></span>
				<br>
				<label>Número de Identificación: </label><span><%= user.getId() %></span>
				<br>
				<label>Acto Administrativo: </label><span><%= permiso.getActoadmin() %></span>
				<br>
				<label>Tipo de Permiso: </label><span><%= renderRequest.getAttribute("tipo_permiso") %></span>
				<br>
				<label>Inicio del Permiso: </label><span><%= renderRequest.getAttribute("fecha_inicial") %></span>
				<br>
				<label>Fin del Permiso: </label><span><%= renderRequest.getAttribute("fecha_final") %></span>
				<br>
				<label>Horas Laborales: </label><span><%= String.valueOf(permiso.getHoras())+" horas y "+String.valueOf(permiso.getMinutos())+" minutos" %></span>
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