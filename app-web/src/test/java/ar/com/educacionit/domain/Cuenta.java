package ar.com.educacionit.domain;

public class Cuenta {
 
	private Long id;
	private String descripcion;
	private Float saldo;
	
	public Cuenta() {
	}

	public Cuenta(Long id, String descripcion, Float saldo) {
		this.id = id;
		this.descripcion = descripcion;
		this.saldo = saldo;
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
	public Float getSaldo() {
		return saldo;
	}
	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}
	
	
}
