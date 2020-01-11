package com.myproject.trackit.domain;

import java.io.File;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.web.multipart.MultipartFile;

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
	private String projectMgrId;

	@Transient
	private MultipartFile image;
	
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

	public String getProjectMgrId() {
		return projectMgrId;
	}

	public void setProjectMgrId(String projectMgrId) {
		this.projectMgrId = projectMgrId;
	}


	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
}
