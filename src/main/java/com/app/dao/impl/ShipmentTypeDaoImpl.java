package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IShipmentTypeDao;
import com.app.model.ShipmentType;
@Repository
public class ShipmentTypeDaoImpl implements IShipmentTypeDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveShipment(ShipmentType st) {
		
		return (Integer) ht.save(st);
	}

	@Override
	public void updateShipment(ShipmentType st) {
		ht.update(st);
	}

	@Override
	public void deleteShipment(Integer sId) {
	       ShipmentType sty=new ShipmentType();
	       sty.setId(sId);
	       ht.delete(sty);
	}

	@Override
	public ShipmentType getOneShipment(Integer sId) {
		
		return ht.get(ShipmentType.class, sId);
	}

	@Override
	public List<ShipmentType> getAllShipments() {
		
		return ht.loadAll(ShipmentType.class);
	}

}
