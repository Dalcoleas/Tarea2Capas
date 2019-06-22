package com.uca.capas.dto;

public class EmpleadosDTO {
	
	private String cEmpleado;
	
	private String nombre;
	
	private String edad;
	
	private String genero;
	
	private String estado;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getActivoDelegate() {
		if(this.estado == null) return "";
		else {
			return estado == "true" ?"Activo":"Inactivo";
		}
	}

	public String getcEmpleado() {
		return cEmpleado;
	}

	public void setcEmpleado(String cEmpleado) {
		this.cEmpleado = cEmpleado;
	}
	
	
	
	
}
