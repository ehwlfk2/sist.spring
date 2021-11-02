package sist.com.di.basic3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SystemMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/sist/com/di/basic3/system.xml");
		
		//..@Component뒤에 value가 없으면 Class 이름에 첫 글자만 소문자로 해주면 된다.
		//System.out.println(context.getBean("systemProcess"));
		
		SystemProcess process = (SystemProcess)context.getBean("Process");
		process.getDataBaseSystem().connect();
		
	}
}
