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
 * This class is a wrapper for {@link DocenciaLocalService}.
 * </p>
 *
 * @author    villartech
 * @see       DocenciaLocalService
 * @generated
 */
public class DocenciaLocalServiceWrapper implements DocenciaLocalService,
	ServiceWrapper<DocenciaLocalService> {
	public DocenciaLocalServiceWrapper(
		DocenciaLocalService docenciaLocalService) {
		_docenciaLocalService = docenciaLocalService;
	}

	/**
	* Adds the docencia to the database. Also notifies the appropriate model listeners.
	*
	* @param docencia the docencia
	* @return the docencia that was added
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia addDocencia(
		co.com.csj.model.Docencia docencia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _docenciaLocalService.addDocencia(docencia);
	}

	/**
	* Creates a new docencia with the primary key. Does not add the docencia to the database.
	*
	* @param id the primary key for the new docencia
	* @return the new docencia
	*/
	public co.com.csj.model.Docencia createDocencia(long id) {
		return _docenciaLocalService.createDocencia(id);
	}

	/**
	* Deletes the docencia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the docencia
	* @return the docencia that was removed
	* @throws PortalException if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia deleteDocencia(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _docenciaLocalService.deleteDocencia(id);
	}

	/**
	* Deletes the docencia from the database. Also notifies the appropriate model listeners.
	*
	* @param docencia the docencia
	* @return the docencia that was removed
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia deleteDocencia(
		co.com.csj.model.Docencia docencia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _docenciaLocalService.deleteDocencia(docencia);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _docenciaLocalService.dynamicQuery();
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
		return _docenciaLocalService.dynamicQuery(dynamicQuery);
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
		return _docenciaLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _docenciaLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _docenciaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public co.com.csj.model.Docencia fetchDocencia(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _docenciaLocalService.fetchDocencia(id);
	}

	/**
	* Returns the docencia with the primary key.
	*
	* @param id the primary key of the docencia
	* @return the docencia
	* @throws PortalException if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia getDocencia(long id)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _docenciaLocalService.getDocencia(id);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _docenciaLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<co.com.csj.model.Docencia> getDocencias(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _docenciaLocalService.getDocencias(start, end);
	}

	/**
	* Returns the number of docencias.
	*
	* @return the number of docencias
	* @throws SystemException if a system exception occurred
	*/
	public int getDocenciasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _docenciaLocalService.getDocenciasCount();
	}

	/**
	* Updates the docencia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param docencia the docencia
	* @return the docencia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia updateDocencia(
		co.com.csj.model.Docencia docencia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _docenciaLocalService.updateDocencia(docencia);
	}

	/**
	* Updates the docencia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param docencia the docencia
	* @param merge whether to merge the docencia with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the docencia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia updateDocencia(
		co.com.csj.model.Docencia docencia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _docenciaLocalService.updateDocencia(docencia, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _docenciaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_docenciaLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _docenciaLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<co.com.csj.model.Docencia> getAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _docenciaLocalService.getAll();
	}

	public java.util.List<co.com.csj.model.Docencia> porDocente(
		java.lang.String personId) {
		return _docenciaLocalService.porDocente(personId);
	}

	public java.util.List<co.com.csj.model.Docencia> getByCreator(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _docenciaLocalService.getByCreator(userId);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DocenciaLocalService getWrappedDocenciaLocalService() {
		return _docenciaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDocenciaLocalService(
		DocenciaLocalService docenciaLocalService) {
		_docenciaLocalService = docenciaLocalService;
	}

	public DocenciaLocalService getWrappedService() {
		return _docenciaLocalService;
	}

	public void setWrappedService(DocenciaLocalService docenciaLocalService) {
		_docenciaLocalService = docenciaLocalService;
	}

	private DocenciaLocalService _docenciaLocalService;
}