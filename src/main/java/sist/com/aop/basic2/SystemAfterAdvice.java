package sist.com.aop.basic2;

import java.lang.reflect.Method;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;

public class SystemAfterAdvice implements AfterReturningAdvice, AfterAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("File Closing... AfterReturning()");
		System.out.println("정상 수행되었습니다.");
	}

	public void afterMethod() throws Throwable {
		System.out.println("This is afterMethod()...");
	}

}
