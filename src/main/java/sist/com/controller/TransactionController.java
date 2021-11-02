package sist.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sist.com.dao.TransactionDao;
import sist.com.vo.TransactionVO;

@Controller
public class TransactionController {
	private final String path = "/mvcAOP/";

	@Autowired(required = true)
	private TransactionDao actionDao;

	private List<TransactionVO> selectProcess() {
		return actionDao.selectAllTransaction();
	}

	@RequestMapping(value = path + "aopTransactionActionDemoSelect.do")
	public @ResponseBody List<TransactionVO> selectAllTransaction() {
		return selectProcess();
	}

	@RequestMapping(value = path + "aopTransactionActionDemoInsert.do")
	public @ResponseBody List<TransactionVO> insertTransaction(TransactionVO vo) {
		int SuccessCount = actionDao.insertTransaction(vo);
		System.out.println("insert : " + SuccessCount);

		if (SuccessCount > 0) {
			return selectProcess();
		} else {
			return null;
		}
	}

	@RequestMapping(value = path + "aopTransactionActionDemoUpdate.do")
	public @ResponseBody List<TransactionVO> updateNoTransaction(TransactionVO vo) {
		int SuccessCount = actionDao.updateNoTransaction(vo);
		System.out.println("update : " + SuccessCount);
		
		if(SuccessCount > 0) {
			return selectProcess();
		}else {
			return null;			
		}
	}

	@RequestMapping(value = path + "aopTransactionActionDemoDelete.do")
	public @ResponseBody List<TransactionVO> deleteTransaction(TransactionVO vo) {
		int SuccessCount = actionDao.deleteTransaction(vo);
		System.out.println("delete : " + SuccessCount);

		if (SuccessCount > 0) {
			return selectProcess();
		} else {
			return null;
		}
	}

}
