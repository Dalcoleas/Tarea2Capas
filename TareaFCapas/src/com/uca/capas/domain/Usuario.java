package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(schema="public", name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(generator="usuario_id_usuario_seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="usuario_id_usuario_seq",sequenceName="public.usuario_id_usuario_seq",allocationSize = 1)
	@Column(name="id_usuario")
	private Integer cUsuario;
	
	@NotEmpty(message="No puede estar vacio")
	@Column(name="usuario")
	private String usuario;
	
	@NotEmpty(message="No puede estar vacio")
	@Column(name="clave")
	private String contrase�a;

	public Usuario(Integer cUsuario, String usuario, String contrase�a) {
		super();
		this.cUsuario = cUsuario;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
	}

	public Usuario() {
		super();

	}

	public Integer getcUsuario() {
		return cUsuario;
	}

	public void setcUsuario(Integer cUsuario) {
		this.cUsuario = cUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

}
