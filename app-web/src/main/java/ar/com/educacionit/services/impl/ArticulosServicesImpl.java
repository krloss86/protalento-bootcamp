package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.impl.ArticulosDaoImpl;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;

public class ArticulosServicesImpl extends AbstractBaseService<Articulos> implements ArticulosServices {

	public ArticulosServicesImpl() {
		super(new ArticulosDaoImpl());
	}

}
