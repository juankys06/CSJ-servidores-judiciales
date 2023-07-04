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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the auditoria p local service. This utility wraps {@link co.com.csj.service.impl.auditoriaPLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author villartech
 * @see auditoriaPLocalService
 * @see co.com.csj.service.base.auditoriaPLocalServiceBaseImpl
 * @see co.com.csj.service.impl.auditoriaPLocalServiceImpl
 * @generated
 */
public class auditoriaPLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link co.com.csj.service.impl.auditoriaPLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the auditoria p to the database. Also notifies the appropriate model listeners.
	*
	* @param auditoriaP the auditoria p
	* @return the auditoria p that was added
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.auditoriaP addauditoriaP(
		co.com.csj.model.auditoriaP auditoriaP)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addauditoriaP(auditoriaP);
	}

	/**
	* Creates a new auditoria p with the primary key. Does not add the auditoria p to the database.
	*
	* @param id the primary key for the new auditoria p
	* @return the new auditoria p
	*/
	public static co.com.csj.model.auditoriaP createauditoriaP(long id) {
		return getService().createauditoriaP(id);
	}

	/**
	* Deletes the auditoria p with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the auditoria p
	* @return the auditoria p that was removed
	* @throws PortalException if a auditoria p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.auditoriaP deleteauditoriaP(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteauditoriaP(id);
	}

	/**
	* Deletes the auditoria p from the database. Also notifies the appropriate model listeners.
	*
	* @param auditoriaP the auditoria p
	* @return the auditoria p that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.auditoriaP deleteauditoriaP(
		co.com.csj.model.auditoriaP auditoriaP)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteauditoriaP(auditoriaP);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static co.com.csj.model.auditoriaP fetchauditoriaP(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchauditoriaP(id);
	}

	/**
	* Returns the auditoria p with the primary key.
	*
	* @param id the primary key of the auditoria p
	* @return the auditoria p
	* @throws PortalException if a auditoria p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.auditoriaP getauditoriaP(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getauditoriaP(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<co.com.csj.model.auditoriaP> getauditoriaPs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getauditoriaPs(start, end);
	}

	/**
	* Returns the number of auditoria ps.
	*
	* @return the number of auditoria ps
	* @throws SystemException if a system exception occurred
	*/
	public static int getauditoriaPsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getauditoriaPsCount();
	}

	/**
	* Updates the auditoria p in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param auditoriaP the auditoria p
	* @return the auditoria p that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.auditoriaP updateauditoriaP(
		co.com.csj.model.auditoriaP auditoriaP)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateauditoriaP(auditoriaP);
	}

	/**
	* Updates the auditoria p in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param auditoriaP the auditoria p
	* @param merge whether to merge the auditoria p with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the auditoria p that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.auditoriaP updateauditoriaP(
		co.com.csj.model.auditoriaP auditoriaP, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateauditoriaP(auditoriaP, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static auditoriaPLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					auditoriaPLocalService.class.getName());

			if (invokableLocalService instanceof auditoriaPLocalService) {
				_service = (auditoriaPLocalService)invokableLocalService;
			}
			else {
				_service = new auditoriaPLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(auditoriaPLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(auditoriaPLocalService service) {
	}

	private static auditoriaPLocalService _service;
}