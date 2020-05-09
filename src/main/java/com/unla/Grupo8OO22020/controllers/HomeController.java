package com.unla.Grupo8OO22020.controllers;

//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo8OO22020.helpers.ViewRouteHelper;




@Controller
@RequestMapping("/")
public class HomeController {
	
	//VER ESTE METODO DESPUES CAMBIARLO PARA QUE SEA UN MODELANDVIEW
	//GET Example:Server/index , petición normal.
	@GetMapping("/index")
	public String helloWorld() {
		return ViewRouteHelper.INDEX;
	}
	
	//GET Example: SERVER/hello?name=someName  , petición con parametros.
		@GetMapping("/hello")
		public ModelAndView helloParams1(@RequestParam(name="name", required=false, defaultValue="null") String name) {
			ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
			mV.addObject("name", name);
			return mV;
		}
		
		//GET Example: SERVER/hello/someName , petición con construcción de la ruta.
		@GetMapping("/hello/{name}")
		public ModelAndView helloParams2(@PathVariable("name") String name) {
			ModelAndView mV = new ModelAndView(ViewRouteHelper.HELLO);
			mV.addObject("name", name);
			return mV;
		}
		
		
		@GetMapping("/")
		public RedirectView redirectToHomeIndex() {
			return new RedirectView(ViewRouteHelper.ROUTE_INDEX);
		}
		
		@GetMapping("/local")
		public RedirectView redirectToLocalIndex() {
			return new RedirectView(ViewRouteHelper.LOCAL_INDEX);
		}
			
	

}