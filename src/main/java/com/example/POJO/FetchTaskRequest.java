package com.example.POJO;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class FetchTaskRequest {

	public String state;
	
	public String assigned;
	
	public String assignee;

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
