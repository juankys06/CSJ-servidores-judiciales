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
public class permisosSoap implements Serializable {
	public static permisosSoap toSoapModel(permisos model) {
		permisosSoap soapModel = new permisosSoap();

		soapModel.setId(model.getId());
		soapModel.setCargo(model.getCargo());
		soapModel.setD_m(model.getD_m());
		soapModel.setUsuario(model.getUsuario());
		soapModel.setCreacion(model.getCreacion());

		return soapModel;
	}

	public static permisosSoap[] toSoapModels(permisos[] models) {
		permisosSoap[] soapModels = new permisosSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static permisosSoap[][] toSoapModels(permisos[][] models) {
		permisosSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new permisosSoap[models.length][models[0].length];
		}
		else {
			soapModels = new permisosSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static permisosSoap[] toSoapModels(List<permisos> models) {
		List<permisosSoap> soapModels = new ArrayList<permisosSoap>(models.size());

		for (permisos model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new permisosSoap[soapModels.size()]);
	}

	public permisosSoap() {
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

	public String getCargo() {
		return _cargo;
	}

	public void setCargo(String cargo) {
		_cargo = cargo;
	}

	public String getD_m() {
		return _d_m;
	}

	public void setD_m(String d_m) {
		_d_m = d_m;
	}

	public String getUsuario() {
		return _usuario;
	}

	public void setUsuario(String usuario) {
		_usuario = usuario;
	}

	public Date getCreacion() {
		return _creacion;
	}

	public void setCreacion(Date creacion) {
		_creacion = creacion;
	}

	private long _id;
	private String _cargo;
	private String _d_m;
	private String _usuario;
	private Date _creacion;
}