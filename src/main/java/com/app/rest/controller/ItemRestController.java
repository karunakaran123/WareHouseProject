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

import com.app.model.Item;
import com.app.service.IItemService;

@RestController
@RequestMapping("rest/item")
public class ItemRestController {

	@Autowired
	private IItemService service;
	@GetMapping("/all")
	public ResponseEntity<?> getAllData()
	{
		ResponseEntity<?> message=null;
		List<Item> itms=service.getAllItems();
		if(itms==null||itms.isEmpty())
		{
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
		{
			message=new ResponseEntity<List<Item>>(itms,HttpStatus.OK);
		}
		return message;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneItem(@PathVariable Integer id)
	{
		ResponseEntity<?> message=null;
		Item itm=service.getOneItem(id);
		if(itm==null)
		{
			message=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else
		{
			message=new ResponseEntity<Item>(itm,HttpStatus.OK);
		}
		return message;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOneItem(@PathVariable Integer id)
	{
		ResponseEntity<String> message=null;
		try
		{
			service.deleteItem(id);
			message=new ResponseEntity<String>("item "+id+" deleted",HttpStatus.OK);
		}
		catch(Exception e)
		{
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<String> saveData(@RequestBody Item item)
	{
		ResponseEntity<String> message=null;
		try {
			Integer id=service.saveItem(item);
			message=new ResponseEntity<String>("item "+id+" saved",HttpStatus.OK);
		}
		
		catch (Exception e) {
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR); 
			// TODO: handle exception
		}
		return message;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateItem(@RequestBody Item item)
	{
		ResponseEntity<String> message=null;
		try
		{
			service.updateItem(item);
			message=new ResponseEntity<String>("item "+item.getItemId()+" updated",HttpStatus.OK);
		}
		catch (Exception e) {
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
		
		return message;
	}
}
