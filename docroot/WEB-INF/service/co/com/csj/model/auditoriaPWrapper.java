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
 * This class is a wrapper for {@link auditoriaP}.
 * </p>
 *
 * @author    villartech
 * @see       auditoriaP
 * @generated
 */
public class auditoriaPWrapper implements auditoriaP, ModelWrapper<auditoriaP> {
	public auditoriaPWrapper(auditoriaP auditoriaP) {
		_auditoriaP = auditoriaP;
	}

	public Class<?> getModelClass() {
		return auditoriaP.class;
	}

	public String getModelClassName() {
		return auditoriaP.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tipo_recurso", getTipo_recurso());
		attributes.put("id_recurso_modificado", getId_recurso_modificado());
		attributes.put("tipo_operacion", getTipo_operacion());
		attributes.put("fecha", getFecha());
		attributes.put("correo", getCorreo());
		attributes.put("usuario_modifico", getUsuario_modifico());
		attributes.put("modificacion", getModificacion());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer tipo_recurso = (Integer)attributes.get("tipo_recurso");

		if (tipo_recurso != null) {
			setTipo_recurso(tipo_recurso);
		}

		String id_recurso_modificado = (String)attributes.get(
				"id_recurso_modificado");

		if (id_recurso_modificado != null) {
			setId_recurso_modificado(id_recurso_modificado);
		}

		String tipo_operacion = (String)attributes.get("tipo_operacion");

		if (tipo_operacion != null) {
			setTipo_operacion(tipo_operacion);
		}

		Date fecha = (Date)attributes.get("fecha");

		if (fecha != null) {
			setFecha(fecha);
		}

		String correo = (String)attributes.get("correo");

		if (correo != null) {
			setCorreo(correo);
		}

		String usuario_modifico = (String)attributes.get("usuario_modifico");

		if (usuario_modifico != null) {
			setUsuario_modifico(usuario_modifico);
		}

		String modificacion = (String)attributes.get("modificacion");

		if (modificacion != null) {
			setModificacion(modificacion);
		}
	}

	/**
	* Returns the primary key of this auditoria p.
	*
	* @return the primary key of this auditoria p
	*/
	public long getPrimaryKey() {
		return _auditoriaP.getPrimaryKey();
	}

	/**
	* Sets the primary key of this auditoria p.
	*
	* @param primaryKey the primary key of this auditoria p
	*/
	public void setPrimaryKey(long primaryKey) {
		_auditoriaP.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this auditoria p.
	*
	* @return the ID of this auditoria p
	*/
	public long getId() {
		return _auditoriaP.getId();
	}

	/**
	* Sets the ID of this auditoria p.
	*
	* @param id the ID of this auditoria p
	*/
	public void setId(long id) {
		_auditoriaP.setId(id);
	}

	/**
	* Returns the tipo_recurso of this auditoria p.
	*
	* @return the tipo_recurso of this auditoria p
	*/
	public int getTipo_recurso() {
		return _auditoriaP.getTipo_recurso();
	}

	/**
	* Sets the tipo_recurso of this auditoria p.
	*
	* @param tipo_recurso the tipo_recurso of this auditoria p
	*/
	public void setTipo_recurso(int tipo_recurso) {
		_auditoriaP.setTipo_recurso(tipo_recurso);
	}

	/**
	* Returns the id_recurso_modificado of this auditoria p.
	*
	* @return the id_recurso_modificado of this auditoria p
	*/
	public java.lang.String getId_recurso_modificado() {
		return _auditoriaP.getId_recurso_modificado();
	}

	/**
	* Sets the id_recurso_modificado of this auditoria p.
	*
	* @param id_recurso_modificado the id_recurso_modificado of this auditoria p
	*/
	public void setId_recurso_modificado(java.lang.String id_recurso_modificado) {
		_auditoriaP.setId_recurso_modificado(id_recurso_modificado);
	}

	/**
	* Returns the tipo_operacion of this auditoria p.
	*
	* @return the tipo_operacion of this auditoria p
	*/
	public java.lang.String getTipo_operacion() {
		return _auditoriaP.getTipo_operacion();
	}

	/**
	* Sets the tipo_operacion of this auditoria p.
	*
	* @param tipo_operacion the tipo_operacion of this auditoria p
	*/
	public void setTipo_operacion(java.lang.String tipo_operacion) {
		_auditoriaP.setTipo_operacion(tipo_operacion);
	}

	/**
	* Returns the fecha of this auditoria p.
	*
	* @return the fecha of this auditoria p
	*/
	public java.util.Date getFecha() {
		return _auditoriaP.getFecha();
	}

	/**
	* Sets the fecha of this auditoria p.
	*
	* @param fecha the fecha of this auditoria p
	*/
	public void setFecha(java.util.Date fecha) {
		_auditoriaP.setFecha(fecha);
	}

	/**
	* Returns the correo of this auditoria p.
	*
	* @return the correo of this auditoria p
	*/
	public java.lang.String getCorreo() {
		return _auditoriaP.getCorreo();
	}

	/**
	* Sets the correo of this auditoria p.
	*
	* @param correo the correo of this auditoria p
	*/
	public void setCorreo(java.lang.String correo) {
		_auditoriaP.setCorreo(correo);
	}

	/**
	* Returns the usuario_modifico of this auditoria p.
	*
	* @return the usuario_modifico of this auditoria p
	*/
	public java.lang.String getUsuario_modifico() {
		return _auditoriaP.getUsuario_modifico();
	}

	/**
	* Sets the usuario_modifico of this auditoria p.
	*
	* @param usuario_modifico the usuario_modifico of this auditoria p
	*/
	public void setUsuario_modifico(java.lang.String usuario_modifico) {
		_auditoriaP.setUsuario_modifico(usuario_modifico);
	}

	/**
	* Returns the modificacion of this auditoria p.
	*
	* @return the modificacion of this auditoria p
	*/
	public java.lang.String getModificacion() {
		return _auditoriaP.getModificacion();
	}

	/**
	* Sets the modificacion of this auditoria p.
	*
	* @param modificacion the modificacion of this auditoria p
	*/
	public void setModificacion(java.lang.String modificacion) {
		_auditoriaP.setModificacion(modificacion);
	}

	public boolean isNew() {
		return _auditoriaP.isNew();
	}

	public void setNew(boolean n) {
		_auditoriaP.setNew(n);
	}

	public boolean isCachedModel() {
		return _auditoriaP.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_auditoriaP.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _auditoriaP.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _auditoriaP.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_auditoriaP.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _auditoriaP.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_auditoriaP.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new auditoriaPWrapper((auditoriaP)_auditoriaP.clone());
	}

	public int compareTo(co.com.csj.model.auditoriaP auditoriaP) {
		return _auditoriaP.compareTo(auditoriaP);
	}

	@Override
	public int hashCode() {
		return _auditoriaP.hashCode();
	}

	public com.liferay.portal.model.CacheModel<co.com.csj.model.auditoriaP> toCacheModel() {
		return _auditoriaP.toCacheModel();
	}

	public co.com.csj.model.auditoriaP toEscapedModel() {
		return new auditoriaPWrapper(_auditoriaP.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _auditoriaP.toString();
	}

	public java.lang.String toXmlString() {
		return _auditoriaP.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_auditoriaP.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public auditoriaP getWrappedauditoriaP() {
		return _auditoriaP;
	}

	public auditoriaP getWrappedModel() {
		return _auditoriaP;
	}

	public void resetOriginalValues() {
		_auditoriaP.resetOriginalValues();
	}

	private auditoriaP _auditoriaP;
}