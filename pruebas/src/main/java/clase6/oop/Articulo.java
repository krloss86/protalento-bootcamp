package clase6.oop;

public class Articulo {

	//atributos
	private String titulo;
	private float precio;
	private String imagen;
	private boolean favorito;
	private boolean envioGratis;
	private boolean tieneDescuento;
	private boolean tieneCuotas;
	private int cantidad;
	
	//constructor
	public Articulo(String titulo, float precio, String imagen, boolean favorito, int cantidad, boolean tieneCuotas) {
		if(precio > 20000) {
			this.envioGratis = true;
		}
		this.favorito = favorito;
		this.titulo = titulo;
		this.imagen = imagen;
		this.cantidad = cantidad;
		this.tieneCuotas = tieneCuotas;
	}
	
	public void agregarAFavorito() {
		this.favorito = !this.favorito;
	}
	
	public void detalleArticulo() {
		System.out.println("Titulo:" + this.titulo);
		System.out.println("Precio:" + this.precio);
		//completar!!!
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public boolean isEnvioGratis() {
		return envioGratis;
	}

	public void setEnvioGratis(boolean envioGratis) {
		this.envioGratis = envioGratis;
	}

	public boolean isTieneDescuento() {
		return tieneDescuento;
	}

	public void setTieneDescuento(boolean tieneDescuento) {
		this.tieneDescuento = tieneDescuento;
	}

	public String getTitulo() {
		// titulos sean upper case 
		return titulo.toUpperCase();
	}

	public float getPrecio() {
		return precio;
	}

	public String getImagen() {
		return imagen;
	}

	public boolean isTieneCuotas() {
		return tieneCuotas;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	//alt+shit+s
	
}
