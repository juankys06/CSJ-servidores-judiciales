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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the materia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see MateriaPersistenceImpl
 * @see MateriaUtil
 * @generated
 */
public interface MateriaPersistence extends BasePersistence<Materia> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MateriaUtil} to access the materia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the materia in the entity cache if it is enabled.
	*
	* @param materia the materia
	*/
	public void cacheResult(co.com.csj.model.Materia materia);

	/**
	* Caches the materias in the entity cache if it is enabled.
	*
	* @param materias the materias
	*/
	public void cacheResult(java.util.List<co.com.csj.model.Materia> materias);

	/**
	* Creates a new materia with the primary key. Does not add the materia to the database.
	*
	* @param id the primary key for the new materia
	* @return the new materia
	*/
	public co.com.csj.model.Materia create(java.lang.String id);

	/**
	* Removes the materia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the materia
	* @return the materia that was removed
	* @throws co.com.csj.NoSuchMateriaException if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Materia remove(java.lang.String id)
		throws co.com.csj.NoSuchMateriaException,
			com.liferay.portal.kernel.exception.SystemException;

	public co.com.csj.model.Materia updateImpl(
		co.com.csj.model.Materia materia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the materia with the primary key or throws a {@link co.com.csj.NoSuchMateriaException} if it could not be found.
	*
	* @param id the primary key of the materia
	* @return the materia
	* @throws co.com.csj.NoSuchMateriaException if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Materia findByPrimaryKey(java.lang.String id)
		throws co.com.csj.NoSuchMateriaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the materia with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the materia
	* @return the materia, or <code>null</code> if a materia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.Materia fetchByPrimaryKey(java.lang.String id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the materias.
	*
	* @return the materias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.Materia> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<co.com.csj.model.Materia> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<co.com.csj.model.Materia> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the materias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of materias.
	*
	* @return the number of materias
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}