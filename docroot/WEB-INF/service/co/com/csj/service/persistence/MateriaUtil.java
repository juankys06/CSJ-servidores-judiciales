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

import co.com.csj.model.Materia;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the materia service. This utility wraps {@link MateriaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see MateriaPersistence
 * @see MateriaPersistenceImpl
 * @generated
 */
public class MateriaUtil {
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
	public static void clearCache(Materia materia) {
		getPersistence().clearCache(materia);
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
	public static List<Materia> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Materia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Materia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Materia update(Materia materia, boolean merge)
		throws SystemException {
		return getPersistence().update(materia, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Materia update(Materia materia, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(materia, merge, serviceContext);
	}

	/**
	* Caches the materia in the entity cache if it is enabled.
	*
	* @param materia the materia
	*/
	public static void cacheResult(co.com.csj.model.Materia materia) {
		getPersistence().cacheResult(materia);
	}

	/**
	* Caches the materias in the entity cache if it is enabled.
	*
	* @param materias the materias
	*/
	public static void cacheResult(
		java.util.List<co.com.csj.model.Materia> materias) {
		getPersistence().cacheResult(materias);
	}

	/**
	* Creates a new materia with the primary key. Does not add the materia to the database.
	*
	* @param id the primary key for the new materia
	* @return the new materia
	*/
	public static co.com.csj.model.Materia create(java.lang.String id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the materia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the materia
	* @return the materia that was removed
	* @throws co.com.csj.NoSuchMateriaException if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Materia remove(java.lang.String id)
		throws co.com.csj.NoSuchMateriaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(id);
	}

	public static co.com.csj.model.Materia updateImpl(
		co.com.csj.model.Materia materia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(materia, merge);
	}

	/**
	* Returns the materia with the primary key or throws a {@link co.com.csj.NoSuchMateriaException} if it could not be found.
	*
	* @param id the primary key of the materia
	* @return the materia
	* @throws co.com.csj.NoSuchMateriaException if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Materia findByPrimaryKey(java.lang.String id)
		throws co.com.csj.NoSuchMateriaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the materia with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the materia
	* @return the materia, or <code>null</code> if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static co.com.csj.model.Materia fetchByPrimaryKey(
		java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the materias.
	*
	* @return the materias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.Materia> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the materias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of materias
	* @param end the upper bound of the range of materias (not inclusive)
	* @return the range of materias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.Materia> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the materias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of materias
	* @param end the upper bound of the range of materias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of materias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<co.com.csj.model.Materia> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the materias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of materias.
	*
	* @return the number of materias
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MateriaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MateriaPersistence)PortletBeanLocatorUtil.locate(co.com.csj.service.ClpSerializer.getServletContextName(),
					MateriaPersistence.class.getName());

			ReferenceRegistry.registerReference(MateriaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(MateriaPersistence persistence) {
	}

	private static MateriaPersistence _persistence;
}