package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
@Repository
public class VendorDaoImpl implements IVendorDao {
	@Autowired
	private HibernateTemplate ht;
	public Integer saveVendor(Vendor ven) {
		
		return (Integer) ht.save(ven);
	}

	
	public void updateVendor(Vendor ven) {
		
		ht.update(ven);
	}

	
	public void deleteVendor(Integer venId) {
		Vendor v=new Vendor();
		v.setVenId(venId);
		ht.delete(v);
	}
	public Vendor getOneVendor(Integer venId) {
		
		return ht.get(Vendor.class,venId);
	}
	public List<Vendor> getAllVendors() {
			return ht.loadAll(Vendor.class);
	}

}
