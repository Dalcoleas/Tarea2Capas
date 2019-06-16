package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer>{
	
	public List<Sucursal> findAll();
}
