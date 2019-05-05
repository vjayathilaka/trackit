package com.myproject.trackit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.trackit.domain.Project;
import com.myproject.trackit.domain.Task;
import com.myproject.trackit.service.ProjectService;

@CrossOrigin()
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
	
	// ongoing / completed
	@GetMapping(path="/projects/{projectId}/tasks/{status}")
	public List<Task> getProjectTasksByStatus(@PathVariable Long projectId, @PathVariable String status){
		return projectService.getProjectTasksByStatus(projectId, status);
	}
	
	@PostMapping(path="/projects")
	public Project saveProject(@RequestBody Project project) {
		return projectService.saveProject(project);
	}
	
	@PutMapping(path="/projects")
	public Project updateProject(@RequestBody Project project) {
		return projectService.saveProject(project);
	}
	
	@DeleteMapping(path="/projects/{id}")
	public Map<String, Boolean> deleteProject(@PathVariable Long id) {
		projectService.deleteProject(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping(path="/projects")
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}
	
	@GetMapping(path="/projects/user/{userId}")
	public List<Project> getProjectsByUserId(@PathVariable Long userId) {
		return projectService.getProjectsByUserId(userId);
	}

}
