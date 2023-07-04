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

package co.com.csj.service.persistence;

import co.com.csj.model.tipo_documento;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the tipo_documento service. This utility wraps {@link tipo_documentoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see tipo_documentoPersistence
 * @see tipo_documentoPersistenceImpl
 * @generated
 */
public class tipo_documentoUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(tipo_documento tipo_documento) {
		getPersistence().clearCache(tipo_documento);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<tipo_documento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<tipo_documento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<tipo_documento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static tipo_documento update(tipo_documento tipo_documento,
		boolean merge) throws SystemException {
		return getPersistence().update(tipo_documento, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static tipo_documento update(tipo_documento tipo_documento,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(tipo_documento, merge, serviceContext);
	}

	/**
	* Caches the tipo_documento in the entity cache if it is enabled.
	*
	* @param tipo_documento the tipo_documento
	*/
	public static void cacheResult(
		co.com.csj.model.tipo_documento tipo_documento) {
		getPersistence().cacheResult(tipo_documento);
	}

	/**
	* Caches the tipo_documentos in the entity cache if it is enabled.
	*
	* @param tipo_documentos the tipo_documentos
	*/
	public static void cacheResult(
		java.util.List<co.com.csj.model.tipo_documento> tipo_documentos) {
		getPersistence().cacheResult(tipo_documentos);
	}

	/**
	* Creates a new tipo_documento with the primary key. Does not add the tipo_documento to the database.
	*
	* @param _id the primary key for the new tipo_documento
	* @return the new tipo_documento
	*/
	public static co.com.csj.model.tipo_documento create(long _id) {
		return getPersistence().create(_id);
	}

	/**
	* Removes the tipo_documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param _id the primary key of the tipo_documento
	* @return the tipo_documento that was removed
	* @throws co.com.csj.NoSuchtipo_documentoException if a tipo_documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.tipo_documento remove(long _id)
		throws co.com.csj.NoSuchtipo_documentoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(_id);
	}

	public static co.com.csj.model.tipo_documento updateImpl(
		co.com.csj.model.tipo_documento tipo_documento, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(tipo_documento, merge);
	}

	/**
	* Returns the tipo_documento with the primary key or throws a {@link co.com.csj.NoSuchtipo_documentoException} if it could not be found.
	*
	* @param _id the primary key of the tipo_documento
	* @return the tipo_documento
	* @throws co.com.csj.NoSuchtipo_documentoException if a tipo_documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.tipo_documento findByPrimaryKey(long _id)
		throws co.com.csj.NoSuchtipo_documentoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(_id);
	}

	/**
	* Returns the tipo_documento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param _id the primary key of the tipo_documento
	* @return the tipo_documento, or <code>null</code> if a tipo_documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.tipo_documento fetchByPrimaryKey(long _id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(_id);
	}

	/**
	* Returns all the tipo_documentos.
	*
	* @return the tipo_documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.tipo_documento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<co.com.csj.model.tipo_documento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the tipo_documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tipo_documentos
	* @param end the upper bound of the range of tipo_documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipo_documentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.tipo_documento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the tipo_documentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of tipo_documentos.
	*
	* @return the number of tipo_documentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static tipo_documentoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (tipo_documentoPersistence)PortletBeanLocatorUtil.locate(co.com.csj.service.ClpSerializer.getServletContextName(),
					tipo_documentoPersistence.class.getName());

			ReferenceRegistry.registerReference(tipo_documentoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(tipo_documentoPersistence persistence) {
	}

	private static tipo_documentoPersistence _persistence;
}