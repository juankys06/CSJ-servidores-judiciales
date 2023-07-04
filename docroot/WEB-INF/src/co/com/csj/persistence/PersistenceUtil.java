package co.com.csj.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersistenceUtil {
	private static Connection conection;
	private static ResultSet resultSet;
	private static Statement statement;

	public static ResultSet realizaConsulta(String consulta, boolean band) throws SQLException, ClassNotFoundException {		
		if(band)
			conection = Conexion.open(Conexion.DATA_SOURCE_PRINCIPAL);
		else
			conection = Conexion.open(Conexion.DATA_SOURCE_APP);
			
		try 
		{	
			statement = conection.createStatement();
			resultSet = statement.executeQuery(consulta);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR PRINCIPAL: " + e.getMessage());
		}
		
		return resultSet;
	}
	
	public static ResultSet realizaConsultaPortal(String consulta) throws SQLException, ClassNotFoundException {		
		
		conection = Conexion.open(Conexion.DATA_SOURCE_PORTAL);
			
		try 
		{	
			statement = conection.createStatement();
			resultSet = statement.executeQuery(consulta);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR PRINCIPAL: " + e.getMessage());
		}
		
		return resultSet;
	}
	
	public static void terminaOperacion() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();
		}
		if (conection != null) {
			conection.close();
		}

		resultSet = null;
		statement = null;
		conection = null;
	}
}
