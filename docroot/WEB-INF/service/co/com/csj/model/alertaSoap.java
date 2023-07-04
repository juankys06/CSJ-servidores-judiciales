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
public class alertaSoap implements Serializable {
	public static alertaSoap toSoapModel(alerta model) {
		alertaSoap soapModel = new alertaSoap();

		soapModel.setId(model.getId());
		soapModel.setAsunto(model.getAsunto());
		soapModel.setMensaje(model.getMensaje());

		return soapModel;
	}

	public static alertaSoap[] toSoapModels(alerta[] models) {
		alertaSoap[] soapModels = new alertaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static alertaSoap[][] toSoapModels(alerta[][] models) {
		alertaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new alertaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new alertaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static alertaSoap[] toSoapModels(List<alerta> models) {
		List<alertaSoap> soapModels = new ArrayList<alertaSoap>(models.size());

		for (alerta model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new alertaSoap[soapModels.size()]);
	}

	public alertaSoap() {
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

	public String getAsunto() {
		return _asunto;
	}

	public void setAsunto(String asunto) {
		_asunto = asunto;
	}

	public String getMensaje() {
		return _mensaje;
	}

	public void setMensaje(String mensaje) {
		_mensaje = mensaje;
	}

	private String _id;
	private String _asunto;
	private String _mensaje;
}