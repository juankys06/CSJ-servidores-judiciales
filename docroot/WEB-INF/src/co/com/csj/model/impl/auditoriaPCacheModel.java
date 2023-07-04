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

import co.com.csj.model.auditoriaP;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing auditoriaP in entity cache.
 *
 * @author villartech
 * @see auditoriaP
 * @generated
 */
public class auditoriaPCacheModel implements CacheModel<auditoriaP>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tipo_recurso=");
		sb.append(tipo_recurso);
		sb.append(", id_recurso_modificado=");
		sb.append(id_recurso_modificado);
		sb.append(", tipo_operacion=");
		sb.append(tipo_operacion);
		sb.append(", fecha=");
		sb.append(fecha);
		sb.append(", correo=");
		sb.append(correo);
		sb.append(", usuario_modifico=");
		sb.append(usuario_modifico);
		sb.append(", modificacion=");
		sb.append(modificacion);
		sb.append("}");

		return sb.toString();
	}

	public auditoriaP toEntityModel() {
		auditoriaPImpl auditoriaPImpl = new auditoriaPImpl();

		auditoriaPImpl.setId(id);
		auditoriaPImpl.setTipo_recurso(tipo_recurso);

		if (id_recurso_modificado == null) {
			auditoriaPImpl.setId_recurso_modificado(StringPool.BLANK);
		}
		else {
			auditoriaPImpl.setId_recurso_modificado(id_recurso_modificado);
		}

		if (tipo_operacion == null) {
			auditoriaPImpl.setTipo_operacion(StringPool.BLANK);
		}
		else {
			auditoriaPImpl.setTipo_operacion(tipo_operacion);
		}

		if (fecha == Long.MIN_VALUE) {
			auditoriaPImpl.setFecha(null);
		}
		else {
			auditoriaPImpl.setFecha(new Date(fecha));
		}

		if (correo == null) {
			auditoriaPImpl.setCorreo(StringPool.BLANK);
		}
		else {
			auditoriaPImpl.setCorreo(correo);
		}

		if (usuario_modifico == null) {
			auditoriaPImpl.setUsuario_modifico(StringPool.BLANK);
		}
		else {
			auditoriaPImpl.setUsuario_modifico(usuario_modifico);
		}

		if (modificacion == null) {
			auditoriaPImpl.setModificacion(StringPool.BLANK);
		}
		else {
			auditoriaPImpl.setModificacion(modificacion);
		}

		auditoriaPImpl.resetOriginalValues();

		return auditoriaPImpl;
	}

	public long id;
	public int tipo_recurso;
	public String id_recurso_modificado;
	public String tipo_operacion;
	public long fecha;
	public String correo;
	public String usuario_modifico;
	public String modificacion;
}