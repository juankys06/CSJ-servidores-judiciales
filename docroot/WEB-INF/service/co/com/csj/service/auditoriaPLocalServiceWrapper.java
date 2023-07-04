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
 * This class is a wrapper for {@link auditoriaPLocalService}.
 * </p>
 *
 * @author    villartech
 * @see       auditoriaPLocalService
 * @generated
 */
public class auditoriaPLocalServiceWrapper implements auditoriaPLocalService,
	ServiceWrapper<auditoriaPLocalService> {
	public auditoriaPLocalServiceWrapper(
		auditoriaPLocalService auditoriaPLocalService) {
		_auditoriaPLocalService = auditoriaPLocalService;
	}

	/**
	* Adds the auditoria p to the database. Also notifies the appropriate model listeners.
	*
	* @param auditoriaP the auditoria p
	* @return the auditoria p that was added
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.auditoriaP addauditoriaP(
		co.com.csj.model.auditoriaP auditoriaP)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPLocalService.addauditoriaP(auditoriaP);
	}

	/**
	* Creates a new auditoria p with the primary key. Does not add the auditoria p to the database.
	*
	* @param id the primary key for the new auditoria p
	* @return the new auditoria p
	*/
	public co.com.csj.model.auditoriaP createauditoriaP(long id) {
		return _auditoriaPLocalService.createauditoriaP(id);
	}

	/**
	* Deletes the auditoria p with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the auditoria p
	* @return the auditoria p that was removed
	* @throws PortalException if a auditoria p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.auditoriaP deleteauditoriaP(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPLocalService.deleteauditoriaP(id);
	}

	/**
	* Deletes the auditoria p from the database. Also notifies the appropriate model listeners.
	*
	* @param auditoriaP the auditoria p
	* @return the auditoria p that was removed
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.auditoriaP deleteauditoriaP(
		co.com.csj.model.auditoriaP auditoriaP)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPLocalService.deleteauditoriaP(auditoriaP);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _auditoriaPLocalService.dynamicQuery();
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
		return _auditoriaPLocalService.dynamicQuery(dynamicQuery);
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
		return _auditoriaPLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _auditoriaPLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _auditoriaPLocalService.dynamicQueryCount(dynamicQuery);
	}

	public co.com.csj.model.auditoriaP fetchauditoriaP(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPLocalService.fetchauditoriaP(id);
	}

	/**
	* Returns the auditoria p with the primary key.
	*
	* @param id the primary key of the auditoria p
	* @return the auditoria p
	* @throws PortalException if a auditoria p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.auditoriaP getauditoriaP(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPLocalService.getauditoriaP(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the auditoria ps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria ps
	* @param end the upper bound of the range of auditoria ps (not inclusive)
	* @return the range of auditoria ps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.auditoriaP> getauditoriaPs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPLocalService.getauditoriaPs(start, end);
	}

	/**
	* Returns the number of auditoria ps.
	*
	* @return the number of auditoria ps
	* @throws SystemException if a system exception occurred
	*/
	public int getauditoriaPsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPLocalService.getauditoriaPsCount();
	}

	/**
	* Updates the auditoria p in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param auditoriaP the auditoria p
	* @return the auditoria p that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.auditoriaP updateauditoriaP(
		co.com.csj.model.auditoriaP auditoriaP)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPLocalService.updateauditoriaP(auditoriaP);
	}

	/**
	* Updates the auditoria p in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param auditoriaP the auditoria p
	* @param merge whether to merge the auditoria p with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the auditoria p that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.auditoriaP updateauditoriaP(
		co.com.csj.model.auditoriaP auditoriaP, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPLocalService.updateauditoriaP(auditoriaP, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _auditoriaPLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_auditoriaPLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _auditoriaPLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public auditoriaPLocalService getWrappedauditoriaPLocalService() {
		return _auditoriaPLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedauditoriaPLocalService(
		auditoriaPLocalService auditoriaPLocalService) {
		_auditoriaPLocalService = auditoriaPLocalService;
	}

	public auditoriaPLocalService getWrappedService() {
		return _auditoriaPLocalService;
	}

	public void setWrappedService(auditoriaPLocalService auditoriaPLocalService) {
		_auditoriaPLocalService = auditoriaPLocalService;
	}

	private auditoriaPLocalService _auditoriaPLocalService;
}