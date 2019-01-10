package com.myproject.trackit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.trackit.domain.Project;
import com.myproject.trackit.domain.Task;
import com.myproject.trackit.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	
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

}
