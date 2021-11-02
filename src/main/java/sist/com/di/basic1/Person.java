package sist.com.di.basic1;

public class Person {
	String name;
	int age;
	String address;
	
	// construct
	public Person() {
		super();
		System.out.println("Person() - " + name);
	}
	public Person(String name, int age, String address) {
		super();
		System.out.println("Person(String, age, address) - " + name);
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	// user method : persondi.xml 에서 사용된다.
	@SuppressWarnings("unused")
	private void initPerson() {
		System.out.println("initPerson() - " + name);
	}
	@SuppressWarnings("unused")
	private void destoryPerson() {
		System.out.println("destoryPerson() - " + name);
	}
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
