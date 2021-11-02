package sist.com.controller.customController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ExternalConnectionController {
	private final String path = "/ajaxDemo/";
	private final String naver = "naver";
	
	/*
	1. String
	2. ModelAndView
	3. void
	4. RedirectView
	5. ResponseEntity<Object>
	*/
	
	// 1. return string
	@GetMapping(path + naver + "01")
	public String connector01() {
		System.out.println("String");
		return "redirect:http://www.naver.com";
	}
	
	// 2. ModelAndView 
	@GetMapping(path + naver + "02")
	public ModelAndView connector02() {
		System.out.println("ModelAndView");
		String projectUrl = "http://www.naver.com";
		//modelAndView.setViewName();
		ModelAndView modelAndView = new ModelAndView("redirect:" + projectUrl);
		System.out.println(modelAndView.getViewName());
		return modelAndView;
	}
	
	// 3. void
	@GetMapping(path + naver + "03")
	public void connector03(HttpServletResponse httpServletResponse) throws IOException {
		System.out.println("void");
		httpServletResponse.sendRedirect("https://naver.com");
	}
	
	@GetMapping(path + naver + "04")
	public RedirectView connector04() {
		System.out.println("RedirectView");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://www.naver.com");
		return redirectView;
	}
	
	@GetMapping(path + naver + "05")
	public ResponseEntity<Object> connector05() throws URISyntaxException {
		System.out.println("ResponseEntity");
		URI redirectUri = new URI("http://www.naver.com");
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(redirectUri);
		return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	}
}
