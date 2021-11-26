package clase6.oop;

public class Articulo {

	//atributos
	String titulo;
	float precio;
	String imagen;
	boolean favorito;
	boolean envioGratis;
	boolean tieneDescuento;
	boolean tieneCuotas;
	int cantidad;
	
	//constructor
	Articulo(String titulo, float precio, String imagen, boolean favorito, int cantidad, boolean tieneCuotas) {
		if(precio > 20000) {
			this.envioGratis = true;
		}
		this.favorito = favorito;
		this.titulo = titulo;
		this.imagen = imagen;
		this.cantidad = cantidad;
		this.tieneCuotas = tieneCuotas;
	}
	
	void agregarAFavorito() {
		this.favorito = !this.favorito;
	}
	
	void detalleArticulo() {
		System.out.println("Titulo:" + this.titulo);
		System.out.println("Precio:" + this.precio);
		//completar!!!
	}
}
