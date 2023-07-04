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

import co.com.csj.model.licencia_permiso;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the licencia_permiso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see licencia_permisoPersistenceImpl
 * @see licencia_permisoUtil
 * @generated
 */
public interface licencia_permisoPersistence extends BasePersistence<licencia_permiso> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link licencia_permisoUtil} to access the licencia_permiso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the licencia_permiso in the entity cache if it is enabled.
	*
	* @param licencia_permiso the licencia_permiso
	*/
	public void cacheResult(co.com.csj.model.licencia_permiso licencia_permiso);

	/**
	* Caches the licencia_permisos in the entity cache if it is enabled.
	*
	* @param licencia_permisos the licencia_permisos
	*/
	public void cacheResult(
		java.util.List<co.com.csj.model.licencia_permiso> licencia_permisos);

	/**
	* Creates a new licencia_permiso with the primary key. Does not add the licencia_permiso to the database.
	*
	* @param id the primary key for the new licencia_permiso
	* @return the new licencia_permiso
	*/
	public co.com.csj.model.licencia_permiso create(long id);

	/**
	* Removes the licencia_permiso with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the licencia_permiso
	* @return the licencia_permiso that was removed
	* @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso remove(long id)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	public co.com.csj.model.licencia_permiso updateImpl(
		co.com.csj.model.licencia_permiso licencia_permiso, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the licencia_permiso with the primary key or throws a {@link co.com.csj.NoSuchlicencia_permisoException} if it could not be found.
	*
	* @param id the primary key of the licencia_permiso
	* @return the licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso findByPrimaryKey(long id)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the licencia_permiso with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the licencia_permiso
	* @return the licencia_permiso, or <code>null</code> if a licencia_permiso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the licencia_permisos where tipofk = &#63;.
	*
	* @param tipofk the tipofk
	* @return the matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByporTipo(
		long tipofk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the licencia_permisos where tipofk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tipofk the tipofk
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @return the range of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByporTipo(
		long tipofk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the licencia_permisos where tipofk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param tipofk the tipofk
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByporTipo(
		long tipofk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first licencia_permiso in the ordered set where tipofk = &#63;.
	*
	* @param tipofk the tipofk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso findByporTipo_First(long tipofk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first licencia_permiso in the ordered set where tipofk = &#63;.
	*
	* @param tipofk the tipofk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso fetchByporTipo_First(long tipofk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last licencia_permiso in the ordered set where tipofk = &#63;.
	*
	* @param tipofk the tipofk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso findByporTipo_Last(long tipofk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last licencia_permiso in the ordered set where tipofk = &#63;.
	*
	* @param tipofk the tipofk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso fetchByporTipo_Last(long tipofk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the licencia_permisos before and after the current licencia_permiso in the ordered set where tipofk = &#63;.
	*
	* @param id the primary key of the current licencia_permiso
	* @param tipofk the tipofk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso[] findByporTipo_PrevAndNext(
		long id, long tipofk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the licencia_permisos where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @return the matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByCreator(
		long creadoPor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the licencia_permisos where creadoPor = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param creadoPor the creado por
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @return the range of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByCreator(
		long creadoPor, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the licencia_permisos where creadoPor = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param creadoPor the creado por
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByCreator(
		long creadoPor, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first licencia_permiso in the ordered set where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso findByCreator_First(
		long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first licencia_permiso in the ordered set where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso fetchByCreator_First(
		long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last licencia_permiso in the ordered set where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso findByCreator_Last(
		long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last licencia_permiso in the ordered set where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso fetchByCreator_Last(
		long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the licencia_permisos before and after the current licencia_permiso in the ordered set where creadoPor = &#63;.
	*
	* @param id the primary key of the current licencia_permiso
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso[] findByCreator_PrevAndNext(
		long id, long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the licencia_permisos where usuariofk = &#63;.
	*
	* @param usuariofk the usuariofk
	* @return the matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByPerson(
		java.lang.String usuariofk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the licencia_permisos where usuariofk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param usuariofk the usuariofk
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @return the range of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByPerson(
		java.lang.String usuariofk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the licencia_permisos where usuariofk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param usuariofk the usuariofk
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByPerson(
		java.lang.String usuariofk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first licencia_permiso in the ordered set where usuariofk = &#63;.
	*
	* @param usuariofk the usuariofk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso findByPerson_First(
		java.lang.String usuariofk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first licencia_permiso in the ordered set where usuariofk = &#63;.
	*
	* @param usuariofk the usuariofk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso fetchByPerson_First(
		java.lang.String usuariofk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last licencia_permiso in the ordered set where usuariofk = &#63;.
	*
	* @param usuariofk the usuariofk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso findByPerson_Last(
		java.lang.String usuariofk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last licencia_permiso in the ordered set where usuariofk = &#63;.
	*
	* @param usuariofk the usuariofk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso fetchByPerson_Last(
		java.lang.String usuariofk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the licencia_permisos before and after the current licencia_permiso in the ordered set where usuariofk = &#63;.
	*
	* @param id the primary key of the current licencia_permiso
	* @param usuariofk the usuariofk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso[] findByPerson_PrevAndNext(
		long id, java.lang.String usuariofk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the licencia_permisos where estatus = &#63;.
	*
	* @param estatus the estatus
	* @return the matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByEstatus(
		int estatus) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the licencia_permisos where estatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param estatus the estatus
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @return the range of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByEstatus(
		int estatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the licencia_permisos where estatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param estatus the estatus
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByEstatus(
		int estatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first licencia_permiso in the ordered set where estatus = &#63;.
	*
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso findByEstatus_First(int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first licencia_permiso in the ordered set where estatus = &#63;.
	*
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso fetchByEstatus_First(int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last licencia_permiso in the ordered set where estatus = &#63;.
	*
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso findByEstatus_Last(int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last licencia_permiso in the ordered set where estatus = &#63;.
	*
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso fetchByEstatus_Last(int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the licencia_permisos before and after the current licencia_permiso in the ordered set where estatus = &#63;.
	*
	* @param id the primary key of the current licencia_permiso
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso[] findByEstatus_PrevAndNext(
		long id, int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the licencia_permisos where despacho = &#63;.
	*
	* @param despacho the despacho
	* @return the matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByDespacho(
		java.lang.String despacho)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the licencia_permisos where despacho = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param despacho the despacho
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @return the range of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByDespacho(
		java.lang.String despacho, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the licencia_permisos where despacho = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param despacho the despacho
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findByDespacho(
		java.lang.String despacho, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first licencia_permiso in the ordered set where despacho = &#63;.
	*
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso findByDespacho_First(
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first licencia_permiso in the ordered set where despacho = &#63;.
	*
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso fetchByDespacho_First(
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last licencia_permiso in the ordered set where despacho = &#63;.
	*
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso findByDespacho_Last(
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last licencia_permiso in the ordered set where despacho = &#63;.
	*
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso fetchByDespacho_Last(
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the licencia_permisos before and after the current licencia_permiso in the ordered set where despacho = &#63;.
	*
	* @param id the primary key of the current licencia_permiso
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next licencia_permiso
	* @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.licencia_permiso[] findByDespacho_PrevAndNext(
		long id, java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchlicencia_permisoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the licencia_permisos.
	*
	* @return the licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the licencia_permisos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @return the range of licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the licencia_permisos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of licencia_permisos
	* @param end the upper bound of the range of licencia_permisos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.licencia_permiso> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the licencia_permisos where tipofk = &#63; from the database.
	*
	* @param tipofk the tipofk
	* @throws SystemException if a system exception occurred
	*/
	public void removeByporTipo(long tipofk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the licencia_permisos where creadoPor = &#63; from the database.
	*
	* @param creadoPor the creado por
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreator(long creadoPor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the licencia_permisos where usuariofk = &#63; from the database.
	*
	* @param usuariofk the usuariofk
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPerson(java.lang.String usuariofk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the licencia_permisos where estatus = &#63; from the database.
	*
	* @param estatus the estatus
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEstatus(int estatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the licencia_permisos where despacho = &#63; from the database.
	*
	* @param despacho the despacho
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDespacho(java.lang.String despacho)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the licencia_permisos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of licencia_permisos where tipofk = &#63;.
	*
	* @param tipofk the tipofk
	* @return the number of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public int countByporTipo(long tipofk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of licencia_permisos where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @return the number of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreator(long creadoPor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of licencia_permisos where usuariofk = &#63;.
	*
	* @param usuariofk the usuariofk
	* @return the number of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public int countByPerson(java.lang.String usuariofk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of licencia_permisos where estatus = &#63;.
	*
	* @param estatus the estatus
	* @return the number of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public int countByEstatus(int estatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of licencia_permisos where despacho = &#63;.
	*
	* @param despacho the despacho
	* @return the number of matching licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public int countByDespacho(java.lang.String despacho)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of licencia_permisos.
	*
	* @return the number of licencia_permisos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}