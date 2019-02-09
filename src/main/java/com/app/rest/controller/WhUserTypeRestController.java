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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@RestController
@RequestMapping("/rest/whuser")
public class WhUserTypeRestController {

	@Autowired
	private IWhUserTypeService service;

	@GetMapping("/all")
	public ResponseEntity<?> getAllWhUsers()
	{
		ResponseEntity<?> message =null;
		List<WhUserType> whurs= service.getAllWhUsers();
		if(whurs==null||whurs.isEmpty())
		{
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
		{
			message=new ResponseEntity<List<WhUserType>>(whurs,HttpStatus.OK);
		}
		return message;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneShipment(@PathVariable Integer id)
	{
		ResponseEntity<?> message=null;
		WhUserType whusr=service.getOneWhUser(id);
		if(whusr==null)
		{
			message=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			message=new ResponseEntity<WhUserType>(whusr,HttpStatus.OK);
		}
		return message;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteShipment(@PathVariable Integer id)
	{
		ResponseEntity<String> message=null;
		try
		{
			service.deleteWhUser(id);
			message=new ResponseEntity<String>("Shipment "+id+"   deleted",HttpStatus.OK);
		}
		catch (Exception e) {
			message=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	@PostMapping("/insert")
	public ResponseEntity<String> saveWhuser(@RequestBody WhUserType whr)
	{
		ResponseEntity<String> message=null;
		try
		{
			Integer wid=service.saveWhUser(whr);
			message=new ResponseEntity<String>("whUser "+wid+" saved",HttpStatus.OK);
		}
		catch (Exception e) {
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateWhUser(@RequestBody WhUserType whr)
	{
		ResponseEntity<String> message=null;
		try
		{
			service.updateWhUser(whr);
			message=new ResponseEntity<String>(" whUser "+whr.getId()+" update",HttpStatus.OK);

		}
		catch (Exception e) {
			// TODO: handle exception
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return message;
	}
}
