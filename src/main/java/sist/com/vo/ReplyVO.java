package sist.com.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReplyVO {
	private int no;
	private String id;
	private String regdate;
	private int step, lev, pnum, ref, reply;
	private String job, contents;
}
