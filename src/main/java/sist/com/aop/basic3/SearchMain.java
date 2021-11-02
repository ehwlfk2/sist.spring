package sist.com.aop.basic3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SearchMain {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/sist/com/aop/basic3/search.xml");
		System.out.println(context);
		
		Search search = (Search) context.getBean("searchImpl");
		
        //core concern
		System.out.println("---search.domSaxSearch()---");
        search.domSaxSearch();
        System.out.println("---search.fileSearch()---");
        search.fileSearch();
        System.out.println("---search.xmlParsing()---");
        search.xmlParsing();
	}
}
