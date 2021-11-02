package sist.com.di.basic7.soccer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoccerController {
	@Autowired // SoccerPlayer라는 타입을 가진 Bean을 찾아서 주입시킨다.
	private SoccerPlayer soccerPlayer;
	
	@RequestMapping("/soccer")
	public String soccerDriver() {
		return soccerPlayer.playSoccer();
	}
}
