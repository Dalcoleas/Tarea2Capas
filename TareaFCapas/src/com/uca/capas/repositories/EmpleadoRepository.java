package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uca.capas.domain.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
	
	@Query(value="select e.nombre, e.edad, e.genero, e.estado " + 
			"from public.sucursal s, public.empleado e " + 
			"where s.id_sucursal = e.id_sucursal " + 
			"and s.id_sucursal = :csucursal", nativeQuery = true)
	public List<Object[]> findEmpleadosSucursal(@Param("csucursal") Integer csucursal);
	
	public List<Empleado> findAll();
}
