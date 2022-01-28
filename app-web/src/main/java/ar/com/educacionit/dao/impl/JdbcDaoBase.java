package ar.com.educacionit.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.dao.GenericDao;
import ar.com.educacionit.dao.exceptions.DuplicatedException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.jdbc.AdministradorDeConexiones;
import ar.com.educacionit.dao.jdbc.util.DTOUtils;
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
		
		T entity = null;
		
		String sql  = "SELECT * FROM " + this.tabla+ " WHERE ID = " + id;
		
		//connection
		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {

			try (Statement st = con.createStatement()) {
				
				try (ResultSet res = st.executeQuery(sql)) {
					
					List<T> list = DTOUtils.populateDTOs(this.clazz, res);

					if(!list.isEmpty()) {
						entity = list.get(0);								
					}
				}
			}
		}catch (Exception e) {			
			throw new GenericException("No se pudo consultar:" +sql, e);
		}
		
		return entity;
	}

	public void delete(Long id) throws GenericException{
		
		if(id == null) {
			throw new GenericException("El id informado es NULL");
		}
		
		String sql = "DELETE FROM "+ this.tabla + " WHERE id =? ";

		//connection
		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {

			try (PreparedStatement st = con.prepareStatement(sql)) {
				
				st.setLong(1, id);
				
				st.executeUpdate();
			}
		}catch (Exception e) {			
			throw new GenericException("No se pudo eliminar:" +sql, e);
		}
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
	
	public T save(T entity) throws DuplicatedException, GenericException {
		
		String sql = "INSERT INTO "+ this.tabla + this.getSaveSQL();
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {

			try (PreparedStatement st = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			
				this.save(st, entity);//esto no graba nada, solo setea el los ? el tipo y dato
				
				st.execute();
				
				try (ResultSet res = st.getGeneratedKeys()) {
					
					if(res.next()) {
						
						Long lastGeneratedId = res.getLong(1);//aca esta el id
						
						entity.setId(lastGeneratedId);
					}
				}
			}
		}catch (Exception e) {			
			throw new GenericException("No se pudo insertar:" +sql, e);
		}
		
		return entity;
	}	
	
	public void update(T entity) throws DuplicatedException, GenericException {
		
		// UPDATE TABLA SET CAMPO1 =?, CAMPO2=?, CAMPON=? WHERE ID = ?
				
		String sql = "UPDATE "+ this.tabla + " SET " + this.getUpdateSQL() + " WHERE id = " + entity.getId();
		
		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {

			try (PreparedStatement st = con.prepareStatement(sql)) {
			
				this.update(st, entity);//esto no graba nada, solo setea el los ? el tipo y dato
				
				st.execute();
			}
		}catch (SQLException e) {
			//analizar si hay duplicated
			if(e instanceof SQLIntegrityConstraintViolationException) {
				throw new DuplicatedException("No se ha podido actualizar " + sql, e);
			}
			//OJO VER MAS TIPOS SI ES NECESARIO
			throw new GenericException("No se pudo actualizar:" +sql, e);
		}
	}
	
	public List<T> findAll() throws GenericException {
		
		List<T> list = new ArrayList<>();
		
		String sql = "SELECT * FROM " + this.tabla;
		
		//connection
		try (Connection con = AdministradorDeConexiones.obtenerConexion();) {

			try (Statement st = con.createStatement()) {
				
				try (ResultSet res = st.executeQuery(sql)) {
					
					list = DTOUtils.populateDTOs(this.clazz, res);					
				}
			}
		}catch (Exception e) {			
			throw new GenericException("No se pudo consultar:" +sql, e);
		}
		
		return list;
	}

	protected abstract void save(PreparedStatement st, T entity) throws SQLException;
	// los hijos estan obligados a implementarlos 
	public abstract String getSaveSQL();
	
	protected abstract void update(PreparedStatement st, T entity) throws SQLException;
	public abstract String getUpdateSQL();
}
