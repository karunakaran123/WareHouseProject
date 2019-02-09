package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private ICustomerDao dao;
	@Transactional
	public Integer saveCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return dao.saveCustomer(cust);
	}

	@Transactional
	public void updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		dao.updateCustomer(cust);
	}

	@Transactional
	public void deleteCustomer(Integer cId) {
		// TODO Auto-generated method stub
		dao.deleteCustomer(cId);
	}

	@Transactional(readOnly=true)
	public Customer getOneCustomer(Integer cId) {
		// TODO Auto-generated method stub
		return dao.getOneCustomer(cId);
	}

	@Transactional(readOnly=true)
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return dao.getAllCustomers();
	}

}
