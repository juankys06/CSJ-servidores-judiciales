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

import co.com.csj.model.alerta;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing alerta in entity cache.
 *
 * @author villartech
 * @see alerta
 * @generated
 */
public class alertaCacheModel implements CacheModel<alerta>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", asunto=");
		sb.append(asunto);
		sb.append(", mensaje=");
		sb.append(mensaje);
		sb.append("}");

		return sb.toString();
	}

	public alerta toEntityModel() {
		alertaImpl alertaImpl = new alertaImpl();

		if (id == null) {
			alertaImpl.setId(StringPool.BLANK);
		}
		else {
			alertaImpl.setId(id);
		}

		if (asunto == null) {
			alertaImpl.setAsunto(StringPool.BLANK);
		}
		else {
			alertaImpl.setAsunto(asunto);
		}

		if (mensaje == null) {
			alertaImpl.setMensaje(StringPool.BLANK);
		}
		else {
			alertaImpl.setMensaje(mensaje);
		}

		alertaImpl.resetOriginalValues();

		return alertaImpl;
	}

	public String id;
	public String asunto;
	public String mensaje;
}