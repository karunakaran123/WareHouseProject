package com.app.dao;

import java.util.List;

import com.app.model.OrderMethod;

public interface IOrderMethodDao {
	
	public Integer saveOrderMethod(OrderMethod ord);
	public void updateOrderMethod(OrderMethod ord);
	public void deleteOrderMethod(Integer oId);
	public OrderMethod getOneMethod(Integer oId);
	public List<OrderMethod> getAllMethods();
	public List<OrderMethod> getOrderMethodByMode(String mode);
	public boolean isOrderMethodAlreadyExist(String code);
}
