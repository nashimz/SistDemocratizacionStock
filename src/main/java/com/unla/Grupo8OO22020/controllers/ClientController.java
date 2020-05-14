package com.unla.Grupo8OO22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo8OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo8OO22020.services.IClientService;
import com.unla.Grupo8OO22020.models.ClientModel;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	@Qualifier("clientService")
	private IClientService clientService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENT_INDEX);
		mAV.addObject("clients", clientService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENT_NEW);
		mAV.addObject("client", new ClientModel());
		return mAV;
	}
	
	
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("client") ClientModel clientModel) {
		clientService.insertOrUpdate(clientModel);
		return new RedirectView(ViewRouteHelper.CLIENT_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.CLIENT_UPDATE);
		mAV.addObject("client", clientService.findById(id));
		return mAV;
	}
	
//	@GetMapping("/by_name/{name}")
//	public ModelAndView getByName(@PathVariable("name") String name) {
//		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_UPDATE);
//		mAV.addObject("person", personService.findByName(name));
//		return mAV;
//	}
	
	
	
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("client") ClientModel clientModel) {
		clientService.insertOrUpdate(clientModel);
		return new RedirectView(ViewRouteHelper.CLIENT_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		clientService.remove(id);
		return new RedirectView(ViewRouteHelper.CLIENT_ROOT);
	}
}