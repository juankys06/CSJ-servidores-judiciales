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

import co.com.csj.service.licencia_permisoLocalServiceUtil;

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
public class licencia_permisoClp extends BaseModelImpl<licencia_permiso>
	implements licencia_permiso {
	public licencia_permisoClp() {
	}

	public Class<?> getModelClass() {
		return licencia_permiso.class;
	}

	public String getModelClassName() {
		return licencia_permiso.class.getName();
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
		attributes.put("fechainicio", getFechainicio());
		attributes.put("fechafin", getFechafin());
		attributes.put("usuariofk", getUsuariofk());
		attributes.put("tipofk", getTipofk());
		attributes.put("actoadmin", getActoadmin());
		attributes.put("creadoPor", getCreadoPor());
		attributes.put("modificadoPor", getModificadoPor());
		attributes.put("estatus", getEstatus());
		attributes.put("despacho", getDespacho());
		attributes.put("cargo", getCargo());
		attributes.put("horas", getHoras());
		attributes.put("minutos", getMinutos());
		attributes.put("fechaRegistro", getFechaRegistro());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date fechainicio = (Date)attributes.get("fechainicio");

		if (fechainicio != null) {
			setFechainicio(fechainicio);
		}

		Date fechafin = (Date)attributes.get("fechafin");

		if (fechafin != null) {
			setFechafin(fechafin);
		}

		String usuariofk = (String)attributes.get("usuariofk");

		if (usuariofk != null) {
			setUsuariofk(usuariofk);
		}

		Long tipofk = (Long)attributes.get("tipofk");

		if (tipofk != null) {
			setTipofk(tipofk);
		}

		String actoadmin = (String)attributes.get("actoadmin");

		if (actoadmin != null) {
			setActoadmin(actoadmin);
		}

		Long creadoPor = (Long)attributes.get("creadoPor");

		if (creadoPor != null) {
			setCreadoPor(creadoPor);
		}

		Long modificadoPor = (Long)attributes.get("modificadoPor");

		if (modificadoPor != null) {
			setModificadoPor(modificadoPor);
		}

		Integer estatus = (Integer)attributes.get("estatus");

		if (estatus != null) {
			setEstatus(estatus);
		}

		String despacho = (String)attributes.get("despacho");

		if (despacho != null) {
			setDespacho(despacho);
		}

		Integer cargo = (Integer)attributes.get("cargo");

		if (cargo != null) {
			setCargo(cargo);
		}

		Integer horas = (Integer)attributes.get("horas");

		if (horas != null) {
			setHoras(horas);
		}

		Integer minutos = (Integer)attributes.get("minutos");

		if (minutos != null) {
			setMinutos(minutos);
		}

		Date fechaRegistro = (Date)attributes.get("fechaRegistro");

		if (fechaRegistro != null) {
			setFechaRegistro(fechaRegistro);
		}
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Date getFechainicio() {
		return _fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		_fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return _fechafin;
	}

	public void setFechafin(Date fechafin) {
		_fechafin = fechafin;
	}

	public String getUsuariofk() {
		return _usuariofk;
	}

	public void setUsuariofk(String usuariofk) {
		_usuariofk = usuariofk;
	}

	public long getTipofk() {
		return _tipofk;
	}

	public void setTipofk(long tipofk) {
		_tipofk = tipofk;
	}

	public String getActoadmin() {
		return _actoadmin;
	}

	public void setActoadmin(String actoadmin) {
		_actoadmin = actoadmin;
	}

	public long getCreadoPor() {
		return _creadoPor;
	}

	public void setCreadoPor(long creadoPor) {
		_creadoPor = creadoPor;
	}

	public long getModificadoPor() {
		return _modificadoPor;
	}

	public void setModificadoPor(long modificadoPor) {
		_modificadoPor = modificadoPor;
	}

	public int getEstatus() {
		return _estatus;
	}

	public void setEstatus(int estatus) {
		_estatus = estatus;
	}

	public String getDespacho() {
		return _despacho;
	}

	public void setDespacho(String despacho) {
		_despacho = despacho;
	}

	public int getCargo() {
		return _cargo;
	}

	public void setCargo(int cargo) {
		_cargo = cargo;
	}

	public int getHoras() {
		return _horas;
	}

	public void setHoras(int horas) {
		_horas = horas;
	}

	public int getMinutos() {
		return _minutos;
	}

	public void setMinutos(int minutos) {
		_minutos = minutos;
	}

	public Date getFechaRegistro() {
		return _fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		_fechaRegistro = fechaRegistro;
	}

	public BaseModel<?> getlicencia_permisoRemoteModel() {
		return _licencia_permisoRemoteModel;
	}

	public void setlicencia_permisoRemoteModel(
		BaseModel<?> licencia_permisoRemoteModel) {
		_licencia_permisoRemoteModel = licencia_permisoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			licencia_permisoLocalServiceUtil.addlicencia_permiso(this);
		}
		else {
			licencia_permisoLocalServiceUtil.updatelicencia_permiso(this);
		}
	}

	@Override
	public licencia_permiso toEscapedModel() {
		return (licencia_permiso)Proxy.newProxyInstance(licencia_permiso.class.getClassLoader(),
			new Class[] { licencia_permiso.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		licencia_permisoClp clone = new licencia_permisoClp();

		clone.setId(getId());
		clone.setFechainicio(getFechainicio());
		clone.setFechafin(getFechafin());
		clone.setUsuariofk(getUsuariofk());
		clone.setTipofk(getTipofk());
		clone.setActoadmin(getActoadmin());
		clone.setCreadoPor(getCreadoPor());
		clone.setModificadoPor(getModificadoPor());
		clone.setEstatus(getEstatus());
		clone.setDespacho(getDespacho());
		clone.setCargo(getCargo());
		clone.setHoras(getHoras());
		clone.setMinutos(getMinutos());
		clone.setFechaRegistro(getFechaRegistro());

		return clone;
	}

	public int compareTo(licencia_permiso licencia_permiso) {
		int value = 0;

		if (getId() < licencia_permiso.getId()) {
			value = -1;
		}
		else if (getId() > licencia_permiso.getId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		licencia_permisoClp licencia_permiso = null;

		try {
			licencia_permiso = (licencia_permisoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = licencia_permiso.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", fechainicio=");
		sb.append(getFechainicio());
		sb.append(", fechafin=");
		sb.append(getFechafin());
		sb.append(", usuariofk=");
		sb.append(getUsuariofk());
		sb.append(", tipofk=");
		sb.append(getTipofk());
		sb.append(", actoadmin=");
		sb.append(getActoadmin());
		sb.append(", creadoPor=");
		sb.append(getCreadoPor());
		sb.append(", modificadoPor=");
		sb.append(getModificadoPor());
		sb.append(", estatus=");
		sb.append(getEstatus());
		sb.append(", despacho=");
		sb.append(getDespacho());
		sb.append(", cargo=");
		sb.append(getCargo());
		sb.append(", horas=");
		sb.append(getHoras());
		sb.append(", minutos=");
		sb.append(getMinutos());
		sb.append(", fechaRegistro=");
		sb.append(getFechaRegistro());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("co.com.csj.model.licencia_permiso");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechainicio</column-name><column-value><![CDATA[");
		sb.append(getFechainicio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechafin</column-name><column-value><![CDATA[");
		sb.append(getFechafin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>usuariofk</column-name><column-value><![CDATA[");
		sb.append(getUsuariofk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipofk</column-name><column-value><![CDATA[");
		sb.append(getTipofk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actoadmin</column-name><column-value><![CDATA[");
		sb.append(getActoadmin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creadoPor</column-name><column-value><![CDATA[");
		sb.append(getCreadoPor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modificadoPor</column-name><column-value><![CDATA[");
		sb.append(getModificadoPor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estatus</column-name><column-value><![CDATA[");
		sb.append(getEstatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>despacho</column-name><column-value><![CDATA[");
		sb.append(getDespacho());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargo</column-name><column-value><![CDATA[");
		sb.append(getCargo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>horas</column-name><column-value><![CDATA[");
		sb.append(getHoras());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minutos</column-name><column-value><![CDATA[");
		sb.append(getMinutos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaRegistro</column-name><column-value><![CDATA[");
		sb.append(getFechaRegistro());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private Date _fechainicio;
	private Date _fechafin;
	private String _usuariofk;
	private long _tipofk;
	private String _actoadmin;
	private long _creadoPor;
	private long _modificadoPor;
	private int _estatus;
	private String _despacho;
	private int _cargo;
	private int _horas;
	private int _minutos;
	private Date _fechaRegistro;
	private BaseModel<?> _licencia_permisoRemoteModel;
}