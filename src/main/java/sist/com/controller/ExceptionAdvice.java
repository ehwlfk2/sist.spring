package sist.com.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // This is  @ExceptionHandler, @InitBinder, or @ModelAttribute methods Only!!
public class ExceptionAdvice { // 실행 우선 순위는 Controller -> ControllerAdvice 순서.
	private final String path = "/mvcOption/";
	
	
	@ExceptionHandler(ArithmeticException.class)
	public String exceptionHandler(ArithmeticException e, Model model) {
		model.addAttribute("msg", "ErrorCheck");
		model.addAttribute("exception", e);
		return path + "exceptionAdvice";
	}
	
}
