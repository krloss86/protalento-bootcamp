package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.domain.Socios;

public class MainJDBC {

	public static void main(String[] args) throws GenericException, SQLException {
		
		//Connection: conexion a la db con user y pass
		Connection con = AdministradorDeConexiones.obtenerConexion();
		
		//Statement / PreparedStatement: sql
		Statement st = con.createStatement();
		
		ResultSet res = st.executeQuery("select * from categorias");//puede haber mas de 1 registro 
		
		Collection<Entity> lista = new ArrayList<>();
		
		while(res.next()) {
			//ResultSet: datos (columnas / filas)
			Long id = res.getLong("id");//obtener un valor long de la columna 1
			String descripcion = res.getString("descripcion");
			String codigo = res.getString("codigo");
			Long habilitad = res.getLong("habilitada");
	
			Categorias categoria = new Categorias(id, descripcion, codigo);
			lista.add(categoria);
		}
		
		System.out.println(lista);
		
		//socios
		res = st.executeQuery("select * from socios");
		
		while(res.next()) {
			//ResultSet: datos (columnas / filas)
			Long id = res.getLong("id");//obtener un valor long de la columna 1
			String nombre = res.getString("nombre");
			String apellido = res.getString("apellido");
			String email = res.getString("email");
			Date fechaAlta = res.getDate("fecha_alta");
			String direccion = res.getString("direccion");
			Long paisId = res.getLong("paises_id");
	
			Socios socios = new Socios(id, nombre, apellido, email, direccion, paisId);
			lista.add(socios);
		}
		
		System.out.println(lista);
		
		con.close();
	}

}
