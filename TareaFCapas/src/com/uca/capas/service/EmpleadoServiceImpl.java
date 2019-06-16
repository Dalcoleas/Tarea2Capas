package com.uca.capas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Empleado;
import com.uca.capas.dto.EmpleadosDTO;
import com.uca.capas.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	EmpleadoRepository empleadoRepository;

	public List<Empleado> findVehiculosCliente() {
		
		return empleadoRepository.findAll();
	}

	public List<EmpleadosDTO> findVehCliente(Integer sucursal) {
		
		List<EmpleadosDTO> empleados = empleadoRepository.findEmpleadosSucursal(sucursal)
				.stream()
				.map(obj -> {
					EmpleadosDTO e = new EmpleadosDTO();
					e.setNombre(obj[0].toString());
					e.setEdad(obj[1].toString());
					e.setGenero(obj[2].toString());
					e.setEstado(obj[3].toString());
					return e;	
				}).collect(Collectors.toList());
		return empleados;
	}
}
