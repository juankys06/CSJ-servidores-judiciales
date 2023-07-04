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

import co.com.csj.NoSuchalertaException;
import co.com.csj.model.alerta;
import co.com.csj.model.impl.alertaImpl;
import co.com.csj.model.impl.alertaModelImpl;

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
 * The persistence implementation for the alerta service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see alertaPersistence
 * @see alertaUtil
 * @generated
 */
public class alertaPersistenceImpl extends BasePersistenceImpl<alerta>
	implements alertaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link alertaUtil} to access the alerta persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = alertaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(alertaModelImpl.ENTITY_CACHE_ENABLED,
			alertaModelImpl.FINDER_CACHE_ENABLED, alertaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(alertaModelImpl.ENTITY_CACHE_ENABLED,
			alertaModelImpl.FINDER_CACHE_ENABLED, alertaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(alertaModelImpl.ENTITY_CACHE_ENABLED,
			alertaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the alerta in the entity cache if it is enabled.
	 *
	 * @param alerta the alerta
	 */
	public void cacheResult(alerta alerta) {
		EntityCacheUtil.putResult(alertaModelImpl.ENTITY_CACHE_ENABLED,
			alertaImpl.class, alerta.getPrimaryKey(), alerta);

		alerta.resetOriginalValues();
	}

	/**
	 * Caches the alertas in the entity cache if it is enabled.
	 *
	 * @param alertas the alertas
	 */
	public void cacheResult(List<alerta> alertas) {
		for (alerta alerta : alertas) {
			if (EntityCacheUtil.getResult(
						alertaModelImpl.ENTITY_CACHE_ENABLED, alertaImpl.class,
						alerta.getPrimaryKey()) == null) {
				cacheResult(alerta);
			}
			else {
				alerta.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all alertas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(alertaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(alertaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the alerta.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(alerta alerta) {
		EntityCacheUtil.removeResult(alertaModelImpl.ENTITY_CACHE_ENABLED,
			alertaImpl.class, alerta.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<alerta> alertas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (alerta alerta : alertas) {
			EntityCacheUtil.removeResult(alertaModelImpl.ENTITY_CACHE_ENABLED,
				alertaImpl.class, alerta.getPrimaryKey());
		}
	}

	/**
	 * Creates a new alerta with the primary key. Does not add the alerta to the database.
	 *
	 * @param id the primary key for the new alerta
	 * @return the new alerta
	 */
	public alerta create(String id) {
		alerta alerta = new alertaImpl();

		alerta.setNew(true);
		alerta.setPrimaryKey(id);

		return alerta;
	}

	/**
	 * Removes the alerta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the alerta
	 * @return the alerta that was removed
	 * @throws co.com.csj.NoSuchalertaException if a alerta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public alerta remove(String id)
		throws NoSuchalertaException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the alerta with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the alerta
	 * @return the alerta that was removed
	 * @throws co.com.csj.NoSuchalertaException if a alerta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public alerta remove(Serializable primaryKey)
		throws NoSuchalertaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			alerta alerta = (alerta)session.get(alertaImpl.class, primaryKey);

			if (alerta == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchalertaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(alerta);
		}
		catch (NoSuchalertaException nsee) {
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
	protected alerta removeImpl(alerta alerta) throws SystemException {
		alerta = toUnwrappedModel(alerta);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, alerta);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(alerta);

		return alerta;
	}

	@Override
	public alerta updateImpl(co.com.csj.model.alerta alerta, boolean merge)
		throws SystemException {
		alerta = toUnwrappedModel(alerta);

		boolean isNew = alerta.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, alerta, merge);

			alerta.setNew(false);
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

		EntityCacheUtil.putResult(alertaModelImpl.ENTITY_CACHE_ENABLED,
			alertaImpl.class, alerta.getPrimaryKey(), alerta);

		return alerta;
	}

	protected alerta toUnwrappedModel(alerta alerta) {
		if (alerta instanceof alertaImpl) {
			return alerta;
		}

		alertaImpl alertaImpl = new alertaImpl();

		alertaImpl.setNew(alerta.isNew());
		alertaImpl.setPrimaryKey(alerta.getPrimaryKey());

		alertaImpl.setId(alerta.getId());
		alertaImpl.setAsunto(alerta.getAsunto());
		alertaImpl.setMensaje(alerta.getMensaje());

		return alertaImpl;
	}

	/**
	 * Returns the alerta with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the alerta
	 * @return the alerta
	 * @throws com.liferay.portal.NoSuchModelException if a alerta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public alerta findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the alerta with the primary key or throws a {@link co.com.csj.NoSuchalertaException} if it could not be found.
	 *
	 * @param id the primary key of the alerta
	 * @return the alerta
	 * @throws co.com.csj.NoSuchalertaException if a alerta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public alerta findByPrimaryKey(String id)
		throws NoSuchalertaException, SystemException {
		alerta alerta = fetchByPrimaryKey(id);

		if (alerta == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchalertaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return alerta;
	}

	/**
	 * Returns the alerta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the alerta
	 * @return the alerta, or <code>null</code> if a alerta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public alerta fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the alerta with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the alerta
	 * @return the alerta, or <code>null</code> if a alerta with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public alerta fetchByPrimaryKey(String id) throws SystemException {
		alerta alerta = (alerta)EntityCacheUtil.getResult(alertaModelImpl.ENTITY_CACHE_ENABLED,
				alertaImpl.class, id);

		if (alerta == _nullalerta) {
			return null;
		}

		if (alerta == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				alerta = (alerta)session.get(alertaImpl.class, id);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (alerta != null) {
					cacheResult(alerta);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(alertaModelImpl.ENTITY_CACHE_ENABLED,
						alertaImpl.class, id, _nullalerta);
				}

				closeSession(session);
			}
		}

		return alerta;
	}

	/**
	 * Returns all the alertas.
	 *
	 * @return the alertas
	 * @throws SystemException if a system exception occurred
	 */
	public List<alerta> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the alertas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of alertas
	 * @param end the upper bound of the range of alertas (not inclusive)
	 * @return the range of alertas
	 * @throws SystemException if a system exception occurred
	 */
	public List<alerta> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the alertas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of alertas
	 * @param end the upper bound of the range of alertas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of alertas
	 * @throws SystemException if a system exception occurred
	 */
	public List<alerta> findAll(int start, int end,
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

		List<alerta> list = (List<alerta>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ALERTA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ALERTA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<alerta>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<alerta>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the alertas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (alerta alerta : findAll()) {
			remove(alerta);
		}
	}

	/**
	 * Returns the number of alertas.
	 *
	 * @return the number of alertas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ALERTA);

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
	 * Initializes the alerta persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.co.com.csj.model.alerta")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<alerta>> listenersList = new ArrayList<ModelListener<alerta>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<alerta>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(alertaImpl.class.getName());
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
	private static final String _SQL_SELECT_ALERTA = "SELECT alerta FROM alerta alerta";
	private static final String _SQL_COUNT_ALERTA = "SELECT COUNT(alerta) FROM alerta alerta";
	private static final String _ORDER_BY_ENTITY_ALIAS = "alerta.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No alerta exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(alertaPersistenceImpl.class);
	private static alerta _nullalerta = new alertaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<alerta> toCacheModel() {
				return _nullalertaCacheModel;
			}
		};

	private static CacheModel<alerta> _nullalertaCacheModel = new CacheModel<alerta>() {
			public alerta toEntityModel() {
				return _nullalerta;
			}
		};
}