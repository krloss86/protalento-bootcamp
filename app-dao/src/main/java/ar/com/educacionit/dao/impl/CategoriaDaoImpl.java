package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.domain.Categorias;

public class CategoriaDaoImpl extends JdbcDaoBase<Categorias> implements CategoriaDao {

	public CategoriaDaoImpl() {
		super("CATEGORIAS");
	}

	@Override
	public String getSaveSQL() {
		return ("(descripcion,codigo,habilitada) values(?,?,?)");
	}
	
	protected void save(PreparedStatement st, Categorias entity) throws SQLException {
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
	protected void update(PreparedStatement st, Categorias entity) throws SQLException {
		st.setString(1,entity.getDescripcion());
		st.setLong(2,entity.getHabilitada());
	}
	
}
