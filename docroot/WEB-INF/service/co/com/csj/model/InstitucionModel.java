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

/**
 * The base model interface for the Institucion service. Represents a row in the &quot;SJ_institucion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link co.com.csj.model.impl.InstitucionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link co.com.csj.model.impl.InstitucionImpl}.
 * </p>
 *
 * @author villartech
 * @see Institucion
 * @see co.com.csj.model.impl.InstitucionImpl
 * @see co.com.csj.model.impl.InstitucionModelImpl
 * @generated
 */
public interface InstitucionModel extends BaseModel<Institucion> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a institucion model instance should use the {@link Institucion} interface instead.
	 */

	/**
	 * Returns the primary key of this institucion.
	 *
	 * @return the primary key of this institucion
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this institucion.
	 *
	 * @param primaryKey the primary key of this institucion
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this institucion.
	 *
	 * @return the ID of this institucion
	 */
	public long getId();

	/**
	 * Sets the ID of this institucion.
	 *
	 * @param id the ID of this institucion
	 */
	public void setId(long id);

	/**
	 * Returns the descripcion of this institucion.
	 *
	 * @return the descripcion of this institucion
	 */
	@AutoEscape
	public String getDescripcion();

	/**
	 * Sets the descripcion of this institucion.
	 *
	 * @param descripcion the descripcion of this institucion
	 */
	public void setDescripcion(String descripcion);

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

	public int compareTo(Institucion institucion);

	public int hashCode();

	public CacheModel<Institucion> toCacheModel();

	public Institucion toEscapedModel();

	public String toString();

	public String toXmlString();
}