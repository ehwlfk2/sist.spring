package sist.com.aop.basic2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SystemMain {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/sist/com/aop/basic2/system.xml");
		System.out.println(context);
		SystemFile system = (SystemFile)context.getBean("aopBean");
		
		system.fileCheck(); //core concern
	}
	
}
