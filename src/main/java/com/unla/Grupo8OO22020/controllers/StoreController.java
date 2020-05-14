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
import com.unla.Grupo8OO22020.services.IStoreService;
import com.unla.Grupo8OO22020.models.StoreModel;

@Controller
@RequestMapping("/store") 

public class StoreController {

	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.STORE_INDEX);
		mAV.addObject("stores", storeService.getAll());
		return mAV;

	}
	
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.STORE_NEW);
		mAV.addObject("store", new StoreModel());
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("store") StoreModel storeModel) {
		storeService.insertOrUpdate(storeModel);
		return new RedirectView(ViewRouteHelper.STORE_ROOT);
	}
	
	@GetMapping("/{idStore}")
	public ModelAndView get(@PathVariable("idStore") long idStore) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.STORE_UPDATE);
		mAV.addObject("store", storeService.findByIdStore(idStore));
		return mAV;
	}
	
	@GetMapping("/batch{id_Batch}")
	public ModelAndView getByIdBatch(@PathVariable("id_Batch") long idBatch) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.STORE_INDEX);
		mAV.addObject("stores", storeService.findByIdBatch(idBatch));
		return mAV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("store") StoreModel storeModel) {
		storeService.insertOrUpdate(storeModel);
		return new RedirectView(ViewRouteHelper.STORE_ROOT);
	}
	
	@PostMapping("/delete/{idStore}")
	public RedirectView delete(@PathVariable("idStore") long idStore) {
		storeService.remove(idStore);
		return new RedirectView(ViewRouteHelper.STORE_ROOT);
	}
	
}

