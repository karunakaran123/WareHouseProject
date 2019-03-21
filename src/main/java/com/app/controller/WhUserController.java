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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.validator.WhUserValidator;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserController {
	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private WhUserValidator validator;
	@RequestMapping("/reg")
	public String showreg(ModelMap map) {
		map.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeReg";
	}
	@RequestMapping("/home")
	public String showWhHome() {
		return "WhUserHome";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveWhUser(@ModelAttribute WhUserType whUserType,Errors errors,ModelMap map) {
		validator.validate(whUserType, errors);
		if(!errors.hasErrors())
		{
		Integer wId=service.saveWhUser(whUserType);
		String msg=" whUser "+wId+" saved";
		map.addAttribute("message",msg);
		map.addAttribute("whUserType",new WhUserType());
		}
		return  "WhUserTypeReg";
	}
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		List<WhUserType> list=service.getAllWhUsers();
		map.addAttribute("list",list);
		return "WhUserTypeData";
	}
	@RequestMapping("/delete")
	public String deleteWhUser(@RequestParam("id")Integer wId,ModelMap map) {
		service.deleteWhUser(wId);
		String msg=" User "+wId+" Deleted";
		List<WhUserType> wr=service.getAllWhUsers();
		map.addAttribute("message",msg);
		map.addAttribute("list", wr);
		return "WhUserTypeData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer id,ModelMap map) {
		WhUserType wh=service.getOneWhUser(id);
		map.addAttribute("whUserType",wh);
		return "WhUserTypeEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	 public String showUpdate(@ModelAttribute WhUserType whUserType,ModelMap map) {
		 service.updateWhUser(whUserType);
		 String msg=" whUser "+whUserType.getId()+" updated ";
		 List<WhUserType> list=service.getAllWhUsers();
		 map.addAttribute("message",msg);
		 map.addAttribute("list",list);
		 return "WhUserTypeData";
	 }
	@RequestMapping("/excel")
	public ModelAndView showExcelView() {
		List<WhUserType> wh=service.getAllWhUsers();
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypeExcelView());
		m.addObject("whr",wh);
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdfView() {
		List<WhUserType> wh=service.getAllWhUsers();
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypePdfView());
		m.addObject("whr",wh);
		return m;
	}
}
