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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the permisos service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see permisosPersistenceImpl
 * @see permisosUtil
 * @generated
 */
public interface permisosPersistence extends BasePersistence<permisos> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link permisosUtil} to access the permisos persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the permisos in the entity cache if it is enabled.
	*
	* @param permisos the permisos
	*/
	public void cacheResult(co.com.csj.model.permisos permisos);

	/**
	* Caches the permisoses in the entity cache if it is enabled.
	*
	* @param permisoses the permisoses
	*/
	public void cacheResult(
		java.util.List<co.com.csj.model.permisos> permisoses);

	/**
	* Creates a new permisos with the primary key. Does not add the permisos to the database.
	*
	* @param id the primary key for the new permisos
	* @return the new permisos
	*/
	public co.com.csj.model.permisos create(long id);

	/**
	* Removes the permisos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the permisos
	* @return the permisos that was removed
	* @throws co.com.csj.NoSuchpermisosException if a permisos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos remove(long id)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException;

	public co.com.csj.model.permisos updateImpl(
		co.com.csj.model.permisos permisos, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the permisos with the primary key or throws a {@link co.com.csj.NoSuchpermisosException} if it could not be found.
	*
	* @param id the primary key of the permisos
	* @return the permisos
	* @throws co.com.csj.NoSuchpermisosException if a permisos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos findByPrimaryKey(long id)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the permisos with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the permisos
	* @return the permisos, or <code>null</code> if a permisos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the permisos where usuario = &#63; or throws a {@link co.com.csj.NoSuchpermisosException} if it could not be found.
	*
	* @param usuario the usuario
	* @return the matching permisos
	* @throws co.com.csj.NoSuchpermisosException if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos findByUsuario(java.lang.String usuario)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the permisos where usuario = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param usuario the usuario
	* @return the matching permisos, or <code>null</code> if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos fetchByUsuario(java.lang.String usuario)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the permisos where usuario = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param usuario the usuario
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching permisos, or <code>null</code> if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos fetchByUsuario(java.lang.String usuario,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the permisoses where usuario = &#63;.
	*
	* @param usuario the usuario
	* @return the matching permisoses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.permisos> findByUsuarioR(
		java.lang.String usuario)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<co.com.csj.model.permisos> findByUsuarioR(
		java.lang.String usuario, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<co.com.csj.model.permisos> findByUsuarioR(
		java.lang.String usuario, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first permisos in the ordered set where usuario = &#63;.
	*
	* @param usuario the usuario
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching permisos
	* @throws co.com.csj.NoSuchpermisosException if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos findByUsuarioR_First(
		java.lang.String usuario,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first permisos in the ordered set where usuario = &#63;.
	*
	* @param usuario the usuario
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching permisos, or <code>null</code> if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos fetchByUsuarioR_First(
		java.lang.String usuario,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last permisos in the ordered set where usuario = &#63;.
	*
	* @param usuario the usuario
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching permisos
	* @throws co.com.csj.NoSuchpermisosException if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos findByUsuarioR_Last(
		java.lang.String usuario,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last permisos in the ordered set where usuario = &#63;.
	*
	* @param usuario the usuario
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching permisos, or <code>null</code> if a matching permisos could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos fetchByUsuarioR_Last(
		java.lang.String usuario,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public co.com.csj.model.permisos[] findByUsuarioR_PrevAndNext(long id,
		java.lang.String usuario,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the permisoses.
	*
	* @return the permisoses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.permisos> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<co.com.csj.model.permisos> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<co.com.csj.model.permisos> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the permisos where usuario = &#63; from the database.
	*
	* @param usuario the usuario
	* @return the permisos that was removed
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.permisos removeByUsuario(java.lang.String usuario)
		throws co.com.csj.NoSuchpermisosException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the permisoses where usuario = &#63; from the database.
	*
	* @param usuario the usuario
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUsuarioR(java.lang.String usuario)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the permisoses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of permisoses where usuario = &#63;.
	*
	* @param usuario the usuario
	* @return the number of matching permisoses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUsuario(java.lang.String usuario)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of permisoses where usuario = &#63;.
	*
	* @param usuario the usuario
	* @return the number of matching permisoses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUsuarioR(java.lang.String usuario)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of permisoses.
	*
	* @return the number of permisoses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}