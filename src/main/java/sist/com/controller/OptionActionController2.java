package sist.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OptionActionController2 {

	@RequestMapping(value="clickAction.do")
	public String actionView() {
		System.out.println("clickAction");
		return "mvcOption/locationView";
	}
}
