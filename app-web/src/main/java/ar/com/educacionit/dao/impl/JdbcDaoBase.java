package ar.com.educacionit.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.domain.Entity;

/**
 * Las T son entidades que repesentan tablas, por ende van a heredar de Entity
 * @author LopezCar
 *
 * @param <T>
 */
public abstract class JdbcDaoBase<T extends Entity> implements GenericDao<T>{

	protected String tabla;
	protected Class<T> clazz;
	
	public JdbcDaoBase(String tablaDelHijo) {
		this.tabla = tablaDelHijo;
		//api reflection de java
		//https://www.javatpoint.com/java-reflection
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T getOne(Long id) throws GenericException{
		
		if(id == null) {
			throw new GenericException("Id no informado");
		}
		
		String sql  = "SELECT * FROM " + this.tabla+ " WHERE ID = " + id;
		System.out.println("Ejecutando sql:" + sql);
		T entity;
		try {//lo vamos a ver la proxima clase
			//entity = this.clazz.newInstance();
			entity = this.clazz.getDeclaredConstructor().newInstance();
			entity.setId(id);
			
			//cuando viene desde la db
			//paises_id > setPaisesId(objeto)
			
			//tomar los metodos de this.clazz > Method[]
			//para cada method > method.invoke(entity)
			
			//clase utilizaria que va a saber como tomar la instancia y como armar 
			//los seteos de los atributos
		} catch (Exception e) {
			entity = null;
		}
		return entity;
	}

	public void delete(Long id) throws GenericException{
		String sql = "DELETE FROM "+ this.tabla + " WHERE id = " + id;
		System.out.println(sql);
		//execute 
		//error de conexion!!!
		
	}

	/*
	public T save(T entity) throws DuplicatedException{
		
		StringBuffer namesSQL = new StringBuffer("INSERT INTO ").append(this.tabla).append("(");
		StringBuffer valueSQLString = new StringBuffer(" values (");
		try {
			T instance = this.clazz.getConstructor().newInstance();
			
			//le pido los Fields
			Field[] fields = instance.getClass().getDeclaredFields();
			
			for(Field field : fields) {
				field.setAccessible(true);
				
				String campoSql = field.getName();
				Object valueSql = field.get(entity);
				
				if(valueSql !=null) {
					namesSQL.append(campoSql).append(",");
					valueSQLString.append("'").append(valueSql).append("'").append(",");
				}
			}
			
			namesSQL = new StringBuffer(namesSQL.substring(0, namesSQL.length()-1));			
			namesSQL.append(")");
			
			valueSQLString = new StringBuffer(valueSQLString.substring(0, valueSQLString.length()-1));
			valueSQLString.append(")");
			//insert into tabla (campo1, campo2...campoN) values('1','2','valorN')
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		String sqlFinal = namesSQL.toString() + valueSQLString.toString(); 
		
		//exucute hacia la db 
		//un recordset
		
		System.out.println(sqlFinal);
		return null;
	}
	*/
	
	public T save(T entity) throws DuplicatedException{
		String sql = "INSERT INTO "+ this.tabla + this.getSaveSQL(entity);
		System.out.println(sql);
		entity.setId(12L);//db
		return entity;
	}	
	
	// los hijos estan obligados a implementarlos 
	public abstract String getSaveSQL(T entity);

	public void update(T entity) {
		String sql = "UPDATE "+ this.tabla + " SET " +getUpdateSQL(entity) + " WHERE id = " + entity.getId();
		System.out.println(sql);
	}
	
	public abstract String getUpdateSQL(T socios);

	public List<T> findAll() {
		String sql = "SELECT * FROM " + this.tabla;
		System.out.println(sql);
		//la informacion debe venir desde la db
		
		//supongo que hay dos registros!!!
		List<T> instances = new ArrayList<T>();
		T instance;
		try {
			instance = this.clazz.getDeclaredConstructor().newInstance();
			instance.setId(1L);
			instances.add(instance);
			instances.add(instance);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return instances;
	}
}
