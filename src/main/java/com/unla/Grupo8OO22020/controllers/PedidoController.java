package com.unla.Grupo8OO22020.controllers;



import java.time.LocalDate;




import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import com.unla.Grupo8OO22020.helpers.ViewRouteHelper;
import com.unla.Grupo8OO22020.models.EmployeeModel;
import com.unla.Grupo8OO22020.models.PedidoModel;
import com.unla.Grupo8OO22020.models.ProductModel;
import com.unla.Grupo8OO22020.models.StoreModel;
import com.unla.Grupo8OO22020.services.IBatchService;
import com.unla.Grupo8OO22020.services.IClientService;
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
	
	@Autowired
	@Qualifier("clientService")
	private IClientService clientService;

	
	
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
		mV.addObject("clients", clientService.getAlls());
		mV.addObject("products", productService.getAlls());
		mV.addObject("employees",employeeService.getAllv());
		return mV;
	}
	
	@PostMapping("/create")
	public ModelAndView create(@ModelAttribute("pedido") PedidoModel pedidoModel,RedirectAttributes redirectAttrs) {
		pedidoService.setAttributes(pedidoModel);
		pedidoModel.setCollaborator(employeeService.findById(pedidoModel.getEmployee().getId()));
		if(pedidoService.validarConsumo(pedidoModel.getStore(),pedidoModel.getProduct(),pedidoModel.getQuantity())) {
			  pedidoService.insert(pedidoModel);	
			  if(pedidoModel.isAccept()) {
			    pedidoService.consumoStock(pedidoModel.getStore(),pedidoModel.getProduct(),pedidoModel.getQuantity());
			    pedidoService.paySalary(pedidoModel.getEmployee(),pedidoModel.getCollaborator(),pedidoModel.getProduct(),pedidoModel.getQuantity());
			 }
		}else { 
			
	          List<StoreModel> stores=new ArrayList<StoreModel>();
			try {
				 int missing=pedidoModel.getQuantity()-pedidoService.calculateStock(pedidoModel.getStore(),pedidoModel.getProduct());
				 stores=storeService.storeStockRequest(storeService.findByIdStore(employeeService.findById(pedidoModel.getEmployee().getId()).getStore().getIdStore()),pedidoModel.getProduct(),missing);
			    if(stores!=null) {
				    ModelAndView mV = new ModelAndView(ViewRouteHelper.PEDIDO_COLLABORATOR);
					mV.addObject("stores",storeService.getAlls());
					mV.addObject("storeswithstock",stores);
					 if (!stores.isEmpty()) {
						pedidoService.insert(pedidoModel);
					  }
					mV.addObject("pedidos", pedidoService.findByIdPedido(pedidoService.getAlls().get(pedidoService.getAlls().size() - 1).getIdPedido()));
					mV.addObject("storev", new StoreModel());
					return mV;
			    }
			    } catch (Exception e) {
					redirectAttrs.addFlashAttribute("mensaje", "No tenemos el stock disponible para su pedido de " + pedidoModel.getProduct().getDescription() + ", sepa disculpar las molestias.");
					redirectAttrs.addFlashAttribute("clase", "danger");
					ModelAndView mV = new ModelAndView(new RedirectView(ViewRouteHelper.PEDIDO_ROOT));
					return mV;

				} finally {
					if (stores.isEmpty()) {
						redirectAttrs.addFlashAttribute("mensaje", "No tenemos el stock disponible para su pedido de " + pedidoModel.getProduct().getDescription() + ", sepa disculpar las molestias.");
						redirectAttrs.addFlashAttribute("clase", "danger");
						ModelAndView mV = new ModelAndView(new RedirectView(ViewRouteHelper.PEDIDO_ROOT));
						return mV;
					}
			    
		}
		}
		ModelAndView mV = new ModelAndView(new RedirectView(ViewRouteHelper.PEDIDO_ROOT));
		return mV;
	}
	
	
	
	@PostMapping("/stockrequest")
	public RedirectView stockrequest(@ModelAttribute PedidoModel pedidoModel, StoreModel store) {
		
		pedidoService.setAttributeRequest(pedidoModel,store);
		pedidoService.insert(pedidoModel);
		int missing=pedidoModel.getQuantity()-pedidoService.calculateStock(employeeService.findById(pedidoModel.getEmployee().getId()).getStore(),pedidoModel.getProduct());
		if (pedidoModel.isAccept()) {
			pedidoService.consumoStock(employeeService.findById(pedidoModel.getEmployee().getId()).getStore(),pedidoModel.getProduct(),pedidoService.calculateStock(pedidoModel.getStore(),pedidoModel.getProduct()));
			pedidoService.consumoStock(employeeService.findById(pedidoModel.getCollaborator().getId()).getStore(),pedidoModel.getProduct(),missing);
			pedidoService.paySalary(pedidoModel.getEmployee(),pedidoModel.getCollaborator(),pedidoModel.getProduct(),pedidoModel.getQuantity());
		}
		
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
	    

	
	@GetMapping("/{idPedido}")
	public ModelAndView get(@PathVariable("idPedido") long idPedido) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PEDIDO_UPDATE);
		mV.addObject("pedido", pedidoService.findByIdPedido(idPedido));
		mV.addObject("clients", clientService.getAlls());
		mV.addObject("products", productService.getAlls());
		mV.addObject("stores", storeService.getAlls());
		mV.addObject("employees",employeeService.getAllv());
		return mV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("pedido") PedidoModel pedidoModel,RedirectAttributes redirectAttrs) {
		pedidoService.setAttributes(pedidoModel);
		pedidoModel.setDate(pedidoModel.getDate());
		pedidoModel.setCollaborator(employeeService.findById(pedidoModel.getCollaborator().getId()));
		pedidoModel.getCollaborator().setStore(storeService.findByIdStore(employeeService.findById(pedidoModel.getCollaborator().getId()).getStore().getIdStore()));
		int stockTotal=pedidoService.calculateStock(pedidoModel.getStore(),pedidoModel.getProduct())+pedidoService.calculateStock(pedidoModel.getCollaborator().getStore(),pedidoModel.getProduct());
		if(pedidoModel.getQuantity()<=stockTotal || pedidoService.validarConsumo(pedidoModel.getStore(),pedidoModel.getProduct(),pedidoModel.getQuantity())) {
		  pedidoService.update(pedidoModel);
	      int missing=pedidoModel.getQuantity()-pedidoService.calculateStock(pedidoModel.getStore(),pedidoModel.getProduct());
	      if (pedidoModel.isAccept() && pedidoModel.getCollaborator().getDni()==pedidoModel.getEmployee().getDni()) {
			  pedidoService.consumoStock(storeService.findByIdStore(employeeService.findById(pedidoModel.getEmployee().getId()).getStore().getIdStore()),productService.findByIdProduct(pedidoModel.getProduct().getIdProduct()),pedidoModel.getQuantity());
			  
		} else if (pedidoModel.isAccept() && pedidoModel.getCollaborator().getDni() !=pedidoModel.getEmployee().getDni()) {
			      pedidoService.consumoStock(employeeService.findById(pedidoModel.getEmployee().getId()).getStore(),pedidoModel.getProduct(),pedidoService.calculateStock(pedidoModel.getStore(),pedidoModel.getProduct()));
			      pedidoService.consumoStock(storeService.findByIdStore(employeeService.findById(pedidoModel.getCollaborator().getId()).getStore().getIdStore()),productService.findByIdProduct(pedidoModel.getProduct().getIdProduct()),missing);
			      
			    }
	      pedidoService.paySalary(pedidoModel.getEmployee(),pedidoModel.getCollaborator(),pedidoModel.getProduct(),pedidoModel.getQuantity());
		}else {
			redirectAttrs.addFlashAttribute("mensaje","El pedido excede la capacidad de nuestros locales. Si desea comprar una cantidad superior a "+stockTotal+ " realice otro pedido.");
			redirectAttrs.addFlashAttribute("clase", "danger");
			pedidoService.remove(pedidoModel.getIdPedido());
			return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
		}
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}		
	
	@GetMapping("/getproductbetweendates")
	public ModelAndView getproductbetweendates() {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PEDIDO_INDEX_BETWEEN_DATES);
		mV.addObject("store",new StoreModel());
		mV.addObject("stores", storeService.getAlls());
		return mV;
	}
	
	@RequestMapping(value ="/producbetweendates", method = RequestMethod.POST)
	public ModelAndView productbetweendates(@ModelAttribute("store") StoreModel store,@RequestParam("since") @DateTimeFormat(pattern = "yy-MM-dd") Date since,@RequestParam("until") @DateTimeFormat(pattern = "yy-MM-dd")Date until) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.PEDIDO_PRODUCT_BETWEEN_DATES);
		store.setIdStore(storeService.findByIdStore(store.getIdStore()).getIdStore());
		LocalDate date1 = since.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate date2 = until.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		List<ProductModel> products = storeService.soldProductsBetweenDates(store,date1,date2);
		mV.addObject("products",products);
		return mV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/salary")
	public ModelAndView salary() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_SALARY);
		return mAV;		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/endingofmonth", method=RequestMethod.POST)
	public ModelAndView endingofmonth(@RequestParam("month") int month, @RequestParam("year") int year) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_ENDINGOFMONTH);
		List<EmployeeModel> listEmployees= pedidoService.paySalary(month, year);
		mAV.addObject("employees", listEmployees);
		return mAV;
	}

	@PostMapping("/delete/{idPedido}")
	public RedirectView delete(@PathVariable("idPedido") long idPedido) {
		pedidoService.remove(idPedido);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
		}
	
}
	