package com.unla.Grupo8OO22020.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import com.unla.Grupo8OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo8OO22020.models.RankingProductModel;
import com.unla.Grupo8OO22020.services.IPedidoService;

import java.util.List;

@Controller
@RequestMapping("/ranking")
public class RankingController {

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@GetMapping("")
	public ModelAndView index() {
												
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.RANKING_INDEX);
		
		List<RankingProductModel> ranking = pedidoService.rankingProduct(pedidoService.getAll());

		mAV.addObject("rankingProductos",ranking);
		return mAV;		
	}
	
	@PostMapping("")
	public RedirectView redirect(@ModelAttribute("ranking") RankingProductModel rankingProductoModel){
		
		return new RedirectView(ViewRouteHelper.RANKING_INDEX);
		
	}
}
	