package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Empleado;
import com.uca.capas.dto.EmpleadosDTO;


public interface EmpleadoService {
	public List<Empleado> findEmpleadosSucursal();
	
	public List<EmpleadosDTO> findSucEmpleado(Integer sucursal);
	
	public void delete(Empleado id);
	
	public void deleteAll();
	
	public Empleado save (Empleado e);	
	
	public Empleado findOne(Integer e);
}
