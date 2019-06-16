package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Empleado;
import com.uca.capas.dto.EmpleadosDTO;


public interface EmpleadoService {

	public List<Empleado> findVehiculosCliente();
	
	public List<EmpleadosDTO> findVehCliente(Integer sucursal);
	
}
