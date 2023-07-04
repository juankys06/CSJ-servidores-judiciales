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

package co.com.csj.model.impl;

import co.com.csj.model.licencia_permiso;
import co.com.csj.service.licencia_permisoLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the licencia_permiso service. Represents a row in the &quot;SJ_licencia_permiso&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link licencia_permisoImpl}.
 * </p>
 *
 * @author villartech
 * @see licencia_permisoImpl
 * @see co.com.csj.model.licencia_permiso
 * @generated
 */
public abstract class licencia_permisoBaseImpl extends licencia_permisoModelImpl
	implements licencia_permiso {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a licencia_permiso model instance should use the {@link licencia_permiso} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			licencia_permisoLocalServiceUtil.addlicencia_permiso(this);
		}
		else {
			licencia_permisoLocalServiceUtil.updatelicencia_permiso(this);
		}
	}
}