package com.unla.Grupo8OO22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.unla.Grupo8OO22020.helpers.*;
import com.unla.Grupo8OO22020.models.*;
import com.unla.Grupo8OO22020.services.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.EMPLOYEE_INDEX);
		mV.addObject("employees", employeeService.getAlls());
		return mV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.EMPLOYEE_NEW);
		mV.addObject("employee", new EmployeeModel());
		mV.addObject("stores", storeService.getAlls());
		return mV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("employee") EmployeeModel employeeModel) {
		employeeService.insertOrUpdate(employeeModel);
		return new RedirectView(ViewRouteHelper.EMPLOYE_ROOT);
	}
	
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.EMPLOYEE_UPDATE);
		mV.addObject("employee", employeeService.findById(id));
		mV.addObject("stores", storeService.getAlls());
		return mV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("employee") EmployeeModel employeeModel) {
		employeeService.insertOrUpdate(employeeModel);
		return new RedirectView(ViewRouteHelper.EMPLOYE_ROOT);
	}
	
	
	@GetMapping("/store/{store_id}")
	public ModelAndView getByStoreId(@PathVariable("store_id") long storeId) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.EMPLOYEE_INDEX);
		mV.addObject("employees", employeeService.findByIdStore(storeId));
		return mV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		employeeService.remove(id);
		return new RedirectView(ViewRouteHelper.EMPLOYE_ROOT);
	}
}