<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Role"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@page import="co.com.csj.model.Docencia" %>

<portlet:defineObjects />

<%	
	boolean isAdmin = false;
	for(Role role : UserLocalServiceUtil.getUser(Long.parseLong(request.getRemoteUser())).getRoles())
		if(role.getName().equals("Administrator"))
			isAdmin = true;
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Docencia permiso = (Docencia)row.getObject();
%>

<liferay-ui:icon-menu>	
	<portlet:actionURL  name="editarDocencia" var="editarDocencia">
       <portlet:param name="id" value="<%= String.valueOf(permiso.getId()) %>"/>	    
   	</portlet:actionURL>
   	<liferay-ui:icon image="edit"  message="Actualizar Docencia" url="<%= editarDocencia %>"/>
    <portlet:actionURL  name="detalleDocencia" var="detalleDocencia">
		<portlet:param name="id" value="<%= String.valueOf(permiso.getId()) %>"/>	    
    </portlet:actionURL>
    <liferay-ui:icon image="edit"  message="Detalle de Docencia" url="<%= detalleDocencia %>"/>
    
    <%if(isAdmin){ %>
	    <portlet:actionURL  name="eliminarDocencia" var="eliminarDocencia">
			<portlet:param name="id" value="<%= String.valueOf(permiso.getId()) %>"/>	    
	    </portlet:actionURL>
	    <liferay-ui:icon image="delete"  message="Eliminar Docencia" url="<%= eliminarDocencia %>"/>
	<%	} %>
    
</liferay-ui:icon-menu>