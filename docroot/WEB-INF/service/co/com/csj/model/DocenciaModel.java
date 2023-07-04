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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Docencia service. Represents a row in the &quot;SJ_docencia&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link co.com.csj.model.impl.DocenciaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link co.com.csj.model.impl.DocenciaImpl}.
 * </p>
 *
 * @author villartech
 * @see Docencia
 * @see co.com.csj.model.impl.DocenciaImpl
 * @see co.com.csj.model.impl.DocenciaModelImpl
 * @generated
 */
public interface DocenciaModel extends BaseModel<Docencia> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a docencia model instance should use the {@link Docencia} interface instead.
	 */

	/**
	 * Returns the primary key of this docencia.
	 *
	 * @return the primary key of this docencia
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this docencia.
	 *
	 * @param primaryKey the primary key of this docencia
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this docencia.
	 *
	 * @return the ID of this docencia
	 */
	public long getId();

	/**
	 * Sets the ID of this docencia.
	 *
	 * @param id the ID of this docencia
	 */
	public void setId(long id);

	/**
	 * Returns the usuario_fk of this docencia.
	 *
	 * @return the usuario_fk of this docencia
	 */
	@AutoEscape
	public String getUsuario_fk();

	/**
	 * Sets the usuario_fk of this docencia.
	 *
	 * @param usuario_fk the usuario_fk of this docencia
	 */
	public void setUsuario_fk(String usuario_fk);

	/**
	 * Returns the fecha inicial of this docencia.
	 *
	 * @return the fecha inicial of this docencia
	 */
	public Date getFechaInicial();

	/**
	 * Sets the fecha inicial of this docencia.
	 *
	 * @param fechaInicial the fecha inicial of this docencia
	 */
	public void setFechaInicial(Date fechaInicial);

	/**
	 * Returns the fecha final of this docencia.
	 *
	 * @return the fecha final of this docencia
	 */
	public Date getFechaFinal();

	/**
	 * Sets the fecha final of this docencia.
	 *
	 * @param fechaFinal the fecha final of this docencia
	 */
	public void setFechaFinal(Date fechaFinal);

	/**
	 * Returns the materia of this docencia.
	 *
	 * @return the materia of this docencia
	 */
	@AutoEscape
	public String getMateria();

	/**
	 * Sets the materia of this docencia.
	 *
	 * @param materia the materia of this docencia
	 */
	public void setMateria(String materia);

	/**
	 * Returns the institucion of this docencia.
	 *
	 * @return the institucion of this docencia
	 */
	@AutoEscape
	public String getInstitucion();

	/**
	 * Sets the institucion of this docencia.
	 *
	 * @param institucion the institucion of this docencia
	 */
	public void setInstitucion(String institucion);

	/**
	 * Returns the despacho of this docencia.
	 *
	 * @return the despacho of this docencia
	 */
	@AutoEscape
	public String getDespacho();

	/**
	 * Sets the despacho of this docencia.
	 *
	 * @param despacho the despacho of this docencia
	 */
	public void setDespacho(String despacho);

	/**
	 * Returns the creado por of this docencia.
	 *
	 * @return the creado por of this docencia
	 */
	public long getCreadoPor();

	/**
	 * Sets the creado por of this docencia.
	 *
	 * @param creadoPor the creado por of this docencia
	 */
	public void setCreadoPor(long creadoPor);

	/**
	 * Returns the modificado por of this docencia.
	 *
	 * @return the modificado por of this docencia
	 */
	public long getModificadoPor();

	/**
	 * Sets the modificado por of this docencia.
	 *
	 * @param modificadoPor the modificado por of this docencia
	 */
	public void setModificadoPor(long modificadoPor);

	/**
	 * Returns the estatus of this docencia.
	 *
	 * @return the estatus of this docencia
	 */
	public int getEstatus();

	/**
	 * Sets the estatus of this docencia.
	 *
	 * @param estatus the estatus of this docencia
	 */
	public void setEstatus(int estatus);

	/**
	 * Returns the horas of this docencia.
	 *
	 * @return the horas of this docencia
	 */
	public int getHoras();

	/**
	 * Sets the horas of this docencia.
	 *
	 * @param horas the horas of this docencia
	 */
	public void setHoras(int horas);

	/**
	 * Returns the minutos of this docencia.
	 *
	 * @return the minutos of this docencia
	 */
	public int getMinutos();

	/**
	 * Sets the minutos of this docencia.
	 *
	 * @param minutos the minutos of this docencia
	 */
	public void setMinutos(int minutos);

	/**
	 * Returns the cargo of this docencia.
	 *
	 * @return the cargo of this docencia
	 */
	public int getCargo();

	/**
	 * Sets the cargo of this docencia.
	 *
	 * @param cargo the cargo of this docencia
	 */
	public void setCargo(int cargo);

	/**
	 * Returns the fecha registro of this docencia.
	 *
	 * @return the fecha registro of this docencia
	 */
	public Date getFechaRegistro();

	/**
	 * Sets the fecha registro of this docencia.
	 *
	 * @param fechaRegistro the fecha registro of this docencia
	 */
	public void setFechaRegistro(Date fechaRegistro);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Docencia docencia);

	public int hashCode();

	public CacheModel<Docencia> toCacheModel();

	public Docencia toEscapedModel();

	public String toString();

	public String toXmlString();
}