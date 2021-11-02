package sample.custom.annotation;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Apple {

	@FruitName("APPLE")
	private String appleName;
	
	@FruitColor(fruitColor = FruitColor.Color.RED)
	private String appleColor;
	
	@FruitProvider(id=1, name="HomePlus", address="Seoul")
	private String appleProvider;
	
}
