package com.myproject.trackit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.myproject.trackit.domain.Project;
import com.myproject.trackit.domain.Task;
import com.myproject.trackit.domain.TaskRequest;
import com.myproject.trackit.domain.TaskResponse;
import com.myproject.trackit.domain.User;
import com.myproject.trackit.service.TaskService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping(path="/tasks/{id}")
	public Task getTaskById(@PathVariable Long id) {		
		return taskService.getById(id);
	}

	@GetMapping(path="/tasks")
	public List<Task> getTaskById() {
		return taskService.getAllTasks();
	}

	@GetMapping(path="/tasks/user/{userId}")
	public Task getTaskByUserId(@PathVariable Long userId) {		
		return taskService.getByUserId(userId);
	}
	
	@PutMapping(path="/tasks")
	public Task updateTask(@RequestBody TaskRequest taskRes) {
		Task task = taskService.getById(Long.parseLong(taskRes.getTaskId()));

		String status = task.getStatus();
		if(taskRes.getIsDone())
			status = "completed";
		task.setStatus(status);

		return taskService.saveTask(task);
	}
	
	@PostMapping(path="/tasks")
	public TaskResponse saveTask(@RequestBody TaskRequest tr) {
		Task task = new Task(tr.getTaskName(), new Project(Long.parseLong(tr.getAssignedProject())), 
				new User(Long.parseLong(tr.getTaskAssignee())), tr.getTaskComment(),tr.getTaskStatus());
		task.setStatus("ongoing");
		Task saveTask = taskService.saveTask(task);
		
		return new TaskResponse(Long.toString(saveTask.getId()));
	}
	
	//my
	@PostMapping(path="/tasks/ui/")
	public Task saveTask(@RequestBody Task task) {
	
		return taskService.saveTask(task);
		
	}

	@DeleteMapping(path="/tasks/{id}")
	public Map<String, Boolean> deleteById(@PathVariable Long id) {
		taskService.deleteTask(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
