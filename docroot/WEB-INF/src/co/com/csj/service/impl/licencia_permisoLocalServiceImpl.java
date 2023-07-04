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

package co.com.csj.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import co.com.csj.NoSuchlicencia_permisoException;
import co.com.csj.model.licencia_permiso;
import co.com.csj.service.base.licencia_permisoLocalServiceBaseImpl;

/**
 * The implementation of the licencia_permiso local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link co.com.csj.service.licencia_permisoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author villartech
 * @see co.com.csj.service.base.licencia_permisoLocalServiceBaseImpl
 * @see co.com.csj.service.licencia_permisoLocalServiceUtil
 */
public class licencia_permisoLocalServiceImpl
	extends licencia_permisoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link co.com.csj.service.licencia_permisoLocalServiceUtil} to access the licencia_permiso local service.
	 */
	public List<licencia_permiso> getAll() throws SystemException{
		return licencia_permisoPersistence.findByEstatus(1);
	}
	public List<licencia_permiso> porPersona(String personId){
		try {
			return licencia_permisoPersistence.findByPerson(personId);
		} catch (SystemException e) {
			return new ArrayList<licencia_permiso>();
		}
	}
	public List<licencia_permiso> findporTipo(long idTipo) throws NoSuchlicencia_permisoException, SystemException{
		return  licencia_permisoPersistence.findByporTipo(idTipo);
	}
	public List<licencia_permiso> getByCreator(long userId) throws NoSuchlicencia_permisoException, SystemException{
		return licencia_permisoPersistence.findByCreator(userId);
	}
}