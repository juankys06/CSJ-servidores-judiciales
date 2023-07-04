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

import co.com.csj.model.permisos;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the permisos service. This utility wraps {@link permisosPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see permisosPersistence
 * @see permisosPersistenceImpl
 * @generated
 */
public class permisosUtil {
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
	public static void clearCache(permisos permisos) {
		getPersistence().clearCache(permisos);
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
	public static List<permisos> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<permisos> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<permisos> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static permisos update(permisos permisos, boolean merge)
		throws SystemException {
		return getPersistence().update(permisos, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static permisos update(permisos permisos, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(permisos, merge, serviceContext);
	}

	/**
	* Caches the permisos in the entity cache if it is enabled.
	*
	* @param permisos the permisos
	*/
	public static void cacheResult(co.com.csj.model.permisos permisos) {
		getPersistence().cacheResult(permisos);
	}

	/**
	* Caches the permisoses in the entity cache if it is enabled.
	*
	* @param permisoses the permisoses
	*/
	public static void cacheResult(
		java.util.List<co.com.csj.model.permisos> permisoses) {
		getPersistence().cacheResult(permisoses);
	}

	/**
	* Creates a new permisos with the primary key. Does not add the permisos to the database.
	*
	* @param id the primary key for the new permisos
	* @return the new permisos
	*/
	public static co.com.csj.model.permisos create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the permisos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the permisos
	* @return the permisos that was removed
	* @throws co.com.csj.NoSuchpermisosException if a permisos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.permisos remove(long id)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static co.com.csj.model.permisos updateImpl(
		co.com.csj.model.permisos permisos, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(permisos, merge);
	}

	/**
	* Returns the permisos with the primary key or throws a {@link co.com.csj.NoSuchpermisosException} if it could not be found.
	*
	* @param id the primary key of the permisos
	* @return the permisos
	* @throws co.com.csj.NoSuchpermisosException if a permisos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.permisos findByPrimaryKey(long id)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the permisos with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the permisos
	* @return the permisos, or <code>null</code> if a permisos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.permisos fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns the permisos where usuario = &#63; or throws a {@link co.com.csj.NoSuchpermisosException} if it could not be found.
	*
	* @param usuario the usuario
	* @return the matching permisos
	* @throws co.com.csj.NoSuchpermisosException if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.permisos findByUsuario(
		java.lang.String usuario)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsuario(usuario);
	}

	/**
	* Returns the permisos where usuario = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param usuario the usuario
	* @return the matching permisos, or <code>null</code> if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.permisos fetchByUsuario(
		java.lang.String usuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUsuario(usuario);
	}

	/**
	* Returns the permisos where usuario = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param usuario the usuario
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching permisos, or <code>null</code> if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.permisos fetchByUsuario(
		java.lang.String usuario, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUsuario(usuario, retrieveFromCache);
	}

	/**
	* Returns all the permisoses where usuario = &#63;.
	*
	* @param usuario the usuario
	* @return the matching permisoses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.permisos> findByUsuarioR(
		java.lang.String usuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsuarioR(usuario);
	}

	/**
	* Returns a range of all the permisoses where usuario = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param usuario the usuario
	* @param start the lower bound of the range of permisoses
	* @param end the upper bound of the range of permisoses (not inclusive)
	* @return the range of matching permisoses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.permisos> findByUsuarioR(
		java.lang.String usuario, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsuarioR(usuario, start, end);
	}

	/**
	* Returns an ordered range of all the permisoses where usuario = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param usuario the usuario
	* @param start the lower bound of the range of permisoses
	* @param end the upper bound of the range of permisoses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching permisoses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.permisos> findByUsuarioR(
		java.lang.String usuario, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUsuarioR(usuario, start, end, orderByComparator);
	}

	/**
	* Returns the first permisos in the ordered set where usuario = &#63;.
	*
	* @param usuario the usuario
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching permisos
	* @throws co.com.csj.NoSuchpermisosException if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.permisos findByUsuarioR_First(
		java.lang.String usuario,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsuarioR_First(usuario, orderByComparator);
	}

	/**
	* Returns the first permisos in the ordered set where usuario = &#63;.
	*
	* @param usuario the usuario
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching permisos, or <code>null</code> if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.permisos fetchByUsuarioR_First(
		java.lang.String usuario,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUsuarioR_First(usuario, orderByComparator);
	}

	/**
	* Returns the last permisos in the ordered set where usuario = &#63;.
	*
	* @param usuario the usuario
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching permisos
	* @throws co.com.csj.NoSuchpermisosException if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.permisos findByUsuarioR_Last(
		java.lang.String usuario,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUsuarioR_Last(usuario, orderByComparator);
	}

	/**
	* Returns the last permisos in the ordered set where usuario = &#63;.
	*
	* @param usuario the usuario
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching permisos, or <code>null</code> if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.permisos fetchByUsuarioR_Last(
		java.lang.String usuario,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUsuarioR_Last(usuario, orderByComparator);
	}

	/**
	* Returns the permisoses before and after the current permisos in the ordered set where usuario = &#63;.
	*
	* @param id the primary key of the current permisos
	* @param usuario the usuario
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next permisos
	* @throws co.com.csj.NoSuchpermisosException if a permisos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.permisos[] findByUsuarioR_PrevAndNext(
		long id, java.lang.String usuario,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUsuarioR_PrevAndNext(id, usuario, orderByComparator);
	}

	/**
	* Returns all the permisoses.
	*
	* @return the permisoses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.permisos> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the permisoses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of permisoses
	* @param end the upper bound of the range of permisoses (not inclusive)
	* @return the range of permisoses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.permisos> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the permisoses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of permisoses
	* @param end the upper bound of the range of permisoses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of permisoses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.permisos> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the permisos where usuario = &#63; from the database.
	*
	* @param usuario the usuario
	* @return the permisos that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.permisos removeByUsuario(
		java.lang.String usuario)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUsuario(usuario);
	}

	/**
	* Removes all the permisoses where usuario = &#63; from the database.
	*
	* @param usuario the usuario
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUsuarioR(java.lang.String usuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUsuarioR(usuario);
	}

	/**
	* Removes all the permisoses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of permisoses where usuario = &#63;.
	*
	* @param usuario the usuario
	* @return the number of matching permisoses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUsuario(java.lang.String usuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUsuario(usuario);
	}

	/**
	* Returns the number of permisoses where usuario = &#63;.
	*
	* @param usuario the usuario
	* @return the number of matching permisoses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUsuarioR(java.lang.String usuario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUsuarioR(usuario);
	}

	/**
	* Returns the number of permisoses.
	*
	* @return the number of permisoses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static permisosPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (permisosPersistence)PortletBeanLocatorUtil.locate(co.com.csj.service.ClpSerializer.getServletContextName(),
					permisosPersistence.class.getName());

			ReferenceRegistry.registerReference(permisosUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(permisosPersistence persistence) {
	}

	private static permisosPersistence _persistence;
}