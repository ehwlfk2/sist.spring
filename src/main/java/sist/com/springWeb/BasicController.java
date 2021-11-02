package sist.com.springWeb;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicController {

	@Resource(name = "loginAction")
	LoginAction action;

	@RequestMapping(value = "loginAction.do")
	public ModelAndView loginProcess(String id, String password) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("UserInputID&Password : " + id + ", " + password);
		modelAndView.addObject("id", id);
		
		if (action.loginCheckAction(id, password)) {
			modelAndView.setViewName("boardMVC/loginSuccess");
		}else {
			modelAndView.setViewName("redirect:/boardMVC/signin.jsp?cmd=fail");
		}
		return modelAndView;
	}

	@RequestMapping(value = "buttonList.do")
	public ModelAndView basicListPark() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message", "Hello Spring MVC List");
		modelAndView.setViewName("WEB-INF/views/parkList");
		// servlet-context 에 해당 Name을 추가해준다.
		return modelAndView;
	}

	@RequestMapping(value = "buttonSet.do")
	public ModelAndView basicSetPark() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message", "Hello Spring MVC Set");
		modelAndView.setViewName("WEB-INF/views/parkSet");
		// servlet-context 에 해당 Name을 추가해준다.
		return modelAndView;
	}

	@RequestMapping(value = "buttonMap.do")
	public ModelAndView basicMapPark() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message", "Hello Spring MVC Map");
		modelAndView.setViewName("WEB-INF/views/parkMap");
		// servlet-context 에 해당 Name을 추가해준다.
		return modelAndView;
	}

	@RequestMapping(value = "actionView.do")
	public ModelAndView actionView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Message", "Hello Spring MVC \"Easter Egg\"");
		modelAndView.setViewName("mvcSpringDemo/actionView");
		// servlet-context 에 해당 Name을 추가해준다.
		return modelAndView;
	}
}
