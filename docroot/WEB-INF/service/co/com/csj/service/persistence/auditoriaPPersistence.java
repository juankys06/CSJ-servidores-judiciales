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

import co.com.csj.model.auditoriaP;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the auditoria p service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see auditoriaPPersistenceImpl
 * @see auditoriaPUtil
 * @generated
 */
public interface auditoriaPPersistence extends BasePersistence<auditoriaP> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link auditoriaPUtil} to access the auditoria p persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the auditoria p in the entity cache if it is enabled.
	*
	* @param auditoriaP the auditoria p
	*/
	public void cacheResult(co.com.csj.model.auditoriaP auditoriaP);

	/**
	* Caches the auditoria ps in the entity cache if it is enabled.
	*
	* @param auditoriaPs the auditoria ps
	*/
	public void cacheResult(
		java.util.List<co.com.csj.model.auditoriaP> auditoriaPs);

	/**
	* Creates a new auditoria p with the primary key. Does not add the auditoria p to the database.
	*
	* @param id the primary key for the new auditoria p
	* @return the new auditoria p
	*/
	public co.com.csj.model.auditoriaP create(long id);

	/**
	* Removes the auditoria p with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the auditoria p
	* @return the auditoria p that was removed
	* @throws co.com.csj.NoSuchauditoriaPException if a auditoria p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.auditoriaP remove(long id)
		throws co.com.csj.NoSuchauditoriaPException,
			com.liferay.portal.kernel.exception.SystemException;

	public co.com.csj.model.auditoriaP updateImpl(
		co.com.csj.model.auditoriaP auditoriaP, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the auditoria p with the primary key or throws a {@link co.com.csj.NoSuchauditoriaPException} if it could not be found.
	*
	* @param id the primary key of the auditoria p
	* @return the auditoria p
	* @throws co.com.csj.NoSuchauditoriaPException if a auditoria p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.auditoriaP findByPrimaryKey(long id)
		throws co.com.csj.NoSuchauditoriaPException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the auditoria p with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the auditoria p
	* @return the auditoria p, or <code>null</code> if a auditoria p with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.auditoriaP fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the auditoria ps.
	*
	* @return the auditoria ps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.auditoriaP> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the auditoria ps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria ps
	* @param end the upper bound of the range of auditoria ps (not inclusive)
	* @return the range of auditoria ps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.auditoriaP> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the auditoria ps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria ps
	* @param end the upper bound of the range of auditoria ps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of auditoria ps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.auditoriaP> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the auditoria ps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of auditoria ps.
	*
	* @return the number of auditoria ps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}