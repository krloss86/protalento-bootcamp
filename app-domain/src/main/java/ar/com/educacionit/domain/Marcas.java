package ar.com.educacionit.domain;

public class Marcas {

	private Long id;
	private String marca;
	private String codigo;
	private Long habilitada;//1 o 0
	
	public Marcas(Long id, String marca, String codigo, Long habilitada) {	
		this.id = id;
		this.marca = marca;
		this.codigo = codigo;
		this.habilitada = habilitada;
	}
	
	public Marcas(String marca, String codigo, Long habilitada) {
		super();
		this.marca = marca;
		this.codigo = codigo;
		this.habilitada = habilitada;
	}


	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getHabilitada() {
		return habilitada;
	}

	public void setHabilitada(Long habilitada) {
		this.habilitada = habilitada;
	}

	@Override
	public String toString() {
		return "Marcas [id=" + id + ", marca=" + marca + ", codigo=" + codigo + ", habilitada=" + habilitada + "]";
	}
	
	
}
