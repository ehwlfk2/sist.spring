package sist.com.springWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sist.com.dao.BoardDao;

@Component
public class LoginAction {
	@Autowired
	private BoardDao dao;
	
	public boolean loginCheckAction(String id, String password) {
		System.out.println("UserInputID&Password : " + id + ", " + password);
		
		return dao.loginBoard(id, password);
		//return id.equals("ehwlfk2@gmail.com") && password.equals("1234");
	}
	
}
