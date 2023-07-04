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
public class licencia_permisoSoap implements Serializable {
	public static licencia_permisoSoap toSoapModel(licencia_permiso model) {
		licencia_permisoSoap soapModel = new licencia_permisoSoap();

		soapModel.setId(model.getId());
		soapModel.setFechainicio(model.getFechainicio());
		soapModel.setFechafin(model.getFechafin());
		soapModel.setUsuariofk(model.getUsuariofk());
		soapModel.setTipofk(model.getTipofk());
		soapModel.setActoadmin(model.getActoadmin());
		soapModel.setCreadoPor(model.getCreadoPor());
		soapModel.setModificadoPor(model.getModificadoPor());
		soapModel.setEstatus(model.getEstatus());
		soapModel.setDespacho(model.getDespacho());
		soapModel.setCargo(model.getCargo());
		soapModel.setHoras(model.getHoras());
		soapModel.setMinutos(model.getMinutos());
		soapModel.setFechaRegistro(model.getFechaRegistro());

		return soapModel;
	}

	public static licencia_permisoSoap[] toSoapModels(licencia_permiso[] models) {
		licencia_permisoSoap[] soapModels = new licencia_permisoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static licencia_permisoSoap[][] toSoapModels(
		licencia_permiso[][] models) {
		licencia_permisoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new licencia_permisoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new licencia_permisoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static licencia_permisoSoap[] toSoapModels(
		List<licencia_permiso> models) {
		List<licencia_permisoSoap> soapModels = new ArrayList<licencia_permisoSoap>(models.size());

		for (licencia_permiso model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new licencia_permisoSoap[soapModels.size()]);
	}

	public licencia_permisoSoap() {
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
}