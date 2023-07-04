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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the usuario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see usuarioPersistenceImpl
 * @see usuarioUtil
 * @generated
 */
public interface usuarioPersistence extends BasePersistence<usuario> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link usuarioUtil} to access the usuario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the usuario in the entity cache if it is enabled.
	*
	* @param usuario the usuario
	*/
	public void cacheResult(co.com.csj.model.usuario usuario);

	/**
	* Caches the usuarios in the entity cache if it is enabled.
	*
	* @param usuarios the usuarios
	*/
	public void cacheResult(java.util.List<co.com.csj.model.usuario> usuarios);

	/**
	* Creates a new usuario with the primary key. Does not add the usuario to the database.
	*
	* @param id the primary key for the new usuario
	* @return the new usuario
	*/
	public co.com.csj.model.usuario create(java.lang.String id);

	/**
	* Removes the usuario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the usuario
	* @return the usuario that was removed
	* @throws co.com.csj.NoSuchusuarioException if a usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.usuario remove(java.lang.String id)
		throws co.com.csj.NoSuchusuarioException,
			com.liferay.portal.kernel.exception.SystemException;

	public co.com.csj.model.usuario updateImpl(
		co.com.csj.model.usuario usuario, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the usuario with the primary key or throws a {@link co.com.csj.NoSuchusuarioException} if it could not be found.
	*
	* @param id the primary key of the usuario
	* @return the usuario
	* @throws co.com.csj.NoSuchusuarioException if a usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.usuario findByPrimaryKey(java.lang.String id)
		throws co.com.csj.NoSuchusuarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the usuario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the usuario
	* @return the usuario, or <code>null</code> if a usuario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.usuario fetchByPrimaryKey(java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the usuarios.
	*
	* @return the usuarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.usuario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<co.com.csj.model.usuario> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<co.com.csj.model.usuario> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the usuarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of usuarios.
	*
	* @return the number of usuarios
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}