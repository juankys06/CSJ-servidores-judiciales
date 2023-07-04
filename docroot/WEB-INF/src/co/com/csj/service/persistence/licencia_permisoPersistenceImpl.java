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

package co.com.csj.service.persistence;

import co.com.csj.NoSuchlicencia_permisoException;
import co.com.csj.model.impl.licencia_permisoImpl;
import co.com.csj.model.impl.licencia_permisoModelImpl;
import co.com.csj.model.licencia_permiso;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the licencia_permiso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see licencia_permisoPersistence
 * @see licencia_permisoUtil
 * @generated
 */
public class licencia_permisoPersistenceImpl extends BasePersistenceImpl<licencia_permiso>
	implements licencia_permisoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link licencia_permisoUtil} to access the licencia_permiso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = licencia_permisoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTIPO = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED,
			licencia_permisoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByporTipo",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTIPO =
		new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED,
			licencia_permisoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByporTipo",
			new String[] { Long.class.getName() },
			licencia_permisoModelImpl.TIPOFK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PORTIPO = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByporTipo",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATOR = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED,
			licencia_permisoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreator",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR =
		new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED,
			licencia_permisoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreator",
			new String[] { Long.class.getName() },
			licencia_permisoModelImpl.CREADOPOR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATOR = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreator",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSON = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED,
			licencia_permisoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPerson",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSON =
		new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED,
			licencia_permisoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPerson",
			new String[] { String.class.getName() },
			licencia_permisoModelImpl.USUARIOFK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PERSON = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPerson",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESTATUS = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED,
			licencia_permisoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEstatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESTATUS =
		new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED,
			licencia_permisoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEstatus",
			new String[] { Integer.class.getName() },
			licencia_permisoModelImpl.ESTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESTATUS = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEstatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESPACHO = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED,
			licencia_permisoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDespacho",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESPACHO =
		new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED,
			licencia_permisoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDespacho",
			new String[] { String.class.getName() },
			licencia_permisoModelImpl.DESPACHO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESPACHO = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDespacho",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED,
			licencia_permisoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED,
			licencia_permisoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the licencia_permiso in the entity cache if it is enabled.
	 *
	 * @param licencia_permiso the licencia_permiso
	 */
	public void cacheResult(licencia_permiso licencia_permiso) {
		EntityCacheUtil.putResult(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoImpl.class, licencia_permiso.getPrimaryKey(),
			licencia_permiso);

		licencia_permiso.resetOriginalValues();
	}

	/**
	 * Caches the licencia_permisos in the entity cache if it is enabled.
	 *
	 * @param licencia_permisos the licencia_permisos
	 */
	public void cacheResult(List<licencia_permiso> licencia_permisos) {
		for (licencia_permiso licencia_permiso : licencia_permisos) {
			if (EntityCacheUtil.getResult(
						licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
						licencia_permisoImpl.class,
						licencia_permiso.getPrimaryKey()) == null) {
				cacheResult(licencia_permiso);
			}
			else {
				licencia_permiso.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all licencia_permisos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(licencia_permisoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(licencia_permisoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the licencia_permiso.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(licencia_permiso licencia_permiso) {
		EntityCacheUtil.removeResult(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoImpl.class, licencia_permiso.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<licencia_permiso> licencia_permisos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (licencia_permiso licencia_permiso : licencia_permisos) {
			EntityCacheUtil.removeResult(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
				licencia_permisoImpl.class, licencia_permiso.getPrimaryKey());
		}
	}

	/**
	 * Creates a new licencia_permiso with the primary key. Does not add the licencia_permiso to the database.
	 *
	 * @param id the primary key for the new licencia_permiso
	 * @return the new licencia_permiso
	 */
	public licencia_permiso create(long id) {
		licencia_permiso licencia_permiso = new licencia_permisoImpl();

		licencia_permiso.setNew(true);
		licencia_permiso.setPrimaryKey(id);

		return licencia_permiso;
	}

	/**
	 * Removes the licencia_permiso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the licencia_permiso
	 * @return the licencia_permiso that was removed
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso remove(long id)
		throws NoSuchlicencia_permisoException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the licencia_permiso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the licencia_permiso
	 * @return the licencia_permiso that was removed
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public licencia_permiso remove(Serializable primaryKey)
		throws NoSuchlicencia_permisoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			licencia_permiso licencia_permiso = (licencia_permiso)session.get(licencia_permisoImpl.class,
					primaryKey);

			if (licencia_permiso == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchlicencia_permisoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(licencia_permiso);
		}
		catch (NoSuchlicencia_permisoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected licencia_permiso removeImpl(licencia_permiso licencia_permiso)
		throws SystemException {
		licencia_permiso = toUnwrappedModel(licencia_permiso);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, licencia_permiso);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(licencia_permiso);

		return licencia_permiso;
	}

	@Override
	public licencia_permiso updateImpl(
		co.com.csj.model.licencia_permiso licencia_permiso, boolean merge)
		throws SystemException {
		licencia_permiso = toUnwrappedModel(licencia_permiso);

		boolean isNew = licencia_permiso.isNew();

		licencia_permisoModelImpl licencia_permisoModelImpl = (licencia_permisoModelImpl)licencia_permiso;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, licencia_permiso, merge);

			licencia_permiso.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !licencia_permisoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((licencia_permisoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTIPO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(licencia_permisoModelImpl.getOriginalTipofk())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTIPO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTIPO,
					args);

				args = new Object[] {
						Long.valueOf(licencia_permisoModelImpl.getTipofk())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PORTIPO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTIPO,
					args);
			}

			if ((licencia_permisoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(licencia_permisoModelImpl.getOriginalCreadoPor())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR,
					args);

				args = new Object[] {
						Long.valueOf(licencia_permisoModelImpl.getCreadoPor())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR,
					args);
			}

			if ((licencia_permisoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSON.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						licencia_permisoModelImpl.getOriginalUsuariofk()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSON, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSON,
					args);

				args = new Object[] { licencia_permisoModelImpl.getUsuariofk() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PERSON, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSON,
					args);
			}

			if ((licencia_permisoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(licencia_permisoModelImpl.getOriginalEstatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESTATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESTATUS,
					args);

				args = new Object[] {
						Integer.valueOf(licencia_permisoModelImpl.getEstatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESTATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESTATUS,
					args);
			}

			if ((licencia_permisoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESPACHO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						licencia_permisoModelImpl.getOriginalDespacho()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESPACHO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESPACHO,
					args);

				args = new Object[] { licencia_permisoModelImpl.getDespacho() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESPACHO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESPACHO,
					args);
			}
		}

		EntityCacheUtil.putResult(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
			licencia_permisoImpl.class, licencia_permiso.getPrimaryKey(),
			licencia_permiso);

		return licencia_permiso;
	}

	protected licencia_permiso toUnwrappedModel(
		licencia_permiso licencia_permiso) {
		if (licencia_permiso instanceof licencia_permisoImpl) {
			return licencia_permiso;
		}

		licencia_permisoImpl licencia_permisoImpl = new licencia_permisoImpl();

		licencia_permisoImpl.setNew(licencia_permiso.isNew());
		licencia_permisoImpl.setPrimaryKey(licencia_permiso.getPrimaryKey());

		licencia_permisoImpl.setId(licencia_permiso.getId());
		licencia_permisoImpl.setFechainicio(licencia_permiso.getFechainicio());
		licencia_permisoImpl.setFechafin(licencia_permiso.getFechafin());
		licencia_permisoImpl.setUsuariofk(licencia_permiso.getUsuariofk());
		licencia_permisoImpl.setTipofk(licencia_permiso.getTipofk());
		licencia_permisoImpl.setActoadmin(licencia_permiso.getActoadmin());
		licencia_permisoImpl.setCreadoPor(licencia_permiso.getCreadoPor());
		licencia_permisoImpl.setModificadoPor(licencia_permiso.getModificadoPor());
		licencia_permisoImpl.setEstatus(licencia_permiso.getEstatus());
		licencia_permisoImpl.setDespacho(licencia_permiso.getDespacho());
		licencia_permisoImpl.setCargo(licencia_permiso.getCargo());
		licencia_permisoImpl.setHoras(licencia_permiso.getHoras());
		licencia_permisoImpl.setMinutos(licencia_permiso.getMinutos());
		licencia_permisoImpl.setFechaRegistro(licencia_permiso.getFechaRegistro());

		return licencia_permisoImpl;
	}

	/**
	 * Returns the licencia_permiso with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the licencia_permiso
	 * @return the licencia_permiso
	 * @throws com.liferay.portal.NoSuchModelException if a licencia_permiso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public licencia_permiso findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the licencia_permiso with the primary key or throws a {@link co.com.csj.NoSuchlicencia_permisoException} if it could not be found.
	 *
	 * @param id the primary key of the licencia_permiso
	 * @return the licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso findByPrimaryKey(long id)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = fetchByPrimaryKey(id);

		if (licencia_permiso == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchlicencia_permisoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return licencia_permiso;
	}

	/**
	 * Returns the licencia_permiso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the licencia_permiso
	 * @return the licencia_permiso, or <code>null</code> if a licencia_permiso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public licencia_permiso fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the licencia_permiso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the licencia_permiso
	 * @return the licencia_permiso, or <code>null</code> if a licencia_permiso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso fetchByPrimaryKey(long id)
		throws SystemException {
		licencia_permiso licencia_permiso = (licencia_permiso)EntityCacheUtil.getResult(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
				licencia_permisoImpl.class, id);

		if (licencia_permiso == _nulllicencia_permiso) {
			return null;
		}

		if (licencia_permiso == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				licencia_permiso = (licencia_permiso)session.get(licencia_permisoImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (licencia_permiso != null) {
					cacheResult(licencia_permiso);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(licencia_permisoModelImpl.ENTITY_CACHE_ENABLED,
						licencia_permisoImpl.class, id, _nulllicencia_permiso);
				}

				closeSession(session);
			}
		}

		return licencia_permiso;
	}

	/**
	 * Returns all the licencia_permisos where tipofk = &#63;.
	 *
	 * @param tipofk the tipofk
	 * @return the matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByporTipo(long tipofk)
		throws SystemException {
		return findByporTipo(tipofk, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the licencia_permisos where tipofk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tipofk the tipofk
	 * @param start the lower bound of the range of licencia_permisos
	 * @param end the upper bound of the range of licencia_permisos (not inclusive)
	 * @return the range of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByporTipo(long tipofk, int start, int end)
		throws SystemException {
		return findByporTipo(tipofk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the licencia_permisos where tipofk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tipofk the tipofk
	 * @param start the lower bound of the range of licencia_permisos
	 * @param end the upper bound of the range of licencia_permisos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByporTipo(long tipofk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PORTIPO;
			finderArgs = new Object[] { tipofk };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PORTIPO;
			finderArgs = new Object[] { tipofk, start, end, orderByComparator };
		}

		List<licencia_permiso> list = (List<licencia_permiso>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (licencia_permiso licencia_permiso : list) {
				if ((tipofk != licencia_permiso.getTipofk())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LICENCIA_PERMISO_WHERE);

			query.append(_FINDER_COLUMN_PORTIPO_TIPOFK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(licencia_permisoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tipofk);

				list = (List<licencia_permiso>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first licencia_permiso in the ordered set where tipofk = &#63;.
	 *
	 * @param tipofk the tipofk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso findByporTipo_First(long tipofk,
		OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = fetchByporTipo_First(tipofk,
				orderByComparator);

		if (licencia_permiso != null) {
			return licencia_permiso;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipofk=");
		msg.append(tipofk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchlicencia_permisoException(msg.toString());
	}

	/**
	 * Returns the first licencia_permiso in the ordered set where tipofk = &#63;.
	 *
	 * @param tipofk the tipofk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso fetchByporTipo_First(long tipofk,
		OrderByComparator orderByComparator) throws SystemException {
		List<licencia_permiso> list = findByporTipo(tipofk, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last licencia_permiso in the ordered set where tipofk = &#63;.
	 *
	 * @param tipofk the tipofk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso findByporTipo_Last(long tipofk,
		OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = fetchByporTipo_Last(tipofk,
				orderByComparator);

		if (licencia_permiso != null) {
			return licencia_permiso;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("tipofk=");
		msg.append(tipofk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchlicencia_permisoException(msg.toString());
	}

	/**
	 * Returns the last licencia_permiso in the ordered set where tipofk = &#63;.
	 *
	 * @param tipofk the tipofk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso fetchByporTipo_Last(long tipofk,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByporTipo(tipofk);

		List<licencia_permiso> list = findByporTipo(tipofk, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the licencia_permisos before and after the current licencia_permiso in the ordered set where tipofk = &#63;.
	 *
	 * @param id the primary key of the current licencia_permiso
	 * @param tipofk the tipofk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso[] findByporTipo_PrevAndNext(long id, long tipofk,
		OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			licencia_permiso[] array = new licencia_permisoImpl[3];

			array[0] = getByporTipo_PrevAndNext(session, licencia_permiso,
					tipofk, orderByComparator, true);

			array[1] = licencia_permiso;

			array[2] = getByporTipo_PrevAndNext(session, licencia_permiso,
					tipofk, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected licencia_permiso getByporTipo_PrevAndNext(Session session,
		licencia_permiso licencia_permiso, long tipofk,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LICENCIA_PERMISO_WHERE);

		query.append(_FINDER_COLUMN_PORTIPO_TIPOFK_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(licencia_permisoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tipofk);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(licencia_permiso);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<licencia_permiso> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the licencia_permisos where creadoPor = &#63;.
	 *
	 * @param creadoPor the creado por
	 * @return the matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByCreator(long creadoPor)
		throws SystemException {
		return findByCreator(creadoPor, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the licencia_permisos where creadoPor = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param creadoPor the creado por
	 * @param start the lower bound of the range of licencia_permisos
	 * @param end the upper bound of the range of licencia_permisos (not inclusive)
	 * @return the range of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByCreator(long creadoPor, int start,
		int end) throws SystemException {
		return findByCreator(creadoPor, start, end, null);
	}

	/**
	 * Returns an ordered range of all the licencia_permisos where creadoPor = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param creadoPor the creado por
	 * @param start the lower bound of the range of licencia_permisos
	 * @param end the upper bound of the range of licencia_permisos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByCreator(long creadoPor, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR;
			finderArgs = new Object[] { creadoPor };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATOR;
			finderArgs = new Object[] { creadoPor, start, end, orderByComparator };
		}

		List<licencia_permiso> list = (List<licencia_permiso>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (licencia_permiso licencia_permiso : list) {
				if ((creadoPor != licencia_permiso.getCreadoPor())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LICENCIA_PERMISO_WHERE);

			query.append(_FINDER_COLUMN_CREATOR_CREADOPOR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(licencia_permisoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creadoPor);

				list = (List<licencia_permiso>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first licencia_permiso in the ordered set where creadoPor = &#63;.
	 *
	 * @param creadoPor the creado por
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso findByCreator_First(long creadoPor,
		OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = fetchByCreator_First(creadoPor,
				orderByComparator);

		if (licencia_permiso != null) {
			return licencia_permiso;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creadoPor=");
		msg.append(creadoPor);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchlicencia_permisoException(msg.toString());
	}

	/**
	 * Returns the first licencia_permiso in the ordered set where creadoPor = &#63;.
	 *
	 * @param creadoPor the creado por
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso fetchByCreator_First(long creadoPor,
		OrderByComparator orderByComparator) throws SystemException {
		List<licencia_permiso> list = findByCreator(creadoPor, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last licencia_permiso in the ordered set where creadoPor = &#63;.
	 *
	 * @param creadoPor the creado por
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso findByCreator_Last(long creadoPor,
		OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = fetchByCreator_Last(creadoPor,
				orderByComparator);

		if (licencia_permiso != null) {
			return licencia_permiso;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creadoPor=");
		msg.append(creadoPor);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchlicencia_permisoException(msg.toString());
	}

	/**
	 * Returns the last licencia_permiso in the ordered set where creadoPor = &#63;.
	 *
	 * @param creadoPor the creado por
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso fetchByCreator_Last(long creadoPor,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCreator(creadoPor);

		List<licencia_permiso> list = findByCreator(creadoPor, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the licencia_permisos before and after the current licencia_permiso in the ordered set where creadoPor = &#63;.
	 *
	 * @param id the primary key of the current licencia_permiso
	 * @param creadoPor the creado por
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso[] findByCreator_PrevAndNext(long id,
		long creadoPor, OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			licencia_permiso[] array = new licencia_permisoImpl[3];

			array[0] = getByCreator_PrevAndNext(session, licencia_permiso,
					creadoPor, orderByComparator, true);

			array[1] = licencia_permiso;

			array[2] = getByCreator_PrevAndNext(session, licencia_permiso,
					creadoPor, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected licencia_permiso getByCreator_PrevAndNext(Session session,
		licencia_permiso licencia_permiso, long creadoPor,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LICENCIA_PERMISO_WHERE);

		query.append(_FINDER_COLUMN_CREATOR_CREADOPOR_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(licencia_permisoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(creadoPor);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(licencia_permiso);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<licencia_permiso> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the licencia_permisos where usuariofk = &#63;.
	 *
	 * @param usuariofk the usuariofk
	 * @return the matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByPerson(String usuariofk)
		throws SystemException {
		return findByPerson(usuariofk, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the licencia_permisos where usuariofk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param usuariofk the usuariofk
	 * @param start the lower bound of the range of licencia_permisos
	 * @param end the upper bound of the range of licencia_permisos (not inclusive)
	 * @return the range of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByPerson(String usuariofk, int start,
		int end) throws SystemException {
		return findByPerson(usuariofk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the licencia_permisos where usuariofk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param usuariofk the usuariofk
	 * @param start the lower bound of the range of licencia_permisos
	 * @param end the upper bound of the range of licencia_permisos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByPerson(String usuariofk, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PERSON;
			finderArgs = new Object[] { usuariofk };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PERSON;
			finderArgs = new Object[] { usuariofk, start, end, orderByComparator };
		}

		List<licencia_permiso> list = (List<licencia_permiso>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (licencia_permiso licencia_permiso : list) {
				if (!Validator.equals(usuariofk, licencia_permiso.getUsuariofk())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LICENCIA_PERMISO_WHERE);

			if (usuariofk == null) {
				query.append(_FINDER_COLUMN_PERSON_USUARIOFK_1);
			}
			else {
				if (usuariofk.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PERSON_USUARIOFK_3);
				}
				else {
					query.append(_FINDER_COLUMN_PERSON_USUARIOFK_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(licencia_permisoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (usuariofk != null) {
					qPos.add(usuariofk);
				}

				list = (List<licencia_permiso>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first licencia_permiso in the ordered set where usuariofk = &#63;.
	 *
	 * @param usuariofk the usuariofk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso findByPerson_First(String usuariofk,
		OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = fetchByPerson_First(usuariofk,
				orderByComparator);

		if (licencia_permiso != null) {
			return licencia_permiso;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("usuariofk=");
		msg.append(usuariofk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchlicencia_permisoException(msg.toString());
	}

	/**
	 * Returns the first licencia_permiso in the ordered set where usuariofk = &#63;.
	 *
	 * @param usuariofk the usuariofk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso fetchByPerson_First(String usuariofk,
		OrderByComparator orderByComparator) throws SystemException {
		List<licencia_permiso> list = findByPerson(usuariofk, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last licencia_permiso in the ordered set where usuariofk = &#63;.
	 *
	 * @param usuariofk the usuariofk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso findByPerson_Last(String usuariofk,
		OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = fetchByPerson_Last(usuariofk,
				orderByComparator);

		if (licencia_permiso != null) {
			return licencia_permiso;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("usuariofk=");
		msg.append(usuariofk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchlicencia_permisoException(msg.toString());
	}

	/**
	 * Returns the last licencia_permiso in the ordered set where usuariofk = &#63;.
	 *
	 * @param usuariofk the usuariofk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso fetchByPerson_Last(String usuariofk,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPerson(usuariofk);

		List<licencia_permiso> list = findByPerson(usuariofk, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the licencia_permisos before and after the current licencia_permiso in the ordered set where usuariofk = &#63;.
	 *
	 * @param id the primary key of the current licencia_permiso
	 * @param usuariofk the usuariofk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso[] findByPerson_PrevAndNext(long id,
		String usuariofk, OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			licencia_permiso[] array = new licencia_permisoImpl[3];

			array[0] = getByPerson_PrevAndNext(session, licencia_permiso,
					usuariofk, orderByComparator, true);

			array[1] = licencia_permiso;

			array[2] = getByPerson_PrevAndNext(session, licencia_permiso,
					usuariofk, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected licencia_permiso getByPerson_PrevAndNext(Session session,
		licencia_permiso licencia_permiso, String usuariofk,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LICENCIA_PERMISO_WHERE);

		if (usuariofk == null) {
			query.append(_FINDER_COLUMN_PERSON_USUARIOFK_1);
		}
		else {
			if (usuariofk.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PERSON_USUARIOFK_3);
			}
			else {
				query.append(_FINDER_COLUMN_PERSON_USUARIOFK_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(licencia_permisoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (usuariofk != null) {
			qPos.add(usuariofk);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(licencia_permiso);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<licencia_permiso> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the licencia_permisos where estatus = &#63;.
	 *
	 * @param estatus the estatus
	 * @return the matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByEstatus(int estatus)
		throws SystemException {
		return findByEstatus(estatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the licencia_permisos where estatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param estatus the estatus
	 * @param start the lower bound of the range of licencia_permisos
	 * @param end the upper bound of the range of licencia_permisos (not inclusive)
	 * @return the range of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByEstatus(int estatus, int start, int end)
		throws SystemException {
		return findByEstatus(estatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the licencia_permisos where estatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param estatus the estatus
	 * @param start the lower bound of the range of licencia_permisos
	 * @param end the upper bound of the range of licencia_permisos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByEstatus(int estatus, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESTATUS;
			finderArgs = new Object[] { estatus };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ESTATUS;
			finderArgs = new Object[] { estatus, start, end, orderByComparator };
		}

		List<licencia_permiso> list = (List<licencia_permiso>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (licencia_permiso licencia_permiso : list) {
				if ((estatus != licencia_permiso.getEstatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LICENCIA_PERMISO_WHERE);

			query.append(_FINDER_COLUMN_ESTATUS_ESTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(licencia_permisoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(estatus);

				list = (List<licencia_permiso>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first licencia_permiso in the ordered set where estatus = &#63;.
	 *
	 * @param estatus the estatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso findByEstatus_First(int estatus,
		OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = fetchByEstatus_First(estatus,
				orderByComparator);

		if (licencia_permiso != null) {
			return licencia_permiso;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("estatus=");
		msg.append(estatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchlicencia_permisoException(msg.toString());
	}

	/**
	 * Returns the first licencia_permiso in the ordered set where estatus = &#63;.
	 *
	 * @param estatus the estatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso fetchByEstatus_First(int estatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<licencia_permiso> list = findByEstatus(estatus, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last licencia_permiso in the ordered set where estatus = &#63;.
	 *
	 * @param estatus the estatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso findByEstatus_Last(int estatus,
		OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = fetchByEstatus_Last(estatus,
				orderByComparator);

		if (licencia_permiso != null) {
			return licencia_permiso;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("estatus=");
		msg.append(estatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchlicencia_permisoException(msg.toString());
	}

	/**
	 * Returns the last licencia_permiso in the ordered set where estatus = &#63;.
	 *
	 * @param estatus the estatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso fetchByEstatus_Last(int estatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEstatus(estatus);

		List<licencia_permiso> list = findByEstatus(estatus, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the licencia_permisos before and after the current licencia_permiso in the ordered set where estatus = &#63;.
	 *
	 * @param id the primary key of the current licencia_permiso
	 * @param estatus the estatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso[] findByEstatus_PrevAndNext(long id, int estatus,
		OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			licencia_permiso[] array = new licencia_permisoImpl[3];

			array[0] = getByEstatus_PrevAndNext(session, licencia_permiso,
					estatus, orderByComparator, true);

			array[1] = licencia_permiso;

			array[2] = getByEstatus_PrevAndNext(session, licencia_permiso,
					estatus, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected licencia_permiso getByEstatus_PrevAndNext(Session session,
		licencia_permiso licencia_permiso, int estatus,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LICENCIA_PERMISO_WHERE);

		query.append(_FINDER_COLUMN_ESTATUS_ESTATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(licencia_permisoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(estatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(licencia_permiso);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<licencia_permiso> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the licencia_permisos where despacho = &#63;.
	 *
	 * @param despacho the despacho
	 * @return the matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByDespacho(String despacho)
		throws SystemException {
		return findByDespacho(despacho, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the licencia_permisos where despacho = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param despacho the despacho
	 * @param start the lower bound of the range of licencia_permisos
	 * @param end the upper bound of the range of licencia_permisos (not inclusive)
	 * @return the range of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByDespacho(String despacho, int start,
		int end) throws SystemException {
		return findByDespacho(despacho, start, end, null);
	}

	/**
	 * Returns an ordered range of all the licencia_permisos where despacho = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param despacho the despacho
	 * @param start the lower bound of the range of licencia_permisos
	 * @param end the upper bound of the range of licencia_permisos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findByDespacho(String despacho, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESPACHO;
			finderArgs = new Object[] { despacho };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DESPACHO;
			finderArgs = new Object[] { despacho, start, end, orderByComparator };
		}

		List<licencia_permiso> list = (List<licencia_permiso>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (licencia_permiso licencia_permiso : list) {
				if (!Validator.equals(despacho, licencia_permiso.getDespacho())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LICENCIA_PERMISO_WHERE);

			if (despacho == null) {
				query.append(_FINDER_COLUMN_DESPACHO_DESPACHO_1);
			}
			else {
				if (despacho.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DESPACHO_DESPACHO_3);
				}
				else {
					query.append(_FINDER_COLUMN_DESPACHO_DESPACHO_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(licencia_permisoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (despacho != null) {
					qPos.add(despacho);
				}

				list = (List<licencia_permiso>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first licencia_permiso in the ordered set where despacho = &#63;.
	 *
	 * @param despacho the despacho
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso findByDespacho_First(String despacho,
		OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = fetchByDespacho_First(despacho,
				orderByComparator);

		if (licencia_permiso != null) {
			return licencia_permiso;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("despacho=");
		msg.append(despacho);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchlicencia_permisoException(msg.toString());
	}

	/**
	 * Returns the first licencia_permiso in the ordered set where despacho = &#63;.
	 *
	 * @param despacho the despacho
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso fetchByDespacho_First(String despacho,
		OrderByComparator orderByComparator) throws SystemException {
		List<licencia_permiso> list = findByDespacho(despacho, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last licencia_permiso in the ordered set where despacho = &#63;.
	 *
	 * @param despacho the despacho
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso findByDespacho_Last(String despacho,
		OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = fetchByDespacho_Last(despacho,
				orderByComparator);

		if (licencia_permiso != null) {
			return licencia_permiso;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("despacho=");
		msg.append(despacho);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchlicencia_permisoException(msg.toString());
	}

	/**
	 * Returns the last licencia_permiso in the ordered set where despacho = &#63;.
	 *
	 * @param despacho the despacho
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching licencia_permiso, or <code>null</code> if a matching licencia_permiso could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso fetchByDespacho_Last(String despacho,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDespacho(despacho);

		List<licencia_permiso> list = findByDespacho(despacho, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the licencia_permisos before and after the current licencia_permiso in the ordered set where despacho = &#63;.
	 *
	 * @param id the primary key of the current licencia_permiso
	 * @param despacho the despacho
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next licencia_permiso
	 * @throws co.com.csj.NoSuchlicencia_permisoException if a licencia_permiso with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public licencia_permiso[] findByDespacho_PrevAndNext(long id,
		String despacho, OrderByComparator orderByComparator)
		throws NoSuchlicencia_permisoException, SystemException {
		licencia_permiso licencia_permiso = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			licencia_permiso[] array = new licencia_permisoImpl[3];

			array[0] = getByDespacho_PrevAndNext(session, licencia_permiso,
					despacho, orderByComparator, true);

			array[1] = licencia_permiso;

			array[2] = getByDespacho_PrevAndNext(session, licencia_permiso,
					despacho, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected licencia_permiso getByDespacho_PrevAndNext(Session session,
		licencia_permiso licencia_permiso, String despacho,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LICENCIA_PERMISO_WHERE);

		if (despacho == null) {
			query.append(_FINDER_COLUMN_DESPACHO_DESPACHO_1);
		}
		else {
			if (despacho.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESPACHO_DESPACHO_3);
			}
			else {
				query.append(_FINDER_COLUMN_DESPACHO_DESPACHO_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(licencia_permisoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (despacho != null) {
			qPos.add(despacho);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(licencia_permiso);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<licencia_permiso> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the licencia_permisos.
	 *
	 * @return the licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the licencia_permisos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of licencia_permisos
	 * @param end the upper bound of the range of licencia_permisos (not inclusive)
	 * @return the range of licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the licencia_permisos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of licencia_permisos
	 * @param end the upper bound of the range of licencia_permisos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public List<licencia_permiso> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<licencia_permiso> list = (List<licencia_permiso>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LICENCIA_PERMISO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LICENCIA_PERMISO.concat(licencia_permisoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<licencia_permiso>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<licencia_permiso>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the licencia_permisos where tipofk = &#63; from the database.
	 *
	 * @param tipofk the tipofk
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByporTipo(long tipofk) throws SystemException {
		for (licencia_permiso licencia_permiso : findByporTipo(tipofk)) {
			remove(licencia_permiso);
		}
	}

	/**
	 * Removes all the licencia_permisos where creadoPor = &#63; from the database.
	 *
	 * @param creadoPor the creado por
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCreator(long creadoPor) throws SystemException {
		for (licencia_permiso licencia_permiso : findByCreator(creadoPor)) {
			remove(licencia_permiso);
		}
	}

	/**
	 * Removes all the licencia_permisos where usuariofk = &#63; from the database.
	 *
	 * @param usuariofk the usuariofk
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByPerson(String usuariofk) throws SystemException {
		for (licencia_permiso licencia_permiso : findByPerson(usuariofk)) {
			remove(licencia_permiso);
		}
	}

	/**
	 * Removes all the licencia_permisos where estatus = &#63; from the database.
	 *
	 * @param estatus the estatus
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEstatus(int estatus) throws SystemException {
		for (licencia_permiso licencia_permiso : findByEstatus(estatus)) {
			remove(licencia_permiso);
		}
	}

	/**
	 * Removes all the licencia_permisos where despacho = &#63; from the database.
	 *
	 * @param despacho the despacho
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDespacho(String despacho) throws SystemException {
		for (licencia_permiso licencia_permiso : findByDespacho(despacho)) {
			remove(licencia_permiso);
		}
	}

	/**
	 * Removes all the licencia_permisos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (licencia_permiso licencia_permiso : findAll()) {
			remove(licencia_permiso);
		}
	}

	/**
	 * Returns the number of licencia_permisos where tipofk = &#63;.
	 *
	 * @param tipofk the tipofk
	 * @return the number of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByporTipo(long tipofk) throws SystemException {
		Object[] finderArgs = new Object[] { tipofk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PORTIPO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICENCIA_PERMISO_WHERE);

			query.append(_FINDER_COLUMN_PORTIPO_TIPOFK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tipofk);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PORTIPO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of licencia_permisos where creadoPor = &#63;.
	 *
	 * @param creadoPor the creado por
	 * @return the number of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCreator(long creadoPor) throws SystemException {
		Object[] finderArgs = new Object[] { creadoPor };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATOR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICENCIA_PERMISO_WHERE);

			query.append(_FINDER_COLUMN_CREATOR_CREADOPOR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creadoPor);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREATOR,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of licencia_permisos where usuariofk = &#63;.
	 *
	 * @param usuariofk the usuariofk
	 * @return the number of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByPerson(String usuariofk) throws SystemException {
		Object[] finderArgs = new Object[] { usuariofk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PERSON,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICENCIA_PERMISO_WHERE);

			if (usuariofk == null) {
				query.append(_FINDER_COLUMN_PERSON_USUARIOFK_1);
			}
			else {
				if (usuariofk.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_PERSON_USUARIOFK_3);
				}
				else {
					query.append(_FINDER_COLUMN_PERSON_USUARIOFK_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (usuariofk != null) {
					qPos.add(usuariofk);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PERSON,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of licencia_permisos where estatus = &#63;.
	 *
	 * @param estatus the estatus
	 * @return the number of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEstatus(int estatus) throws SystemException {
		Object[] finderArgs = new Object[] { estatus };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ESTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICENCIA_PERMISO_WHERE);

			query.append(_FINDER_COLUMN_ESTATUS_ESTATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(estatus);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ESTATUS,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of licencia_permisos where despacho = &#63;.
	 *
	 * @param despacho the despacho
	 * @return the number of matching licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDespacho(String despacho) throws SystemException {
		Object[] finderArgs = new Object[] { despacho };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DESPACHO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LICENCIA_PERMISO_WHERE);

			if (despacho == null) {
				query.append(_FINDER_COLUMN_DESPACHO_DESPACHO_1);
			}
			else {
				if (despacho.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DESPACHO_DESPACHO_3);
				}
				else {
					query.append(_FINDER_COLUMN_DESPACHO_DESPACHO_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (despacho != null) {
					qPos.add(despacho);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DESPACHO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of licencia_permisos.
	 *
	 * @return the number of licencia_permisos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LICENCIA_PERMISO);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the licencia_permiso persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.co.com.csj.model.licencia_permiso")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<licencia_permiso>> listenersList = new ArrayList<ModelListener<licencia_permiso>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<licencia_permiso>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(licencia_permisoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = alertaPersistence.class)
	protected alertaPersistence alertaPersistence;
	@BeanReference(type = auditoriaPPersistence.class)
	protected auditoriaPPersistence auditoriaPPersistence;
	@BeanReference(type = cargoPersistence.class)
	protected cargoPersistence cargoPersistence;
	@BeanReference(type = DocenciaPersistence.class)
	protected DocenciaPersistence docenciaPersistence;
	@BeanReference(type = licencia_permisoPersistence.class)
	protected licencia_permisoPersistence licencia_permisoPersistence;
	@BeanReference(type = permisosPersistence.class)
	protected permisosPersistence permisosPersistence;
	@BeanReference(type = tipoPersistence.class)
	protected tipoPersistence tipoPersistence;
	@BeanReference(type = tipo_documentoPersistence.class)
	protected tipo_documentoPersistence tipo_documentoPersistence;
	@BeanReference(type = usuarioPersistence.class)
	protected usuarioPersistence usuarioPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LICENCIA_PERMISO = "SELECT licencia_permiso FROM licencia_permiso licencia_permiso";
	private static final String _SQL_SELECT_LICENCIA_PERMISO_WHERE = "SELECT licencia_permiso FROM licencia_permiso licencia_permiso WHERE ";
	private static final String _SQL_COUNT_LICENCIA_PERMISO = "SELECT COUNT(licencia_permiso) FROM licencia_permiso licencia_permiso";
	private static final String _SQL_COUNT_LICENCIA_PERMISO_WHERE = "SELECT COUNT(licencia_permiso) FROM licencia_permiso licencia_permiso WHERE ";
	private static final String _FINDER_COLUMN_PORTIPO_TIPOFK_2 = "licencia_permiso.tipofk = ? AND licencia_permiso.estatus = 1";
	private static final String _FINDER_COLUMN_CREATOR_CREADOPOR_2 = "licencia_permiso.creadoPor = ? AND licencia_permiso.estatus = 1";
	private static final String _FINDER_COLUMN_PERSON_USUARIOFK_1 = "licencia_permiso.usuariofk IS NULL AND licencia_permiso.estatus = 1";
	private static final String _FINDER_COLUMN_PERSON_USUARIOFK_2 = "licencia_permiso.usuariofk = ? AND licencia_permiso.estatus = 1";
	private static final String _FINDER_COLUMN_PERSON_USUARIOFK_3 = "(licencia_permiso.usuariofk IS NULL OR licencia_permiso.usuariofk = ?) AND licencia_permiso.estatus = 1";
	private static final String _FINDER_COLUMN_ESTATUS_ESTATUS_2 = "licencia_permiso.estatus = ?";
	private static final String _FINDER_COLUMN_DESPACHO_DESPACHO_1 = "licencia_permiso.despacho IS NULL AND licencia_permiso.estatus = 1";
	private static final String _FINDER_COLUMN_DESPACHO_DESPACHO_2 = "licencia_permiso.despacho = ? AND licencia_permiso.estatus = 1";
	private static final String _FINDER_COLUMN_DESPACHO_DESPACHO_3 = "(licencia_permiso.despacho IS NULL OR licencia_permiso.despacho = ?) AND licencia_permiso.estatus = 1";
	private static final String _ORDER_BY_ENTITY_ALIAS = "licencia_permiso.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No licencia_permiso exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No licencia_permiso exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(licencia_permisoPersistenceImpl.class);
	private static licencia_permiso _nulllicencia_permiso = new licencia_permisoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<licencia_permiso> toCacheModel() {
				return _nulllicencia_permisoCacheModel;
			}
		};

	private static CacheModel<licencia_permiso> _nulllicencia_permisoCacheModel = new CacheModel<licencia_permiso>() {
			public licencia_permiso toEntityModel() {
				return _nulllicencia_permiso;
			}
		};
}