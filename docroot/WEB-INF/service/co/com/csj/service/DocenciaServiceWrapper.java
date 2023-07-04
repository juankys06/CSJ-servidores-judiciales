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

package co.com.csj.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link DocenciaService}.
 * </p>
 *
 * @author    villartech
 * @see       DocenciaService
 * @generated
 */
public class DocenciaServiceWrapper implements DocenciaService,
	ServiceWrapper<DocenciaService> {
	public DocenciaServiceWrapper(DocenciaService docenciaService) {
		_docenciaService = docenciaService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _docenciaService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_docenciaService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _docenciaService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public DocenciaService getWrappedDocenciaService() {
		return _docenciaService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedDocenciaService(DocenciaService docenciaService) {
		_docenciaService = docenciaService;
	}

	public DocenciaService getWrappedService() {
		return _docenciaService;
	}

	public void setWrappedService(DocenciaService docenciaService) {
		_docenciaService = docenciaService;
	}

	private DocenciaService _docenciaService;
}