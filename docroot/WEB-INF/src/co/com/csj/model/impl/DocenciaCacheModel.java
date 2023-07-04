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

import co.com.csj.model.Docencia;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Docencia in entity cache.
 *
 * @author villartech
 * @see Docencia
 * @generated
 */
public class DocenciaCacheModel implements CacheModel<Docencia>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(id);
		sb.append(", usuario_fk=");
		sb.append(usuario_fk);
		sb.append(", fechaInicial=");
		sb.append(fechaInicial);
		sb.append(", fechaFinal=");
		sb.append(fechaFinal);
		sb.append(", materia=");
		sb.append(materia);
		sb.append(", institucion=");
		sb.append(institucion);
		sb.append(", despacho=");
		sb.append(despacho);
		sb.append(", creadoPor=");
		sb.append(creadoPor);
		sb.append(", modificadoPor=");
		sb.append(modificadoPor);
		sb.append(", estatus=");
		sb.append(estatus);
		sb.append(", horas=");
		sb.append(horas);
		sb.append(", minutos=");
		sb.append(minutos);
		sb.append(", cargo=");
		sb.append(cargo);
		sb.append(", fechaRegistro=");
		sb.append(fechaRegistro);
		sb.append("}");

		return sb.toString();
	}

	public Docencia toEntityModel() {
		DocenciaImpl docenciaImpl = new DocenciaImpl();

		docenciaImpl.setId(id);

		if (usuario_fk == null) {
			docenciaImpl.setUsuario_fk(StringPool.BLANK);
		}
		else {
			docenciaImpl.setUsuario_fk(usuario_fk);
		}

		if (fechaInicial == Long.MIN_VALUE) {
			docenciaImpl.setFechaInicial(null);
		}
		else {
			docenciaImpl.setFechaInicial(new Date(fechaInicial));
		}

		if (fechaFinal == Long.MIN_VALUE) {
			docenciaImpl.setFechaFinal(null);
		}
		else {
			docenciaImpl.setFechaFinal(new Date(fechaFinal));
		}

		if (materia == null) {
			docenciaImpl.setMateria(StringPool.BLANK);
		}
		else {
			docenciaImpl.setMateria(materia);
		}

		if (institucion == null) {
			docenciaImpl.setInstitucion(StringPool.BLANK);
		}
		else {
			docenciaImpl.setInstitucion(institucion);
		}

		if (despacho == null) {
			docenciaImpl.setDespacho(StringPool.BLANK);
		}
		else {
			docenciaImpl.setDespacho(despacho);
		}

		docenciaImpl.setCreadoPor(creadoPor);
		docenciaImpl.setModificadoPor(modificadoPor);
		docenciaImpl.setEstatus(estatus);
		docenciaImpl.setHoras(horas);
		docenciaImpl.setMinutos(minutos);
		docenciaImpl.setCargo(cargo);

		if (fechaRegistro == Long.MIN_VALUE) {
			docenciaImpl.setFechaRegistro(null);
		}
		else {
			docenciaImpl.setFechaRegistro(new Date(fechaRegistro));
		}

		docenciaImpl.resetOriginalValues();

		return docenciaImpl;
	}

	public long id;
	public String usuario_fk;
	public long fechaInicial;
	public long fechaFinal;
	public String materia;
	public String institucion;
	public String despacho;
	public long creadoPor;
	public long modificadoPor;
	public int estatus;
	public int horas;
	public int minutos;
	public int cargo;
	public long fechaRegistro;
}