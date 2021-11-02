package sist.com.di.basic9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ActionMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ActionConfig.class);
		System.out.println(context);

		System.out.println("\n--- first test ---");
		String[] beans = context.getBeanDefinitionNames();
		System.out.println("context.getBeanDefinitionNames() : ");
		for (int i = 0; i < beans.length; i++)
			System.out.printf("beans[%d] : %s\n", i, beans[i]);

		Action action = context.getBean("action", Action.class);
		System.out.println(action);

		System.out.println("\n--- second test ---");
		System.out.println("bean insert...");
		action.setActionCount(100);
		action.setActionName("경진조");
		System.out.println("bean action : " + action);

		System.out.println("a create...");
		Action a = new Action();
		a.setActionCount(50);
		System.out.println("a action : " + a);
		
		System.out.println("bean action : " + action);
	}
}
