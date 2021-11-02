package sist.com.aop.basic2;

public class SystemFileImp implements SystemFile {

	@Override
	public void fileUpload() {
		System.out.println("fileUpload() run!");
	}

	@Override
	public void fileValidate() {
		System.out.println("fileValidate() run!");
	}

	@Override
	public void fileCheck() {
		System.out.println("fileCheck() run!");
	}

}
