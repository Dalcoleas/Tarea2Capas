package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Sucursal;

public interface SucursalService {
	
	public List<Sucursal> findAll();
	
	public Sucursal findOne(Integer sucursal);
	
	public Sucursal save(Sucursal s);
	
	public void delete(Sucursal s);
	
}
