package sist.com.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import sist.com.vo.MemberBoardVO;
import sist.com.vo.MvcBoardVO;

@Repository
public class BoardDao extends SqlSessionDaoSupport {

	@Resource(name = "sqlSessionTemplate")
	protected void initDao(SqlSessionTemplate sessionTemplate) throws Exception {
		System.out.println("initDao() : BoardDao");
		this.setSqlSessionTemplate(sessionTemplate);
	}
	
	//insert
	public void insertBoard(MvcBoardVO vo) {
		System.out.println("insertBoard() : " + this.getSqlSession());

		System.out.println("vo : " + vo);

		this.getSqlSession().insert("insertBoard", vo);
		//sist.com.vo.MvcBoardVO
	}
	//insert - login
	public void signUpBoard(MemberBoardVO vo) {
		System.out.println("SignUp() : " + vo);
		this.getSqlSession().insert("insertBoardMember", vo);
	}
	
	//update
	public void updateHit(int no) {
		/*int count = */this.getSqlSession().update("updateHit", no);
		//System.out.println(count + "개 행의 hit이 업데이트되었습니다.");
	}
	// 추후에는 여러 행의 동시에 처리하는 Sequence나 Function으로 변경해주자.. DB에 여러번 접근하니까 느려...
	public void updateStep(Map<?, ?> map) {	
		/*int count = */this.getSqlSession().update("updateStep", map);
		//System.out.println(count + "개 행의 step이 업데이트 되었습니다.");
	}
	public void updateReply(int no) { 
		int count = this.getSqlSession().update("updateReply", no);
		System.out.println(count + "개 행의 reply가 업데이트 되었습니다.");
	}
	
	//select
	public List<MvcBoardVO> selectBoard() {
		System.out.println("selectBoard() in BoardDao.java");
		return this.getSqlSession().selectList("selectBoard");
	}
	public MvcBoardVO selectInfoBoard(int no) {
		return this.getSqlSession().selectOne("selectInfoBoard", no);
	}
	public MvcBoardVO selectInfoAllBoard(int no) {
		return this.getSqlSession().selectOne("selectInfoAllBoard", no);
	}	
	//select - login
	public boolean loginBoard(String id, String password) {
		System.out.println("UserInputID&Password : " + id + ", " + password);
		String dbPass = this.getSqlSession().selectOne("loginBoard", id);
		System.out.println("DbQueryPassword : " + dbPass);
		return dbPass != null && dbPass.equals(password);
	}
	//select - part on one
	public int getSequence() {
		return this.getSqlSession().selectOne("getSequence");
	}
	public String getMemberId(int no) {
		return this.getSqlSession().selectOne("getMemberId", no);
	}
	//select - boardPassword
	public boolean boardPasswordConfirm(String password, int no) {
		String dbPass = this.getSqlSession().selectOne("getPasswordOfBoard", no);
		return ((dbPass != null) && (dbPass.equals(password))) ? true : false;
	}
	
	//delete - board
	public void deleteBoardOfNo(int no) {
		this.getSqlSession().delete("deleteBoardOfNo", no);
	}
}
