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

package co.com.csj.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    villartech
 * @generated
 */
public class auditoriaPSoap implements Serializable {
	public static auditoriaPSoap toSoapModel(auditoriaP model) {
		auditoriaPSoap soapModel = new auditoriaPSoap();

		soapModel.setId(model.getId());
		soapModel.setTipo_recurso(model.getTipo_recurso());
		soapModel.setId_recurso_modificado(model.getId_recurso_modificado());
		soapModel.setTipo_operacion(model.getTipo_operacion());
		soapModel.setFecha(model.getFecha());
		soapModel.setCorreo(model.getCorreo());
		soapModel.setUsuario_modifico(model.getUsuario_modifico());
		soapModel.setModificacion(model.getModificacion());

		return soapModel;
	}

	public static auditoriaPSoap[] toSoapModels(auditoriaP[] models) {
		auditoriaPSoap[] soapModels = new auditoriaPSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static auditoriaPSoap[][] toSoapModels(auditoriaP[][] models) {
		auditoriaPSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new auditoriaPSoap[models.length][models[0].length];
		}
		else {
			soapModels = new auditoriaPSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static auditoriaPSoap[] toSoapModels(List<auditoriaP> models) {
		List<auditoriaPSoap> soapModels = new ArrayList<auditoriaPSoap>(models.size());

		for (auditoriaP model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new auditoriaPSoap[soapModels.size()]);
	}

	public auditoriaPSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public int getTipo_recurso() {
		return _tipo_recurso;
	}

	public void setTipo_recurso(int tipo_recurso) {
		_tipo_recurso = tipo_recurso;
	}

	public String getId_recurso_modificado() {
		return _id_recurso_modificado;
	}

	public void setId_recurso_modificado(String id_recurso_modificado) {
		_id_recurso_modificado = id_recurso_modificado;
	}

	public String getTipo_operacion() {
		return _tipo_operacion;
	}

	public void setTipo_operacion(String tipo_operacion) {
		_tipo_operacion = tipo_operacion;
	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public String getCorreo() {
		return _correo;
	}

	public void setCorreo(String correo) {
		_correo = correo;
	}

	public String getUsuario_modifico() {
		return _usuario_modifico;
	}

	public void setUsuario_modifico(String usuario_modifico) {
		_usuario_modifico = usuario_modifico;
	}

	public String getModificacion() {
		return _modificacion;
	}

	public void setModificacion(String modificacion) {
		_modificacion = modificacion;
	}

	private long _id;
	private int _tipo_recurso;
	private String _id_recurso_modificado;
	private String _tipo_operacion;
	private Date _fecha;
	private String _correo;
	private String _usuario_modifico;
	private String _modificacion;
}