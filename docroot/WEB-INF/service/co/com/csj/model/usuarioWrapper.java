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
 * This class is a wrapper for {@link usuario}.
 * </p>
 *
 * @author    villartech
 * @see       usuario
 * @generated
 */
public class usuarioWrapper implements usuario, ModelWrapper<usuario> {
	public usuarioWrapper(usuario usuario) {
		_usuario = usuario;
	}

	public Class<?> getModelClass() {
		return usuario.class;
	}

	public String getModelClassName() {
		return usuario.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nomb", getNomb());
		attributes.put("ape", getApe());
		attributes.put("tipo_doc", getTipo_doc());
		attributes.put("despachofk", getDespachofk());
		attributes.put("cargofk", getCargofk());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nomb = (String)attributes.get("nomb");

		if (nomb != null) {
			setNomb(nomb);
		}

		String ape = (String)attributes.get("ape");

		if (ape != null) {
			setApe(ape);
		}

		Long tipo_doc = (Long)attributes.get("tipo_doc");

		if (tipo_doc != null) {
			setTipo_doc(tipo_doc);
		}

		String despachofk = (String)attributes.get("despachofk");

		if (despachofk != null) {
			setDespachofk(despachofk);
		}

		Long cargofk = (Long)attributes.get("cargofk");

		if (cargofk != null) {
			setCargofk(cargofk);
		}
	}

	/**
	* Returns the primary key of this usuario.
	*
	* @return the primary key of this usuario
	*/
	public java.lang.String getPrimaryKey() {
		return _usuario.getPrimaryKey();
	}

	/**
	* Sets the primary key of this usuario.
	*
	* @param primaryKey the primary key of this usuario
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_usuario.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this usuario.
	*
	* @return the ID of this usuario
	*/
	public java.lang.String getId() {
		return _usuario.getId();
	}

	/**
	* Sets the ID of this usuario.
	*
	* @param id the ID of this usuario
	*/
	public void setId(java.lang.String id) {
		_usuario.setId(id);
	}

	/**
	* Returns the nomb of this usuario.
	*
	* @return the nomb of this usuario
	*/
	public java.lang.String getNomb() {
		return _usuario.getNomb();
	}

	/**
	* Sets the nomb of this usuario.
	*
	* @param nomb the nomb of this usuario
	*/
	public void setNomb(java.lang.String nomb) {
		_usuario.setNomb(nomb);
	}

	/**
	* Returns the ape of this usuario.
	*
	* @return the ape of this usuario
	*/
	public java.lang.String getApe() {
		return _usuario.getApe();
	}

	/**
	* Sets the ape of this usuario.
	*
	* @param ape the ape of this usuario
	*/
	public void setApe(java.lang.String ape) {
		_usuario.setApe(ape);
	}

	/**
	* Returns the tipo_doc of this usuario.
	*
	* @return the tipo_doc of this usuario
	*/
	public long getTipo_doc() {
		return _usuario.getTipo_doc();
	}

	/**
	* Sets the tipo_doc of this usuario.
	*
	* @param tipo_doc the tipo_doc of this usuario
	*/
	public void setTipo_doc(long tipo_doc) {
		_usuario.setTipo_doc(tipo_doc);
	}

	/**
	* Returns the despachofk of this usuario.
	*
	* @return the despachofk of this usuario
	*/
	public java.lang.String getDespachofk() {
		return _usuario.getDespachofk();
	}

	/**
	* Sets the despachofk of this usuario.
	*
	* @param despachofk the despachofk of this usuario
	*/
	public void setDespachofk(java.lang.String despachofk) {
		_usuario.setDespachofk(despachofk);
	}

	/**
	* Returns the cargofk of this usuario.
	*
	* @return the cargofk of this usuario
	*/
	public long getCargofk() {
		return _usuario.getCargofk();
	}

	/**
	* Sets the cargofk of this usuario.
	*
	* @param cargofk the cargofk of this usuario
	*/
	public void setCargofk(long cargofk) {
		_usuario.setCargofk(cargofk);
	}

	public boolean isNew() {
		return _usuario.isNew();
	}

	public void setNew(boolean n) {
		_usuario.setNew(n);
	}

	public boolean isCachedModel() {
		return _usuario.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_usuario.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _usuario.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _usuario.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_usuario.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _usuario.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_usuario.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new usuarioWrapper((usuario)_usuario.clone());
	}

	public int compareTo(co.com.csj.model.usuario usuario) {
		return _usuario.compareTo(usuario);
	}

	@Override
	public int hashCode() {
		return _usuario.hashCode();
	}

	public com.liferay.portal.model.CacheModel<co.com.csj.model.usuario> toCacheModel() {
		return _usuario.toCacheModel();
	}

	public co.com.csj.model.usuario toEscapedModel() {
		return new usuarioWrapper(_usuario.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _usuario.toString();
	}

	public java.lang.String toXmlString() {
		return _usuario.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_usuario.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public usuario getWrappedusuario() {
		return _usuario;
	}

	public usuario getWrappedModel() {
		return _usuario;
	}

	public void resetOriginalValues() {
		_usuario.resetOriginalValues();
	}

	private usuario _usuario;
}