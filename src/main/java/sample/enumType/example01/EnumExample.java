package sample.enumType.example01;

public class EnumExample {

	//기존에 상수를 정의하는 방법
	public static final String MALE = "MALE";
	public static final String FEMALE = "FEMALE";
	
	public static void main(String[] args) {
		String gender1;
		
		
		gender1 = EnumExample.MALE;
		gender1 = EnumExample.FEMALE;
		
		/* MALE, FEMALE이 아닌 상수 값이 할당 될 때 
		 * 컴파일시 에러가 나지 않음 = "This is Problem" */
		gender1 = "boy";
		
		System.out.println(gender1);
		
		Gender gender2;
		gender2 = Gender.MALE;
		gender2 = Gender.FEMALE;
		
		/* 컴파일시 의도하지 않는 상수 값을 체크할 수 있다.
		 * Enum으로 정의한 상수값만 할당 받을 수 있다. */
		//gender2 = "boy";
		
		System.out.println(gender2);
		
		if(Gender.MALE.toString() == "MALE") System.out.println("MALE 같다!");
		
		for(Gender gender : Gender.values())
			System.out.println(gender);
	}
}
