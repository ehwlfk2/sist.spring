package sist.com.di.basic8;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NodeMain {

	public static void main(String[] args) {
		// "Annotation Config Application Context"를 다뤄보자.
		System.out.println("first context : ");
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigDemo.class);
		System.out.println(context);
		
		System.out.println("\n--- first test ---");
		// name 이 없을 경우 method 이름 그대로 들고 온다.
		System.out.println(context.getBean("getComputer"));
		
		try {
			// name 이 있을 경우 method로 부르면 Error 발생
			System.out.println("method name : " + context.getBean("getComputerSuper"));
		}catch (BeansException e) {
			// name 이 있을 경우 name으로 들고온다.
			System.out.println("bean name : " + context.getBean("Song"));
		}
		
		
		System.out.println("\n--- second test ---");
		// first test의 확장.
		System.out.println(context.getBean("getSystemNode"));
		
		
		System.out.println("\n--- third test ---");
		/* context를 이루는 ConfigDemo에
		Annotation :  
			Configuration 
			ComponentScan
		을 넣어주고 Computer.java에다가
		Annotation :
			Component
		를 넣어주면 .xml에서 사용하듯이 가져올 수 있다. (대소문자 주의)
		*/
		System.out.println(context.getBean("computer"));
		
		
		System.out.println("second context : ");
		ApplicationContext contextMan = new AnnotationConfigApplicationContext(ConfigMan.class);
		System.out.println(contextMan);
		
		System.out.println("\n--- forth test ---");
		System.out.println(contextMan.getBean("getMan"));
		
		
		System.out.println("\n--- fifth test ---");
		System.out.println(context.getDisplayName() + " : " + context.getStartupDate());
		String[] beans = context.getBeanDefinitionNames();
		System.out.println("beans : ");
		for(int i = 0; i < beans.length; i++)
			System.out.printf("beans[%d] : %s\n", i, beans[i]);
		System.out.println("context.getBean(\"configMan\") : " + context.getBean("configMan"));
		/* ConfigDemo.java에다가
		Annotation : 
			Import(value=ConfigMan.class)
		을 넣어주면, ConfigMan.java에 있는 다른 Bean Annotation을 불러 올 수 있다.
		*/
		System.out.println(context.getBean("getMan"));
		
		
		System.out.println("\n--- sixth test ---");
		/* ConfigDemo.java에다가
		Annotation : 
			ImportResource(value="sist/com/di/basic2/bookdi.xml")
		을 넣어주면, bookdi.xml에 있는 다른 Bean들을 호출 할 수 있다.
		
		ps)	여기서 path는 ClassPath이기 때문에 java폴더 내부에서 출발하고 있다.
			더불어 BookMain.java안에서 bookdi.xml의 path는 다음과 같다.
			ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/sist/com/di/basic2/bookdi.xml");
			보면 위의 Annotation과 path가 다른 것을 알 수 있는데, FileSystemXmlApplicationContext이기 때문에 프로젝트 root 폴더 내부에서 출발하고 있기 때문이다.
			이를 같은 ClassPath인 
			ClassPathXmlApplicationContext("sist/com/di/basic2/bookdi.xml"); 
			으로 코드를 변경해도 돌아가는 것을 알 수 있다.
		*/
		System.out.println(context.getBean("book3"));
		
		
		System.out.println("\n--- seventh test ---");
		/* ConfigDemo.java의 Annotation중 ImportResource안에 value의 값을 변경했다
		변경 전 코드 : 
			ImportResource(value= "sist/com/di/basic2/bookdi.xml")
		변경 후 코드 :
			ImportResource(value= {"sist/com/di/basic2/bookdi.xml", "sist/com/di/basic7/server.xml"})
		보면 value에 배열로 값을 여러 개 넣어준 코드로 변경한 것.		
		*/
		System.out.println(context.getBean("webServer"));
		
		
		System.out.println("\n--- eighth test ---");
		// ConfigDemo.java안에 DiProcess를 추가해주고 Annotation Inject를 통해 DI해주었다.
		DiProcess diProcess = context.getBean("diProcess", DiProcess.class);
		diProcess.process();
		
	}
}
