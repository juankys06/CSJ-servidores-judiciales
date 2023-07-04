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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Institucion}.
 * </p>
 *
 * @author    villartech
 * @see       Institucion
 * @generated
 */
public class InstitucionWrapper implements Institucion,
	ModelWrapper<Institucion> {
	public InstitucionWrapper(Institucion institucion) {
		_institucion = institucion;
	}

	public Class<?> getModelClass() {
		return Institucion.class;
	}

	public String getModelClassName() {
		return Institucion.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("descripcion", getDescripcion());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String descripcion = (String)attributes.get("descripcion");

		if (descripcion != null) {
			setDescripcion(descripcion);
		}
	}

	/**
	* Returns the primary key of this institucion.
	*
	* @return the primary key of this institucion
	*/
	public long getPrimaryKey() {
		return _institucion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this institucion.
	*
	* @param primaryKey the primary key of this institucion
	*/
	public void setPrimaryKey(long primaryKey) {
		_institucion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this institucion.
	*
	* @return the ID of this institucion
	*/
	public long getId() {
		return _institucion.getId();
	}

	/**
	* Sets the ID of this institucion.
	*
	* @param id the ID of this institucion
	*/
	public void setId(long id) {
		_institucion.setId(id);
	}

	/**
	* Returns the descripcion of this institucion.
	*
	* @return the descripcion of this institucion
	*/
	public java.lang.String getDescripcion() {
		return _institucion.getDescripcion();
	}

	/**
	* Sets the descripcion of this institucion.
	*
	* @param descripcion the descripcion of this institucion
	*/
	public void setDescripcion(java.lang.String descripcion) {
		_institucion.setDescripcion(descripcion);
	}

	public boolean isNew() {
		return _institucion.isNew();
	}

	public void setNew(boolean n) {
		_institucion.setNew(n);
	}

	public boolean isCachedModel() {
		return _institucion.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_institucion.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _institucion.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _institucion.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_institucion.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _institucion.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_institucion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InstitucionWrapper((Institucion)_institucion.clone());
	}

	public int compareTo(co.com.csj.model.Institucion institucion) {
		return _institucion.compareTo(institucion);
	}

	@Override
	public int hashCode() {
		return _institucion.hashCode();
	}

	public com.liferay.portal.model.CacheModel<co.com.csj.model.Institucion> toCacheModel() {
		return _institucion.toCacheModel();
	}

	public co.com.csj.model.Institucion toEscapedModel() {
		return new InstitucionWrapper(_institucion.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _institucion.toString();
	}

	public java.lang.String toXmlString() {
		return _institucion.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_institucion.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Institucion getWrappedInstitucion() {
		return _institucion;
	}

	public Institucion getWrappedModel() {
		return _institucion;
	}

	public void resetOriginalValues() {
		_institucion.resetOriginalValues();
	}

	private Institucion _institucion;
}