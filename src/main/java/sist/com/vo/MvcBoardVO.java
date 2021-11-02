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
public class MvcBoardVO {
	private int no;             // NO           // boardMvc_seq.nextVal
	private String author;      // AUTHOR       //
	private String title;       // TITLE        //
	private String password;    // PASSWORD     //
	private String contents;    // CONTENTS     //
	private int hit;            // HIT          // 조회 수
	private int ref;            // REF          // Root 게시글 No (default = this.no)
	private int step;           // STEP         // 출력 순서 (부모 - 형제:최신글 - 자식)
	private int lev;            // LEV          // 조상 게시글 수 (tree의 depth)
	private int pnum;           // PNUM         // 부모 게시글 No (default = this.no)
	private int reply;          // REPLY        // 바로밑에 자식 수
	private String regdate;     // REGDATE      // sysdate
	private String fileName;    // FILENAME     // 업로드한 파일 이름
	private String id;          // ID           // 작성자의 id
	private String job;			// JOB          // 작성자의 익명 name
}
/*
NO       NOT NULL NUMBER(5)     
AUTHOR            VARCHAR2(20)  
TITLE             VARCHAR2(20)  
PASSWORD          VARCHAR2(20)  
CONTENTS          CLOB          
HIT               NUMBER(5)     
REF               NUMBER(5)     
STEP              NUMBER(5)     
LEV               NUMBER(5)     
PNUM              NUMBER(5)     
REPLY             NUMBER(5)     
REGDATE           DATE          
FILENAME          VARCHAR2(100) 
ID                VARCHAR2(20)  
JOB     		  VARCHAR2(20)
*/