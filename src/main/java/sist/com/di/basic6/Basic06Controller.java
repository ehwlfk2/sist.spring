package sist.com.di.basic6;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Controller 안에 Component가 들어가 있다.
public class Basic06Controller {
	private final String pre_path = "mvcSpringDemo/";

	// Can be used to Resource Annotation Inject Code :
	// Resource(name="messageColor")
	MessageColor messageColor;
	BasicControllerDao dao;

	public Basic06Controller() {
		super();
		// Construct Inject Code.
		messageColor = new MessageColor();
		dao = new BasicControllerDao();
	}

	@RequestMapping(value = pre_path + "*.do")
	// return type을 void로 해도 된다!? In this case, value is "viewname".
	public void empListAction(@RequestParam(value = "state", required = false, defaultValue = "Action") String state,
			ModelMap map, HttpServletRequest request) {
		System.out.println("State : " + state);
		System.out.println(request.getRequestURL().toString());
		
		String url = request.getRequestURL().toString();
		String urn = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
		System.out.println(urn);
		
		map.addAttribute("state", state);
	}

	// RequestMapping Annotation is "URL FULL PATH"
	@RequestMapping(value = pre_path + "locationAction.do")
	// ModelAndView로 Return시키지 않아도 된다!?
	public String messageSuccess(String id, Model model) {
		System.out.println("messageSuccess");

		// redirect가 없으면 dispatcher, 있으면 redirect 방식으로 request 전송.
		model.addAttribute("id", id);

		String message = messageColor.getColorMessage(id);
		System.out.println(message);

		model.addAttribute("message", message);
		return "mvcSpringDemo/mvcAction02Result";
	}

	@RequestMapping(value = pre_path + "locationActionImg.do")
	public String messageImgSuccess(String alt, Model model) {
		// response.setHeader("Content-Type", "text/html;charset=utf-8");
		System.out.println("messageImgSuccess - " + alt);

		model.addAttribute("id", alt);

		String message = messageColor.getColorMessage(alt);
		System.out.println(message);

		// model.addAttribute("message", message);
		/*
		 * Encoding 시도. 1. Serialization 방식. 코드 : byte[] tmp =
		 * ("안녕").getBytes(Charset.forName("euc-kr")); 결과 : 실패. 이유 : 배열로 담긴다. 2.
		 * Encoding, Decoding 방식. 코드 : URLEncoder.encode(word, "UTF-8") 결과 : 실패. 이유 :
		 * addAttribute 메서드 실행시 자동으로 디코딩되는 것으로 보인다. 3. RedirectAttributes 사용. 설명 :
		 * session에 잠시 담았다가 redirect후 소멸시키는 객체. 코드 :
		 * redirectAttr.addFlashAttribute("hi", "안녕"); 결과 : 실패. 이유 : ①
		 * addAttribute("id", alt) : get방식과 동일하게 URL뒤에 붙어서 나왔었는데 이 방식을 사용하니 없어졌다. ② 별도의
		 * Redirect URL 처리 Controller가 필요하다. 결론... 가정 : get방식으로 Data를 전송할 때, 조건 :
		 * redirect Controller를 별도로 작성할 생각이 없으면!! 해결 : addAttribute를 사용하지말고 URI에 직접
		 * 기입하자. ex : "redirect:sample.jsp?message="+URLEncoder.encode("한글", "UTF-8");
		 */

		// redirect로 전달되기 때문에 request 내부 값은 보존되지 않는다!! 대신 URL에 추가되는 get방식으로 값이 전달된다.
		return "redirect:mvcAction02Result.jsp?message=" + encoding(message);
	}

	private String encoding(String word) {
		try {
			// chrome은 UTF-8로 encoding 된다.
			return URLEncoder.encode(word, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("Cannot Encoding : " + word);
		}
		return word;
	}
}

/*
 * Open Declaration org.springframework.stereotype.Controller
 * 
 * @Component
 * 
 * @Target(value={TYPE})
 * 
 * @Retention(value=RUNTIME)
 * 
 * @Documented
 * 
 * Indicates that an annotated class is a "Controller" (e.g. a web controller).
 * 
 * This annotation serves as a specialization of @Component, allowing for
 * implementation classes to be autodetected through classpath scanning. It is
 * typically used in combination with annotated handler methods based on the
 * org.springframework.web.bind.annotation.RequestMapping annotation.
 * 
 * Since:2.5 Author: Arjen Poutsma Juergen Hoeller See Also: Component
 * org.springframework.web.bind.annotation.RequestMapping
 * org.springframework.context.annotation.ClassPathBeanDefinitionScanner
 */