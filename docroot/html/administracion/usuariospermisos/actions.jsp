<%@page import="co.com.csj.model.permisos"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%	ResultRow row=( ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	permisos usuariosgenero= (permisos)row.getObject();
	String id=String.valueOf(usuariosgenero.getId());
	String urlAux="";
%>

<liferay-ui:icon-menu>	
	
	<portlet:actionURL  name="eliminarUsuario" var="eliminarUsuario">
	       <portlet:param name="id" value="<%=id%>"/>	    
    </portlet:actionURL>
    
    	    
   <liferay-ui:icon image="delete"  message="eliminar" url="<%=eliminarUsuario %>"/>	
</liferay-ui:icon-menu>