package sist.com.aop.basic;

import org.springframework.aop.AfterAdvice;

public class AfterAdviseBean implements AfterAdvice{

	public void afterMethod() {
		System.out.println("Connect Close");
		System.out.println("DataBaseAfter End");		
	}
}
