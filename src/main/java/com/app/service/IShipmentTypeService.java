package com.app.service;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeService {
	public Integer saveShipment(ShipmentType st);
	public void updateShipment(ShipmentType st);
	public void deleteShipment(Integer sId);
	public ShipmentType getOneShipment(Integer sId);
	public List<ShipmentType> getAllShipments();

}
