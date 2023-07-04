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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import co.com.csj.NoSuchpermisosException;
import co.com.csj.model.permisos;
import co.com.csj.service.base.permisosLocalServiceBaseImpl;

/**
 * The implementation of the permisos local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link co.com.csj.service.permisosLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author villartech
 * @see co.com.csj.service.base.permisosLocalServiceBaseImpl
 * @see co.com.csj.service.permisosLocalServiceUtil
 */
public class permisosLocalServiceImpl extends permisosLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link co.com.csj.service.permisosLocalServiceUtil} to access the permisos local service.
	 */
	public permisos getByUser(String userID){
		try {
			return permisosPersistence.findByUsuario(userID);
		} catch (NoSuchpermisosException e) {
			System.err.println("ERROR: No existe ese usuario en la BD de permisos.");
			return null;
		} catch (SystemException e) {
			System.err.println("ERROR: hubo un problema con la consulta.");
			return null;
		}
	}
	
	public List<permisos> getByUserR(String userID){
		try {
			return permisosPersistence.findByUsuarioR(userID);
		} catch (SystemException e) {
			System.err.println("ERROR: hubo un problema con la consulta.");
			return null;
		}
	}
}