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

import co.com.csj.model.auditoriaP;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the auditoria p service. This utility wraps {@link auditoriaPPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see auditoriaPPersistence
 * @see auditoriaPPersistenceImpl
 * @generated
 */
public class auditoriaPUtil {
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
	public static void clearCache(auditoriaP auditoriaP) {
		getPersistence().clearCache(auditoriaP);
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
	public static List<auditoriaP> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<auditoriaP> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<auditoriaP> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static auditoriaP update(auditoriaP auditoriaP, boolean merge)
		throws SystemException {
		return getPersistence().update(auditoriaP, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static auditoriaP update(auditoriaP auditoriaP, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(auditoriaP, merge, serviceContext);
	}

	/**
	* Caches the auditoria p in the entity cache if it is enabled.
	*
	* @param auditoriaP the auditoria p
	*/
	public static void cacheResult(co.com.csj.model.auditoriaP auditoriaP) {
		getPersistence().cacheResult(auditoriaP);
	}

	/**
	* Caches the auditoria ps in the entity cache if it is enabled.
	*
	* @param auditoriaPs the auditoria ps
	*/
	public static void cacheResult(
		java.util.List<co.com.csj.model.auditoriaP> auditoriaPs) {
		getPersistence().cacheResult(auditoriaPs);
	}

	/**
	* Creates a new auditoria p with the primary key. Does not add the auditoria p to the database.
	*
	* @param id the primary key for the new auditoria p
	* @return the new auditoria p
	*/
	public static co.com.csj.model.auditoriaP create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the auditoria p with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the auditoria p
	* @return the auditoria p that was removed
	* @throws co.com.csj.NoSuchauditoriaPException if a auditoria p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.auditoriaP remove(long id)
		throws co.com.csj.NoSuchauditoriaPException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static co.com.csj.model.auditoriaP updateImpl(
		co.com.csj.model.auditoriaP auditoriaP, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(auditoriaP, merge);
	}

	/**
	* Returns the auditoria p with the primary key or throws a {@link co.com.csj.NoSuchauditoriaPException} if it could not be found.
	*
	* @param id the primary key of the auditoria p
	* @return the auditoria p
	* @throws co.com.csj.NoSuchauditoriaPException if a auditoria p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.auditoriaP findByPrimaryKey(long id)
		throws co.com.csj.NoSuchauditoriaPException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the auditoria p with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the auditoria p
	* @return the auditoria p, or <code>null</code> if a auditoria p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.auditoriaP fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the auditoria ps.
	*
	* @return the auditoria ps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.auditoriaP> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<co.com.csj.model.auditoriaP> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the auditoria ps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria ps
	* @param end the upper bound of the range of auditoria ps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of auditoria ps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.auditoriaP> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the auditoria ps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of auditoria ps.
	*
	* @return the number of auditoria ps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static auditoriaPPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (auditoriaPPersistence)PortletBeanLocatorUtil.locate(co.com.csj.service.ClpSerializer.getServletContextName(),
					auditoriaPPersistence.class.getName());

			ReferenceRegistry.registerReference(auditoriaPUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(auditoriaPPersistence persistence) {
	}

	private static auditoriaPPersistence _persistence;
}