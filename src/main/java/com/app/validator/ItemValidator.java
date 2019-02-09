package com.app.validator;

import java.util.regex.Pattern;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;
@Component
public class ItemValidator  implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Item itm=(Item)target;
		
		if(!Pattern.compile("[A-Z]{4,10}").matcher(itm.getItemCode()).matches())
		{
			errors.rejectValue("itemCode",null,"please enter  4 to 10 upper case letters only");
		}
		if( itm.getWidth()==null|| itm.getWidth() <= 0 || itm.getLength() <= 0 || itm.getHight() <= 0) {
			errors.rejectValue("width", null, "Enter Valid dimensions");
		}
		
		if(itm.getItemBaseCost()==null||itm.getItemBaseCost()<=0)
		{
			errors.rejectValue("itemBaseCost",null,"please enter basecost");
		}
		
		if("".equals(itm.getItemcurncy()))
		{
			errors.rejectValue("itemcurncy",null,"please choose basecourency");
		}
		if(itm.getUom()==null|| itm.getUom().getId()==null)
		{
			errors.rejectValue("uom",null,"please choose one uom");
		}
		if(itm.getSaleType()==null || itm.getSaleType().getId()==null) {
			errors.rejectValue("saleType",null,"please choose one  saletype");
		}
		if(itm.getPurchaseType()==null || itm.getPurchaseType().getId()==null) {
			errors.rejectValue("purchaseType",null,"please choose one  purchasetype");
		}
		
		if(itm.getVenuser()==null || itm.getVenuser().isEmpty())
		{
			errors.rejectValue("venuser",null,"please choose venuser");
		}
		if(itm.getCustuser()==null || itm.getCustuser().isEmpty())
		{
			errors.rejectValue("custuser",null,"please choose custuser");
		}
		
		if("".equals(itm.getItmdsc().trim()))
		{
			errors.rejectValue("itmdsc",null,"please write description");
		}
	}
	
}
