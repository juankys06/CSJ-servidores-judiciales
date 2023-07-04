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

import co.com.csj.model.tipo_documento;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the tipo_documento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see tipo_documentoPersistenceImpl
 * @see tipo_documentoUtil
 * @generated
 */
public interface tipo_documentoPersistence extends BasePersistence<tipo_documento> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link tipo_documentoUtil} to access the tipo_documento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the tipo_documento in the entity cache if it is enabled.
	*
	* @param tipo_documento the tipo_documento
	*/
	public void cacheResult(co.com.csj.model.tipo_documento tipo_documento);

	/**
	* Caches the tipo_documentos in the entity cache if it is enabled.
	*
	* @param tipo_documentos the tipo_documentos
	*/
	public void cacheResult(
		java.util.List<co.com.csj.model.tipo_documento> tipo_documentos);

	/**
	* Creates a new tipo_documento with the primary key. Does not add the tipo_documento to the database.
	*
	* @param _id the primary key for the new tipo_documento
	* @return the new tipo_documento
	*/
	public co.com.csj.model.tipo_documento create(long _id);

	/**
	* Removes the tipo_documento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param _id the primary key of the tipo_documento
	* @return the tipo_documento that was removed
	* @throws co.com.csj.NoSuchtipo_documentoException if a tipo_documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.tipo_documento remove(long _id)
		throws co.com.csj.NoSuchtipo_documentoException,
			com.liferay.portal.kernel.exception.SystemException;

	public co.com.csj.model.tipo_documento updateImpl(
		co.com.csj.model.tipo_documento tipo_documento, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tipo_documento with the primary key or throws a {@link co.com.csj.NoSuchtipo_documentoException} if it could not be found.
	*
	* @param _id the primary key of the tipo_documento
	* @return the tipo_documento
	* @throws co.com.csj.NoSuchtipo_documentoException if a tipo_documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.tipo_documento findByPrimaryKey(long _id)
		throws co.com.csj.NoSuchtipo_documentoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the tipo_documento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param _id the primary key of the tipo_documento
	* @return the tipo_documento, or <code>null</code> if a tipo_documento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public co.com.csj.model.tipo_documento fetchByPrimaryKey(long _id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tipo_documentos.
	*
	* @return the tipo_documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.tipo_documento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tipo_documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tipo_documentos
	* @param end the upper bound of the range of tipo_documentos (not inclusive)
	* @return the range of tipo_documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.tipo_documento> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tipo_documentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of tipo_documentos
	* @param end the upper bound of the range of tipo_documentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tipo_documentos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<co.com.csj.model.tipo_documento> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tipo_documentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tipo_documentos.
	*
	* @return the number of tipo_documentos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}