package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IOrderMethodDao;
import com.app.model.OrderMethod;

@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao{
	@Autowired
	private HibernateTemplate ht;

	
	public Integer saveOrderMethod(OrderMethod ord) {
		
		return (Integer) ht.save(ord);
	}

	
	public void updateOrderMethod(OrderMethod ord) {
		ht.update(ord);
		
	}


	public void deleteOrderMethod(Integer oId) {
		OrderMethod or=new OrderMethod();
		or.setId(oId);
		ht.delete(or);
	}

	
	public OrderMethod getOneMethod(Integer oId) {
		
		return ht.get(OrderMethod.class, oId);
	}
	
	public List<OrderMethod> getAllMethods() {
		
		return ht.loadAll(OrderMethod.class);
	}


	
	@SuppressWarnings("unchecked")
	public List<OrderMethod> getOrderMethodByMode(String mode) {
		
		/*String hql=" from "+OrderMethod.class.getName()+" where mode=?";
		List<OrderMethod> oms=(List<OrderMethod>)ht.find(hql, mode);*/
		List<OrderMethod> oms=(List<OrderMethod>) ht.findByCriteria(DetachedCriteria.forClass(OrderMethod.class)
				.add(Restrictions.eq("mode",mode)));
		return oms;
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean isOrderMethodAlreadyExist(String code) {

	 List<Long> listCount=(List<Long>) ht.findByCriteria(DetachedCriteria.forClass(OrderMethod.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.eq("code",code))
				);
		return listCount.get(0)!=0?true:false;
	}
	
}
