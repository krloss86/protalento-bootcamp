package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.MarcasDao;
import ar.com.educacionit.domain.Marcas;

public class MarcasDaoImpl extends JdbcDaoBase<Marcas> implements MarcasDao {

	public MarcasDaoImpl() {
		super("MARCAS");
	}

	@Override
	public String getSaveSQL() {
		return ("(descripcion,codigo,habilitada) values(?,?,?)");
	}
	
	protected void save(PreparedStatement st, Marcas entity) throws SQLException {
		//inser insto categorias (
		st.setString(1, entity.getDescripcion());
		st.setString(2, entity.getCodigo());
		st.setLong(3, entity.getHabilitada());
	}
	
	@Override
	public String getUpdateSQL() {
		return "descripcion=?, habilitada=?";
	}

	@Override
	protected void update(PreparedStatement st, Marcas entity) throws SQLException {
		st.setString(1,entity.getDescripcion());
		st.setLong(2,entity.getHabilitada());
	}
	
}
