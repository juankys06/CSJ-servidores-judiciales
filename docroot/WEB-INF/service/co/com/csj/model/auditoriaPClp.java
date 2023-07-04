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

import co.com.csj.service.auditoriaPLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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
public class auditoriaPClp extends BaseModelImpl<auditoriaP>
	implements auditoriaP {
	public auditoriaPClp() {
	}

	public Class<?> getModelClass() {
		return auditoriaP.class;
	}

	public String getModelClassName() {
		return auditoriaP.class.getName();
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
		return _id_recurso_modificado;
	}

	public void setId_recurso_modificado(String id_recurso_modificado) {
		_id_recurso_modificado = id_recurso_modificado;
	}

	public String getTipo_operacion() {
		return _tipo_operacion;
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
		return _correo;
	}

	public void setCorreo(String correo) {
		_correo = correo;
	}

	public String getUsuario_modifico() {
		return _usuario_modifico;
	}

	public void setUsuario_modifico(String usuario_modifico) {
		_usuario_modifico = usuario_modifico;
	}

	public String getModificacion() {
		return _modificacion;
	}

	public void setModificacion(String modificacion) {
		_modificacion = modificacion;
	}

	public BaseModel<?> getauditoriaPRemoteModel() {
		return _auditoriaPRemoteModel;
	}

	public void setauditoriaPRemoteModel(BaseModel<?> auditoriaPRemoteModel) {
		_auditoriaPRemoteModel = auditoriaPRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			auditoriaPLocalServiceUtil.addauditoriaP(this);
		}
		else {
			auditoriaPLocalServiceUtil.updateauditoriaP(this);
		}
	}

	@Override
	public auditoriaP toEscapedModel() {
		return (auditoriaP)Proxy.newProxyInstance(auditoriaP.class.getClassLoader(),
			new Class[] { auditoriaP.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		auditoriaPClp clone = new auditoriaPClp();

		clone.setId(getId());
		clone.setTipo_recurso(getTipo_recurso());
		clone.setId_recurso_modificado(getId_recurso_modificado());
		clone.setTipo_operacion(getTipo_operacion());
		clone.setFecha(getFecha());
		clone.setCorreo(getCorreo());
		clone.setUsuario_modifico(getUsuario_modifico());
		clone.setModificacion(getModificacion());

		return clone;
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

		auditoriaPClp auditoriaP = null;

		try {
			auditoriaP = (auditoriaPClp)obj;
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

	private long _id;
	private int _tipo_recurso;
	private String _id_recurso_modificado;
	private String _tipo_operacion;
	private Date _fecha;
	private String _correo;
	private String _usuario_modifico;
	private String _modificacion;
	private BaseModel<?> _auditoriaPRemoteModel;
}