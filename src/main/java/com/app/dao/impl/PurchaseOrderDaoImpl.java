package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
@Repository
public class PurchaseOrderDaoImpl implements IPurchaseOrderDao {

	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer savePurchaseOrder(PurchaseOrder por) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(por);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder por) {
		// TODO Auto-generated method stub
               ht.update(por);
	}

	@Override
	public void deletePurchaseOrder(Integer purId) {
		// TODO Auto-generated method stub
		PurchaseOrder p=new PurchaseOrder();
		p.setPurchaseId(purId);
		ht.delete(p);

	}

	@Override
	public PurchaseOrder getOnePurchaseOrderById(Integer purId) {
		// TODO Auto-generated method stub
		return ht.get(PurchaseOrder.class,purId);
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		// TODO Auto-generated method stub
		return ht.loadAll(PurchaseOrder.class);
	}

}
