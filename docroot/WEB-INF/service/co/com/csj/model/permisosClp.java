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

import co.com.csj.service.permisosLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author villartech
 */
public class permisosClp extends BaseModelImpl<permisos> implements permisos {
	public permisosClp() {
	}

	public Class<?> getModelClass() {
		return permisos.class;
	}

	public String getModelClassName() {
		return permisos.class.getName();
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
		attributes.put("cargo", getCargo());
		attributes.put("d_m", getD_m());
		attributes.put("usuario", getUsuario());
		attributes.put("creacion", getCreacion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String cargo = (String)attributes.get("cargo");

		if (cargo != null) {
			setCargo(cargo);
		}

		String d_m = (String)attributes.get("d_m");

		if (d_m != null) {
			setD_m(d_m);
		}

		String usuario = (String)attributes.get("usuario");

		if (usuario != null) {
			setUsuario(usuario);
		}

		Date creacion = (Date)attributes.get("creacion");

		if (creacion != null) {
			setCreacion(creacion);
		}
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getCargo() {
		return _cargo;
	}

	public void setCargo(String cargo) {
		_cargo = cargo;
	}

	public String getD_m() {
		return _d_m;
	}

	public void setD_m(String d_m) {
		_d_m = d_m;
	}

	public String getUsuario() {
		return _usuario;
	}

	public void setUsuario(String usuario) {
		_usuario = usuario;
	}

	public Date getCreacion() {
		return _creacion;
	}

	public void setCreacion(Date creacion) {
		_creacion = creacion;
	}

	public BaseModel<?> getpermisosRemoteModel() {
		return _permisosRemoteModel;
	}

	public void setpermisosRemoteModel(BaseModel<?> permisosRemoteModel) {
		_permisosRemoteModel = permisosRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			permisosLocalServiceUtil.addpermisos(this);
		}
		else {
			permisosLocalServiceUtil.updatepermisos(this);
		}
	}

	@Override
	public permisos toEscapedModel() {
		return (permisos)Proxy.newProxyInstance(permisos.class.getClassLoader(),
			new Class[] { permisos.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		permisosClp clone = new permisosClp();

		clone.setId(getId());
		clone.setCargo(getCargo());
		clone.setD_m(getD_m());
		clone.setUsuario(getUsuario());
		clone.setCreacion(getCreacion());

		return clone;
	}

	public int compareTo(permisos permisos) {
		long primaryKey = permisos.getPrimaryKey();

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

		permisosClp permisos = null;

		try {
			permisos = (permisosClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = permisos.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", cargo=");
		sb.append(getCargo());
		sb.append(", d_m=");
		sb.append(getD_m());
		sb.append(", usuario=");
		sb.append(getUsuario());
		sb.append(", creacion=");
		sb.append(getCreacion());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("co.com.csj.model.permisos");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargo</column-name><column-value><![CDATA[");
		sb.append(getCargo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>d_m</column-name><column-value><![CDATA[");
		sb.append(getD_m());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>usuario</column-name><column-value><![CDATA[");
		sb.append(getUsuario());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creacion</column-name><column-value><![CDATA[");
		sb.append(getCreacion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _cargo;
	private String _d_m;
	private String _usuario;
	private Date _creacion;
	private BaseModel<?> _permisosRemoteModel;
}