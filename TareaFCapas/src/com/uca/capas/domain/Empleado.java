package com.uca.capas.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(schema="public", name="empleado")
public class Empleado {
	
	@Id
	@GeneratedValue(generator="empleado_id_empleado_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="empleado_id_empleado_seq",sequenceName="public.empleado_id_empleado_seq",allocationSize = 1)
	@Column(name="id_empleado")
	private Integer cEmpleado;
	
	@NotEmpty(message= "Favor ingrese nombre empleado.")
	@Column(name="nombre")
	private String nEmpleado;

	@Column(name="genero")
	private String gEmpleado;
	
	@Min(value = 1L, message = "El número debe ser positivo y mayor a 1.")
	@NotNull(message= "Favor ingrese edad empleado.")
	@Column(name="edad")
	private Integer eEmpleado;
	
	@Column(name="estado")
	private Boolean eActivo;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="id_sucursal")
	private Sucursal sucursal;
	
	public Empleado(Integer cEmpleado, String nEmpleado, String gEmpleado, Integer eEmpleado, Boolean eActivo,
			Sucursal sucursal) {
		super();
		this.cEmpleado = cEmpleado;
		this.nEmpleado = nEmpleado;
		this.gEmpleado = gEmpleado;
		this.eEmpleado = eEmpleado;
		this.eActivo = eActivo;
		this.sucursal = sucursal;
	}
	
	public Empleado() {
		super();
	}

	public Integer getcEmpleado() {
		return cEmpleado;
	}

	public void setcEmpleado(Integer cEmpleado) {
		this.cEmpleado = cEmpleado;
	}

	public String getnEmpleado() {
		return nEmpleado;
	}

	public void setnEmpleado(String nEmpleado) {
		this.nEmpleado = nEmpleado;
	}

	public String getgEmpleado() {
		return gEmpleado;
	}

	public void setgEmpleado(String gEmpleado) {
		this.gEmpleado = gEmpleado;
	}

	public Integer geteEmpleado() {
		return eEmpleado;
	}

	public void seteEmpleado(Integer eEmpleado) {
		this.eEmpleado = eEmpleado;
	}

	public Boolean geteActivo() {
		return eActivo;
	}

	public void seteActivo(Boolean eActivo) {
		this.eActivo = eActivo;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	//Funciones delegate
		public String getActivoDelegate() {
			if(this.eActivo == null) return "";
			else {
				return eActivo == true ?"Activo":"Inactivo";
			}
		}	
	
}
