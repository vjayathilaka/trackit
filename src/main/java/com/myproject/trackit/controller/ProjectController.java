package com.myproject.trackit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.trackit.domain.Issue;
import com.myproject.trackit.domain.IssueResponse;
import com.myproject.trackit.domain.Project;
import com.myproject.trackit.domain.ProjectResponse;
import com.myproject.trackit.domain.Task;
import com.myproject.trackit.domain.TaskResponse;
import com.myproject.trackit.service.ProjectService;
import com.myproject.trackit.service.TaskService;

@CrossOrigin()
@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TaskService taskService;

	@GetMapping(path="/projects/{id}")
	public Project getProject(@PathVariable Long id) {	
		return projectService.getProject(id);	
	}
	
	@GetMapping(path="/projects/{projectId}/tasks")
	public List<Task> getProjectTasks(@PathVariable Long projectId){
		return projectService.getProjectTasks(projectId);
	}
	
	@GetMapping(path="/projects/{projectId}/issues")
	public List<IssueResponse> getProjectIssues(@PathVariable Long projectId){
		List<Issue> issues =  projectService.getProjectIssues(projectId);
	
		List<IssueResponse> issueResponses = issues.stream().map(i ->  new IssueResponse(Long.toString(i.getId()), i.getName(), i.getComment()))
			.collect(Collectors.toList());
		
		return issueResponses;
	}
	
	// ongoing / completed
	@GetMapping(path="/projects/{projectId}/tasks/{status}")
	public List<TaskResponse> getProjectTasksByStatus(@PathVariable Long projectId, @PathVariable String status){
		List<Task> tasks = taskService.getByProjectIdAndStatus(projectId, status);
		
		List<TaskResponse> taskResponse = tasks.stream()
			.map(task -> new TaskResponse(
					Long.toString(task.getId()),
					task.getName(), 
					task.getAssignee().getName(),
					task.getComment(),
					task.getStatus(),
					""))
			.collect(Collectors.toList());
		
		return taskResponse;
		
	}
	
	@PostMapping(path="/projects")
	public ProjectResponse saveProject(@RequestBody Project project) {
		project.setStatus("ongoing");
		Project saveProject = projectService.saveProject(project);
		return new ProjectResponse(Long.toString(saveProject.getId()));
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
	
	//project list provide
	@GetMapping(path="/projects")
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}
	
	@GetMapping(path="/projects/user/{userId}")
	public List<Project> getProjectsByUserId(@PathVariable Long userId) {
		return projectService.getProjectsByUserId(userId);
	}

}
