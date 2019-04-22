package com.myproject.trackit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.trackit.domain.Comment;
import com.myproject.trackit.domain.Task;
import com.myproject.trackit.service.TaskService;

@CrossOrigin(origins = "http://localhost:4200")
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

}
