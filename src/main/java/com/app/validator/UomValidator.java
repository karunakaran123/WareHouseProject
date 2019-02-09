package com.app.validator;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
import com.app.service.IUomService;
@Component
public class UomValidator implements Validator {

	@Autowired
	private IUomService service;
	
	private static final Logger log=Logger.getLogger(UomValidator.class);
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Uom uom=(Uom)target;
		
		if("".equals(uom.getType()))
		{
			errors.rejectValue("type",null,"please choose atleast one type");
		}
		
		
		if(!Pattern.compile("[A-Z]{4,10}").matcher(uom.getModel()).matches())
		{
			errors.rejectValue("model",null,"please enter  4 to 10 upper case letters only");
		}
		else if(service.isUomAlreadyExist(uom.getModel()))
		{
			errors.rejectValue("model",null,"Uom already exist please enter another one....");
			log.info(" this uom model already exist please try another");
		}
		
		
		if("".equals(uom.getDsc().trim()))
		{
			errors.rejectValue("dsc",null,"please write description!....");
		}
	}

}
