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

import co.com.csj.service.DocenciaLocalServiceUtil;

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
public class DocenciaClp extends BaseModelImpl<Docencia> implements Docencia {
	public DocenciaClp() {
	}

	public Class<?> getModelClass() {
		return Docencia.class;
	}

	public String getModelClassName() {
		return Docencia.class.getName();
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
		attributes.put("usuario_fk", getUsuario_fk());
		attributes.put("fechaInicial", getFechaInicial());
		attributes.put("fechaFinal", getFechaFinal());
		attributes.put("materia", getMateria());
		attributes.put("institucion", getInstitucion());
		attributes.put("despacho", getDespacho());
		attributes.put("creadoPor", getCreadoPor());
		attributes.put("modificadoPor", getModificadoPor());
		attributes.put("estatus", getEstatus());
		attributes.put("horas", getHoras());
		attributes.put("minutos", getMinutos());
		attributes.put("cargo", getCargo());
		attributes.put("fechaRegistro", getFechaRegistro());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String usuario_fk = (String)attributes.get("usuario_fk");

		if (usuario_fk != null) {
			setUsuario_fk(usuario_fk);
		}

		Date fechaInicial = (Date)attributes.get("fechaInicial");

		if (fechaInicial != null) {
			setFechaInicial(fechaInicial);
		}

		Date fechaFinal = (Date)attributes.get("fechaFinal");

		if (fechaFinal != null) {
			setFechaFinal(fechaFinal);
		}

		String materia = (String)attributes.get("materia");

		if (materia != null) {
			setMateria(materia);
		}

		String institucion = (String)attributes.get("institucion");

		if (institucion != null) {
			setInstitucion(institucion);
		}

		String despacho = (String)attributes.get("despacho");

		if (despacho != null) {
			setDespacho(despacho);
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

		Integer horas = (Integer)attributes.get("horas");

		if (horas != null) {
			setHoras(horas);
		}

		Integer minutos = (Integer)attributes.get("minutos");

		if (minutos != null) {
			setMinutos(minutos);
		}

		Integer cargo = (Integer)attributes.get("cargo");

		if (cargo != null) {
			setCargo(cargo);
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

	public String getUsuario_fk() {
		return _usuario_fk;
	}

	public void setUsuario_fk(String usuario_fk) {
		_usuario_fk = usuario_fk;
	}

	public Date getFechaInicial() {
		return _fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		_fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return _fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		_fechaFinal = fechaFinal;
	}

	public String getMateria() {
		return _materia;
	}

	public void setMateria(String materia) {
		_materia = materia;
	}

	public String getInstitucion() {
		return _institucion;
	}

	public void setInstitucion(String institucion) {
		_institucion = institucion;
	}

	public String getDespacho() {
		return _despacho;
	}

	public void setDespacho(String despacho) {
		_despacho = despacho;
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

	public int getCargo() {
		return _cargo;
	}

	public void setCargo(int cargo) {
		_cargo = cargo;
	}

	public Date getFechaRegistro() {
		return _fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		_fechaRegistro = fechaRegistro;
	}

	public BaseModel<?> getDocenciaRemoteModel() {
		return _docenciaRemoteModel;
	}

	public void setDocenciaRemoteModel(BaseModel<?> docenciaRemoteModel) {
		_docenciaRemoteModel = docenciaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DocenciaLocalServiceUtil.addDocencia(this);
		}
		else {
			DocenciaLocalServiceUtil.updateDocencia(this);
		}
	}

	@Override
	public Docencia toEscapedModel() {
		return (Docencia)Proxy.newProxyInstance(Docencia.class.getClassLoader(),
			new Class[] { Docencia.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DocenciaClp clone = new DocenciaClp();

		clone.setId(getId());
		clone.setUsuario_fk(getUsuario_fk());
		clone.setFechaInicial(getFechaInicial());
		clone.setFechaFinal(getFechaFinal());
		clone.setMateria(getMateria());
		clone.setInstitucion(getInstitucion());
		clone.setDespacho(getDespacho());
		clone.setCreadoPor(getCreadoPor());
		clone.setModificadoPor(getModificadoPor());
		clone.setEstatus(getEstatus());
		clone.setHoras(getHoras());
		clone.setMinutos(getMinutos());
		clone.setCargo(getCargo());
		clone.setFechaRegistro(getFechaRegistro());

		return clone;
	}

	public int compareTo(Docencia docencia) {
		int value = 0;

		if (getId() < docencia.getId()) {
			value = -1;
		}
		else if (getId() > docencia.getId()) {
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

		DocenciaClp docencia = null;

		try {
			docencia = (DocenciaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = docencia.getPrimaryKey();

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
		sb.append(", usuario_fk=");
		sb.append(getUsuario_fk());
		sb.append(", fechaInicial=");
		sb.append(getFechaInicial());
		sb.append(", fechaFinal=");
		sb.append(getFechaFinal());
		sb.append(", materia=");
		sb.append(getMateria());
		sb.append(", institucion=");
		sb.append(getInstitucion());
		sb.append(", despacho=");
		sb.append(getDespacho());
		sb.append(", creadoPor=");
		sb.append(getCreadoPor());
		sb.append(", modificadoPor=");
		sb.append(getModificadoPor());
		sb.append(", estatus=");
		sb.append(getEstatus());
		sb.append(", horas=");
		sb.append(getHoras());
		sb.append(", minutos=");
		sb.append(getMinutos());
		sb.append(", cargo=");
		sb.append(getCargo());
		sb.append(", fechaRegistro=");
		sb.append(getFechaRegistro());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("co.com.csj.model.Docencia");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>usuario_fk</column-name><column-value><![CDATA[");
		sb.append(getUsuario_fk());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaInicial</column-name><column-value><![CDATA[");
		sb.append(getFechaInicial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaFinal</column-name><column-value><![CDATA[");
		sb.append(getFechaFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>materia</column-name><column-value><![CDATA[");
		sb.append(getMateria());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>institucion</column-name><column-value><![CDATA[");
		sb.append(getInstitucion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>despacho</column-name><column-value><![CDATA[");
		sb.append(getDespacho());
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
			"<column><column-name>horas</column-name><column-value><![CDATA[");
		sb.append(getHoras());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minutos</column-name><column-value><![CDATA[");
		sb.append(getMinutos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cargo</column-name><column-value><![CDATA[");
		sb.append(getCargo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaRegistro</column-name><column-value><![CDATA[");
		sb.append(getFechaRegistro());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _id;
	private String _usuario_fk;
	private Date _fechaInicial;
	private Date _fechaFinal;
	private String _materia;
	private String _institucion;
	private String _despacho;
	private long _creadoPor;
	private long _modificadoPor;
	private int _estatus;
	private int _horas;
	private int _minutos;
	private int _cargo;
	private Date _fechaRegistro;
	private BaseModel<?> _docenciaRemoteModel;
}