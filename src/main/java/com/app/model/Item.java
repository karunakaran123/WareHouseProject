package com.app.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="itemtab")
public class Item {
	@Id
	@GeneratedValue(generator="itm_gen")
	@GenericGenerator(name="itm_gen",strategy="increment")
	private Integer itemId;
	private String itemCode;
	private Double width;
	private Double length;
	private Double hight;
	private Double itemBaseCost;
	private String itemcurncy;
	private String itmdsc;
	@ManyToOne
	@JoinColumn(name="uidfk")
	private Uom uom;
	
	@ManyToOne
	@JoinColumn(name="omSaleId")
	private OrderMethod saleType;
	
	@ManyToOne
	@JoinColumn(name="omPurchseId")
	private OrderMethod purchaseType;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="item_venuser_table", joinColumns=@JoinColumn(name="itemIdFk"),inverseJoinColumns=@JoinColumn(name="venIdFk"))
	@Fetch(value=FetchMode.SUBSELECT)
	private List<WhUserType> venuser =new ArrayList<WhUserType>(0);
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Fetch(value=FetchMode.SUBSELECT)
	@JoinTable(name="item_custuser_table", joinColumns=@JoinColumn(name="itemIdFk"),inverseJoinColumns=@JoinColumn(name="custIdFk"))
	private List<WhUserType> custuser =new ArrayList<WhUserType>(0);
	
	
	public Item() {
		super();
	}


	public Item(Integer itemId) {
		super();
		this.itemId = itemId;
	}

	public Integer getItemId() {
		return itemId;
	}


	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public Double getWidth() {
		return width;
	}


	public void setWidth(Double width) {
		this.width = width;
	}


	public Double getLength() {
		return length;
	}


	public void setLength(Double length) {
		this.length = length;
	}


	public Double getHight() {
		return hight;
	}


	public void setHight(Double hight) {
		this.hight = hight;
	}


	public Double getItemBaseCost() {
		return itemBaseCost;
	}


	public void setItemBaseCost(Double itemBaseCost) {
		this.itemBaseCost = itemBaseCost;
	}


	public String getItemcurncy() {
		return itemcurncy;
	}


	public void setItemcurncy(String itemcurncy) {
		this.itemcurncy = itemcurncy;
	}


	public String getItmdsc() {
		return itmdsc;
	}


	public void setItmdsc(String itmdsc) {
		this.itmdsc = itmdsc;
	}


	public Uom getUom() {
		return uom;
	}


	public void setUom(Uom uom) {
		this.uom = uom;
	}


	public OrderMethod getSaleType() {
		return saleType;
	}


	public void setSaleType(OrderMethod saleType) {
		this.saleType = saleType;
	}


	public OrderMethod getPurchaseType() {
		return purchaseType;
	}


	public void setPurchaseType(OrderMethod purchaseType) {
		this.purchaseType = purchaseType;
	}


	public List<WhUserType> getVenuser() {
		return venuser;
	}


	public void setVenuser(List<WhUserType> venuser) {
		this.venuser = venuser;
	}


	public List<WhUserType> getCustuser() {
		return custuser;
	}


	public void setCustuser(List<WhUserType> custuser) {
		this.custuser = custuser;
	}


	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemCode=" + itemCode + ", width=" + width + ", length=" + length
				+ ", hight=" + hight + ", itemBaseCost=" + itemBaseCost + ", itemcurncy=" + itemcurncy + ", itmdsc="
				+ itmdsc + ", uom=" + uom + ", saleType=" + saleType + ", purchaseType=" + purchaseType + ", venuser="
				+ venuser + ", custuser=" + custuser + "]";
	}


	

	
}
