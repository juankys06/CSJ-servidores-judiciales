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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link licencia_permiso}.
 * </p>
 *
 * @author    villartech
 * @see       licencia_permiso
 * @generated
 */
public class licencia_permisoWrapper implements licencia_permiso,
	ModelWrapper<licencia_permiso> {
	public licencia_permisoWrapper(licencia_permiso licencia_permiso) {
		_licencia_permiso = licencia_permiso;
	}

	public Class<?> getModelClass() {
		return licencia_permiso.class;
	}

	public String getModelClassName() {
		return licencia_permiso.class.getName();
	}

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

	/**
	* Returns the primary key of this licencia_permiso.
	*
	* @return the primary key of this licencia_permiso
	*/
	public long getPrimaryKey() {
		return _licencia_permiso.getPrimaryKey();
	}

	/**
	* Sets the primary key of this licencia_permiso.
	*
	* @param primaryKey the primary key of this licencia_permiso
	*/
	public void setPrimaryKey(long primaryKey) {
		_licencia_permiso.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this licencia_permiso.
	*
	* @return the ID of this licencia_permiso
	*/
	public long getId() {
		return _licencia_permiso.getId();
	}

	/**
	* Sets the ID of this licencia_permiso.
	*
	* @param id the ID of this licencia_permiso
	*/
	public void setId(long id) {
		_licencia_permiso.setId(id);
	}

	/**
	* Returns the fechainicio of this licencia_permiso.
	*
	* @return the fechainicio of this licencia_permiso
	*/
	public java.util.Date getFechainicio() {
		return _licencia_permiso.getFechainicio();
	}

	/**
	* Sets the fechainicio of this licencia_permiso.
	*
	* @param fechainicio the fechainicio of this licencia_permiso
	*/
	public void setFechainicio(java.util.Date fechainicio) {
		_licencia_permiso.setFechainicio(fechainicio);
	}

	/**
	* Returns the fechafin of this licencia_permiso.
	*
	* @return the fechafin of this licencia_permiso
	*/
	public java.util.Date getFechafin() {
		return _licencia_permiso.getFechafin();
	}

	/**
	* Sets the fechafin of this licencia_permiso.
	*
	* @param fechafin the fechafin of this licencia_permiso
	*/
	public void setFechafin(java.util.Date fechafin) {
		_licencia_permiso.setFechafin(fechafin);
	}

	/**
	* Returns the usuariofk of this licencia_permiso.
	*
	* @return the usuariofk of this licencia_permiso
	*/
	public java.lang.String getUsuariofk() {
		return _licencia_permiso.getUsuariofk();
	}

	/**
	* Sets the usuariofk of this licencia_permiso.
	*
	* @param usuariofk the usuariofk of this licencia_permiso
	*/
	public void setUsuariofk(java.lang.String usuariofk) {
		_licencia_permiso.setUsuariofk(usuariofk);
	}

	/**
	* Returns the tipofk of this licencia_permiso.
	*
	* @return the tipofk of this licencia_permiso
	*/
	public long getTipofk() {
		return _licencia_permiso.getTipofk();
	}

	/**
	* Sets the tipofk of this licencia_permiso.
	*
	* @param tipofk the tipofk of this licencia_permiso
	*/
	public void setTipofk(long tipofk) {
		_licencia_permiso.setTipofk(tipofk);
	}

	/**
	* Returns the actoadmin of this licencia_permiso.
	*
	* @return the actoadmin of this licencia_permiso
	*/
	public java.lang.String getActoadmin() {
		return _licencia_permiso.getActoadmin();
	}

	/**
	* Sets the actoadmin of this licencia_permiso.
	*
	* @param actoadmin the actoadmin of this licencia_permiso
	*/
	public void setActoadmin(java.lang.String actoadmin) {
		_licencia_permiso.setActoadmin(actoadmin);
	}

	/**
	* Returns the creado por of this licencia_permiso.
	*
	* @return the creado por of this licencia_permiso
	*/
	public long getCreadoPor() {
		return _licencia_permiso.getCreadoPor();
	}

	/**
	* Sets the creado por of this licencia_permiso.
	*
	* @param creadoPor the creado por of this licencia_permiso
	*/
	public void setCreadoPor(long creadoPor) {
		_licencia_permiso.setCreadoPor(creadoPor);
	}

	/**
	* Returns the modificado por of this licencia_permiso.
	*
	* @return the modificado por of this licencia_permiso
	*/
	public long getModificadoPor() {
		return _licencia_permiso.getModificadoPor();
	}

	/**
	* Sets the modificado por of this licencia_permiso.
	*
	* @param modificadoPor the modificado por of this licencia_permiso
	*/
	public void setModificadoPor(long modificadoPor) {
		_licencia_permiso.setModificadoPor(modificadoPor);
	}

	/**
	* Returns the estatus of this licencia_permiso.
	*
	* @return the estatus of this licencia_permiso
	*/
	public int getEstatus() {
		return _licencia_permiso.getEstatus();
	}

	/**
	* Sets the estatus of this licencia_permiso.
	*
	* @param estatus the estatus of this licencia_permiso
	*/
	public void setEstatus(int estatus) {
		_licencia_permiso.setEstatus(estatus);
	}

	/**
	* Returns the despacho of this licencia_permiso.
	*
	* @return the despacho of this licencia_permiso
	*/
	public java.lang.String getDespacho() {
		return _licencia_permiso.getDespacho();
	}

	/**
	* Sets the despacho of this licencia_permiso.
	*
	* @param despacho the despacho of this licencia_permiso
	*/
	public void setDespacho(java.lang.String despacho) {
		_licencia_permiso.setDespacho(despacho);
	}

	/**
	* Returns the cargo of this licencia_permiso.
	*
	* @return the cargo of this licencia_permiso
	*/
	public int getCargo() {
		return _licencia_permiso.getCargo();
	}

	/**
	* Sets the cargo of this licencia_permiso.
	*
	* @param cargo the cargo of this licencia_permiso
	*/
	public void setCargo(int cargo) {
		_licencia_permiso.setCargo(cargo);
	}

	/**
	* Returns the horas of this licencia_permiso.
	*
	* @return the horas of this licencia_permiso
	*/
	public int getHoras() {
		return _licencia_permiso.getHoras();
	}

	/**
	* Sets the horas of this licencia_permiso.
	*
	* @param horas the horas of this licencia_permiso
	*/
	public void setHoras(int horas) {
		_licencia_permiso.setHoras(horas);
	}

	/**
	* Returns the minutos of this licencia_permiso.
	*
	* @return the minutos of this licencia_permiso
	*/
	public int getMinutos() {
		return _licencia_permiso.getMinutos();
	}

	/**
	* Sets the minutos of this licencia_permiso.
	*
	* @param minutos the minutos of this licencia_permiso
	*/
	public void setMinutos(int minutos) {
		_licencia_permiso.setMinutos(minutos);
	}

	/**
	* Returns the fecha registro of this licencia_permiso.
	*
	* @return the fecha registro of this licencia_permiso
	*/
	public java.util.Date getFechaRegistro() {
		return _licencia_permiso.getFechaRegistro();
	}

	/**
	* Sets the fecha registro of this licencia_permiso.
	*
	* @param fechaRegistro the fecha registro of this licencia_permiso
	*/
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		_licencia_permiso.setFechaRegistro(fechaRegistro);
	}

	public boolean isNew() {
		return _licencia_permiso.isNew();
	}

	public void setNew(boolean n) {
		_licencia_permiso.setNew(n);
	}

	public boolean isCachedModel() {
		return _licencia_permiso.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_licencia_permiso.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _licencia_permiso.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _licencia_permiso.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_licencia_permiso.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _licencia_permiso.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_licencia_permiso.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new licencia_permisoWrapper((licencia_permiso)_licencia_permiso.clone());
	}

	public int compareTo(co.com.csj.model.licencia_permiso licencia_permiso) {
		return _licencia_permiso.compareTo(licencia_permiso);
	}

	@Override
	public int hashCode() {
		return _licencia_permiso.hashCode();
	}

	public com.liferay.portal.model.CacheModel<co.com.csj.model.licencia_permiso> toCacheModel() {
		return _licencia_permiso.toCacheModel();
	}

	public co.com.csj.model.licencia_permiso toEscapedModel() {
		return new licencia_permisoWrapper(_licencia_permiso.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _licencia_permiso.toString();
	}

	public java.lang.String toXmlString() {
		return _licencia_permiso.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_licencia_permiso.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public licencia_permiso getWrappedlicencia_permiso() {
		return _licencia_permiso;
	}

	public licencia_permiso getWrappedModel() {
		return _licencia_permiso;
	}

	public void resetOriginalValues() {
		_licencia_permiso.resetOriginalValues();
	}

	private licencia_permiso _licencia_permiso;
}