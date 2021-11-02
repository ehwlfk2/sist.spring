package sist.com.di.basic5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ActionMain {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/java/sist/com/di/basic5/action.xml");

		System.out.println("--- --- first --- ---");
		System.out.println("context : " + context);
		
		WebController webController = (WebController)context.getBean("webController");
		System.out.println("webController : " + webController);
		
		System.out.println("viewJs : " + webController.viewJs());
	}
}
