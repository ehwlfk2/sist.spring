package sample.enumType.example02;

public class MainFuits {
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		System.out.println("main");
		
		Fruits fruits = Fruits.APPLE;
		
		for(Fruits fruit : fruits.values())
			System.out.println(fruit);
		
		System.out.println(fruits.getLabel());
		
		if(fruits.toString() == "APPLE")
			System.out.println("match APPLE!!");
		if(fruits.name() == "APPLE")
			System.out.println("name으로 matching!");
		
		switch (fruits) {
		case APPLE:
			System.out.println("match APPLE!!!");
			break;
		default:
			System.out.println("no match...	");
			break;
		}
		
		System.out.println(fruits.valueOf("APPLE"));
		System.out.println(fruits.name());
		
		
		System.out.println("--- --- --- ---");
		System.out.println(fruits.valueOfLabel("1"));
	}
}