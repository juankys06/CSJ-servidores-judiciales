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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    villartech
 * @generated
 */
public class DocenciaSoap implements Serializable {
	public static DocenciaSoap toSoapModel(Docencia model) {
		DocenciaSoap soapModel = new DocenciaSoap();

		soapModel.setId(model.getId());
		soapModel.setUsuario_fk(model.getUsuario_fk());
		soapModel.setFechaInicial(model.getFechaInicial());
		soapModel.setFechaFinal(model.getFechaFinal());
		soapModel.setMateria(model.getMateria());
		soapModel.setInstitucion(model.getInstitucion());
		soapModel.setDespacho(model.getDespacho());
		soapModel.setCreadoPor(model.getCreadoPor());
		soapModel.setModificadoPor(model.getModificadoPor());
		soapModel.setEstatus(model.getEstatus());
		soapModel.setHoras(model.getHoras());
		soapModel.setMinutos(model.getMinutos());
		soapModel.setCargo(model.getCargo());
		soapModel.setFechaRegistro(model.getFechaRegistro());

		return soapModel;
	}

	public static DocenciaSoap[] toSoapModels(Docencia[] models) {
		DocenciaSoap[] soapModels = new DocenciaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DocenciaSoap[][] toSoapModels(Docencia[][] models) {
		DocenciaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DocenciaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DocenciaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DocenciaSoap[] toSoapModels(List<Docencia> models) {
		List<DocenciaSoap> soapModels = new ArrayList<DocenciaSoap>(models.size());

		for (Docencia model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DocenciaSoap[soapModels.size()]);
	}

	public DocenciaSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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
}