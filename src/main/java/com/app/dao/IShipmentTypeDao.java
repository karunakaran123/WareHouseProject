package com.app.dao;

import java.util.List;

import com.app.model.ShipmentType;

public interface IShipmentTypeDao {
	public Integer saveShipment(ShipmentType st);
	public void updateShipment(ShipmentType st);
	public void deleteShipment(Integer sId);
	public ShipmentType getOneShipment(Integer sId);
	public List<ShipmentType> getAllShipments();
}
