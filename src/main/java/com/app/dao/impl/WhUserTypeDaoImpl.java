package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {
    @Autowired
	private HibernateTemplate ht;
	@Override
	public Integer saveWhUser(WhUserType whr) {
		// TODO Auto-generated method stub
		return (Integer)ht.save(whr);
	}

	@Override
	public void updateWhUser(WhUserType whr) {
		// TODO Auto-generated method stub
         ht.update(whr);
	}

	@Override
	public void deleteWhUser(Integer id) {
		// TODO Auto-generated method stub
	    WhUserType wh=new WhUserType();
	    wh.setId(id);
	    ht.delete(wh);
	}

	@Override
	public WhUserType getOneWhUser(Integer id) {
		// TODO Auto-generated method stub
		return ht.get(WhUserType.class, id);
	}

	@Override
	public List<WhUserType> getAllWhUsers() {
		// TODO Auto-generated method stub
		return ht.loadAll(WhUserType.class);
	}
	@SuppressWarnings("deprecation")
	@Override
	public List<WhUserType> getWhUserTypesByType(String type) {
		String hql=" from "+WhUserType.class.getName()+" where type=?";
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) ht.find(hql, type);
		return list;
	}
}
