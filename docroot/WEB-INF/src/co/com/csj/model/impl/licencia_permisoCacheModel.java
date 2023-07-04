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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing licencia_permiso in entity cache.
 *
 * @author villartech
 * @see licencia_permiso
 * @generated
 */
public class licencia_permisoCacheModel implements CacheModel<licencia_permiso>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(id);
		sb.append(", fechainicio=");
		sb.append(fechainicio);
		sb.append(", fechafin=");
		sb.append(fechafin);
		sb.append(", usuariofk=");
		sb.append(usuariofk);
		sb.append(", tipofk=");
		sb.append(tipofk);
		sb.append(", actoadmin=");
		sb.append(actoadmin);
		sb.append(", creadoPor=");
		sb.append(creadoPor);
		sb.append(", modificadoPor=");
		sb.append(modificadoPor);
		sb.append(", estatus=");
		sb.append(estatus);
		sb.append(", despacho=");
		sb.append(despacho);
		sb.append(", cargo=");
		sb.append(cargo);
		sb.append(", horas=");
		sb.append(horas);
		sb.append(", minutos=");
		sb.append(minutos);
		sb.append(", fechaRegistro=");
		sb.append(fechaRegistro);
		sb.append("}");

		return sb.toString();
	}

	public licencia_permiso toEntityModel() {
		licencia_permisoImpl licencia_permisoImpl = new licencia_permisoImpl();

		licencia_permisoImpl.setId(id);

		if (fechainicio == Long.MIN_VALUE) {
			licencia_permisoImpl.setFechainicio(null);
		}
		else {
			licencia_permisoImpl.setFechainicio(new Date(fechainicio));
		}

		if (fechafin == Long.MIN_VALUE) {
			licencia_permisoImpl.setFechafin(null);
		}
		else {
			licencia_permisoImpl.setFechafin(new Date(fechafin));
		}

		if (usuariofk == null) {
			licencia_permisoImpl.setUsuariofk(StringPool.BLANK);
		}
		else {
			licencia_permisoImpl.setUsuariofk(usuariofk);
		}

		licencia_permisoImpl.setTipofk(tipofk);

		if (actoadmin == null) {
			licencia_permisoImpl.setActoadmin(StringPool.BLANK);
		}
		else {
			licencia_permisoImpl.setActoadmin(actoadmin);
		}

		licencia_permisoImpl.setCreadoPor(creadoPor);
		licencia_permisoImpl.setModificadoPor(modificadoPor);
		licencia_permisoImpl.setEstatus(estatus);

		if (despacho == null) {
			licencia_permisoImpl.setDespacho(StringPool.BLANK);
		}
		else {
			licencia_permisoImpl.setDespacho(despacho);
		}

		licencia_permisoImpl.setCargo(cargo);
		licencia_permisoImpl.setHoras(horas);
		licencia_permisoImpl.setMinutos(minutos);

		if (fechaRegistro == Long.MIN_VALUE) {
			licencia_permisoImpl.setFechaRegistro(null);
		}
		else {
			licencia_permisoImpl.setFechaRegistro(new Date(fechaRegistro));
		}

		licencia_permisoImpl.resetOriginalValues();

		return licencia_permisoImpl;
	}

	public long id;
	public long fechainicio;
	public long fechafin;
	public String usuariofk;
	public long tipofk;
	public String actoadmin;
	public long creadoPor;
	public long modificadoPor;
	public int estatus;
	public String despacho;
	public int cargo;
	public int horas;
	public int minutos;
	public long fechaRegistro;
}