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

import co.com.csj.service.cargoLocalServiceUtil;

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
public class cargoClp extends BaseModelImpl<cargo> implements cargo {
	public cargoClp() {
	}

	public Class<?> getModelClass() {
		return cargo.class;
	}

	public String getModelClassName() {
		return cargo.class.getName();
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

	public BaseModel<?> getcargoRemoteModel() {
		return _cargoRemoteModel;
	}

	public void setcargoRemoteModel(BaseModel<?> cargoRemoteModel) {
		_cargoRemoteModel = cargoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			cargoLocalServiceUtil.addcargo(this);
		}
		else {
			cargoLocalServiceUtil.updatecargo(this);
		}
	}

	@Override
	public cargo toEscapedModel() {
		return (cargo)Proxy.newProxyInstance(cargo.class.getClassLoader(),
			new Class[] { cargo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		cargoClp clone = new cargoClp();

		clone.set_id(get_id());
		clone.setDesc(getDesc());

		return clone;
	}

	public int compareTo(cargo cargo) {
		int value = 0;

		value = getDesc().compareTo(cargo.getDesc());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		cargoClp cargo = null;

		try {
			cargo = (cargoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = cargo.getPrimaryKey();

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
		sb.append("co.com.csj.model.cargo");
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
	private BaseModel<?> _cargoRemoteModel;
}