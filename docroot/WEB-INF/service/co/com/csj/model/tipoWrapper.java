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
 * This class is a wrapper for {@link tipo}.
 * </p>
 *
 * @author    villartech
 * @see       tipo
 * @generated
 */
public class tipoWrapper implements tipo, ModelWrapper<tipo> {
	public tipoWrapper(tipo tipo) {
		_tipo = tipo;
	}

	public Class<?> getModelClass() {
		return tipo.class;
	}

	public String getModelClassName() {
		return tipo.class.getName();
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
	* Returns the primary key of this tipo.
	*
	* @return the primary key of this tipo
	*/
	public long getPrimaryKey() {
		return _tipo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tipo.
	*
	* @param primaryKey the primary key of this tipo
	*/
	public void setPrimaryKey(long primaryKey) {
		_tipo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this tipo.
	*
	* @return the ID of this tipo
	*/
	public long getId() {
		return _tipo.getId();
	}

	/**
	* Sets the ID of this tipo.
	*
	* @param id the ID of this tipo
	*/
	public void setId(long id) {
		_tipo.setId(id);
	}

	/**
	* Returns the descripcion of this tipo.
	*
	* @return the descripcion of this tipo
	*/
	public java.lang.String getDescripcion() {
		return _tipo.getDescripcion();
	}

	/**
	* Sets the descripcion of this tipo.
	*
	* @param descripcion the descripcion of this tipo
	*/
	public void setDescripcion(java.lang.String descripcion) {
		_tipo.setDescripcion(descripcion);
	}

	public boolean isNew() {
		return _tipo.isNew();
	}

	public void setNew(boolean n) {
		_tipo.setNew(n);
	}

	public boolean isCachedModel() {
		return _tipo.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tipo.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tipo.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tipo.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tipo.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tipo.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tipo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new tipoWrapper((tipo)_tipo.clone());
	}

	public int compareTo(co.com.csj.model.tipo tipo) {
		return _tipo.compareTo(tipo);
	}

	@Override
	public int hashCode() {
		return _tipo.hashCode();
	}

	public com.liferay.portal.model.CacheModel<co.com.csj.model.tipo> toCacheModel() {
		return _tipo.toCacheModel();
	}

	public co.com.csj.model.tipo toEscapedModel() {
		return new tipoWrapper(_tipo.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tipo.toString();
	}

	public java.lang.String toXmlString() {
		return _tipo.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tipo.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public tipo getWrappedtipo() {
		return _tipo;
	}

	public tipo getWrappedModel() {
		return _tipo;
	}

	public void resetOriginalValues() {
		_tipo.resetOriginalValues();
	}

	private tipo _tipo;
}