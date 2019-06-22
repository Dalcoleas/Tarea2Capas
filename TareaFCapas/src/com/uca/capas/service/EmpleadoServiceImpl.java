package com.uca.capas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Empleado;
import com.uca.capas.dto.EmpleadosDTO;
import com.uca.capas.repositories.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	EmpleadoRepository empleadoRepository;

	public List<Empleado> findEmpleadosSucursal() {
		
		return empleadoRepository.findAll();
	}

	public List<EmpleadosDTO> findSucEmpleado(Integer sucursal) {
		
		List<EmpleadosDTO> empleados = empleadoRepository.findEmpleadosSucursal(sucursal)
				.stream()
				.map(obj -> {
					EmpleadosDTO e = new EmpleadosDTO();
					e.setcEmpleado(obj[0].toString());
					e.setNombre(obj[1].toString());
					e.setEdad(obj[2].toString());
					e.setGenero(obj[3].toString());
					e.setEstado(obj[4].toString());
					return e;	
				}).collect(Collectors.toList());
		return empleados;
	}

	@Transactional
	public void delete(Empleado id) {
		empleadoRepository.delete(id);
	}

	@Transactional
	public void deleteAll() {
		empleadoRepository.deleteAll();
		
	}

	@Transactional
	public Empleado save(Empleado e) {
		empleadoRepository.save(e);
		return null;
	}

	@Override
	public Empleado findOne(Integer e) {
		return empleadoRepository.findById(e).get();
	}

}
