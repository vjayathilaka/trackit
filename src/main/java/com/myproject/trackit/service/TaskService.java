package com.myproject.trackit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.trackit.domain.Task;
import com.myproject.trackit.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Task getById(Long id) {	
		Optional<Task> optionalTask = taskRepository.findById(id);
		
		if(optionalTask.isPresent())
			return optionalTask.get();
		else
			return null;
	}

	public List<Task> getByProjectIdAndStatus(Long projectId, String status){
		List<Task> tasks = taskRepository.findByProjectIdAndStatus(projectId, status);
		return tasks;
	}

	public Task getByUserId(Long userId) {
		return null;
	}

	public Task saveTask(Task task) {
		task.setStatus("ongoing");
		return taskRepository.save(task);
	}
	
//	//angular save task
//	public Task createTask(Task task) {
//		Task saveTask = taskRepository.save(task);
//		return saveTask;
//	}

	

}
