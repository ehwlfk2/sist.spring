package sist.com.di.basic6;

import java.util.ArrayList;
import java.util.List;

public class BasicControllerDao {

	
	public List<String> selectLoginItem(){
		// DB 조회
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		
		return list;
		
	}
}
