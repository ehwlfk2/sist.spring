package sist.com.di.basic9;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Action {
	@Setter
	private String actionName;
	@Setter
	private int actionCount;
	@Setter
	private String actionMode;
	
	/*
	public Action() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Action(String actionName, int actionCount, String actionMode) {
		super();
		this.actionName = actionName;
		this.actionCount = actionCount;
		this.actionMode = actionMode;
	}
	@Override
	public String toString() {
		return "Action [actionName=" + actionName + ", actionCount=" + actionCount + ", actionMode=" + actionMode + "]";
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public int getActionCount() {
		return actionCount;
	}
	public void setActionCount(int actionCount) {
		this.actionCount = actionCount;
	}
	public String getActionMode() {
		return actionMode;
	}
	public void setActionMode(String actionMode) {
		this.actionMode = actionMode;
	}
	*/
	
}
