package ar.com.educacionit.dao.impl;

import java.lang.reflect.ParameterizedType;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.domain.Entity;

/**
 * Las T son entidades que repesentan tablas, por ende van a heredar de Entity
 * @author LopezCar
 *
 * @param <T>
 */
public class JdbcDaoBase<T extends Entity> implements GenericDao<T>{

	protected String tabla;
	protected Class<T> clazz;
	
	public JdbcDaoBase(String tablaDelHijo) {
		this.tabla = tablaDelHijo;
		//api reflection de java
		//https://www.javatpoint.com/java-reflection
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T getOne(Long id) {
		String sql  = "SELECT * FROM " + this.tabla+ " WHERE ID = " + id;
		System.out.println("Ejecutando sql:" + sql);
		T entity;
		try {//lo vamos a ver la proxima clase
			//entity = this.clazz.newInstance();
			entity = this.clazz.getDeclaredConstructor().newInstance();
			entity.setId(id);
			//clase utilizaria que va a saber como tomar la instancia y como armar 
			//los seteos de los atributos
		} catch (Exception e) {
			entity = null;
		}
		return entity;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public T save(T entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	public T[] findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
