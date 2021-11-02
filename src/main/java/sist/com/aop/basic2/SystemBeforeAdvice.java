package sist.com.aop.basic2;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SystemBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("File 분석한다... before()");
		System.out.println(method.getName() + " : " + method);
		System.out.println("수행중 >>> ");
	}

}
