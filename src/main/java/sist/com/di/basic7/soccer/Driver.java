package sist.com.di.basic7.soccer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("sist/com/di/basic7/server.xml");
		
		System.out.println(context);
		
		String[] names = context.getBeanDefinitionNames();
		for(int i = 0 ; i < names.length ; i++) {
			System.out.println(i + " : " + names[i]);
		}
		
		System.out.println("");
		SoccerPlayer player = (SoccerPlayer) context.getBean("soccerPlayer");
		System.out.println(player.playSoccer());
	}
}
