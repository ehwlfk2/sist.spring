package sist.com.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sist.com.vo.MemberCheckBean;

public class MemberInfoValidate implements Validator {

	/**
	 * @param clazz // 클래스 정보 연결이 목적인 method.
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		// 실제 메모리.
		return MemberCheckBean.class.isAssignableFrom(clazz);
	}

	/**
	 * @param target // 유효성 검사를 진행할 객체
	 * @param errors // 유효성 검사의 결과
	 */
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("method Validate(target, errors)");

		MemberCheckBean bean = (MemberCheckBean) target;

		// 에러 발생 조건.
		if (bean.getId() == null || bean.getId().length() == 0) {
			// field, errorCode(String), defaultMessage
			errors.rejectValue("id", "idC", "id는 비어있을 수 없습니다.");
		}
		if (bean.getName() == null || bean.getName().length() == 0) {
			errors.rejectValue("name", "nameC", "name는 비어있을 수 없습니다.");
		}
		if (bean.getAddr() == null || bean.getAddr().length() == 0) {
			errors.rejectValue("addr", "addrC", "addr는 비어있을 수 없습니다.");
		}
		if (bean.getPwd() == null || bean.getPwd().length() == 0) {
			errors.rejectValue("pwd", "pwdC", "pwd는 비어있을 수 없습니다.");
		}
	}

}
