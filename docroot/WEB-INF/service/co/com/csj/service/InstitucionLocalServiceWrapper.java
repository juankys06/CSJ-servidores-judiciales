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
 * This class is a wrapper for {@link InstitucionLocalService}.
 * </p>
 *
 * @author    villartech
 * @see       InstitucionLocalService
 * @generated
 */
public class InstitucionLocalServiceWrapper implements InstitucionLocalService,
	ServiceWrapper<InstitucionLocalService> {
	public InstitucionLocalServiceWrapper(
		InstitucionLocalService institucionLocalService) {
		_institucionLocalService = institucionLocalService;
	}

	/**
	* Adds the institucion to the database. Also notifies the appropriate model listeners.
	*
	* @param institucion the institucion
	* @return the institucion that was added
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Institucion addInstitucion(
		co.com.csj.model.Institucion institucion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _institucionLocalService.addInstitucion(institucion);
	}

	/**
	* Creates a new institucion with the primary key. Does not add the institucion to the database.
	*
	* @param id the primary key for the new institucion
	* @return the new institucion
	*/
	public co.com.csj.model.Institucion createInstitucion(long id) {
		return _institucionLocalService.createInstitucion(id);
	}

	/**
	* Deletes the institucion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the institucion
	* @return the institucion that was removed
	* @throws PortalException if a institucion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Institucion deleteInstitucion(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _institucionLocalService.deleteInstitucion(id);
	}

	/**
	* Deletes the institucion from the database. Also notifies the appropriate model listeners.
	*
	* @param institucion the institucion
	* @return the institucion that was removed
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Institucion deleteInstitucion(
		co.com.csj.model.Institucion institucion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _institucionLocalService.deleteInstitucion(institucion);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _institucionLocalService.dynamicQuery();
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
		return _institucionLocalService.dynamicQuery(dynamicQuery);
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
		return _institucionLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _institucionLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _institucionLocalService.dynamicQueryCount(dynamicQuery);
	}

	public co.com.csj.model.Institucion fetchInstitucion(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _institucionLocalService.fetchInstitucion(id);
	}

	/**
	* Returns the institucion with the primary key.
	*
	* @param id the primary key of the institucion
	* @return the institucion
	* @throws PortalException if a institucion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Institucion getInstitucion(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _institucionLocalService.getInstitucion(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _institucionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the institucions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of institucions
	* @param end the upper bound of the range of institucions (not inclusive)
	* @return the range of institucions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Institucion> getInstitucions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _institucionLocalService.getInstitucions(start, end);
	}

	/**
	* Returns the number of institucions.
	*
	* @return the number of institucions
	* @throws SystemException if a system exception occurred
	*/
	public int getInstitucionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _institucionLocalService.getInstitucionsCount();
	}

	/**
	* Updates the institucion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param institucion the institucion
	* @return the institucion that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Institucion updateInstitucion(
		co.com.csj.model.Institucion institucion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _institucionLocalService.updateInstitucion(institucion);
	}

	/**
	* Updates the institucion in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param institucion the institucion
	* @param merge whether to merge the institucion with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the institucion that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Institucion updateInstitucion(
		co.com.csj.model.Institucion institucion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _institucionLocalService.updateInstitucion(institucion, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _institucionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_institucionLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _institucionLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public InstitucionLocalService getWrappedInstitucionLocalService() {
		return _institucionLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedInstitucionLocalService(
		InstitucionLocalService institucionLocalService) {
		_institucionLocalService = institucionLocalService;
	}

	public InstitucionLocalService getWrappedService() {
		return _institucionLocalService;
	}

	public void setWrappedService(
		InstitucionLocalService institucionLocalService) {
		_institucionLocalService = institucionLocalService;
	}

	private InstitucionLocalService _institucionLocalService;
}