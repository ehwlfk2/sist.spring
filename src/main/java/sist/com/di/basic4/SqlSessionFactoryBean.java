package sist.com.di.basic4;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SqlSessionFactoryBean {
	// Autowired vs Inject vs Resource - 자세한 것 노트 정리하자.
	@Autowired	// DI 시키는 Annotation. Spring 2.5 이상부터 사용 가능. 1:1 관계(?)
	@Inject		// DI 시키는 Annotation. 일반적인 Java 환경에서도 사용할 수 있다. 1:1 관계(?)
	@Resource(name="OracleDBMS")	// DI Annotation. Annotation 1.0 이상부터 사용. 1:n 관계(?)
	private Dbms dbms; 

	@Override
	public String toString() {
		return "SqlSessionFactoryBean [dbms=" + dbms + "]";
	}
	
}
