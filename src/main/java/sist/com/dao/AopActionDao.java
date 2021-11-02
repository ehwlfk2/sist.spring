package sist.com.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AopActionDao implements ParentDao {
	
	@Override
	public void fileAccessData() {
		System.out.println("fileAccessData()");
	}

	@Override
	public void xmlProcessData() {
		System.out.println("xmlProcessData()");		
	}
}
