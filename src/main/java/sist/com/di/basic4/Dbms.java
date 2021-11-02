package sist.com.di.basic4;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component(value="OracleDBMS")
@Scope("singleton")
public class Dbms {
	@Value("localhost:1521:orcl") //생성될 때 값을 초기화해주는 Annotation
	private String url;
	
	@Value("apple")
	private String account;

	@Value("500")
	private int connect;

	@Value("-1")
	private int waitTime;
	
	public Dbms() {
		System.out.println("Dbms()");
		System.out.println("Dbms.url : " + url);
	}

	@PostConstruct //생성될 때 생성자 호출 후에 실행시킨다는 Annotation.
	private void connect() {
		// Value Annotation이 실행되는 구간.
		System.out.println("Dbms.connect()...");
		System.out.println("Dbms.url : " + url);
	}
	
	@Override
	public String toString() {
		return "Dbms [url=" + url + ", account=" + account + ", connect=" + connect + ", waitTime=" + waitTime + "]";
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}


/*
org.springframework.stereotype.Component


@Target(value={TYPE})
@Retention(value=RUNTIME)
@Documented


Indicates that an annotated class is a "component".Such classes are considered as candidates for auto-detectionwhen using annotation-based configuration and classpath scanning. 

Other class-level annotations may be considered as identifyinga component as well, typically a special kind of component:e.g. the @Repository annotation or AspectJ's @Aspect annotation.
*/
