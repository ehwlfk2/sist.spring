package sist.com.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberBoardVO {
	private int no;
	private	String id;      
	private String password;      
	private String name;       
}
/*
ID        NOT NULL VARCHAR2(20)
PASSWORD  NOT NULL VARCHAR2(20)
LOVETABLE          NUMBER(5)   
NAME               VARCHAR2(20)
*/