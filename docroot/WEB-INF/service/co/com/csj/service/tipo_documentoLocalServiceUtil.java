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
 * The utility for the tipo_documento local service. This utility wraps {@link co.com.csj.service.impl.tipo_documentoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author villartech
 * @see tipo_documentoLocalService
 * @see co.com.csj.service.base.tipo_documentoLocalServiceBaseImpl
 * @see co.com.csj.service.impl.tipo_documentoLocalServiceImpl
 * @generated
 */
public class tipo_documentoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link co.com.csj.service.impl.tipo_documentoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the tipo_documento to the database. Also notifies the appropriate model listeners.
	*
	* @param tipo_documento the tipo_documento
	* @return the tipo_documento that was added
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.tipo_documento addtipo_documento(
		co.com.csj.model.tipo_documento tipo_documento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addtipo_documento(tipo_documento);
	}

	/**
	* Creates a new tipo_documento with the primary key. Does not add the tipo_documento to the database.
	*
	* @param _id the primary key for the new tipo_documento
	* @return the new tipo_documento
	*/
	public static co.com.csj.model.tipo_documento createtipo_documento(long _id) {
		return getService().createtipo_documento(_id);
	}

	/**
	* Deletes the tipo_documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param _id the primary key of the tipo_documento
	* @return the tipo_documento that was removed
	* @throws PortalException if a tipo_documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.tipo_documento deletetipo_documento(long _id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletetipo_documento(_id);
	}

	/**
	* Deletes the tipo_documento from the database. Also notifies the appropriate model listeners.
	*
	* @param tipo_documento the tipo_documento
	* @return the tipo_documento that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.tipo_documento deletetipo_documento(
		co.com.csj.model.tipo_documento tipo_documento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletetipo_documento(tipo_documento);
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

	public static co.com.csj.model.tipo_documento fetchtipo_documento(long _id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchtipo_documento(_id);
	}

	/**
	* Returns the tipo_documento with the primary key.
	*
	* @param _id the primary key of the tipo_documento
	* @return the tipo_documento
	* @throws PortalException if a tipo_documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.tipo_documento gettipo_documento(long _id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().gettipo_documento(_id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the tipo_documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tipo_documentos
	* @param end the upper bound of the range of tipo_documentos (not inclusive)
	* @return the range of tipo_documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.tipo_documento> gettipo_documentos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().gettipo_documentos(start, end);
	}

	/**
	* Returns the number of tipo_documentos.
	*
	* @return the number of tipo_documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int gettipo_documentosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().gettipo_documentosCount();
	}

	/**
	* Updates the tipo_documento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipo_documento the tipo_documento
	* @return the tipo_documento that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.tipo_documento updatetipo_documento(
		co.com.csj.model.tipo_documento tipo_documento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatetipo_documento(tipo_documento);
	}

	/**
	* Updates the tipo_documento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tipo_documento the tipo_documento
	* @param merge whether to merge the tipo_documento with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the tipo_documento that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.tipo_documento updatetipo_documento(
		co.com.csj.model.tipo_documento tipo_documento, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatetipo_documento(tipo_documento, merge);
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

	public static tipo_documentoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					tipo_documentoLocalService.class.getName());

			if (invokableLocalService instanceof tipo_documentoLocalService) {
				_service = (tipo_documentoLocalService)invokableLocalService;
			}
			else {
				_service = new tipo_documentoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(tipo_documentoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(tipo_documentoLocalService service) {
	}

	private static tipo_documentoLocalService _service;
}