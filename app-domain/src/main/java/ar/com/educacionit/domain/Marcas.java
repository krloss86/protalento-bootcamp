package ar.com.educacionit.domain;

public class Marcas implements Entity{

	private Long id;
	private String descripcion;
	private String codigo;
	private Long habilitada;//1 o 0
	
	public Marcas() {
		
	}
	
	public Marcas(Long id, String marca, String codigo, Long habilitada) {	
		this.id = id;
		this.descripcion = marca;
		this.codigo = codigo;
		this.habilitada = habilitada;
	}
	
	public Marcas(String marca, String codigo, Long habilitada) {
		super();
		this.descripcion = marca;
		this.codigo = codigo;
		this.habilitada = habilitada;
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
		return "Marcas [id=" + id + ", marca=" + descripcion + ", codigo=" + codigo + ", habilitada=" + habilitada + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
