package sist.com.di.basic8;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="sist.com.di.basic8")
public class ConfigMan {
	
	@Bean
	public Man getMan() {
		return new Man("경진이", 28);
	}
}
