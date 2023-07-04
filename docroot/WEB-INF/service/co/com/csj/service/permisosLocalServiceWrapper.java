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
 * This class is a wrapper for {@link permisosLocalService}.
 * </p>
 *
 * @author    villartech
 * @see       permisosLocalService
 * @generated
 */
public class permisosLocalServiceWrapper implements permisosLocalService,
	ServiceWrapper<permisosLocalService> {
	public permisosLocalServiceWrapper(
		permisosLocalService permisosLocalService) {
		_permisosLocalService = permisosLocalService;
	}

	/**
	* Adds the permisos to the database. Also notifies the appropriate model listeners.
	*
	* @param permisos the permisos
	* @return the permisos that was added
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos addpermisos(
		co.com.csj.model.permisos permisos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permisosLocalService.addpermisos(permisos);
	}

	/**
	* Creates a new permisos with the primary key. Does not add the permisos to the database.
	*
	* @param id the primary key for the new permisos
	* @return the new permisos
	*/
	public co.com.csj.model.permisos createpermisos(long id) {
		return _permisosLocalService.createpermisos(id);
	}

	/**
	* Deletes the permisos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the permisos
	* @return the permisos that was removed
	* @throws PortalException if a permisos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos deletepermisos(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _permisosLocalService.deletepermisos(id);
	}

	/**
	* Deletes the permisos from the database. Also notifies the appropriate model listeners.
	*
	* @param permisos the permisos
	* @return the permisos that was removed
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos deletepermisos(
		co.com.csj.model.permisos permisos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permisosLocalService.deletepermisos(permisos);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _permisosLocalService.dynamicQuery();
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
		return _permisosLocalService.dynamicQuery(dynamicQuery);
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
		return _permisosLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _permisosLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _permisosLocalService.dynamicQueryCount(dynamicQuery);
	}

	public co.com.csj.model.permisos fetchpermisos(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permisosLocalService.fetchpermisos(id);
	}

	/**
	* Returns the permisos with the primary key.
	*
	* @param id the primary key of the permisos
	* @return the permisos
	* @throws PortalException if a permisos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos getpermisos(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _permisosLocalService.getpermisos(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _permisosLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the permisoses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of permisoses
	* @param end the upper bound of the range of permisoses (not inclusive)
	* @return the range of permisoses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.permisos> getpermisoses(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _permisosLocalService.getpermisoses(start, end);
	}

	/**
	* Returns the number of permisoses.
	*
	* @return the number of permisoses
	* @throws SystemException if a system exception occurred
	*/
	public int getpermisosesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permisosLocalService.getpermisosesCount();
	}

	/**
	* Updates the permisos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param permisos the permisos
	* @return the permisos that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos updatepermisos(
		co.com.csj.model.permisos permisos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permisosLocalService.updatepermisos(permisos);
	}

	/**
	* Updates the permisos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param permisos the permisos
	* @param merge whether to merge the permisos with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the permisos that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos updatepermisos(
		co.com.csj.model.permisos permisos, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _permisosLocalService.updatepermisos(permisos, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _permisosLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_permisosLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _permisosLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public co.com.csj.model.permisos getByUser(java.lang.String userID) {
		return _permisosLocalService.getByUser(userID);
	}

	public java.util.List<co.com.csj.model.permisos> getByUserR(
		java.lang.String userID) {
		return _permisosLocalService.getByUserR(userID);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public permisosLocalService getWrappedpermisosLocalService() {
		return _permisosLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedpermisosLocalService(
		permisosLocalService permisosLocalService) {
		_permisosLocalService = permisosLocalService;
	}

	public permisosLocalService getWrappedService() {
		return _permisosLocalService;
	}

	public void setWrappedService(permisosLocalService permisosLocalService) {
		_permisosLocalService = permisosLocalService;
	}

	private permisosLocalService _permisosLocalService;
}