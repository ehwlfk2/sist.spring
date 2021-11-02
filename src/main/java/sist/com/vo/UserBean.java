package sist.com.vo;

import java.util.List;

import lombok.Data;


@Data
public class UserBean {
	// userForm과 변수 이름이 같아야 한다.
	private String name;
	private String email;
	private String gender;
	private List<String> item;	
}
