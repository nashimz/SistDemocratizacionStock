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
import com.unla.Grupo8OO22020.models.PedidoModel;
import com.unla.Grupo8OO22020.services.IBatchService;
import com.unla.Grupo8OO22020.services.IEmployeeService;
import com.unla.Grupo8OO22020.services.IPedidoService;
import com.unla.Grupo8OO22020.services.IProductService;
import com.unla.Grupo8OO22020.services.IStoreService;



@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	@Autowired
	@Qualifier("batchService")
	private IBatchService batchService;
	
	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	

	
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PEDIDO_INDEX);
		mV.addObject("pedidos", pedidoService.getAlls());
		return mV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PEDIDO_NEW);
		mV.addObject("pedido", new PedidoModel());
		mV.addObject("products", productService.getAlls());
		mV.addObject("employees",employeeService.getAllv());
		return mV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("pedido") PedidoModel pedidoModel) {
		pedidoModel.setEmployee(employeeService.findById(pedidoModel.getEmployee().getId()));
		pedidoModel.setCollaborator(employeeService.findById(pedidoModel.getEmployee().getId()));
		pedidoModel.setStore(storeService.findByIdStore(employeeService.findById(pedidoModel.getEmployee().getId()).getStore().getIdStore()));
		pedidoModel.setSubtotal(productService.findByIdProduct(pedidoModel.getProduct().getIdProduct()).getPrice()*pedidoModel.getQuantity());
		if(pedidoService.validarConsumo(pedidoModel)){
			pedidoService.insert(pedidoModel);	
			if(pedidoModel.isAccept()) {
			pedidoService.consumoStock(pedidoModel);
			}
		}
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
	
	@GetMapping("/{idPedido}")
	public ModelAndView get(@PathVariable("idPedido") long idPedido) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PEDIDO_UPDATE);
		mV.addObject("pedido", pedidoService.findByIdPedido(idPedido));
		mV.addObject("products", productService.getAlls());
		mV.addObject("stores", storeService.getAlls());
		mV.addObject("employees",employeeService.getAllv());
		return mV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("pedido") PedidoModel pedidoModel) {
		System.out.println(pedidoModel.getQuantity());
		if(pedidoService.validarConsumo(pedidoModel)){
			pedidoService.insert(pedidoModel);	
			if(pedidoModel.isAccept()) {
			pedidoService.consumoStock(pedidoModel);
			}
		}
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
	
	
	@PostMapping("/delete/{idPedido}")
	public RedirectView delete(@PathVariable("idPedido") long idPedido) {
		pedidoService.remove(idPedido);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
		}
	
}
