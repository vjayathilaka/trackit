package com.myproject.trackit.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String status;
	
	private String taskName;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="project_id")
	private Project project;

	@ManyToOne(cascade=CascadeType.MERGE)
	private User assignee;

	private String comment;

	public Task() {}

	public Task(String name) {
		this.taskName = name;
	}

	public Task(String taskName, Project project, User assignee, String comment, String status) {
		this.taskName = taskName;
		this.project = project;
		this.assignee = assignee;
		this.comment = comment;
		//modification
		this.status = status;
	}

	public Task(long id, String status) {
		this.id = id;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return taskName;
	}

	public void setName(String name) {
		this.taskName = name;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
