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
 * This class is a wrapper for {@link permisos}.
 * </p>
 *
 * @author    villartech
 * @see       permisos
 * @generated
 */
public class permisosWrapper implements permisos, ModelWrapper<permisos> {
	public permisosWrapper(permisos permisos) {
		_permisos = permisos;
	}

	public Class<?> getModelClass() {
		return permisos.class;
	}

	public String getModelClassName() {
		return permisos.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("cargo", getCargo());
		attributes.put("d_m", getD_m());
		attributes.put("usuario", getUsuario());
		attributes.put("creacion", getCreacion());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String cargo = (String)attributes.get("cargo");

		if (cargo != null) {
			setCargo(cargo);
		}

		String d_m = (String)attributes.get("d_m");

		if (d_m != null) {
			setD_m(d_m);
		}

		String usuario = (String)attributes.get("usuario");

		if (usuario != null) {
			setUsuario(usuario);
		}

		Date creacion = (Date)attributes.get("creacion");

		if (creacion != null) {
			setCreacion(creacion);
		}
	}

	/**
	* Returns the primary key of this permisos.
	*
	* @return the primary key of this permisos
	*/
	public long getPrimaryKey() {
		return _permisos.getPrimaryKey();
	}

	/**
	* Sets the primary key of this permisos.
	*
	* @param primaryKey the primary key of this permisos
	*/
	public void setPrimaryKey(long primaryKey) {
		_permisos.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this permisos.
	*
	* @return the ID of this permisos
	*/
	public long getId() {
		return _permisos.getId();
	}

	/**
	* Sets the ID of this permisos.
	*
	* @param id the ID of this permisos
	*/
	public void setId(long id) {
		_permisos.setId(id);
	}

	/**
	* Returns the cargo of this permisos.
	*
	* @return the cargo of this permisos
	*/
	public java.lang.String getCargo() {
		return _permisos.getCargo();
	}

	/**
	* Sets the cargo of this permisos.
	*
	* @param cargo the cargo of this permisos
	*/
	public void setCargo(java.lang.String cargo) {
		_permisos.setCargo(cargo);
	}

	/**
	* Returns the d_m of this permisos.
	*
	* @return the d_m of this permisos
	*/
	public java.lang.String getD_m() {
		return _permisos.getD_m();
	}

	/**
	* Sets the d_m of this permisos.
	*
	* @param d_m the d_m of this permisos
	*/
	public void setD_m(java.lang.String d_m) {
		_permisos.setD_m(d_m);
	}

	/**
	* Returns the usuario of this permisos.
	*
	* @return the usuario of this permisos
	*/
	public java.lang.String getUsuario() {
		return _permisos.getUsuario();
	}

	/**
	* Sets the usuario of this permisos.
	*
	* @param usuario the usuario of this permisos
	*/
	public void setUsuario(java.lang.String usuario) {
		_permisos.setUsuario(usuario);
	}

	/**
	* Returns the creacion of this permisos.
	*
	* @return the creacion of this permisos
	*/
	public java.util.Date getCreacion() {
		return _permisos.getCreacion();
	}

	/**
	* Sets the creacion of this permisos.
	*
	* @param creacion the creacion of this permisos
	*/
	public void setCreacion(java.util.Date creacion) {
		_permisos.setCreacion(creacion);
	}

	public boolean isNew() {
		return _permisos.isNew();
	}

	public void setNew(boolean n) {
		_permisos.setNew(n);
	}

	public boolean isCachedModel() {
		return _permisos.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_permisos.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _permisos.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _permisos.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_permisos.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _permisos.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_permisos.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new permisosWrapper((permisos)_permisos.clone());
	}

	public int compareTo(co.com.csj.model.permisos permisos) {
		return _permisos.compareTo(permisos);
	}

	@Override
	public int hashCode() {
		return _permisos.hashCode();
	}

	public com.liferay.portal.model.CacheModel<co.com.csj.model.permisos> toCacheModel() {
		return _permisos.toCacheModel();
	}

	public co.com.csj.model.permisos toEscapedModel() {
		return new permisosWrapper(_permisos.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _permisos.toString();
	}

	public java.lang.String toXmlString() {
		return _permisos.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_permisos.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public permisos getWrappedpermisos() {
		return _permisos;
	}

	public permisos getWrappedModel() {
		return _permisos;
	}

	public void resetOriginalValues() {
		_permisos.resetOriginalValues();
	}

	private permisos _permisos;
}