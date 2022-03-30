package ar.com.educacionit.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import ar.com.educacionit.dao.exceptions.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException {
		String url = "jdbc:postgresql://ec2-52-204-196-4.compute-1.amazonaws.com:5432/danjnhikpeq89d";
		String user = "odkhwdqqaduamk";
		String password = "255c6115ed9e2860e9affbda5149a07e90560c1e3b530bf09c1f9a1e014db88a";
		String diverName  = "org.postgresql.Driver";
		
		try {
			//com.mysql.cj.jdbc.Driver.class.newInstance();
			Class.forName(diverName);
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (Exception  e) {
			throw new GenericException("Error oteniendo conexion: " + e.getMessage(),e);
		} 
	}
	
	public static void main(String[] args) {
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {			
			System.out.println("Conexion obtenida");
		}catch (Exception e) {			
			e.printStackTrace();
		}
	}
}
