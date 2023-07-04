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

import co.com.csj.model.Docencia;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the docencia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see DocenciaPersistenceImpl
 * @see DocenciaUtil
 * @generated
 */
public interface DocenciaPersistence extends BasePersistence<Docencia> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DocenciaUtil} to access the docencia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the docencia in the entity cache if it is enabled.
	*
	* @param docencia the docencia
	*/
	public void cacheResult(co.com.csj.model.Docencia docencia);

	/**
	* Caches the docencias in the entity cache if it is enabled.
	*
	* @param docencias the docencias
	*/
	public void cacheResult(java.util.List<co.com.csj.model.Docencia> docencias);

	/**
	* Creates a new docencia with the primary key. Does not add the docencia to the database.
	*
	* @param id the primary key for the new docencia
	* @return the new docencia
	*/
	public co.com.csj.model.Docencia create(long id);

	/**
	* Removes the docencia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the docencia
	* @return the docencia that was removed
	* @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia remove(long id)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	public co.com.csj.model.Docencia updateImpl(
		co.com.csj.model.Docencia docencia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the docencia with the primary key or throws a {@link co.com.csj.NoSuchDocenciaException} if it could not be found.
	*
	* @param id the primary key of the docencia
	* @return the docencia
	* @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia findByPrimaryKey(long id)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the docencia with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the docencia
	* @return the docencia, or <code>null</code> if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the docencias where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @return the matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findByCreator(
		long creadoPor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the docencias where creadoPor = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param creadoPor the creado por
	* @param start the lower bound of the range of docencias
	* @param end the upper bound of the range of docencias (not inclusive)
	* @return the range of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findByCreator(
		long creadoPor, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the docencias where creadoPor = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param creadoPor the creado por
	* @param start the lower bound of the range of docencias
	* @param end the upper bound of the range of docencias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findByCreator(
		long creadoPor, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first docencia in the ordered set where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia findByCreator_First(long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first docencia in the ordered set where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia fetchByCreator_First(long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last docencia in the ordered set where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia findByCreator_Last(long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last docencia in the ordered set where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia fetchByCreator_Last(long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the docencias before and after the current docencia in the ordered set where creadoPor = &#63;.
	*
	* @param id the primary key of the current docencia
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next docencia
	* @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia[] findByCreator_PrevAndNext(long id,
		long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the docencias where estatus = &#63;.
	*
	* @param estatus the estatus
	* @return the matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findByEstatus(int estatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the docencias where estatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param estatus the estatus
	* @param start the lower bound of the range of docencias
	* @param end the upper bound of the range of docencias (not inclusive)
	* @return the range of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findByEstatus(
		int estatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the docencias where estatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param estatus the estatus
	* @param start the lower bound of the range of docencias
	* @param end the upper bound of the range of docencias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findByEstatus(
		int estatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first docencia in the ordered set where estatus = &#63;.
	*
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia findByEstatus_First(int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first docencia in the ordered set where estatus = &#63;.
	*
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia fetchByEstatus_First(int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last docencia in the ordered set where estatus = &#63;.
	*
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia findByEstatus_Last(int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last docencia in the ordered set where estatus = &#63;.
	*
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia fetchByEstatus_Last(int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the docencias before and after the current docencia in the ordered set where estatus = &#63;.
	*
	* @param id the primary key of the current docencia
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next docencia
	* @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia[] findByEstatus_PrevAndNext(long id,
		int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the docencias where despacho = &#63;.
	*
	* @param despacho the despacho
	* @return the matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findByDespacho(
		java.lang.String despacho)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the docencias where despacho = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param despacho the despacho
	* @param start the lower bound of the range of docencias
	* @param end the upper bound of the range of docencias (not inclusive)
	* @return the range of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findByDespacho(
		java.lang.String despacho, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the docencias where despacho = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param despacho the despacho
	* @param start the lower bound of the range of docencias
	* @param end the upper bound of the range of docencias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findByDespacho(
		java.lang.String despacho, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first docencia in the ordered set where despacho = &#63;.
	*
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia findByDespacho_First(
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first docencia in the ordered set where despacho = &#63;.
	*
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia fetchByDespacho_First(
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last docencia in the ordered set where despacho = &#63;.
	*
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia findByDespacho_Last(
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last docencia in the ordered set where despacho = &#63;.
	*
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia fetchByDespacho_Last(
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the docencias before and after the current docencia in the ordered set where despacho = &#63;.
	*
	* @param id the primary key of the current docencia
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next docencia
	* @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia[] findByDespacho_PrevAndNext(long id,
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the docencias where usuario_fk = &#63;.
	*
	* @param usuario_fk the usuario_fk
	* @return the matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findByDocente(
		java.lang.String usuario_fk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the docencias where usuario_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param usuario_fk the usuario_fk
	* @param start the lower bound of the range of docencias
	* @param end the upper bound of the range of docencias (not inclusive)
	* @return the range of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findByDocente(
		java.lang.String usuario_fk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the docencias where usuario_fk = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param usuario_fk the usuario_fk
	* @param start the lower bound of the range of docencias
	* @param end the upper bound of the range of docencias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findByDocente(
		java.lang.String usuario_fk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first docencia in the ordered set where usuario_fk = &#63;.
	*
	* @param usuario_fk the usuario_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia findByDocente_First(
		java.lang.String usuario_fk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first docencia in the ordered set where usuario_fk = &#63;.
	*
	* @param usuario_fk the usuario_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia fetchByDocente_First(
		java.lang.String usuario_fk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last docencia in the ordered set where usuario_fk = &#63;.
	*
	* @param usuario_fk the usuario_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia findByDocente_Last(
		java.lang.String usuario_fk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last docencia in the ordered set where usuario_fk = &#63;.
	*
	* @param usuario_fk the usuario_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia fetchByDocente_Last(
		java.lang.String usuario_fk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the docencias before and after the current docencia in the ordered set where usuario_fk = &#63;.
	*
	* @param id the primary key of the current docencia
	* @param usuario_fk the usuario_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next docencia
	* @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Docencia[] findByDocente_PrevAndNext(long id,
		java.lang.String usuario_fk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the docencias.
	*
	* @return the docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<co.com.csj.model.Docencia> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the docencias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of docencias
	* @param end the upper bound of the range of docencias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of docencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Docencia> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the docencias where creadoPor = &#63; from the database.
	*
	* @param creadoPor the creado por
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCreator(long creadoPor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the docencias where estatus = &#63; from the database.
	*
	* @param estatus the estatus
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEstatus(int estatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the docencias where despacho = &#63; from the database.
	*
	* @param despacho the despacho
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDespacho(java.lang.String despacho)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the docencias where usuario_fk = &#63; from the database.
	*
	* @param usuario_fk the usuario_fk
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDocente(java.lang.String usuario_fk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the docencias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of docencias where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @return the number of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public int countByCreator(long creadoPor)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of docencias where estatus = &#63;.
	*
	* @param estatus the estatus
	* @return the number of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public int countByEstatus(int estatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of docencias where despacho = &#63;.
	*
	* @param despacho the despacho
	* @return the number of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public int countByDespacho(java.lang.String despacho)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of docencias where usuario_fk = &#63;.
	*
	* @param usuario_fk the usuario_fk
	* @return the number of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public int countByDocente(java.lang.String usuario_fk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of docencias.
	*
	* @return the number of docencias
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}