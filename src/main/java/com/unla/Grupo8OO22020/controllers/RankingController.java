package com.unla.Grupo8OO22020.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.Grupo8OO22020.entities.Pedido;
import com.unla.Grupo8OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo8OO22020.models.RankingProductModel;
import com.unla.Grupo8OO22020.services.IPedidoService;





@Controller
@RequestMapping("/ranking")
public class RankingController {

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@GetMapping("")
	public ModelAndView index() {
													// ranking/index
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.RANKING_INDEX);
		
		List<RankingProductModel> ranking = rankingProducto(pedidoService.getAll());

		mAV.addObject("rankingProductos",ranking);
		return mAV;		
	}
	
	@PostMapping("")
	public RedirectView redirect(@ModelAttribute("ranking") RankingProductModel rankingProductoModel){
		
		return new RedirectView(ViewRouteHelper.RANKING_INDEX);
		
	}
	
	
	
	public List<RankingProductModel> rankingProducto(List<Pedido> pedidos){
				
		Map<String,Integer> ranking = new HashMap<String,Integer>();
		List<RankingProductModel> rankingProd = new ArrayList<RankingProductModel>();
		
		for(Pedido p: pedidos) {
			if(p.isAceptado()) {
				if(!ranking.containsKey(p.getProduct().getDescription())) {
					ranking.put(p.getProduct().getDescription(), p.getQuantity());
				}
				else {
					ranking.replace(p.getProduct().getDescription(), ranking.get(p.getProduct().getDescription())+p.getQuantity());
				}
			}
		}

		for(String key : ranking.keySet()) {
			rankingProd.add(new RankingProductModel(key, ranking.get(key)));
		}
		
		Collections.sort(rankingProd, Collections.reverseOrder(Comparator.comparing(RankingProductModel::getCantidadVendida)));
		
		return rankingProd;
	}
}
	