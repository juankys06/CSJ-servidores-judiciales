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

package co.com.csj.service;

import co.com.csj.model.DocenciaClp;
import co.com.csj.model.alertaClp;
import co.com.csj.model.auditoriaPClp;
import co.com.csj.model.cargoClp;
import co.com.csj.model.licencia_permisoClp;
import co.com.csj.model.permisosClp;
import co.com.csj.model.tipoClp;
import co.com.csj.model.tipo_documentoClp;
import co.com.csj.model.usuarioClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"Servidores-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"Servidores-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "Servidores-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(alertaClp.class.getName())) {
			return translateInputalerta(oldModel);
		}

		if (oldModelClassName.equals(auditoriaPClp.class.getName())) {
			return translateInputauditoriaP(oldModel);
		}

		if (oldModelClassName.equals(cargoClp.class.getName())) {
			return translateInputcargo(oldModel);
		}

		if (oldModelClassName.equals(DocenciaClp.class.getName())) {
			return translateInputDocencia(oldModel);
		}

		if (oldModelClassName.equals(licencia_permisoClp.class.getName())) {
			return translateInputlicencia_permiso(oldModel);
		}

		if (oldModelClassName.equals(permisosClp.class.getName())) {
			return translateInputpermisos(oldModel);
		}

		if (oldModelClassName.equals(tipoClp.class.getName())) {
			return translateInputtipo(oldModel);
		}

		if (oldModelClassName.equals(tipo_documentoClp.class.getName())) {
			return translateInputtipo_documento(oldModel);
		}

		if (oldModelClassName.equals(usuarioClp.class.getName())) {
			return translateInputusuario(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputalerta(BaseModel<?> oldModel) {
		alertaClp oldClpModel = (alertaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getalertaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputauditoriaP(BaseModel<?> oldModel) {
		auditoriaPClp oldClpModel = (auditoriaPClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getauditoriaPRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputcargo(BaseModel<?> oldModel) {
		cargoClp oldClpModel = (cargoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getcargoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDocencia(BaseModel<?> oldModel) {
		DocenciaClp oldClpModel = (DocenciaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDocenciaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputlicencia_permiso(BaseModel<?> oldModel) {
		licencia_permisoClp oldClpModel = (licencia_permisoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getlicencia_permisoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputpermisos(BaseModel<?> oldModel) {
		permisosClp oldClpModel = (permisosClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getpermisosRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputtipo(BaseModel<?> oldModel) {
		tipoClp oldClpModel = (tipoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.gettipoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputtipo_documento(BaseModel<?> oldModel) {
		tipo_documentoClp oldClpModel = (tipo_documentoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.gettipo_documentoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputusuario(BaseModel<?> oldModel) {
		usuarioClp oldClpModel = (usuarioClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getusuarioRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("co.com.csj.model.impl.alertaImpl")) {
			return translateOutputalerta(oldModel);
		}

		if (oldModelClassName.equals("co.com.csj.model.impl.auditoriaPImpl")) {
			return translateOutputauditoriaP(oldModel);
		}

		if (oldModelClassName.equals("co.com.csj.model.impl.cargoImpl")) {
			return translateOutputcargo(oldModel);
		}

		if (oldModelClassName.equals("co.com.csj.model.impl.DocenciaImpl")) {
			return translateOutputDocencia(oldModel);
		}

		if (oldModelClassName.equals(
					"co.com.csj.model.impl.licencia_permisoImpl")) {
			return translateOutputlicencia_permiso(oldModel);
		}

		if (oldModelClassName.equals("co.com.csj.model.impl.permisosImpl")) {
			return translateOutputpermisos(oldModel);
		}

		if (oldModelClassName.equals("co.com.csj.model.impl.tipoImpl")) {
			return translateOutputtipo(oldModel);
		}

		if (oldModelClassName.equals("co.com.csj.model.impl.tipo_documentoImpl")) {
			return translateOutputtipo_documento(oldModel);
		}

		if (oldModelClassName.equals("co.com.csj.model.impl.usuarioImpl")) {
			return translateOutputusuario(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("co.com.csj.NoSuchalertaException")) {
			return new co.com.csj.NoSuchalertaException();
		}

		if (className.equals("co.com.csj.NoSuchauditoriaPException")) {
			return new co.com.csj.NoSuchauditoriaPException();
		}

		if (className.equals("co.com.csj.NoSuchcargoException")) {
			return new co.com.csj.NoSuchcargoException();
		}

		if (className.equals("co.com.csj.NoSuchDocenciaException")) {
			return new co.com.csj.NoSuchDocenciaException();
		}

		if (className.equals("co.com.csj.NoSuchlicencia_permisoException")) {
			return new co.com.csj.NoSuchlicencia_permisoException();
		}

		if (className.equals("co.com.csj.NoSuchpermisosException")) {
			return new co.com.csj.NoSuchpermisosException();
		}

		if (className.equals("co.com.csj.NoSuchtipoException")) {
			return new co.com.csj.NoSuchtipoException();
		}

		if (className.equals("co.com.csj.NoSuchtipo_documentoException")) {
			return new co.com.csj.NoSuchtipo_documentoException();
		}

		if (className.equals("co.com.csj.NoSuchusuarioException")) {
			return new co.com.csj.NoSuchusuarioException();
		}

		return throwable;
	}

	public static Object translateOutputalerta(BaseModel<?> oldModel) {
		alertaClp newModel = new alertaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setalertaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputauditoriaP(BaseModel<?> oldModel) {
		auditoriaPClp newModel = new auditoriaPClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setauditoriaPRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputcargo(BaseModel<?> oldModel) {
		cargoClp newModel = new cargoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setcargoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDocencia(BaseModel<?> oldModel) {
		DocenciaClp newModel = new DocenciaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDocenciaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputlicencia_permiso(BaseModel<?> oldModel) {
		licencia_permisoClp newModel = new licencia_permisoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setlicencia_permisoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputpermisos(BaseModel<?> oldModel) {
		permisosClp newModel = new permisosClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setpermisosRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputtipo(BaseModel<?> oldModel) {
		tipoClp newModel = new tipoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.settipoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputtipo_documento(BaseModel<?> oldModel) {
		tipo_documentoClp newModel = new tipo_documentoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.settipo_documentoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputusuario(BaseModel<?> oldModel) {
		usuarioClp newModel = new usuarioClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setusuarioRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}