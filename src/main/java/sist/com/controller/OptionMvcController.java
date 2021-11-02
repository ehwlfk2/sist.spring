package sist.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sist.com.dao.StudentDao;
import sist.com.vo.ReplyVO;
import sist.com.vo.StudentVO;

@Controller
@SessionAttributes(value = { "sList", "strList" }) // 값을 받아온다.
public class OptionMvcController {
	private final String path = "/mvcOption/";

	@Inject
	private StudentDao dao;

	/********** SessionAttributes **********/
	@ModelAttribute(name = "sList")
	private List<StudentVO> selectSt() {
		return dao.selectAllStudent();
	}

	@ModelAttribute(name = "strList")
	private List<String> selectString() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("민제");
		list.add("태라");
		return list;
	}

	/********** mvcEx1 **********/
	@GetMapping(value = path + "JavaClick.do")
	public String javaProc(Model model) {
		model.addAttribute("msg", "JavaAction");
		return "redirect:" + path + "mvcEx1Result.jsp";
	}

	@GetMapping(value = path + "XmlClick.do")
	public String xmlProc(Model model) {
		model.addAttribute("msg", "xmlAction");
		return "redirect:" + path + "mvcEx1Result.jsp";
	}

	@GetMapping(value = path + "OracleClick.do")
	public String oracleProc(Model model) {
		model.addAttribute("msg", "oracleAction");
		return "redirect:" + path + "mvcEx1Result.jsp";
	}

	@RequestMapping(value = path + "modelArgDemo.do")
	public String modelProc(Model model, @ModelAttribute(name = "sv") ReplyVO vo) {
		System.out.println("no");
		model.addAttribute("msg", "modelAction");
		return "redirect:" + path + "mvcEx1Result.jsp";
	}

	/********** mvcEx2 : Header **********/
	@RequestMapping(value = path + "headerEx1.do")
	public String injectHead1(@RequestHeader("Accept") String acceptType, Model model, String keyWord) {

		System.out.println(keyWord + " : " + acceptType);

		model.addAttribute("headData", acceptType);
		return path + "mvcEx2Result";
	}

	@RequestMapping(value = path + "headerEx2.do")
	public String injectHead2(@RequestHeader Map<String, String> map, ModelMap model) {

		model.addAttribute("headData", map);
		return path + "mvcEx2Result";
	}

	/********** mvcEx2 : Cause An Exception **********/
	// Cause an exception
	@RequestMapping(value = path + "nullPoint.do")
	public String injectHead3(int no) {
		String str = null;
		if (no > 10) {
			str = new String("Default");
		}

		str.concat("Demo"); // null인 상태에서 concat이라는 method를 실행 시킬 수 없음 = null point exception
		System.out.println("str : " + str);
		return path + "exceptionNone";
	}

	// Cause an selective exception
	@RequestMapping(value = path + "classCasting.do")
	public String injectHead4() {
		String str = (String) new Object();
		System.out.println(str); // delete : unused warning.
		return path + "exceptionNone";
	}

	// Cause an exception
	@RequestMapping(value = path + "numberFormat.do")
	public String injectHead5() {
		Integer.parseInt("이십");
		return path + "exceptionNone";
	}

	@RequestMapping(value = path + "arithmetic.do")
	public String injectHead6() {
		int cnt = (10 / 0);
		System.out.println(cnt); // delete : unused warning.
		return path + "exceptionNone";
	}

	@RequestMapping(value = path + "arrayOutOfBounds.do")
	public String injectHead7() {
		int[] cnt = { 1, 2, 3 };
		cnt[4] = 10; // arrayOutOfBounds!!
		return path + "exceptionNone";
	}

	/********** mvcEx2 : Exception Handler **********/
	// Exception Handler ( Overload )
	@ExceptionHandler(NullPointerException.class)
	public String exceptionHandler(NullPointerException e, Model model) {
		model.addAttribute("msg", "ErrorCheck");
		model.addAttribute("exception", e);
		return path + "exceptionError";
	}

	// Exception Handler ( Overload )
	@ExceptionHandler(ClassCastException.class) // 매개변수 type이 다르면 Exception Handling이 안된다...
	public String exceptionHandler(ClassCastException e, Model model) {
		model.addAttribute("msg", "ErrorCheck");
		model.addAttribute("exception", e);
		return path + "exceptionError";
	}

	// Exception Handler ( Overload )
	@ExceptionHandler(NumberFormatException.class) // 매개변수 type이 다르면 Exception Handling이 안된다...
	public String exceptionHandler(NumberFormatException e, Model model) {
		model.addAttribute("msg", "ErrorCheck");
		model.addAttribute("exception", e);
		return path + "exceptionError";
	}

	// Exception Handler ( Overload )
	@ExceptionHandler(ArithmeticException.class)
	public String exceptionHandler(ArithmeticException e, Model model) {
		model.addAttribute("msg", "ErrorCheck");
		model.addAttribute("exception", e);
		return path + "exceptionError";
	}
	// Ancestor Exception
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		model.addAttribute("msg", "ErrorCheck");
		model.addAttribute("exceptionType", e.getClass().getName());
		return path + "exceptionError";
	}
	
	/********** Intercepter : login **********/
	@RequestMapping(value = "login.do")
	public String loginActionDataPro(String id, String pw) {
		System.out.println("loginActionDataPro");
		return "redirect:/intercepterList.do"; //intercepter return true?
	}

	@RequestMapping(value = "intercepterList.do")
	public String ListActionDataPro(Model model) {
		//dao를 통해 데이터를 뿌려야하나 시간관계상 생략.
		System.out.println("ListActionDataPro");
		model.addAttribute("msg", "ListMessage");
		return path + "interListView"; //intercepter return true?
	}
}
