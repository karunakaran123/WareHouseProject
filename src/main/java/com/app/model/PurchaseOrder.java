package com.app.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="purchase_order")
public class PurchaseOrder {

		@Id
		@GeneratedValue(generator="pur_gen")
		@GenericGenerator(name="pur_gen",strategy="increment")
		private Integer purchaseId;
		private String orderCode;
		private Integer referenceNumber;
		private String qualityCheck;
		private String defaultStatus;
		private String description;
		@ManyToOne
		@JoinColumn(name="shipmentIdfk")
		private ShipmentType shipmentCode;
		
		@ManyToOne
		@JoinColumn(name="whuserIdfk")
		private WhUserType vendor;

		public PurchaseOrder() {
			super();
		}

		public PurchaseOrder(Integer purchaseId) {
			super();
			this.purchaseId = purchaseId;
		}

		public Integer getPurchaseId() {
			return purchaseId;
		}

		public void setPurchaseId(Integer purchaseId) {
			this.purchaseId = purchaseId;
		}

		public String getOrderCode() {
			return orderCode;
		}

		public void setOrderCode(String orderCode) {
			this.orderCode = orderCode;
		}

		public Integer getReferenceNumber() {
			return referenceNumber;
		}

		public void setReferenceNumber(Integer referenceNumber) {
			this.referenceNumber = referenceNumber;
		}

		public String getQualityCheck() {
			return qualityCheck;
		}

		public void setQualityCheck(String qualityCheck) {
			this.qualityCheck = qualityCheck;
		}

		public String getDefaultStatus() {
			return defaultStatus;
		}

		public void setDefaultStatus(String defaultStatus) {
			this.defaultStatus = defaultStatus;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public ShipmentType getShipmentCode() {
			return shipmentCode;
		}

		public void setShipmentCode(ShipmentType shipmentCode) {
			this.shipmentCode = shipmentCode;
		}

		public WhUserType getVendor() {
			return vendor;
		}

		public void setVendor(WhUserType vendor) {
			this.vendor = vendor;
		}

		@Override
		public String toString() {
			return "PurchaseOrder [purchaseId=" + purchaseId + ", orderCode=" + orderCode + ", referenceNumber="
					+ referenceNumber + ", qualityCheck=" + qualityCheck + ", defaultStatus=" + defaultStatus
					+ ", description=" + description + ", shipmentCode=" + shipmentCode + ", vendor=" + vendor + "]";
		}
		
}
