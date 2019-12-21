package com.myproject.trackit.domain;

public class ProjectResponse {
	
	private String id;
	//

	private String clientId;
	private String deadline;
	private String status;
	private String engineerId;
	private String constructorId;

	public ProjectResponse(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	////
	private String projectName;
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEngineerId() {
		return engineerId;
	}

	public void setEngineerId(String engineerId) {
		this.engineerId = engineerId;
	}

	public String getConstructorId() {
		return constructorId;
	}

	public void setConstructorId(String constructorId) {
		this.constructorId = constructorId;
	}
}
