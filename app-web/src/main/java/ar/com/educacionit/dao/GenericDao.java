package ar.com.educacionit.dao;

import java.util.List;

import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;

public interface GenericDao<T> {

	public T getOne(Long id) throws GenericException;

	public void delete(Long id) throws GenericException;

	public T save(T entity) throws DuplicatedException;

	public void update(T entity);

	public List<T> findAll() throws GenericException;
}
