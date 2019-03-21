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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.validator.ShipmentTypeValidator;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeContoller {
	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ShipmentTypeValidator validator;
	
	@RequestMapping("/reg")
	public String showreg(ModelMap map) {
		map.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeReg";
	}
	@RequestMapping("/home")
	public String showShipmentHome() {
		return "ShipmentHome";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveReg(@ModelAttribute ShipmentType shipmentType,Errors errors,ModelMap map) {
		
		validator.validate(shipmentType, errors);
		if(!errors.hasErrors())
		{
		Integer sId=service.saveShipment(shipmentType);
		String msg=" shipment "+sId+" saved ";
		map.addAttribute("message",msg);
		map.addAttribute("shipmentType",new ShipmentType());
		}
		return "ShipmentTypeReg";
	}
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<ShipmentType> smts=service.getAllShipments();
		map.addAttribute("list",smts);
		return "ShipmentTypeData";
	}
	@RequestMapping("/delete")
	public String shipmentDelete(@RequestParam("id")Integer sId,ModelMap map) {
		service.deleteShipment(sId);
		String msg=" shipmentType "+sId+" Deleted";
		List<ShipmentType> list=service.getAllShipments();
		map.addAttribute("message",msg);
		map.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	@RequestMapping("/edit")
	public String shoedit(@RequestParam("id")Integer sId,ModelMap map) {
		ShipmentType stmt=service.getOneShipment(sId);
		map.addAttribute("shipmentType",stmt);
		return "ShipmentTypeEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String showUpdate(@ModelAttribute ShipmentType shipmentType,ModelMap map) {
		service.updateShipment(shipmentType);
		String msg=" shipment "+shipmentType.getId()+"  Updated";
		List<ShipmentType> st=service.getAllShipments();
		map.addAttribute("message",msg);
		map.addAttribute("list",st);
		return "ShipmentTypeData";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcelView() {
		List<ShipmentType> list=service.getAllShipments();
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		m.addObject("sht",list);
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdfView() {
		List<ShipmentType> list=service.getAllShipments();
		ModelAndView m=new ModelAndView();		
		m.setView(new ShipmentTypePdfView());
		m.addObject("shtp",list);
		return m;
	}
}
