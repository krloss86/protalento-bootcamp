package ar.com.educacionit.dao.impl;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.domain.Categorias;

public class CategoriaDaoImpl extends JdbcDaoBase<Categorias> implements CategoriaDao {

	public CategoriaDaoImpl() {
		super("CATEGORIAS");
	}
	
	/*
	public Categorias getOne(Long id) {
		String sql  = "SELECT * FROM CATEGORIAS WHERE ID = " + id;
		System.out.println("Ejecutando sql:" + sql);
		return new Categorias(id, "categoria 1", "abc000");
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	public Categorias save(Categorias entity) {
		String sql = "INSERT INTO Categorias(descripcion,codigo) VALUES('"+entity.getDescripcion()+"', '"+entity.getCodigo()+"')";
		System.out.println("Ejecutando sql:" + sql);
		
		entity.setId(1L);
		
		return entity; 
	}

	public void update(Categorias entity) {
		// TODO Auto-generated method stub

	}

	public Categorias[] findAll() {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
