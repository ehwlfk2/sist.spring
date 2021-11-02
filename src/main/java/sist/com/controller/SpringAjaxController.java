package sist.com.controller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sist.com.dao.StudentDao;
import sist.com.vo.ReplyVO;
import sist.com.vo.StudentVO;

@Controller
@RequestMapping(value = "jQuery/springAjax")
public class SpringAjaxController {
	private final String path = "/jQuery/springAjax/";

	@Autowired
	private StudentDao dao;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "studAjax.do")
	public String selectStudentAction(Model model) throws IllegalArgumentException, IllegalAccessException,
			InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {

		List<StudentVO> list = dao.selectAllStudent();
		// Gson gson = new Gson(); //dependency 필요.
		// JSONParser jsonParser = new JSONParser();
		JSONArray jsonArray = new JSONArray();

		System.out.println(list);

		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = convertToMap(list.get(i));
			System.out.println("Vo -> Map");
			System.out.println(map);

			//SuppressWarnings("unchecked")
			jsonArray.add(new JSONObject(map));
			
			
			StudentVO convertValueObject = convertToValueObject(map, StudentVO.class);
			System.out.println("Map -> Vo");
			System.out.println(convertValueObject);
		}
		model.addAttribute("jsonList", jsonArray);
		System.out.println(jsonArray);
		model.addAttribute("Message", "AjaxJsonAction");
		return path + "AppEx1Result";

	}

	@ResponseBody
	@RequestMapping(value = "mapAjax.do")
	public HashMap<String, String> ajaxMapAction() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", "BLUE");
		map.put("pass", "1234");
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "objectAjax.do")
	public ReplyVO objectAjaxAction() {
		ReplyVO rv = new ReplyVO();
		rv.setNo(10);
		rv.setJob("Student");
		return rv;
	}

	public Map<String, Object> convertToMap(Object obj) throws IllegalArgumentException, IllegalAccessException {
		if (obj == null)
			return Collections.emptyMap();

		Map<String, Object> convertMap = new HashMap<>();

		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			convertMap.put(field.getName(), field.get(obj));
		}

		return convertMap;
	}

	public <T> T convertToValueObject(Map<String, Object> map, Class<T> clazz)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		if (clazz == null)
			throw new NullPointerException("Class cannot be null in covertToValueObject Method");

		T instance = clazz.getConstructor().newInstance();

		if (map == null || map.isEmpty())
			return instance;

		for (Map.Entry<String, Object> entrySet : map.entrySet()) {
			Field[] fields = clazz.getDeclaredFields();

			System.out.println("--- entrySet ---");
			System.out.println(entrySet);

			for (Field field : fields) {
				field.setAccessible(true);

				String fieldName = field.getName();

				try {
					// key -> value가 Null일 경우 에러 발생!
					boolean isSameType = entrySet.getValue().getClass().equals(field.getType());
					boolean isSameName = entrySet.getKey().equals(fieldName);

					if (isSameType && isSameName) {
						field.set(instance, map.get(fieldName));
					}
				} catch (NullPointerException e) {
					System.out.println("isSameType 값은 null입니다.");
				} // try - catch

			}
		}

		return instance;
	}
}
