package ar.com.educacionit.dao.impl;

import ar.com.educacionit.domain.Socios;

public class SocioDaoImpl implements SocioSQLCustom{

	//create
	public Socios create(Socios socio) {
		
		//mas adelante veremos como conectarnos a la db 
		//insertar datos
		
		String sql = "INSERT INTO SOCIOS(nombre,apellido,email,direccion) VALUES('carlos', 'lopez', 'krloss@gmail.com', 'av siempre viva 46')";
		System.out.println("Ejecutando sql:" + sql);
		
		return new Socios(10L, "carlos", "lopez", "krloss@gmail.com", "av siempre viva 46", 1l);
		
	}

	//read (by id)
	public Socios findById(Long id) {
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

	public Socios selectCustom() {
		String sql = "select nombre, apellido from socios ";
		System.out.println("Ejecutando sql:" + sql);
		return new Socios(1l, "carlos", "lopez", "krloss@gmail.com", "av siempre viva 46", 1l);
	}
}
