package sist.com.di.basic5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
// default scope pattern "singletone"
public class WebController {
	
	@Autowired	//Autowired : Spring 기반, Inject : Java 기반.
	@Qualifier(value="q2")	//action.xml 에 p1, p2 있음..., Resource(name="action2") Annotation으로 대체 가능.
	private ActionMessage actionMessage;	//WebController가 ActionMessage를 의존한다!

	public WebController() {
		super();
		System.out.println("WebController()");
		//System.out.println(viewJs());
	}

	public String viewJs() {
		return this.actionMessage.toString();
	}
	
	//	getter, setter
	public ActionMessage getActionMessage() {
		return actionMessage;
	}
	
	@Required
	@Autowired
	// Resource(name="action1")으로 Qualifier(value="q1")을 대체할 수 있다.
	public void setActionMessage(@Qualifier(value="q1") ActionMessage actionMessage) {
		System.out.println("before setter : " + viewJs());
		this.actionMessage = actionMessage;
		System.out.println("after setter : " + viewJs());
	}
}

/*
Open Declaration :
org.springframework.beans.factory.annotation.Qualifier
구분자!!

@Target(value={ANNOTATION_TYPE, FIELD, METHOD, PARAMETER, TYPE})
어노테이션 작성 가능 위치.
@Retention(value=RUNTIME)
어노테이션 지속 시간 결정.
@Documented
Java Docs에 문서화 여부를 결정.
@Inherited
자식클래스에 상속 결정.

This annotation may be used on a field or parameter as a qualifier forcandidate beans when autowiring. 
It may also be used to annotate other custom annotations that can then in turn be used as qualifiers.
이 주석은 autowire될 때 강압적인 한정자로 필드 또는 파라미터에서 사용할 수 있습니다. 
또한 다른 사용자 지정 주석에 주석을 달고 차례로 한정자로 사용할 수 있습니다.

Since:2.5
Author:
	Mark Fisher
	Juergen Hoeller
See Also:
	Autowired
*/

/*
Open Declaration :  
org.springframework.beans.factory.annotation.Required
필수요소!!

@Target(value={METHOD})
@Retention(value=RUNTIME)

Marks a method (typically a JavaBean setter method) as being 'required': 
that is, the setter method must be configured to be dependency-injected with a value. 
메서드(일반적으로 JavaBean 세터 메서드)를 '필수'로 표시합니다. 
즉, 세터 메서드는 값을 가진 종속성으로 구성되어야 합니다.

Please do consult the javadoc for the RequiredAnnotationBeanPostProcessorclass 
(which, by default, checks for the presence of this annotation).
RequiredAnnotationBeanPostProcessor 클래스의 javadoc을 참조하십시오. 
기본적으로 이 주석이 있는지 확인합니다.

Since:2.0
Author:
	Rob HarropSee 
Also:
	RequiredAnnotationBeanPostProcessor
*/

/*
Open Declaration :  
package javax.inject.Inject

@Target({ METHOD, CONSTRUCTOR, FIELD })
@Retention(RUNTIME)
@Documented

Identifies injectable constructors, methods, and fields. May apply to static as well as instance members. 
An injectable member may have any access modifier (private, package-private, protected, public). 
Constructors are injected first, followed by fields, and then methods. 
Fields and methods in superclasses are injected before those in subclasses. 
Ordering of injection among fields and among methods in the same class is not specified.

<p>Injectable constructors are annotated with {@code @Inject} and accept zero or more dependencies as arguments. 
{@code @Inject} can apply to at most one constructor per class.

주입 가능한 생성자, 메서드, 필드를 나타낸다. 
static과 인스턴스 멤버에도 적용 가능하다. 
주입 가능한 멤버는 어떠한 접속 제어자를 가질 수 있다 (private, package-private, protected, public). 
생성자, 필드, 메서드 순으로 주입된다. 슈퍼클래스에 있는 필드와 메서드가 서브 클래스에 있는 것들보다 먼저 주입된다. 
같은 클래스에 있는 필드와 메서드 간에 주입 순서는 지정되지 않음. 

<p> 주입 가능한 생성자들은 {@code @Inject} 로 주석이 되고 0 또는 그 이상의 종속성을 인수로 수락함.  
{@code @Inject}는 클래스 당 최대 1개의 생성자에 적용할 수 있음.
*/