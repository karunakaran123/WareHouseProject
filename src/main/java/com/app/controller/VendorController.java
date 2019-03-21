package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Vendor;
import com.app.service.IVendorService;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private IVendorService service;
	
	@RequestMapping("/reg")
	public String showreg(ModelMap map) {
		map.addAttribute("vendor",new Vendor());
		return "VendorReg";
	}
	@RequestMapping("/home")
	public String showVenHome() {
		return "VenHome";
	}
	@RequestMapping("/insert")
	public String insertData(@ModelAttribute Vendor vendor,ModelMap map) {
		Integer vId=service.saveVendor(vendor);
		String msg="Vendor "+vId+" saved";
		map.addAttribute("message",msg);
		map.addAttribute("vendor",new Vendor());
		return "VendorReg";
	}
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		List<Vendor> list=service.getAllVendors();
		map.addAttribute("list",list);
		return "VenData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer vId,ModelMap map) {
		Vendor ven=service.getOneVendor(vId);
		map.addAttribute("ven",ven);
		return "VendorReg";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String showUpdate(@ModelAttribute Vendor vendor,ModelMap map) {
		service.updateVendor(vendor);
		String msg=" Vendor "+vendor.getVenId()+" updated";
		List<Vendor> list=service.getAllVendors();
		map.addAttribute("message",msg);
		map.addAttribute("list", list);
		return "VendorData";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcelView() {
		List<Vendor> ven=service.getAllVendors();
		ModelAndView m=new ModelAndView();
		m.setView(null);
		m.addObject("ven",ven);
	    return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showPsf() {
		List<Vendor> ven=service.getAllVendors();
		ModelAndView m=new ModelAndView();
		m.setView(null);
		m.addObject("ven",ven);
		return m;
	}
}
