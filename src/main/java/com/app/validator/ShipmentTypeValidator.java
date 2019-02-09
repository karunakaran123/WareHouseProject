package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;

@Component
public class ShipmentTypeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ShipmentType st=(ShipmentType)target;
		if("".equals(st.getMode()))
		{
			errors.rejectValue("mode",null,"please choose shipment mode");
		}
		if("".equals(st.getCode()))
		{
			errors.rejectValue("code",null,"please enter shipment code");
		}
		if(st.getEnabled()==null||"".isEmpty())
		{
			errors.rejectValue("enabled",null,"please enable shipment ");
		}
		if(st.getGrade()==null||"".isEmpty())
		{
			errors.rejectValue("grade",null,"please select shipment grade");
		}
		if("".equals(st.getDsc()))
		{
			errors.rejectValue("dsc",null,"please write shipment description ");
		}
	}

}
