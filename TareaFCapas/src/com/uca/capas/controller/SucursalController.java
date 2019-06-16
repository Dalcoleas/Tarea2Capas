package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.dto.EmpleadosDTO;
import com.uca.capas.service.EmpleadoService;
import com.uca.capas.service.SucursalService;

import java.util.logging.Logger;


@Controller
public class SucursalController {
	
	@Autowired
	private SucursalService sucursalService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	static Logger log = Logger.getLogger(SucursalController.class.getName());
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Sucursal> sucursales = null;
		try {
			sucursales = sucursalService.findAll();
		} 
		catch (Exception e) {
			log.log(Level.SEVERE,"Exception Occur",e);
		}
		mav.addObject("sucursales",sucursales);
		mav.setViewName("sucursal");
		return mav;
	}
	
	@RequestMapping("/perfilSucursal")
	public ModelAndView perfilSucursal(@RequestParam("cSucursal") Integer cSucursal) {
		ModelAndView mav = new ModelAndView();
		List<EmpleadosDTO> e = null;
		Sucursal s = null;
		
		try {
			s = sucursalService.findOne(cSucursal);
			e = empleadoService.findVehCliente(cSucursal);
		}catch (Exception er) {
			log.log(Level.SEVERE,"Exception Occur",er);
		}
		
		mav.addObject("sucursal", s);
		mav.addObject("empleados", e);
		mav.setViewName("perfilS");
		return mav;
		
	}
	
	/*ver perfil...
	
	empleados = findByid(cSucursal)
	
	empleados */
	
	
}
