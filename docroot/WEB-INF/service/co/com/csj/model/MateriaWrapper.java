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
 * This class is a wrapper for {@link Materia}.
 * </p>
 *
 * @author    villartech
 * @see       Materia
 * @generated
 */
public class MateriaWrapper implements Materia, ModelWrapper<Materia> {
	public MateriaWrapper(Materia materia) {
		_materia = materia;
	}

	public Class<?> getModelClass() {
		return Materia.class;
	}

	public String getModelClassName() {
		return Materia.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String id = (String)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	/**
	* Returns the primary key of this materia.
	*
	* @return the primary key of this materia
	*/
	public java.lang.String getPrimaryKey() {
		return _materia.getPrimaryKey();
	}

	/**
	* Sets the primary key of this materia.
	*
	* @param primaryKey the primary key of this materia
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_materia.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this materia.
	*
	* @return the ID of this materia
	*/
	public java.lang.String getId() {
		return _materia.getId();
	}

	/**
	* Sets the ID of this materia.
	*
	* @param id the ID of this materia
	*/
	public void setId(java.lang.String id) {
		_materia.setId(id);
	}

	/**
	* Returns the nombre of this materia.
	*
	* @return the nombre of this materia
	*/
	public java.lang.String getNombre() {
		return _materia.getNombre();
	}

	/**
	* Sets the nombre of this materia.
	*
	* @param nombre the nombre of this materia
	*/
	public void setNombre(java.lang.String nombre) {
		_materia.setNombre(nombre);
	}

	public boolean isNew() {
		return _materia.isNew();
	}

	public void setNew(boolean n) {
		_materia.setNew(n);
	}

	public boolean isCachedModel() {
		return _materia.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_materia.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _materia.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _materia.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_materia.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _materia.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_materia.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MateriaWrapper((Materia)_materia.clone());
	}

	public int compareTo(co.com.csj.model.Materia materia) {
		return _materia.compareTo(materia);
	}

	@Override
	public int hashCode() {
		return _materia.hashCode();
	}

	public com.liferay.portal.model.CacheModel<co.com.csj.model.Materia> toCacheModel() {
		return _materia.toCacheModel();
	}

	public co.com.csj.model.Materia toEscapedModel() {
		return new MateriaWrapper(_materia.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _materia.toString();
	}

	public java.lang.String toXmlString() {
		return _materia.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_materia.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Materia getWrappedMateria() {
		return _materia;
	}

	public Materia getWrappedModel() {
		return _materia;
	}

	public void resetOriginalValues() {
		_materia.resetOriginalValues();
	}

	private Materia _materia;
}