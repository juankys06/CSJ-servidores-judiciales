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
 * This class is a wrapper for {@link tipoLocalService}.
 * </p>
 *
 * @author    villartech
 * @see       tipoLocalService
 * @generated
 */
public class tipoLocalServiceWrapper implements tipoLocalService,
	ServiceWrapper<tipoLocalService> {
	public tipoLocalServiceWrapper(tipoLocalService tipoLocalService) {
		_tipoLocalService = tipoLocalService;
	}

	/**
	* Adds the tipo to the database. Also notifies the appropriate model listeners.
	*
	* @param tipo the tipo
	* @return the tipo that was added
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.tipo addtipo(co.com.csj.model.tipo tipo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipoLocalService.addtipo(tipo);
	}

	/**
	* Creates a new tipo with the primary key. Does not add the tipo to the database.
	*
	* @param id the primary key for the new tipo
	* @return the new tipo
	*/
	public co.com.csj.model.tipo createtipo(long id) {
		return _tipoLocalService.createtipo(id);
	}

	/**
	* Deletes the tipo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tipo
	* @return the tipo that was removed
	* @throws PortalException if a tipo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.tipo deletetipo(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipoLocalService.deletetipo(id);
	}

	/**
	* Deletes the tipo from the database. Also notifies the appropriate model listeners.
	*
	* @param tipo the tipo
	* @return the tipo that was removed
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.tipo deletetipo(co.com.csj.model.tipo tipo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipoLocalService.deletetipo(tipo);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tipoLocalService.dynamicQuery();
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
		return _tipoLocalService.dynamicQuery(dynamicQuery);
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
		return _tipoLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _tipoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _tipoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public co.com.csj.model.tipo fetchtipo(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipoLocalService.fetchtipo(id);
	}

	/**
	* Returns the tipo with the primary key.
	*
	* @param id the primary key of the tipo
	* @return the tipo
	* @throws PortalException if a tipo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.tipo gettipo(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipoLocalService.gettipo(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _tipoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tipos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tipos
	* @param end the upper bound of the range of tipos (not inclusive)
	* @return the range of tipos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.tipo> gettipos(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipoLocalService.gettipos(start, end);
	}

	/**
	* Returns the number of tipos.
	*
	* @return the number of tipos
	* @throws SystemException if a system exception occurred
	*/
	public int gettiposCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipoLocalService.gettiposCount();
	}

	/**
	* Updates the tipo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipo the tipo
	* @return the tipo that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.tipo updatetipo(co.com.csj.model.tipo tipo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipoLocalService.updatetipo(tipo);
	}

	/**
	* Updates the tipo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipo the tipo
	* @param merge whether to merge the tipo with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tipo that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.tipo updatetipo(co.com.csj.model.tipo tipo,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _tipoLocalService.updatetipo(tipo, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _tipoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_tipoLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _tipoLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public tipoLocalService getWrappedtipoLocalService() {
		return _tipoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedtipoLocalService(tipoLocalService tipoLocalService) {
		_tipoLocalService = tipoLocalService;
	}

	public tipoLocalService getWrappedService() {
		return _tipoLocalService;
	}

	public void setWrappedService(tipoLocalService tipoLocalService) {
		_tipoLocalService = tipoLocalService;
	}

	private tipoLocalService _tipoLocalService;
}