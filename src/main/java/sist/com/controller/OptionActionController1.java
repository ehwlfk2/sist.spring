package sist.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sist.com.vo.InjectDemo;

@Controller
@RequestMapping(value = "mvcOption/")
public class OptionActionController1 {
	
	@Autowired
	private InjectDemo InjectDemo;
	
	@RequestMapping(value="clickAction.do")
	public String clickView(Model model) {
		System.out.println("clickAction");
		model.addAttribute("msg", "clickView");
		InjectDemo.sayHello();
		return "/mvcOption/mvcEx3Result";
	}
	
	@RequestMapping(value="mouseAction.do")
	public String mouseView(Model model) {
		System.out.println("mouseAction");
		model.addAttribute("msg", "mouseView");
		InjectDemo.sayHello();
		return "/mvcOption/mvcEx3Result";
	}
}
