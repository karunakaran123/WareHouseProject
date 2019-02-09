package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Component
public class OrderMethodValidator implements Validator {
	
	@Autowired
	private IOrderMethodService service;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		OrderMethod om=(OrderMethod)target;
		if(om.getMode()==null || "".equals(om.getMode()))
		{
			errors.rejectValue("mode",null,"please choose order mode");
		}
		if("".equals(om.getCode().trim()))
		{
			errors.rejectValue("code",null,"please enter order code");
		}
		else if(service.isOrderMethodAlreadyExist(om.getCode())) {
			errors.rejectValue("code",null,"Order method alredy exist!....");
		}
		if(om.getAccept()==null || om.getAccept().isEmpty())
		{
			errors.rejectValue("accept",null,"please chosee accept type");
		}
		if("".equals(om.getMethod()))
		{
			errors.rejectValue("method",null,"please choose order method");
		}
		if("".equals(om.getDsc().trim()))
		{
			errors.rejectValue("dsc",null,"please write description of order method");
		}
		
	}

}
