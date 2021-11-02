package sist.com.aop.basic;

import org.springframework.aop.BeforeAdvice;

public class BeforeAdviceBean implements BeforeAdvice{
	
	public void beforeMethod() {
		System.out.println("DataBaseConnect");
		System.out.println("PrePareAction");
	}
}
