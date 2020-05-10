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
import com.unla.Grupo8OO22020.models.LoteModel;
import com.unla.Grupo8OO22020.services.ILoteService;
import com.unla.Grupo8OO22020.services.IProductoService;



@Controller
@RequestMapping("/lote")
public class LoteController {
	
	
	
	@Autowired
	@Qualifier("LoteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("ProductoService")
	private IProductoService productoService;
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.LOTE_NEW);
		mV.addObject("lote", new LoteModel());
		mV.addObject("productos", productoService.getAll());
		return mV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("lote") LoteModel loteModel) {
		System.out.println("El id es :"+loteModel.getProducto().getIdProducto());
		loteService.insert(loteModel);
		return new RedirectView(ViewRouteHelper.LOTE_ROOT);
	}
	
	@GetMapping("/{idLote}")
	public ModelAndView get(@PathVariable("idLote") long idLote) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.LOTE_UPDATE);
		mV.addObject("lote", loteService.findByIdLote(idLote));
		mV.addObject("productos", productoService.getAll());
		return mV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("lote") LoteModel loteModel) {
	 System.out.println("El id es :"+loteModel.getProducto().getIdProducto());
	 loteService.update(loteModel);
	 return new RedirectView(ViewRouteHelper.LOTE_ROOT);
	}
}
