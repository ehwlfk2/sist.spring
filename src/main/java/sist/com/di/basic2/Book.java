package sist.com.di.basic2;

public class Book {
	private String name;
	private int price;
	private String author;
	private String publisher;

	// 생성자
	public Book() {
		super();
		System.out.println("Book() - " + name);
	}

	public Book(String name, int price, String author, String publisher) {
		super();
		this.name = name;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		System.out.println("Book(name, price, author, publisher) - " + name);
	}
	
	// 사용자 정의 메서드
	@SuppressWarnings("unused") // bookdi.xml에서 사용함 
	private void initBook() {
		System.out.println("initBook() - " + name);
	}

	@Override
	public String toString() {
		return "Book [price=" + price + ", author=" + author + ", publisher=" + publisher + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
