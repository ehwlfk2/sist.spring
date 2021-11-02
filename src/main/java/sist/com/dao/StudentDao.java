package sist.com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import sist.com.vo.StudentVO;

@Repository
public class StudentDao extends SqlSessionDaoSupport {
	@Resource(name = "sqlSessionTemplate")
	protected void initDao(SqlSessionTemplate sessionTemplate) throws Exception {
		System.out.println("initDao() : StudentDao");
		this.setSqlSessionTemplate(sessionTemplate);
	}

	public List<StudentVO> selectAllStudent() {
		return this.getSqlSession().selectList("selectStudAction");
	}

	public List<HashMap<String, Object>> selectAllEmployee() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		// dao.selectSingleEmployee
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("empno", 7878);
		map.put("ename", "smith");
		map.put("sal", 5000);
		list.add(map);

		return list;
	}

	public HashMap<String, Object> selectSingleDept() {
		// dao.selectSingleDept
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("deptno", 10);
		map.put("dname", "영업부");
		map.put("loc", "부산");

		return map;
	}
}
