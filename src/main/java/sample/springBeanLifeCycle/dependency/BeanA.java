package sample.springBeanLifeCycle.dependency;

public class BeanA {
	
	public BeanA() {
		super();
		System.out.println("BeanA : Constructor()");
	}

	public void init() {
		System.out.println("BeanA : init()");
	}
	
	public void destroy() {
		System.out.println("BeanA : destroy()");
	}
}
