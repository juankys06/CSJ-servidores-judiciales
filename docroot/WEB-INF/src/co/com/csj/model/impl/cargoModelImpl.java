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

package co.com.csj.model.impl;

import co.com.csj.model.cargo;
import co.com.csj.model.cargoModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the cargo service. Represents a row in the &quot;SJ_cargo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link co.com.csj.model.cargoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link cargoImpl}.
 * </p>
 *
 * @author villartech
 * @see cargoImpl
 * @see co.com.csj.model.cargo
 * @see co.com.csj.model.cargoModel
 * @generated
 */
public class cargoModelImpl extends BaseModelImpl<cargo> implements cargoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cargo model instance should use the {@link co.com.csj.model.cargo} interface instead.
	 */
	public static final String TABLE_NAME = "SJ_cargo";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "descripcion", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SJ_cargo (id LONG not null primary key,descripcion VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table SJ_cargo";
	public static final String ORDER_BY_JPQL = " ORDER BY cargo.desc ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SJ_cargo.descripcion ASC";
	public static final String DATA_SOURCE = "base_despachos";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.co.com.csj.model.cargo"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.co.com.csj.model.cargo"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.co.com.csj.model.cargo"));

	public cargoModelImpl() {
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

	public Class<?> getModelClass() {
		return cargo.class;
	}

	public String getModelClassName() {
		return cargo.class.getName();
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
		if (_desc == null) {
			return StringPool.BLANK;
		}
		else {
			return _desc;
		}
	}

	public void setDesc(String desc) {
		_desc = desc;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			cargo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public cargo toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (cargo)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		cargoImpl cargoImpl = new cargoImpl();

		cargoImpl.set_id(get_id());
		cargoImpl.setDesc(getDesc());

		cargoImpl.resetOriginalValues();

		return cargoImpl;
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

		cargo cargo = null;

		try {
			cargo = (cargo)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<cargo> toCacheModel() {
		cargoCacheModel cargoCacheModel = new cargoCacheModel();

		cargoCacheModel._id = get_id();

		cargoCacheModel.desc = getDesc();

		String desc = cargoCacheModel.desc;

		if ((desc != null) && (desc.length() == 0)) {
			cargoCacheModel.desc = null;
		}

		return cargoCacheModel;
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

	private static ClassLoader _classLoader = cargo.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			cargo.class
		};
	private long __id;
	private String _desc;
	private cargo _escapedModelProxy;
}