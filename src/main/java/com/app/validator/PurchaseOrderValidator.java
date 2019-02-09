package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.PurchaseOrder;
@Component
public class PurchaseOrderValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
	
		return PurchaseOrder.class.equals(clazz);
	}@Override
	public void validate(Object target, Errors errors) {
		
		PurchaseOrder pr=(PurchaseOrder)target;
		if(pr.getOrderCode()==null || pr.getOrderCode().isEmpty())
		{
			errors.rejectValue("orderCode",null,"please enter order code");
		}
		if(pr.getShipmentCode()==null || pr.getShipmentCode().getId()==null)
		{
			errors.rejectValue("shipmentCode",null,"please choose one shipment code");
		}
		if(pr.getVendor()==null || pr.getVendor().getId()==null)
		{
			errors.rejectValue("vendor",null,"please choose one vendor");
		}
		if(pr.getReferenceNumber()==null || pr.getReferenceNumber()==null)
		{
			errors.rejectValue("referenceNumber",null,"please enter reference Number");
		}
		if(pr.getQualityCheck()==null ||  "".equals(pr.getQualityCheck()))
		{
			errors.rejectValue("qualityCheck",null,"please choose one quality check");
		}
		if("".equals(pr.getDescription()) || pr.getDescription().isEmpty())
		{
			errors.rejectValue("description",null,"please write description");
		}
	}
}
