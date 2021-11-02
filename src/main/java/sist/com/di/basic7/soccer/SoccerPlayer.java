package sist.com.di.basic7.soccer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // 의존성을 주입받는 객체도 Bean으로 등록되어야 한다.
public class SoccerPlayer {

	// Dependency Inject : Spring Framework
	@Autowired
	@Qualifier("nikeBall")
	private SoccerBall ball;
	
	// return type  : void -> String
	public String playSoccer() {
		return "축구선수가 공을 찼다! \n" + this.ball.touchBall();
	}
	
}
