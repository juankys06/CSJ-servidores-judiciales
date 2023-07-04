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
 * This class is a wrapper for {@link tipo_documento}.
 * </p>
 *
 * @author    villartech
 * @see       tipo_documento
 * @generated
 */
public class tipo_documentoWrapper implements tipo_documento,
	ModelWrapper<tipo_documento> {
	public tipo_documentoWrapper(tipo_documento tipo_documento) {
		_tipo_documento = tipo_documento;
	}

	public Class<?> getModelClass() {
		return tipo_documento.class;
	}

	public String getModelClassName() {
		return tipo_documento.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("_id", get_id());
		attributes.put("desc", getDesc());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long _id = (Long)attributes.get("_id");

		if (_id != null) {
			set_id(_id);
		}

		String desc = (String)attributes.get("desc");

		if (desc != null) {
			setDesc(desc);
		}
	}

	/**
	* Returns the primary key of this tipo_documento.
	*
	* @return the primary key of this tipo_documento
	*/
	public long getPrimaryKey() {
		return _tipo_documento.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tipo_documento.
	*
	* @param primaryKey the primary key of this tipo_documento
	*/
	public void setPrimaryKey(long primaryKey) {
		_tipo_documento.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the _id of this tipo_documento.
	*
	* @return the _id of this tipo_documento
	*/
	public long get_id() {
		return _tipo_documento.get_id();
	}

	/**
	* Sets the _id of this tipo_documento.
	*
	* @param _id the _id of this tipo_documento
	*/
	public void set_id(long _id) {
		_tipo_documento.set_id(_id);
	}

	/**
	* Returns the desc of this tipo_documento.
	*
	* @return the desc of this tipo_documento
	*/
	public java.lang.String getDesc() {
		return _tipo_documento.getDesc();
	}

	/**
	* Sets the desc of this tipo_documento.
	*
	* @param desc the desc of this tipo_documento
	*/
	public void setDesc(java.lang.String desc) {
		_tipo_documento.setDesc(desc);
	}

	public boolean isNew() {
		return _tipo_documento.isNew();
	}

	public void setNew(boolean n) {
		_tipo_documento.setNew(n);
	}

	public boolean isCachedModel() {
		return _tipo_documento.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_tipo_documento.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _tipo_documento.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _tipo_documento.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_tipo_documento.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _tipo_documento.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_tipo_documento.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new tipo_documentoWrapper((tipo_documento)_tipo_documento.clone());
	}

	public int compareTo(co.com.csj.model.tipo_documento tipo_documento) {
		return _tipo_documento.compareTo(tipo_documento);
	}

	@Override
	public int hashCode() {
		return _tipo_documento.hashCode();
	}

	public com.liferay.portal.model.CacheModel<co.com.csj.model.tipo_documento> toCacheModel() {
		return _tipo_documento.toCacheModel();
	}

	public co.com.csj.model.tipo_documento toEscapedModel() {
		return new tipo_documentoWrapper(_tipo_documento.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _tipo_documento.toString();
	}

	public java.lang.String toXmlString() {
		return _tipo_documento.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_tipo_documento.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public tipo_documento getWrappedtipo_documento() {
		return _tipo_documento;
	}

	public tipo_documento getWrappedModel() {
		return _tipo_documento;
	}

	public void resetOriginalValues() {
		_tipo_documento.resetOriginalValues();
	}

	private tipo_documento _tipo_documento;
}