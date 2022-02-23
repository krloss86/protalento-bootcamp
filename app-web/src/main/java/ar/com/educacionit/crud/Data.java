package ar.com.educacionit.crud;

public class Data{

	private Long id;
	private String titulo;
	
	public Data() {
	
	}
	
	public Data(Long id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", titulo=" + titulo + "]";
	}
	
}
