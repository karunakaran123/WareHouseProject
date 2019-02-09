package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@RestController
@RequestMapping("/rest/order")
public class OrderMethodRestController {

	@Autowired
	private IOrderMethodService service;
	@GetMapping("/all")
	public ResponseEntity<?> getAllOrders()
	{
		ResponseEntity<?> message=null;
		List<OrderMethod> orms=service.getAllMethods();
		if(orms==null||orms.isEmpty())
		{
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
		{
			message=new ResponseEntity<List<OrderMethod>>(orms,HttpStatus.OK);
		}
		return message;
	}
	@PostMapping("/insert")
	public ResponseEntity<String> saveData(@RequestBody OrderMethod ord)
	{
		ResponseEntity<String> message=null;
		try
		{
			Integer oId=service.saveOrderMethod(ord);
			message=new ResponseEntity<String>("order '"+oId+"' saved",HttpStatus.OK);
		}
		catch (Exception e) {
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	@PostMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody OrderMethod ord)
	{
		ResponseEntity<String> message=null;
		try
		{
			service.updateOrderMethod(ord);
			message=new ResponseEntity<String>("order "+ord.getId()+" updated",HttpStatus.OK);
			
		}
		catch(Exception e)
		{
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneOrder(@PathVariable Integer id){
		ResponseEntity<?> message=null;
		OrderMethod ormd= service.getOneMethod(id);
		if(ormd==null)
		{
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
		{
			message=new ResponseEntity<OrderMethod>(ormd,HttpStatus.OK);
		}
		
		return message;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrderMethod(@PathVariable Integer id)
	{ 
		ResponseEntity<String> message=null;
		try {
			service.deleteOrderMethod(id);
			message=new ResponseEntity<String>("order "+id+" deleted",HttpStatus.OK);
		}
		catch(Exception e)
		{
			message=new ResponseEntity<String>("order "+id+" not found",HttpStatus.BAD_REQUEST);
		}
		
		return message;
	}
}
