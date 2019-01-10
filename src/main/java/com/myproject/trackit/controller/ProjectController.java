package com.myproject.trackit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.trackit.domain.Project;
import com.myproject.trackit.domain.Task;
import com.myproject.trackit.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;

	@GetMapping(path="/projects/{id}")
	public Project getProject(@PathVariable Long id) {	
		return projectService.getProject(id);	
	}
	
	@GetMapping(path="/projects/{projectId}/tasks")
	public List<Task> getProjectTasks(@PathVariable Long projectId){
		return projectService.getProjectTasks(projectId);
	}
	
	@PostMapping(path="/projects")
	public Project saveProject(@RequestBody Project project) {
		return projectService.saveProject(project);
	}
	
	@PutMapping(path="/projects")
	public Project updateProject(@RequestBody Project project) {
		return projectService.saveProject(project);
	}
	
	public Project deleteProject() {
		return null;
	}
	
	@GetMapping(path="/projects")
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}

}
