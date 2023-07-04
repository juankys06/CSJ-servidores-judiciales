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

import co.com.csj.service.MateriaLocalServiceUtil;

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
public class MateriaClp extends BaseModelImpl<Materia> implements Materia {
	public MateriaClp() {
	}

	public Class<?> getModelClass() {
		return Materia.class;
	}

	public String getModelClassName() {
		return Materia.class.getName();
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
		attributes.put("nombre", getNombre());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
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

	public BaseModel<?> getMateriaRemoteModel() {
		return _materiaRemoteModel;
	}

	public void setMateriaRemoteModel(BaseModel<?> materiaRemoteModel) {
		_materiaRemoteModel = materiaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			MateriaLocalServiceUtil.addMateria(this);
		}
		else {
			MateriaLocalServiceUtil.updateMateria(this);
		}
	}

	@Override
	public Materia toEscapedModel() {
		return (Materia)Proxy.newProxyInstance(Materia.class.getClassLoader(),
			new Class[] { Materia.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MateriaClp clone = new MateriaClp();

		clone.setId(getId());
		clone.setNombre(getNombre());

		return clone;
	}

	public int compareTo(Materia materia) {
		String primaryKey = materia.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		MateriaClp materia = null;

		try {
			materia = (MateriaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		String primaryKey = materia.getPrimaryKey();

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
		StringBundler sb = new StringBundler(5);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("co.com.csj.model.Materia");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _id;
	private String _nombre;
	private BaseModel<?> _materiaRemoteModel;
}