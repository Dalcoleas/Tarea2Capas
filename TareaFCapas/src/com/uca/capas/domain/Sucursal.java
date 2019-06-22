package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(schema="public", name="sucursal")
public class Sucursal {
	
	@Id
	@GeneratedValue(generator="sucursal_id_sucursal_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="sucursal_id_sucursal_seq",sequenceName="public.sucursal_id_sucursal_seq",allocationSize = 1)
	@Column(name="id_sucursal")
	private Integer cSucursal;
	
	@NotEmpty(message= "Favor ingrese nombre sucursal.")
	@Column(name="nombre")
	private String nSucursal;
	
	@NotEmpty(message= "Favor ingrese nombre gerente.")
	@Column(name="nom_gerente")
	private String nGerente;

	@Min(value = 1L, message = "El número debe ser positivo y mayor a 1.")
	@NotNull(message= "Favor ingrese cantidad de mesas.")
	@Column(name="n_mesas")
	private Integer nMesas;
	
	@NotEmpty(message= "Favor ingrese ubicación.")
	@Column(name="ubicacion")
	private String uSucursal;
	
	@NotEmpty(message= "Favor ingrese horario apertura.")
	@Column(name="horario_apertura")
	private String hApertura;
	
	@NotEmpty(message= "Favor ingrese horario cierre.")
	@Column(name="horario_cierre")
	private String hCierre;
	
	@OneToMany(mappedBy="sucursal", fetch = FetchType.EAGER)
	private List<Empleado> empleados;
	
	public Sucursal(Integer cSucursal, String nSucursal, String nGerente, Integer nMesas, String uSucursal,
			String hApertura, String hCierre, List<Empleado> empleados) {
		super();
		this.cSucursal = cSucursal;
		this.nSucursal = nSucursal;
		this.nGerente = nGerente;
		this.nMesas = nMesas;
		this.uSucursal = uSucursal;
		this.hApertura = hApertura;
		this.hCierre = hCierre;
		this.empleados = empleados;
	}

	public Sucursal() {
		super();
	}
	
	
	public Integer getcSucursal() {
		return cSucursal;
	}

	public void setcSucursal(Integer cSucursal) {
		this.cSucursal = cSucursal;
	}

	public String getnSucursal() {
		return nSucursal;
	}

	public void setnSucursal(String nSucursal) {
		this.nSucursal = nSucursal;
	}

	public String getnGerente() {
		return nGerente;
	}

	public void setnGerente(String nGerente) {
		this.nGerente = nGerente;
	}

	public Integer getnMesas() {
		return nMesas;
	}

	public void setnMesas(Integer nMesas) {
		this.nMesas = nMesas;
	}

	public String getuSucursal() {
		return uSucursal;
	}

	public void setuSucursal(String uSucursal) {
		this.uSucursal = uSucursal;
	}

	public String gethApertura() {
		return hApertura;
	}

	public void sethApertura(String hApertura) {
		this.hApertura = hApertura;
	}

	public String gethCierre() {
		return hCierre;
	}

	public void sethCierre(String hCierre) {
		this.hCierre = hCierre;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	
}
