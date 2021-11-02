package sist.com.di.basic7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerMain {

	public static void main(String[] args) {
		/* server.xml 안에 server.properties의 path를 ClassPath로 지정해뒀기 때문에 .xml을 호출할 때도 ClassPath로 불러야 한다.
		아래의 코드는 Path Error 유발 : 
			ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/sist/com/di/basic7/server.xml");
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("sist/com/di/basic7/server.xml");
		
		System.out.println(context);
		System.out.println(context.getBean("webServer"));
		
	}
	
	
}
