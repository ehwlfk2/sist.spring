package sist.com.aop.basic3;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component(value = "basic3ActionAspect")
public class ActionAspect {

	@Before("execution(public * sist.com.aop.basic3.Search*.*())")
	public void dataBeforeProcess(JoinPoint jp) {
		Signature signature = jp.getSignature();
		Date date = new Date();

		System.out.println("BeforeAdvice - " + date);

		String methodName = signature.getName();
	
		switch(methodName) {
		case "fileSearch":
			System.out.println("FileActionBeforeAdvice");
			break;
		case "xmlParsing":
			System.out.println("XmlActionBeforeAdvice");
			break;
		case "domSaxSearch":
			System.out.println("DomSaxActionBeforeAdvice");
			break;
		}
		
		
	}
}
