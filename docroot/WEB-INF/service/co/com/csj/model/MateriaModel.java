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
 * The base model interface for the Materia service. Represents a row in the &quot;SJ_invest_materia&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link co.com.csj.model.impl.MateriaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link co.com.csj.model.impl.MateriaImpl}.
 * </p>
 *
 * @author villartech
 * @see Materia
 * @see co.com.csj.model.impl.MateriaImpl
 * @see co.com.csj.model.impl.MateriaModelImpl
 * @generated
 */
public interface MateriaModel extends BaseModel<Materia> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a materia model instance should use the {@link Materia} interface instead.
	 */

	/**
	 * Returns the primary key of this materia.
	 *
	 * @return the primary key of this materia
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this materia.
	 *
	 * @param primaryKey the primary key of this materia
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the ID of this materia.
	 *
	 * @return the ID of this materia
	 */
	@AutoEscape
	public String getId();

	/**
	 * Sets the ID of this materia.
	 *
	 * @param id the ID of this materia
	 */
	public void setId(String id);

	/**
	 * Returns the nombre of this materia.
	 *
	 * @return the nombre of this materia
	 */
	@AutoEscape
	public String getNombre();

	/**
	 * Sets the nombre of this materia.
	 *
	 * @param nombre the nombre of this materia
	 */
	public void setNombre(String nombre);

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

	public int compareTo(Materia materia);

	public int hashCode();

	public CacheModel<Materia> toCacheModel();

	public Materia toEscapedModel();

	public String toString();

	public String toXmlString();
}