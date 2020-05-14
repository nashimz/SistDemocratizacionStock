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

import com.unla.Grupo8OO22020.helpers.*;
import com.unla.Grupo8OO22020.models.*;
import com.unla.Grupo8OO22020.services.*;

@Controller
@RequestMapping("/employee")

public class EmployeeController {
	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLOYEE_INDEX);
		mAV.addObject("employees", employeeService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLOYEE_NEW);
		mAV.addObject("employee", new EmployeeModel());
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("employee") EmployeeModel employeeModel) {
		employeeService.insertOrUpdate(employeeModel);
		return new RedirectView(ViewRouteHelper.EMPLOYE_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.EMPLOYEE_UPDATE);
		mAV.addObject("employee", employeeService.findById(id));
		return mAV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("employee") EmployeeModel employeeModel) {
		employeeService.insertOrUpdate(employeeModel);
		return new RedirectView(ViewRouteHelper.EMPLOYE_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		employeeService.remove(id);
		return new RedirectView(ViewRouteHelper.EMPLOYE_ROOT);
	}
}