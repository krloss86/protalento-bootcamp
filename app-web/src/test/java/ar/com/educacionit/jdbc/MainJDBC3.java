package ar.com.educacionit.jdbc;

import java.sql.SQLException;

import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;

public class MainJDBC3 {

	public static void main(String[] args) throws GenericException, SQLException, ServiceException {
		/*
		//Connection: conexion a la db con user y pass
		Connection con = AdministradorDeConexiones.obtenerConexion();
		
		//Statement / PreparedStatement: sql
		String sql  = "delete from categorias where id =?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, 10l);	
		
		st.executeUpdate();
		
		con.close();
		*/
		CategoriaService cs = new CategoriaServiceImpl();
		cs.delete(2l);
		
		System.out.println("fin");
	}

}
