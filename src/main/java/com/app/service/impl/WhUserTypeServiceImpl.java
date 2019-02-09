package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
@Service
public class WhUserTypeServiceImpl implements IWhUserTypeService {
	
	@Autowired
	private IWhUserTypeDao dao;
	@Transactional
	public Integer saveWhUser(WhUserType whr) {
		// TODO Auto-generated method stub
		return (Integer)dao.saveWhUser(whr);
	}

	@Transactional
	public void updateWhUser(WhUserType whr) {
		// TODO Auto-generated method stub
         dao.updateWhUser(whr);
	}

	@Transactional
	public void deleteWhUser(Integer wId) {
		// TODO Auto-generated method stub
        dao.deleteWhUser(wId);
	}

	@Transactional(readOnly=true)
	public WhUserType getOneWhUser(Integer wId) {
		// TODO Auto-generated method stub
		return dao.getOneWhUser(wId);
	}

	@Transactional(readOnly=true)
	public List<WhUserType> getAllWhUsers() {
		// TODO Auto-generated method stub
		return dao.getAllWhUsers();
	}
	@Transactional(readOnly=true)
	public List<WhUserType> getWhUserTypesByType(String type) {
		
		return dao.getWhUserTypesByType(type);
	}
}
