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
 * This class is a wrapper for {@link licencia_permisoLocalService}.
 * </p>
 *
 * @author    villartech
 * @see       licencia_permisoLocalService
 * @generated
 */
public class licencia_permisoLocalServiceWrapper
	implements licencia_permisoLocalService,
		ServiceWrapper<licencia_permisoLocalService> {
	public licencia_permisoLocalServiceWrapper(
		licencia_permisoLocalService licencia_permisoLocalService) {
		_licencia_permisoLocalService = licencia_permisoLocalService;
	}

	/**
	* Adds the licencia_permiso to the database. Also notifies the appropriate model listeners.
	*
	* @param licencia_permiso the licencia_permiso
	* @return the licencia_permiso that was added
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso addlicencia_permiso(
		co.com.csj.model.licencia_permiso licencia_permiso)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.addlicencia_permiso(licencia_permiso);
	}

	/**
	* Creates a new licencia_permiso with the primary key. Does not add the licencia_permiso to the database.
	*
	* @param id the primary key for the new licencia_permiso
	* @return the new licencia_permiso
	*/
	public co.com.csj.model.licencia_permiso createlicencia_permiso(long id) {
		return _licencia_permisoLocalService.createlicencia_permiso(id);
	}

	/**
	* Deletes the licencia_permiso with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the licencia_permiso
	* @return the licencia_permiso that was removed
	* @throws PortalException if a licencia_permiso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso deletelicencia_permiso(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.deletelicencia_permiso(id);
	}

	/**
	* Deletes the licencia_permiso from the database. Also notifies the appropriate model listeners.
	*
	* @param licencia_permiso the licencia_permiso
	* @return the licencia_permiso that was removed
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso deletelicencia_permiso(
		co.com.csj.model.licencia_permiso licencia_permiso)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.deletelicencia_permiso(licencia_permiso);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _licencia_permisoLocalService.dynamicQuery();
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
		return _licencia_permisoLocalService.dynamicQuery(dynamicQuery);
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
		return _licencia_permisoLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _licencia_permisoLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _licencia_permisoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public co.com.csj.model.licencia_permiso fetchlicencia_permiso(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.fetchlicencia_permiso(id);
	}

	/**
	* Returns the licencia_permiso with the primary key.
	*
	* @param id the primary key of the licencia_permiso
	* @return the licencia_permiso
	* @throws PortalException if a licencia_permiso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso getlicencia_permiso(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.getlicencia_permiso(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the licencia_permisos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @return the range of licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> getlicencia_permisos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.getlicencia_permisos(start, end);
	}

	/**
	* Returns the number of licencia_permisos.
	*
	* @return the number of licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public int getlicencia_permisosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.getlicencia_permisosCount();
	}

	/**
	* Updates the licencia_permiso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param licencia_permiso the licencia_permiso
	* @return the licencia_permiso that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso updatelicencia_permiso(
		co.com.csj.model.licencia_permiso licencia_permiso)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.updatelicencia_permiso(licencia_permiso);
	}

	/**
	* Updates the licencia_permiso in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param licencia_permiso the licencia_permiso
	* @param merge whether to merge the licencia_permiso with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the licencia_permiso that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso updatelicencia_permiso(
		co.com.csj.model.licencia_permiso licencia_permiso, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.updatelicencia_permiso(licencia_permiso,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _licencia_permisoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_licencia_permisoLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _licencia_permisoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<co.com.csj.model.licencia_permiso> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.getAll();
	}

	public java.util.List<co.com.csj.model.licencia_permiso> porPersona(
		java.lang.String personId) {
		return _licencia_permisoLocalService.porPersona(personId);
	}

	public java.util.List<co.com.csj.model.licencia_permiso> findporTipo(
		long idTipo)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.findporTipo(idTipo);
	}

	public java.util.List<co.com.csj.model.licencia_permiso> getByCreator(
		long userId)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException {
		return _licencia_permisoLocalService.getByCreator(userId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public licencia_permisoLocalService getWrappedlicencia_permisoLocalService() {
		return _licencia_permisoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedlicencia_permisoLocalService(
		licencia_permisoLocalService licencia_permisoLocalService) {
		_licencia_permisoLocalService = licencia_permisoLocalService;
	}

	public licencia_permisoLocalService getWrappedService() {
		return _licencia_permisoLocalService;
	}

	public void setWrappedService(
		licencia_permisoLocalService licencia_permisoLocalService) {
		_licencia_permisoLocalService = licencia_permisoLocalService;
	}

	private licencia_permisoLocalService _licencia_permisoLocalService;
}