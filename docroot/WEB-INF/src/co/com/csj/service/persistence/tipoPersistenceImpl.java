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

import co.com.csj.NoSuchtipoException;
import co.com.csj.model.impl.tipoImpl;
import co.com.csj.model.impl.tipoModelImpl;
import co.com.csj.model.tipo;

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
 * The persistence implementation for the tipo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see tipoPersistence
 * @see tipoUtil
 * @generated
 */
public class tipoPersistenceImpl extends BasePersistenceImpl<tipo>
	implements tipoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link tipoUtil} to access the tipo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = tipoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(tipoModelImpl.ENTITY_CACHE_ENABLED,
			tipoModelImpl.FINDER_CACHE_ENABLED, tipoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(tipoModelImpl.ENTITY_CACHE_ENABLED,
			tipoModelImpl.FINDER_CACHE_ENABLED, tipoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(tipoModelImpl.ENTITY_CACHE_ENABLED,
			tipoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tipo in the entity cache if it is enabled.
	 *
	 * @param tipo the tipo
	 */
	public void cacheResult(tipo tipo) {
		EntityCacheUtil.putResult(tipoModelImpl.ENTITY_CACHE_ENABLED,
			tipoImpl.class, tipo.getPrimaryKey(), tipo);

		tipo.resetOriginalValues();
	}

	/**
	 * Caches the tipos in the entity cache if it is enabled.
	 *
	 * @param tipos the tipos
	 */
	public void cacheResult(List<tipo> tipos) {
		for (tipo tipo : tipos) {
			if (EntityCacheUtil.getResult(tipoModelImpl.ENTITY_CACHE_ENABLED,
						tipoImpl.class, tipo.getPrimaryKey()) == null) {
				cacheResult(tipo);
			}
			else {
				tipo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tipos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(tipoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(tipoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tipo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(tipo tipo) {
		EntityCacheUtil.removeResult(tipoModelImpl.ENTITY_CACHE_ENABLED,
			tipoImpl.class, tipo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<tipo> tipos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (tipo tipo : tipos) {
			EntityCacheUtil.removeResult(tipoModelImpl.ENTITY_CACHE_ENABLED,
				tipoImpl.class, tipo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tipo with the primary key. Does not add the tipo to the database.
	 *
	 * @param id the primary key for the new tipo
	 * @return the new tipo
	 */
	public tipo create(long id) {
		tipo tipo = new tipoImpl();

		tipo.setNew(true);
		tipo.setPrimaryKey(id);

		return tipo;
	}

	/**
	 * Removes the tipo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tipo
	 * @return the tipo that was removed
	 * @throws co.com.csj.NoSuchtipoException if a tipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public tipo remove(long id) throws NoSuchtipoException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the tipo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipo
	 * @return the tipo that was removed
	 * @throws co.com.csj.NoSuchtipoException if a tipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tipo remove(Serializable primaryKey)
		throws NoSuchtipoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			tipo tipo = (tipo)session.get(tipoImpl.class, primaryKey);

			if (tipo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchtipoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipo);
		}
		catch (NoSuchtipoException nsee) {
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
	protected tipo removeImpl(tipo tipo) throws SystemException {
		tipo = toUnwrappedModel(tipo);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tipo);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tipo);

		return tipo;
	}

	@Override
	public tipo updateImpl(co.com.csj.model.tipo tipo, boolean merge)
		throws SystemException {
		tipo = toUnwrappedModel(tipo);

		boolean isNew = tipo.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tipo, merge);

			tipo.setNew(false);
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

		EntityCacheUtil.putResult(tipoModelImpl.ENTITY_CACHE_ENABLED,
			tipoImpl.class, tipo.getPrimaryKey(), tipo);

		return tipo;
	}

	protected tipo toUnwrappedModel(tipo tipo) {
		if (tipo instanceof tipoImpl) {
			return tipo;
		}

		tipoImpl tipoImpl = new tipoImpl();

		tipoImpl.setNew(tipo.isNew());
		tipoImpl.setPrimaryKey(tipo.getPrimaryKey());

		tipoImpl.setId(tipo.getId());
		tipoImpl.setDescripcion(tipo.getDescripcion());

		return tipoImpl;
	}

	/**
	 * Returns the tipo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo
	 * @return the tipo
	 * @throws com.liferay.portal.NoSuchModelException if a tipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tipo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tipo with the primary key or throws a {@link co.com.csj.NoSuchtipoException} if it could not be found.
	 *
	 * @param id the primary key of the tipo
	 * @return the tipo
	 * @throws co.com.csj.NoSuchtipoException if a tipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public tipo findByPrimaryKey(long id)
		throws NoSuchtipoException, SystemException {
		tipo tipo = fetchByPrimaryKey(id);

		if (tipo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchtipoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return tipo;
	}

	/**
	 * Returns the tipo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo
	 * @return the tipo, or <code>null</code> if a tipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tipo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tipo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tipo
	 * @return the tipo, or <code>null</code> if a tipo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public tipo fetchByPrimaryKey(long id) throws SystemException {
		tipo tipo = (tipo)EntityCacheUtil.getResult(tipoModelImpl.ENTITY_CACHE_ENABLED,
				tipoImpl.class, id);

		if (tipo == _nulltipo) {
			return null;
		}

		if (tipo == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tipo = (tipo)session.get(tipoImpl.class, Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tipo != null) {
					cacheResult(tipo);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(tipoModelImpl.ENTITY_CACHE_ENABLED,
						tipoImpl.class, id, _nulltipo);
				}

				closeSession(session);
			}
		}

		return tipo;
	}

	/**
	 * Returns all the tipos.
	 *
	 * @return the tipos
	 * @throws SystemException if a system exception occurred
	 */
	public List<tipo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipos
	 * @param end the upper bound of the range of tipos (not inclusive)
	 * @return the range of tipos
	 * @throws SystemException if a system exception occurred
	 */
	public List<tipo> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipos
	 * @param end the upper bound of the range of tipos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipos
	 * @throws SystemException if a system exception occurred
	 */
	public List<tipo> findAll(int start, int end,
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

		List<tipo> list = (List<tipo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TIPO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<tipo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<tipo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the tipos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (tipo tipo : findAll()) {
			remove(tipo);
		}
	}

	/**
	 * Returns the number of tipos.
	 *
	 * @return the number of tipos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPO);

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
	 * Initializes the tipo persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.co.com.csj.model.tipo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<tipo>> listenersList = new ArrayList<ModelListener<tipo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<tipo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(tipoImpl.class.getName());
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
	private static final String _SQL_SELECT_TIPO = "SELECT tipo FROM tipo tipo";
	private static final String _SQL_COUNT_TIPO = "SELECT COUNT(tipo) FROM tipo tipo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No tipo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(tipoPersistenceImpl.class);
	private static tipo _nulltipo = new tipoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<tipo> toCacheModel() {
				return _nulltipoCacheModel;
			}
		};

	private static CacheModel<tipo> _nulltipoCacheModel = new CacheModel<tipo>() {
			public tipo toEntityModel() {
				return _nulltipo;
			}
		};
}