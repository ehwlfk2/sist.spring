package sample.springBeanLifeCycle.dependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //web.xml과 같은 역할
@ComponentScan(basePackages="sample.springBeanLifeCycle.dependency")
public class WebConfig {
	
	public WebConfig() {
		System.out.println("WebConfig : Constructor()");
	}
	
	@Bean(name = "beanA", initMethod = "init", destroyMethod = "destroy")
	public BeanA getBeanA() {
		return new BeanA();
	}
	
	@Bean(name = "beanB", initMethod = "init", destroyMethod = "destroy")
	public BeanB getBeaA() {
		return new BeanB();
	}
}
