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

import co.com.csj.model.Docencia;
import co.com.csj.service.base.DocenciaLocalServiceBaseImpl;

/**
 * The implementation of the docencia local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link co.com.csj.service.DocenciaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author villartech
 * @see co.com.csj.service.base.DocenciaLocalServiceBaseImpl
 * @see co.com.csj.service.DocenciaLocalServiceUtil
 */
public class DocenciaLocalServiceImpl extends DocenciaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link co.com.csj.service.DocenciaLocalServiceUtil} to access the docencia local service.
	 */
	public List<Docencia> getAll() throws SystemException{
		return docenciaPersistence.findByEstatus(1);
	}
	public List<Docencia> porDocente(String personId){
		try {
			return docenciaPersistence.findByDocente(personId);
		} catch (SystemException e) {
			return new ArrayList<Docencia>();
		}
	}
	public List<Docencia> getByCreator(long userId) throws SystemException{
		return docenciaPersistence.findByCreator(userId);
	}
}