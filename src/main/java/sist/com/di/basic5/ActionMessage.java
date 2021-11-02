package sist.com.di.basic5;

public class ActionMessage {
	private String message;
	private int count;
	
	//	contructor
	public ActionMessage() {
		super();
		System.out.println("ActionMessage()");
	}
	public ActionMessage(String message, int count) {
		super();
		this.message = message;
		this.count = count;
	}

	//	ToString
	@Override
	public String toString() {
		return "ActionMessage [message=" + message + ", count=" + count + "]";
	}
	
	//	getter, setter
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
