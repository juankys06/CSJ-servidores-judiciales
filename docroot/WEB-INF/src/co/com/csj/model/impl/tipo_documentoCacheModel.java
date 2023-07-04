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

import co.com.csj.model.tipo_documento;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing tipo_documento in entity cache.
 *
 * @author villartech
 * @see tipo_documento
 * @generated
 */
public class tipo_documentoCacheModel implements CacheModel<tipo_documento>,
	Serializable {
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

	public tipo_documento toEntityModel() {
		tipo_documentoImpl tipo_documentoImpl = new tipo_documentoImpl();

		tipo_documentoImpl.set_id(_id);

		if (desc == null) {
			tipo_documentoImpl.setDesc(StringPool.BLANK);
		}
		else {
			tipo_documentoImpl.setDesc(desc);
		}

		tipo_documentoImpl.resetOriginalValues();

		return tipo_documentoImpl;
	}

	public long _id;
	public String desc;
}