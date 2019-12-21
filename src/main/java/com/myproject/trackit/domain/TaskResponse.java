package com.myproject.trackit.domain;

public class TaskResponse {
	private String taskId;
	
    private String taskName;
    private String taskAssignee;
    private String taskComment;
    private String taskResourceId;
    //modification
    private String taskStatus;

	public TaskResponse(String taskId) {
		this.taskId = taskId;
	}
	
	public TaskResponse(String taskId, String taskName, String taskAssignee, String taskComment,
			String taskResourceId, String taskStatus) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskAssignee = taskAssignee;
		this.taskComment = taskComment;
		this.taskResourceId = taskResourceId;
		//
		this.taskStatus = taskStatus;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskAssignee() {
		return taskAssignee;
	}

	public void setTaskAssignee(String taskAssignee) {
		this.taskAssignee = taskAssignee;
	}

	public String getTaskComment() {
		return taskComment;
	}

	public void setTaskComment(String taskComment) {
		this.taskComment = taskComment;
	}

	public String getTaskResourceId() {
		return taskResourceId;
	}

	public void setTaskResourceId(String taskResourceId) {
		this.taskResourceId = taskResourceId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	//modification
	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
}
