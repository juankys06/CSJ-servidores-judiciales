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

import co.com.csj.model.usuario;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing usuario in entity cache.
 *
 * @author villartech
 * @see usuario
 * @generated
 */
public class usuarioCacheModel implements CacheModel<usuario>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", nomb=");
		sb.append(nomb);
		sb.append(", ape=");
		sb.append(ape);
		sb.append(", tipo_doc=");
		sb.append(tipo_doc);
		sb.append(", despachofk=");
		sb.append(despachofk);
		sb.append(", cargofk=");
		sb.append(cargofk);
		sb.append("}");

		return sb.toString();
	}

	public usuario toEntityModel() {
		usuarioImpl usuarioImpl = new usuarioImpl();

		if (id == null) {
			usuarioImpl.setId(StringPool.BLANK);
		}
		else {
			usuarioImpl.setId(id);
		}

		if (nomb == null) {
			usuarioImpl.setNomb(StringPool.BLANK);
		}
		else {
			usuarioImpl.setNomb(nomb);
		}

		if (ape == null) {
			usuarioImpl.setApe(StringPool.BLANK);
		}
		else {
			usuarioImpl.setApe(ape);
		}

		usuarioImpl.setTipo_doc(tipo_doc);

		if (despachofk == null) {
			usuarioImpl.setDespachofk(StringPool.BLANK);
		}
		else {
			usuarioImpl.setDespachofk(despachofk);
		}

		usuarioImpl.setCargofk(cargofk);

		usuarioImpl.resetOriginalValues();

		return usuarioImpl;
	}

	public String id;
	public String nomb;
	public String ape;
	public long tipo_doc;
	public String despachofk;
	public long cargofk;
}