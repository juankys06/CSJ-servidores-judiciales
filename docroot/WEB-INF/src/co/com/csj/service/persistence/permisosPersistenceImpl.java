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

import co.com.csj.NoSuchpermisosException;
import co.com.csj.model.impl.permisosImpl;
import co.com.csj.model.impl.permisosModelImpl;
import co.com.csj.model.permisos;

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
 * The persistence implementation for the permisos service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see permisosPersistence
 * @see permisosUtil
 * @generated
 */
public class permisosPersistenceImpl extends BasePersistenceImpl<permisos>
	implements permisosPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link permisosUtil} to access the permisos persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = permisosImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_FETCH_BY_USUARIO = new FinderPath(permisosModelImpl.ENTITY_CACHE_ENABLED,
			permisosModelImpl.FINDER_CACHE_ENABLED, permisosImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUsuario",
			new String[] { String.class.getName() },
			permisosModelImpl.USUARIO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USUARIO = new FinderPath(permisosModelImpl.ENTITY_CACHE_ENABLED,
			permisosModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUsuario",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USUARIOR = new FinderPath(permisosModelImpl.ENTITY_CACHE_ENABLED,
			permisosModelImpl.FINDER_CACHE_ENABLED, permisosImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUsuarioR",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USUARIOR =
		new FinderPath(permisosModelImpl.ENTITY_CACHE_ENABLED,
			permisosModelImpl.FINDER_CACHE_ENABLED, permisosImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUsuarioR",
			new String[] { String.class.getName() },
			permisosModelImpl.USUARIO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USUARIOR = new FinderPath(permisosModelImpl.ENTITY_CACHE_ENABLED,
			permisosModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUsuarioR",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(permisosModelImpl.ENTITY_CACHE_ENABLED,
			permisosModelImpl.FINDER_CACHE_ENABLED, permisosImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(permisosModelImpl.ENTITY_CACHE_ENABLED,
			permisosModelImpl.FINDER_CACHE_ENABLED, permisosImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(permisosModelImpl.ENTITY_CACHE_ENABLED,
			permisosModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the permisos in the entity cache if it is enabled.
	 *
	 * @param permisos the permisos
	 */
	public void cacheResult(permisos permisos) {
		EntityCacheUtil.putResult(permisosModelImpl.ENTITY_CACHE_ENABLED,
			permisosImpl.class, permisos.getPrimaryKey(), permisos);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO,
			new Object[] { permisos.getUsuario() }, permisos);

		permisos.resetOriginalValues();
	}

	/**
	 * Caches the permisoses in the entity cache if it is enabled.
	 *
	 * @param permisoses the permisoses
	 */
	public void cacheResult(List<permisos> permisoses) {
		for (permisos permisos : permisoses) {
			if (EntityCacheUtil.getResult(
						permisosModelImpl.ENTITY_CACHE_ENABLED,
						permisosImpl.class, permisos.getPrimaryKey()) == null) {
				cacheResult(permisos);
			}
			else {
				permisos.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all permisoses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(permisosImpl.class.getName());
		}

		EntityCacheUtil.clearCache(permisosImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the permisos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(permisos permisos) {
		EntityCacheUtil.removeResult(permisosModelImpl.ENTITY_CACHE_ENABLED,
			permisosImpl.class, permisos.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(permisos);
	}

	@Override
	public void clearCache(List<permisos> permisoses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (permisos permisos : permisoses) {
			EntityCacheUtil.removeResult(permisosModelImpl.ENTITY_CACHE_ENABLED,
				permisosImpl.class, permisos.getPrimaryKey());

			clearUniqueFindersCache(permisos);
		}
	}

	protected void clearUniqueFindersCache(permisos permisos) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USUARIO,
			new Object[] { permisos.getUsuario() });
	}

	/**
	 * Creates a new permisos with the primary key. Does not add the permisos to the database.
	 *
	 * @param id the primary key for the new permisos
	 * @return the new permisos
	 */
	public permisos create(long id) {
		permisos permisos = new permisosImpl();

		permisos.setNew(true);
		permisos.setPrimaryKey(id);

		return permisos;
	}

	/**
	 * Removes the permisos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the permisos
	 * @return the permisos that was removed
	 * @throws co.com.csj.NoSuchpermisosException if a permisos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public permisos remove(long id)
		throws NoSuchpermisosException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the permisos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the permisos
	 * @return the permisos that was removed
	 * @throws co.com.csj.NoSuchpermisosException if a permisos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public permisos remove(Serializable primaryKey)
		throws NoSuchpermisosException, SystemException {
		Session session = null;

		try {
			session = openSession();

			permisos permisos = (permisos)session.get(permisosImpl.class,
					primaryKey);

			if (permisos == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchpermisosException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(permisos);
		}
		catch (NoSuchpermisosException nsee) {
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
	protected permisos removeImpl(permisos permisos) throws SystemException {
		permisos = toUnwrappedModel(permisos);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, permisos);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(permisos);

		return permisos;
	}

	@Override
	public permisos updateImpl(co.com.csj.model.permisos permisos, boolean merge)
		throws SystemException {
		permisos = toUnwrappedModel(permisos);

		boolean isNew = permisos.isNew();

		permisosModelImpl permisosModelImpl = (permisosModelImpl)permisos;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, permisos, merge);

			permisos.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !permisosModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((permisosModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USUARIOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						permisosModelImpl.getOriginalUsuario()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USUARIOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USUARIOR,
					args);

				args = new Object[] { permisosModelImpl.getUsuario() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USUARIOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USUARIOR,
					args);
			}
		}

		EntityCacheUtil.putResult(permisosModelImpl.ENTITY_CACHE_ENABLED,
			permisosImpl.class, permisos.getPrimaryKey(), permisos);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO,
				new Object[] { permisos.getUsuario() }, permisos);
		}
		else {
			if ((permisosModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USUARIO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						permisosModelImpl.getOriginalUsuario()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USUARIO, args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USUARIO, args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO,
					new Object[] { permisos.getUsuario() }, permisos);
			}
		}

		return permisos;
	}

	protected permisos toUnwrappedModel(permisos permisos) {
		if (permisos instanceof permisosImpl) {
			return permisos;
		}

		permisosImpl permisosImpl = new permisosImpl();

		permisosImpl.setNew(permisos.isNew());
		permisosImpl.setPrimaryKey(permisos.getPrimaryKey());

		permisosImpl.setId(permisos.getId());
		permisosImpl.setCargo(permisos.getCargo());
		permisosImpl.setD_m(permisos.getD_m());
		permisosImpl.setUsuario(permisos.getUsuario());
		permisosImpl.setCreacion(permisos.getCreacion());

		return permisosImpl;
	}

	/**
	 * Returns the permisos with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the permisos
	 * @return the permisos
	 * @throws com.liferay.portal.NoSuchModelException if a permisos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public permisos findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the permisos with the primary key or throws a {@link co.com.csj.NoSuchpermisosException} if it could not be found.
	 *
	 * @param id the primary key of the permisos
	 * @return the permisos
	 * @throws co.com.csj.NoSuchpermisosException if a permisos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public permisos findByPrimaryKey(long id)
		throws NoSuchpermisosException, SystemException {
		permisos permisos = fetchByPrimaryKey(id);

		if (permisos == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchpermisosException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return permisos;
	}

	/**
	 * Returns the permisos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the permisos
	 * @return the permisos, or <code>null</code> if a permisos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public permisos fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the permisos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the permisos
	 * @return the permisos, or <code>null</code> if a permisos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public permisos fetchByPrimaryKey(long id) throws SystemException {
		permisos permisos = (permisos)EntityCacheUtil.getResult(permisosModelImpl.ENTITY_CACHE_ENABLED,
				permisosImpl.class, id);

		if (permisos == _nullpermisos) {
			return null;
		}

		if (permisos == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				permisos = (permisos)session.get(permisosImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (permisos != null) {
					cacheResult(permisos);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(permisosModelImpl.ENTITY_CACHE_ENABLED,
						permisosImpl.class, id, _nullpermisos);
				}

				closeSession(session);
			}
		}

		return permisos;
	}

	/**
	 * Returns the permisos where usuario = &#63; or throws a {@link co.com.csj.NoSuchpermisosException} if it could not be found.
	 *
	 * @param usuario the usuario
	 * @return the matching permisos
	 * @throws co.com.csj.NoSuchpermisosException if a matching permisos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public permisos findByUsuario(String usuario)
		throws NoSuchpermisosException, SystemException {
		permisos permisos = fetchByUsuario(usuario);

		if (permisos == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("usuario=");
			msg.append(usuario);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchpermisosException(msg.toString());
		}

		return permisos;
	}

	/**
	 * Returns the permisos where usuario = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param usuario the usuario
	 * @return the matching permisos, or <code>null</code> if a matching permisos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public permisos fetchByUsuario(String usuario) throws SystemException {
		return fetchByUsuario(usuario, true);
	}

	/**
	 * Returns the permisos where usuario = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param usuario the usuario
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching permisos, or <code>null</code> if a matching permisos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public permisos fetchByUsuario(String usuario, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { usuario };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USUARIO,
					finderArgs, this);
		}

		if (result instanceof permisos) {
			permisos permisos = (permisos)result;

			if (!Validator.equals(usuario, permisos.getUsuario())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_SELECT_PERMISOS_WHERE);

			if (usuario == null) {
				query.append(_FINDER_COLUMN_USUARIO_USUARIO_1);
			}
			else {
				if (usuario.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USUARIO_USUARIO_3);
				}
				else {
					query.append(_FINDER_COLUMN_USUARIO_USUARIO_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (usuario != null) {
					qPos.add(usuario);
				}

				List<permisos> list = q.list();

				result = list;

				permisos permisos = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO,
						finderArgs, list);
				}
				else {
					permisos = list.get(0);

					cacheResult(permisos);

					if ((permisos.getUsuario() == null) ||
							!permisos.getUsuario().equals(usuario)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USUARIO,
							finderArgs, permisos);
					}
				}

				return permisos;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USUARIO,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (permisos)result;
			}
		}
	}

	/**
	 * Returns all the permisoses where usuario = &#63;.
	 *
	 * @param usuario the usuario
	 * @return the matching permisoses
	 * @throws SystemException if a system exception occurred
	 */
	public List<permisos> findByUsuarioR(String usuario)
		throws SystemException {
		return findByUsuarioR(usuario, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the permisoses where usuario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param usuario the usuario
	 * @param start the lower bound of the range of permisoses
	 * @param end the upper bound of the range of permisoses (not inclusive)
	 * @return the range of matching permisoses
	 * @throws SystemException if a system exception occurred
	 */
	public List<permisos> findByUsuarioR(String usuario, int start, int end)
		throws SystemException {
		return findByUsuarioR(usuario, start, end, null);
	}

	/**
	 * Returns an ordered range of all the permisoses where usuario = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param usuario the usuario
	 * @param start the lower bound of the range of permisoses
	 * @param end the upper bound of the range of permisoses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permisoses
	 * @throws SystemException if a system exception occurred
	 */
	public List<permisos> findByUsuarioR(String usuario, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USUARIOR;
			finderArgs = new Object[] { usuario };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USUARIOR;
			finderArgs = new Object[] { usuario, start, end, orderByComparator };
		}

		List<permisos> list = (List<permisos>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (permisos permisos : list) {
				if (!Validator.equals(usuario, permisos.getUsuario())) {
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
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_PERMISOS_WHERE);

			if (usuario == null) {
				query.append(_FINDER_COLUMN_USUARIOR_USUARIO_1);
			}
			else {
				if (usuario.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USUARIOR_USUARIO_3);
				}
				else {
					query.append(_FINDER_COLUMN_USUARIOR_USUARIO_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (usuario != null) {
					qPos.add(usuario);
				}

				list = (List<permisos>)QueryUtil.list(q, getDialect(), start,
						end);
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
	 * Returns the first permisos in the ordered set where usuario = &#63;.
	 *
	 * @param usuario the usuario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permisos
	 * @throws co.com.csj.NoSuchpermisosException if a matching permisos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public permisos findByUsuarioR_First(String usuario,
		OrderByComparator orderByComparator)
		throws NoSuchpermisosException, SystemException {
		permisos permisos = fetchByUsuarioR_First(usuario, orderByComparator);

		if (permisos != null) {
			return permisos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("usuario=");
		msg.append(usuario);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchpermisosException(msg.toString());
	}

	/**
	 * Returns the first permisos in the ordered set where usuario = &#63;.
	 *
	 * @param usuario the usuario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permisos, or <code>null</code> if a matching permisos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public permisos fetchByUsuarioR_First(String usuario,
		OrderByComparator orderByComparator) throws SystemException {
		List<permisos> list = findByUsuarioR(usuario, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last permisos in the ordered set where usuario = &#63;.
	 *
	 * @param usuario the usuario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permisos
	 * @throws co.com.csj.NoSuchpermisosException if a matching permisos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public permisos findByUsuarioR_Last(String usuario,
		OrderByComparator orderByComparator)
		throws NoSuchpermisosException, SystemException {
		permisos permisos = fetchByUsuarioR_Last(usuario, orderByComparator);

		if (permisos != null) {
			return permisos;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("usuario=");
		msg.append(usuario);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchpermisosException(msg.toString());
	}

	/**
	 * Returns the last permisos in the ordered set where usuario = &#63;.
	 *
	 * @param usuario the usuario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permisos, or <code>null</code> if a matching permisos could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public permisos fetchByUsuarioR_Last(String usuario,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUsuarioR(usuario);

		List<permisos> list = findByUsuarioR(usuario, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the permisoses before and after the current permisos in the ordered set where usuario = &#63;.
	 *
	 * @param id the primary key of the current permisos
	 * @param usuario the usuario
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permisos
	 * @throws co.com.csj.NoSuchpermisosException if a permisos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public permisos[] findByUsuarioR_PrevAndNext(long id, String usuario,
		OrderByComparator orderByComparator)
		throws NoSuchpermisosException, SystemException {
		permisos permisos = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			permisos[] array = new permisosImpl[3];

			array[0] = getByUsuarioR_PrevAndNext(session, permisos, usuario,
					orderByComparator, true);

			array[1] = permisos;

			array[2] = getByUsuarioR_PrevAndNext(session, permisos, usuario,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected permisos getByUsuarioR_PrevAndNext(Session session,
		permisos permisos, String usuario, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PERMISOS_WHERE);

		if (usuario == null) {
			query.append(_FINDER_COLUMN_USUARIOR_USUARIO_1);
		}
		else {
			if (usuario.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_USUARIOR_USUARIO_3);
			}
			else {
				query.append(_FINDER_COLUMN_USUARIOR_USUARIO_2);
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

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (usuario != null) {
			qPos.add(usuario);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(permisos);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<permisos> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the permisoses.
	 *
	 * @return the permisoses
	 * @throws SystemException if a system exception occurred
	 */
	public List<permisos> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the permisoses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of permisoses
	 * @param end the upper bound of the range of permisoses (not inclusive)
	 * @return the range of permisoses
	 * @throws SystemException if a system exception occurred
	 */
	public List<permisos> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the permisoses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of permisoses
	 * @param end the upper bound of the range of permisoses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of permisoses
	 * @throws SystemException if a system exception occurred
	 */
	public List<permisos> findAll(int start, int end,
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

		List<permisos> list = (List<permisos>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PERMISOS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERMISOS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<permisos>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<permisos>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes the permisos where usuario = &#63; from the database.
	 *
	 * @param usuario the usuario
	 * @return the permisos that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public permisos removeByUsuario(String usuario)
		throws NoSuchpermisosException, SystemException {
		permisos permisos = findByUsuario(usuario);

		return remove(permisos);
	}

	/**
	 * Removes all the permisoses where usuario = &#63; from the database.
	 *
	 * @param usuario the usuario
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUsuarioR(String usuario) throws SystemException {
		for (permisos permisos : findByUsuarioR(usuario)) {
			remove(permisos);
		}
	}

	/**
	 * Removes all the permisoses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (permisos permisos : findAll()) {
			remove(permisos);
		}
	}

	/**
	 * Returns the number of permisoses where usuario = &#63;.
	 *
	 * @param usuario the usuario
	 * @return the number of matching permisoses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUsuario(String usuario) throws SystemException {
		Object[] finderArgs = new Object[] { usuario };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USUARIO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERMISOS_WHERE);

			if (usuario == null) {
				query.append(_FINDER_COLUMN_USUARIO_USUARIO_1);
			}
			else {
				if (usuario.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USUARIO_USUARIO_3);
				}
				else {
					query.append(_FINDER_COLUMN_USUARIO_USUARIO_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (usuario != null) {
					qPos.add(usuario);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USUARIO,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of permisoses where usuario = &#63;.
	 *
	 * @param usuario the usuario
	 * @return the number of matching permisoses
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUsuarioR(String usuario) throws SystemException {
		Object[] finderArgs = new Object[] { usuario };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USUARIOR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERMISOS_WHERE);

			if (usuario == null) {
				query.append(_FINDER_COLUMN_USUARIOR_USUARIO_1);
			}
			else {
				if (usuario.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_USUARIOR_USUARIO_3);
				}
				else {
					query.append(_FINDER_COLUMN_USUARIOR_USUARIO_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (usuario != null) {
					qPos.add(usuario);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USUARIOR,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of permisoses.
	 *
	 * @return the number of permisoses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERMISOS);

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
	 * Initializes the permisos persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.co.com.csj.model.permisos")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<permisos>> listenersList = new ArrayList<ModelListener<permisos>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<permisos>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(permisosImpl.class.getName());
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
	private static final String _SQL_SELECT_PERMISOS = "SELECT permisos FROM permisos permisos";
	private static final String _SQL_SELECT_PERMISOS_WHERE = "SELECT permisos FROM permisos permisos WHERE ";
	private static final String _SQL_COUNT_PERMISOS = "SELECT COUNT(permisos) FROM permisos permisos";
	private static final String _SQL_COUNT_PERMISOS_WHERE = "SELECT COUNT(permisos) FROM permisos permisos WHERE ";
	private static final String _FINDER_COLUMN_USUARIO_USUARIO_1 = "permisos.usuario IS NULL";
	private static final String _FINDER_COLUMN_USUARIO_USUARIO_2 = "permisos.usuario = ?";
	private static final String _FINDER_COLUMN_USUARIO_USUARIO_3 = "(permisos.usuario IS NULL OR permisos.usuario = ?)";
	private static final String _FINDER_COLUMN_USUARIOR_USUARIO_1 = "permisos.usuario IS NULL";
	private static final String _FINDER_COLUMN_USUARIOR_USUARIO_2 = "permisos.usuario = ?";
	private static final String _FINDER_COLUMN_USUARIOR_USUARIO_3 = "(permisos.usuario IS NULL OR permisos.usuario = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "permisos.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No permisos exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No permisos exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(permisosPersistenceImpl.class);
	private static permisos _nullpermisos = new permisosImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<permisos> toCacheModel() {
				return _nullpermisosCacheModel;
			}
		};

	private static CacheModel<permisos> _nullpermisosCacheModel = new CacheModel<permisos>() {
			public permisos toEntityModel() {
				return _nullpermisos;
			}
		};
}