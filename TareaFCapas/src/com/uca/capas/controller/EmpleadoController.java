package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Empleado;
import com.uca.capas.domain.Sucursal;
import com.uca.capas.dto.EmpleadosDTO;
import com.uca.capas.service.EmpleadoService;
import com.uca.capas.service.SucursalService;

@Controller
public class EmpleadoController {
	
	@Autowired
	private SucursalService sucursalService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@RequestMapping("/agregarEmpleado")
	public ModelAndView addEmpleado(@RequestParam(name= "sucursalID") Integer id) {
		ModelAndView mav = new ModelAndView();
		Sucursal s = sucursalService.findOne(id);
		System.out.println(s.getcSucursal().toString());
		mav.addObject("empleado", new Empleado());
		mav.addObject("sucursal", s);
		mav.setViewName("newE");
		
		return mav;
	}
	
	@RequestMapping(value="/saveempleado", method=RequestMethod.POST)
	public ModelAndView saveEmpleado(@Valid @ModelAttribute("empleado") Empleado e, BindingResult r, @RequestParam("cSucursal") Integer idSuc ){
		ModelAndView mav = new ModelAndView();
		Sucursal s = null;
		s = sucursalService.findOne(idSuc);
		e.setSucursal(s);
		List<EmpleadosDTO> emp = null;
		if(r.hasErrors()) {
			mav.setViewName("newE");
			mav.addObject("resultado", 0);
			mav.addObject("sucursal", s);
			
		}
		else {
			empleadoService.save(e);
			emp = empleadoService.findSucEmpleado(idSuc);
			mav.addObject("resultado",1);
			mav.addObject("sucursal", s);
			mav.addObject("empleados", emp);
			mav.setViewName("newE");
		}
		
		return mav;
	}
	
	@RequestMapping("/editarEmpleado")
	public ModelAndView editEmpleado(@RequestParam("cSucursal") Integer idSuc, @RequestParam("cEmpleado") Integer idEmp){
		ModelAndView mav = new ModelAndView();
		Sucursal s = null;
		Empleado e = null;
		e = empleadoService.findOne(idEmp);
		s = sucursalService.findOne(idSuc);
		mav.addObject("empleado", e);
		mav.addObject("sucursal", s);
		mav.setViewName("newE");
		return mav;
	}
	
	@RequestMapping("borrarEmpleado")
	public ModelAndView deleteEmpleado(@RequestParam("cEmpleado") Integer id, @RequestParam("cSucursal") Integer cSucursal) {
		ModelAndView mav = new ModelAndView();
		List<EmpleadosDTO> et = null;
		Sucursal s = null;
		Empleado e = empleadoService.findOne(id);
		empleadoService.delete(e);
		s = sucursalService.findOne(cSucursal);
		et = empleadoService.findSucEmpleado(cSucursal);
		mav.addObject("sucursal", s);
		mav.addObject("empleados", et);
		mav.setViewName("perfilS");
		return mav;
	}
}
