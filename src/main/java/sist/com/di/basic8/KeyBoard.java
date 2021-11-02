package sist.com.di.basic8;

public class KeyBoard {
	private String maker;
	private int price;
	
	// constructor
	public KeyBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KeyBoard(String maker, int price) {
		super();
		this.maker = maker;
		this.price = price;
	}

	// toString
	@Override
	public String toString() {
		return "KeyBoard [maker=" + maker + ", price=" + price + "]";
	}
	
	// getter, setter	
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
