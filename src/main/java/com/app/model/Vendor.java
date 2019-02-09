package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendortable")
public class Vendor {
	@Id
	@GeneratedValue
	private Integer venId;
	private String venName;
	private String venCode;
	private String venDesg;
	private String venPreserve;
	public Vendor() {
		super();
	}
	public Integer getVenId() {
		return venId;
	}
	public void setVenId(Integer venId) {
		this.venId = venId;
	}
	public String getVenName() {
		return venName;
	}
	public void setVenName(String venName) {
		this.venName = venName;
	}
	public String getVenCode() {
		return venCode;
	}
	public void setVenCode(String venCode) {
		this.venCode = venCode;
	}
	public String getVenDesg() {
		return venDesg;
	}
	public void setVenDesg(String venDesg) {
		this.venDesg = venDesg;
	}
	public String getVenPreserve() {
		return venPreserve;
	}
	public void setVenPreserve(String venPreserve) {
		this.venPreserve = venPreserve;
	}
	@Override
	public String toString() {
		return "Vendor [venId=" + venId + ", venName=" + venName + ", venCode=" + venCode + ", venDesg=" + venDesg
				+ ", venPreserve=" + venPreserve + "]";
	}
	
}
