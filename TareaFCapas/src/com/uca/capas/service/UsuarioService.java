package com.uca.capas.service;

import com.uca.capas.domain.Usuario;

public interface UsuarioService {
	public Usuario findUser(String user, String password);
}
