package sist.com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
/* 
1. RestController Annotation을 import 할때 에러가 난다면 maven 버전을 맞춰야 한다.
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-webmvc</artifactId>
	<version>4.1.6.RELEASE</version>
</dependency>

2. class 이름이 해당 Annotation과 같은 경우에 Error 발생...
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sist.com.dao.BoardDao;
import sist.com.dao.StudentDao;
import sist.com.vo.MemberBoardVO;

@RestController
public class RestControllerEx {
	private final String path = "/boardMVC/";
	@Autowired
	private StudentDao dao;
	@Autowired
	private BoardDao boardDao;

	@RequestMapping(value = path + "ajaxLogin.do")
	public String restAjaxLogin(String id, String password, HttpSession session) {
		System.out.println(id+" "+password);
		//return "Success"; //testcase 1
		//return String.valueOf(boardDao.loginBoard(id,password)); //testcase 2
		boolean state = boardDao.loginBoard(id, password);
		if(state) {
			session.setAttribute("id",id);
			session.setMaxInactiveInterval(600);
			return "success";
		}
		return "fail";
	}
	
	@RequestMapping(value = "ajaxMessage.do")
	public String restMessageAction() {
		return "HelloRestConroller";
	}

	@RequestMapping(value = "ajaxAlert.do")
	public String restAlertAction() {
		return "<script> alert('HelloRestConroller') </script>";
	}

	@RequestMapping(value = "ajaxJson.do")
	public MemberBoardVO restJsonAction() {
		return new MemberBoardVO();
	}

	@RequestMapping(value = "koreaEncoding.do", produces = "application/text; charset=UTF-8")
	public String koreaEncodingAction() {
		String korea = "안녕하세요!";
		return "{\"ListStudent\" : \"" + korea + "\"}";
	}

	@RequestMapping(value = "studentList.do", produces = "application/text; charset=UTF-8")
	public String studentListAction(@RequestParam Map<String, Object> param, HttpServletResponse response) {
		return convertStringforJSON(dao.selectAllStudent());
	}

	@RequestMapping(value = "empList.do", produces = "application/text; charset=UTF-8")
	public String empListAction() {
		return convertStringforJSON(dao.selectAllEmployee());
	}

	@RequestMapping(value = "deptInfo.do", produces = "application/text; charset=UTF-8")
	public String deptListAction() {
		return convertStringforJSON(dao.selectSingleDept());
	}
	
	
	private String convertStringforJSON(Object data) {
		String json = null;
		try {
			json = new ObjectMapper().writeValueAsString(data);
			System.out.println("----json----\n" + json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}
