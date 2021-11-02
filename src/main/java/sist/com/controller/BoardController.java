package sist.com.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sist.com.dao.BoardDao;
import sist.com.vo.MemberBoardVO;
import sist.com.vo.MvcBoardVO;

/**
 * @RequestMappingList 1. value="/boardMVC/boardLogin.do" 2.
 *                     value="/boardMVC/boardList.do" 3. value="/boardInsert.do"
 *                     4. value="/springWeb/boardInfo.do"
 *
 */
@Controller
public class BoardController {
	@Autowired
	private BoardDao dao;

	private final String path = "/boardMVC/";

	/*
	 * 1. RequestMapping(value="/boardMVC/boardLogin.do", method=
	 * {RequestMethod.GET, RequestMethod.POST}) 2.
	 * GetMapping(value="/boardMVC/boardLigon.do") 3.
	 * PostMapping(value="/boardMVC/boardLogin.do")
	 */
	@RequestMapping(value = path + "boardLogin.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String logCheck(HttpSession session, HttpServletRequest request) {
		System.out.println("logCheck()");
		if (dao.loginBoard(request.getParameter("id"), request.getParameter("password"))) {
			// session 처리가 필요하다.
			session.setAttribute("id", request.getParameter("id"));
			session.setMaxInactiveInterval(3600);
			return "redirect:boardList.do";
		} else {
			return "redirect:signin.jsp?cmd=fail";
		}
	}

	@RequestMapping(value = path + "boardSignUp")
	public String SignUpAction(MemberBoardVO bean) {
		System.out.println("SignUpAction");
		dao.signUpBoard(bean);
		return "redirect:" + path + "boardLogin.do?id=" + bean.getId() + "&password=" + bean.getPassword();
	}

	// BOARD
	@RequestMapping(value = path + "boardList.do")
	public String boardListAction(Model model) {
		System.out.println("boardListAction\ndao : " + dao);
		model.addAttribute("boardList", dao.selectBoard());
		return "boardMVC/board";
	}

	@RequestMapping(value = path + "boardInsert.do")
	public String boardInsertAction(HttpServletRequest request, MvcBoardVO bean,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		System.out.println("boardInsertAction()");
		System.out.println("bean : " + bean);

		bean.setFileName(imageUpload(file));

		// be writen : author, title, password, contents, ... , fileName, id, job
		int no = (dao.getSequence());
		bean.setNo(no);

		if (bean.getJob().equals("new")) { // new
			System.out.println("new : ");
			// init : no, hit, (ref), step, lev, (pnum), reply, (regdate)
			bean.setRef(no);
			bean.setPnum(no);
			// regdate는 DB에서 적용.
		} else { // reply
			System.out.println("reply : " + bean.getJob());
			MvcBoardVO vo = dao.selectInfoAllBoard(Integer.parseInt(request.getParameter("no")));
			System.out.println("vo : " + vo);
			int ref = vo.getRef();
			bean.setRef(ref);
			int step = vo.getStep() + 1;
			bean.setStep(step);
			dao.updateStep(createMap(new String[] { "ref", "step" }, new Integer[] { ref, step }));
			bean.setLev(vo.getLev() + 1);
			bean.setPnum(vo.getNo());
			dao.updateReply(ref);
		} // edit
		System.out.println(bean);
		dao.insertBoard(bean);
		return "redirect:/boardMVC/boardList.do";
	}

	@RequestMapping(value = path + "boardInfo.do")
	public String boardInfoAction(HttpServletRequest request, Model model) {
		System.out.println("boardInfoAction()");
		// 해당 게시글 no의 hit 증가해야됨!
		dao.updateHit(Integer.parseInt(request.getParameter("no")));
		model.addAttribute("boardInfo", dao.selectInfoBoard(Integer.parseInt(request.getParameter("no"))));
		try {
			String job = request.getParameter("job");
			if (job.equals("edit"))
				return "/boardMVC/write";
		} catch (NullPointerException e) {
			// System.out.println("job이 없습니다.");
		}
		return "/boardMVC/info";
	}

	@RequestMapping(value = path + "passwordConfirm.do")
	public String passwordConfirmAction(String password, int no, String job) {
		System.out.println("password : " + password);
		boolean bool;
		System.out.println(bool = dao.boardPasswordConfirm(password, no));

		String uri = "redirect:/boardMVC/passwordConfirm.jsp";
		String param = "?no=" + no + "&job=" + job;

		if (bool) {
			switch (job) {
			case "del":
				uri = "redirect:/boardMVC/deleteBoardAction.do";
				break;
			case "edit":
				uri = "redirect:/boardMVC/boardInfo.do";
				break;
			default:
				System.out.println("default");
			}
		}
		System.out.println(uri + param);
		return uri + param;
	}

	@RequestMapping(value = path + "deleteBoardAction.do")
	public String deleteBoardAction(int no) {
		System.out.println("deleteBoard number : " + no);
		dao.deleteBoardOfNo(no);
		return "redirect:boardList.do";
	}

	@RequestMapping(value = path + "replyView.do")
	public String replyViewAction() {
		System.out.println("replyViewAction()");
		//dao.insert();
		return "redirect:/boardMVC/reply/replyView.jsp";
	}

	private String imageUpload(MultipartFile file) {
		System.out.println(file.getOriginalFilename());

		// parameterPrint(request);

		// FileIOStream //upload file...system 
		// 나 이제 E 아니다!!
		String location = "E:\\software\\Spring\\web\\src\\main\\webapp\\resources\\upload\\";
		FileOutputStream fos = null;
		String fileName = file.getOriginalFilename();
		if (fileName.length() > 0) {
			try {
				fos = new FileOutputStream(location.concat(fileName));
				fos.write(file.getBytes());
				return fileName;
			} catch (Exception e) {
				System.out.println("boardInsertAction.fileIOError");
				e.printStackTrace();
			} finally {
				try {
					if (fos != null)
						fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} // if
		return null;
	}

	@SuppressWarnings("unused") // 테스트용 출력코드
	private void parameterPrint(HttpServletRequest request) {
		// dao.insertBoard();
		MvcBoardVO vo = new MvcBoardVO();
		vo.setAuthor(request.getParameter("author"));

		Enumeration<?> e = request.getParameterNames();
		// Map<String, String> map = (Map<String, String>)request.getParameterMap();

		/*
		 * The keys in the parameter map are of type String. The values in the parameter
		 * map are of type String array.
		 */
		Map<?, ?> map = request.getParameterMap();
		System.out.println("request.getParmeterNames : ");
		int i = 1;
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			System.out.printf("\t%d : %s = %s\n", i++, name, "next");

			System.out.println(map.get(name).getClass().getCanonicalName());
			String[] values = (String[]) map.get(name);
			for (int j = 0; j < values.length; j++) {
				System.out.println(values[j]);
			}

		}

		Set<?> keys = map.keySet();
		Iterator<?> key_iter = keys.iterator();
		while (key_iter.hasNext()) {
			String key = (String) key_iter.next();
			System.out.println("key : " + key);
			System.out.println("value : " + map.get(key));
		}

		Collection<?> list = map.values();
		Iterator<?> list_iter = list.iterator();
		while (list_iter.hasNext()) {
			System.out.println(list_iter.next());
		}

		System.out.println(vo.getAuthor());
	}

	private Map<?, ?> createMap(String[] keys, Integer[] integers) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], integers[i]);
		}
		System.out.println(map);
		return map;
	}
}
