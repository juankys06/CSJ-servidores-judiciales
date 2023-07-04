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

import co.com.csj.NoSuchtipo_documentoException;
import co.com.csj.model.impl.tipo_documentoImpl;
import co.com.csj.model.impl.tipo_documentoModelImpl;
import co.com.csj.model.tipo_documento;

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
 * The persistence implementation for the tipo_documento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see tipo_documentoPersistence
 * @see tipo_documentoUtil
 * @generated
 */
public class tipo_documentoPersistenceImpl extends BasePersistenceImpl<tipo_documento>
	implements tipo_documentoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link tipo_documentoUtil} to access the tipo_documento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = tipo_documentoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(tipo_documentoModelImpl.ENTITY_CACHE_ENABLED,
			tipo_documentoModelImpl.FINDER_CACHE_ENABLED,
			tipo_documentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(tipo_documentoModelImpl.ENTITY_CACHE_ENABLED,
			tipo_documentoModelImpl.FINDER_CACHE_ENABLED,
			tipo_documentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(tipo_documentoModelImpl.ENTITY_CACHE_ENABLED,
			tipo_documentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the tipo_documento in the entity cache if it is enabled.
	 *
	 * @param tipo_documento the tipo_documento
	 */
	public void cacheResult(tipo_documento tipo_documento) {
		EntityCacheUtil.putResult(tipo_documentoModelImpl.ENTITY_CACHE_ENABLED,
			tipo_documentoImpl.class, tipo_documento.getPrimaryKey(),
			tipo_documento);

		tipo_documento.resetOriginalValues();
	}

	/**
	 * Caches the tipo_documentos in the entity cache if it is enabled.
	 *
	 * @param tipo_documentos the tipo_documentos
	 */
	public void cacheResult(List<tipo_documento> tipo_documentos) {
		for (tipo_documento tipo_documento : tipo_documentos) {
			if (EntityCacheUtil.getResult(
						tipo_documentoModelImpl.ENTITY_CACHE_ENABLED,
						tipo_documentoImpl.class, tipo_documento.getPrimaryKey()) == null) {
				cacheResult(tipo_documento);
			}
			else {
				tipo_documento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all tipo_documentos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(tipo_documentoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(tipo_documentoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the tipo_documento.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(tipo_documento tipo_documento) {
		EntityCacheUtil.removeResult(tipo_documentoModelImpl.ENTITY_CACHE_ENABLED,
			tipo_documentoImpl.class, tipo_documento.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<tipo_documento> tipo_documentos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (tipo_documento tipo_documento : tipo_documentos) {
			EntityCacheUtil.removeResult(tipo_documentoModelImpl.ENTITY_CACHE_ENABLED,
				tipo_documentoImpl.class, tipo_documento.getPrimaryKey());
		}
	}

	/**
	 * Creates a new tipo_documento with the primary key. Does not add the tipo_documento to the database.
	 *
	 * @param _id the primary key for the new tipo_documento
	 * @return the new tipo_documento
	 */
	public tipo_documento create(long _id) {
		tipo_documento tipo_documento = new tipo_documentoImpl();

		tipo_documento.setNew(true);
		tipo_documento.setPrimaryKey(_id);

		return tipo_documento;
	}

	/**
	 * Removes the tipo_documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param _id the primary key of the tipo_documento
	 * @return the tipo_documento that was removed
	 * @throws co.com.csj.NoSuchtipo_documentoException if a tipo_documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public tipo_documento remove(long _id)
		throws NoSuchtipo_documentoException, SystemException {
		return remove(Long.valueOf(_id));
	}

	/**
	 * Removes the tipo_documento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipo_documento
	 * @return the tipo_documento that was removed
	 * @throws co.com.csj.NoSuchtipo_documentoException if a tipo_documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tipo_documento remove(Serializable primaryKey)
		throws NoSuchtipo_documentoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			tipo_documento tipo_documento = (tipo_documento)session.get(tipo_documentoImpl.class,
					primaryKey);

			if (tipo_documento == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchtipo_documentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(tipo_documento);
		}
		catch (NoSuchtipo_documentoException nsee) {
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
	protected tipo_documento removeImpl(tipo_documento tipo_documento)
		throws SystemException {
		tipo_documento = toUnwrappedModel(tipo_documento);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, tipo_documento);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(tipo_documento);

		return tipo_documento;
	}

	@Override
	public tipo_documento updateImpl(
		co.com.csj.model.tipo_documento tipo_documento, boolean merge)
		throws SystemException {
		tipo_documento = toUnwrappedModel(tipo_documento);

		boolean isNew = tipo_documento.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, tipo_documento, merge);

			tipo_documento.setNew(false);
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

		EntityCacheUtil.putResult(tipo_documentoModelImpl.ENTITY_CACHE_ENABLED,
			tipo_documentoImpl.class, tipo_documento.getPrimaryKey(),
			tipo_documento);

		return tipo_documento;
	}

	protected tipo_documento toUnwrappedModel(tipo_documento tipo_documento) {
		if (tipo_documento instanceof tipo_documentoImpl) {
			return tipo_documento;
		}

		tipo_documentoImpl tipo_documentoImpl = new tipo_documentoImpl();

		tipo_documentoImpl.setNew(tipo_documento.isNew());
		tipo_documentoImpl.setPrimaryKey(tipo_documento.getPrimaryKey());

		tipo_documentoImpl.set_id(tipo_documento.get_id());
		tipo_documentoImpl.setDesc(tipo_documento.getDesc());

		return tipo_documentoImpl;
	}

	/**
	 * Returns the tipo_documento with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo_documento
	 * @return the tipo_documento
	 * @throws com.liferay.portal.NoSuchModelException if a tipo_documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tipo_documento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tipo_documento with the primary key or throws a {@link co.com.csj.NoSuchtipo_documentoException} if it could not be found.
	 *
	 * @param _id the primary key of the tipo_documento
	 * @return the tipo_documento
	 * @throws co.com.csj.NoSuchtipo_documentoException if a tipo_documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public tipo_documento findByPrimaryKey(long _id)
		throws NoSuchtipo_documentoException, SystemException {
		tipo_documento tipo_documento = fetchByPrimaryKey(_id);

		if (tipo_documento == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + _id);
			}

			throw new NoSuchtipo_documentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				_id);
		}

		return tipo_documento;
	}

	/**
	 * Returns the tipo_documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipo_documento
	 * @return the tipo_documento, or <code>null</code> if a tipo_documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public tipo_documento fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the tipo_documento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param _id the primary key of the tipo_documento
	 * @return the tipo_documento, or <code>null</code> if a tipo_documento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public tipo_documento fetchByPrimaryKey(long _id) throws SystemException {
		tipo_documento tipo_documento = (tipo_documento)EntityCacheUtil.getResult(tipo_documentoModelImpl.ENTITY_CACHE_ENABLED,
				tipo_documentoImpl.class, _id);

		if (tipo_documento == _nulltipo_documento) {
			return null;
		}

		if (tipo_documento == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				tipo_documento = (tipo_documento)session.get(tipo_documentoImpl.class,
						Long.valueOf(_id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (tipo_documento != null) {
					cacheResult(tipo_documento);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(tipo_documentoModelImpl.ENTITY_CACHE_ENABLED,
						tipo_documentoImpl.class, _id, _nulltipo_documento);
				}

				closeSession(session);
			}
		}

		return tipo_documento;
	}

	/**
	 * Returns all the tipo_documentos.
	 *
	 * @return the tipo_documentos
	 * @throws SystemException if a system exception occurred
	 */
	public List<tipo_documento> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipo_documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo_documentos
	 * @param end the upper bound of the range of tipo_documentos (not inclusive)
	 * @return the range of tipo_documentos
	 * @throws SystemException if a system exception occurred
	 */
	public List<tipo_documento> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipo_documentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipo_documentos
	 * @param end the upper bound of the range of tipo_documentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipo_documentos
	 * @throws SystemException if a system exception occurred
	 */
	public List<tipo_documento> findAll(int start, int end,
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

		List<tipo_documento> list = (List<tipo_documento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TIPO_DOCUMENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIPO_DOCUMENTO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<tipo_documento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<tipo_documento>)QueryUtil.list(q,
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
	 * Removes all the tipo_documentos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (tipo_documento tipo_documento : findAll()) {
			remove(tipo_documento);
		}
	}

	/**
	 * Returns the number of tipo_documentos.
	 *
	 * @return the number of tipo_documentos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TIPO_DOCUMENTO);

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
	 * Initializes the tipo_documento persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.co.com.csj.model.tipo_documento")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<tipo_documento>> listenersList = new ArrayList<ModelListener<tipo_documento>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<tipo_documento>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(tipo_documentoImpl.class.getName());
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
	private static final String _SQL_SELECT_TIPO_DOCUMENTO = "SELECT tipo_documento FROM tipo_documento tipo_documento";
	private static final String _SQL_COUNT_TIPO_DOCUMENTO = "SELECT COUNT(tipo_documento) FROM tipo_documento tipo_documento";
	private static final String _ORDER_BY_ENTITY_ALIAS = "tipo_documento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No tipo_documento exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(tipo_documentoPersistenceImpl.class);
	private static tipo_documento _nulltipo_documento = new tipo_documentoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<tipo_documento> toCacheModel() {
				return _nulltipo_documentoCacheModel;
			}
		};

	private static CacheModel<tipo_documento> _nulltipo_documentoCacheModel = new CacheModel<tipo_documento>() {
			public tipo_documento toEntityModel() {
				return _nulltipo_documento;
			}
		};
}