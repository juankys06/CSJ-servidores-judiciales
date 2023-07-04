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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the cargo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see cargoPersistenceImpl
 * @see cargoUtil
 * @generated
 */
public interface cargoPersistence extends BasePersistence<cargo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link cargoUtil} to access the cargo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the cargo in the entity cache if it is enabled.
	*
	* @param cargo the cargo
	*/
	public void cacheResult(co.com.csj.model.cargo cargo);

	/**
	* Caches the cargos in the entity cache if it is enabled.
	*
	* @param cargos the cargos
	*/
	public void cacheResult(java.util.List<co.com.csj.model.cargo> cargos);

	/**
	* Creates a new cargo with the primary key. Does not add the cargo to the database.
	*
	* @param _id the primary key for the new cargo
	* @return the new cargo
	*/
	public co.com.csj.model.cargo create(long _id);

	/**
	* Removes the cargo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param _id the primary key of the cargo
	* @return the cargo that was removed
	* @throws co.com.csj.NoSuchcargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.cargo remove(long _id)
		throws co.com.csj.NoSuchcargoException,
			com.liferay.portal.kernel.exception.SystemException;

	public co.com.csj.model.cargo updateImpl(co.com.csj.model.cargo cargo,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargo with the primary key or throws a {@link co.com.csj.NoSuchcargoException} if it could not be found.
	*
	* @param _id the primary key of the cargo
	* @return the cargo
	* @throws co.com.csj.NoSuchcargoException if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.cargo findByPrimaryKey(long _id)
		throws co.com.csj.NoSuchcargoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cargo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param _id the primary key of the cargo
	* @return the cargo, or <code>null</code> if a cargo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.cargo fetchByPrimaryKey(long _id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cargos.
	*
	* @return the cargos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.cargo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<co.com.csj.model.cargo> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<co.com.csj.model.cargo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cargos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cargos.
	*
	* @return the number of cargos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}