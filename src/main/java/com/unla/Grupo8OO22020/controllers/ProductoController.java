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

import com.unla.Grupo8OO22020.services.IProductoService;
import com.unla.Grupo8OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo8OO22020.models.ProductoModel;



@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	//metodo simple que me trae una vista que me lista a todos los productos existentes y me permite hacer consultas
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_INDEX);
		mAV.addObject("productos", productoService.getAll());
		return mAV;
	}
	
	//metodo que me traer una vista para generar un un formulario para un producto nuevo
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_NEW);
		mAV.addObject("producto", new ProductoModel());
		return mAV;
	}
	
	// metodo para crear un producto nuevo haciendo un post al servidor
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("producto") ProductoModel productoModel) {
		productoService.insertOrUpdate(productoModel);
		return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
	}
	
	//metodo para consultar productos a traves de su id
	
	@GetMapping("/{idProducto}")
	public ModelAndView get(@PathVariable("idProducto") int idProducto) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_UPDATE);
		mAV.addObject("producto", productoService.findByIdProducto(idProducto));
		return mAV;
	}
	
	
	//metodo para rutear por otra variable que no sea el id 
	@GetMapping("/by_descripcion/{descripcion}")
	public ModelAndView getByDescripcion(@PathVariable("descripcion") String descripcion) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_UPDATE);
		mAV.addObject("producto", productoService.findByDescripcion(descripcion));
		return mAV;
	}
	
	@GetMapping("/by_talle/{talle}")
	public ModelAndView getByTalle(@PathVariable("talle") String talle) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_UPDATE);
		mAV.addObject("producto", productoService.findByTalle(talle));
		return mAV;
	}
	
	@GetMapping("/descripcion/{descripcion_name}")
	public ModelAndView getByDescripcionName(@PathVariable("descripcion_name") String descripcionName) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_INDEX);
		mAV.addObject("productos", productoService.findByDescripcionName(descripcionName));
		return mAV;
	}
	
	
	@GetMapping("/talle/{talle_name}")
	public ModelAndView getByTalleName(@PathVariable("talle_name") String talleName) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_INDEX);
		mAV.addObject("productos", productoService.findByTalleName(talleName));
		return mAV;
	}
	
	//metodo para poder actualizar un producto
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("producto") ProductoModel productoModel) {
		productoService.insertOrUpdate(productoModel);
		return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
	}
	
	//metodo para poder eliminar un producto
	@PostMapping("/delete/{idProducto}")
	public RedirectView delete(@PathVariable("idProducto") long idProducto) {
		productoService.remove(idProducto);
		return new RedirectView(ViewRouteHelper.PRODUCTO_ROOT);
	}
}
