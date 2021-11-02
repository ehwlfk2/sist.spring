package sist.com.di.basic4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DbmsMain {
	public static void main(String[] args) {
		System.out.println("--- main start ---");
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"src/main/java/sist/com/di/basic4/dbaction.xml");
		
		System.out.println("\n\n--- The Dividing Line : first ---");
		
		System.out.println("context : ");
		System.out.println(context);
		
		Object bean;

		try {
			// 이름을 주지 않을 때.
			System.out.println("\ncontext.getBean(\"dbms\") : ");
			System.out.println(bean = context.getBean("dbms"));
		} catch (BeansException e) {
			// 이름을 줄때 (value = "OracleDBMS")
			System.out.println("context.getBean(\"OracleDBMS\") : ");
			System.out.println(bean = context.getBean("OracleDBMS"));
		}

		System.out.println("\n\n--- The Dividing Line : third ---");
		DiController diController = (DiController)context.getBean("diController");
		diController.selectDemo();
		
		System.out.println("\n\n--- The Dividing Line : second ---");
		System.out.println(bean = context.getBean("dao"));
		System.out.println(((Dao)bean).getBean());
		System.out.println(context.getBean("dao"));
				
		
	}
}
