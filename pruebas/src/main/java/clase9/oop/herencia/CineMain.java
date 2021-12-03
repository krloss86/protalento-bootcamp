package clase9.oop.herencia;

public class CineMain {

	public static void main(String[] args) {

		// Persona persona = new Persona("persona1", "apellido1","negro");
		Empleado empleado = new Empleado("empleado1","apellidoemp1","rojo", 1);
		Efectivo efectivo = new Efectivo("nombre efectivo1", "apellido efectivo1", "rubio", 1);
		Contratado contratado = new Contratado("nombre contratado1","apellido contratado1","azul", 1, 6);

		Director director = new Director("nombre director", "apellido director", "negro", 10);
		
		//todas las personas pueden ir al cine
		Persona[] personas = new Persona[4];
		//personas[0] = persona;
		personas[0] = empleado;
		personas[1] = efectivo;
		personas[2] = contratado;
		personas[3] = director;
		
		//recorrer las personas que entran al cine y quiero saber si son un Director
		for(Persona aux : personas   ) {
			
			//con aux tengo acceso a todos los metodos public de Persona
			aux.detalle();
						
			if(aux instanceof Director) {
				
				//toma al director que esta dentro de la persona
				// (Clase)objeto > castear = casting
				Director d = (Director)aux;
				
				//aux.getApellido();
				//d.getApellido();
				
				System.out.println("Director: tiene "+ d.getEmpACargo() + " a cargo y va a una silla especial!!");
			}			
		}
	}

}
