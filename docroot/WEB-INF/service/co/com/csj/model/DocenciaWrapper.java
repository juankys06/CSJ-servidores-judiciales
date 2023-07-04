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
 * This class is a wrapper for {@link Docencia}.
 * </p>
 *
 * @author    villartech
 * @see       Docencia
 * @generated
 */
public class DocenciaWrapper implements Docencia, ModelWrapper<Docencia> {
	public DocenciaWrapper(Docencia docencia) {
		_docencia = docencia;
	}

	public Class<?> getModelClass() {
		return Docencia.class;
	}

	public String getModelClassName() {
		return Docencia.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("usuario_fk", getUsuario_fk());
		attributes.put("fechaInicial", getFechaInicial());
		attributes.put("fechaFinal", getFechaFinal());
		attributes.put("materia", getMateria());
		attributes.put("institucion", getInstitucion());
		attributes.put("despacho", getDespacho());
		attributes.put("creadoPor", getCreadoPor());
		attributes.put("modificadoPor", getModificadoPor());
		attributes.put("estatus", getEstatus());
		attributes.put("horas", getHoras());
		attributes.put("minutos", getMinutos());
		attributes.put("cargo", getCargo());
		attributes.put("fechaRegistro", getFechaRegistro());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String usuario_fk = (String)attributes.get("usuario_fk");

		if (usuario_fk != null) {
			setUsuario_fk(usuario_fk);
		}

		Date fechaInicial = (Date)attributes.get("fechaInicial");

		if (fechaInicial != null) {
			setFechaInicial(fechaInicial);
		}

		Date fechaFinal = (Date)attributes.get("fechaFinal");

		if (fechaFinal != null) {
			setFechaFinal(fechaFinal);
		}

		String materia = (String)attributes.get("materia");

		if (materia != null) {
			setMateria(materia);
		}

		String institucion = (String)attributes.get("institucion");

		if (institucion != null) {
			setInstitucion(institucion);
		}

		String despacho = (String)attributes.get("despacho");

		if (despacho != null) {
			setDespacho(despacho);
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

		Integer horas = (Integer)attributes.get("horas");

		if (horas != null) {
			setHoras(horas);
		}

		Integer minutos = (Integer)attributes.get("minutos");

		if (minutos != null) {
			setMinutos(minutos);
		}

		Integer cargo = (Integer)attributes.get("cargo");

		if (cargo != null) {
			setCargo(cargo);
		}

		Date fechaRegistro = (Date)attributes.get("fechaRegistro");

		if (fechaRegistro != null) {
			setFechaRegistro(fechaRegistro);
		}
	}

	/**
	* Returns the primary key of this docencia.
	*
	* @return the primary key of this docencia
	*/
	public long getPrimaryKey() {
		return _docencia.getPrimaryKey();
	}

	/**
	* Sets the primary key of this docencia.
	*
	* @param primaryKey the primary key of this docencia
	*/
	public void setPrimaryKey(long primaryKey) {
		_docencia.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this docencia.
	*
	* @return the ID of this docencia
	*/
	public long getId() {
		return _docencia.getId();
	}

	/**
	* Sets the ID of this docencia.
	*
	* @param id the ID of this docencia
	*/
	public void setId(long id) {
		_docencia.setId(id);
	}

	/**
	* Returns the usuario_fk of this docencia.
	*
	* @return the usuario_fk of this docencia
	*/
	public java.lang.String getUsuario_fk() {
		return _docencia.getUsuario_fk();
	}

	/**
	* Sets the usuario_fk of this docencia.
	*
	* @param usuario_fk the usuario_fk of this docencia
	*/
	public void setUsuario_fk(java.lang.String usuario_fk) {
		_docencia.setUsuario_fk(usuario_fk);
	}

	/**
	* Returns the fecha inicial of this docencia.
	*
	* @return the fecha inicial of this docencia
	*/
	public java.util.Date getFechaInicial() {
		return _docencia.getFechaInicial();
	}

	/**
	* Sets the fecha inicial of this docencia.
	*
	* @param fechaInicial the fecha inicial of this docencia
	*/
	public void setFechaInicial(java.util.Date fechaInicial) {
		_docencia.setFechaInicial(fechaInicial);
	}

	/**
	* Returns the fecha final of this docencia.
	*
	* @return the fecha final of this docencia
	*/
	public java.util.Date getFechaFinal() {
		return _docencia.getFechaFinal();
	}

	/**
	* Sets the fecha final of this docencia.
	*
	* @param fechaFinal the fecha final of this docencia
	*/
	public void setFechaFinal(java.util.Date fechaFinal) {
		_docencia.setFechaFinal(fechaFinal);
	}

	/**
	* Returns the materia of this docencia.
	*
	* @return the materia of this docencia
	*/
	public java.lang.String getMateria() {
		return _docencia.getMateria();
	}

	/**
	* Sets the materia of this docencia.
	*
	* @param materia the materia of this docencia
	*/
	public void setMateria(java.lang.String materia) {
		_docencia.setMateria(materia);
	}

	/**
	* Returns the institucion of this docencia.
	*
	* @return the institucion of this docencia
	*/
	public java.lang.String getInstitucion() {
		return _docencia.getInstitucion();
	}

	/**
	* Sets the institucion of this docencia.
	*
	* @param institucion the institucion of this docencia
	*/
	public void setInstitucion(java.lang.String institucion) {
		_docencia.setInstitucion(institucion);
	}

	/**
	* Returns the despacho of this docencia.
	*
	* @return the despacho of this docencia
	*/
	public java.lang.String getDespacho() {
		return _docencia.getDespacho();
	}

	/**
	* Sets the despacho of this docencia.
	*
	* @param despacho the despacho of this docencia
	*/
	public void setDespacho(java.lang.String despacho) {
		_docencia.setDespacho(despacho);
	}

	/**
	* Returns the creado por of this docencia.
	*
	* @return the creado por of this docencia
	*/
	public long getCreadoPor() {
		return _docencia.getCreadoPor();
	}

	/**
	* Sets the creado por of this docencia.
	*
	* @param creadoPor the creado por of this docencia
	*/
	public void setCreadoPor(long creadoPor) {
		_docencia.setCreadoPor(creadoPor);
	}

	/**
	* Returns the modificado por of this docencia.
	*
	* @return the modificado por of this docencia
	*/
	public long getModificadoPor() {
		return _docencia.getModificadoPor();
	}

	/**
	* Sets the modificado por of this docencia.
	*
	* @param modificadoPor the modificado por of this docencia
	*/
	public void setModificadoPor(long modificadoPor) {
		_docencia.setModificadoPor(modificadoPor);
	}

	/**
	* Returns the estatus of this docencia.
	*
	* @return the estatus of this docencia
	*/
	public int getEstatus() {
		return _docencia.getEstatus();
	}

	/**
	* Sets the estatus of this docencia.
	*
	* @param estatus the estatus of this docencia
	*/
	public void setEstatus(int estatus) {
		_docencia.setEstatus(estatus);
	}

	/**
	* Returns the horas of this docencia.
	*
	* @return the horas of this docencia
	*/
	public int getHoras() {
		return _docencia.getHoras();
	}

	/**
	* Sets the horas of this docencia.
	*
	* @param horas the horas of this docencia
	*/
	public void setHoras(int horas) {
		_docencia.setHoras(horas);
	}

	/**
	* Returns the minutos of this docencia.
	*
	* @return the minutos of this docencia
	*/
	public int getMinutos() {
		return _docencia.getMinutos();
	}

	/**
	* Sets the minutos of this docencia.
	*
	* @param minutos the minutos of this docencia
	*/
	public void setMinutos(int minutos) {
		_docencia.setMinutos(minutos);
	}

	/**
	* Returns the cargo of this docencia.
	*
	* @return the cargo of this docencia
	*/
	public int getCargo() {
		return _docencia.getCargo();
	}

	/**
	* Sets the cargo of this docencia.
	*
	* @param cargo the cargo of this docencia
	*/
	public void setCargo(int cargo) {
		_docencia.setCargo(cargo);
	}

	/**
	* Returns the fecha registro of this docencia.
	*
	* @return the fecha registro of this docencia
	*/
	public java.util.Date getFechaRegistro() {
		return _docencia.getFechaRegistro();
	}

	/**
	* Sets the fecha registro of this docencia.
	*
	* @param fechaRegistro the fecha registro of this docencia
	*/
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		_docencia.setFechaRegistro(fechaRegistro);
	}

	public boolean isNew() {
		return _docencia.isNew();
	}

	public void setNew(boolean n) {
		_docencia.setNew(n);
	}

	public boolean isCachedModel() {
		return _docencia.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_docencia.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _docencia.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _docencia.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_docencia.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _docencia.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_docencia.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DocenciaWrapper((Docencia)_docencia.clone());
	}

	public int compareTo(co.com.csj.model.Docencia docencia) {
		return _docencia.compareTo(docencia);
	}

	@Override
	public int hashCode() {
		return _docencia.hashCode();
	}

	public com.liferay.portal.model.CacheModel<co.com.csj.model.Docencia> toCacheModel() {
		return _docencia.toCacheModel();
	}

	public co.com.csj.model.Docencia toEscapedModel() {
		return new DocenciaWrapper(_docencia.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _docencia.toString();
	}

	public java.lang.String toXmlString() {
		return _docencia.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_docencia.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Docencia getWrappedDocencia() {
		return _docencia;
	}

	public Docencia getWrappedModel() {
		return _docencia;
	}

	public void resetOriginalValues() {
		_docencia.resetOriginalValues();
	}

	private Docencia _docencia;
}