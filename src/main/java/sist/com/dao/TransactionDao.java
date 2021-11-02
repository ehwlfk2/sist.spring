package sist.com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import sist.com.vo.TransactionVO;

@Repository
public class TransactionDao extends SqlSessionDaoSupport {

	@Resource(name = "sqlSessionTemplate")
	protected void initDao(SqlSessionTemplate sessionTemplate) throws Exception {
		System.out.println("initDao() : TransactionDao");
		this.setSqlSessionTemplate(sessionTemplate);
	}

	// select
	public List<TransactionVO> selectAllTransaction() {
		return this.getSqlSession().selectList("selectAllTransaction");
	}

	public int selectNoSeqTransaction() {
		return this.getSqlSession().selectOne("selectNoSeqTransaction");
	}

	// insert
	public int insertTransaction(TransactionVO vo) {
		if (vo.getNo() > 0) {
			return this.getSqlSession().insert("insertAllTransaction", vo);
		} else { // Auto No
			return this.getSqlSession().insert("insertMsgTransaction", vo);
		}
	}

	// update
	public int updateNoTransaction(TransactionVO vo) {
		return this.getSqlSession().update("updateNoTransaction", vo);
	}

	// delete
	public int deleteTransaction(TransactionVO vo) {
		int successCount;
		if (vo.getNo() > 0) {
			if (vo.getMsg() != null && vo.getMsg().length() > 0)
				successCount = this.getSqlSession().delete("deleteNoMsgTransaction", vo);
			else
				successCount = this.getSqlSession().delete("deleteNoTransaction", vo);
		} else
			successCount = this.getSqlSession().delete("deleteMsgTransaction", vo);
		return successCount;
	}

}
