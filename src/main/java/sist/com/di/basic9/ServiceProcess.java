package sist.com.di.basic9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/*
@Data is ...
1. Getter
2. Setter
3. RequiredArgsConstructor // NonNull인 매개변수들로 이루어진 생성자.
4. ToString
5. EqualsAndHashCode // Equal 조건.
6. lombok.Value
*/ 

@Data
@NoArgsConstructor // 기본생성자
@RequiredArgsConstructor // 필요한 매개변수 (@NonNull) 로 이뤄진 매개변수
@AllArgsConstructor // 모든 매게
public class ServiceProcess {
	@NonNull
	private String serviceName;
	private int serviceTime;
	@NonNull
	private String serviceKind;
	
	public static void main(String[] args) {
		System.out.println("main");
		ServiceProcess serviceProcess01 = new ServiceProcess();
		System.out.println(serviceProcess01);
		ServiceProcess serviceProcess02 = new ServiceProcess("Do", "human");
		System.out.println(serviceProcess02);
		ServiceProcess serviceProcess03 = new ServiceProcess("Do", 123, "human");
		System.out.println(serviceProcess03);
	}

}
