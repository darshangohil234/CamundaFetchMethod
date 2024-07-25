package com.example.POJO;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FetchTaskResp {
	
	public String id;
	
	public String name;
	
	public String taskDefinitionId;
	
	public String processName;
	
	public String creationDate;
	
	public String completionDate;
	
	public String assignee;
	
	public String taskState;
	
	public String formKey;
	
	public String isFirst;
	
	public String formId;
	
	public String formVersion;
	
	public String dueDate;
	
	public String processInstanceKey;
	
	public String processDefinitionKey;
	
	public String followUpDate;
	
	public List[] sortValues;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaskDefinitionId() {
		return taskDefinitionId;
	}

	public void setTaskDefinitionId(String taskDefinitionId) {
		this.taskDefinitionId = taskDefinitionId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getTaskState() {
		return taskState;
	}

	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}

	public String getFormKey() {
		return formKey;
	}

	public void setFormKey(String formKey) {
		this.formKey = formKey;
	}

	public String getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getFormVersion() {
		return formVersion;
	}

	public void setFormVersion(String formVersion) {
		this.formVersion = formVersion;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getProcessInstanceKey() {
		return processInstanceKey;
	}

	public void setProcessInstanceKey(String processInstanceKey) {
		this.processInstanceKey = processInstanceKey;
	}

	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}

	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
	}

	public String getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(String followUpDate) {
		this.followUpDate = followUpDate;
	}

	public List[] getSortValues() {
		return sortValues;
	}

	public void setSortValues(List[] sortValues) {
		this.sortValues = sortValues;
	}


}
