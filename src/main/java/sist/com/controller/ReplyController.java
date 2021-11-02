package sist.com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sist.com.dao.ReplyAjaxDao;
import sist.com.vo.ReplyVO;

@RestController
public class ReplyController {
	private final String path = "/boardMVC/";
	// private final String rePath = "/boardMVC/reply/";

	@Autowired
	private ReplyAjaxDao ajaxDao;
	/*
	 * getAjaxSequence selectAjaxReply insertAjaxReply
	 */

	@RequestMapping(value = path + "ajaxGetId.do")
	public String ajaxGetId(HttpSession session) {
		String id = (String) session.getAttribute("id");
		System.out.println("[id : " + id + "]");
		return (String) session.getAttribute("id");
	}

	@RequestMapping(value = path + "ajaxReplyInsert.do")
	public List<ReplyVO> ajaxInsertList(ReplyVO vo) {
		System.out.println("input data : " + vo);
		if (vo.getJob().equals("new")) {
			System.out.println("new reply insert...");
			vo.setNo(ajaxDao.getAjaxSequence());
			vo.setPnum(vo.getNo());
			vo.setRef(vo.getNo());
		} else { // edit
			System.out.println("아직 edit 구현하지 않았습니다.");
			return ajaxDao.selectAjaxReply();
		}
		System.out.println("insert data : " + vo);
		ajaxDao.insertAjaxReply(vo);
		return ajaxDao.selectAjaxReply();
	}
	
	@RequestMapping(value = path + "ajaxReplySelect.do")
	public List<ReplyVO> ajaxSelectList(){
		return ajaxDao.selectAjaxReply();
	}	
}
