package sample.springBeanLifeCycle.dependency;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class ComponentB {

	public ComponentB() {
		System.out.println("ComponentB : constructor()");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("ComponentB : init()");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("ComponentB : destroy()");
	}
}
