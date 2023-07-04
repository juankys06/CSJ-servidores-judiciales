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
 * This class is a wrapper for {@link cargo}.
 * </p>
 *
 * @author    villartech
 * @see       cargo
 * @generated
 */
public class cargoWrapper implements cargo, ModelWrapper<cargo> {
	public cargoWrapper(cargo cargo) {
		_cargo = cargo;
	}

	public Class<?> getModelClass() {
		return cargo.class;
	}

	public String getModelClassName() {
		return cargo.class.getName();
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
	* Returns the primary key of this cargo.
	*
	* @return the primary key of this cargo
	*/
	public long getPrimaryKey() {
		return _cargo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cargo.
	*
	* @param primaryKey the primary key of this cargo
	*/
	public void setPrimaryKey(long primaryKey) {
		_cargo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the _id of this cargo.
	*
	* @return the _id of this cargo
	*/
	public long get_id() {
		return _cargo.get_id();
	}

	/**
	* Sets the _id of this cargo.
	*
	* @param _id the _id of this cargo
	*/
	public void set_id(long _id) {
		_cargo.set_id(_id);
	}

	/**
	* Returns the desc of this cargo.
	*
	* @return the desc of this cargo
	*/
	public java.lang.String getDesc() {
		return _cargo.getDesc();
	}

	/**
	* Sets the desc of this cargo.
	*
	* @param desc the desc of this cargo
	*/
	public void setDesc(java.lang.String desc) {
		_cargo.setDesc(desc);
	}

	public boolean isNew() {
		return _cargo.isNew();
	}

	public void setNew(boolean n) {
		_cargo.setNew(n);
	}

	public boolean isCachedModel() {
		return _cargo.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_cargo.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _cargo.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _cargo.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cargo.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cargo.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cargo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new cargoWrapper((cargo)_cargo.clone());
	}

	public int compareTo(co.com.csj.model.cargo cargo) {
		return _cargo.compareTo(cargo);
	}

	@Override
	public int hashCode() {
		return _cargo.hashCode();
	}

	public com.liferay.portal.model.CacheModel<co.com.csj.model.cargo> toCacheModel() {
		return _cargo.toCacheModel();
	}

	public co.com.csj.model.cargo toEscapedModel() {
		return new cargoWrapper(_cargo.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cargo.toString();
	}

	public java.lang.String toXmlString() {
		return _cargo.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cargo.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public cargo getWrappedcargo() {
		return _cargo;
	}

	public cargo getWrappedModel() {
		return _cargo;
	}

	public void resetOriginalValues() {
		_cargo.resetOriginalValues();
	}

	private cargo _cargo;
}