
package sist.com.di.basic7.soccer;
import org.springframework.stereotype.Component;

@Component("adidasBall") // adidasBall�̶� �̸��� ���� Bean���� ��� 
public class AdidasSoccerBall implements SoccerBall{
	
	@Override
	public String touchBall() {
		return "아디다스 축구공이 굴러간다!";
	}
}
