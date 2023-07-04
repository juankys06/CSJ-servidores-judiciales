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

import co.com.csj.NoSuchcargoException;
import co.com.csj.model.cargo;
import co.com.csj.model.impl.cargoImpl;
import co.com.csj.model.impl.cargoModelImpl;

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
 * The persistence implementation for the cargo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see cargoPersistence
 * @see cargoUtil
 * @generated
 */
public class cargoPersistenceImpl extends BasePersistenceImpl<cargo>
	implements cargoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link cargoUtil} to access the cargo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = cargoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(cargoModelImpl.ENTITY_CACHE_ENABLED,
			cargoModelImpl.FINDER_CACHE_ENABLED, cargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(cargoModelImpl.ENTITY_CACHE_ENABLED,
			cargoModelImpl.FINDER_CACHE_ENABLED, cargoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(cargoModelImpl.ENTITY_CACHE_ENABLED,
			cargoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the cargo in the entity cache if it is enabled.
	 *
	 * @param cargo the cargo
	 */
	public void cacheResult(cargo cargo) {
		EntityCacheUtil.putResult(cargoModelImpl.ENTITY_CACHE_ENABLED,
			cargoImpl.class, cargo.getPrimaryKey(), cargo);

		cargo.resetOriginalValues();
	}

	/**
	 * Caches the cargos in the entity cache if it is enabled.
	 *
	 * @param cargos the cargos
	 */
	public void cacheResult(List<cargo> cargos) {
		for (cargo cargo : cargos) {
			if (EntityCacheUtil.getResult(cargoModelImpl.ENTITY_CACHE_ENABLED,
						cargoImpl.class, cargo.getPrimaryKey()) == null) {
				cacheResult(cargo);
			}
			else {
				cargo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cargos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(cargoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(cargoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cargo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(cargo cargo) {
		EntityCacheUtil.removeResult(cargoModelImpl.ENTITY_CACHE_ENABLED,
			cargoImpl.class, cargo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<cargo> cargos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (cargo cargo : cargos) {
			EntityCacheUtil.removeResult(cargoModelImpl.ENTITY_CACHE_ENABLED,
				cargoImpl.class, cargo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cargo with the primary key. Does not add the cargo to the database.
	 *
	 * @param _id the primary key for the new cargo
	 * @return the new cargo
	 */
	public cargo create(long _id) {
		cargo cargo = new cargoImpl();

		cargo.setNew(true);
		cargo.setPrimaryKey(_id);

		return cargo;
	}

	/**
	 * Removes the cargo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param _id the primary key of the cargo
	 * @return the cargo that was removed
	 * @throws co.com.csj.NoSuchcargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public cargo remove(long _id) throws NoSuchcargoException, SystemException {
		return remove(Long.valueOf(_id));
	}

	/**
	 * Removes the cargo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cargo
	 * @return the cargo that was removed
	 * @throws co.com.csj.NoSuchcargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public cargo remove(Serializable primaryKey)
		throws NoSuchcargoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			cargo cargo = (cargo)session.get(cargoImpl.class, primaryKey);

			if (cargo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcargoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cargo);
		}
		catch (NoSuchcargoException nsee) {
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
	protected cargo removeImpl(cargo cargo) throws SystemException {
		cargo = toUnwrappedModel(cargo);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, cargo);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(cargo);

		return cargo;
	}

	@Override
	public cargo updateImpl(co.com.csj.model.cargo cargo, boolean merge)
		throws SystemException {
		cargo = toUnwrappedModel(cargo);

		boolean isNew = cargo.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cargo, merge);

			cargo.setNew(false);
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

		EntityCacheUtil.putResult(cargoModelImpl.ENTITY_CACHE_ENABLED,
			cargoImpl.class, cargo.getPrimaryKey(), cargo);

		return cargo;
	}

	protected cargo toUnwrappedModel(cargo cargo) {
		if (cargo instanceof cargoImpl) {
			return cargo;
		}

		cargoImpl cargoImpl = new cargoImpl();

		cargoImpl.setNew(cargo.isNew());
		cargoImpl.setPrimaryKey(cargo.getPrimaryKey());

		cargoImpl.set_id(cargo.get_id());
		cargoImpl.setDesc(cargo.getDesc());

		return cargoImpl;
	}

	/**
	 * Returns the cargo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cargo
	 * @return the cargo
	 * @throws com.liferay.portal.NoSuchModelException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public cargo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cargo with the primary key or throws a {@link co.com.csj.NoSuchcargoException} if it could not be found.
	 *
	 * @param _id the primary key of the cargo
	 * @return the cargo
	 * @throws co.com.csj.NoSuchcargoException if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public cargo findByPrimaryKey(long _id)
		throws NoSuchcargoException, SystemException {
		cargo cargo = fetchByPrimaryKey(_id);

		if (cargo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + _id);
			}

			throw new NoSuchcargoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				_id);
		}

		return cargo;
	}

	/**
	 * Returns the cargo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cargo
	 * @return the cargo, or <code>null</code> if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public cargo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the cargo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param _id the primary key of the cargo
	 * @return the cargo, or <code>null</code> if a cargo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public cargo fetchByPrimaryKey(long _id) throws SystemException {
		cargo cargo = (cargo)EntityCacheUtil.getResult(cargoModelImpl.ENTITY_CACHE_ENABLED,
				cargoImpl.class, _id);

		if (cargo == _nullcargo) {
			return null;
		}

		if (cargo == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				cargo = (cargo)session.get(cargoImpl.class, Long.valueOf(_id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (cargo != null) {
					cacheResult(cargo);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(cargoModelImpl.ENTITY_CACHE_ENABLED,
						cargoImpl.class, _id, _nullcargo);
				}

				closeSession(session);
			}
		}

		return cargo;
	}

	/**
	 * Returns all the cargos.
	 *
	 * @return the cargos
	 * @throws SystemException if a system exception occurred
	 */
	public List<cargo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cargos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @return the range of cargos
	 * @throws SystemException if a system exception occurred
	 */
	public List<cargo> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cargos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of cargos
	 * @param end the upper bound of the range of cargos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cargos
	 * @throws SystemException if a system exception occurred
	 */
	public List<cargo> findAll(int start, int end,
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

		List<cargo> list = (List<cargo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CARGO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CARGO.concat(cargoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<cargo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<cargo>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the cargos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (cargo cargo : findAll()) {
			remove(cargo);
		}
	}

	/**
	 * Returns the number of cargos.
	 *
	 * @return the number of cargos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CARGO);

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
	 * Initializes the cargo persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.co.com.csj.model.cargo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<cargo>> listenersList = new ArrayList<ModelListener<cargo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<cargo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(cargoImpl.class.getName());
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
	private static final String _SQL_SELECT_CARGO = "SELECT cargo FROM cargo cargo";
	private static final String _SQL_COUNT_CARGO = "SELECT COUNT(cargo) FROM cargo cargo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cargo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No cargo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(cargoPersistenceImpl.class);
	private static cargo _nullcargo = new cargoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<cargo> toCacheModel() {
				return _nullcargoCacheModel;
			}
		};

	private static CacheModel<cargo> _nullcargoCacheModel = new CacheModel<cargo>() {
			public cargo toEntityModel() {
				return _nullcargo;
			}
		};
}