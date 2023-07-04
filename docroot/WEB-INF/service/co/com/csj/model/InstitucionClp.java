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

import co.com.csj.service.InstitucionLocalServiceUtil;

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
public class InstitucionClp extends BaseModelImpl<Institucion>
	implements Institucion {
	public InstitucionClp() {
	}

	public Class<?> getModelClass() {
		return Institucion.class;
	}

	public String getModelClassName() {
		return Institucion.class.getName();
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_id);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("descripcion", getDescripcion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String descripcion = (String)attributes.get("descripcion");

		if (descripcion != null) {
			setDescripcion(descripcion);
		}
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

	public BaseModel<?> getInstitucionRemoteModel() {
		return _institucionRemoteModel;
	}

	public void setInstitucionRemoteModel(BaseModel<?> institucionRemoteModel) {
		_institucionRemoteModel = institucionRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			InstitucionLocalServiceUtil.addInstitucion(this);
		}
		else {
			InstitucionLocalServiceUtil.updateInstitucion(this);
		}
	}

	@Override
	public Institucion toEscapedModel() {
		return (Institucion)Proxy.newProxyInstance(Institucion.class.getClassLoader(),
			new Class[] { Institucion.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InstitucionClp clone = new InstitucionClp();

		clone.setId(getId());
		clone.setDescripcion(getDescripcion());

		return clone;
	}

	public int compareTo(Institucion institucion) {
		long primaryKey = institucion.getPrimaryKey();

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

		InstitucionClp institucion = null;

		try {
			institucion = (InstitucionClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = institucion.getPrimaryKey();

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

		sb.append("{id=");
		sb.append(getId());
		sb.append(", descripcion=");
		sb.append(getDescripcion());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("co.com.csj.model.Institucion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descripcion</column-name><column-value><![CDATA[");
		sb.append(getDescripcion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _descripcion;
	private BaseModel<?> _institucionRemoteModel;
}