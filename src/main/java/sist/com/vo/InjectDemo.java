package sist.com.vo;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import sist.com.dao.BoardDao;

@Repository
public class InjectDemo {
	
	@Getter
	@Inject
	private BoardDao boardDao;
	
	public void sayHello() {
		System.out.println("This is InjectDemo Class");
		System.out.println(boardDao);
	}
}
