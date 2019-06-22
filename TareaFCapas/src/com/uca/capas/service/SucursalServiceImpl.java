package com.uca.capas.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Sucursal;
import com.uca.capas.repositories.SucursalRepository;

@Service
public class SucursalServiceImpl implements SucursalService{
	
	@Autowired
	SucursalRepository sucursalRepository; 

	public List<Sucursal> findAll() {
		
		return sucursalRepository.findAll();
	}

	public Sucursal findOne(Integer sucursal) {
	
		return sucursalRepository.findById(sucursal).get();
	}

	@Transactional
	public Sucursal save(Sucursal s) {
		return sucursalRepository.save(s);
	}

	@Transactional
	public void delete(Sucursal s) {
		sucursalRepository.delete(s);
	}

}
