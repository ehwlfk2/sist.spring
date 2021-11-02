package sist.com.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import sist.com.vo.ReplyVO;

@Repository
public class ReplyAjaxDao extends SqlSessionDaoSupport{
	
	@Inject
	protected void initDao(SqlSessionTemplate st) throws Exception{
		this.setSqlSessionTemplate(st);
	}
	
	// select
	public Integer getAjaxSequence() {
		System.out.println("This is getAjaxSequence()...");
		return this.getSqlSession().selectOne("getAjaxSequence");
	}
	public List<ReplyVO>selectAjaxReply(){
		return this.getSqlSession().selectList("selectAjaxReply");
	}
	
	// insert
	public void insertAjaxReply(ReplyVO vo) {
		this.getSqlSession().insert("insertAjaxReply", vo);
	}
}
