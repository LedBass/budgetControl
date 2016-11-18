package br.com.ledbass.budgetControl.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.ledbass.budgetControl.model.User;

/**
 * This class is used to validate users login
 * @author marcio.silva
 *
 */
@Component
public class UserValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", 
				"error.username", "O campo login não pode estar vazio");
		
		ValidationUtils.rejectIfEmpty(errors, "password",
				"error.password", "A senha deve ser informada");
	}
}
