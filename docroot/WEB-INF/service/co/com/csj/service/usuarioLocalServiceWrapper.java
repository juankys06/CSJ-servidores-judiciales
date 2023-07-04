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

package co.com.csj.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link usuarioLocalService}.
 * </p>
 *
 * @author    villartech
 * @see       usuarioLocalService
 * @generated
 */
public class usuarioLocalServiceWrapper implements usuarioLocalService,
	ServiceWrapper<usuarioLocalService> {
	public usuarioLocalServiceWrapper(usuarioLocalService usuarioLocalService) {
		_usuarioLocalService = usuarioLocalService;
	}

	/**
	* Adds the usuario to the database. Also notifies the appropriate model listeners.
	*
	* @param usuario the usuario
	* @return the usuario that was added
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.usuario addusuario(co.com.csj.model.usuario usuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.addusuario(usuario);
	}

	/**
	* Creates a new usuario with the primary key. Does not add the usuario to the database.
	*
	* @param id the primary key for the new usuario
	* @return the new usuario
	*/
	public co.com.csj.model.usuario createusuario(java.lang.String id) {
		return _usuarioLocalService.createusuario(id);
	}

	/**
	* Deletes the usuario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the usuario
	* @return the usuario that was removed
	* @throws PortalException if a usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.usuario deleteusuario(java.lang.String id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.deleteusuario(id);
	}

	/**
	* Deletes the usuario from the database. Also notifies the appropriate model listeners.
	*
	* @param usuario the usuario
	* @return the usuario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.usuario deleteusuario(
		co.com.csj.model.usuario usuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.deleteusuario(usuario);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _usuarioLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.dynamicQuery(dynamicQuery, start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.dynamicQueryCount(dynamicQuery);
	}

	public co.com.csj.model.usuario fetchusuario(java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.fetchusuario(id);
	}

	/**
	* Returns the usuario with the primary key.
	*
	* @param id the primary key of the usuario
	* @return the usuario
	* @throws PortalException if a usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.usuario getusuario(java.lang.String id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.getusuario(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<co.com.csj.model.usuario> getusuarios(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.getusuarios(start, end);
	}

	/**
	* Returns the number of usuarios.
	*
	* @return the number of usuarios
	* @throws SystemException if a system exception occurred
	*/
	public int getusuariosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.getusuariosCount();
	}

	/**
	* Updates the usuario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param usuario the usuario
	* @return the usuario that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.usuario updateusuario(
		co.com.csj.model.usuario usuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.updateusuario(usuario);
	}

	/**
	* Updates the usuario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param usuario the usuario
	* @param merge whether to merge the usuario with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the usuario that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.usuario updateusuario(
		co.com.csj.model.usuario usuario, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _usuarioLocalService.updateusuario(usuario, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _usuarioLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_usuarioLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _usuarioLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public usuarioLocalService getWrappedusuarioLocalService() {
		return _usuarioLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedusuarioLocalService(
		usuarioLocalService usuarioLocalService) {
		_usuarioLocalService = usuarioLocalService;
	}

	public usuarioLocalService getWrappedService() {
		return _usuarioLocalService;
	}

	public void setWrappedService(usuarioLocalService usuarioLocalService) {
		_usuarioLocalService = usuarioLocalService;
	}

	private usuarioLocalService _usuarioLocalService;
}