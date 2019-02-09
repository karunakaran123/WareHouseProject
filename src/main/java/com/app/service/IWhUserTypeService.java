package com.app.service;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeService {
	
	 public Integer saveWhUser(WhUserType whr);
	 public void updateWhUser(WhUserType whr);
	 public void deleteWhUser(Integer wId);
	 public WhUserType getOneWhUser(Integer wId);
	 public List<WhUserType> getAllWhUsers();
	 public List<WhUserType> getWhUserTypesByType(String type);
}
