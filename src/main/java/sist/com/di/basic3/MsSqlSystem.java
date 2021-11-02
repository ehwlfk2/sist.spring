package sist.com.di.basic3;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class MsSqlSystem implements DataBaseSystem{

	@Override
	public void connect() {
		System.out.println("MsSqlSystem conncet");		
	}

	@Override
	public void find() {
		System.out.println("MsSqlSystem find");		
	}

	@Override
	public void result() {
		System.out.println("MsSqlSystem result");
	}

}
