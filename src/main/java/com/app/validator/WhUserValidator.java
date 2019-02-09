package com.app.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;

@Component
public class WhUserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return WhUserType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WhUserType whr=(WhUserType)target;
		if(whr.getType()==null || "".equals(whr.getType()))
		 {
		    errors.rejectValue("type",null,"please choose user type");
		 }
		if("".equals(whr.getCode().trim()))
		{
			errors.rejectValue("code",null,"please enter user code");
		}
		if("".equals(whr.getForType()))
		{
			errors.rejectValue("forType",null,"please choose user type");
		}
		if("".equals(whr.getEmail().trim()))
		{
			errors.rejectValue("email",null,"please enter valid mail");
		}
		if("".equals(whr.getContact().trim()))
		{
			errors.rejectValue("contact",null,"please enter contact number");
		}
		if("".equals(whr.getIdType()))
		{
			errors.rejectValue("idType",null,"please choose one idType");
		}
		if("".equals(whr.getIdNum()))
		{
			errors.rejectValue("idNum",null,"please enter Id number");
		}
	}

}
