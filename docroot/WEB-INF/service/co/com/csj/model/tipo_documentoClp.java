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

import co.com.csj.service.tipo_documentoLocalServiceUtil;

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
public class tipo_documentoClp extends BaseModelImpl<tipo_documento>
	implements tipo_documento {
	public tipo_documentoClp() {
	}

	public Class<?> getModelClass() {
		return tipo_documento.class;
	}

	public String getModelClassName() {
		return tipo_documento.class.getName();
	}

	public long getPrimaryKey() {
		return __id;
	}

	public void setPrimaryKey(long primaryKey) {
		set_id(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(__id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("_id", get_id());
		attributes.put("desc", getDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long _id = (Long)attributes.get("_id");

		if (_id != null) {
			set_id(_id);
		}

		String desc = (String)attributes.get("desc");

		if (desc != null) {
			setDesc(desc);
		}
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

	public BaseModel<?> gettipo_documentoRemoteModel() {
		return _tipo_documentoRemoteModel;
	}

	public void settipo_documentoRemoteModel(
		BaseModel<?> tipo_documentoRemoteModel) {
		_tipo_documentoRemoteModel = tipo_documentoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			tipo_documentoLocalServiceUtil.addtipo_documento(this);
		}
		else {
			tipo_documentoLocalServiceUtil.updatetipo_documento(this);
		}
	}

	@Override
	public tipo_documento toEscapedModel() {
		return (tipo_documento)Proxy.newProxyInstance(tipo_documento.class.getClassLoader(),
			new Class[] { tipo_documento.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		tipo_documentoClp clone = new tipo_documentoClp();

		clone.set_id(get_id());
		clone.setDesc(getDesc());

		return clone;
	}

	public int compareTo(tipo_documento tipo_documento) {
		long primaryKey = tipo_documento.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		tipo_documentoClp tipo_documento = null;

		try {
			tipo_documento = (tipo_documentoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = tipo_documento.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{_id=");
		sb.append(get_id());
		sb.append(", desc=");
		sb.append(getDesc());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("co.com.csj.model.tipo_documento");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>_id</column-name><column-value><![CDATA[");
		sb.append(get_id());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>desc</column-name><column-value><![CDATA[");
		sb.append(getDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long __id;
	private String _desc;
	private BaseModel<?> _tipo_documentoRemoteModel;
}