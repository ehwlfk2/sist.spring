package sist.com.aop.basic;

public class MyBatisDao implements Dao{

	@Override
	public void appInsert() {
		System.out.println("--core concern : appInsert()");
	}

	@Override
	public void appUpdate() {
		System.out.println("--core concern : appUpdate()");		
	}

	@Override
	public void appDelete() {
		System.out.println("--core concern : appDelete()");		
	}
	
	
}
