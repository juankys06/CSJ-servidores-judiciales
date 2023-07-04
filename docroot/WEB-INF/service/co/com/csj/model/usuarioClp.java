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

import co.com.csj.service.usuarioLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author villartech
 */
public class usuarioClp extends BaseModelImpl<usuario> implements usuario {
	public usuarioClp() {
	}

	public Class<?> getModelClass() {
		return usuario.class;
	}

	public String getModelClassName() {
		return usuario.class.getName();
	}

	public String getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(String primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nomb", getNomb());
		attributes.put("ape", getApe());
		attributes.put("tipo_doc", getTipo_doc());
		attributes.put("despachofk", getDespachofk());
		attributes.put("cargofk", getCargofk());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nomb = (String)attributes.get("nomb");

		if (nomb != null) {
			setNomb(nomb);
		}

		String ape = (String)attributes.get("ape");

		if (ape != null) {
			setApe(ape);
		}

		Long tipo_doc = (Long)attributes.get("tipo_doc");

		if (tipo_doc != null) {
			setTipo_doc(tipo_doc);
		}

		String despachofk = (String)attributes.get("despachofk");

		if (despachofk != null) {
			setDespachofk(despachofk);
		}

		Long cargofk = (Long)attributes.get("cargofk");

		if (cargofk != null) {
			setCargofk(cargofk);
		}
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

	public BaseModel<?> getusuarioRemoteModel() {
		return _usuarioRemoteModel;
	}

	public void setusuarioRemoteModel(BaseModel<?> usuarioRemoteModel) {
		_usuarioRemoteModel = usuarioRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			usuarioLocalServiceUtil.addusuario(this);
		}
		else {
			usuarioLocalServiceUtil.updateusuario(this);
		}
	}

	@Override
	public usuario toEscapedModel() {
		return (usuario)Proxy.newProxyInstance(usuario.class.getClassLoader(),
			new Class[] { usuario.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		usuarioClp clone = new usuarioClp();

		clone.setId(getId());
		clone.setNomb(getNomb());
		clone.setApe(getApe());
		clone.setTipo_doc(getTipo_doc());
		clone.setDespachofk(getDespachofk());
		clone.setCargofk(getCargofk());

		return clone;
	}

	public int compareTo(usuario usuario) {
		String primaryKey = usuario.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		usuarioClp usuario = null;

		try {
			usuario = (usuarioClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = usuario.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", nomb=");
		sb.append(getNomb());
		sb.append(", ape=");
		sb.append(getApe());
		sb.append(", tipo_doc=");
		sb.append(getTipo_doc());
		sb.append(", despachofk=");
		sb.append(getDespachofk());
		sb.append(", cargofk=");
		sb.append(getCargofk());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("co.com.csj.model.usuario");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomb</column-name><column-value><![CDATA[");
		sb.append(getNomb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ape</column-name><column-value><![CDATA[");
		sb.append(getApe());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipo_doc</column-name><column-value><![CDATA[");
		sb.append(getTipo_doc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>despachofk</column-name><column-value><![CDATA[");
		sb.append(getDespachofk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargofk</column-name><column-value><![CDATA[");
		sb.append(getCargofk());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _id;
	private String _nomb;
	private String _ape;
	private long _tipo_doc;
	private String _despachofk;
	private long _cargofk;
	private BaseModel<?> _usuarioRemoteModel;
}