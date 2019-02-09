package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
	 private HibernateTemplate ht;
	
	public Integer saveCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return (Integer) ht.save(cust);
	}
	public void updateCustomer(Customer cust) {
		
		ht.update(cust);
		
	}
	public void deleteCustomer(Integer cId) {
		
		Customer c=new Customer();
		c.setCustId(cId);
		ht.delete(c);
		
	}
	public Customer getOneCustomer(Integer cId) {
		// TODO Auto-generated method stub
		return ht.get(Customer.class,cId);
	}
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return ht.loadAll(Customer.class);
	}

}
