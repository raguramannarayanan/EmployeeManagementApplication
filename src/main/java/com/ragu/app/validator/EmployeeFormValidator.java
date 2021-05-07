package com.ragu.app.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ragu.app.dto.EmployeeDTO;
@Service("employeeValidator")
public class EmployeeFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EmployeeDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "doorNumber", "doorNumber.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "state.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "street.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "country.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "zipCode.required");
	}

	

}
