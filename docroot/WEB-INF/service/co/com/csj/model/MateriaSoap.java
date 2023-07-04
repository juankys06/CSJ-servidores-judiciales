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
 * This class is used by SOAP remote services, specifically {@link co.com.csj.service.http.MateriaServiceSoap}.
 *
 * @author    villartech
 * @see       co.com.csj.service.http.MateriaServiceSoap
 * @generated
 */
public class MateriaSoap implements Serializable {
	public static MateriaSoap toSoapModel(Materia model) {
		MateriaSoap soapModel = new MateriaSoap();

		soapModel.setId(model.getId());
		soapModel.setNombre(model.getNombre());

		return soapModel;
	}

	public static MateriaSoap[] toSoapModels(Materia[] models) {
		MateriaSoap[] soapModels = new MateriaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MateriaSoap[][] toSoapModels(Materia[][] models) {
		MateriaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MateriaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MateriaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MateriaSoap[] toSoapModels(List<Materia> models) {
		List<MateriaSoap> soapModels = new ArrayList<MateriaSoap>(models.size());

		for (Materia model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MateriaSoap[soapModels.size()]);
	}

	public MateriaSoap() {
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String pk) {
		setId(pk);
	}

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		_id = id;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	private String _id;
	private String _nombre;
}