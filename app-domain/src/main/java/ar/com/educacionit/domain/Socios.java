package ar.com.educacionit.domain;

import java.util.Date;

public class Socios implements Entity{

	private Long id;
	private String nombre;
	private String apellido;
	private String email;
	private String direccion;
	private Long paisesId;
	private Date fechaAlta;
	
	public Socios() {
		
	}
	
	public Socios(Long id, String nombre, String apellido, String email, String direccion, Long paisesId) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.paisesId = paisesId;
	}
	
	public Socios(Long id, String nombre, String apellido, String email, String direccion, Long paisesId,Date fechaAlta) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.paisesId = paisesId;
		this.fechaAlta = fechaAlta;
	}

	public Socios(String nombre, String apellido, String email, String direccion, Long paisesId) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.paisesId = paisesId;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getPaisesId() {
		return paisesId;
	}

	public void setPaisesId(Long paisesId) {
		this.paisesId = paisesId;
	}

	@Override
	public String toString() {
		return "Socios [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", direccion=" + direccion + ", paisesId=" + paisesId + "]";
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
}
