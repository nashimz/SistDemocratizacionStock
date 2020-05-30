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
import com.unla.Grupo8OO22020.models.StockRequestModel;
import com.unla.Grupo8OO22020.services.IEmployeeService;
import com.unla.Grupo8OO22020.services.IProductService;
import com.unla.Grupo8OO22020.services.IStockRequestService;
import com.unla.Grupo8OO22020.services.IStoreService;


@Controller
@RequestMapping("/stockRequest")
public class StockRequestController {
	@Autowired
	@Qualifier("stockRequestService")
	private IStockRequestService stockRequestService;
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.STOCK_REQUEST_INDEX);
		mAV.addObject("stockRequests", stockRequestService.getAlls());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.STOCK_REQUEST_NEW);
		mV.addObject("stockRequest", new StockRequestModel());
		mV.addObject("products", productService.getAlls());
		mV.addObject("employees", employeeService.getAlls());
		mV.addObject("collaborators", employeeService.getAlls());
		mV.addObject("stores", storeService.getAlls());
		return mV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("stockRequest") StockRequestModel stockRequestModel) {
		stockRequestService.insert(stockRequestModel);
		return new RedirectView(ViewRouteHelper.STOCK_REQUEST_ROOT);
	}
	
	@GetMapping("/{idStockRequest}")
	public ModelAndView get(@PathVariable("idStockRequest") long idStockRequest) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.STOCK_REQUEST_UPDATE);
		mV.addObject("stockRequest", stockRequestService.findByIdStockRequest(idStockRequest));
		mV.addObject("products", productService.getAlls());
		mV.addObject("employees", employeeService.getAlls());
		mV.addObject("stores", storeService.getAlls());
		return mV;
	}
	
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("stockRequest") StockRequestModel stockRequestModel) {
		stockRequestService.update(stockRequestModel);
		return new RedirectView(ViewRouteHelper.STOCK_REQUEST_ROOT);
	}
		
	@PostMapping("/delete/{idStockRequest}")
	public RedirectView delete(@PathVariable("idStockRequest") long idStockRequest) {
		stockRequestService.remove(idStockRequest);
		return new RedirectView(ViewRouteHelper.STOCK_REQUEST_ROOT);
	}

}