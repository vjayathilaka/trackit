package com.myproject.trackit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.trackit.domain.Comment;
import com.myproject.trackit.domain.Project;
import com.myproject.trackit.domain.Task;
import com.myproject.trackit.domain.TaskRequest;
import com.myproject.trackit.domain.TaskResponse;
import com.myproject.trackit.domain.User;
import com.myproject.trackit.service.TaskService;

@CrossOrigin
@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping(path="/tasks/{id}")
	public Task getTaskById(@PathVariable Long id) {		
		return taskService.getById(id);
	}
	
	@GetMapping(path="/tasks/{taskId}/comments")
	public List<Comment> getCommentsByTaskId(@PathVariable Long taskId) {
		return taskService.getCommentsById(taskId);
	}
	
	@PostMapping(path="tasks/{taskId}/comments")
	public Comment saveTaskComment(@PathVariable Long taskId, @RequestBody Comment comment) {
		return taskService.saveTaskComment(taskId, comment);
	}
	
	@GetMapping(path="/tasks/user/{userId}")
	public Task getTaskByUserId(@PathVariable Long userId) {		
		return taskService.getByUserId(userId);
	}
	
	@PutMapping(path="tasks")
	public Task updateTask(@RequestBody TaskRequest taskRes) {
		String status = "";
		if(taskRes.getIsDone()) 
			status = "completed";
		
		Task task = new Task(Long.parseLong(taskRes.getTaskId()), status);
		return taskService.saveTask(task);
	}
	
	@PostMapping(path="tasks")
	public TaskResponse saveTask(@RequestBody TaskRequest tr) {
		Task task = new Task(tr.getTaskName(), new Project(Long.parseLong(tr.getAssignedProject())), 
				new User(Long.parseLong(tr.getTaskAssignee())), tr.getTaskComment());
		Task saveTask = taskService.saveTask(task);
		
		return new TaskResponse(Long.toString(saveTask.getId()));
	}

}
