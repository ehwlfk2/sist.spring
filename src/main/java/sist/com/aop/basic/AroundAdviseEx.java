package sist.com.aop.basic;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdviseEx {

	public void messageAround(ProceedingJoinPoint jp) throws Throwable{
	    long start = System.currentTimeMillis();
	    System.out.println("program run!!");
	    //jp.proceed();
	    
	    for(int i = 0 ; i < (int)(Math.random()*10000000) ; i++){ // sleep?
	        
	    }
	    jp.proceed(); //핵심코드!! 위치는 마음대로~

	    long end = System.currentTimeMillis();
	    System.out.println((end-start)+"밀리초 소요...");

	}

}
