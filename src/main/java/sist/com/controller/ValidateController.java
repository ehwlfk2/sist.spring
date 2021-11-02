package sist.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sist.com.validate.MemberInfoValidate;
import sist.com.validate.UserValidate;
import sist.com.vo.MemberCheckBean;
import sist.com.vo.UserBean;

@Controller
@RequestMapping(value = "validateEx")
public class ValidateController {

	@Autowired
	@Qualifier("userValidate")
	private UserValidate userValidate;

	/**
	 * @param binder Valiators를 맵핑시켜주는 필수 함수. 사용하기전에 미리 초기화시켜주는 InitBinder
	 *               Annotation을 사용했다.
	 */
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		// Autowired를 사용하였기때문에 Validate의 supports를 initBinder로 di한다.
		binder.addValidators(userValidate);
	}

	@RequestMapping(value = "")
	public String mainPage() {
		return "redirect:/validateEx/formPro.jsp";
	}

	/**
	 * @param bean
	 * @param result // validate의 errors를 위해 ...
	 * @return BindingResult = 유효성 검사의 결과가 담기는 변수.
	 */
	@RequestMapping(value = "formValidate.do", method = RequestMethod.POST)
	public String fromValidate(@ModelAttribute("test") MemberCheckBean bean, BindingResult result) {
		System.out.println("method fromValidate(bean, result)");
		System.out.println(bean);

		// 유효성 검사 실시. new를 통한 객체생성 = 해당 클래스에 Annotation 필요없음.
		new MemberInfoValidate().validate(bean, result);

		System.out.println(result);
		if (result.hasErrors()) {
			// message bundle -> utf-8로 바꿔 한글 깨짐을 방지하기 위해서.
			return "validateEx/formPro";
		}
		return "validateEx/formResult";
	}

	@RequestMapping(value = "start.do")
	public String userForm(Model model) {
		model.addAttribute("user", new UserBean());
		return "validateEx/userForm";
	}

	@PostMapping(value = "saveUser.do")
	public String saveProcess(@ModelAttribute("user") @Validated UserBean user, BindingResult result) {
		System.out.println("saveProcess");

		if (result.hasErrors()) {
			return "validateEx/userForm";
		}
		return "validateEx/userSuccess";
	}

}
