package com.unla.Grupo8OO22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.Grupo8OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo8OO22020.services.IStockRequestService;


@Controller
@RequestMapping("/stockRequest")
public class StockRequestController {
	@Autowired
	@Qualifier("stockRequestService")
	private IStockRequestService stockRequestService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.STOCK_REQUEST_INDEX);
		mAV.addObject("stockRequests", stockRequestService.getAlls());
		return mAV;
	}

}
