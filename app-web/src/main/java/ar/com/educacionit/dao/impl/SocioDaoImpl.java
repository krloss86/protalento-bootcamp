package ar.com.educacionit.dao.impl;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.domain.Socios;

public class SocioDaoImpl extends JdbcDaoBase<Socios> implements SociosDao{

	public SocioDaoImpl() {
		super("socios");//es la tabla
	}
	
	@Override
	public String getSaveSQL(Socios socios) {
		return ("(nombre,apellido,email,direccion, paises_id) values("+socios.getNombre()+","+socios.getApellido()+","+
				socios.getEmail()+","+socios.getDireccion()+","+socios.getPaisesId()+")");
	}
	
	@Override
	public String getUpdateSQL(Socios socios) {
		String sql = "nombre='"+socios.getNombre()+"',";
		sql = sql + "apellido='"+socios.getApellido()+"',";
		sql = sql + "email='"+socios.getEmail()+"',";
		if(socios.getPaisesId() !=null) {
			sql = sql + "paises_id='"+socios.getPaisesId()+"'";
		}
		return sql;
	}
	
	/*
	//create
	public Socios save(Socios socio) {
		
		//mas adelante veremos como conectarnos a la db 
		//insertar datos
		
		String sql = "INSERT INTO SOCIOS(nombre,apellido,email,direccion) VALUES('carlos', 'lopez', 'krloss@gmail.com', 'av siempre viva 46')";
		System.out.println("Ejecutando sql:" + sql);
		
		return new Socios(10L, "carlos", "lopez", "krloss@gmail.com", "av siempre viva 46", 1l);
		
	}

	//read (by id)
	public Socios getOne(Long id) {
		String sql  = "SELECT * FROM SOCIOS WHERE ID = " + id;
		System.out.println("Ejecutando sql:" + sql);
		return new Socios(id, "carlos", "lopez", "krloss@gmail.com", "av siempre viva 46", 1l);
	}
	
	//select *
	public Socios[] findAll() {
		String sql = "select * from socios";
		//varios row 0 > n
		System.out.println("Ejecutando sql:" + sql);
		
		Socios socio1 = new Socios(1l, "carlos", "lopez", "krloss@gmail.com", "av siempre viva 46", 1l);
		Socios socio2 = new Socios(2l, "carlos 1", "lopez", "krloss@gmail.com", "av siempre viva 46", 1l);
		Socios socio3 = new Socios(2l, "carlos 1", "lopez", "krloss@gmail.com", "av siempre viva 46", 1l);
		
		return new Socios[] {socio1,socio2,socio3};
		
	}

	public void delete(Long id) {
		String sql = "DELETE FROM socios WHERE id = " + id;
		System.out.println(sql);
	}

	public void update(Socios entity) {
		String sql = "UPDATE socios"+
		" SET direccion = '"+entity.getDireccion()+"', APELLIDO = '"+entity.getApellido()+"', paises_id = "+entity.getPaisesId()+""+
		" WHERE id = 1";
		System.out.println(sql);		
	}
	*/
}
