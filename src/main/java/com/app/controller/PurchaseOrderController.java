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

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.validator.PurchaseOrderValidator;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {

	@Autowired
	private IPurchaseOrderService service;
	
	@Autowired
	private IShipmentTypeService shipmentservice;
	
	@Autowired
	private IWhUserTypeService whservice;
	
	@Autowired
	private PurchaseOrderValidator validator;
	
	@RequestMapping("/reg")
	public String showPurchaseOrderReg(ModelMap map)
	{
		map.addAttribute("purchaseOrder",new PurchaseOrder());
		List<ShipmentType> shipmentType=shipmentservice.getAllShipments();
		map.addAttribute("shipmentType",shipmentType);
		
		List<WhUserType> whuser=whservice.getWhUserTypesByType("vendor");
		map.addAttribute("whuser",whuser);
		
		return "PurchaseOrderreg";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String savePurchaseOrderData(@ModelAttribute PurchaseOrder purchaseOrder,Errors errors,ModelMap map)
	{
		validator.validate(purchaseOrder, errors);
		if(!errors.hasErrors())
		{
		Integer pId=service.savePurchaseOrder(purchaseOrder);
		String msg="PurchaseOrder "+pId+" saved";
		map.addAttribute("message",msg);
		map.addAttribute("purchaseOrder",new PurchaseOrder());
		}
		else {
			List<ShipmentType> shipmentType=shipmentservice.getAllShipments();
			map.addAttribute("shipmentType",shipmentType);
			
			List<WhUserType> whuser=whservice.getWhUserTypesByType("vendor");
			map.addAttribute("whuser",whuser);
		}
		return "PurchaseOrderreg";
	}
	@RequestMapping("/all")
	public String getPurchaseOrderData(ModelMap map)
	{
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		map.addAttribute("list",list);
		return "PurchaseOederdata";
	}
	
	@RequestMapping("/delete")
	public String showPurchaseOrderDelete(@RequestParam("id")Integer pId,ModelMap map)
	{	
		service.deletePurchaseOrder(pId);
		String msg="PurchaseOrder "+pId+" deleted";
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		map.addAttribute("message",msg);
		map.addAttribute("list",list);
		return "PurchaseOrderdata";
	}
	@RequestMapping("/edit")
	public String showPurchaseOrderEdit(@RequestParam("id")Integer pId,ModelMap map)
	{
		PurchaseOrder purchaseOrder=service.getOnePurchaseOrderById(pId);
		map.addAttribute("purchaseOrder",purchaseOrder);
		return "PurchaseOrderedit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String shoPurchaseOrderUpdate(@ModelAttribute PurchaseOrder purchaseOrder,ModelMap map)
	{
		service.updatePurchaseOrder(purchaseOrder);
		String msg="PurchaseOrder"+purchaseOrder.getPurchaseId()+" updated";
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		map.addAttribute("message",msg);
		map.addAttribute("list",list);
		return "PurchaseOrderdata";
	}
}
