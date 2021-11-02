package sist.com.di.basic2;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BookMain {
	ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/sist/com/di/basic2/bookdi.xml");
	//ApplicationContext context = new ClassPathXmlApplicationContext("sist/com/di/basic2/bookdi.xml");
	
	Store store1 = null;
	
	private void first_test() {
		System.out.println("---Variable Declaration---");
		Book book1 = (Book) context.getBean("book1");
		Book book2 = (Book) context.getBean("book2");
		Book book3 = (Book) context.getBean("book3");

		System.out.println("---First Test---");
		printBookData(book1, book2, book3);
	}
	
	private void second_test() {
		System.out.println("---Second Test---");
		store1 = (Store) context.getBean("store1");
		
		System.out.println("List:");
		printCollection(store1.getList());
		
		System.out.println("Set:");
		printCollection(store1.getSet());
	}
	
	private void third_test() {
		System.out.println("---Third Test---");
		System.out.println("Map:");
		printCollection(store1.getMap().entrySet());
	}
	
	private void fourth_test(){
		System.out.println("---Fourth Test---");
		printCollection(store1.getProperties().entrySet());
	}

	public BookMain() {
		first_test();
		second_test();
		third_test();
		fourth_test();
	}

	public static void main(String[] args) {
		// basic path = "E:\software\Spring\web"
		System.out.println("---main---");
		new BookMain();
	}

	private void printCollection(Collection<?> list) {
		 Iterator<?> it = list.iterator();
		 while(it.hasNext())
			 System.out.println(it.next());
	}

	private void printBookData(Book... list) {
		for (int i = 0; i < list.length; i++)
			System.out.println(list[i]);
	}
}
