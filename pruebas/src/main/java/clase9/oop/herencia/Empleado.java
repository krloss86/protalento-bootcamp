package clase9.oop.herencia;

public class Empleado extends Persona {

	//atributo propio del empleado
	private Integer id;

	public Empleado(String nombre, 
				String apellido, 
				String colorPelo,
				Integer id) {
		//antes de nacer el  empleado, nace la persona
		super(nombre,apellido,colorPelo);
		
		//puedo "setear" los atributos propios
		this.id = id;
		
		//cantidadOrejas = 3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	//cambiar el comportamiento del padre (reutilizar lo del padre + lo propio)
	/*public void detalle() {
		super.detalle();
		
		//muestra la propio
		System.out.println("Id: " + this.getId());
	}*/
	
	public void detallar() {
		//muestra la propio
		System.out.println("Id: " + this.getId());
	}
	
	/*
	public int getCantidadOjos() {
		return 3;
	}
	*/
}
