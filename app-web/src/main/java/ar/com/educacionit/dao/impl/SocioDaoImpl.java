package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.domain.Socios;

public class SocioDaoImpl extends JdbcDaoBase<Socios> implements SociosDao{

	public SocioDaoImpl() {
		super("socios");//es la tabla
	}
	
	@Override
	public String getSaveSQL() {
		return ("(nombre,apellido,email,direccion, paises_id,fecha_alta) values(?,?,?,?,?,?)");
	}
	
	@Override
	protected void save(PreparedStatement st, Socios entity) throws SQLException {
		st.setString(1,entity.getNombre());
		st.setString(2, entity.getApellido());
		st.setString(3, entity.getEmail());
		st.setString(4,entity.getDireccion());
		st.setLong(5, entity.getPaisesId());
		st.setDate(6, new java.sql.Date(new Date().getTime()));
	}
	
	@Override
	public String getUpdateSQL() {
		return "nombre=?,apellido=?,email=?,paises_id=?";		
	}

	@Override
	protected void update(PreparedStatement st, Socios entity) throws SQLException {
		st.setString(1,entity.getNombre());
		st.setString(2,entity.getApellido());
		st.setString(3,entity.getEmail());
		st.setLong(4,entity.getPaisesId());
	}
	
}
