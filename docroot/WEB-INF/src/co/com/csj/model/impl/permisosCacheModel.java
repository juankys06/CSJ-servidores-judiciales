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

import co.com.csj.model.permisos;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing permisos in entity cache.
 *
 * @author villartech
 * @see permisos
 * @generated
 */
public class permisosCacheModel implements CacheModel<permisos>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", cargo=");
		sb.append(cargo);
		sb.append(", d_m=");
		sb.append(d_m);
		sb.append(", usuario=");
		sb.append(usuario);
		sb.append(", creacion=");
		sb.append(creacion);
		sb.append("}");

		return sb.toString();
	}

	public permisos toEntityModel() {
		permisosImpl permisosImpl = new permisosImpl();

		permisosImpl.setId(id);

		if (cargo == null) {
			permisosImpl.setCargo(StringPool.BLANK);
		}
		else {
			permisosImpl.setCargo(cargo);
		}

		if (d_m == null) {
			permisosImpl.setD_m(StringPool.BLANK);
		}
		else {
			permisosImpl.setD_m(d_m);
		}

		if (usuario == null) {
			permisosImpl.setUsuario(StringPool.BLANK);
		}
		else {
			permisosImpl.setUsuario(usuario);
		}

		if (creacion == Long.MIN_VALUE) {
			permisosImpl.setCreacion(null);
		}
		else {
			permisosImpl.setCreacion(new Date(creacion));
		}

		permisosImpl.resetOriginalValues();

		return permisosImpl;
	}

	public long id;
	public String cargo;
	public String d_m;
	public String usuario;
	public long creacion;
}