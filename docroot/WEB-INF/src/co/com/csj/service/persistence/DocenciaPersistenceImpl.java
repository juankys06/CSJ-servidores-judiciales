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

import co.com.csj.NoSuchDocenciaException;
import co.com.csj.model.Docencia;
import co.com.csj.model.impl.DocenciaImpl;
import co.com.csj.model.impl.DocenciaModelImpl;

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
 * The persistence implementation for the docencia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author villartech
 * @see DocenciaPersistence
 * @see DocenciaUtil
 * @generated
 */
public class DocenciaPersistenceImpl extends BasePersistenceImpl<Docencia>
	implements DocenciaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DocenciaUtil} to access the docencia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DocenciaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATOR = new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, DocenciaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCreator",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR =
		new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, DocenciaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCreator",
			new String[] { Long.class.getName() },
			DocenciaModelImpl.CREADOPOR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATOR = new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreator",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ESTATUS = new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, DocenciaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEstatus",
			new String[] {
				Integer.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESTATUS =
		new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, DocenciaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEstatus",
			new String[] { Integer.class.getName() },
			DocenciaModelImpl.ESTATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ESTATUS = new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEstatus",
			new String[] { Integer.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESPACHO = new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, DocenciaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDespacho",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESPACHO =
		new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, DocenciaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDespacho",
			new String[] { String.class.getName() },
			DocenciaModelImpl.DESPACHO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESPACHO = new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDespacho",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCENTE = new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, DocenciaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDocente",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCENTE =
		new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, DocenciaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDocente",
			new String[] { String.class.getName() },
			DocenciaModelImpl.USUARIO_FK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DOCENTE = new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDocente",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, DocenciaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, DocenciaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the docencia in the entity cache if it is enabled.
	 *
	 * @param docencia the docencia
	 */
	public void cacheResult(Docencia docencia) {
		EntityCacheUtil.putResult(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaImpl.class, docencia.getPrimaryKey(), docencia);

		docencia.resetOriginalValues();
	}

	/**
	 * Caches the docencias in the entity cache if it is enabled.
	 *
	 * @param docencias the docencias
	 */
	public void cacheResult(List<Docencia> docencias) {
		for (Docencia docencia : docencias) {
			if (EntityCacheUtil.getResult(
						DocenciaModelImpl.ENTITY_CACHE_ENABLED,
						DocenciaImpl.class, docencia.getPrimaryKey()) == null) {
				cacheResult(docencia);
			}
			else {
				docencia.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all docencias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DocenciaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DocenciaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the docencia.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Docencia docencia) {
		EntityCacheUtil.removeResult(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaImpl.class, docencia.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Docencia> docencias) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Docencia docencia : docencias) {
			EntityCacheUtil.removeResult(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
				DocenciaImpl.class, docencia.getPrimaryKey());
		}
	}

	/**
	 * Creates a new docencia with the primary key. Does not add the docencia to the database.
	 *
	 * @param id the primary key for the new docencia
	 * @return the new docencia
	 */
	public Docencia create(long id) {
		Docencia docencia = new DocenciaImpl();

		docencia.setNew(true);
		docencia.setPrimaryKey(id);

		return docencia;
	}

	/**
	 * Removes the docencia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the docencia
	 * @return the docencia that was removed
	 * @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia remove(long id)
		throws NoSuchDocenciaException, SystemException {
		return remove(Long.valueOf(id));
	}

	/**
	 * Removes the docencia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the docencia
	 * @return the docencia that was removed
	 * @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Docencia remove(Serializable primaryKey)
		throws NoSuchDocenciaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Docencia docencia = (Docencia)session.get(DocenciaImpl.class,
					primaryKey);

			if (docencia == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDocenciaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(docencia);
		}
		catch (NoSuchDocenciaException nsee) {
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
	protected Docencia removeImpl(Docencia docencia) throws SystemException {
		docencia = toUnwrappedModel(docencia);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, docencia);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(docencia);

		return docencia;
	}

	@Override
	public Docencia updateImpl(co.com.csj.model.Docencia docencia, boolean merge)
		throws SystemException {
		docencia = toUnwrappedModel(docencia);

		boolean isNew = docencia.isNew();

		DocenciaModelImpl docenciaModelImpl = (DocenciaModelImpl)docencia;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, docencia, merge);

			docencia.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DocenciaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((docenciaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(docenciaModelImpl.getOriginalCreadoPor())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR,
					args);

				args = new Object[] {
						Long.valueOf(docenciaModelImpl.getCreadoPor())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR,
					args);
			}

			if ((docenciaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Integer.valueOf(docenciaModelImpl.getOriginalEstatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESTATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESTATUS,
					args);

				args = new Object[] {
						Integer.valueOf(docenciaModelImpl.getEstatus())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ESTATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ESTATUS,
					args);
			}

			if ((docenciaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESPACHO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						docenciaModelImpl.getOriginalDespacho()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESPACHO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESPACHO,
					args);

				args = new Object[] { docenciaModelImpl.getDespacho() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DESPACHO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESPACHO,
					args);
			}

			if ((docenciaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCENTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						docenciaModelImpl.getOriginalUsuario_fk()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCENTE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCENTE,
					args);

				args = new Object[] { docenciaModelImpl.getUsuario_fk() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DOCENTE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCENTE,
					args);
			}
		}

		EntityCacheUtil.putResult(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
			DocenciaImpl.class, docencia.getPrimaryKey(), docencia);

		return docencia;
	}

	protected Docencia toUnwrappedModel(Docencia docencia) {
		if (docencia instanceof DocenciaImpl) {
			return docencia;
		}

		DocenciaImpl docenciaImpl = new DocenciaImpl();

		docenciaImpl.setNew(docencia.isNew());
		docenciaImpl.setPrimaryKey(docencia.getPrimaryKey());

		docenciaImpl.setId(docencia.getId());
		docenciaImpl.setUsuario_fk(docencia.getUsuario_fk());
		docenciaImpl.setFechaInicial(docencia.getFechaInicial());
		docenciaImpl.setFechaFinal(docencia.getFechaFinal());
		docenciaImpl.setMateria(docencia.getMateria());
		docenciaImpl.setInstitucion(docencia.getInstitucion());
		docenciaImpl.setDespacho(docencia.getDespacho());
		docenciaImpl.setCreadoPor(docencia.getCreadoPor());
		docenciaImpl.setModificadoPor(docencia.getModificadoPor());
		docenciaImpl.setEstatus(docencia.getEstatus());
		docenciaImpl.setHoras(docencia.getHoras());
		docenciaImpl.setMinutos(docencia.getMinutos());
		docenciaImpl.setCargo(docencia.getCargo());
		docenciaImpl.setFechaRegistro(docencia.getFechaRegistro());

		return docenciaImpl;
	}

	/**
	 * Returns the docencia with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the docencia
	 * @return the docencia
	 * @throws com.liferay.portal.NoSuchModelException if a docencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Docencia findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the docencia with the primary key or throws a {@link co.com.csj.NoSuchDocenciaException} if it could not be found.
	 *
	 * @param id the primary key of the docencia
	 * @return the docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia findByPrimaryKey(long id)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = fetchByPrimaryKey(id);

		if (docencia == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
			}

			throw new NoSuchDocenciaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				id);
		}

		return docencia;
	}

	/**
	 * Returns the docencia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the docencia
	 * @return the docencia, or <code>null</code> if a docencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Docencia fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the docencia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the docencia
	 * @return the docencia, or <code>null</code> if a docencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia fetchByPrimaryKey(long id) throws SystemException {
		Docencia docencia = (Docencia)EntityCacheUtil.getResult(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
				DocenciaImpl.class, id);

		if (docencia == _nullDocencia) {
			return null;
		}

		if (docencia == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				docencia = (Docencia)session.get(DocenciaImpl.class,
						Long.valueOf(id));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (docencia != null) {
					cacheResult(docencia);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(DocenciaModelImpl.ENTITY_CACHE_ENABLED,
						DocenciaImpl.class, id, _nullDocencia);
				}

				closeSession(session);
			}
		}

		return docencia;
	}

	/**
	 * Returns all the docencias where creadoPor = &#63;.
	 *
	 * @param creadoPor the creado por
	 * @return the matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findByCreator(long creadoPor)
		throws SystemException {
		return findByCreator(creadoPor, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the docencias where creadoPor = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param creadoPor the creado por
	 * @param start the lower bound of the range of docencias
	 * @param end the upper bound of the range of docencias (not inclusive)
	 * @return the range of matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findByCreator(long creadoPor, int start, int end)
		throws SystemException {
		return findByCreator(creadoPor, start, end, null);
	}

	/**
	 * Returns an ordered range of all the docencias where creadoPor = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param creadoPor the creado por
	 * @param start the lower bound of the range of docencias
	 * @param end the upper bound of the range of docencias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findByCreator(long creadoPor, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Docencia> list = (List<Docencia>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Docencia docencia : list) {
				if ((creadoPor != docencia.getCreadoPor())) {
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

			query.append(_SQL_SELECT_DOCENCIA_WHERE);

			query.append(_FINDER_COLUMN_CREATOR_CREADOPOR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DocenciaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creadoPor);

				list = (List<Docencia>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first docencia in the ordered set where creadoPor = &#63;.
	 *
	 * @param creadoPor the creado por
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia findByCreator_First(long creadoPor,
		OrderByComparator orderByComparator)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = fetchByCreator_First(creadoPor, orderByComparator);

		if (docencia != null) {
			return docencia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creadoPor=");
		msg.append(creadoPor);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocenciaException(msg.toString());
	}

	/**
	 * Returns the first docencia in the ordered set where creadoPor = &#63;.
	 *
	 * @param creadoPor the creado por
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docencia, or <code>null</code> if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia fetchByCreator_First(long creadoPor,
		OrderByComparator orderByComparator) throws SystemException {
		List<Docencia> list = findByCreator(creadoPor, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last docencia in the ordered set where creadoPor = &#63;.
	 *
	 * @param creadoPor the creado por
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia findByCreator_Last(long creadoPor,
		OrderByComparator orderByComparator)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = fetchByCreator_Last(creadoPor, orderByComparator);

		if (docencia != null) {
			return docencia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creadoPor=");
		msg.append(creadoPor);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocenciaException(msg.toString());
	}

	/**
	 * Returns the last docencia in the ordered set where creadoPor = &#63;.
	 *
	 * @param creadoPor the creado por
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docencia, or <code>null</code> if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia fetchByCreator_Last(long creadoPor,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCreator(creadoPor);

		List<Docencia> list = findByCreator(creadoPor, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the docencias before and after the current docencia in the ordered set where creadoPor = &#63;.
	 *
	 * @param id the primary key of the current docencia
	 * @param creadoPor the creado por
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia[] findByCreator_PrevAndNext(long id, long creadoPor,
		OrderByComparator orderByComparator)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Docencia[] array = new DocenciaImpl[3];

			array[0] = getByCreator_PrevAndNext(session, docencia, creadoPor,
					orderByComparator, true);

			array[1] = docencia;

			array[2] = getByCreator_PrevAndNext(session, docencia, creadoPor,
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

	protected Docencia getByCreator_PrevAndNext(Session session,
		Docencia docencia, long creadoPor, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCENCIA_WHERE);

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
			query.append(DocenciaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(creadoPor);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(docencia);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Docencia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the docencias where estatus = &#63;.
	 *
	 * @param estatus the estatus
	 * @return the matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findByEstatus(int estatus) throws SystemException {
		return findByEstatus(estatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the docencias where estatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param estatus the estatus
	 * @param start the lower bound of the range of docencias
	 * @param end the upper bound of the range of docencias (not inclusive)
	 * @return the range of matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findByEstatus(int estatus, int start, int end)
		throws SystemException {
		return findByEstatus(estatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the docencias where estatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param estatus the estatus
	 * @param start the lower bound of the range of docencias
	 * @param end the upper bound of the range of docencias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findByEstatus(int estatus, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Docencia> list = (List<Docencia>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Docencia docencia : list) {
				if ((estatus != docencia.getEstatus())) {
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

			query.append(_SQL_SELECT_DOCENCIA_WHERE);

			query.append(_FINDER_COLUMN_ESTATUS_ESTATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DocenciaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(estatus);

				list = (List<Docencia>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first docencia in the ordered set where estatus = &#63;.
	 *
	 * @param estatus the estatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia findByEstatus_First(int estatus,
		OrderByComparator orderByComparator)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = fetchByEstatus_First(estatus, orderByComparator);

		if (docencia != null) {
			return docencia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("estatus=");
		msg.append(estatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocenciaException(msg.toString());
	}

	/**
	 * Returns the first docencia in the ordered set where estatus = &#63;.
	 *
	 * @param estatus the estatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docencia, or <code>null</code> if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia fetchByEstatus_First(int estatus,
		OrderByComparator orderByComparator) throws SystemException {
		List<Docencia> list = findByEstatus(estatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last docencia in the ordered set where estatus = &#63;.
	 *
	 * @param estatus the estatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia findByEstatus_Last(int estatus,
		OrderByComparator orderByComparator)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = fetchByEstatus_Last(estatus, orderByComparator);

		if (docencia != null) {
			return docencia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("estatus=");
		msg.append(estatus);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocenciaException(msg.toString());
	}

	/**
	 * Returns the last docencia in the ordered set where estatus = &#63;.
	 *
	 * @param estatus the estatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docencia, or <code>null</code> if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia fetchByEstatus_Last(int estatus,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEstatus(estatus);

		List<Docencia> list = findByEstatus(estatus, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the docencias before and after the current docencia in the ordered set where estatus = &#63;.
	 *
	 * @param id the primary key of the current docencia
	 * @param estatus the estatus
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia[] findByEstatus_PrevAndNext(long id, int estatus,
		OrderByComparator orderByComparator)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Docencia[] array = new DocenciaImpl[3];

			array[0] = getByEstatus_PrevAndNext(session, docencia, estatus,
					orderByComparator, true);

			array[1] = docencia;

			array[2] = getByEstatus_PrevAndNext(session, docencia, estatus,
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

	protected Docencia getByEstatus_PrevAndNext(Session session,
		Docencia docencia, int estatus, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCENCIA_WHERE);

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
			query.append(DocenciaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(estatus);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(docencia);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Docencia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the docencias where despacho = &#63;.
	 *
	 * @param despacho the despacho
	 * @return the matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findByDespacho(String despacho)
		throws SystemException {
		return findByDespacho(despacho, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the docencias where despacho = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param despacho the despacho
	 * @param start the lower bound of the range of docencias
	 * @param end the upper bound of the range of docencias (not inclusive)
	 * @return the range of matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findByDespacho(String despacho, int start, int end)
		throws SystemException {
		return findByDespacho(despacho, start, end, null);
	}

	/**
	 * Returns an ordered range of all the docencias where despacho = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param despacho the despacho
	 * @param start the lower bound of the range of docencias
	 * @param end the upper bound of the range of docencias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findByDespacho(String despacho, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Docencia> list = (List<Docencia>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Docencia docencia : list) {
				if (!Validator.equals(despacho, docencia.getDespacho())) {
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

			query.append(_SQL_SELECT_DOCENCIA_WHERE);

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
				query.append(DocenciaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Docencia>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first docencia in the ordered set where despacho = &#63;.
	 *
	 * @param despacho the despacho
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia findByDespacho_First(String despacho,
		OrderByComparator orderByComparator)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = fetchByDespacho_First(despacho, orderByComparator);

		if (docencia != null) {
			return docencia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("despacho=");
		msg.append(despacho);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocenciaException(msg.toString());
	}

	/**
	 * Returns the first docencia in the ordered set where despacho = &#63;.
	 *
	 * @param despacho the despacho
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docencia, or <code>null</code> if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia fetchByDespacho_First(String despacho,
		OrderByComparator orderByComparator) throws SystemException {
		List<Docencia> list = findByDespacho(despacho, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last docencia in the ordered set where despacho = &#63;.
	 *
	 * @param despacho the despacho
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia findByDespacho_Last(String despacho,
		OrderByComparator orderByComparator)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = fetchByDespacho_Last(despacho, orderByComparator);

		if (docencia != null) {
			return docencia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("despacho=");
		msg.append(despacho);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocenciaException(msg.toString());
	}

	/**
	 * Returns the last docencia in the ordered set where despacho = &#63;.
	 *
	 * @param despacho the despacho
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docencia, or <code>null</code> if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia fetchByDespacho_Last(String despacho,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDespacho(despacho);

		List<Docencia> list = findByDespacho(despacho, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the docencias before and after the current docencia in the ordered set where despacho = &#63;.
	 *
	 * @param id the primary key of the current docencia
	 * @param despacho the despacho
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia[] findByDespacho_PrevAndNext(long id, String despacho,
		OrderByComparator orderByComparator)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Docencia[] array = new DocenciaImpl[3];

			array[0] = getByDespacho_PrevAndNext(session, docencia, despacho,
					orderByComparator, true);

			array[1] = docencia;

			array[2] = getByDespacho_PrevAndNext(session, docencia, despacho,
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

	protected Docencia getByDespacho_PrevAndNext(Session session,
		Docencia docencia, String despacho,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCENCIA_WHERE);

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
			query.append(DocenciaModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(docencia);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Docencia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the docencias where usuario_fk = &#63;.
	 *
	 * @param usuario_fk the usuario_fk
	 * @return the matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findByDocente(String usuario_fk)
		throws SystemException {
		return findByDocente(usuario_fk, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the docencias where usuario_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param usuario_fk the usuario_fk
	 * @param start the lower bound of the range of docencias
	 * @param end the upper bound of the range of docencias (not inclusive)
	 * @return the range of matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findByDocente(String usuario_fk, int start, int end)
		throws SystemException {
		return findByDocente(usuario_fk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the docencias where usuario_fk = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param usuario_fk the usuario_fk
	 * @param start the lower bound of the range of docencias
	 * @param end the upper bound of the range of docencias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findByDocente(String usuario_fk, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DOCENTE;
			finderArgs = new Object[] { usuario_fk };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DOCENTE;
			finderArgs = new Object[] { usuario_fk, start, end, orderByComparator };
		}

		List<Docencia> list = (List<Docencia>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Docencia docencia : list) {
				if (!Validator.equals(usuario_fk, docencia.getUsuario_fk())) {
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

			query.append(_SQL_SELECT_DOCENCIA_WHERE);

			if (usuario_fk == null) {
				query.append(_FINDER_COLUMN_DOCENTE_USUARIO_FK_1);
			}
			else {
				if (usuario_fk.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DOCENTE_USUARIO_FK_3);
				}
				else {
					query.append(_FINDER_COLUMN_DOCENTE_USUARIO_FK_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(DocenciaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (usuario_fk != null) {
					qPos.add(usuario_fk);
				}

				list = (List<Docencia>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first docencia in the ordered set where usuario_fk = &#63;.
	 *
	 * @param usuario_fk the usuario_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia findByDocente_First(String usuario_fk,
		OrderByComparator orderByComparator)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = fetchByDocente_First(usuario_fk, orderByComparator);

		if (docencia != null) {
			return docencia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("usuario_fk=");
		msg.append(usuario_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocenciaException(msg.toString());
	}

	/**
	 * Returns the first docencia in the ordered set where usuario_fk = &#63;.
	 *
	 * @param usuario_fk the usuario_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching docencia, or <code>null</code> if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia fetchByDocente_First(String usuario_fk,
		OrderByComparator orderByComparator) throws SystemException {
		List<Docencia> list = findByDocente(usuario_fk, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last docencia in the ordered set where usuario_fk = &#63;.
	 *
	 * @param usuario_fk the usuario_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia findByDocente_Last(String usuario_fk,
		OrderByComparator orderByComparator)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = fetchByDocente_Last(usuario_fk, orderByComparator);

		if (docencia != null) {
			return docencia;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("usuario_fk=");
		msg.append(usuario_fk);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDocenciaException(msg.toString());
	}

	/**
	 * Returns the last docencia in the ordered set where usuario_fk = &#63;.
	 *
	 * @param usuario_fk the usuario_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching docencia, or <code>null</code> if a matching docencia could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia fetchByDocente_Last(String usuario_fk,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDocente(usuario_fk);

		List<Docencia> list = findByDocente(usuario_fk, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the docencias before and after the current docencia in the ordered set where usuario_fk = &#63;.
	 *
	 * @param id the primary key of the current docencia
	 * @param usuario_fk the usuario_fk
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next docencia
	 * @throws co.com.csj.NoSuchDocenciaException if a docencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Docencia[] findByDocente_PrevAndNext(long id, String usuario_fk,
		OrderByComparator orderByComparator)
		throws NoSuchDocenciaException, SystemException {
		Docencia docencia = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Docencia[] array = new DocenciaImpl[3];

			array[0] = getByDocente_PrevAndNext(session, docencia, usuario_fk,
					orderByComparator, true);

			array[1] = docencia;

			array[2] = getByDocente_PrevAndNext(session, docencia, usuario_fk,
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

	protected Docencia getByDocente_PrevAndNext(Session session,
		Docencia docencia, String usuario_fk,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DOCENCIA_WHERE);

		if (usuario_fk == null) {
			query.append(_FINDER_COLUMN_DOCENTE_USUARIO_FK_1);
		}
		else {
			if (usuario_fk.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DOCENTE_USUARIO_FK_3);
			}
			else {
				query.append(_FINDER_COLUMN_DOCENTE_USUARIO_FK_2);
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
			query.append(DocenciaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (usuario_fk != null) {
			qPos.add(usuario_fk);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(docencia);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Docencia> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the docencias.
	 *
	 * @return the docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the docencias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of docencias
	 * @param end the upper bound of the range of docencias (not inclusive)
	 * @return the range of docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the docencias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of docencias
	 * @param end the upper bound of the range of docencias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of docencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Docencia> findAll(int start, int end,
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

		List<Docencia> list = (List<Docencia>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DOCENCIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DOCENCIA.concat(DocenciaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Docencia>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Docencia>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the docencias where creadoPor = &#63; from the database.
	 *
	 * @param creadoPor the creado por
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCreator(long creadoPor) throws SystemException {
		for (Docencia docencia : findByCreator(creadoPor)) {
			remove(docencia);
		}
	}

	/**
	 * Removes all the docencias where estatus = &#63; from the database.
	 *
	 * @param estatus the estatus
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByEstatus(int estatus) throws SystemException {
		for (Docencia docencia : findByEstatus(estatus)) {
			remove(docencia);
		}
	}

	/**
	 * Removes all the docencias where despacho = &#63; from the database.
	 *
	 * @param despacho the despacho
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDespacho(String despacho) throws SystemException {
		for (Docencia docencia : findByDespacho(despacho)) {
			remove(docencia);
		}
	}

	/**
	 * Removes all the docencias where usuario_fk = &#63; from the database.
	 *
	 * @param usuario_fk the usuario_fk
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByDocente(String usuario_fk) throws SystemException {
		for (Docencia docencia : findByDocente(usuario_fk)) {
			remove(docencia);
		}
	}

	/**
	 * Removes all the docencias from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Docencia docencia : findAll()) {
			remove(docencia);
		}
	}

	/**
	 * Returns the number of docencias where creadoPor = &#63;.
	 *
	 * @param creadoPor the creado por
	 * @return the number of matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCreator(long creadoPor) throws SystemException {
		Object[] finderArgs = new Object[] { creadoPor };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATOR,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCENCIA_WHERE);

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
	 * Returns the number of docencias where estatus = &#63;.
	 *
	 * @param estatus the estatus
	 * @return the number of matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public int countByEstatus(int estatus) throws SystemException {
		Object[] finderArgs = new Object[] { estatus };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ESTATUS,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCENCIA_WHERE);

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
	 * Returns the number of docencias where despacho = &#63;.
	 *
	 * @param despacho the despacho
	 * @return the number of matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDespacho(String despacho) throws SystemException {
		Object[] finderArgs = new Object[] { despacho };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DESPACHO,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCENCIA_WHERE);

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
	 * Returns the number of docencias where usuario_fk = &#63;.
	 *
	 * @param usuario_fk the usuario_fk
	 * @return the number of matching docencias
	 * @throws SystemException if a system exception occurred
	 */
	public int countByDocente(String usuario_fk) throws SystemException {
		Object[] finderArgs = new Object[] { usuario_fk };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DOCENTE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DOCENCIA_WHERE);

			if (usuario_fk == null) {
				query.append(_FINDER_COLUMN_DOCENTE_USUARIO_FK_1);
			}
			else {
				if (usuario_fk.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_DOCENTE_USUARIO_FK_3);
				}
				else {
					query.append(_FINDER_COLUMN_DOCENTE_USUARIO_FK_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (usuario_fk != null) {
					qPos.add(usuario_fk);
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

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOCENTE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of docencias.
	 *
	 * @return the number of docencias
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_DOCENCIA);

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
	 * Initializes the docencia persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.co.com.csj.model.Docencia")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Docencia>> listenersList = new ArrayList<ModelListener<Docencia>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Docencia>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DocenciaImpl.class.getName());
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
	private static final String _SQL_SELECT_DOCENCIA = "SELECT docencia FROM Docencia docencia";
	private static final String _SQL_SELECT_DOCENCIA_WHERE = "SELECT docencia FROM Docencia docencia WHERE ";
	private static final String _SQL_COUNT_DOCENCIA = "SELECT COUNT(docencia) FROM Docencia docencia";
	private static final String _SQL_COUNT_DOCENCIA_WHERE = "SELECT COUNT(docencia) FROM Docencia docencia WHERE ";
	private static final String _FINDER_COLUMN_CREATOR_CREADOPOR_2 = "docencia.creadoPor = ? AND docencia.estatus = 1";
	private static final String _FINDER_COLUMN_ESTATUS_ESTATUS_2 = "docencia.estatus = ?";
	private static final String _FINDER_COLUMN_DESPACHO_DESPACHO_1 = "docencia.despacho IS NULL AND docencia.estatus = 1";
	private static final String _FINDER_COLUMN_DESPACHO_DESPACHO_2 = "docencia.despacho = ? AND docencia.estatus = 1";
	private static final String _FINDER_COLUMN_DESPACHO_DESPACHO_3 = "(docencia.despacho IS NULL OR docencia.despacho = ?) AND docencia.estatus = 1";
	private static final String _FINDER_COLUMN_DOCENTE_USUARIO_FK_1 = "docencia.usuario_fk IS NULL AND docencia.estatus = 1";
	private static final String _FINDER_COLUMN_DOCENTE_USUARIO_FK_2 = "docencia.usuario_fk = ? AND docencia.estatus = 1";
	private static final String _FINDER_COLUMN_DOCENTE_USUARIO_FK_3 = "(docencia.usuario_fk IS NULL OR docencia.usuario_fk = ?) AND docencia.estatus = 1";
	private static final String _ORDER_BY_ENTITY_ALIAS = "docencia.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Docencia exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Docencia exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DocenciaPersistenceImpl.class);
	private static Docencia _nullDocencia = new DocenciaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Docencia> toCacheModel() {
				return _nullDocenciaCacheModel;
			}
		};

	private static CacheModel<Docencia> _nullDocenciaCacheModel = new CacheModel<Docencia>() {
			public Docencia toEntityModel() {
				return _nullDocencia;
			}
		};
}