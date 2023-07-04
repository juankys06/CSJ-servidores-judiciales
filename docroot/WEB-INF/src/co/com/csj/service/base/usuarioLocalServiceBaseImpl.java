/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package co.com.csj.service.base;

import co.com.csj.model.usuario;
import co.com.csj.service.DocenciaLocalService;
import co.com.csj.service.alertaLocalService;
import co.com.csj.service.auditoriaPLocalService;
import co.com.csj.service.cargoLocalService;
import co.com.csj.service.licencia_permisoLocalService;
import co.com.csj.service.permisosLocalService;
import co.com.csj.service.persistence.DocenciaPersistence;
import co.com.csj.service.persistence.alertaPersistence;
import co.com.csj.service.persistence.auditoriaPPersistence;
import co.com.csj.service.persistence.cargoPersistence;
import co.com.csj.service.persistence.licencia_permisoPersistence;
import co.com.csj.service.persistence.permisosPersistence;
import co.com.csj.service.persistence.tipoPersistence;
import co.com.csj.service.persistence.tipo_documentoPersistence;
import co.com.csj.service.persistence.usuarioPersistence;
import co.com.csj.service.tipoLocalService;
import co.com.csj.service.tipo_documentoLocalService;
import co.com.csj.service.usuarioLocalService;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the usuario local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link co.com.csj.service.impl.usuarioLocalServiceImpl}.
 * </p>
 *
 * @author villartech
 * @see co.com.csj.service.impl.usuarioLocalServiceImpl
 * @see co.com.csj.service.usuarioLocalServiceUtil
 * @generated
 */
public abstract class usuarioLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements usuarioLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link co.com.csj.service.usuarioLocalServiceUtil} to access the usuario local service.
	 */

	/**
	 * Adds the usuario to the database. Also notifies the appropriate model listeners.
	 *
	 * @param usuario the usuario
	 * @return the usuario that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public usuario addusuario(usuario usuario) throws SystemException {
		usuario.setNew(true);

		return usuarioPersistence.update(usuario, false);
	}

	/**
	 * Creates a new usuario with the primary key. Does not add the usuario to the database.
	 *
	 * @param id the primary key for the new usuario
	 * @return the new usuario
	 */
	public usuario createusuario(String id) {
		return usuarioPersistence.create(id);
	}

	/**
	 * Deletes the usuario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the usuario
	 * @return the usuario that was removed
	 * @throws PortalException if a usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public usuario deleteusuario(String id)
		throws PortalException, SystemException {
		return usuarioPersistence.remove(id);
	}

	/**
	 * Deletes the usuario from the database. Also notifies the appropriate model listeners.
	 *
	 * @param usuario the usuario
	 * @return the usuario that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public usuario deleteusuario(usuario usuario) throws SystemException {
		return usuarioPersistence.remove(usuario);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(usuario.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return usuarioPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return usuarioPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return usuarioPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return usuarioPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public usuario fetchusuario(String id) throws SystemException {
		return usuarioPersistence.fetchByPrimaryKey(id);
	}

	/**
	 * Returns the usuario with the primary key.
	 *
	 * @param id the primary key of the usuario
	 * @return the usuario
	 * @throws PortalException if a usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public usuario getusuario(String id)
		throws PortalException, SystemException {
		return usuarioPersistence.findByPrimaryKey(id);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return usuarioPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the usuarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of usuarios
	 * @param end the upper bound of the range of usuarios (not inclusive)
	 * @return the range of usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<usuario> getusuarios(int start, int end)
		throws SystemException {
		return usuarioPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of usuarios.
	 *
	 * @return the number of usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public int getusuariosCount() throws SystemException {
		return usuarioPersistence.countAll();
	}

	/**
	 * Updates the usuario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param usuario the usuario
	 * @return the usuario that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public usuario updateusuario(usuario usuario) throws SystemException {
		return updateusuario(usuario, true);
	}

	/**
	 * Updates the usuario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param usuario the usuario
	 * @param merge whether to merge the usuario with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the usuario that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public usuario updateusuario(usuario usuario, boolean merge)
		throws SystemException {
		usuario.setNew(false);

		return usuarioPersistence.update(usuario, merge);
	}

	/**
	 * Returns the alerta local service.
	 *
	 * @return the alerta local service
	 */
	public alertaLocalService getalertaLocalService() {
		return alertaLocalService;
	}

	/**
	 * Sets the alerta local service.
	 *
	 * @param alertaLocalService the alerta local service
	 */
	public void setalertaLocalService(alertaLocalService alertaLocalService) {
		this.alertaLocalService = alertaLocalService;
	}

	/**
	 * Returns the alerta persistence.
	 *
	 * @return the alerta persistence
	 */
	public alertaPersistence getalertaPersistence() {
		return alertaPersistence;
	}

	/**
	 * Sets the alerta persistence.
	 *
	 * @param alertaPersistence the alerta persistence
	 */
	public void setalertaPersistence(alertaPersistence alertaPersistence) {
		this.alertaPersistence = alertaPersistence;
	}

	/**
	 * Returns the auditoria p local service.
	 *
	 * @return the auditoria p local service
	 */
	public auditoriaPLocalService getauditoriaPLocalService() {
		return auditoriaPLocalService;
	}

	/**
	 * Sets the auditoria p local service.
	 *
	 * @param auditoriaPLocalService the auditoria p local service
	 */
	public void setauditoriaPLocalService(
		auditoriaPLocalService auditoriaPLocalService) {
		this.auditoriaPLocalService = auditoriaPLocalService;
	}

	/**
	 * Returns the auditoria p persistence.
	 *
	 * @return the auditoria p persistence
	 */
	public auditoriaPPersistence getauditoriaPPersistence() {
		return auditoriaPPersistence;
	}

	/**
	 * Sets the auditoria p persistence.
	 *
	 * @param auditoriaPPersistence the auditoria p persistence
	 */
	public void setauditoriaPPersistence(
		auditoriaPPersistence auditoriaPPersistence) {
		this.auditoriaPPersistence = auditoriaPPersistence;
	}

	/**
	 * Returns the cargo local service.
	 *
	 * @return the cargo local service
	 */
	public cargoLocalService getcargoLocalService() {
		return cargoLocalService;
	}

	/**
	 * Sets the cargo local service.
	 *
	 * @param cargoLocalService the cargo local service
	 */
	public void setcargoLocalService(cargoLocalService cargoLocalService) {
		this.cargoLocalService = cargoLocalService;
	}

	/**
	 * Returns the cargo persistence.
	 *
	 * @return the cargo persistence
	 */
	public cargoPersistence getcargoPersistence() {
		return cargoPersistence;
	}

	/**
	 * Sets the cargo persistence.
	 *
	 * @param cargoPersistence the cargo persistence
	 */
	public void setcargoPersistence(cargoPersistence cargoPersistence) {
		this.cargoPersistence = cargoPersistence;
	}

	/**
	 * Returns the docencia local service.
	 *
	 * @return the docencia local service
	 */
	public DocenciaLocalService getDocenciaLocalService() {
		return docenciaLocalService;
	}

	/**
	 * Sets the docencia local service.
	 *
	 * @param docenciaLocalService the docencia local service
	 */
	public void setDocenciaLocalService(
		DocenciaLocalService docenciaLocalService) {
		this.docenciaLocalService = docenciaLocalService;
	}

	/**
	 * Returns the docencia persistence.
	 *
	 * @return the docencia persistence
	 */
	public DocenciaPersistence getDocenciaPersistence() {
		return docenciaPersistence;
	}

	/**
	 * Sets the docencia persistence.
	 *
	 * @param docenciaPersistence the docencia persistence
	 */
	public void setDocenciaPersistence(DocenciaPersistence docenciaPersistence) {
		this.docenciaPersistence = docenciaPersistence;
	}

	/**
	 * Returns the licencia_permiso local service.
	 *
	 * @return the licencia_permiso local service
	 */
	public licencia_permisoLocalService getlicencia_permisoLocalService() {
		return licencia_permisoLocalService;
	}

	/**
	 * Sets the licencia_permiso local service.
	 *
	 * @param licencia_permisoLocalService the licencia_permiso local service
	 */
	public void setlicencia_permisoLocalService(
		licencia_permisoLocalService licencia_permisoLocalService) {
		this.licencia_permisoLocalService = licencia_permisoLocalService;
	}

	/**
	 * Returns the licencia_permiso persistence.
	 *
	 * @return the licencia_permiso persistence
	 */
	public licencia_permisoPersistence getlicencia_permisoPersistence() {
		return licencia_permisoPersistence;
	}

	/**
	 * Sets the licencia_permiso persistence.
	 *
	 * @param licencia_permisoPersistence the licencia_permiso persistence
	 */
	public void setlicencia_permisoPersistence(
		licencia_permisoPersistence licencia_permisoPersistence) {
		this.licencia_permisoPersistence = licencia_permisoPersistence;
	}

	/**
	 * Returns the permisos local service.
	 *
	 * @return the permisos local service
	 */
	public permisosLocalService getpermisosLocalService() {
		return permisosLocalService;
	}

	/**
	 * Sets the permisos local service.
	 *
	 * @param permisosLocalService the permisos local service
	 */
	public void setpermisosLocalService(
		permisosLocalService permisosLocalService) {
		this.permisosLocalService = permisosLocalService;
	}

	/**
	 * Returns the permisos persistence.
	 *
	 * @return the permisos persistence
	 */
	public permisosPersistence getpermisosPersistence() {
		return permisosPersistence;
	}

	/**
	 * Sets the permisos persistence.
	 *
	 * @param permisosPersistence the permisos persistence
	 */
	public void setpermisosPersistence(permisosPersistence permisosPersistence) {
		this.permisosPersistence = permisosPersistence;
	}

	/**
	 * Returns the tipo local service.
	 *
	 * @return the tipo local service
	 */
	public tipoLocalService gettipoLocalService() {
		return tipoLocalService;
	}

	/**
	 * Sets the tipo local service.
	 *
	 * @param tipoLocalService the tipo local service
	 */
	public void settipoLocalService(tipoLocalService tipoLocalService) {
		this.tipoLocalService = tipoLocalService;
	}

	/**
	 * Returns the tipo persistence.
	 *
	 * @return the tipo persistence
	 */
	public tipoPersistence gettipoPersistence() {
		return tipoPersistence;
	}

	/**
	 * Sets the tipo persistence.
	 *
	 * @param tipoPersistence the tipo persistence
	 */
	public void settipoPersistence(tipoPersistence tipoPersistence) {
		this.tipoPersistence = tipoPersistence;
	}

	/**
	 * Returns the tipo_documento local service.
	 *
	 * @return the tipo_documento local service
	 */
	public tipo_documentoLocalService gettipo_documentoLocalService() {
		return tipo_documentoLocalService;
	}

	/**
	 * Sets the tipo_documento local service.
	 *
	 * @param tipo_documentoLocalService the tipo_documento local service
	 */
	public void settipo_documentoLocalService(
		tipo_documentoLocalService tipo_documentoLocalService) {
		this.tipo_documentoLocalService = tipo_documentoLocalService;
	}

	/**
	 * Returns the tipo_documento persistence.
	 *
	 * @return the tipo_documento persistence
	 */
	public tipo_documentoPersistence gettipo_documentoPersistence() {
		return tipo_documentoPersistence;
	}

	/**
	 * Sets the tipo_documento persistence.
	 *
	 * @param tipo_documentoPersistence the tipo_documento persistence
	 */
	public void settipo_documentoPersistence(
		tipo_documentoPersistence tipo_documentoPersistence) {
		this.tipo_documentoPersistence = tipo_documentoPersistence;
	}

	/**
	 * Returns the usuario local service.
	 *
	 * @return the usuario local service
	 */
	public usuarioLocalService getusuarioLocalService() {
		return usuarioLocalService;
	}

	/**
	 * Sets the usuario local service.
	 *
	 * @param usuarioLocalService the usuario local service
	 */
	public void setusuarioLocalService(usuarioLocalService usuarioLocalService) {
		this.usuarioLocalService = usuarioLocalService;
	}

	/**
	 * Returns the usuario persistence.
	 *
	 * @return the usuario persistence
	 */
	public usuarioPersistence getusuarioPersistence() {
		return usuarioPersistence;
	}

	/**
	 * Sets the usuario persistence.
	 *
	 * @param usuarioPersistence the usuario persistence
	 */
	public void setusuarioPersistence(usuarioPersistence usuarioPersistence) {
		this.usuarioPersistence = usuarioPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("co.com.csj.model.usuario",
			usuarioLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"co.com.csj.model.usuario");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return usuario.class;
	}

	protected String getModelClassName() {
		return usuario.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = usuarioPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = alertaLocalService.class)
	protected alertaLocalService alertaLocalService;
	@BeanReference(type = alertaPersistence.class)
	protected alertaPersistence alertaPersistence;
	@BeanReference(type = auditoriaPLocalService.class)
	protected auditoriaPLocalService auditoriaPLocalService;
	@BeanReference(type = auditoriaPPersistence.class)
	protected auditoriaPPersistence auditoriaPPersistence;
	@BeanReference(type = cargoLocalService.class)
	protected cargoLocalService cargoLocalService;
	@BeanReference(type = cargoPersistence.class)
	protected cargoPersistence cargoPersistence;
	@BeanReference(type = DocenciaLocalService.class)
	protected DocenciaLocalService docenciaLocalService;
	@BeanReference(type = DocenciaPersistence.class)
	protected DocenciaPersistence docenciaPersistence;
	@BeanReference(type = licencia_permisoLocalService.class)
	protected licencia_permisoLocalService licencia_permisoLocalService;
	@BeanReference(type = licencia_permisoPersistence.class)
	protected licencia_permisoPersistence licencia_permisoPersistence;
	@BeanReference(type = permisosLocalService.class)
	protected permisosLocalService permisosLocalService;
	@BeanReference(type = permisosPersistence.class)
	protected permisosPersistence permisosPersistence;
	@BeanReference(type = tipoLocalService.class)
	protected tipoLocalService tipoLocalService;
	@BeanReference(type = tipoPersistence.class)
	protected tipoPersistence tipoPersistence;
	@BeanReference(type = tipo_documentoLocalService.class)
	protected tipo_documentoLocalService tipo_documentoLocalService;
	@BeanReference(type = tipo_documentoPersistence.class)
	protected tipo_documentoPersistence tipo_documentoPersistence;
	@BeanReference(type = usuarioLocalService.class)
	protected usuarioLocalService usuarioLocalService;
	@BeanReference(type = usuarioPersistence.class)
	protected usuarioPersistence usuarioPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private usuarioLocalServiceClpInvoker _clpInvoker = new usuarioLocalServiceClpInvoker();
}