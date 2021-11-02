package sist.com.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionVO {
	private int no;
	private String msg;
	private String regdate;
}

/*
create table TransactionDB(
	NO NUMBER(5) PRIMARY KEY,
	MSG VARCHAR2(20),
	REGDATE DATE
);

create SEQUENCE TransactionDB_seq
	increment by 1
	start with 1
	maxValue 9999
	cycle;

*/