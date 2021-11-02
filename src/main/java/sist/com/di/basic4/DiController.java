package sist.com.di.basic4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiController {

	@Autowired
	private Dao dao;
	
	public DiController() {
		System.out.println("DiController()..!");
	}
	
	public void selectDemo() {
		dao.select();	// DiController.
	}
	
	
	
}
