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

import co.com.csj.model.tipo_documento;
import co.com.csj.model.tipo_documentoModel;

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
 * The base model implementation for the tipo_documento service. Represents a row in the &quot;SJ_tipo_documento&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link co.com.csj.model.tipo_documentoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link tipo_documentoImpl}.
 * </p>
 *
 * @author villartech
 * @see tipo_documentoImpl
 * @see co.com.csj.model.tipo_documento
 * @see co.com.csj.model.tipo_documentoModel
 * @generated
 */
public class tipo_documentoModelImpl extends BaseModelImpl<tipo_documento>
	implements tipo_documentoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tipo_documento model instance should use the {@link co.com.csj.model.tipo_documento} interface instead.
	 */
	public static final String TABLE_NAME = "SJ_tipo_documento";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "descripcion", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SJ_tipo_documento (id LONG not null primary key,descripcion VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table SJ_tipo_documento";
	public static final String DATA_SOURCE = "base_despachos";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.co.com.csj.model.tipo_documento"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.co.com.csj.model.tipo_documento"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.co.com.csj.model.tipo_documento"));

	public tipo_documentoModelImpl() {
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
		return tipo_documento.class;
	}

	public String getModelClassName() {
		return tipo_documento.class.getName();
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
			tipo_documento.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public tipo_documento toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (tipo_documento)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		tipo_documentoImpl tipo_documentoImpl = new tipo_documentoImpl();

		tipo_documentoImpl.set_id(get_id());
		tipo_documentoImpl.setDesc(getDesc());

		tipo_documentoImpl.resetOriginalValues();

		return tipo_documentoImpl;
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

		tipo_documento tipo_documento = null;

		try {
			tipo_documento = (tipo_documento)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<tipo_documento> toCacheModel() {
		tipo_documentoCacheModel tipo_documentoCacheModel = new tipo_documentoCacheModel();

		tipo_documentoCacheModel._id = get_id();

		tipo_documentoCacheModel.desc = getDesc();

		String desc = tipo_documentoCacheModel.desc;

		if ((desc != null) && (desc.length() == 0)) {
			tipo_documentoCacheModel.desc = null;
		}

		return tipo_documentoCacheModel;
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

	private static ClassLoader _classLoader = tipo_documento.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			tipo_documento.class
		};
	private long __id;
	private String _desc;
	private tipo_documento _escapedModelProxy;
}