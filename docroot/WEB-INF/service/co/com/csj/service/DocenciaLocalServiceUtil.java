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
 * The utility for the docencia local service. This utility wraps {@link co.com.csj.service.impl.DocenciaLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author villartech
 * @see DocenciaLocalService
 * @see co.com.csj.service.base.DocenciaLocalServiceBaseImpl
 * @see co.com.csj.service.impl.DocenciaLocalServiceImpl
 * @generated
 */
public class DocenciaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link co.com.csj.service.impl.DocenciaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the docencia to the database. Also notifies the appropriate model listeners.
	*
	* @param docencia the docencia
	* @return the docencia that was added
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia addDocencia(
		co.com.csj.model.Docencia docencia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDocencia(docencia);
	}

	/**
	* Creates a new docencia with the primary key. Does not add the docencia to the database.
	*
	* @param id the primary key for the new docencia
	* @return the new docencia
	*/
	public static co.com.csj.model.Docencia createDocencia(long id) {
		return getService().createDocencia(id);
	}

	/**
	* Deletes the docencia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the docencia
	* @return the docencia that was removed
	* @throws PortalException if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia deleteDocencia(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDocencia(id);
	}

	/**
	* Deletes the docencia from the database. Also notifies the appropriate model listeners.
	*
	* @param docencia the docencia
	* @return the docencia that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia deleteDocencia(
		co.com.csj.model.Docencia docencia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDocencia(docencia);
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

	public static co.com.csj.model.Docencia fetchDocencia(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDocencia(id);
	}

	/**
	* Returns the docencia with the primary key.
	*
	* @param id the primary key of the docencia
	* @return the docencia
	* @throws PortalException if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia getDocencia(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDocencia(id);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the docencias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of docencias
	* @param end the upper bound of the range of docencias (not inclusive)
	* @return the range of docencias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.Docencia> getDocencias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDocencias(start, end);
	}

	/**
	* Returns the number of docencias.
	*
	* @return the number of docencias
	* @throws SystemException if a system exception occurred
	*/
	public static int getDocenciasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDocenciasCount();
	}

	/**
	* Updates the docencia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param docencia the docencia
	* @return the docencia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia updateDocencia(
		co.com.csj.model.Docencia docencia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDocencia(docencia);
	}

	/**
	* Updates the docencia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param docencia the docencia
	* @param merge whether to merge the docencia with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the docencia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia updateDocencia(
		co.com.csj.model.Docencia docencia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDocencia(docencia, merge);
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

	public static java.util.List<co.com.csj.model.Docencia> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAll();
	}

	public static java.util.List<co.com.csj.model.Docencia> porDocente(
		java.lang.String personId) {
		return getService().porDocente(personId);
	}

	public static java.util.List<co.com.csj.model.Docencia> getByCreator(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByCreator(userId);
	}

	public static void clearService() {
		_service = null;
	}

	public static DocenciaLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DocenciaLocalService.class.getName());

			if (invokableLocalService instanceof DocenciaLocalService) {
				_service = (DocenciaLocalService)invokableLocalService;
			}
			else {
				_service = new DocenciaLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DocenciaLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(DocenciaLocalService service) {
	}

	private static DocenciaLocalService _service;
}