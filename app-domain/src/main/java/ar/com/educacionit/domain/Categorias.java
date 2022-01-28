package ar.com.educacionit.domain;

public class Categorias implements Entity{

	//atributos
	private Long id;
	private String descripcion;
	private String codigo;
	private Long habilitada;
	
	public Categorias() {

	}
	
	public Categorias(Long id, String descripcion, String codigo) {
		this.id = id;
		this.descripcion = descripcion;
		this.codigo = codigo;
	}
	
	public Categorias(String descripcion, String codigo,Long habiltiada) {
		setDescripcion(descripcion);
		//this.descripcion = descripcion;
		this.codigo = codigo;
		this.habilitada = habiltiada;
	}
	
	public Categorias(Long id, String descripcion, String codigo,Long habiltiada) {
		this.id = id;
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.habilitada = habiltiada;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descripcion=" + descripcion + ", codigo=" + codigo + "]";
	}

	public Long getHabilitada() {
		return habilitada;
	}

	public void setHabilitada(Long habilitada) {
		this.habilitada = habilitada;
	}
	
	//constructor
	//alt+shit+s
	
	//metodos
	
	//get/set
	
}
