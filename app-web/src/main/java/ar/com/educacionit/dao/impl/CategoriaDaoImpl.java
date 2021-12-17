package ar.com.educacionit.dao.impl;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.domain.Categorias;

public class CategoriaDaoImpl implements CategoriaDao {

	public Categorias getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
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

}
