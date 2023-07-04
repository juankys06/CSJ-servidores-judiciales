package co.com.csj.modelos;

import co.com.csj.model.Docencia;
import co.com.csj.model.auditoriaP;
import co.com.csj.model.auditoriaPClp;
import co.com.csj.model.licencia_permiso;
import co.com.csj.model.permisos;
import co.com.csj.modelos.Area;
import co.com.csj.modelos.despacho;
import co.com.csj.modelos.entidad;
import co.com.csj.modelos.especialidad;
import co.com.csj.modelos.localizacion;
import co.com.csj.persistence.PersistenceUtil;
import co.com.csj.service.DocenciaLocalServiceUtil;
import co.com.csj.service.licencia_permisoLocalServiceUtil;
import co.com.csj.service.permisosLocalServiceUtil;

import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

public final class consultas {
	
	private static String BDPortal = "lportalramaprod";
    private static String BDApps = "APPsPortal";
	
    public static List<Area> obtenerAreas() {
        ArrayList<Area> areas = new ArrayList<Area>();
        String _SQL = "SELECT id, nombre FROM ADM_AREA;";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    Area area = new Area(result.getInt(1), result.getString(2));
                    areas.add(area);
                }
            } else {
                System.out.println("La consulta sobre areas retorno nada.");
            }
        }
        catch (SQLException e) {
            System.out.println("Error en la consulta de la BD a despacho: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("Error  excepcion  " + e.getMessage());
        }
        return areas;
    }

    public static List<localizacion> obtenerMunicipios(String codDepar) {
        ArrayList<localizacion> lista = new ArrayList<localizacion>();
        String _SQL = "select cod_dane,cod_dane_departamento,nombre from ADM_LOCALIZACION where nombre!='' and cod_dane!=cod_dane_departamento and cod_dane_departamento = '" + codDepar + "' ORDER BY nombre ASC";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    localizacion l = new localizacion();
                    l.setCod_dane(result.getString(1));
                    l.setCod_dane_departamento(result.getString(2));
                    l.setNombre(result.getString(3));
                    lista.add(l);
                }
            } else {
                System.out.println("La consulta sobre municipios retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException bde) {
            bde.printStackTrace();
            System.out.println("Error en la consulta de municipios de la BD: " + bde.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return lista;
    }
    
    public static List<localizacion> obtenerMunicipiosR(String userCod) {
        ArrayList<localizacion> lista = new ArrayList<localizacion>();
        String _SQL = "select cod_dane,cod_dane_departamento,nombre from ADM_LOCALIZACION where nombre!='' and cod_dane!=cod_dane_departamento and cod_dane_departamento in (select departamento_municipio from "+BDApps+".dbo.SJ_permiso_usuario where usuario = '"+userCod+"' ) ORDER BY nombre ASC";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    localizacion l = new localizacion();
                    l.setCod_dane(result.getString(1));
                    l.setCod_dane_departamento(result.getString(2));
                    l.setNombre(result.getString(3));
                    lista.add(l);
                }
            } else {
                System.out.println("La consulta sobre municipios retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException bde) {
            bde.printStackTrace();
            System.out.println("Error en la consulta de municipios de la BD: " + bde.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return lista;
    }

    public static List<localizacion> obtenerMunicipio(String cod) {
        ArrayList<localizacion> lista = new ArrayList<localizacion>();
        String _SQL = "SELECT cod_dane,cod_dane_departamento,nombre FROM ADM_LOCALIZACION WHERE (cod_dane_departamento + cod_dane) LIKE '%" + cod + "%' ORDER BY nombre ASC";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    localizacion l = new localizacion();
                    l.setCod_dane(result.getString(1));
                    l.setCod_dane_departamento(result.getString(2));
                    l.setNombre(result.getString(3));
                    lista.add(l);
                }
            } else {
                System.out.println("La consulta sobre Municipios retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error en la consulta de municipios en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return lista;
    }

    public static List<localizacion> obtenerMDepartamentos() {
        ArrayList<localizacion> lista = new ArrayList<localizacion>();
        String _SQL = "SELECT cod_dane, cod_dane_departamento, nombre FROM ADM_LOCALIZACION where cod_dane=cod_dane_departamento ORDER BY nombre ASC";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    localizacion l = new localizacion();
                    l.setCod_dane(result.getString(1));
                    l.setCod_dane_departamento(result.getString(2));
                    l.setNombre(result.getString(3));
                    lista.add(l);
                }
            } else {
                System.out.println("La consulta sobre departamentos retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error en la consulta de departamentos en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return lista;
    }

    public static List<localizacion> obtenerTodosMuni() {
        ArrayList<localizacion> lista = new ArrayList<localizacion>();
        String _SQL = "SELECT cod_dane,cod_dane_departamento,nombre FROM ADM_LOCALIZACION WHERE cod_dane!=cod_dane_departamento ORDER BY nombre ASC";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    localizacion l = new localizacion();
                    l.setCod_dane(result.getString(1));
                    l.setCod_dane_departamento(result.getString(2));
                    l.setNombre(result.getString(3));
                    lista.add(l);
                }
            } else {
                System.out.println("La consulta sobre municipios retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error en la consulta de municipios en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return lista;
    }

    public static List<despacho> obtenerDespacho(String cod) {
        ArrayList<despacho> lista = new ArrayList<despacho>();
        String _SQL = "SELECT codigo, nombre, area FROM fun_despacho_info WHERE codigo LIKE '%" + cod + "%' and FK_ESTADO_TO_DESPACHO =1 ORDER BY nombre ASC";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    despacho l = new despacho(result.getString(1), result.getString(2), result.getInt(3),"");
                    lista.add(l);
                }
            } else {
                System.out.println("La consulta sobre despachos retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error en la consulta de la BD a despacho: " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return lista;
    }

    public static List<despacho> obtenerDespacho(String cod, String area) {
        ArrayList<despacho> lista = new ArrayList<despacho>();
        String _SQL = "SELECT codigo, nombre, area FROM fun_despacho_info WHERE codigo LIKE '" + cod + "%' and FK_ESTADO_TO_DESPACHO =1 ";
        if (area != null && !area.equals("")) {
            _SQL = String.valueOf(_SQL) + "AND area = " + area;
        }
        _SQL = String.valueOf(_SQL) + " ORDER BY nombre ASC;";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    despacho l = new despacho(result.getString(1), result.getString(2), result.getInt(3),"");
                    lista.add(l);
                }
            } else {
                System.out.println("La consulta sobre despachos retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error en la consulta de la BD a despacho: " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return lista;
    }

    public static despacho obtenerDespachoSel(String cod) {
        despacho lista = new despacho();
        String _SQL = "SELECT codigo, nombre, area FROM fun_despacho_info WHERE codigo = '" + cod + "' ORDER BY nombre ASC";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    lista.setCodigo(result.getString(1));
                    lista.setNombre(result.getString(2));
                }
            } else {
                System.out.println("La consulta sobre despacho retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error en la consulta de la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return lista;
    }

    public static List<especialidad> obtenerEspecialidad(String cod) {
        ArrayList<especialidad> lista = new ArrayList<especialidad>();
        String _SQL = "SELECT e.codigo,e.nombre FROM ADM_ENTIDAD_ESPECIALIDAD ee JOIN ADM_ESPECIALIDAD e ON(ee.id_especialidad=e.codigo) WHERE ee.id_entidad='" + cod + "'";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    especialidad l = new especialidad();
                    l.setId(result.getString(1));
                    l.setNombre(result.getString(2));
                    lista.add(l);
                }
            } else {
                System.out.println("La consulta sobre especialidades retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error en la consulta de la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return lista;
    }

    public static List<entidad> obtenerEntidades() {
        ArrayList<entidad> lista = new ArrayList<entidad>();
        String _SQL = "SELECT codigo,nombre FROM ADM_ENTIDAD WHERE estado=1 ORDER BY nombre ASC";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    entidad l = new entidad();
                    l.setId(result.getString(1));
                    l.setNombre(result.getString(2));
                    lista.add(l);
                }
            } else {
                System.out.println("La consulta sobre entidades retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return lista;
    }

    public static List<especialidad> obtenerEspecialidades() {
        ArrayList<especialidad> lista = new ArrayList<especialidad>();
        String _SQL = "SELECT codigo,nombre FROM ADM_ESPECIALIDAD WHERE estado=1 ORDER BY nombre ASC";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    especialidad l = new especialidad();
                    l.setId(result.getString(1));
                    l.setNombre(result.getString(2));
                    lista.add(l);
                }
            } else {
                System.out.println("La consulta sobre especialidades retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de especialidades desde la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return lista;
    }

    public static String obtenerDistrito(String cod) {
        String respuesta = "No Encontrado";
        String _SQL = 	"select distri.NOMBRE "+
						"from fun_despacho_info despa join ADM_ENTIDAD enti on (SUBSTRING(despa.CODIGO,6,2)=enti.CODIGO) "+
						"join ADM_MAPA_JUDICIAL mapa on (mapa.FK_DANEMUNI_TO_MAPA=SUBSTRING(despa.CODIGO,3,3) and mapa.FK_DANEDEPAR_TO_MAPA=SUBSTRING(despa.CODIGO,1,2) and mapa.FK_JURIDICCION_TO_MAPA=enti.FK_ENTIDAD_TO_JURIDICCION) "+
						"join ADM_CIRCUITO circu on (circu.id=mapa.FK_CIRCUITO_TO_MAPA) "+
						"join ADM_DISTRITO distri on (circu.FK_DISTRITO_TO_CIRCUITO=distri.id) "+
						"where despa.codigo = '" + cod + "'";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    respuesta = result.getString(1);
                }
            } else {
                System.out.println("La consulta sobre distritos no retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de distritos en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error excepcion  " + ex.getMessage());
        }
        return respuesta;
    }

    public static List<licencia_permiso> getPermisos(String departamento, String municipio, String despacho2, String email, String fi, String ff) {
        ArrayList<licencia_permiso> permisos2 = new ArrayList<licencia_permiso>();
        String _SQL = "SELECT ID, fecha_inicio, fecha_fin, usuario_fk, tipo_fk, acto_admin, created_by, modified_by, estatus, despacho_fk, cargo_fk, horas_permiso FROM SJ_licencia_permiso join "+BDPortal+".dbo.User_ on (created_by = userId) WHERE estatus != 2 ";
        if (departamento != null && !departamento.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND SUBSTRING(despacho_fk, 1, 2) = '" + departamento + "'";
        }
        if (municipio != null && !municipio.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND SUBSTRING(despacho_fk, 3, 3) = '" + municipio + "'";
        }
        if (despacho2 != null && !despacho2.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND despacho_fk = '" + despacho2 + "'";
        }
        if (email != null && !email.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND emailAddress = '" + email + "'";
        }
        if(fi != "" && ff != "")
		{
			_SQL += " AND ( CONVERT(date, fecha_inicio, 23) >= CONVERT(date, '"+fi+"', 23) "+
					" AND CONVERT(date, fecha_inicio, 23) <= CONVERT(date, '"+ff+"', 23) ) ";
			
			_SQL += " OR ( CONVERT(date, fecha_fin, 23) >= CONVERT(date, '"+fi+"', 23) "+
					" AND CONVERT(date, fecha_fin, 23) <= CONVERT(date, '"+ff+"', 23) ) ";
		}
        
        
        _SQL = String.valueOf(_SQL) + " ORDER BY id desc";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    licencia_permiso temp = licencia_permisoLocalServiceUtil.createlicencia_permiso((long)result.getLong(1));
                    temp.setFechainicio((java.util.Date)result.getDate(2));
                    temp.setFechafin((java.util.Date)result.getDate(3));
                    temp.setUsuariofk(result.getString(4));
                    temp.setTipofk(result.getLong(5));
                    temp.setActoadmin(result.getString(6));
                    temp.setCreadoPor(result.getLong(7));
                    temp.setModificadoPor(result.getLong(8));
                    temp.setEstatus(result.getInt(9));
                    temp.setDespacho(result.getString(10));
                    temp.setCargo(result.getInt(11));
                    temp.setHoras(result.getInt(12));
                    permisos2.add(temp);
                }
            } else {
                System.err.println("La consulta sobre permisos no retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException e) {
            System.err.println("Error en la consulta de permisos sobre la Base de Datos.");
            System.err.println("ERROR: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return permisos2;
    }

    public static List<Docencia> getPermisosDocencia(String departamento, String municipio, String despacho2, String email, String fi, String ff) {
        ArrayList<Docencia> permisosDocencia = new ArrayList<Docencia>();
        String _SQL = "SELECT * FROM SJ_Docencia join "+BDPortal+".dbo.User_ on (created_by = userId) WHERE estatus = 1 ";
        if (departamento != null && !departamento.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND SUBSTRING(despacho_fk, 1, 2) = '" + departamento + "'";
        }
        if (municipio != null && !municipio.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND SUBSTRING(despacho_fk, 3, 3) = '" + municipio + "'";
        }
        if (despacho2 != null && !despacho2.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND despacho_fk = '" + despacho2 + "'";
        }
        if (email != null && !email.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND emailAddress = '" + email + "'";
        }
        if(fi != "" && ff != "")
		{
			_SQL += " AND ( CONVERT(date, fecha_inicial, 23) >= CONVERT(date, '"+fi+"', 23) "+
					" AND CONVERT(date, fecha_inicial, 23) <= CONVERT(date, '"+ff+"', 23) ) ";
			
			_SQL += " OR ( CONVERT(date, fecha_final, 23) >= CONVERT(date, '"+fi+"', 23) "+
					" AND CONVERT(date, fecha_final, 23) <= CONVERT(date, '"+ff+"', 23) ) ";
		}
        _SQL = String.valueOf(_SQL) + " ORDER BY id desc";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    Docencia temp = DocenciaLocalServiceUtil.createDocencia((long)result.getLong(1));
                    temp.setUsuario_fk(result.getString(2));
                    temp.setFechaInicial((java.util.Date)result.getDate(3));
                    temp.setFechaFinal((java.util.Date)result.getDate(4));
                    temp.setMateria(result.getString(5));
                    temp.setInstitucion(result.getString(6));
                    temp.setDespacho(result.getString(7));
                    temp.setCreadoPor(result.getLong(8));
                    temp.setModificadoPor(result.getLong(9));
                    temp.setEstatus(result.getInt(10));
                    temp.setHoras(result.getInt(11));
                    temp.setCargo(result.getInt(12));
                    permisosDocencia.add(temp);
                }
            } else {
                System.err.println("La consulta sobre Docencia no retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException e) {
            System.err.println("Error en la consulta de docencia sobre la Base de Datos.");
            System.err.println("ERROR: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return permisosDocencia;
    }

    public static String getMunicipio(String codMunicipio) {
        String _SQL = "SELECT nombre FROM ADM_LOCALIZACION WHERE (cod_dane_departamento + cod_dane) LIKE '" + codMunicipio + "'";
        String nombre = "";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    nombre = result.getString(1);
                }
            } else {
                System.err.println("La consulta sobre municipios no retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException e) {
            System.err.println("Error en la consulta de municipios sobre la Base de Datos.");
            System.err.println("ERROR: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return nombre;
    }

    public static String obtenerDepartamento(String codDepartamento) {
        String _SQL = "SELECT nombre FROM ADM_LOCALIZACION WHERE cod_dane='" + codDepartamento + "' AND cod_dane_departamento='" + codDepartamento + "'";
        String nombre = null;
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    nombre = result.getString(1);
                }
            } else {
                System.err.println("La consulta sobre departamentos no retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException e) {
            System.err.println("Error en la consulta de departamentos sobre la Base de Datos.");
            System.err.println("ERROR: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return nombre;
    }

    public static List<localizacion> getMunicipios(String codDepartamento) {
        String _SQL = "SELECT cod_dane, cod_dane_departamento, nombre FROM ADM_LOCALIZACION WHERE nombre!='' and cod_dane_departamento='" + codDepartamento + "' AND cod_dane != cod_dane_departamento ORDER BY nombre ASC";
        ArrayList<localizacion> municipios = new ArrayList<localizacion>();
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    localizacion l = new localizacion();
                    l.setCod_dane(result.getString(1));
                    l.setCod_dane_departamento(result.getString(2));
                    l.setNombre(result.getString(3));
                    municipios.add(l);
                }
            } else {
                System.out.println("La consulta sobre municipios retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de municipios en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error excepcion: " + ex.getMessage());
        }
        return municipios;
    }

    public static String getCargo(String cod) {
        String _SQL = "SELECT descripcion FROM sj_cargo where id = " + cod;
        String cargo = "";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    cargo = result.getString(1);
                }
            } else {
                System.out.println("La consulta sobre municipios retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de municipios en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error excepcion: " + ex.getMessage());
        }
        return cargo;
    }

    public static List<despacho> getDespachos(String departamento, String municipio) {
        String _SQL = "SELECT codigo, nombre, area FROM fun_despacho_info WHERE SUBSTRING(CODIGO,1,2) = '" + departamento + "' AND SUBSTRING(CODIGO,3,3) = '" + municipio + "' ORDER BY nombre ASC";
        ArrayList<despacho> despachos = new ArrayList<despacho>();
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    despacho Despacho = new despacho(result.getString(1), result.getString(2), result.getInt(3),"");
                    despachos.add(Despacho);
                }
            } else {
                System.out.println("La consulta sobre despachos retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de la BD a despacho: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return despachos;
    }

    public static List<permisos> getUsuariosPermisos(String cargo, String email, String nombre) {
        ArrayList<permisos> usuariosPermisos = new ArrayList<permisos>();
        String _SQL = "SELECT id, cargo, departamento_municipio, usuario FROM SJ_permiso_usuario, "+BDPortal+".dbo.User_ WHERE usuario=userId";
        if (cargo != null && !cargo.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND cargo = '" + cargo + "'";
        }
        if (email != null && !email.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND emailAddress = '" + email + "'";
        }
        if (nombre != null && !nombre.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND (firstName + ' ' + lastName LIKE '%" + nombre + "%' OR lastName + ' ' + firstName LIKE '%" + nombre + "')";
        }
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    permisos temp = permisosLocalServiceUtil.createpermisos((int)result.getInt(1));
                    temp.setCargo(result.getString(2));
                    temp.setD_m(result.getString(3));
                    temp.setUsuario(result.getString(4));
                    usuariosPermisos.add(temp);
                }
            } else {
                System.err.println("La consulta sobre usuarios permisos no retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException e) {
            System.err.println("Error en la consulta de usuarios permisos sobre la Base de Datos.");
            System.err.println("ERROR: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("Error  excepcion  " + e.getMessage());
        }
        return usuariosPermisos;
    }

    public static List<licencia_permiso> filtroPermisos(long creador, String fechaInicio, String fechaFin, long tipo, String municipio) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<licencia_permiso> permisos2 = new ArrayList<licencia_permiso>();
        String _SQL = "SELECT ID, fecha_inicio, fecha_fin, usuario_fk, tipo_fk, acto_admin, created_by, modified_by, estatus, despacho_fk, cargo_fk, horas_permiso FROM SJ_licencia_permiso WHERE estatus != 2 and created_by = " + creador;
        try {
            java.util.Date fechaInicial = formato.parse(fechaInicio);
            _SQL = String.valueOf(_SQL) + " AND fecha_inicio >= '" + formato.format(fechaInicial) + "'";
        }
        catch (ParseException fechaInicial) {
            // empty catch block
        }
        try {
            java.util.Date fechaFinal = formato.parse(fechaFin);
            _SQL = String.valueOf(_SQL) + " AND fecha_fin <= '" + formato.format(fechaFinal) + "'";
        }
        catch (ParseException fechaFinal) {
            // empty catch block
        }
        if (tipo != -1L) {
            _SQL = String.valueOf(_SQL) + " AND tipo_fk = " + tipo;
        }
        if (municipio != null && !municipio.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND SUBSTRING(despacho_fk, 1, 5) = '" + municipio + "'";
        }
        _SQL = String.valueOf(_SQL) + " ORDER BY id desc";
        System.err.println(_SQL);
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    licencia_permiso temp = licencia_permisoLocalServiceUtil.createlicencia_permiso((long)result.getLong(1));
                    temp.setFechainicio((java.util.Date)result.getDate(2));
                    temp.setFechafin((java.util.Date)result.getDate(3));
                    temp.setUsuariofk(result.getString(4));
                    temp.setTipofk(result.getLong(5));
                    temp.setActoadmin(result.getString(6));
                    temp.setCreadoPor(result.getLong(7));
                    temp.setModificadoPor(result.getLong(8));
                    temp.setEstatus(result.getInt(9));
                    temp.setDespacho(result.getString(10));
                    temp.setCargo(result.getInt(11));
                    temp.setHoras(result.getInt(12));
                    permisos2.add(temp);
                }
            } else {
                System.err.println("La consulta sobre permisos no retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException e) {
            System.err.println("Error en la consulta de permisos sobre la Base de Datos.");
            System.err.println("ERROR: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return permisos2;
    }

    public static List<Docencia> filtroDocencia(long creador, String fechaInicio, String fechaFin, String municipio) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String _SQL = "SELECT * FROM SJ_Docencia WHERE estatus = 1 AND created_by = " + creador;
        ArrayList<Docencia> docencias = new ArrayList<Docencia>();
        try {
            java.util.Date fechaInicial = formato.parse(fechaInicio);
            _SQL = String.valueOf(_SQL) + " AND fecha_inicial >= '" + formato.format(fechaInicial) + "'";
        }
        catch (ParseException fechaInicial) {
            // empty catch block
        }
        try {
            java.util.Date fechaFinal = formato.parse(fechaFin);
            _SQL = String.valueOf(_SQL) + " AND fecha_final <= '" + formato.format(fechaFinal) + "'";
        }
        catch (ParseException fechaFinal) {
            // empty catch block
        }
        if (municipio != null && !municipio.equals("")) {
            _SQL = String.valueOf(_SQL) + " AND SUBSTRING(despacho_fk, 1, 5) = '" + municipio + "'";
        }
        _SQL = String.valueOf(_SQL) + " ORDER BY id desc";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    Docencia temp = DocenciaLocalServiceUtil.createDocencia((long)result.getLong(1));
                    temp.setUsuario_fk(result.getString(2));
                    temp.setFechaInicial((java.util.Date)result.getDate(3));
                    temp.setFechaFinal((java.util.Date)result.getDate(4));
                    temp.setMateria(result.getString(5));
                    temp.setInstitucion(result.getString(6));
                    temp.setDespacho(result.getString(7));
                    temp.setCreadoPor(result.getLong(8));
                    temp.setModificadoPor(result.getLong(9));
                    temp.setEstatus(result.getInt(10));
                    temp.setHoras(result.getInt(11));
                    temp.setCargo(result.getInt(12));
                    docencias.add(temp);
                }
            } else {
                System.err.println("La consulta sobre Docencia no retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException e) {
            System.err.println("Error en la consulta de docencia sobre la Base de Datos.");
            System.err.println("ERROR: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return docencias;
    }

    public static List<despacho> reporteDespachosPermisos(String fi, String ff) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<despacho> lista = new ArrayList<despacho>();
        String sql = "SELECT despa.CODIGO,despa.NOMBRE,COUNT(permi.despacho_fk) 'permisos reportados',MAX(fecha_registro) FROM fun_despacho_info despa left join "+BDApps+".dbo.SJ_licencia_permiso permi on despa.CODIGO=permi.despacho_fk WHERE despa.FK_ESTADO_TO_DESPACHO = 1  and permi.estatus=1 ";
        if(fi != "" && ff != "")
		{
        	sql += " AND ( CONVERT(date, permi.fecha_inicio, 23) >= CONVERT(date, '"+fi+"', 23) "+
					" AND CONVERT(date, permi.fecha_inicio, 23) <= CONVERT(date, '"+ff+"', 23) ) ";
			
        	sql += " OR ( CONVERT(date, permi.fecha_fin, 23) >= CONVERT(date, '"+fi+"', 23) "+
					" AND CONVERT(date, permi.fecha_fin, 23) <= CONVERT(date, '"+ff+"', 23) ) ";
		}
        sql = String.valueOf(sql) + " group by despa.CODIGO,despa.NOMBRE,permi.despacho_fk";
        System.out.println(sql);
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)sql, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    despacho des = new despacho();
                    des.setCodigo(result.getString(1));
                    des.setNombre(result.getString(2));
                    des.setArea(result.getInt(3));
                    if(result.getString(4)!=null)
                    	des.setFecha(result.getString(4));
                    else
                    	des.setFecha("");
                    lista.add(des);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<despacho> reporteDespachosDocencia(String fi, String ff) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<despacho> lista = new ArrayList<despacho>();
        String sql = "SELECT despa.CODIGO,despa.NOMBRE,COUNT(permi.despacho_fk) 'permisos reportados',MAX(fecha_registro) FROM fun_despacho_info despa left join "+BDApps+".dbo.SJ_docencia permi on despa.CODIGO=permi.despacho_fk WHERE despa.FK_ESTADO_TO_DESPACHO = 1 and permi.estatus=1 ";
        if(fi != "" && ff != "")
		{
        	sql += " AND ( CONVERT(date, permi.fecha_inicial, 23) >= CONVERT(date, '"+fi+"', 23) "+
					" AND CONVERT(date, permi.fecha_inicial, 23) <= CONVERT(date, '"+ff+"', 23) ) ";
			
        	sql += " OR ( CONVERT(date, permi.fecha_final, 23) >= CONVERT(date, '"+fi+"', 23) "+
					" AND CONVERT(date, permi.fecha_final, 23) <= CONVERT(date, '"+ff+"', 23) ) ";
		}
        sql = String.valueOf(sql) + " group by despa.CODIGO,despa.NOMBRE,permi.despacho_fk";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)sql, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    despacho des = new despacho();
                    des.setCodigo(result.getString(1));
                    des.setNombre(result.getString(2));
                    des.setArea(result.getInt(3));
                    if(result.getString(4)!=null)
                    	des.setFecha(result.getString(4));
                    else
                    	des.setFecha("");
                    lista.add(des);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static List<auditoriaP> getAuditoria(int tipoR, String fi, String ff, String id, String correo) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ArrayList<auditoriaP> lista = new ArrayList<auditoriaP>();
        String sql = "select * from SJ_log where 1=1 ";
        if (tipoR != 0) {
            sql = String.valueOf(sql) + " and tipo_recurso =" + tipoR;
        }
        if (!fi.isEmpty()) {
            fi = String.valueOf(fi) + " 00:00";
            java.util.Date fechaInicial = formato.parse(fi);
            sql = String.valueOf(sql) + " and fecha >= '" + formato.format(fechaInicial) + "'";
        }
        if (!ff.isEmpty()) {
            ff = String.valueOf(ff) + " 23:59";
            java.util.Date fechaFinal = formato.parse(ff);
            sql = String.valueOf(sql) + " and fecha <= '" + formato.format(fechaFinal) + "'";
        }
        if (!id.isEmpty()) {
            sql = String.valueOf(sql) + " and id_recurso_modificado = '" + id + "'";
        }
        if (!correo.isEmpty()) {
            sql = String.valueOf(sql) + " and correo_usuario_modifico like '%" + correo + "%'";
        }
        sql = String.valueOf(sql) + " order by fecha desc";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)sql, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    auditoriaPClp aud = new auditoriaPClp();
                    aud.setId(result.getLong(1));
                    aud.setTipo_recurso(result.getInt(2));
                    aud.setId_recurso_modificado(result.getString(3));
                    aud.setTipo_operacion(result.getString(4));
                    String fecha = result.getString(5);
                    java.util.Date fecha1 = formato1.parse(fecha);
                    aud.setFecha(fecha1);
                    aud.setCorreo(result.getString(6));
                    aud.setUsuario_modifico(result.getString(7));
                    aud.setModificacion(result.getString(8));
                    lista.add((auditoriaP)aud);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static String obtenerNombreDespacho(String cod) {
        String nombre = "";
        String _SQL = "SELECT nombre FROM fun_despacho_info WHERE codigo = '" + cod + "' and FK_ESTADO_TO_DESPACHO =1";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)true);
            if (result != null) {
                while (result.next()) {
                    nombre = result.getString(1);
                }
            } else {
                System.out.println("La consulta sobre el nombre de despachos retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error en la consulta de la BD a despacho: " + ex.getMessage());
        }
        catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error  excepcion  " + ex.getMessage());
        }
        return nombre;
    }

    public static int getCargoPorNombre(String nombre) {
        String _SQL = "SELECT id FROM sj_cargo where descripcion = '" +nombre+"'";
        int cargo = 0;
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    cargo = result.getInt(1);
                }
            } else {
                System.out.println("La consulta sobre municipios retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de municipios en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error excepcion: " + ex.getMessage());
        }
        return cargo;
    }
    
    public static int getTipoPermisoPorNombre(String nombre) {
        String _SQL = "SELECT id FROM sj_tipo where descripcion = '" +nombre+"'";
        int cargo = 99;
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    cargo = result.getInt(1);
                }
            } else {
                System.out.println("La consulta sobre municipios retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de municipios en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error excepcion: " + ex.getMessage());
        }
        return cargo;
    }
    
    public static int getTipoDocumentoPorNombre(String nombre) {
        String _SQL = "SELECT id FROM sj_tipo_documento where descripcion = '" +nombre+"'";
        int cargo = 0;
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    cargo = result.getInt(1);
                }
            } else {
                System.out.println("La consulta sobre municipios retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de municipios en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error excepcion: " + ex.getMessage());
        }
        return cargo;
    }

    public static String getCargoUsuario(long id) {
        String _SQL = "SELECT cargo FROM SJ_permiso_usuario where usuario = '" +id+"' group by cargo";
        String cargo = "";
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    cargo = result.getString(1);
                }
            } else {
                System.out.println("La consulta sobre municipios retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de municipios en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error excepcion: " + ex.getMessage());
        }
        return cargo;
    }
    
    public static List<String> getUsuarioAsociado(long id) {
        String _SQL = "SELECT departamento_municipio FROM SJ_permiso_usuario where usuario = '" +id+"'";
        List<String> DM = new ArrayList<String>();
        try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)_SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    DM.add(result.getString(1));
                }
            } else {
                System.out.println("La consulta sobre municipios retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de municipios en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error excepcion: " + ex.getMessage());
        }
        return DM;
    }
    
    public static List<User> getUsuariosNoRegistran(int trimestre) throws SystemException, PortalException{
    	
    	List<User> usuPermisosNoRegistran = new ArrayList<User>();
    	java.util.Date hoy = new java.util.Date();
    	int trimestreAux = (hoy.getMonth()/3)+1;
    	int anhioActual = (hoy.getYear())+1900;
    	if(trimestreAux==1 && trimestre==4){
    		anhioActual = anhioActual-1;
    	}
    	
    	String SQL = "select userId from "+BDPortal+".dbo.user_ where status=0 and userId in (select usuario from SJ_permiso_usuario group by usuario)";
    	List<Long> usu = new ArrayList<Long>();
    	try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    usu.add(result.getLong(1));
                }
            } else {
                System.out.println("La consulta sobre usuarios de permisos retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de usuarios de permisos en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error excepcion: " + ex.getMessage());
        }
    	
    	SQL = "select created_by from SJ_licencia_permiso where DATEPART(QUARTER,fecha_inicio) = "+trimestre+" and DATEPART(YEAR,fecha_inicio)= "+anhioActual+" group by created_by";
    	List<Long> registraron = new ArrayList<Long>();
    	try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    registraron.add(result.getLong(1));
                }
            } else {
                System.out.println("La consulta sobre permisos usuarios que registran retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de permisos en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error excepcion: " + ex.getMessage());
        }
    	boolean registro = true;
    	for(long u : usu){
    		for(long l : registraron){
    			registro = true;
    			if(u == l){
    				registro = false;
    				break;
    			}
    		}
    		if(registro){
    			usuPermisosNoRegistran.add(UserLocalServiceUtil.getUser(u));
    		}
    	}
    	
    	return usuPermisosNoRegistran;
    }
    
    public static List<User> getUsuariosNoRegistranD(int semestre) throws SystemException, PortalException{
    	
    	List<User> usuPermisosNoRegistran = new ArrayList<User>();
    	java.util.Date hoy = new java.util.Date();
    	int semestreAux = (hoy.getMonth()/6)+1;
    	int anhioActual = (hoy.getYear())+1900;
    	if(semestreAux==1 && semestre==2){
    		anhioActual = anhioActual-1;
    	}
    	
    	String SQL = "select userId from "+BDPortal+".dbo.user_ where status=0 and userId in (select usuario from SJ_permiso_usuario where cargo in ('Magistrado Seccional','Permisos y Docencia Nacional','Permisos y Docencia por Distrito') group by usuario)";
    	List<Long> usu = new ArrayList<Long>();
    	try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    usu.add(result.getLong(1));
                }
            } else {
                System.out.println("La consulta sobre usuarios de permisos retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de usuarios de permisos en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error excepcion: " + ex.getMessage());
        }
    	
    	SQL = "select created_by from SJ_docencia where (((DATEPART(QUARTER,fecha_inicial))/3)+1) = "+semestre+" and DATEPART(YEAR,fecha_inicial)= "+anhioActual+" group by created_by";
    	System.out.println(SQL);
    	List<Long> registraron = new ArrayList<Long>();
    	try {
            ResultSet result = PersistenceUtil.realizaConsulta((String)SQL, (boolean)false);
            if (result != null) {
                while (result.next()) {
                    registraron.add(result.getLong(1));
                }
            } else {
                System.out.println("La consulta sobre permisos usuarios que registran retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de permisos en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error excepcion: " + ex.getMessage());
        }
    	boolean registro = true;
    	for(long u : usu){
    		for(long l : registraron){
    			registro = true;
    			if(u == l){
    				registro = false;
    				break;
    			}
    		}
    		if(registro){
    			usuPermisosNoRegistran.add(UserLocalServiceUtil.getUser(u));
    		}
    	}
    	
    	return usuPermisosNoRegistran;
    }


    public static String getContenidoWeb() throws ParserConfigurationException, SAXException, IOException{
    	String respueta="";
    	String contenido ="";
    	String SQL = "select content from journalarticle where articleid = '58530001' and version = (select max(version) from journalarticle where articleId = '58530001')";
    	
    	try {
            ResultSet result = PersistenceUtil.realizaConsultaPortal(SQL);
            if (result != null) {
                while (result.next()) {
                    contenido = result.getString(1);
                }
            } else {
                System.out.println("La consulta sobre usuarios de permisos retorno nada.");
            }
            PersistenceUtil.terminaOperacion();
        }
        catch (SQLException ex) {
            System.out.println("Error en la consulta de usuarios de permisos en la BD: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("Error excepcion: " + ex.getMessage());
        }
    	
    	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();	
        InputSource inputSource = new InputSource();
        inputSource.setCharacterStream(new StringReader(contenido));
        Document document = documentBuilder.parse(inputSource);	
        document.getDocumentElement().normalize();	
        NodeList nodeList = document.getElementsByTagName("static-content");
        
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);			               
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) item;	
                respueta = element.getTextContent();               
            }
        }
    	return respueta;
    }
}