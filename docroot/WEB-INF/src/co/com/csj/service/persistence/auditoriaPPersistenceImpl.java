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

import co.com.csj.NoSuchauditoriaPException;
import co.com.csj.model.auditoriaP;
import co.com.csj.model.impl.auditoriaPImpl;
import co.com.csj.model.impl.auditoriaPModelImpl;

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
 * The persistence implementation for the auditoria p service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see auditoriaPPersistence
 * @see auditoriaPUtil
 * @generated
 */
public class auditoriaPPersistenceImpl extends BasePersistenceImpl<auditoriaP>
	implements auditoriaPPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link auditoriaPUtil} to access the auditoria p persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = auditoriaPImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(auditoriaPModelImpl.ENTITY_CACHE_ENABLED,
			auditoriaPModelImpl.FINDER_CACHE_ENABLED, auditoriaPImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(auditoriaPModelImpl.ENTITY_CACHE_ENABLED,
			auditoriaPModelImpl.FINDER_CACHE_ENABLED, auditoriaPImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(auditoriaPModelImpl.ENTITY_CACHE_ENABLED,
			auditoriaPModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the auditoria p in the entity cache if it is enabled.
	 *
	 * @param auditoriaP the auditoria p
	 */
	public void cacheResult(auditoriaP auditoriaP) {
		EntityCacheUtil.putResult(auditoriaPModelImpl.ENTITY_CACHE_ENABLED,
			auditoriaPImpl.class, auditoriaP.getPrimaryKey(), auditoriaP);

		auditoriaP.resetOriginalValues();
	}

	/**
	 * Caches the auditoria ps in the entity cache if it is enabled.
	 *
	 * @param auditoriaPs the auditoria ps
	 */
	public void cacheResult(List<auditoriaP> auditoriaPs) {
		for (auditoriaP auditoriaP : auditoriaPs) {
			if (EntityCacheUtil.getResult(
						auditoriaPModelImpl.ENTITY_CACHE_ENABLED,
						auditoriaPImpl.class, auditoriaP.getPrimaryKey()) == null) {
				cacheResult(auditoriaP);
			}
			else {
				auditoriaP.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all auditoria ps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(auditoriaPImpl.class.getName());
		}

		EntityCacheUtil.clearCache(auditoriaPImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the auditoria p.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(auditoriaP auditoriaP) {
		EntityCacheUtil.removeResult(auditoriaPModelImpl.ENTITY_CACHE_ENABLED,
			auditoriaPImpl.class, auditoriaP.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<auditoriaP> auditoriaPs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (auditoriaP auditoriaP : auditoriaPs) {
			EntityCacheUtil.removeResult(auditoriaPModelImpl.ENTITY_CACHE_ENABLED,
				auditoriaPImpl.class, auditoriaP.getPrimaryKey());
		}
	}

	/**
	 * Creates a new auditoria p with the primary key. Does not add the auditoria p to the database.
	 *
	 * @param id the primary key for the new auditoria p
	 * @return the new auditoria p
	 */
	public auditoriaP create(long id) {
		auditoriaP auditoriaP = new auditoriaPImpl();

		auditoriaP.setNew(true);
		auditoriaP.setPrimaryKey(id);

		return auditoriaP;
	}

	/**
	 * Removes the auditoria p with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the auditoria p
	 * @return the auditoria p that was removed
	 * @throws co.com.csj.NoSuchauditoriaPException if a auditoria p with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public auditoriaP remove(long id)
		throws NoSuchauditoriaPException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the auditoria p with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the auditoria p
	 * @return the auditoria p that was removed
	 * @throws co.com.csj.NoSuchauditoriaPException if a auditoria p with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public auditoriaP remove(Serializable primaryKey)
		throws NoSuchauditoriaPException, SystemException {
		Session session = null;

		try {
			session = openSession();

			auditoriaP auditoriaP = (auditoriaP)session.get(auditoriaPImpl.class,
					primaryKey);

			if (auditoriaP == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchauditoriaPException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(auditoriaP);
		}
		catch (NoSuchauditoriaPException nsee) {
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
	protected auditoriaP removeImpl(auditoriaP auditoriaP)
		throws SystemException {
		auditoriaP = toUnwrappedModel(auditoriaP);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, auditoriaP);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(auditoriaP);

		return auditoriaP;
	}

	@Override
	public auditoriaP updateImpl(co.com.csj.model.auditoriaP auditoriaP,
		boolean merge) throws SystemException {
		auditoriaP = toUnwrappedModel(auditoriaP);

		boolean isNew = auditoriaP.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, auditoriaP, merge);

			auditoriaP.setNew(false);
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

		EntityCacheUtil.putResult(auditoriaPModelImpl.ENTITY_CACHE_ENABLED,
			auditoriaPImpl.class, auditoriaP.getPrimaryKey(), auditoriaP);

		return auditoriaP;
	}

	protected auditoriaP toUnwrappedModel(auditoriaP auditoriaP) {
		if (auditoriaP instanceof auditoriaPImpl) {
			return auditoriaP;
		}

		auditoriaPImpl auditoriaPImpl = new auditoriaPImpl();

		auditoriaPImpl.setNew(auditoriaP.isNew());
		auditoriaPImpl.setPrimaryKey(auditoriaP.getPrimaryKey());

		auditoriaPImpl.setId(auditoriaP.getId());
		auditoriaPImpl.setTipo_recurso(auditoriaP.getTipo_recurso());
		auditoriaPImpl.setId_recurso_modificado(auditoriaP.getId_recurso_modificado());
		auditoriaPImpl.setTipo_operacion(auditoriaP.getTipo_operacion());
		auditoriaPImpl.setFecha(auditoriaP.getFecha());
		auditoriaPImpl.setCorreo(auditoriaP.getCorreo());
		auditoriaPImpl.setUsuario_modifico(auditoriaP.getUsuario_modifico());
		auditoriaPImpl.setModificacion(auditoriaP.getModificacion());

		return auditoriaPImpl;
	}

	/**
	 * Returns the auditoria p with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the auditoria p
	 * @return the auditoria p
	 * @throws com.liferay.portal.NoSuchModelException if a auditoria p with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public auditoriaP findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the auditoria p with the primary key or throws a {@link co.com.csj.NoSuchauditoriaPException} if it could not be found.
	 *
	 * @param id the primary key of the auditoria p
	 * @return the auditoria p
	 * @throws co.com.csj.NoSuchauditoriaPException if a auditoria p with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public auditoriaP findByPrimaryKey(long id)
		throws NoSuchauditoriaPException, SystemException {
		auditoriaP auditoriaP = fetchByPrimaryKey(id);

		if (auditoriaP == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchauditoriaPException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return auditoriaP;
	}

	/**
	 * Returns the auditoria p with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the auditoria p
	 * @return the auditoria p, or <code>null</code> if a auditoria p with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public auditoriaP fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the auditoria p with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the auditoria p
	 * @return the auditoria p, or <code>null</code> if a auditoria p with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public auditoriaP fetchByPrimaryKey(long id) throws SystemException {
		auditoriaP auditoriaP = (auditoriaP)EntityCacheUtil.getResult(auditoriaPModelImpl.ENTITY_CACHE_ENABLED,
				auditoriaPImpl.class, id);

		if (auditoriaP == _nullauditoriaP) {
			return null;
		}

		if (auditoriaP == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				auditoriaP = (auditoriaP)session.get(auditoriaPImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (auditoriaP != null) {
					cacheResult(auditoriaP);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(auditoriaPModelImpl.ENTITY_CACHE_ENABLED,
						auditoriaPImpl.class, id, _nullauditoriaP);
				}

				closeSession(session);
			}
		}

		return auditoriaP;
	}

	/**
	 * Returns all the auditoria ps.
	 *
	 * @return the auditoria ps
	 * @throws SystemException if a system exception occurred
	 */
	public List<auditoriaP> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auditoria ps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditoria ps
	 * @param end the upper bound of the range of auditoria ps (not inclusive)
	 * @return the range of auditoria ps
	 * @throws SystemException if a system exception occurred
	 */
	public List<auditoriaP> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the auditoria ps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditoria ps
	 * @param end the upper bound of the range of auditoria ps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auditoria ps
	 * @throws SystemException if a system exception occurred
	 */
	public List<auditoriaP> findAll(int start, int end,
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

		List<auditoriaP> list = (List<auditoriaP>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AUDITORIAP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUDITORIAP.concat(auditoriaPModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<auditoriaP>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<auditoriaP>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the auditoria ps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (auditoriaP auditoriaP : findAll()) {
			remove(auditoriaP);
		}
	}

	/**
	 * Returns the number of auditoria ps.
	 *
	 * @return the number of auditoria ps
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AUDITORIAP);

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
	 * Initializes the auditoria p persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.co.com.csj.model.auditoriaP")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<auditoriaP>> listenersList = new ArrayList<ModelListener<auditoriaP>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<auditoriaP>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(auditoriaPImpl.class.getName());
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
	private static final String _SQL_SELECT_AUDITORIAP = "SELECT auditoriaP FROM auditoriaP auditoriaP";
	private static final String _SQL_COUNT_AUDITORIAP = "SELECT COUNT(auditoriaP) FROM auditoriaP auditoriaP";
	private static final String _ORDER_BY_ENTITY_ALIAS = "auditoriaP.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No auditoriaP exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(auditoriaPPersistenceImpl.class);
	private static auditoriaP _nullauditoriaP = new auditoriaPImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<auditoriaP> toCacheModel() {
				return _nullauditoriaPCacheModel;
			}
		};

	private static CacheModel<auditoriaP> _nullauditoriaPCacheModel = new CacheModel<auditoriaP>() {
			public auditoriaP toEntityModel() {
				return _nullauditoriaP;
			}
		};
}