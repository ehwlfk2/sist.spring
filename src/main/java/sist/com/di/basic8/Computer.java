package sist.com.di.basic8;

import org.springframework.stereotype.Component;

@Component
public class Computer {
	private String cpu;
	private String maker;
	private String graphicCard;
	private int price;
	
	// contructor
	public Computer() {
		super();
	}
	public Computer(String cpu, String maker, String graphicCard, int price) {
		super();
		this.cpu = cpu;
		this.maker = maker;
		this.graphicCard = graphicCard;
		this.price = price;
	}
	
	// tostring
	@Override
	public String toString() {
		return "Computer [cpu=" + cpu + ", maker=" + maker + ", graphicCard=" + graphicCard + ", price=" + price + "]";
	}	
	
	// getter, setter
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getGraphicCard() {
		return graphicCard;
	}
	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
