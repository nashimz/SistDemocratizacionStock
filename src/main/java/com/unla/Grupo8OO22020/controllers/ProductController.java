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

import com.unla.Grupo8OO22020.services.IProductService;
import com.unla.Grupo8OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo8OO22020.models.ProductModel;



@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PRODUCT_INDEX);
		mV.addObject("products", productService.getAlls());
		return mV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PRODUCT_NEW);
		mV.addObject("product", new ProductModel());
		return mV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("product") ProductModel productModel) {
		productService.insertOrUpdate(productModel);
		return new RedirectView(ViewRouteHelper.PRODUCT_ROOT);
	}
	
	
	
	@GetMapping("/{idProduct}")
	public ModelAndView get(@PathVariable("idProduct") int idProduct) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PRODUCT_UPDATE);
		mV.addObject("product", productService.findByIdProduct(idProduct));
		return mV;
	}
	
	
	@GetMapping("/description/{description_name}")
	public ModelAndView getByDescriptionName(@PathVariable("description_name") String descriptionName) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PRODUCT_INDEX);
		mV.addObject("products", productService.findByDescriptionName(descriptionName));
		return mV;
	}
	
	
	@GetMapping("/size/{size_name}")
	public ModelAndView getBySizeName(@PathVariable("size_name") String sizeName) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PRODUCT_INDEX);
		mV.addObject("products", productService.findBySizeName(sizeName));
		return mV;
	}
	
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("product") ProductModel productModel) {
		productService.insertOrUpdate(productModel);
		return new RedirectView(ViewRouteHelper.PRODUCT_ROOT);
	}
	
	
	@PostMapping("/delete/{idProduct}")
	public RedirectView delete(@PathVariable("idProduct") long idProduct) {
		productService.remove(idProduct);
		return new RedirectView(ViewRouteHelper.PRODUCT_ROOT);
	}
}
