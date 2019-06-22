package com.uca.capas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uca.capas.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	public Usuario findByUsuarioAndContraseña(String user, String password);

}
