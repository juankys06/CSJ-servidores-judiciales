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
 * This class is a wrapper for {@link alertaLocalService}.
 * </p>
 *
 * @author    villartech
 * @see       alertaLocalService
 * @generated
 */
public class alertaLocalServiceWrapper implements alertaLocalService,
	ServiceWrapper<alertaLocalService> {
	public alertaLocalServiceWrapper(alertaLocalService alertaLocalService) {
		_alertaLocalService = alertaLocalService;
	}

	/**
	* Adds the alerta to the database. Also notifies the appropriate model listeners.
	*
	* @param alerta the alerta
	* @return the alerta that was added
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.alerta addalerta(co.com.csj.model.alerta alerta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alertaLocalService.addalerta(alerta);
	}

	/**
	* Creates a new alerta with the primary key. Does not add the alerta to the database.
	*
	* @param id the primary key for the new alerta
	* @return the new alerta
	*/
	public co.com.csj.model.alerta createalerta(java.lang.String id) {
		return _alertaLocalService.createalerta(id);
	}

	/**
	* Deletes the alerta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the alerta
	* @return the alerta that was removed
	* @throws PortalException if a alerta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.alerta deletealerta(java.lang.String id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alertaLocalService.deletealerta(id);
	}

	/**
	* Deletes the alerta from the database. Also notifies the appropriate model listeners.
	*
	* @param alerta the alerta
	* @return the alerta that was removed
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.alerta deletealerta(co.com.csj.model.alerta alerta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alertaLocalService.deletealerta(alerta);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _alertaLocalService.dynamicQuery();
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
		return _alertaLocalService.dynamicQuery(dynamicQuery);
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
		return _alertaLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _alertaLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _alertaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public co.com.csj.model.alerta fetchalerta(java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alertaLocalService.fetchalerta(id);
	}

	/**
	* Returns the alerta with the primary key.
	*
	* @param id the primary key of the alerta
	* @return the alerta
	* @throws PortalException if a alerta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.alerta getalerta(java.lang.String id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alertaLocalService.getalerta(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alertaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the alertas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of alertas
	* @param end the upper bound of the range of alertas (not inclusive)
	* @return the range of alertas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.alerta> getalertas(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alertaLocalService.getalertas(start, end);
	}

	/**
	* Returns the number of alertas.
	*
	* @return the number of alertas
	* @throws SystemException if a system exception occurred
	*/
	public int getalertasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alertaLocalService.getalertasCount();
	}

	/**
	* Updates the alerta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param alerta the alerta
	* @return the alerta that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.alerta updatealerta(co.com.csj.model.alerta alerta)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alertaLocalService.updatealerta(alerta);
	}

	/**
	* Updates the alerta in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param alerta the alerta
	* @param merge whether to merge the alerta with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the alerta that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.alerta updatealerta(
		co.com.csj.model.alerta alerta, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alertaLocalService.updatealerta(alerta, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _alertaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_alertaLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _alertaLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public alertaLocalService getWrappedalertaLocalService() {
		return _alertaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedalertaLocalService(
		alertaLocalService alertaLocalService) {
		_alertaLocalService = alertaLocalService;
	}

	public alertaLocalService getWrappedService() {
		return _alertaLocalService;
	}

	public void setWrappedService(alertaLocalService alertaLocalService) {
		_alertaLocalService = alertaLocalService;
	}

	private alertaLocalService _alertaLocalService;
}