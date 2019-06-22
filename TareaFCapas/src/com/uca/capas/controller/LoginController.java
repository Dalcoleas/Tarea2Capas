package com.uca.capas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Usuario;
import com.uca.capas.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		Usuario u = new Usuario();
		mav.addObject("usuario",u);
		mav.setViewName("main");
		return mav;
	}	
	
	@RequestMapping(value="/verificarusuario", method=RequestMethod.POST)
	public ModelAndView validarUsuario(@Valid  @ModelAttribute Usuario usu, BindingResult r, @RequestParam(value="usuario") String user, @RequestParam(value="contraseña") String password) {
		ModelAndView mav = new ModelAndView();
		Usuario u = usuarioService.findUser(user, password);
		if( r.hasErrors()) {
			mav.setViewName("main");
		} 
		
		else if(u==null) {
			mav.addObject("resultado",0);
			mav.setViewName("main");
		}
		else {
			mav.setViewName("redirect:/sucursales");
		}
		return mav;
	}
}
