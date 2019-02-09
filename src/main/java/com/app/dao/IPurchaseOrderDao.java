package com.app.dao;

import java.util.List;

import com.app.model.PurchaseOrder;

public interface IPurchaseOrderDao {

	public Integer savePurchaseOrder(PurchaseOrder por);
	public void updatePurchaseOrder(PurchaseOrder por);
	public void deletePurchaseOrder(Integer purId);
	public PurchaseOrder getOnePurchaseOrderById(Integer purId);
	public List<PurchaseOrder> getAllPurchaseOrders();
}
