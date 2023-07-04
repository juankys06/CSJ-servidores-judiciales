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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link co.com.csj.service.http.InstitucionServiceSoap}.
 *
 * @author    villartech
 * @see       co.com.csj.service.http.InstitucionServiceSoap
 * @generated
 */
public class InstitucionSoap implements Serializable {
	public static InstitucionSoap toSoapModel(Institucion model) {
		InstitucionSoap soapModel = new InstitucionSoap();

		soapModel.setId(model.getId());
		soapModel.setDescripcion(model.getDescripcion());

		return soapModel;
	}

	public static InstitucionSoap[] toSoapModels(Institucion[] models) {
		InstitucionSoap[] soapModels = new InstitucionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InstitucionSoap[][] toSoapModels(Institucion[][] models) {
		InstitucionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InstitucionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InstitucionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InstitucionSoap[] toSoapModels(List<Institucion> models) {
		List<InstitucionSoap> soapModels = new ArrayList<InstitucionSoap>(models.size());

		for (Institucion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InstitucionSoap[soapModels.size()]);
	}

	public InstitucionSoap() {
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

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}

	private long _id;
	private String _descripcion;
}