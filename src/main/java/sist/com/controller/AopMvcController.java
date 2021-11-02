package sist.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import sist.com.dao.ParentDao;

@Controller
public class AopMvcController {
	private final String path = "/mvcAOP/";
	
	@Autowired(required = true)
	private ParentDao dao;
	
	@GetMapping(value = path + "aopActionDemo1.do")
	public String actionAopEx1() {
		dao.fileAccessData();
		return "redirect:mvcEx1Result1.jsp";
	}
	@GetMapping(value = path + "aopActionDemo2.do")
	public String actionAopEx2() {
		dao.xmlProcessData();
		return "redirect:mvcEx1Result2.jsp";
	}
}
