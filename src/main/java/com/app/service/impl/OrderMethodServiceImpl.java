package com.app.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
@Service
public class OrderMethodServiceImpl implements IOrderMethodService{
	@Autowired
	private IOrderMethodDao dao;
	@Transactional
	public Integer saveOrderMethod(OrderMethod ord) {
		
		return (Integer)dao.saveOrderMethod(ord);
	}

	@Transactional
	public void updateOrderMethod(OrderMethod ord) {
		dao.updateOrderMethod(ord);
		
	}

	@Transactional
	public void deleteOrderMethod(Integer oId) {
		dao.deleteOrderMethod(oId);
	}

	@Transactional(readOnly=true)
	public OrderMethod getOneMethod(Integer oId) {
		
		return dao.getOneMethod(oId);
	}

	@Transactional(readOnly=true)
	public List<OrderMethod> getAllMethods() {
		
		return dao.getAllMethods();
	}

	@Transactional(readOnly=true)
	public List<OrderMethod> getOrderMethodByMode(String mode) {
		return dao.getOrderMethodByMode(mode);
		
	}

	@Transactional(readOnly=true)
	public boolean isOrderMethodAlreadyExist(String code) {
		// TODO Auto-generated method stub
		return dao.isOrderMethodAlreadyExist(code);
	}

}
