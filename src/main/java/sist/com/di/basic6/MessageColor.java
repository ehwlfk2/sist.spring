package sist.com.di.basic6;

public class MessageColor {

	public String getColorMessage(String id) {
		String message = null;

		switch (id) {
		case "Red":
			message = "무지개의 첫번 째 색입니다.";
			break;
		case "Orange":
			message = "무지개의 두번 째 색입니다.";
			break;
		case "Yellow":
			message = "무지개의 세번 째 색입니다.";
			break;
		case "Green":
			message = "무지개의 네번 째 색입니다.";
			break;
		case "Blue":
			message = "무지개의 다섯번 째 색입니다.";
			break;
		case "Indigo":
			message = "무지개의 여섯번 째 색입니다.";
			break;
		case "Purple":
			message = "무지개의 일곱번 째 색입니다.";
			break;
		default:
			message = "무지개에 없는 색입니다.";
		}

		return message;
	}
}
