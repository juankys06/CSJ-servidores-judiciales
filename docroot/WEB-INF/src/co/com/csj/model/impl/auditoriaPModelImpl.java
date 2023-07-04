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

import co.com.csj.model.auditoriaP;
import co.com.csj.model.auditoriaPModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.DateUtil;
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the auditoriaP service. Represents a row in the &quot;SJ_log&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link co.com.csj.model.auditoriaPModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link auditoriaPImpl}.
 * </p>
 *
 * @author villartech
 * @see auditoriaPImpl
 * @see co.com.csj.model.auditoriaP
 * @see co.com.csj.model.auditoriaPModel
 * @generated
 */
public class auditoriaPModelImpl extends BaseModelImpl<auditoriaP>
	implements auditoriaPModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a auditoria p model instance should use the {@link co.com.csj.model.auditoriaP} interface instead.
	 */
	public static final String TABLE_NAME = "SJ_log";
	public static final Object[][] TABLE_COLUMNS = {
			{ "id", Types.BIGINT },
			{ "tipo_recurso", Types.INTEGER },
			{ "id_recurso_modificado", Types.VARCHAR },
			{ "tipo_operacion", Types.VARCHAR },
			{ "fecha", Types.TIMESTAMP },
			{ "correo_usuario_modifico", Types.VARCHAR },
			{ "usuario_modifico", Types.VARCHAR },
			{ "modificacion", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SJ_log (id LONG not null primary key IDENTITY,tipo_recurso INTEGER,id_recurso_modificado VARCHAR(75) null,tipo_operacion VARCHAR(75) null,fecha DATE null,correo_usuario_modifico VARCHAR(75) null,usuario_modifico VARCHAR(75) null,modificacion VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table SJ_log";
	public static final String ORDER_BY_JPQL = " ORDER BY auditoriaP.fecha DESC";
	public static final String ORDER_BY_SQL = " ORDER BY SJ_log.fecha DESC";
	public static final String DATA_SOURCE = "base_despachos";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.co.com.csj.model.auditoriaP"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.co.com.csj.model.auditoriaP"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.co.com.csj.model.auditoriaP"));

	public auditoriaPModelImpl() {
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

	public Class<?> getModelClass() {
		return auditoriaP.class;
	}

	public String getModelClassName() {
		return auditoriaP.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tipo_recurso", getTipo_recurso());
		attributes.put("id_recurso_modificado", getId_recurso_modificado());
		attributes.put("tipo_operacion", getTipo_operacion());
		attributes.put("fecha", getFecha());
		attributes.put("correo", getCorreo());
		attributes.put("usuario_modifico", getUsuario_modifico());
		attributes.put("modificacion", getModificacion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer tipo_recurso = (Integer)attributes.get("tipo_recurso");

		if (tipo_recurso != null) {
			setTipo_recurso(tipo_recurso);
		}

		String id_recurso_modificado = (String)attributes.get(
				"id_recurso_modificado");

		if (id_recurso_modificado != null) {
			setId_recurso_modificado(id_recurso_modificado);
		}

		String tipo_operacion = (String)attributes.get("tipo_operacion");

		if (tipo_operacion != null) {
			setTipo_operacion(tipo_operacion);
		}

		Date fecha = (Date)attributes.get("fecha");

		if (fecha != null) {
			setFecha(fecha);
		}

		String correo = (String)attributes.get("correo");

		if (correo != null) {
			setCorreo(correo);
		}

		String usuario_modifico = (String)attributes.get("usuario_modifico");

		if (usuario_modifico != null) {
			setUsuario_modifico(usuario_modifico);
		}

		String modificacion = (String)attributes.get("modificacion");

		if (modificacion != null) {
			setModificacion(modificacion);
		}
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public int getTipo_recurso() {
		return _tipo_recurso;
	}

	public void setTipo_recurso(int tipo_recurso) {
		_tipo_recurso = tipo_recurso;
	}

	public String getId_recurso_modificado() {
		if (_id_recurso_modificado == null) {
			return StringPool.BLANK;
		}
		else {
			return _id_recurso_modificado;
		}
	}

	public void setId_recurso_modificado(String id_recurso_modificado) {
		_id_recurso_modificado = id_recurso_modificado;
	}

	public String getTipo_operacion() {
		if (_tipo_operacion == null) {
			return StringPool.BLANK;
		}
		else {
			return _tipo_operacion;
		}
	}

	public void setTipo_operacion(String tipo_operacion) {
		_tipo_operacion = tipo_operacion;
	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public String getCorreo() {
		if (_correo == null) {
			return StringPool.BLANK;
		}
		else {
			return _correo;
		}
	}

	public void setCorreo(String correo) {
		_correo = correo;
	}

	public String getUsuario_modifico() {
		if (_usuario_modifico == null) {
			return StringPool.BLANK;
		}
		else {
			return _usuario_modifico;
		}
	}

	public void setUsuario_modifico(String usuario_modifico) {
		_usuario_modifico = usuario_modifico;
	}

	public String getModificacion() {
		if (_modificacion == null) {
			return StringPool.BLANK;
		}
		else {
			return _modificacion;
		}
	}

	public void setModificacion(String modificacion) {
		_modificacion = modificacion;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			auditoriaP.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public auditoriaP toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (auditoriaP)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		auditoriaPImpl auditoriaPImpl = new auditoriaPImpl();

		auditoriaPImpl.setId(getId());
		auditoriaPImpl.setTipo_recurso(getTipo_recurso());
		auditoriaPImpl.setId_recurso_modificado(getId_recurso_modificado());
		auditoriaPImpl.setTipo_operacion(getTipo_operacion());
		auditoriaPImpl.setFecha(getFecha());
		auditoriaPImpl.setCorreo(getCorreo());
		auditoriaPImpl.setUsuario_modifico(getUsuario_modifico());
		auditoriaPImpl.setModificacion(getModificacion());

		auditoriaPImpl.resetOriginalValues();

		return auditoriaPImpl;
	}

	public int compareTo(auditoriaP auditoriaP) {
		int value = 0;

		value = DateUtil.compareTo(getFecha(), auditoriaP.getFecha());

		value = value * -1;

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

		auditoriaP auditoriaP = null;

		try {
			auditoriaP = (auditoriaP)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = auditoriaP.getPrimaryKey();

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
	public CacheModel<auditoriaP> toCacheModel() {
		auditoriaPCacheModel auditoriaPCacheModel = new auditoriaPCacheModel();

		auditoriaPCacheModel.id = getId();

		auditoriaPCacheModel.tipo_recurso = getTipo_recurso();

		auditoriaPCacheModel.id_recurso_modificado = getId_recurso_modificado();

		String id_recurso_modificado = auditoriaPCacheModel.id_recurso_modificado;

		if ((id_recurso_modificado != null) &&
				(id_recurso_modificado.length() == 0)) {
			auditoriaPCacheModel.id_recurso_modificado = null;
		}

		auditoriaPCacheModel.tipo_operacion = getTipo_operacion();

		String tipo_operacion = auditoriaPCacheModel.tipo_operacion;

		if ((tipo_operacion != null) && (tipo_operacion.length() == 0)) {
			auditoriaPCacheModel.tipo_operacion = null;
		}

		Date fecha = getFecha();

		if (fecha != null) {
			auditoriaPCacheModel.fecha = fecha.getTime();
		}
		else {
			auditoriaPCacheModel.fecha = Long.MIN_VALUE;
		}

		auditoriaPCacheModel.correo = getCorreo();

		String correo = auditoriaPCacheModel.correo;

		if ((correo != null) && (correo.length() == 0)) {
			auditoriaPCacheModel.correo = null;
		}

		auditoriaPCacheModel.usuario_modifico = getUsuario_modifico();

		String usuario_modifico = auditoriaPCacheModel.usuario_modifico;

		if ((usuario_modifico != null) && (usuario_modifico.length() == 0)) {
			auditoriaPCacheModel.usuario_modifico = null;
		}

		auditoriaPCacheModel.modificacion = getModificacion();

		String modificacion = auditoriaPCacheModel.modificacion;

		if ((modificacion != null) && (modificacion.length() == 0)) {
			auditoriaPCacheModel.modificacion = null;
		}

		return auditoriaPCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", tipo_recurso=");
		sb.append(getTipo_recurso());
		sb.append(", id_recurso_modificado=");
		sb.append(getId_recurso_modificado());
		sb.append(", tipo_operacion=");
		sb.append(getTipo_operacion());
		sb.append(", fecha=");
		sb.append(getFecha());
		sb.append(", correo=");
		sb.append(getCorreo());
		sb.append(", usuario_modifico=");
		sb.append(getUsuario_modifico());
		sb.append(", modificacion=");
		sb.append(getModificacion());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("co.com.csj.model.auditoriaP");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipo_recurso</column-name><column-value><![CDATA[");
		sb.append(getTipo_recurso());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>id_recurso_modificado</column-name><column-value><![CDATA[");
		sb.append(getId_recurso_modificado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipo_operacion</column-name><column-value><![CDATA[");
		sb.append(getTipo_operacion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha</column-name><column-value><![CDATA[");
		sb.append(getFecha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>correo</column-name><column-value><![CDATA[");
		sb.append(getCorreo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>usuario_modifico</column-name><column-value><![CDATA[");
		sb.append(getUsuario_modifico());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modificacion</column-name><column-value><![CDATA[");
		sb.append(getModificacion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = auditoriaP.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			auditoriaP.class
		};
	private long _id;
	private int _tipo_recurso;
	private String _id_recurso_modificado;
	private String _tipo_operacion;
	private Date _fecha;
	private String _correo;
	private String _usuario_modifico;
	private String _modificacion;
	private auditoriaP _escapedModelProxy;
}