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

import co.com.csj.service.alertaLocalServiceUtil;

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
public class alertaClp extends BaseModelImpl<alerta> implements alerta {
	public alertaClp() {
	}

	public Class<?> getModelClass() {
		return alerta.class;
	}

	public String getModelClassName() {
		return alerta.class.getName();
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
		attributes.put("asunto", getAsunto());
		attributes.put("mensaje", getMensaje());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String asunto = (String)attributes.get("asunto");

		if (asunto != null) {
			setAsunto(asunto);
		}

		String mensaje = (String)attributes.get("mensaje");

		if (mensaje != null) {
			setMensaje(mensaje);
		}
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

	public BaseModel<?> getalertaRemoteModel() {
		return _alertaRemoteModel;
	}

	public void setalertaRemoteModel(BaseModel<?> alertaRemoteModel) {
		_alertaRemoteModel = alertaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			alertaLocalServiceUtil.addalerta(this);
		}
		else {
			alertaLocalServiceUtil.updatealerta(this);
		}
	}

	@Override
	public alerta toEscapedModel() {
		return (alerta)Proxy.newProxyInstance(alerta.class.getClassLoader(),
			new Class[] { alerta.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		alertaClp clone = new alertaClp();

		clone.setId(getId());
		clone.setAsunto(getAsunto());
		clone.setMensaje(getMensaje());

		return clone;
	}

	public int compareTo(alerta alerta) {
		String primaryKey = alerta.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		alertaClp alerta = null;

		try {
			alerta = (alertaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = alerta.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", asunto=");
		sb.append(getAsunto());
		sb.append(", mensaje=");
		sb.append(getMensaje());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("co.com.csj.model.alerta");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>asunto</column-name><column-value><![CDATA[");
		sb.append(getAsunto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mensaje</column-name><column-value><![CDATA[");
		sb.append(getMensaje());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _id;
	private String _asunto;
	private String _mensaje;
	private BaseModel<?> _alertaRemoteModel;
}