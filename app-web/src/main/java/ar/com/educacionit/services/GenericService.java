package ar.com.educacionit.services;

import ar.com.educacionit.services.exceptions.ServiceException;

public interface GenericService<T> {

	public T getOne(Long id) throws ServiceException;
	
	public void delete(Long id);
	
	public T save(T entity) throws ServiceException;
	
	public void update(T entity);
	
	public T[] findAll();
}
