	package sample.book;
	
	import org.springframework.context.ApplicationContext;
	import org.springframework.context.annotation.AnnotationConfigApplicationContext;
	import org.springframework.context.support.AbstractApplicationContext;
	
	public class DemoApplication {
		
		public static void main(String[] args) {
			//ApplicationContext context = new ClassPathXmlApplicationContext("sample/book/application.xml");
			ApplicationContext context = new AnnotationConfigApplicationContext(sample.book.ApplicationConfig.class);
			
			String[] getBeanDefinitionNames = context.getBeanDefinitionNames();
			
			for(int i = 0; i<getBeanDefinitionNames.length; i++)
				System.out.printf("%d : %s\n", i, getBeanDefinitionNames[i]);
			
			((AbstractApplicationContext) context).close();
		}
	}
