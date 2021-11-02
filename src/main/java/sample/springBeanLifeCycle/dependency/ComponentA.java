package sample.springBeanLifeCycle.dependency;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class ComponentA {
	
	public ComponentA() {
		System.out.println("ComponentA : Constructor()");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("ComponentA : init()");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("ConponentA : destroy()");
	}
}
