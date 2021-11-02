package sample.springBeanLifeCycle.dependency;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controller + ResponseBody
@SuppressWarnings("unused") // This is Testing Code.
public class DiController {
	
	// Dependency Injection
	@Autowired
	private BeanA beanA;
	@Autowired
	private BeanB beanB;
	@Autowired
	private ComponentA componentA;
	@Autowired
	private ComponentB componentB;
	//end injection;
	
	public DiController() {
		System.out.println("DiController : Constructor()");
	}

	@PostConstruct
	void init() {
		System.out.println("DiController : init()");
	}

	@RequestMapping("/sampleController.do")
	public String index() {
		return "hello world on DiController.java";
	}

	@PreDestroy
	public void destroy() {
		System.out.println("DiController : destroy()");
	}

	public static void main(String[] args) {
		//String config = "sample.springBeanLifeCycle.dependencyNo.WebConfig";
		System.out.println("Main of DiController");
		ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
		//ApplicationContext context = new ClassPathXmlApplicationContext(config);
		
		System.out.println("Context : ");
		System.out.println(context);
		
		System.out.println("ContextNames : ");
		String[] names = context.getBeanDefinitionNames();
		for(int i =0 ; i < names.length ; i++)
			System.out.printf("names[%d] = %s\n", i, names[i]);
		
		// Down Casting. ( AbstractApplicationContext.class - ConfigurableApplicationContext.interface - ApplicationContext.interface )
		// .close() is destroy Web Context.
		((AbstractApplicationContext) context).close();
		
	}

}
