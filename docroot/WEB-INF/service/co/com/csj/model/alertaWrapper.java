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
 * This class is a wrapper for {@link alerta}.
 * </p>
 *
 * @author    villartech
 * @see       alerta
 * @generated
 */
public class alertaWrapper implements alerta, ModelWrapper<alerta> {
	public alertaWrapper(alerta alerta) {
		_alerta = alerta;
	}

	public Class<?> getModelClass() {
		return alerta.class;
	}

	public String getModelClassName() {
		return alerta.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("asunto", getAsunto());
		attributes.put("mensaje", getMensaje());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String asunto = (String)attributes.get("asunto");

		if (asunto != null) {
			setAsunto(asunto);
		}

		String mensaje = (String)attributes.get("mensaje");

		if (mensaje != null) {
			setMensaje(mensaje);
		}
	}

	/**
	* Returns the primary key of this alerta.
	*
	* @return the primary key of this alerta
	*/
	public java.lang.String getPrimaryKey() {
		return _alerta.getPrimaryKey();
	}

	/**
	* Sets the primary key of this alerta.
	*
	* @param primaryKey the primary key of this alerta
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_alerta.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this alerta.
	*
	* @return the ID of this alerta
	*/
	public java.lang.String getId() {
		return _alerta.getId();
	}

	/**
	* Sets the ID of this alerta.
	*
	* @param id the ID of this alerta
	*/
	public void setId(java.lang.String id) {
		_alerta.setId(id);
	}

	/**
	* Returns the asunto of this alerta.
	*
	* @return the asunto of this alerta
	*/
	public java.lang.String getAsunto() {
		return _alerta.getAsunto();
	}

	/**
	* Sets the asunto of this alerta.
	*
	* @param asunto the asunto of this alerta
	*/
	public void setAsunto(java.lang.String asunto) {
		_alerta.setAsunto(asunto);
	}

	/**
	* Returns the mensaje of this alerta.
	*
	* @return the mensaje of this alerta
	*/
	public java.lang.String getMensaje() {
		return _alerta.getMensaje();
	}

	/**
	* Sets the mensaje of this alerta.
	*
	* @param mensaje the mensaje of this alerta
	*/
	public void setMensaje(java.lang.String mensaje) {
		_alerta.setMensaje(mensaje);
	}

	public boolean isNew() {
		return _alerta.isNew();
	}

	public void setNew(boolean n) {
		_alerta.setNew(n);
	}

	public boolean isCachedModel() {
		return _alerta.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_alerta.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _alerta.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _alerta.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_alerta.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _alerta.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_alerta.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new alertaWrapper((alerta)_alerta.clone());
	}

	public int compareTo(co.com.csj.model.alerta alerta) {
		return _alerta.compareTo(alerta);
	}

	@Override
	public int hashCode() {
		return _alerta.hashCode();
	}

	public com.liferay.portal.model.CacheModel<co.com.csj.model.alerta> toCacheModel() {
		return _alerta.toCacheModel();
	}

	public co.com.csj.model.alerta toEscapedModel() {
		return new alertaWrapper(_alerta.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _alerta.toString();
	}

	public java.lang.String toXmlString() {
		return _alerta.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_alerta.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public alerta getWrappedalerta() {
		return _alerta;
	}

	public alerta getWrappedModel() {
		return _alerta;
	}

	public void resetOriginalValues() {
		_alerta.resetOriginalValues();
	}

	private alerta _alerta;
}