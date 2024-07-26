package com.example.pojo;

import org.springframework.stereotype.Component;

@Component
public class FetchTaskRequest {

	private String state;
	
	private String assigned;
	
	private String assignee;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAssigned() {
		return assigned;
	}

	public void setAssigned(String assigned) {
		this.assigned = assigned;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
}


