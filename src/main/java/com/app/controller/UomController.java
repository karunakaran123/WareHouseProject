package com.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {
	
	private static final Logger log=Logger.getLogger(UomController.class);
	
	@Autowired
	private IUomService service;
	
	@Autowired
	private UomValidator validator;
	
	@RequestMapping("/reg")
	public String showUom(ModelMap map) {
		log.info("enter into registration page");
		map.addAttribute("uom",new Uom());
		log.info("uom emty form displayed");
		return "UomRegister";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertUom(@ModelAttribute Uom uom,Errors errors,ModelMap map) {
		log.info("entered into uomsave method ");
		validator.validate(uom, errors);
		log.info("validations are completed");
		
		if(!errors.hasErrors())
		{
			Integer uId=0;
			try
			{
		        uId=service.saveUom(uom);
		        String msg="Uom  "+uId+"  saved";
		        log.debug("uom created "+uId+"  successfully");
	            map.addAttribute("message",msg);
			}
			catch (Exception e) {
				log.error(e.getMessage());
			}
	      map.addAttribute("uom", new Uom());
		}
		return "UomRegister";
	}
	@RequestMapping("/all")
	public String getUomData(ModelMap map) {
		List<Uom> list=service.getAllUoms();
		map.addAttribute("list",list);
		return "UomData";
	}
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam Integer id,ModelMap map) {
		
		String message=null;
		try {
			if(service.isUomConnectedToItem(id))
			{
				message="uom "+id+" is connected in another table";
			}
			else
			{
			  service.deleteUom(id);
			  message=" uom "+id+" deleted succesfully!";
			}
		}catch (HibernateOptimisticLockingFailureException e) {
			message="UOM "+id+"  NOT FOUND";
		}
		
		List<Uom> uom=service.getAllUoms();
		
		map.addAttribute("message",message);
		map.addAttribute("list",uom);
		return "UomData";
	}
	@RequestMapping("/edit")
	public String updateUom(@RequestParam("id")Integer uId,ModelMap map) {
		Uom uom=service.getOneUom(uId);
		map.addAttribute("uom",uom);
		return "UomEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String afterUpdate(@ModelAttribute Uom uom,ModelMap map) {
		service.updateUom(uom);
		String msg=" Uom "+uom.getId()+" updated";
		List<Uom> list=service.getAllUoms();
		map.addAttribute("message",msg);
		map.addAttribute("list",list);
		return "UomData";
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdfView() {
		List<Uom> uom=service.getAllUoms();
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		m.addObject("uom",uom);
		return m;
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Uom> uom=service.getAllUoms();
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		m.addObject("uom",uom);
		return m;
	}

}
