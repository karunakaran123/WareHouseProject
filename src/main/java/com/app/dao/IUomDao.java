package com.app.dao;

import java.util.List;

import com.app.model.Uom;

public interface IUomDao {
	public Integer saveUom(Uom uom);
	public void updateUom(Uom uom);
	public void deleteUom(Integer uId);
	public Uom getOneUom(Integer uId);
	public List<Uom> getAllUoms();
	public boolean isUomAlreadyExist(String model);
	public boolean isUomConnectedToItem(Integer id);
}
