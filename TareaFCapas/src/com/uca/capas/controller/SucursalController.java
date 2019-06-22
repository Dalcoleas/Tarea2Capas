package com.uca.capas.controller;

import java.util.List;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.dto.EmpleadosDTO;
import com.uca.capas.service.EmpleadoService;
import com.uca.capas.service.SucursalService;

import java.util.logging.Logger;

import javax.validation.Valid;


@Controller
public class SucursalController {
	
	@Autowired
	private SucursalService sucursalService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	static Logger log = Logger.getLogger(SucursalController.class.getName());
	
	@RequestMapping("/sucursales")
	public ModelAndView sucursales() {
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
			e = empleadoService.findSucEmpleado(cSucursal);
		}catch (Exception er) {
			log.log(Level.SEVERE,"Exception Occur",er);
		}
		
		mav.addObject("sucursal", s);
		mav.addObject("empleados", e);
		mav.setViewName("perfilS");
		return mav;
		
	}
	
	@RequestMapping(value = "/addSucursal")
	public ModelAndView insert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("sucursal",new Sucursal());
		mav.setViewName("newS");
		return mav;
	}
	
	@RequestMapping(value = "/editarSucursal")
	public ModelAndView editSucursal(@RequestParam("cSucursal") Integer cSucursal) {
		ModelAndView mav = new ModelAndView();
		Sucursal s = sucursalService.findOne(cSucursal);
		mav.addObject("sucursal", s);
		mav.setViewName("newS");
		return mav;
	}
	
	@RequestMapping(value = "/savesucursal", method= RequestMethod.POST)
	public ModelAndView saveSucursal(@Valid @ModelAttribute ("sucursal") Sucursal s, BindingResult r) {
		ModelAndView mav = new ModelAndView();
		List<Sucursal> suc = null;
		if(r.hasErrors()) {
			mav.setViewName("newS");
		}else {
			sucursalService.save(s);
			suc = sucursalService.findAll();
			mav.addObject("sucursales", suc);
			mav.setViewName("redirect:/sucursales");
		}
		return mav;
	}
	
	@RequestMapping("/eliminarSucursal")
	public ModelAndView eliminarSucursal(@RequestParam("cSucursal") Integer cSucursal) {
		ModelAndView mav = new ModelAndView();
		Sucursal s = sucursalService.findOne(cSucursal);
		sucursalService.delete(s);
		mav.addObject("sucursales", sucursalService.findAll());
		mav.setViewName("redirect:/sucursales");
		return mav;
	}
	
}
