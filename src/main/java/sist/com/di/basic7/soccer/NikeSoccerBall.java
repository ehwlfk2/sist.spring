package sist.com.di.basic7.soccer;

import org.springframework.stereotype.Component;

@Component("nikeBall") // nikeBall�̶� �̸��� ���� Bean���� ���
public class NikeSoccerBall implements SoccerBall {
	
	@Override
	public String touchBall() {
		return "나이키 축구공이 굴러간다!";
	}
}
