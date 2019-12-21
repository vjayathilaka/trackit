package com.myproject.trackit.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String projectName;
	private String clientId;
	private String deadline;
	private String status;
	private String engineerId;
	private String constructorId; 
	
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, mappedBy="project", fetch=FetchType.LAZY)
	private List<Task> tasks;
	
	@JsonManagedReference
	@OneToMany(cascade=CascadeType.ALL, mappedBy="project", fetch=FetchType.LAZY)
	private List<Issue> issues;
	
	public Project() {}
	
	public String getEngineerId() {
		return engineerId;
	}



	public void setEngineerId(String engineerId) {
		this.engineerId = engineerId;
	}

	public Project(long id) {
		this.id = id;
	}

	public Project(String name) {
		this.projectName = name;
	}
	
	public Project(String name, List<Task> tasks) {
		this.projectName = name;
		this.tasks = tasks;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String name) {
		this.projectName = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getConstructorId() {
		return constructorId;
	}

	public void setConstructorId(String constructorId) {
		this.constructorId = constructorId;
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

	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

}
