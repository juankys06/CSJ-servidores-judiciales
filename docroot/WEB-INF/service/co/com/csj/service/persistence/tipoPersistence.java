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

import co.com.csj.model.tipo;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the tipo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see tipoPersistenceImpl
 * @see tipoUtil
 * @generated
 */
public interface tipoPersistence extends BasePersistence<tipo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link tipoUtil} to access the tipo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tipo in the entity cache if it is enabled.
	*
	* @param tipo the tipo
	*/
	public void cacheResult(co.com.csj.model.tipo tipo);

	/**
	* Caches the tipos in the entity cache if it is enabled.
	*
	* @param tipos the tipos
	*/
	public void cacheResult(java.util.List<co.com.csj.model.tipo> tipos);

	/**
	* Creates a new tipo with the primary key. Does not add the tipo to the database.
	*
	* @param id the primary key for the new tipo
	* @return the new tipo
	*/
	public co.com.csj.model.tipo create(long id);

	/**
	* Removes the tipo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the tipo
	* @return the tipo that was removed
	* @throws co.com.csj.NoSuchtipoException if a tipo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.tipo remove(long id)
		throws co.com.csj.NoSuchtipoException,
			com.liferay.portal.kernel.exception.SystemException;

	public co.com.csj.model.tipo updateImpl(co.com.csj.model.tipo tipo,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tipo with the primary key or throws a {@link co.com.csj.NoSuchtipoException} if it could not be found.
	*
	* @param id the primary key of the tipo
	* @return the tipo
	* @throws co.com.csj.NoSuchtipoException if a tipo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.tipo findByPrimaryKey(long id)
		throws co.com.csj.NoSuchtipoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tipo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the tipo
	* @return the tipo, or <code>null</code> if a tipo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.tipo fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tipos.
	*
	* @return the tipos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.tipo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tipos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tipos
	* @param end the upper bound of the range of tipos (not inclusive)
	* @return the range of tipos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.tipo> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tipos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tipos
	* @param end the upper bound of the range of tipos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.tipo> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tipos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tipos.
	*
	* @return the number of tipos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}