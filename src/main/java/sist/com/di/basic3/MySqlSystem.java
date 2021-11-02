package sist.com.di.basic3;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class MySqlSystem implements DataBaseSystem{

	@Override
	public void connect() {
		System.out.println("MySqlSystem connect");
	}

	@Override
	public void find() {
		System.out.println("MySqlSystem find");	
	}

	@Override
	public void result() {
		System.out.println("MySqlSystem result");		
	}

}
