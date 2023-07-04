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
public class cargoSoap implements Serializable {
	public static cargoSoap toSoapModel(cargo model) {
		cargoSoap soapModel = new cargoSoap();

		soapModel.set_id(model.get_id());
		soapModel.setDesc(model.getDesc());

		return soapModel;
	}

	public static cargoSoap[] toSoapModels(cargo[] models) {
		cargoSoap[] soapModels = new cargoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static cargoSoap[][] toSoapModels(cargo[][] models) {
		cargoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new cargoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new cargoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static cargoSoap[] toSoapModels(List<cargo> models) {
		List<cargoSoap> soapModels = new ArrayList<cargoSoap>(models.size());

		for (cargo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new cargoSoap[soapModels.size()]);
	}

	public cargoSoap() {
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