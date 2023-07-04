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

import co.com.csj.model.cargo;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the cargo service. This utility wraps {@link cargoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see cargoPersistence
 * @see cargoPersistenceImpl
 * @generated
 */
public class cargoUtil {
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
	public static void clearCache(cargo cargo) {
		getPersistence().clearCache(cargo);
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
	public static List<cargo> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<cargo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<cargo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static cargo update(cargo cargo, boolean merge)
		throws SystemException {
		return getPersistence().update(cargo, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static cargo update(cargo cargo, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(cargo, merge, serviceContext);
	}

	/**
	* Caches the cargo in the entity cache if it is enabled.
	*
	* @param cargo the cargo
	*/
	public static void cacheResult(co.com.csj.model.cargo cargo) {
		getPersistence().cacheResult(cargo);
	}

	/**
	* Caches the cargos in the entity cache if it is enabled.
	*
	* @param cargos the cargos
	*/
	public static void cacheResult(
		java.util.List<co.com.csj.model.cargo> cargos) {
		getPersistence().cacheResult(cargos);
	}

	/**
	* Creates a new cargo with the primary key. Does not add the cargo to the database.
	*
	* @param _id the primary key for the new cargo
	* @return the new cargo
	*/
	public static co.com.csj.model.cargo create(long _id) {
		return getPersistence().create(_id);
	}

	/**
	* Removes the cargo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param _id the primary key of the cargo
	* @return the cargo that was removed
	* @throws co.com.csj.NoSuchcargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.cargo remove(long _id)
		throws co.com.csj.NoSuchcargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(_id);
	}

	public static co.com.csj.model.cargo updateImpl(
		co.com.csj.model.cargo cargo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cargo, merge);
	}

	/**
	* Returns the cargo with the primary key or throws a {@link co.com.csj.NoSuchcargoException} if it could not be found.
	*
	* @param _id the primary key of the cargo
	* @return the cargo
	* @throws co.com.csj.NoSuchcargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.cargo findByPrimaryKey(long _id)
		throws co.com.csj.NoSuchcargoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(_id);
	}

	/**
	* Returns the cargo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param _id the primary key of the cargo
	* @return the cargo, or <code>null</code> if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.cargo fetchByPrimaryKey(long _id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(_id);
	}

	/**
	* Returns all the cargos.
	*
	* @return the cargos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.cargo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<co.com.csj.model.cargo> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cargos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of cargos
	* @param end the upper bound of the range of cargos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cargos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.cargo> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cargos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cargos.
	*
	* @return the number of cargos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static cargoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (cargoPersistence)PortletBeanLocatorUtil.locate(co.com.csj.service.ClpSerializer.getServletContextName(),
					cargoPersistence.class.getName());

			ReferenceRegistry.registerReference(cargoUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(cargoPersistence persistence) {
	}

	private static cargoPersistence _persistence;
}