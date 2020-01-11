package com.myproject.trackit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.myproject.trackit.domain.*;
import com.myproject.trackit.service.FileUploadService;
import com.myproject.trackit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myproject.trackit.service.ProjectService;
import com.myproject.trackit.service.TaskService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private UserService userService;

	@GetMapping(path="/projects/{id}")
	public ProjectResponseMobile getProject(@PathVariable Long id) {

		Project p = projectService.getProject(id);

		ProjectResponseMobile projectRes = new ProjectResponseMobile(p.getId(),p.getProjectName(),p.getClientId(),p.getDeadline(),p.getStatus(),p.getEngineerId(),p.getConstructorId(),p.getProjectMgrId());

		projectRes.setEngName(p.getEngineerId() != null ? userService.getById(Long.parseLong(p.getEngineerId())).getName(): "");
		projectRes.setConName(p.getConstructorId() != null ? userService.getById(Long.parseLong(p.getConstructorId())).getName(): "");
		projectRes.setManName(p.getProjectMgrId() != null ? userService.getById(Long.parseLong(p.getProjectMgrId())).getName(): "");
		projectRes.setCliName(p.getClientId() != null ? userService.getById(Long.parseLong(p.getClientId())).getName(): "");

		return projectRes;
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
	public ProjectResponse saveProject(@ModelAttribute Project project) {
		project.setStatus("ongoing");
		Project saveProject = projectService.saveProject(project);

		try {
			fileUploadService.saveProjectFile(project.getImage(), project.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ProjectResponse(Long.toString(saveProject.getId()));
	}
	
	@PutMapping(path="/projects")
	public Project updateProject(@RequestBody Project project) {

		Project savedProject = projectService.saveProject(project);

		try {
			fileUploadService.saveProjectFile(project.getImage(), savedProject.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return savedProject;
	}
	
	@DeleteMapping(path="/projects/{id}")
	public Map<String, Boolean> deleteProject(@PathVariable Long id) {
		projectService.deleteProject(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@GetMapping(path="/projects/mobile")
	public List<ProjectResponseMobile> getAllProjectsMobile() {
		return projectService.getAllProjects().stream().map(p -> {
			ProjectResponseMobile projectRes = new ProjectResponseMobile(
					p.getId(), p.getProjectName(), p.getClientId(), p.getDeadline(), p.getStatus(), p.getEngineerId(), p.getConstructorId(),
					p.getProjectMgrId());

			projectRes.setEngName(p.getEngineerId() != null ? userService.getById(Long.parseLong(p.getEngineerId())).getName(): "");
			projectRes.setConName(p.getConstructorId() != null ? userService.getById(Long.parseLong(p.getConstructorId())).getName(): "");
			projectRes.setManName(p.getProjectMgrId() != null ? userService.getById(Long.parseLong(p.getProjectMgrId())).getName(): "");

			return projectRes;
		}).collect(Collectors.toList());
	}
	
	//project list provide
	@GetMapping(path="/projects")
	public List<Project> getAllProjects() {
		return projectService.getAllProjects();
	}
	
	@GetMapping(path="/projects/user/{userId}")
	public List<Project> getProjectsByUserId(@PathVariable String userId) {
		return projectService.getProjectsByUserId(userId);
	}

	@GetMapping(path="/projects/client/{clientId}")
	public List<Project> getProjectsByClientId(@PathVariable String clientId) {
		return projectService.getProjectsByClientId(clientId);
	}

	@GetMapping(path="/projects/constructor/{constroctorId}")
	public List<Project> getProjectsByConstructorId(@PathVariable String constroctorId) {
		return projectService.getProjectsByConstructorId(constroctorId);
	}

	@GetMapping(path="/projects/engineer/{engineerId}")
	public List<Project> getProjectsByEngineerId(@PathVariable String engineerId) {
		return projectService.getProjectsByEngineerId(engineerId);
	}

	@GetMapping(path="/projects/projectmgr/{mgrId}")
	public List<Project> getProjectsByProjectMgrId(@PathVariable String mgrId) {
		return projectService.getProjectsByProjectMgrId(mgrId);
	}
//==========================================================================================
	@GetMapping(path="/projects/mobile/client/{clientId}")
	public List<ProjectResponseMobile> getProjectsByClientIdMobile(@PathVariable String clientId) {
		return projectService.getProjectsByClientId(clientId).stream().map(p -> {
			ProjectResponseMobile projectRes = new ProjectResponseMobile(
					p.getId(), p.getProjectName(), p.getClientId(), p.getDeadline(), p.getStatus(), p.getEngineerId(), p.getConstructorId(),
					p.getProjectMgrId());

			projectRes.setEngName(p.getEngineerId() != null ? userService.getById(Long.parseLong(p.getEngineerId())).getName(): "");
			projectRes.setConName(p.getConstructorId() != null ? userService.getById(Long.parseLong(p.getConstructorId())).getName(): "");
			projectRes.setManName(p.getProjectMgrId() != null ? userService.getById(Long.parseLong(p.getProjectMgrId())).getName(): "");

			return projectRes;
		}).collect(Collectors.toList());
	}

	@GetMapping(path="/projects/mobile/constructor/{constroctorId}")
	public List<ProjectResponseMobile> getProjectsByConstructorIdMobile(@PathVariable String constroctorId) {
		return projectService.getProjectsByConstructorId(constroctorId).stream().map(p -> {
			ProjectResponseMobile projectRes = new ProjectResponseMobile(
					p.getId(), p.getProjectName(), p.getClientId(), p.getDeadline(), p.getStatus(), p.getEngineerId(), p.getConstructorId(),
					p.getProjectMgrId());

			projectRes.setEngName(p.getEngineerId() != null ? userService.getById(Long.parseLong(p.getEngineerId())).getName(): "");
			projectRes.setConName(p.getConstructorId() != null ? userService.getById(Long.parseLong(p.getConstructorId())).getName(): "");
			projectRes.setManName(p.getProjectMgrId() != null ? userService.getById(Long.parseLong(p.getProjectMgrId())).getName(): "");

			return projectRes;
		}).collect(Collectors.toList());
	}

	@GetMapping(path="/projects/mobile/engineer/{engineerId}")
	public List<ProjectResponseMobile> getProjectsByEngineerIdMobile(@PathVariable String engineerId) {
		return projectService.getProjectsByEngineerId(engineerId).stream().map(p -> {
			ProjectResponseMobile projectRes = new ProjectResponseMobile(
					p.getId(), p.getProjectName(), p.getClientId(), p.getDeadline(), p.getStatus(), p.getEngineerId(), p.getConstructorId(),
					p.getProjectMgrId());

			projectRes.setEngName(p.getEngineerId() != null ? userService.getById(Long.parseLong(p.getEngineerId())).getName(): "");
			projectRes.setConName(p.getConstructorId() != null ? userService.getById(Long.parseLong(p.getConstructorId())).getName(): "");
			projectRes.setManName(p.getProjectMgrId() != null ? userService.getById(Long.parseLong(p.getProjectMgrId())).getName(): "");

			return projectRes;
		}).collect(Collectors.toList());
	}

	@GetMapping(path="/projects/mobile/projectmgr/{mgrId}")
	public List<ProjectResponseMobile> getProjectsByProjectMgrIdMobile(@PathVariable String mgrId) {
		return projectService.getProjectsByProjectMgrId(mgrId).stream().map(p -> {
			ProjectResponseMobile projectRes = new ProjectResponseMobile(
					p.getId(), p.getProjectName(), p.getClientId(), p.getDeadline(), p.getStatus(), p.getEngineerId(), p.getConstructorId(),
					p.getProjectMgrId());

			projectRes.setEngName(p.getEngineerId() != null ? userService.getById(Long.parseLong(p.getEngineerId())).getName(): "");
			projectRes.setConName(p.getConstructorId() != null ? userService.getById(Long.parseLong(p.getConstructorId())).getName(): "");
			projectRes.setManName(p.getProjectMgrId() != null ? userService.getById(Long.parseLong(p.getProjectMgrId())).getName(): "");

			return projectRes;
		}).collect(Collectors.toList());
	}

}
