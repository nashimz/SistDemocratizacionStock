package com.unla.Grupo8OO22020.controllers;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo8OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo8OO22020.services.IEmployeeService;
import com.unla.Grupo8OO22020.services.IStoreService;

import com.unla.Grupo8OO22020.models.StoreModel;
import com.unla.Grupo8OO22020.models.StoresModel;

@Controller
@RequestMapping("/store") 
public class StoreController {

	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	@Autowired
	@Qualifier("employeeService")
	private IEmployeeService employeeService;
	

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.STORE_INDEX);
		mV.addObject("stores", storeService.getAlls());
		return mV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.STORE_NEW);
		mV.addObject("store", new StoreModel());
		mV.addObject("managers", employeeService.getAll());
		return mV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("store") StoreModel storeModel) {
		System.out.println("El id es :"+storeModel.getManager().getId());
		storeService.insert(storeModel);
		return new RedirectView(ViewRouteHelper.STORE_ROOT);
	}
	
	@GetMapping("/{idStore}")
	public ModelAndView get(@PathVariable("idStore") long idStore) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.STORE_UPDATE);
		mV.addObject("store", storeService.findByIdStore(idStore));
		mV.addObject("managers", employeeService.getAll());
		return mV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("store") StoreModel storeModel) {
		System.out.println("El id es :"+storeModel.getManager().getId());
		storeService.update(storeModel);
		return new RedirectView(ViewRouteHelper.STORE_ROOT);
	}
	
	@GetMapping("/distanceStores")
	public ModelAndView distanceStores() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.STORE_DISTANCE);
		mV.addObject("stores", storeService.getAlls());
		return mV;
	}
	
	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {
		double radioTierra = 6371;
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
		+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		return radioTierra * va2;
		}

	@RequestMapping(value="/calculatedistance",method=RequestMethod.POST)
	public ModelAndView calculatedistance(StoresModel stores) {
		ModelAndView mV=new ModelAndView(ViewRouteHelper.STORE_CALCULATEDISTANCE);
		double distancia=distanciaCoord(storeService.findByIdStore(stores.getStore1().getIdStore()).getLatitude(),storeService.findByIdStore(stores.getStore1().getIdStore()).getLongitude(),storeService.findByIdStore(stores.getStore2().getIdStore()).getLatitude(),storeService.findByIdStore(stores.getStore2().getIdStore()).getLongitude());
	    mV.addObject("distancia",distancia);
		return mV;	
	}
	
	@GetMapping("/producto{id_Product}")
	public ModelAndView getByIdProduct(@PathVariable("id_Product") long idProduct) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.STORE_INDEX);
		mV.addObject("stores", storeService.findByIdProduct(idProduct));
		return mV;
	}
	
	@PostMapping("/delete/{idStore}")
	public RedirectView delete(@PathVariable("idStore") long idStore) {
		storeService.remove(idStore);
		return new RedirectView(ViewRouteHelper.STORE_ROOT);
	}
	
}

