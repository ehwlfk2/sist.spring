package sist.com.aop.basic3;

import org.springframework.stereotype.Repository;

@Repository
public class SearchImpl implements Search{

	@Override
	public void fileSearch() {
		System.out.println("fileSearch()...");
	}

	@Override
	public void xmlParsing() {
		System.out.println("xmlParsing()...");		
	}

	@Override
	public void domSaxSearch() {
		System.out.println("domSaxSearch()...");		
	}
}
