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

import co.com.csj.model.cargo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing cargo in entity cache.
 *
 * @author villartech
 * @see cargo
 * @generated
 */
public class cargoCacheModel implements CacheModel<cargo>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{_id=");
		sb.append(_id);
		sb.append(", desc=");
		sb.append(desc);
		sb.append("}");

		return sb.toString();
	}

	public cargo toEntityModel() {
		cargoImpl cargoImpl = new cargoImpl();

		cargoImpl.set_id(_id);

		if (desc == null) {
			cargoImpl.setDesc(StringPool.BLANK);
		}
		else {
			cargoImpl.setDesc(desc);
		}

		cargoImpl.resetOriginalValues();

		return cargoImpl;
	}

	public long _id;
	public String desc;
}