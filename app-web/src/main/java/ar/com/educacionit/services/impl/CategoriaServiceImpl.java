package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.impl.CategoriaDaoImpl;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.services.CategoriaService;

public class CategoriaServiceImpl extends AbstractBaseService<Categorias> implements CategoriaService{
	
	public CategoriaServiceImpl() {
		super(new CategoriaDaoImpl());
	}
}
