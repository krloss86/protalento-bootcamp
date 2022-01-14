package ar.com.educacionit.collections;

import java.util.HashSet;
import java.util.Set;

public class MainCollection4 {

	public static void main(String[] args) {
		
		//creo
		Set<Cliente> clientes = new HashSet<>();  
		
		clientes.add(new Cliente("carlos","12345"));
		clientes.add(new Cliente("carlos","12345"));
		
		System.out.println(clientes);
	}
}
