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
 * This class is used by SOAP remote services.
 *
 * @author    villartech
 * @generated
 */
public class tipoSoap implements Serializable {
	public static tipoSoap toSoapModel(tipo model) {
		tipoSoap soapModel = new tipoSoap();

		soapModel.setId(model.getId());
		soapModel.setDescripcion(model.getDescripcion());

		return soapModel;
	}

	public static tipoSoap[] toSoapModels(tipo[] models) {
		tipoSoap[] soapModels = new tipoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static tipoSoap[][] toSoapModels(tipo[][] models) {
		tipoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new tipoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new tipoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static tipoSoap[] toSoapModels(List<tipo> models) {
		List<tipoSoap> soapModels = new ArrayList<tipoSoap>(models.size());

		for (tipo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new tipoSoap[soapModels.size()]);
	}

	public tipoSoap() {
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