package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPurchaseOrderDao;
import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements IPurchaseOrderService {
	
	@Autowired
	private IPurchaseOrderDao dao;
	@Transactional
	public Integer savePurchaseOrder(PurchaseOrder por) {
		
		return dao.savePurchaseOrder(por);
	}

	@Transactional
	public void updatePurchaseOrder(PurchaseOrder por) {
		// TODO Auto-generated method stub
		dao.updatePurchaseOrder(por);
	}

	@Transactional
	public void deletePurchaseOrder(Integer purId) {
		// TODO Auto-generated method stub
		dao.deletePurchaseOrder(purId);
	}

	@Transactional(readOnly=true)
	public PurchaseOrder getOnePurchaseOrderById(Integer purId) {
		// TODO Auto-generated method stub
		return dao.getOnePurchaseOrderById(purId);
	}

	@Transactional(readOnly=true)
	public List<PurchaseOrder> getAllPurchaseOrders() {
		// TODO Auto-generated method stub
		return dao.getAllPurchaseOrders();
	}

}
