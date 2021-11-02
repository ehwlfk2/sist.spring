package sample.springBeanLifeCycle.dependency;

public class BeanB {

	public BeanB() {
		super();
		System.out.println("BeanB : Constructor()");
	}
	
	public void init() {
		System.out.println("BeanB : init()");
	}
	
	public void destroy() {
		System.out.println("BeanB : destroy()");
	}
	
}
