package com.app.dao;

import java.util.List;

import com.app.model.WhUserType;

public interface IWhUserTypeDao {
 public Integer saveWhUser(WhUserType whr);
 public void updateWhUser(WhUserType whr);
 public void deleteWhUser(Integer id);
 public WhUserType getOneWhUser(Integer id);
 public List<WhUserType> getAllWhUsers();
 public List<WhUserType> getWhUserTypesByType(String type);
}
