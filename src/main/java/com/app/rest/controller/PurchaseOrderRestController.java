package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;

@RestController
@RequestMapping("/rest/purchase")
public class PurchaseOrderRestController {

	@Autowired
	private IPurchaseOrderService service;
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<PurchaseOrder> pur=service.getAllPurchaseOrders();
		if(pur==null||pur.isEmpty())
		{
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
		{
			message=new ResponseEntity<List<PurchaseOrder>>(pur,HttpStatus.OK);
		}
		return message;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOnePurchaseOrder(@PathVariable Integer id){

		ResponseEntity<?> message=null;
		PurchaseOrder pur=service.getOnePurchaseOrderById(id);
		if(pur==null) {
			message=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else
		{
			message=new ResponseEntity<PurchaseOrder>(pur,HttpStatus.OK);
		}

		return message;
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> delestePurchase(@PathVariable Integer id)
	{
		ResponseEntity<String> message=null;
		try
		{
			service.deletePurchaseOrder(id);
			message=new ResponseEntity<String>("purchaseOrder "+id+"  deleted",HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			message=new ResponseEntity<String>("purchaseorder "+id+" not found",HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	@PostMapping("/insert")
	public ResponseEntity<String> saveData(@RequestBody PurchaseOrder pur)
	{
		ResponseEntity<String> message=null;
		try
		{
			Integer pid=service.savePurchaseOrder(pur);		
			message=new ResponseEntity<String>("purchase order "+pid+" saved",HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody PurchaseOrder pur)
	{
		ResponseEntity<String> message=null;
		try
		{
			service.updatePurchaseOrder(pur);
			message=new ResponseEntity<String>("purcaheseOrder "+pur.getPurchaseId()+" updated",HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return message;
	}
}
