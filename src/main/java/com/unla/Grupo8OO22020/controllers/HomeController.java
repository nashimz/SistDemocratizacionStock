package com.unla.Grupo8OO22020.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.unla.Grupo8OO22020.helpers.ViewRouteHelper;


@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mV= new ModelAndView(ViewRouteHelper.HOME_INDEX);
		return mV;
	}
	
	

	
	

}
