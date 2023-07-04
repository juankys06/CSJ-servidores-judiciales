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

import co.com.csj.model.Institucion;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the institucion service. This utility wraps {@link InstitucionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see InstitucionPersistence
 * @see InstitucionPersistenceImpl
 * @generated
 */
public class InstitucionUtil {
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
	public static void clearCache(Institucion institucion) {
		getPersistence().clearCache(institucion);
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
	public static List<Institucion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Institucion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Institucion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Institucion update(Institucion institucion, boolean merge)
		throws SystemException {
		return getPersistence().update(institucion, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Institucion update(Institucion institucion, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(institucion, merge, serviceContext);
	}

	/**
	* Caches the institucion in the entity cache if it is enabled.
	*
	* @param institucion the institucion
	*/
	public static void cacheResult(co.com.csj.model.Institucion institucion) {
		getPersistence().cacheResult(institucion);
	}

	/**
	* Caches the institucions in the entity cache if it is enabled.
	*
	* @param institucions the institucions
	*/
	public static void cacheResult(
		java.util.List<co.com.csj.model.Institucion> institucions) {
		getPersistence().cacheResult(institucions);
	}

	/**
	* Creates a new institucion with the primary key. Does not add the institucion to the database.
	*
	* @param id the primary key for the new institucion
	* @return the new institucion
	*/
	public static co.com.csj.model.Institucion create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the institucion with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the institucion
	* @return the institucion that was removed
	* @throws co.com.csj.NoSuchInstitucionException if a institucion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Institucion remove(long id)
		throws co.com.csj.NoSuchInstitucionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static co.com.csj.model.Institucion updateImpl(
		co.com.csj.model.Institucion institucion, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(institucion, merge);
	}

	/**
	* Returns the institucion with the primary key or throws a {@link co.com.csj.NoSuchInstitucionException} if it could not be found.
	*
	* @param id the primary key of the institucion
	* @return the institucion
	* @throws co.com.csj.NoSuchInstitucionException if a institucion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Institucion findByPrimaryKey(long id)
		throws co.com.csj.NoSuchInstitucionException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the institucion with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the institucion
	* @return the institucion, or <code>null</code> if a institucion with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Institucion fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the institucions.
	*
	* @return the institucions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.Institucion> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<co.com.csj.model.Institucion> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the institucions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of institucions
	* @param end the upper bound of the range of institucions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of institucions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.Institucion> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the institucions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of institucions.
	*
	* @return the number of institucions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static InstitucionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (InstitucionPersistence)PortletBeanLocatorUtil.locate(co.com.csj.service.ClpSerializer.getServletContextName(),
					InstitucionPersistence.class.getName());

			ReferenceRegistry.registerReference(InstitucionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(InstitucionPersistence persistence) {
	}

	private static InstitucionPersistence _persistence;
}