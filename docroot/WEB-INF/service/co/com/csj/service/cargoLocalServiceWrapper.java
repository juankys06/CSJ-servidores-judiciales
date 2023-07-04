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
 * This class is a wrapper for {@link cargoLocalService}.
 * </p>
 *
 * @author    villartech
 * @see       cargoLocalService
 * @generated
 */
public class cargoLocalServiceWrapper implements cargoLocalService,
	ServiceWrapper<cargoLocalService> {
	public cargoLocalServiceWrapper(cargoLocalService cargoLocalService) {
		_cargoLocalService = cargoLocalService;
	}

	/**
	* Adds the cargo to the database. Also notifies the appropriate model listeners.
	*
	* @param cargo the cargo
	* @return the cargo that was added
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.cargo addcargo(co.com.csj.model.cargo cargo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.addcargo(cargo);
	}

	/**
	* Creates a new cargo with the primary key. Does not add the cargo to the database.
	*
	* @param _id the primary key for the new cargo
	* @return the new cargo
	*/
	public co.com.csj.model.cargo createcargo(long _id) {
		return _cargoLocalService.createcargo(_id);
	}

	/**
	* Deletes the cargo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param _id the primary key of the cargo
	* @return the cargo that was removed
	* @throws PortalException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.cargo deletecargo(long _id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.deletecargo(_id);
	}

	/**
	* Deletes the cargo from the database. Also notifies the appropriate model listeners.
	*
	* @param cargo the cargo
	* @return the cargo that was removed
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.cargo deletecargo(co.com.csj.model.cargo cargo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.deletecargo(cargo);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cargoLocalService.dynamicQuery();
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
		return _cargoLocalService.dynamicQuery(dynamicQuery);
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
		return _cargoLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _cargoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _cargoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public co.com.csj.model.cargo fetchcargo(long _id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.fetchcargo(_id);
	}

	/**
	* Returns the cargo with the primary key.
	*
	* @param _id the primary key of the cargo
	* @return the cargo
	* @throws PortalException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.cargo getcargo(long _id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.getcargo(_id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the cargos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @return the range of cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.cargo> getcargos(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.getcargos(start, end);
	}

	/**
	* Returns the number of cargos.
	*
	* @return the number of cargos
	* @throws SystemException if a system exception occurred
	*/
	public int getcargosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.getcargosCount();
	}

	/**
	* Updates the cargo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargo the cargo
	* @return the cargo that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.cargo updatecargo(co.com.csj.model.cargo cargo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.updatecargo(cargo);
	}

	/**
	* Updates the cargo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargo the cargo
	* @param merge whether to merge the cargo with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the cargo that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.cargo updatecargo(co.com.csj.model.cargo cargo,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargoLocalService.updatecargo(cargo, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _cargoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cargoLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cargoLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public cargoLocalService getWrappedcargoLocalService() {
		return _cargoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedcargoLocalService(cargoLocalService cargoLocalService) {
		_cargoLocalService = cargoLocalService;
	}

	public cargoLocalService getWrappedService() {
		return _cargoLocalService;
	}

	public void setWrappedService(cargoLocalService cargoLocalService) {
		_cargoLocalService = cargoLocalService;
	}

	private cargoLocalService _cargoLocalService;
}