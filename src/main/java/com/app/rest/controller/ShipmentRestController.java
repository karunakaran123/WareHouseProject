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

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("rest/shipment")
public class ShipmentRestController {
	
	@Autowired
	private IShipmentTypeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllData()
	{
		ResponseEntity<?> message=null;
		List<ShipmentType> sht=service.getAllShipments();
		if(sht==null || sht.isEmpty())
		{
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
		{
			message=new ResponseEntity<List<ShipmentType>>(sht,HttpStatus.OK);
		}
		return message;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneShipment(@PathVariable Integer id){
		ResponseEntity<?> message =null;
		ShipmentType sht= service.getOneShipment(id);
		if(sht==null)
		{
			message=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else
		{
			message=new  ResponseEntity<ShipmentType>(sht,HttpStatus.OK);
		}
		return message;
	}
	@DeleteMapping("/gelete/{id}")
	public ResponseEntity<String> deleteData(@PathVariable Integer id)
	{
		ResponseEntity<String> message=null;
		try
		{
			service.deleteShipment(id);
			message=new ResponseEntity<String>(" shipment "+id+" deleted",HttpStatus.OK);
		}
		catch(Exception e)
		{
			message=new ResponseEntity<String>(" shipment "+id+" not found",HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<String> saveData(@RequestBody ShipmentType sht)
	{
		ResponseEntity<String> message=null;
		try
		{
			Integer sid=service.saveShipment(sht);
			message=new ResponseEntity<String>("shipment"+sid+"   saved ",HttpStatus.OK);
		}
		catch (Exception e) {
		message=new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody ShipmentType sht)
	{
		ResponseEntity<String> message=null;
		
		try {
			service.saveShipment(sht);
			message=new ResponseEntity<String>("shipment "+sht.getId()+" updated",HttpStatus.OK);
		}
		catch (Exception e) {
			message=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
}
