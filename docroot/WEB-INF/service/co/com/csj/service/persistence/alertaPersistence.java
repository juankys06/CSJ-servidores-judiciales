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

import co.com.csj.model.alerta;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the alerta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see alertaPersistenceImpl
 * @see alertaUtil
 * @generated
 */
public interface alertaPersistence extends BasePersistence<alerta> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link alertaUtil} to access the alerta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the alerta in the entity cache if it is enabled.
	*
	* @param alerta the alerta
	*/
	public void cacheResult(co.com.csj.model.alerta alerta);

	/**
	* Caches the alertas in the entity cache if it is enabled.
	*
	* @param alertas the alertas
	*/
	public void cacheResult(java.util.List<co.com.csj.model.alerta> alertas);

	/**
	* Creates a new alerta with the primary key. Does not add the alerta to the database.
	*
	* @param id the primary key for the new alerta
	* @return the new alerta
	*/
	public co.com.csj.model.alerta create(java.lang.String id);

	/**
	* Removes the alerta with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the alerta
	* @return the alerta that was removed
	* @throws co.com.csj.NoSuchalertaException if a alerta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.alerta remove(java.lang.String id)
		throws co.com.csj.NoSuchalertaException,
			com.liferay.portal.kernel.exception.SystemException;

	public co.com.csj.model.alerta updateImpl(co.com.csj.model.alerta alerta,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the alerta with the primary key or throws a {@link co.com.csj.NoSuchalertaException} if it could not be found.
	*
	* @param id the primary key of the alerta
	* @return the alerta
	* @throws co.com.csj.NoSuchalertaException if a alerta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.alerta findByPrimaryKey(java.lang.String id)
		throws co.com.csj.NoSuchalertaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the alerta with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the alerta
	* @return the alerta, or <code>null</code> if a alerta with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.alerta fetchByPrimaryKey(java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the alertas.
	*
	* @return the alertas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.alerta> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the alertas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of alertas
	* @param end the upper bound of the range of alertas (not inclusive)
	* @return the range of alertas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.alerta> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the alertas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of alertas
	* @param end the upper bound of the range of alertas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of alertas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.alerta> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the alertas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of alertas.
	*
	* @return the number of alertas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}