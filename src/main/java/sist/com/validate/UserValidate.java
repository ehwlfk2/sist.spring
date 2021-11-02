package sist.com.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sist.com.vo.UserBean;

@Component
public class UserValidate implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserBean userBean = (UserBean) target;
		// ① error, field, errorCode
		ValidationUtils.rejectIfEmpty(errors, "name", "user.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "user.email.empty");
		ValidationUtils.rejectIfEmpty(errors, "gender", "user.gender.empty");
		ValidationUtils.rejectIfEmpty(errors, "item", "user.item.empty");
		System.out.println("------------------------------");

		if (userBean.getName().length() < 2 && userBean.getName().length() > 6) {
			// ② field, errorCode
			errors.rejectValue("name", "user.name.length");
		}
		if (!userBean.getEmail().contains("@")) {
			errors.rejectValue("email", "user.email.invalid");
		}

	}

}
