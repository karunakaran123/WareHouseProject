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

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {
	@Autowired
	private IUomService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getallUoms(){
       ResponseEntity<?> message=null;
       List<Uom> uoms=service.getAllUoms();
       if(uoms==null||uoms.isEmpty())
       {
    	   message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       else
       {
    	   message=new ResponseEntity<List<Uom>>(uoms,HttpStatus.OK);
       }
		return message;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneUom(@PathVariable Integer id)
	{
		ResponseEntity<?> message=null;
		Uom uom=service.getOneUom(id);
		if(uom==null)
		{
			message=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else
		{
			message=new ResponseEntity<Uom>(uom,HttpStatus.OK);
		}
		return message;
	}
	@PostMapping("/insert")
	public ResponseEntity<String> saveData(@RequestBody Uom uom)
	{
		ResponseEntity<String> message=null;
		try
		{
			Integer uId=service.saveUom(uom);
			message=new ResponseEntity<String>("uom "+uId+" saved",HttpStatus.OK);
		}
		catch(Exception e)
		{
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updataData(@RequestBody Uom uom)
	{
		ResponseEntity<String> message=null;
		try
		{
			service.updateUom(uom);
			message=new ResponseEntity<String>("uom "+uom.getId()+"updated",HttpStatus.OK);
		}
		catch (Exception e) {
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUom(@PathVariable Integer id){
		ResponseEntity<String> message=null;
		try {
			service.deleteUom(id);
			message=new ResponseEntity<String>("uom "+id+" deleted",HttpStatus.OK);
		}
		catch(Exception e)
		{
			message=new ResponseEntity<String>("uom "+id+" not found",HttpStatus.BAD_REQUEST);
		}
	
		return message;
	
	}
}
