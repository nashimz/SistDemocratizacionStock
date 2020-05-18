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
import com.unla.Grupo8OO22020.models.BatchModel;
import com.unla.Grupo8OO22020.services.IBatchService;
import com.unla.Grupo8OO22020.services.IProductService;


@Controller
@RequestMapping("/batch")
public class BatchController {

	@Autowired
	@Qualifier("batchService")
	private IBatchService batchService;
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.BATCH_INDEX);
		mV.addObject("batches", batchService.getAlls());
		return mV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.BATCH_NEW);
		mV.addObject("batch", new BatchModel());
		mV.addObject("products", productService.getAll());
		return mV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("batch") BatchModel batchModel) {
		System.out.println("El id es :"+batchModel.getProduct().getIdProduct());
		batchService.insert(batchModel);
		return new RedirectView(ViewRouteHelper.BATCH_ROOT);
	}
	
	@GetMapping("/{idBatch}")
	public ModelAndView get(@PathVariable("idBatch") long idBatch) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.BATCH_UPDATE);
		mV.addObject("batch", batchService.findByIdBatch(idBatch));
		mV.addObject("products", productService.getAll());
		return mV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("batch") BatchModel batchModel) {
	 System.out.println("El id es :"+batchModel.getProduct().getIdProduct());
	 batchService.update(batchModel);
	 return new RedirectView(ViewRouteHelper.BATCH_ROOT);
	}
	
	//metodo para poder eliminar un producto
		@PostMapping("/delete/{idBatch}")
		public RedirectView delete(@PathVariable("idBatch") long idBatch) {
			batchService.remove(idBatch);
			return new RedirectView(ViewRouteHelper.BATCH_ROOT);
		}
}
