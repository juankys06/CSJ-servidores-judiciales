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
 * The base model interface for the permisos service. Represents a row in the &quot;SJ_permiso_usuario&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link co.com.csj.model.impl.permisosModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link co.com.csj.model.impl.permisosImpl}.
 * </p>
 *
 * @author villartech
 * @see permisos
 * @see co.com.csj.model.impl.permisosImpl
 * @see co.com.csj.model.impl.permisosModelImpl
 * @generated
 */
public interface permisosModel extends BaseModel<permisos> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a permisos model instance should use the {@link permisos} interface instead.
	 */

	/**
	 * Returns the primary key of this permisos.
	 *
	 * @return the primary key of this permisos
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this permisos.
	 *
	 * @param primaryKey the primary key of this permisos
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this permisos.
	 *
	 * @return the ID of this permisos
	 */
	public long getId();

	/**
	 * Sets the ID of this permisos.
	 *
	 * @param id the ID of this permisos
	 */
	public void setId(long id);

	/**
	 * Returns the cargo of this permisos.
	 *
	 * @return the cargo of this permisos
	 */
	@AutoEscape
	public String getCargo();

	/**
	 * Sets the cargo of this permisos.
	 *
	 * @param cargo the cargo of this permisos
	 */
	public void setCargo(String cargo);

	/**
	 * Returns the d_m of this permisos.
	 *
	 * @return the d_m of this permisos
	 */
	@AutoEscape
	public String getD_m();

	/**
	 * Sets the d_m of this permisos.
	 *
	 * @param d_m the d_m of this permisos
	 */
	public void setD_m(String d_m);

	/**
	 * Returns the usuario of this permisos.
	 *
	 * @return the usuario of this permisos
	 */
	@AutoEscape
	public String getUsuario();

	/**
	 * Sets the usuario of this permisos.
	 *
	 * @param usuario the usuario of this permisos
	 */
	public void setUsuario(String usuario);

	/**
	 * Returns the creacion of this permisos.
	 *
	 * @return the creacion of this permisos
	 */
	public Date getCreacion();

	/**
	 * Sets the creacion of this permisos.
	 *
	 * @param creacion the creacion of this permisos
	 */
	public void setCreacion(Date creacion);

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

	public int compareTo(permisos permisos);

	public int hashCode();

	public CacheModel<permisos> toCacheModel();

	public permisos toEscapedModel();

	public String toString();

	public String toXmlString();
}