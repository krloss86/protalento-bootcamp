package ar.com.educacionit.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ar.com.educacionit.dao.ArticuloDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Articulos;

public class ArticulosDaoImpl extends JdbcDaoBase<Articulos> implements ArticuloDao {

	public ArticulosDaoImpl() {
		super("ARTICULOS");
	}

	@Override
	public String getSaveSQL() {
		return ("(titulo,codigo,fecha_creacion,precio,stock,marcas_id,categorias_id) values(?,?,?,?,?,?,?)");
	}
	
	protected void save(PreparedStatement st, Articulos entity) throws SQLException {
		st.setString(1, entity.getTitulo());
		st.setString(2, entity.getCodigo());
		st.setDate(3, new java.sql.Date(entity.getFechaCreacion().getTime()));//java.util.date > java.sql.data
		st.setDouble(4, entity.getPrecio());
		st.setLong(5, entity.getStock());
		st.setLong(6, entity.getMarcasId());
		st.setLong(7, entity.getCategoriasId());
	}
	
	@Override
	public String getUpdateSQL() {
		return "titulo=?, precio=?, stock=?, marcas_id=?,categorias_id=?";
	}

	@Override
	protected void update(PreparedStatement st, Articulos entity) throws SQLException {
		st.setString(1,entity.getTitulo());
		st.setDouble(2,entity.getPrecio());
		st.setLong(3,entity.getStock());
		st.setLong(4,entity.getMarcasId());
		st.setLong(5,entity.getCategoriasId());
	}
	
	@Override
	public List<Articulos> findBySQL(String whereSQL) throws GenericException {
		String where  = "select * from articulos where  titulo like '%"+whereSQL+"%'";
		return super.findBySQL(where);
	}
}
