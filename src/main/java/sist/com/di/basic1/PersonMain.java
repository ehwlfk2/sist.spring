package sist.com.di.basic1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class PersonMain {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/sist/com/di/basic1/persondi.xml");
		
		// prototype : 호출할 때 객체 생성
		// singletone : context 만들때 객체 생성
		System.out.println("---First Test---");
		Object o1 = context.getBean("person1");
		Object o2 = context.getBean("person1");
		
		System.out.println("o1="+o1);
		System.out.println("o2="+o2);
	
		// prototype : 같은 속성 다른 객체.
		// singletone : 같은 속성 같은 객체.
		System.out.println(o1 == o2);
		
		
		System.out.println("---Second Test---");
		Person p2_1 = (Person)context.getBean("person2");
		Person p2_2 = (Person)context.getBean("person2");
		
		p2_1.setName("도경진");
		
		// prototype : 다른 객체라서 '김태라' 출력
		// singletone : 같은 객체라서 '도경진' 출력
		System.out.println(p2_1.getName());
		System.out.println(p2_2.getName());
		
		System.out.println("---Third Test---");
		Person p1 = (Person)context.getBean("person1");
		Person p2 = (Person)context.getBean("person2");
		Person p3 = (Person)context.getBean("person3");
		
		printPerson(p1,p2,p3);
		
		p1.setAge(p1.getAge()+10);
		p2.setAge(p2.getAge()+10);
		p3.setAge(p3.getAge()+10);

		printPerson(
				(Person)context.getBean("person1"),
				(Person)context.getBean("person2"),
				(Person)context.getBean("person3")
			);
	}
	
	private static void printPerson(Person ...list) {
		for(int i = 0 ; i < list.length ; i++)
			System.out.println(list[i]);
	}
}
