package clase9.oop.herencia;

public class CineMain3 {

	public static void main(String[] args) {

		Empleado empleado = new Empleado("empleado1","apellidoemp1","rojo", 1);
		
		//no hace falta crear un Director
		//porque el metodo delegar no le pertenece a una instancia en particular
		//sino a la clase Director
		
		Director.delegar(empleado, "archivar");
	}

}
