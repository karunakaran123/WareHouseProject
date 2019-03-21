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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.validator.OrderMethodValidator;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;
@Controller
@RequestMapping("/order")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private OrderMethodValidator validator;
	
	@RequestMapping("/reg")
	public String showOrderReg(ModelMap map) {
		map.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodReg";
	}
	@RequestMapping("/home")
	public String showOrderMethodHome() {
		
		return "OrderHome";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertOrd(@ModelAttribute OrderMethod orderMethod,Errors errors,ModelMap map) {
		
		validator.validate(orderMethod, errors);
		if(!errors.hasErrors())
		{
		Integer orId=service.saveOrderMethod(orderMethod);
		String msg="Order "+orId+" saved ";
		map.addAttribute("message", msg);
		map.addAttribute("orderMethod",new OrderMethod());
		}
		return "OrderMethodReg";
	}
	@RequestMapping("/all")
	public String orderMethodData(ModelMap map) {
		List<OrderMethod> list=service.getAllMethods();
		map.addAttribute("list",list);
		return "OrderMethodData";
	}
	@RequestMapping("/delete")
	public String deleteOrderr(@RequestParam("id")Integer oId,ModelMap map) {
		service.deleteOrderMethod(oId);
		List<OrderMethod> list=service.getAllMethods();
		String msg=" Order "+oId+"deleted successfully";
		map.addAttribute("list", list);
		map.addAttribute("mesaage",msg);
		return "OrderMethodData";
	}
	@RequestMapping("/edit")
	 public String showedit(@RequestParam("id")Integer oId,ModelMap map) {
		OrderMethod om=service.getOneMethod(oId);
		map.addAttribute("orderMethod",om);
		return "OrderMethodEdit";
	 }
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String showUpdate(@ModelAttribute OrderMethod om,ModelMap map) {
		service.updateOrderMethod(om);
		String msg=" OrderMethod "+om.getId()+" updated";		
		List<OrderMethod> list=service.getAllMethods();
		map.addAttribute("message", msg);
		map.addAttribute("list",list);
		return "OrderMethodData";
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		List<OrderMethod> or=service.getAllMethods();
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodPdfView());
		m.addObject("ord",or);
		return m;
	}
	@RequestMapping("/excel")
	public ModelAndView showExcelView() {
		List<OrderMethod> ord=service.getAllMethods();
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodExcelView());
		m.addObject("ord",ord);
		return m;
	}
}
