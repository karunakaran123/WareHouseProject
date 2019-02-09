package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
@Service
public class ShipmentTypeServicImpl implements IShipmentTypeService {
	
	@Autowired
	private IShipmentTypeDao dao;
	@Transactional
	public Integer saveShipment(ShipmentType st) {
		// TODO Auto-generated method stub
		return (Integer)dao.saveShipment(st);
	}

	@Transactional
	public void updateShipment(ShipmentType st) {
		 
		dao.updateShipment(st);
	}

	@Transactional
	public void deleteShipment(Integer sId) {
		dao.deleteShipment(sId);

	}

	@Transactional(readOnly=true)
	public ShipmentType getOneShipment(Integer sId) {
		
		return dao.getOneShipment(sId);
	}

	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipments() {
		// TODO Auto-generated method stub
		return dao.getAllShipments();
	}

}
