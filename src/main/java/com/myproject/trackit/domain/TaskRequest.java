package com.myproject.trackit.domain;

public class TaskRequest {
	private String taskId;
    private String taskName;
    private String taskAssignee;
    private String taskComment;
    private String assignedProject;
    private boolean isDone;
    
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
	public String getAssignedProject() {
		return assignedProject;
	}
	public void setAssignedProject(String assignedProject) {
		this.assignedProject = assignedProject;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}

}
