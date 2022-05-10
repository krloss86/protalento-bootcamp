package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.dao.MarcasDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.impl.ArticulosDaoImpl;
import ar.com.educacionit.dao.impl.CategoriaDaoImpl;
import ar.com.educacionit.dao.impl.MarcasDaoImpl;
import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Marcas;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;

public class ArticulosServicesImpl extends AbstractBaseService<Articulos> implements ArticulosServices {

	//usar otros daos
	private CategoriaDao categoriaDao;
	private MarcasDao marcasDao;
	
	public ArticulosServicesImpl() {
		super(new ArticulosDaoImpl());
		this.categoriaDao = new CategoriaDaoImpl();
		this.marcasDao = new MarcasDaoImpl();		
	}

	@Override
	public Articulos getOne(Long id) throws ServiceException {
		try {
			Articulos articulo = this.genericDao.getOne(id);
			Marcas marcaDelArticulo = this.marcasDao.getOne(articulo.getMarcasId());
			Categorias categoriaDelArticulo = this.categoriaDao.getOne(articulo.getCategoriasId());
			
			articulo.setMarca(marcaDelArticulo);
			articulo.setCategoria(categoriaDelArticulo);
			return articulo;
		} catch (GenericException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
