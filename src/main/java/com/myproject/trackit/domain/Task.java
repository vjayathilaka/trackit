package com.myproject.trackit.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String taskName;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@ManyToOne
	private User creator;
	
	@ManyToOne
	private User assignee;
	
	@ManyToOne
	
	private Task parentTask;
	
	@JsonManagedReference
	@OneToMany(mappedBy="task")
	private List<Comment> comments;
	
	private String comment;
	
	private String status;
	
	public Task() {}

	public Task(String name) {
		this.taskName = name;
	}
	
	public Task(Long taskId, String status) {
		this.id = taskId;
		this.status = status;
		
	}

	public Task(String taskName, Project project, User assignee, String comment) {
		this.taskName = taskName;
		this.project = project;
		this.assignee = assignee;
		this.comment = comment;
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

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public Task getParentTask() {
		return parentTask;
	}

	public void setParentTask(Task parentTask) {
		this.parentTask = parentTask;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
