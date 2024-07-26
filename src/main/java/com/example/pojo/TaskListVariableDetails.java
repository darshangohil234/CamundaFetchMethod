package com.example.pojo;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskListVariableDetails {

	public static class TaskListVariableRequest {

		private Object requestBody;

		public Object getRequestBody() {
			return requestBody;
		}

		public void setRequestBody(Object requestBody) {
			this.requestBody = requestBody;
		}
	}
	
	public static class GetTaskResponse {		

		private String id;
		
		private String name;
		
		private String taskDefinitionId;
		
		private String processName;
		
		private String creationDate;
		
		private String completionDate;
		
		private String assignee;
		
		private String taskState;
		
		private String formKey;
		
		private String isFirst;
		
		private String formId;
		
		private String formVersion;
		
		private String dueDate;
		
		private String processInstanceKey;
		
		private String processDefinitionKey;
		
		private String followUpDate;

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
		
	}

	public static class TaskListVariableResponse {

		ResponseEntity<Object> taskDetails;

		public ResponseEntity<Object> getTaskDetails() {
			return taskDetails;
		}

		public void setTaskDetails(ResponseEntity<Object> taskDetails) {
			this.taskDetails = taskDetails;
		}

		public String getProcessDefinitionKey() {
			return processDefinitionKey;
		}

		public void setProcessDefinitionKey(String processDefinitionKey) {
			this.processDefinitionKey = processDefinitionKey;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public JSONObject getJsonResponse() {
			return jsonResponse;
		}

		public void setJsonResponse(JSONObject jsonResponse) {
			this.jsonResponse = jsonResponse;
		}

		public String getFormId() {
			return formId;
		}

		public void setFormId(String formId) {
			this.formId = formId;
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

		String processDefinitionKey;

		public String message;

		public JSONObject jsonResponse;

		public String formId;

		String assignee;

		String taskState;
	}

}
