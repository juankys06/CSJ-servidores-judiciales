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

import co.com.csj.model.tipo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing tipo in entity cache.
 *
 * @author villartech
 * @see tipo
 * @generated
 */
public class tipoCacheModel implements CacheModel<tipo>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{id=");
		sb.append(id);
		sb.append(", descripcion=");
		sb.append(descripcion);
		sb.append("}");

		return sb.toString();
	}

	public tipo toEntityModel() {
		tipoImpl tipoImpl = new tipoImpl();

		tipoImpl.setId(id);

		if (descripcion == null) {
			tipoImpl.setDescripcion(StringPool.BLANK);
		}
		else {
			tipoImpl.setDescripcion(descripcion);
		}

		tipoImpl.resetOriginalValues();

		return tipoImpl;
	}

	public long id;
	public String descripcion;
}