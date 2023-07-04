<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="co.com.csj.model.licencia_permiso" %>

<portlet:defineObjects />

<%	
	boolean isAdmin = false;
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	licencia_permiso permiso = (licencia_permiso)row.getObject();
	for(Role role : UserLocalServiceUtil.getUser(Long.parseLong(request.getRemoteUser())).getRoles())
		if(role.getName().equals("Administrator"))
			isAdmin = true;
%>

<liferay-ui:icon-menu>	
	<portlet:actionURL  name="editarPermiso" var="editarPermiso">
       <portlet:param name="id" value="<%= String.valueOf(permiso.getId()) %>"/>	    
   	</portlet:actionURL>
   	<liferay-ui:icon image="edit"  message="Actualizar Permiso" url="<%= editarPermiso %>"/>
    <portlet:actionURL  name="detallePermiso" var="detallePermiso">
		<portlet:param name="id" value="<%= String.valueOf(permiso.getId()) %>"/>	    
    </portlet:actionURL>
    <liferay-ui:icon image="edit"  message="Detalle del Permiso" url="<%= detallePermiso %>"/>
    <%if(isAdmin){ %>
	    <portlet:actionURL  name="eliminarPermiso" var="eliminarPermiso">
			<portlet:param name="id" value="<%= String.valueOf(permiso.getId()) %>"/>	    
	    </portlet:actionURL>
	    <liferay-ui:icon image="delete"  message="Eliminar Permiso" url="<%= eliminarPermiso %>"/>
	<%	} %>
    
</liferay-ui:icon-menu>