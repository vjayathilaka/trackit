package com.myproject.trackit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.trackit.domain.Issue;
import com.myproject.trackit.domain.Project;
import com.myproject.trackit.domain.ProjectResponse;
import com.myproject.trackit.domain.Task;
import com.myproject.trackit.repository.ProjectRepository;
import com.myproject.trackit.response.UserLoginResponse;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	//
//	@Autowired
//	UserLoginResponse loginResponse;
//	@Autowired
//	ProjectResponse projectResponce;

	public Project getProject(Long id) {
		Optional<Project> optionalProject = projectRepository.findById(id);
		if(optionalProject.isPresent())
			return optionalProject.get();
		else
			return null;
	}
	
	public List<Task> getProjectTasks(Long projectId) {		
		Optional<Project> optionalProject = projectRepository.findById(projectId);
		if(optionalProject.isPresent())
			return optionalProject.get().getTasks();
		else
			return null;
		
	}
	
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}
	
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}

	public void deleteProject(Long projectId) {
		projectRepository.deleteById(projectId);
	}

	public List<Project> getProjectsByUserId(String userId) {
		return projectRepository.findByConstructorId(userId);
	}

	public List<Issue> getProjectIssues(Long projectId) {
		Optional<Project> optionalProject = projectRepository.findById(projectId);
		if(optionalProject.isPresent())
			return optionalProject.get().getIssues();
		else
			return null;
	}
	
	//provide projects using client id
	
	public List<Project> getAllProjects(Long clientId){
		
//		if(loginResponse.getUserId() == projectResponce.getClientId(){
//			return projectRepository.findAll();
//		}
//		Optional<Project> clientProject = projectRepository.findById(clientId);
//		if(clientProject.)
		return projectRepository.findAll();
	}
	

	public List<Project> getProjectsByClientId(String clientId) {
		return projectRepository.findByClientId(clientId);
	}

	public List<Project> getProjectsByConstructorId(String constroctorId) {
		return projectRepository.findByConstructorId(constroctorId );
	}

	public List<Project> getProjectsByEngineerId(String engineerId) {
		return projectRepository.findByEngineerId(engineerId);
	}

	public List<Project> getProjectsByProjectMgrId(String mgrId) {
		return projectRepository.findByProjectMgrId(mgrId);
	}
}
