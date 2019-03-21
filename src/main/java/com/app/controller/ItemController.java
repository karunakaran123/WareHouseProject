package com.app.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Item;
import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IItemService;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;
import com.app.validator.ItemValidator;

@Controller
@RequestMapping("/item")
public class ItemController {
   
	@Autowired	
	private IItemService service;
	
	@Autowired
	private IUomService uomservice;
	
	@Autowired
	private IOrderMethodService omservice;
	
	@Autowired
	private IWhUserTypeService whuserservice;
	
	@Autowired
	private ItemValidator validator;
	
	@RequestMapping("/reg")
	public String showReg(ModelMap map) {
		map.addAttribute("item",new Item());
		
		List<Uom> uom=uomservice.getAllUoms();
		map.addAttribute("uom",uom);
		
		List<OrderMethod> sales=omservice.getOrderMethodByMode("sale");
		map.addAttribute("sales",sales);
		
		List<OrderMethod> purchases=omservice.getOrderMethodByMode("purchase");
		map.addAttribute("purchases",purchases);
		
		List<WhUserType> vendors=whuserservice.getWhUserTypesByType("vendor");
		map.addAttribute("vendors",vendors);
		
		List<WhUserType> customers=whuserservice.getWhUserTypesByType("customer");
		map.addAttribute("customers",customers);
		
		return "ItemReg";
	}
	@RequestMapping("/home")
	public String showItemHome() {
		
		return "ItemHome";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertData(@ModelAttribute Item item,Errors errors,ModelMap map){
		
		validator.validate(item,errors);
		
		if(!errors.hasErrors())
		{
		Integer itemId=service.saveItem(item);
		String msg="Item "+itemId+" saved";
		map.addAttribute("message",msg);
		map.addAttribute("item",new Item());
		
		List<Uom> uom=uomservice.getAllUoms();
		map.addAttribute("uom",uom);
		
		
		List<OrderMethod> sales=omservice.getOrderMethodByMode("sale");
		map.addAttribute("sales",sales);
		
		List<OrderMethod> purchases=omservice.getOrderMethodByMode("purchase");
		map.addAttribute("purchases",purchases);
	
		
		List<WhUserType> vendors=whuserservice.getWhUserTypesByType("vendor");
		map.addAttribute("vendors",vendors);
		
		List<WhUserType> customers=whuserservice.getWhUserTypesByType("customer");
		map.addAttribute("customers",customers);
	
		}
		return "ItemReg";
	}
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<Item> list=service.getAllItems();
		map.addAttribute("list",list);
		return "ItemData";
	}
	@RequestMapping("/delete")
	public String showDelete(@RequestParam Integer id, ModelMap map) {
		service.deleteItem(id);
		String msg="Item "+id+" dleted";
		List<Item> list=service.getAllItems();
		map.addAttribute("message",msg);
		map.addAttribute("list",list);
		return "ItemData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam Integer id,ModelMap map) {
		Item item=service.getOneItem(id);
		map.addAttribute("item",item);
		
		List<Uom> uom=uomservice.getAllUoms();
		map.addAttribute("uom",uom);
		
		List<OrderMethod> sales=omservice.getOrderMethodByMode("sale");
		map.addAttribute("sales",sales);
		
		List<OrderMethod> purchases=omservice.getOrderMethodByMode("purchase");
		map.addAttribute("purchases",purchases);
		
		List<WhUserType> vendors=whuserservice.getWhUserTypesByType("vendor");
		map.addAttribute("vendors",vendors);
		
		List<WhUserType> customers=whuserservice.getWhUserTypesByType("customer");
		map.addAttribute("customers",customers);
	
		return "ItemEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String insertUpdateData(@ModelAttribute Item item,ModelMap map) {
		service.updateItem(item);
		String msg="Item "+item.getItemId()+" updated";
		List<Item> list=service.getAllItems();
		map.addAttribute("message",msg);
		map.addAttribute("list",list);
		return "ItemData";
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdfView() {
		List<Item> list=service.getAllItems();
		ModelAndView m=new ModelAndView();
		m.setView(null);
		m.addObject("list",list);
		return m;
	}
	@RequestMapping("/excel")
	public  ModelAndView shoExcel() {
		List<Item> list=service.getAllItems();
		ModelAndView m=new ModelAndView();
		m.setView(null);
		m.addObject("list",list);
		return m;
	}
}
