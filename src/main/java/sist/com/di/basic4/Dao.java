package sist.com.di.basic4;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Dao {
	
	//Resource(name="sqlSessionFactoryBean")	// Annotation
	@Autowired	// Annotation - Spring 조립기가 이름을 기준으로 matching 해준다. 
	//Inject	// Annotation - (=Autowired)
	/*But! dbaction.xml에서 Class의 <bean>에게 id를 줄 경우 Class명으로 매칭시켜주는 Autowired나 Inject의 경우 에러가 발생!! 
	따라서 반드시 dbaction.xml에 있는 bean id를 주석 처리하거나 id를 class이름과 동일하게 만들어야 한다. */
	private SqlSessionFactoryBean bean;
		
	public Dao() {
		super();
		System.out.println("Dao()...");
	}

	public void select(){
		System.out.println("Dao.select()...");
	}
	
	@PostConstruct
	public void connect() {
		System.out.println("Dao.connect()...");
	}
	
	//getter, setter
	public SqlSessionFactoryBean getBean() {
		return bean;
	}

	public void setBean(SqlSessionFactoryBean bean) {
		this.bean = bean;
	}
}
