package sist.com.aop.core;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component(value = "coreActionAspect") // basic3와 충돌방지
public class ActionAspect {
	
	@Before("execution(public * sist.com.dao.ParentDao.file*(..))")
	public void fileBeforeAspect() {
		System.out.println("FileSizeCheck! (BeforeAdvise)");
	}
}
