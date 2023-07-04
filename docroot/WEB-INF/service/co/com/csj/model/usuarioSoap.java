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
public class usuarioSoap implements Serializable {
	public static usuarioSoap toSoapModel(usuario model) {
		usuarioSoap soapModel = new usuarioSoap();

		soapModel.setId(model.getId());
		soapModel.setNomb(model.getNomb());
		soapModel.setApe(model.getApe());
		soapModel.setTipo_doc(model.getTipo_doc());
		soapModel.setDespachofk(model.getDespachofk());
		soapModel.setCargofk(model.getCargofk());

		return soapModel;
	}

	public static usuarioSoap[] toSoapModels(usuario[] models) {
		usuarioSoap[] soapModels = new usuarioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static usuarioSoap[][] toSoapModels(usuario[][] models) {
		usuarioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new usuarioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new usuarioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static usuarioSoap[] toSoapModels(List<usuario> models) {
		List<usuarioSoap> soapModels = new ArrayList<usuarioSoap>(models.size());

		for (usuario model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new usuarioSoap[soapModels.size()]);
	}

	public usuarioSoap() {
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

	public String getNomb() {
		return _nomb;
	}

	public void setNomb(String nomb) {
		_nomb = nomb;
	}

	public String getApe() {
		return _ape;
	}

	public void setApe(String ape) {
		_ape = ape;
	}

	public long getTipo_doc() {
		return _tipo_doc;
	}

	public void setTipo_doc(long tipo_doc) {
		_tipo_doc = tipo_doc;
	}

	public String getDespachofk() {
		return _despachofk;
	}

	public void setDespachofk(String despachofk) {
		_despachofk = despachofk;
	}

	public long getCargofk() {
		return _cargofk;
	}

	public void setCargofk(long cargofk) {
		_cargofk = cargofk;
	}

	private String _id;
	private String _nomb;
	private String _ape;
	private long _tipo_doc;
	private String _despachofk;
	private long _cargofk;
}