package sample.enumType.example02;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum Fruits {
	// constants
	APPLE("1"),
	GRAPE("2"),
	ORANGE("3");
	
	// field
	private String label;
	
	// default constructor
	private Fruits() {
		System.out.println("Call Constructor : " + this);
	}	
	
	Fruits(String label){
		System.out.println("Call Constructor(fruits) : " + this);
		this.label = label;
		// fruits가 1,2,3일 때 해당 상수와 매칭된다.
	}

	/*
	 * above code => string enum pattern
	 * private final String APPLE = "1";
	 * private final String GRAPE = "2";
	 * private final String ORANGE = "3";
	 */
	
	/*
	public static Fruits valueOfLabel(String label) {
		for(Fruits e : values()) {
			if(e.label.equals(label)) {
				return e;
			}
		}
		return null;
	}
	*/
	
	private final static Map<String, Fruits> BY_LABEL = new HashMap<>();
	static {
		for (Fruits e : values()) {
			BY_LABEL.put(e.label, e);
		}
	}
	public Fruits valueOfLabel(String label) {
		return BY_LABEL.get(label);
	}
	
}
