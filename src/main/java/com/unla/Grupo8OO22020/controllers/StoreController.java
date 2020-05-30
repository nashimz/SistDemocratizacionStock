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

import com.unla.Grupo8OO22020.entities.Store;
import com.unla.Grupo8OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo8OO22020.services.IBatchService;
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
	
	@Autowired
	@Qualifier("batchService")
	private IBatchService batchService;
	
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
		mV.addObject("employees", employeeService.getAlls());
		mV.addObject("batches", batchService.getAlls());
		return mV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("store") StoreModel storeModel) {
		storeService.insert(storeModel);
		return new RedirectView(ViewRouteHelper.STORE_ROOT);
	}
	
	@GetMapping("/{idStore}")
	public ModelAndView get(@PathVariable("idStore") long idStore) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.STORE_UPDATE);
		mV.addObject("store", storeService.findByIdStore(idStore));
		mV.addObject("batches",batchService.findByIdStore(idStore));
		mV.addObject("employees", employeeService.findByIdStore(idStore));
		return mV;
	}
	
	@GetMapping("/consultNearby{idStore}")
	public ModelAndView consultNearby(@PathVariable("idStore") long idStore) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.STORE_NEAR);
		StoreModel storeModel=storeService.findByIdStore(idStore);
		mV.addObject("stores", storeService.getNearestStore(storeModel));
		return mV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("store") StoreModel storeModel) {
		storeService.update(storeModel);
		return new RedirectView(ViewRouteHelper.STORE_ROOT);
	}
	
	@GetMapping("/distanceStores")
	public ModelAndView distanceStores() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.STORE_DISTANCE);
		mV.addObject("stores", storeService.getAlls());
		return mV;
	}
	
	@RequestMapping(value="/calculatedistance",method=RequestMethod.POST)
	public ModelAndView calculatedistance(StoresModel stores) {
		ModelAndView mV=new ModelAndView(ViewRouteHelper.STORE_CALCULATEDISTANCE);
		double distancia=Store.distanciaCoord(storeService.findByIdStore(stores.getStore1().getIdStore()).getLatitude(),storeService.findByIdStore(stores.getStore1().getIdStore()).getLongitude(),storeService.findByIdStore(stores.getStore2().getIdStore()).getLatitude(),storeService.findByIdStore(stores.getStore2().getIdStore()).getLongitude());
	    mV.addObject("distancia",distancia);
		return mV;	
	}
	
	@PostMapping("/delete/{idStore}")
	public RedirectView delete(@PathVariable("idStore") long idStore) {
		storeService.remove(idStore);
		return new RedirectView(ViewRouteHelper.STORE_ROOT);
	}
	
}
