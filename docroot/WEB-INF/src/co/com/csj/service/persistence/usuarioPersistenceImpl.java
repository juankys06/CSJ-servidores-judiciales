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

import co.com.csj.NoSuchusuarioException;
import co.com.csj.model.impl.usuarioImpl;
import co.com.csj.model.impl.usuarioModelImpl;
import co.com.csj.model.usuario;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
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
 * The persistence implementation for the usuario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see usuarioPersistence
 * @see usuarioUtil
 * @generated
 */
public class usuarioPersistenceImpl extends BasePersistenceImpl<usuario>
	implements usuarioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link usuarioUtil} to access the usuario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = usuarioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(usuarioModelImpl.ENTITY_CACHE_ENABLED,
			usuarioModelImpl.FINDER_CACHE_ENABLED, usuarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(usuarioModelImpl.ENTITY_CACHE_ENABLED,
			usuarioModelImpl.FINDER_CACHE_ENABLED, usuarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(usuarioModelImpl.ENTITY_CACHE_ENABLED,
			usuarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the usuario in the entity cache if it is enabled.
	 *
	 * @param usuario the usuario
	 */
	public void cacheResult(usuario usuario) {
		EntityCacheUtil.putResult(usuarioModelImpl.ENTITY_CACHE_ENABLED,
			usuarioImpl.class, usuario.getPrimaryKey(), usuario);

		usuario.resetOriginalValues();
	}

	/**
	 * Caches the usuarios in the entity cache if it is enabled.
	 *
	 * @param usuarios the usuarios
	 */
	public void cacheResult(List<usuario> usuarios) {
		for (usuario usuario : usuarios) {
			if (EntityCacheUtil.getResult(
						usuarioModelImpl.ENTITY_CACHE_ENABLED,
						usuarioImpl.class, usuario.getPrimaryKey()) == null) {
				cacheResult(usuario);
			}
			else {
				usuario.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all usuarios.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(usuarioImpl.class.getName());
		}

		EntityCacheUtil.clearCache(usuarioImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the usuario.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(usuario usuario) {
		EntityCacheUtil.removeResult(usuarioModelImpl.ENTITY_CACHE_ENABLED,
			usuarioImpl.class, usuario.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<usuario> usuarios) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (usuario usuario : usuarios) {
			EntityCacheUtil.removeResult(usuarioModelImpl.ENTITY_CACHE_ENABLED,
				usuarioImpl.class, usuario.getPrimaryKey());
		}
	}

	/**
	 * Creates a new usuario with the primary key. Does not add the usuario to the database.
	 *
	 * @param id the primary key for the new usuario
	 * @return the new usuario
	 */
	public usuario create(String id) {
		usuario usuario = new usuarioImpl();

		usuario.setNew(true);
		usuario.setPrimaryKey(id);

		return usuario;
	}

	/**
	 * Removes the usuario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the usuario
	 * @return the usuario that was removed
	 * @throws co.com.csj.NoSuchusuarioException if a usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public usuario remove(String id)
		throws NoSuchusuarioException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the usuario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the usuario
	 * @return the usuario that was removed
	 * @throws co.com.csj.NoSuchusuarioException if a usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public usuario remove(Serializable primaryKey)
		throws NoSuchusuarioException, SystemException {
		Session session = null;

		try {
			session = openSession();

			usuario usuario = (usuario)session.get(usuarioImpl.class, primaryKey);

			if (usuario == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchusuarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(usuario);
		}
		catch (NoSuchusuarioException nsee) {
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
	protected usuario removeImpl(usuario usuario) throws SystemException {
		usuario = toUnwrappedModel(usuario);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, usuario);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(usuario);

		return usuario;
	}

	@Override
	public usuario updateImpl(co.com.csj.model.usuario usuario, boolean merge)
		throws SystemException {
		usuario = toUnwrappedModel(usuario);

		boolean isNew = usuario.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, usuario, merge);

			usuario.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(usuarioModelImpl.ENTITY_CACHE_ENABLED,
			usuarioImpl.class, usuario.getPrimaryKey(), usuario);

		return usuario;
	}

	protected usuario toUnwrappedModel(usuario usuario) {
		if (usuario instanceof usuarioImpl) {
			return usuario;
		}

		usuarioImpl usuarioImpl = new usuarioImpl();

		usuarioImpl.setNew(usuario.isNew());
		usuarioImpl.setPrimaryKey(usuario.getPrimaryKey());

		usuarioImpl.setId(usuario.getId());
		usuarioImpl.setNomb(usuario.getNomb());
		usuarioImpl.setApe(usuario.getApe());
		usuarioImpl.setTipo_doc(usuario.getTipo_doc());
		usuarioImpl.setDespachofk(usuario.getDespachofk());
		usuarioImpl.setCargofk(usuario.getCargofk());

		return usuarioImpl;
	}

	/**
	 * Returns the usuario with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the usuario
	 * @return the usuario
	 * @throws com.liferay.portal.NoSuchModelException if a usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public usuario findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the usuario with the primary key or throws a {@link co.com.csj.NoSuchusuarioException} if it could not be found.
	 *
	 * @param id the primary key of the usuario
	 * @return the usuario
	 * @throws co.com.csj.NoSuchusuarioException if a usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public usuario findByPrimaryKey(String id)
		throws NoSuchusuarioException, SystemException {
		usuario usuario = fetchByPrimaryKey(id);

		if (usuario == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchusuarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return usuario;
	}

	/**
	 * Returns the usuario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the usuario
	 * @return the usuario, or <code>null</code> if a usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public usuario fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the usuario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the usuario
	 * @return the usuario, or <code>null</code> if a usuario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public usuario fetchByPrimaryKey(String id) throws SystemException {
		usuario usuario = (usuario)EntityCacheUtil.getResult(usuarioModelImpl.ENTITY_CACHE_ENABLED,
				usuarioImpl.class, id);

		if (usuario == _nullusuario) {
			return null;
		}

		if (usuario == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				usuario = (usuario)session.get(usuarioImpl.class, id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (usuario != null) {
					cacheResult(usuario);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(usuarioModelImpl.ENTITY_CACHE_ENABLED,
						usuarioImpl.class, id, _nullusuario);
				}

				closeSession(session);
			}
		}

		return usuario;
	}

	/**
	 * Returns all the usuarios.
	 *
	 * @return the usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<usuario> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the usuarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of usuarios
	 * @param end the upper bound of the range of usuarios (not inclusive)
	 * @return the range of usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<usuario> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the usuarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of usuarios
	 * @param end the upper bound of the range of usuarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<usuario> findAll(int start, int end,
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

		List<usuario> list = (List<usuario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_USUARIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USUARIO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<usuario>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<usuario>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the usuarios from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (usuario usuario : findAll()) {
			remove(usuario);
		}
	}

	/**
	 * Returns the number of usuarios.
	 *
	 * @return the number of usuarios
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USUARIO);

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
	 * Initializes the usuario persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.co.com.csj.model.usuario")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<usuario>> listenersList = new ArrayList<ModelListener<usuario>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<usuario>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(usuarioImpl.class.getName());
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
	private static final String _SQL_SELECT_USUARIO = "SELECT usuario FROM usuario usuario";
	private static final String _SQL_COUNT_USUARIO = "SELECT COUNT(usuario) FROM usuario usuario";
	private static final String _ORDER_BY_ENTITY_ALIAS = "usuario.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No usuario exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(usuarioPersistenceImpl.class);
	private static usuario _nullusuario = new usuarioImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<usuario> toCacheModel() {
				return _nullusuarioCacheModel;
			}
		};

	private static CacheModel<usuario> _nullusuarioCacheModel = new CacheModel<usuario>() {
			public usuario toEntityModel() {
				return _nullusuario;
			}
		};
}