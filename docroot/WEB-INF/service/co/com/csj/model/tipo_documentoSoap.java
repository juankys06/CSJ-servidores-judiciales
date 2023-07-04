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
public class tipo_documentoSoap implements Serializable {
	public static tipo_documentoSoap toSoapModel(tipo_documento model) {
		tipo_documentoSoap soapModel = new tipo_documentoSoap();

		soapModel.set_id(model.get_id());
		soapModel.setDesc(model.getDesc());

		return soapModel;
	}

	public static tipo_documentoSoap[] toSoapModels(tipo_documento[] models) {
		tipo_documentoSoap[] soapModels = new tipo_documentoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static tipo_documentoSoap[][] toSoapModels(tipo_documento[][] models) {
		tipo_documentoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new tipo_documentoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new tipo_documentoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static tipo_documentoSoap[] toSoapModels(List<tipo_documento> models) {
		List<tipo_documentoSoap> soapModels = new ArrayList<tipo_documentoSoap>(models.size());

		for (tipo_documento model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new tipo_documentoSoap[soapModels.size()]);
	}

	public tipo_documentoSoap() {
	}

	public long getPrimaryKey() {
		return __id;
	}

	public void setPrimaryKey(long pk) {
		set_id(pk);
	}

	public long get_id() {
		return __id;
	}

	public void set_id(long _id) {
		__id = _id;
	}

	public String getDesc() {
		return _desc;
	}

	public void setDesc(String desc) {
		_desc = desc;
	}

	private long __id;
	private String _desc;
}