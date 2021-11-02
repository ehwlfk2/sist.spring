package sist.com.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "cookieSession")
public class OptionMvcCoreController {
	private final String root = "/cookieSession/";

	@RequestMapping(value = "cookieTest.do")
	public String cookieDemo1(@RequestParam(value = "color", required = false, defaultValue = "white") String color,
			Model model, HttpServletResponse response) {

		model.addAttribute("colorModel", color);

		Cookie cookie = null;
		cookie = new Cookie("colorSession", color);
		cookie.setMaxAge(30);

		response.addCookie(cookie);

		return "cookieSession/cookie01Result";
	}

	@RequestMapping(value = "cookieCheck.do")
	public String cookieDemo2(
			@CookieValue(value = "colorSession", required = false, defaultValue = "white") String color, Model model) {
		model.addAttribute("colorModel", color);
		return "cookieSession/cookieColor";
	}

	@RequestMapping(value = "view/adminLoginCheck.do")
	public String cookieDemo3(@CookieValue(value = "id", required = false, defaultValue = "") String id,
			Model model) {
		
		//print
		System.out.println(id);
		
		model.addAttribute("id", id);
		
		
		return root + "view/adminLogin";
	}

	@RequestMapping(value = "adminLogin.do") // 'ck' is id remember checkBox.
	public String cookieDemo4(@RequestParam(value = "id") String id, String ck, Model model,
			HttpServletResponse response) {
		
		// print
		System.out.println("id : " + id + "\nck : " + ck);
		
		
		// ck
		if (ck!=null && ck.equals("on")) {
			System.out.println("> id : " + id + " 를 session에 저장.");

			Cookie cookie = null;
			cookie = new Cookie("id", id);
			cookie.setMaxAge(60);
			
			response.addCookie(cookie);
		}
		return "redirect: main.jsp";
	}
}
