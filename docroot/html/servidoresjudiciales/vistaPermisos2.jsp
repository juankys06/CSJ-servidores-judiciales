<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="co.com.csj.modelos.despacho"%>
<%@page import="co.com.csj.modelos.entidad"%>
<%@page import="co.com.csj.modelos.especialidad"%>
<%@page import="co.com.csj.modelos.consultas"%>
<%@page import="co.com.csj.modelos.localizacion"%>
<%@page import = "co.com.csj.modelos.Area"%>
<%@page import="co.com.csj.service.permisosLocalServiceUtil"%>
<%@page import="co.com.csj.model.permisos"%>
<%@page import = "com.liferay.portal.model.Role" %>
<%@page import = "com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import ="co.com.csj.model.tipo" %>
<%@page import ="co.com.csj.model.licencia_permiso" %>
<%@page import ="co.com.csj.model.cargo" %>
<%@page import ="co.com.csj.model.usuario" %>
<%@page import ="co.com.csj.model.tipo_documento" %>
<%@page import ="java.util.ArrayList"  %>
<%@page import ="java.util.List" %> 
<%@page import = "co.com.csj.service.tipoLocalServiceUtil" %>
<%@page import = "co.com.csj.service.licencia_permisoLocalServiceUtil" %>
<%@page import = "co.com.csj.service.cargoLocalServiceUtil" %>
<%@page import = "co.com.csj.service.usuarioLocalServiceUtil" %>
<%@page import = "co.com.csj.service.tipo_documentoLocalServiceUtil" %>

<portlet:defineObjects />


<portlet:actionURL name="consulta_permisos" var="consulta_permisos"></portlet:actionURL>
<portlet:actionURL name="addPermiso" var="addPermiso"></portlet:actionURL>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/html/servidoresjudiciales/vistaPermisos2.jsp"/>
</liferay-portlet:renderURL>
<portlet:actionURL name="actualizar_persona" var="actualizar_persona"></portlet:actionURL>
<%
	permisos login = permisosLocalServiceUtil.getByUser(request.getRemoteUser());
	boolean isAdmin = false;
	for(Role role : UserLocalServiceUtil.getUser(Long.parseLong(request.getRemoteUser())).getRoles())
		if(role.getName().equals("Administrator"))
			isAdmin = true;
	
	List<localizacion> ciudadesList = new ArrayList<localizacion>();
	List<localizacion> departamentosList = new ArrayList<localizacion>();
	List<Area> areas = consultas.obtenerAreas();
	List<especialidad> especialidades = new ArrayList<especialidad>();
	List<entidad> entidades = new ArrayList<entidad>();
	List<tipo> tipos_permisos = new ArrayList<tipo>();
	List<licencia_permiso> permisos = new ArrayList<licencia_permiso>();
	List<cargo> cargos = new ArrayList<cargo>();
	List<tipo_documento> tipoDocumento = new ArrayList<tipo_documento>();
	
	if(login.getCargo().equalsIgnoreCase("Juez"))
		ciudadesList = consultas.obtenerMunicipio(login.getD_m());

	if(login.getCargo().equalsIgnoreCase("Magistrado") || login.getCargo().equalsIgnoreCase("Magistrado Seccional"))
		ciudadesList = consultas.obtenerMunicipios(login.getD_m());
	
	if(login.getCargo().equalsIgnoreCase("Permisos por Distrito") || login.getCargo().equalsIgnoreCase("Permisos y Docencia por Distrito"))
		ciudadesList = consultas.obtenerMunicipiosR(login.getUsuario());
	
	especialidades = consultas.obtenerEspecialidades();
	entidades = consultas.obtenerEntidades();
	tipos_permisos = tipoLocalServiceUtil.gettipos(-1, -1);
	cargos = cargoLocalServiceUtil.getcargos(-1, -1);
	tipoDocumento = tipo_documentoLocalServiceUtil.gettipo_documentos(-1, -1);
	
	if(renderRequest.getAttribute("lista_permisos") != null)
		permisos = (List<licencia_permiso>)renderRequest.getAttribute("lista_permisos");
	
	usuario usuarios = (usuario)renderRequest.getPortletSession().getAttribute("usuario");
	despacho des = consultas.obtenerDespachoSel(usuarios.getDespachofk());
	
	String departamentoSelecto = des.getCodigo().substring(0, 2);
	String municipioSelecto = des.getCodigo().substring(0, 5);
	int entidadSelecta = Integer.parseInt(des.getCodigo().substring(5, 7));
	int especialidadSelecta = Integer.parseInt(des.getCodigo().substring(7,9));
	if(login.getCargo().equalsIgnoreCase("Permisos y Docencia Nacional")){
		departamentosList = consultas.obtenerMDepartamentos();
		ciudadesList = consultas.obtenerMunicipios(departamentoSelecto);
	}
%>
<script>
$( function() {
   	$( "#desde" ).datepicker({
							/* beforeShowDay: $.datepicker.noWeekends, */
							dateFormat: 'dd/mm/yy' ,
							minDate: '22/11/2018',
							monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
						   	monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
						   	dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
						   	dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
						   	dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá']
							});
 } );
$( function() {
	$( "#hasta" ).datepicker({
							/* beforeShowDay: $.datepicker.noWeekends, */
							dateFormat: 'dd/mm/yy' ,
							minDate: '22/11/2018',
							monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
						   	monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
						   	dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
						   	dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
						   	dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá']
							});
 } );
</script>
<div style="display: inline-block; vertical-align: top; width: 17%;">
	<jsp:include page="/html/servidoresjudiciales/menuLateral.jsp"></jsp:include>
</div>
<div style="display: inline-block; vertical-align: top; width: 82%;">
	<liferay-ui:success key="usuarioModificado" message="Se ha modificado el usuario." />
	<liferay-ui:success key="usuarioAdded" message="Se ha añadido el usuario y su permiso." />
	<liferay-ui:success key="addedPermiso" message="Se ha añadido el permiso." />
	<liferay-ui:error key="errorModificando" message="Hubo un error al intentar modificar el usuario." />
	<liferay-ui:error key="errorPermiso" message="Hubo un error al intentar agregar el permiso." />
	<div class="container">
	<div class="row">
		<div class="col-lg-12 text-center">
	 		<h1>REGISTRO  DE INFORMACIÓN COMPLEMENTARIA DE SERVIDORES JUDICIALES<br>DATOS DEL FUNCIONARIO/A O EMPLEADO/A JUDICIAL</h1>
	 	</div>
		<form name="addPermiso" id="addPermiso" action="<%= addPermiso %>" method="post">
			<div class="row form-div">
				<div class="col-lg-12">
					<div class=row>
						<div class="col-lg-3">
							<div class="col-lg-12">
								<label class="label-form">Nombre</label>
							</div>
							<div class="col-lg-12">
							<input class="select-option" name="nombre" id="nombre" type="text" placeholder="Nombre" required="required" value="<%= usuarios.getNomb() %>"/>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="col-lg-12">
								<label class="label-form">Apellido</label>
							</div>
							<div class="col-lg-12">
								<input class="select-option" name="apellido" id="apellido" type="text" placeholder="Apellido" required="required" value="<%= usuarios.getApe() %>"/>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="col-lg-12">
								<label class="label-form">Tipo de Documento</label>
							</div>
							<div class="col-lg-12">
								<select name="tipo_doc" id="tipo_doc" class="select-option" disabled>
									<option value="">Seleccione...</option>
									<%
									for(tipo_documento tp : tipoDocumento){
										if(tp.get_id() == usuarios.getTipo_doc()){%>
										<option value="<%= tp.get_id()%>" selected><%= tp.getDesc() %> </option>
										<%
											
										}else{
										%>
										<option value="<%= tp.get_id()%>"><%= tp.getDesc() %> </option>
										<%
											}
									}
									%>
								</select>
							</div>
						</div>
						
						<div class="col-lg-3">
							<div class="col-lg-12">
								<label class="label-form">Número de Documento</label>
							</div>
							<div class="col-lg-12">
								<input class=" select-option" name="cedula" id="cedula" type="text" placeholder="Número de Cédula" required="required" value="<%= usuarios.getId() %>" disabled/>
							</div>
						</div>
					</div>
					<% 
					if(login.getCargo().equalsIgnoreCase("Permisos y Docencia Nacional")){
					%>
						<div class="row">
						 	<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Distrito Judicial</label>
								</div>
								<div class="col-lg-12">
									<input class="select-option" name="djudicial" id="djudicial" type="text" placeholder="Distrito Judicial" disabled />
								</div>
							</div> 
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Departamento</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="departamento" id="departamento" onchange="filtromuni()" required>
										<option value>Seleccione...</option>
										<% for(localizacion cc : departamentosList){
											if(departamentoSelecto.equals(cc.getCod_dane_departamento())){
											%><option selected value="<%= cc.getCod_dane_departamento()%>"><%= cc.getNombre() %></option><%
											} else{
												%><option value="<%= cc.getCod_dane_departamento()%>"><%= cc.getNombre() %></option><%
											}
										} %>
									</select>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Ciudad/Municipio</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="ciudad" id="ciudad" onchange="despachofiltro()" required>
										<option value>Seleccione...</option>
										<% for(localizacion cc : ciudadesList){
											if(municipioSelecto.equals(cc.getCod_dane_departamento()+cc.getCod_dane())){
											%><option selected value="<%= cc.getCod_dane_departamento()+cc.getCod_dane()%>"><%= cc.getNombre() %></option><%
											} else{
												%><option value="<%= cc.getCod_dane_departamento()+cc.getCod_dane()%>"><%= cc.getNombre() %></option><%
											}
										} %>
									</select>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Entidad</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="entidad" id="entidad" onchange="despachofiltro()" required>
										<option value>Seleccione...</option>
										<%
											for(entidad en : entidades){
												if( entidadSelecta == Integer.parseInt(en.getId())){
												%><option selected value="<%= en.getId()%>"> <%= en.getNombre() %></option><%
												} else{
													%><option value="<%= en.getId()%>"> <%= en.getNombre() %></option><%
												}
											}
										%>
									</select>
								</div>
							</div> 
						</div>
						<div class=row>
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form" for="area">Área</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" id="area" name="area" onchange="despachofiltro()">
										<option value>Seleccione...</option>
										<% for(Area area: areas){
											if(area.getId() == des.getArea()){ %>
											<option selected value="<%= area.getId() %>"><%= area.getNombre() %></option>
										<%
											}else{ %>
											<option value="<%= area.getId() %>"><%= area.getNombre() %></option><%	
											}} %>
									</select>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Especialidad</label>
								</div>
								<div class="col-lg-12">
									<select class=" select-option" name="especialidad" id="especialidad" onchange="despachofiltro()">
										<option value>Seleccione...</option>
										<% for(especialidad e : especialidades){
											if(especialidadSelecta == Integer.parseInt(e.getId())){
											%><option selected value="<%= e.getId() %>"> <%= e.getNombre() %></option><%
											} else {
												%><option value="<%= e.getId() %>"> <%= e.getNombre() %></option><%
											}
										}
										%>
									</select>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Despacho Judicial</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="despacho" id="despacho" required onchange="distritofiltro()">
										<option value="<%= des.getCodigo() %>" selected ><%= des.getNombre() %></option>
									</select>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Cargo</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="cargo" id="cargo" type="text" required>
										<option value>Seleccione...</option>
										<%
											for(cargo cc: cargos){
												if(cc.get_id() == usuarios.getCargofk()){
													%>
													<option value = "<%= cc.get_id()%>" selected ><%= cc.getDesc()%></option>
													<%
												}else{
												%>
												<option value = "<%= cc.get_id()%>"><%= cc.getDesc()%></option>
												<%
												}
											}
										%>
									</select>
								</div>
							</div>
						</div>
					<%
					}else{
					%>
						<div class="row">
						 	<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Distrito Judicial</label>
								</div>
								<div class="col-lg-12">
									<input class="select-option" name="djudicial" id="djudicial" type="text" placeholder="Distrito Judicial" disabled />
								</div>
							</div> 
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Ciudad/Municipio</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="ciudad" id="ciudad" onchange="despachofiltro()" required>
										<option value>Seleccione...</option>
										<% for(localizacion cc : ciudadesList){
											if(municipioSelecto.equals(cc.getCod_dane_departamento()+cc.getCod_dane())){
											%><option selected value="<%= cc.getCod_dane_departamento()+cc.getCod_dane()%>"><%= cc.getNombre() %></option><%
											} else{
												%><option value="<%= cc.getCod_dane_departamento()+cc.getCod_dane()%>"><%= cc.getNombre() %></option><%
											}
										} %>
									</select>
								</div>
							</div>
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form">Entidad</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="entidad" id="entidad" onchange="despachofiltro()" required>
										<option value>Seleccione...</option>
										<%
											for(entidad en : entidades){
												if( entidadSelecta == Integer.parseInt(en.getId())){
												%><option selected value="<%= en.getId()%>"> <%= en.getNombre() %></option><%
												} else{
													%><option value="<%= en.getId()%>"> <%= en.getNombre() %></option><%
												}
											}
										%>
									</select>
								</div>
							</div> 
							<div class="col-lg-3">
								<div class="col-lg-12">
									<label class="label-form" for="area">Área</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" id="area" name="area" onchange="despachofiltro()">
										<option value>Seleccione...</option>
										<% for(Area area: areas){
											if(area.getId() == des.getArea()){ %>
											<option selected value="<%= area.getId() %>"><%= area.getNombre() %></option>
										<%
											}else{ %>
											<option value="<%= area.getId() %>"><%= area.getNombre() %></option><%	
											}} %>
									</select>
								</div>
							</div>
						</div>
						<div class=row>
							<div class="col-lg-4">
								<div class="col-lg-12">
									<label class="label-form">Especialidad</label>
								</div>
								<div class="col-lg-12">
									<select class=" select-option" name="especialidad" id="especialidad" onchange="despachofiltro()">
										<option value>Seleccione...</option>
										<% for(especialidad e : especialidades){
											if(especialidadSelecta == Integer.parseInt(e.getId())){
											%><option selected value="<%= e.getId() %>"> <%= e.getNombre() %></option><%
											} else {
												%><option value="<%= e.getId() %>"> <%= e.getNombre() %></option><%
											}
										}
										%>
									</select>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="col-lg-12">
									<label class="label-form">Despacho Judicial</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="despacho" id="despacho" required onchange="distritofiltro()">
										<option value="<%= des.getCodigo() %>" selected ><%= des.getNombre() %></option>
									</select>
								</div>
							</div>
							<div class="col-lg-4">
								<div class="col-lg-12">
									<label class="label-form">Cargo</label>
								</div>
								<div class="col-lg-12">
									<select class="select-option" name="cargo" id="cargo" type="text" required>
										<option value>Seleccione...</option>
										<%
											for(cargo cc: cargos){
												if(cc.get_id() == usuarios.getCargofk()){
													%>
													<option value = "<%= cc.get_id()%>" selected ><%= cc.getDesc()%></option>
													<%
												}else{
												%>
												<option value = "<%= cc.get_id()%>"><%= cc.getDesc()%></option>
												<%
												}
											}
										%>
									</select>
								</div>
							</div>
						</div>
					<%
					} 
					%>
							
				</div>
			
				
				<div class="col-lg-12">
					<h2>Permisos, Licencias, Comisión de Servicios</h2>
				</div>
				<div class="col-lg-12">
					<div class=row>
						<div class="col-lg-4">
							<div class="col-lg-12">
								<label class="label-form">Tipo de Permiso</label>
							</div>
							<div class="col-lg-12">
								<select name="t_permiso" class="select-option" required>
									<option value>Seleccione...</option>
									<%
										for(tipo temp : tipos_permisos){ %>
											<option value="<%= temp.getId() %>"><%= temp.getDescripcion() %></option>
									<%  } %>
								</select>
							</div>
						</div>	
						<div class="col-lg-4">
							<div class="col-lg-12">
								<label class="label-form">Desde</label>
							</div>
							<div class="col-lg-12">
							<input class=" select-option" required name="desde" id="desde" type="text" placeholder="dd/mm/yyyy" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}" />
							</div>
						</div>
						<div class="col-lg-4">
							<div class="col-lg-12">
								<label class="label-form">Hasta</label>
							</div>
							<div class="col-lg-12">
								<input class=" select-option" required name="hasta" id="hasta" type="text" placeholder="dd/mm/yyyy" pattern="(0[1-9]|1[0-9]|2[0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}"/>
							</div>
							<input style="display: none" type="text" name="validarF" id="validarF" required>
						</div>
						
					</div>
					<div class=row>
						<div class="col-lg-4">
							<div class="col-lg-12">
								<label class="label-form">Acto Administrativo</label>
							</div>
							<div class="col-lg-12">
								<input class=" select-option" name="aadmin" type="text" placeholder="Acto Administrativo"/>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="col-lg-12">
								<label class="label-form" for="horas">Horas Laborales</label>
							</div>
							<div class="col-lg-12">
								<input class="select-option" name="horas" id="horas" type="number" step="1" min="0"/>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="col-lg-12">
								<label class="label-form" for="minutos">Minutos Laborales</label>
							</div>
							<div class="col-lg-12">
								<input class="select-option" name="minutos" id="minutos" type="number" min="0" max="59" step="1"/>
							</div>
						</div>
					</div>
				
				</div>
				<div class="col-lg-12 col-md-12 col-xs-12 ">
					<div class="block-btn text-center">
						<input type="submit" value="Guardar" class="btn btn-default btn-buscar" onclick="validarFechas()">
					</div>
				</div>
			</div>
		</form>
	</div>
			<div class="row">
				<div class="col-lg-12 text-center">
			 		<h3>Consulta de Permisos</h3>
			 	</div>
			 	<div class="col-lg-12 col-md-12 col-xs-12">
				 	<form action="<%= consulta_permisos %>" method="post" name="consulta" id="consulta">
						<div  class="col-lg-12 col-md-12 col-xs-12">
							<div class=row>
								<div class="col-lg-4">
									<div class="col-lg-12">
										<label class="label-form">Fecha Inicio</label>
									</div>
									<div class="col-lg-12">
										<input class=" select-option" name="fechaini" id="fechaini" type="date" />
									</div>
								</div>
								<div class="col-lg-4">
									<div class="col-lg-12">
										<label class="label-form">Fecha fin</label>
									</div>
									<div class="col-lg-12">
										<input class="select-option" name="fechafin" id="fechafin" type="date" />
									</div>
									<input style="display: none" type="text" name="validarF1" id="validarF1" required>
								</div>
							</div>
						</div>
						<div class="col-lg-12 col-md-12 col-xs-12 ">
							<div class="block-btn text-center">
								<input type="submit" value="Buscar" class="btn btn-default btn-buscar" onclick="validarFechas1()">
							</div>
						</div>
					</form>
				</div>
				<div class="col-lg-12 col-md-12 col-xs-12">
						<liferay-ui:search-container   delta="10" deltaConfigurable="true"  emptyResultsMessage="No hay Resultados" iteratorURL="<%=iteratorURL%>">
							<liferay-ui:search-container-results>
								<%
									String keywords = ParamUtil.getString(request, "keywords");
											results = ListUtil.subList(permisos,
													searchContainer.getStart(),
													searchContainer.getEnd());
											total = permisos.size();
											searchContainer.setTotal(permisos.size());
											pageContext.setAttribute("results", results);
											pageContext.setAttribute("total", total);
								%>
							</liferay-ui:search-container-results>    
							<liferay-ui:search-container-row className="co.com.csj.model.licencia_permiso"  modelVar="permiso">
							       <%
							       String tipoPermiso = tipoLocalServiceUtil.gettipo(permiso.getTipofk()).getDescripcion(); ;
							       DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
							       %>
							       <liferay-ui:search-container-column-text name="Tipo de Permiso" value="<%= tipoPermiso %>"/>
							       <liferay-ui:search-container-column-text name="Acto Administrativo" value="<%= permiso.getActoadmin() %>"/>
							       <liferay-ui:search-container-column-text name="Fecha de inicio" value="<%= formato.format(permiso.getFechainicio()) %>"/>
							       <liferay-ui:search-container-column-text name="Fecha de finalización" value="<%= formato.format(permiso.getFechafin()) %>"/>
							  </liferay-ui:search-container-row>
							<liferay-ui:search-iterator />
					</liferay-ui:search-container>
				</div>
			</div>
	</div>
</div>
</div>
<portlet:resourceURL var="filtro">
	<portlet:param name="action" value="getDespachos"/>
</portlet:resourceURL>
<script type="text/javascript">

function filtromuni(){
	var departamento = document.getElementById('departamento').value;
	$.ajax({
		url: '<%=filtro%>',
        type:  'post',
        dataType: 'json',
        data:  {tipo_sol : 4 ,departamento : departamento },
        success:  function (response) {
        	var data = response;
        	$('#ciudad').html('');
        	$('#ciudad').append($('<option>').text('Seleccione...').attr('value', ''));
        	$.each(data, function(i, des) {
        		$('#ciudad').append($('<option>').text(des.nombre).attr('value', des.id));
            });
        }
	});
}

function despachofiltro(){
	var ciudad = document.getElementById('ciudad').value;
	var entidad = document.getElementById('entidad').value;
	var especialidad = document.getElementById('especialidad').value;
	
	if(entidad.length === 1)
		entidad = "0" + entidad;
	
	if(especialidad.length === 1)
		especialidad = "0" + especialidad;
	
	var despacho = ciudad + entidad + especialidad;
	
	$.ajax({
		url: '<%=filtro%>',
        type:  'post',
        dataType: 'json',
        data:  {tipo_sol : 1 ,despachos : despacho, area: document.getElementById('area').value },
        success:  function (response) {
        	var data = response;
        	$('#despacho').html('');
        	$('#despacho').append(new Option('Seleccione...', ""));
        	$.each(data, function(i, des) {
        		$('#despacho').append(new Option(des.nombre, des.id));
            });
        }
	});
}

function distritofiltro(){
	var ciudad = document.getElementById('despacho').value;
	
	$.ajax({
		url: '<%=filtro%>',
        type:  'post',
        dataType: 'json',
        data:  {tipo_sol : 3 ,ciudad : ciudad },
        success:  function (response) {
        	var data = response;
        	document.getElementById('djudicial').value = '';
        	document.getElementById('djudicial').value = data[0].distrito;
        }
	});
}

$(document).ready( function() {	
	$('#entidad').change( function(){
		$("#menu-cargarPermisos").addClass("active");
		var entidad = document.getElementById('entidad').value;
		$.ajax({
			url: '<%=filtro%>',
	        type:  'post',
	        dataType: 'json',
	        data:  {tipo_sol : 2 , entidad : entidad },
	        success:  function (response) {
	        	var data = response;
	        	$('#especialidad').html('');
	        	$('#especialidad').append(new Option('Seleccione...', ""));
	        	$.each(data, function(i, des) {
	        		$('#especialidad').append(new Option(des.nombre, des.id));
	            });
	        }
		});
	});
});

function validarFechas(){
	document.getElementById("validarF").value="";
	var fechaInicial = new Date();
	var fechaFinal = new Date();
	var fechaInferior = new Date(2018, 10 , 22);
	var hayFS = false;
	if(document.getElementById("desde").value != ''){
		var fechaInicial_aux = document.getElementById("desde").value.split("/");
		fechaInicial = new Date(parseInt(fechaInicial_aux[2]),parseInt(fechaInicial_aux[1]-1),parseInt(fechaInicial_aux[0]),parseInt("00"),parseInt("00"));
		if(fechaInicial < fechaInferior){
			hayFS=true;
			alert("Fecha inicial del rango no puede ser inferior al (22/11/2018)");
		}
		if(fechaInicial.getDay()==0 || fechaInicial.getDay()==6){
	 		if(confirm("La fecha inicial ingresada es un fin de semana esta seguro que desea seleccionar esa fecha?")){
	 			
	 		}else{
	 			hayFS=true;
	 		}
		}
	}
	if(document.getElementById("hasta").value != ''){
		var fechaFinal_aux = document.getElementById("hasta").value.split("/");
	 	fechaFinal = new Date(parseInt(fechaFinal_aux[2]),parseInt(fechaFinal_aux[1]-1),parseInt(fechaFinal_aux[0]),parseInt("23"),parseInt("59"));
	 	if(fechaFinal.getDay()==0 || fechaFinal.getDay()==6){
			if(confirm("La fecha final ingresada es un fin de semana esta seguro que desea seleccionar esa fecha?")){
	 			
	 		}else{
	 			hayFS=true;
	 		}
		}
	}
	
 	if(document.getElementById("desde").value != '' && document.getElementById("hasta").value != ''){
 		if(fechaInicial>fechaFinal){
 			alert("La fecha inicial no puede ser mayor que la fecha final");
		}else{
 			document.getElementById("validarF").value="1";
 		}
 		if(hayFS==true){
 			document.getElementById("validarF").value="";
 		}
 	}else{
 		document.getElementById("validarF").value="1";
 	}
 	
 }
 
function validarFechas1(){
	document.getElementById("validarF1").value="";
	var fechaInicial = new Date();
	var fechaFinal = new Date();
	if(document.getElementById("fechaini").value != ''){
		var fechaInicial_aux = document.getElementById("fechaini").value.split("-");
		
	 	fechaInicial = new Date(parseInt(fechaInicial_aux[0]),parseInt(fechaInicial_aux[1]-1),parseInt(fechaInicial_aux[2]),parseInt("00"),parseInt("00"));
	}
	if(document.getElementById("fechafin").value != ''){
		var fechaFinal_aux = document.getElementById("fechafin").value.split("-");
	 	fechaFinal = new Date(parseInt(fechaFinal_aux[0]),parseInt(fechaFinal_aux[1]-1),parseInt(fechaFinal_aux[2]),parseInt("23"),parseInt("59"));
	}
	
 	if(document.getElementById("fechaini").value != '' && document.getElementById("fechafin").value != ''){
 		if(fechaInicial>fechaFinal){
 			alert("La fecha inicial no puede ser mayor que la fecha final");
 		}else{
 			document.getElementById("validarF1").value="1";
 		}
 	}else{
 		document.getElementById("validarF1").value="1";
 	}
 	
 }
$(document).ready( function(){
	distritofiltro();
});
$(document).ready( function(){
	$("#menu-cargarPermisos").addClass("active");
});
</script>
