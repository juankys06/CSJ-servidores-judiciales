<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import = "co.com.csj.model.permisos" %>
<%@page import = "co.com.csj.service.permisosLocalServiceUtil" %>
<%@page import = "com.liferay.portal.model.Role" %>
<%@page import = "com.liferay.portal.service.UserLocalServiceUtil" %>

<portlet:defineObjects />
<portlet:actionURL name="verPermisos" var="home"></portlet:actionURL>
<portlet:actionURL name="verDocencias" var="docencias"></portlet:actionURL>
<portlet:renderURL var="form1" >
	<portlet:param name="mvcPath" value="/html/servidoresjudiciales/vistaUsuarioPermisos.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="excelP" >
	<portlet:param name="mvcPath" value="/html/servidoresjudiciales/permisosexcel.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="excelD" >
	<portlet:param name="mvcPath" value="/html/servidoresjudiciales/docenciasexcel.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="form2" >
	<portlet:param name="mvcPath" value="/html/servidoresjudiciales/vistaUsuarioDocencia.jsp"/>
</portlet:renderURL>
<portlet:actionURL name="reports" var="reportes"></portlet:actionURL>
<portlet:actionURL name="reportesDocencia" var="reportesDocencia"></portlet:actionURL>
<portlet:renderURL var="reportesDespachos" >
	<portlet:param name="mvcPath" value="/html/servidoresjudiciales/reportesDespachos.jsp"/>
</portlet:renderURL>

<%
	permisos login = permisosLocalServiceUtil.getByUser(request.getRemoteUser());
	boolean isAdmin = false;
	for(Role role : UserLocalServiceUtil.getUser(Long.parseLong(request.getRemoteUser())).getRoles())
		if(role.getName().equals("Administrator"))
			isAdmin = true;
%>

<nav class="navbar navbar-default sidebar">
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
	        <li><a id="btn-1">PERMISOS</a>
	        	<ul class="nav navbar-nav" >
					<li id="menu-cargarPermisos"><a href="${form1}">&nbsp;&nbsp;&nbsp;&nbsp;Agregar Permisos<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-tags"></span></a></li>
					<% if(!login.getCargo().equals("Juez")){ %>
					<li id="menu-permisosexcel"><a href="${excelP}">&nbsp;&nbsp;&nbsp;&nbsp;Permisos Excel<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-open-file"></span></a></li>
					<% } %>
					<li id="menu-permisosUsuario"><a href="${home}">&nbsp;&nbsp;&nbsp;&nbsp;Consultar Permisos<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-book"></span></a></li>
				</ul>
	        </li>
	        <% if(isAdmin || login.getCargo().equals("Magistrado Seccional") || login.getCargo().equals("Permisos y Docencia Nacional") || login.getCargo().equals("Permisos y Docencia por Distrito") ){ %>
		        <li><a id="btn-2">DOCENCIA</a>
		        	<ul class="nav navbar-nav">
		        		<li id="menu-cargarDocencias"><a href="${form2}">&nbsp;&nbsp;&nbsp;&nbsp;Agregar Docencia<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-tags"></span></a></li>
		        		<li id="menu-docenciaexcel"><a href="${excelD}">&nbsp;&nbsp;&nbsp;&nbsp;Docencia Excel<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-open-file"></span></a></li>
						<li id="menu-docenciasUsuario"><a href="${docencias}">&nbsp;&nbsp;&nbsp;&nbsp;Consultar Docencias<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-book"></span></a></li>
					</ul>
		        </li>
	        <%} %>
	        <%if(isAdmin){ %>
	        	<li><a id="btn-3">REPORTES</a>
		        	<ul class="nav navbar-nav">
		        		<li id="menu-reportesPermisos"><a href="${reportes}">&nbsp;&nbsp;&nbsp;&nbsp;Permisos<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-book"></span></a>
		        		<li id="menu-reportesDocencias"><a href="${reportesDocencia}">&nbsp;&nbsp;&nbsp;&nbsp;Docencia<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-book"></span></a>
		        		<li id="menu-reportesDocencias"><a href="${reportesDespachos}">&nbsp;&nbsp;&nbsp;&nbsp;Por Despachos<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-book"></span></a>
					</ul>
		        </li>
	        <%} %>
	      </ul>
	    </div>
  </div>
</nav>