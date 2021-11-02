package sample.custom.annotation;

import java.lang.reflect.Field;

// Custom Annotation이 사용된 클래스들을 '모아서' 출력합니다.
public class FruitInfoUtil {

	public static void getFruitInfo(Class<?> clazz) {
		
		String strFruitName = "과이 이름 : ";
		String strFruitColor = "과이 이름 : ";
		String strFruitProvider = "과일 파는 곳 > ";
		
		/* 
		 * Annotation이 어디서 사용되었는지 알아야 하기 때문에, 
		 * Reflection API인 class.getDeclaredFields()를 사용하여 Annotation이 사용된 클래스들을 전부 가져오게 됩니다. 
		 * 
		 * Annotation을 만들 때 @Retention(RetentionPolicy.RUNTIME) 속성을 줬기 때문에 Reflection을 사용할 수 있습니다.
		 * 만약, @Retention(RetentionPolicy.CLASS) 속성을 줬다면, Reflection을 사용할 수 없습니다.
		 */
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields) {
			if(field.isAnnotationPresent(FruitName.class)) {
				FruitName fruitName = field.getAnnotation(FruitName.class);
				strFruitName += fruitName.value();
				System.out.println(strFruitName);
			}else if(field.isAnnotationPresent(FruitColor.class)) {
				FruitColor fruitColor = field.getAnnotation(FruitColor.class);
				strFruitColor += fruitColor.fruitColor().toString();
				System.out.println(strFruitColor);
			}else if(field.isAnnotationPresent(FruitProvider.class)) {
				FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
				strFruitProvider += "\n  과일 파는 곳의 ID : " + fruitProvider.id() + 
						"\n  지점 이름 : " + fruitProvider.name() + 
						"\n  지점 주소 : " + fruitProvider.address();
				System.out.println(strFruitProvider);
			}
		}//for
	}//getFruitInfo method
}//FruitInfoUtil class
