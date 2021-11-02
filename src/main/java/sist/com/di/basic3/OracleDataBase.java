package sist.com.di.basic3;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class OracleDataBase implements DataBaseSystem{

	public OracleDataBase() {
		System.out.println("OracleDataBase()");
	}
	
	// 생성(생성자 실행) 후에 Spring에서 사용하기 전에 따로 호출하는 것으로 보임. 
	@PostConstruct
	public void initDataBase() {
		System.out.println("initDataBase");
	}
	
	@Override
	public void connect() {
		System.out.println("OracleDataBase connect");
	}

	@Override
	public void find() {
		System.out.println("OracleDataBase find");
	}

	@Override
	public void result() {
		System.out.println("OracleDataBase result");
	}

}
