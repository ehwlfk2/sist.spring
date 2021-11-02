package sist.com.di.basic8;

public class Man {
	private String name;
	private int age;

	// constructor
	public Man() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Man(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// toString
	@Override
	public String toString() {
		return "Man [name=" + name + ", age=" + age + "]";
	}
	
	// getter, setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
