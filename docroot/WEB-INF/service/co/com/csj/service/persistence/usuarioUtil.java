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

import co.com.csj.model.usuario;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the usuario service. This utility wraps {@link usuarioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see usuarioPersistence
 * @see usuarioPersistenceImpl
 * @generated
 */
public class usuarioUtil {
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
	public static void clearCache(usuario usuario) {
		getPersistence().clearCache(usuario);
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
	public static List<usuario> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<usuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<usuario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static usuario update(usuario usuario, boolean merge)
		throws SystemException {
		return getPersistence().update(usuario, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static usuario update(usuario usuario, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(usuario, merge, serviceContext);
	}

	/**
	* Caches the usuario in the entity cache if it is enabled.
	*
	* @param usuario the usuario
	*/
	public static void cacheResult(co.com.csj.model.usuario usuario) {
		getPersistence().cacheResult(usuario);
	}

	/**
	* Caches the usuarios in the entity cache if it is enabled.
	*
	* @param usuarios the usuarios
	*/
	public static void cacheResult(
		java.util.List<co.com.csj.model.usuario> usuarios) {
		getPersistence().cacheResult(usuarios);
	}

	/**
	* Creates a new usuario with the primary key. Does not add the usuario to the database.
	*
	* @param id the primary key for the new usuario
	* @return the new usuario
	*/
	public static co.com.csj.model.usuario create(java.lang.String id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the usuario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the usuario
	* @return the usuario that was removed
	* @throws co.com.csj.NoSuchusuarioException if a usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.usuario remove(java.lang.String id)
		throws co.com.csj.NoSuchusuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static co.com.csj.model.usuario updateImpl(
		co.com.csj.model.usuario usuario, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(usuario, merge);
	}

	/**
	* Returns the usuario with the primary key or throws a {@link co.com.csj.NoSuchusuarioException} if it could not be found.
	*
	* @param id the primary key of the usuario
	* @return the usuario
	* @throws co.com.csj.NoSuchusuarioException if a usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.usuario findByPrimaryKey(java.lang.String id)
		throws co.com.csj.NoSuchusuarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the usuario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the usuario
	* @return the usuario, or <code>null</code> if a usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.usuario fetchByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the usuarios.
	*
	* @return the usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.usuario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the usuarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of usuarios
	* @param end the upper bound of the range of usuarios (not inclusive)
	* @return the range of usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.usuario> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the usuarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of usuarios
	* @param end the upper bound of the range of usuarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.usuario> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the usuarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of usuarios.
	*
	* @return the number of usuarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static usuarioPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (usuarioPersistence)PortletBeanLocatorUtil.locate(co.com.csj.service.ClpSerializer.getServletContextName(),
					usuarioPersistence.class.getName());

			ReferenceRegistry.registerReference(usuarioUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(usuarioPersistence persistence) {
	}

	private static usuarioPersistence _persistence;
}