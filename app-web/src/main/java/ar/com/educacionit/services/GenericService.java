package ar.com.educacionit.services;

import java.util.List;

import ar.com.educacionit.services.exceptions.ServiceException;

public interface GenericService<T> {

	public T getOne(Long id) throws ServiceException;
	
	public void delete(Long id) throws ServiceException;
	
	public T save(T entity) throws ServiceException;
	
	public void update(T entity) throws ServiceException;
	
	public List<T> findAll() throws ServiceException;
}
