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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the docencia service. This utility wraps {@link DocenciaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see DocenciaPersistence
 * @see DocenciaPersistenceImpl
 * @generated
 */
public class DocenciaUtil {
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
	public static void clearCache(Docencia docencia) {
		getPersistence().clearCache(docencia);
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
	public static List<Docencia> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Docencia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Docencia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Docencia update(Docencia docencia, boolean merge)
		throws SystemException {
		return getPersistence().update(docencia, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Docencia update(Docencia docencia, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(docencia, merge, serviceContext);
	}

	/**
	* Caches the docencia in the entity cache if it is enabled.
	*
	* @param docencia the docencia
	*/
	public static void cacheResult(co.com.csj.model.Docencia docencia) {
		getPersistence().cacheResult(docencia);
	}

	/**
	* Caches the docencias in the entity cache if it is enabled.
	*
	* @param docencias the docencias
	*/
	public static void cacheResult(
		java.util.List<co.com.csj.model.Docencia> docencias) {
		getPersistence().cacheResult(docencias);
	}

	/**
	* Creates a new docencia with the primary key. Does not add the docencia to the database.
	*
	* @param id the primary key for the new docencia
	* @return the new docencia
	*/
	public static co.com.csj.model.Docencia create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the docencia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the docencia
	* @return the docencia that was removed
	* @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia remove(long id)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static co.com.csj.model.Docencia updateImpl(
		co.com.csj.model.Docencia docencia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(docencia, merge);
	}

	/**
	* Returns the docencia with the primary key or throws a {@link co.com.csj.NoSuchDocenciaException} if it could not be found.
	*
	* @param id the primary key of the docencia
	* @return the docencia
	* @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia findByPrimaryKey(long id)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the docencia with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the docencia
	* @return the docencia, or <code>null</code> if a docencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the docencias where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @return the matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.Docencia> findByCreator(
		long creadoPor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreator(creadoPor);
	}

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
	public static java.util.List<co.com.csj.model.Docencia> findByCreator(
		long creadoPor, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreator(creadoPor, start, end);
	}

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
	public static java.util.List<co.com.csj.model.Docencia> findByCreator(
		long creadoPor, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreator(creadoPor, start, end, orderByComparator);
	}

	/**
	* Returns the first docencia in the ordered set where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia findByCreator_First(
		long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreator_First(creadoPor, orderByComparator);
	}

	/**
	* Returns the first docencia in the ordered set where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia fetchByCreator_First(
		long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCreator_First(creadoPor, orderByComparator);
	}

	/**
	* Returns the last docencia in the ordered set where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia findByCreator_Last(long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCreator_Last(creadoPor, orderByComparator);
	}

	/**
	* Returns the last docencia in the ordered set where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia fetchByCreator_Last(
		long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCreator_Last(creadoPor, orderByComparator);
	}

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
	public static co.com.csj.model.Docencia[] findByCreator_PrevAndNext(
		long id, long creadoPor,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCreator_PrevAndNext(id, creadoPor, orderByComparator);
	}

	/**
	* Returns all the docencias where estatus = &#63;.
	*
	* @param estatus the estatus
	* @return the matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.Docencia> findByEstatus(
		int estatus) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEstatus(estatus);
	}

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
	public static java.util.List<co.com.csj.model.Docencia> findByEstatus(
		int estatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEstatus(estatus, start, end);
	}

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
	public static java.util.List<co.com.csj.model.Docencia> findByEstatus(
		int estatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEstatus(estatus, start, end, orderByComparator);
	}

	/**
	* Returns the first docencia in the ordered set where estatus = &#63;.
	*
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia findByEstatus_First(int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEstatus_First(estatus, orderByComparator);
	}

	/**
	* Returns the first docencia in the ordered set where estatus = &#63;.
	*
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia fetchByEstatus_First(int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEstatus_First(estatus, orderByComparator);
	}

	/**
	* Returns the last docencia in the ordered set where estatus = &#63;.
	*
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia findByEstatus_Last(int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEstatus_Last(estatus, orderByComparator);
	}

	/**
	* Returns the last docencia in the ordered set where estatus = &#63;.
	*
	* @param estatus the estatus
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia fetchByEstatus_Last(int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEstatus_Last(estatus, orderByComparator);
	}

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
	public static co.com.csj.model.Docencia[] findByEstatus_PrevAndNext(
		long id, int estatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEstatus_PrevAndNext(id, estatus, orderByComparator);
	}

	/**
	* Returns all the docencias where despacho = &#63;.
	*
	* @param despacho the despacho
	* @return the matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.Docencia> findByDespacho(
		java.lang.String despacho)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDespacho(despacho);
	}

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
	public static java.util.List<co.com.csj.model.Docencia> findByDespacho(
		java.lang.String despacho, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDespacho(despacho, start, end);
	}

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
	public static java.util.List<co.com.csj.model.Docencia> findByDespacho(
		java.lang.String despacho, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDespacho(despacho, start, end, orderByComparator);
	}

	/**
	* Returns the first docencia in the ordered set where despacho = &#63;.
	*
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia findByDespacho_First(
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDespacho_First(despacho, orderByComparator);
	}

	/**
	* Returns the first docencia in the ordered set where despacho = &#63;.
	*
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia fetchByDespacho_First(
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDespacho_First(despacho, orderByComparator);
	}

	/**
	* Returns the last docencia in the ordered set where despacho = &#63;.
	*
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia findByDespacho_Last(
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDespacho_Last(despacho, orderByComparator);
	}

	/**
	* Returns the last docencia in the ordered set where despacho = &#63;.
	*
	* @param despacho the despacho
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia fetchByDespacho_Last(
		java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDespacho_Last(despacho, orderByComparator);
	}

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
	public static co.com.csj.model.Docencia[] findByDespacho_PrevAndNext(
		long id, java.lang.String despacho,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDespacho_PrevAndNext(id, despacho, orderByComparator);
	}

	/**
	* Returns all the docencias where usuario_fk = &#63;.
	*
	* @param usuario_fk the usuario_fk
	* @return the matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.Docencia> findByDocente(
		java.lang.String usuario_fk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDocente(usuario_fk);
	}

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
	public static java.util.List<co.com.csj.model.Docencia> findByDocente(
		java.lang.String usuario_fk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDocente(usuario_fk, start, end);
	}

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
	public static java.util.List<co.com.csj.model.Docencia> findByDocente(
		java.lang.String usuario_fk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDocente(usuario_fk, start, end, orderByComparator);
	}

	/**
	* Returns the first docencia in the ordered set where usuario_fk = &#63;.
	*
	* @param usuario_fk the usuario_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia findByDocente_First(
		java.lang.String usuario_fk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDocente_First(usuario_fk, orderByComparator);
	}

	/**
	* Returns the first docencia in the ordered set where usuario_fk = &#63;.
	*
	* @param usuario_fk the usuario_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia fetchByDocente_First(
		java.lang.String usuario_fk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDocente_First(usuario_fk, orderByComparator);
	}

	/**
	* Returns the last docencia in the ordered set where usuario_fk = &#63;.
	*
	* @param usuario_fk the usuario_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia
	* @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia findByDocente_Last(
		java.lang.String usuario_fk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDocente_Last(usuario_fk, orderByComparator);
	}

	/**
	* Returns the last docencia in the ordered set where usuario_fk = &#63;.
	*
	* @param usuario_fk the usuario_fk
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching docencia, or <code>null</code> if a matching docencia could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Docencia fetchByDocente_Last(
		java.lang.String usuario_fk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDocente_Last(usuario_fk, orderByComparator);
	}

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
	public static co.com.csj.model.Docencia[] findByDocente_PrevAndNext(
		long id, java.lang.String usuario_fk,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws co.com.csj.NoSuchDocenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDocente_PrevAndNext(id, usuario_fk, orderByComparator);
	}

	/**
	* Returns all the docencias.
	*
	* @return the docencias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.Docencia> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<co.com.csj.model.Docencia> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<co.com.csj.model.Docencia> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the docencias where creadoPor = &#63; from the database.
	*
	* @param creadoPor the creado por
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCreator(long creadoPor)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCreator(creadoPor);
	}

	/**
	* Removes all the docencias where estatus = &#63; from the database.
	*
	* @param estatus the estatus
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEstatus(int estatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEstatus(estatus);
	}

	/**
	* Removes all the docencias where despacho = &#63; from the database.
	*
	* @param despacho the despacho
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDespacho(java.lang.String despacho)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDespacho(despacho);
	}

	/**
	* Removes all the docencias where usuario_fk = &#63; from the database.
	*
	* @param usuario_fk the usuario_fk
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDocente(java.lang.String usuario_fk)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDocente(usuario_fk);
	}

	/**
	* Removes all the docencias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of docencias where creadoPor = &#63;.
	*
	* @param creadoPor the creado por
	* @return the number of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCreator(long creadoPor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCreator(creadoPor);
	}

	/**
	* Returns the number of docencias where estatus = &#63;.
	*
	* @param estatus the estatus
	* @return the number of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEstatus(int estatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEstatus(estatus);
	}

	/**
	* Returns the number of docencias where despacho = &#63;.
	*
	* @param despacho the despacho
	* @return the number of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDespacho(java.lang.String despacho)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDespacho(despacho);
	}

	/**
	* Returns the number of docencias where usuario_fk = &#63;.
	*
	* @param usuario_fk the usuario_fk
	* @return the number of matching docencias
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDocente(java.lang.String usuario_fk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDocente(usuario_fk);
	}

	/**
	* Returns the number of docencias.
	*
	* @return the number of docencias
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DocenciaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DocenciaPersistence)PortletBeanLocatorUtil.locate(co.com.csj.service.ClpSerializer.getServletContextName(),
					DocenciaPersistence.class.getName());

			ReferenceRegistry.registerReference(DocenciaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(DocenciaPersistence persistence) {
	}

	private static DocenciaPersistence _persistence;
}