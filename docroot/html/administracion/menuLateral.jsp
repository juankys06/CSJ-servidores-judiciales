<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import = "co.com.csj.model.permisos" %>
<%@page import = "co.com.csj.service.permisosLocalServiceUtil" %>
<%@page import = "com.liferay.portal.model.Role" %>
<%@page import = "com.liferay.portal.service.UserLocalServiceUtil" %>

<portlet:defineObjects />

<portlet:renderURL var="auditoria" >
	<portlet:param name="mvcPath" value="/html/administracion/auditoria/view.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="usuarios" >
	<portlet:param name="mvcPath" value="/html/administracion/usuariospermisos/view.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="alertasP" >
	<portlet:param name="mvcPath" value="/html/administracion/alertas/viewP.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="alertasD" >
	<portlet:param name="mvcPath" value="/html/administracion/alertas/viewD.jsp"/>
</portlet:renderURL>


<%
	permisos login = permisosLocalServiceUtil.getByUser(request.getRemoteUser());
	boolean isAdmin = false;
	for(Role role : UserLocalServiceUtil.getUser(Long.parseLong(request.getRemoteUser())).getRoles())
		if(role.getName().equals("Administrator"))
			isAdmin = true;
%>

<nav class="navbar navbar-default sidebar" >
    <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>      
	    </div>
	    <div class="navbar-nav" id="bs-sidebar-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li id="btn-1">
	        	<a href="${auditoria }" style="font-weight: bold; color:black; border-bottom: 1px solid; border-top: 1px solid;">Auditoria</a>
	        </li>
	        <li id="btn-2">
	        	<a href="${usuarios }" style="font-weight: bold; color:black; border-bottom: 1px solid;">Usuarios</a>
	        </li>
	        <li id="btn-n">
	        	<a style="font-weight: bold; color:black; border-bottom: 1px solid;">Alertas</a>
	        	<ul class="nav navbar-nav">
		        		<li id="btn-3"><a href="${alertasP }" style="font-weight: bold; color:black; border-bottom: 1px solid;">&nbsp;&nbsp;&nbsp;&nbsp;Permisos</a></li>
		        		<li id="btn-4"><a href="${alertasD }" style="font-weight: bold; color:black; border-bottom: 1px solid;">&nbsp;&nbsp;&nbsp;&nbsp;Docencia</a></li>
					</ul>
	        </li>
	      </ul>
	    </div>
  </div>
</nav>