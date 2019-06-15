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

@Entity
@Table(schema="public", name="sucursal")
public class Sucursal {
	
	@Id
	@GeneratedValue(generator="sucursal_id_sucursal_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="sucursal_id_sucursal_seq",sequenceName="public.sucursal_id_sucursal_seq",allocationSize = 1)
	@Column(name="id_sucursal")
	private Integer cSucursal;
	
	@Column(name="nombre")
	private String nSucursal;
	
	@Column(name="nomGerente")
	private String nGerente;
	
	@Column(name="nMesas")
	private Integer nMesas;
	
	@Column(name="ubicacion")
	private String uSucursal;
	
	@Column(name="horario_apertura")
	private String hApertura;
	
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
