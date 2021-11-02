package sist.com.di.basic8;

public class SystemNode {
	Computer computer;
	KeyBoard keyBoard;
	
	public SystemNode(Computer computer, KeyBoard keyBoard) {
		this.computer = computer;
		this.keyBoard = keyBoard;
	}

	@Override
	public String toString() {
		return "SystemNode [computer=" + computer + ", keyBoard=" + keyBoard + "]";
	}
	
	public Computer getComputer() {
		return computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public KeyBoard getKeyBoard() {
		return keyBoard;
	}

	public void setKeyBoard(KeyBoard keyBoard) {
		this.keyBoard = keyBoard;
	}
}
