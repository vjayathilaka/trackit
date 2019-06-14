package com.myproject.trackit.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.trackit.domain.Comment;
import com.myproject.trackit.domain.Task;
import com.myproject.trackit.repository.CommentRepository;
import com.myproject.trackit.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private CommentRepository commentRepository;
	
	public Task getById(Long id) {	
		Optional<Task> optionalTask = taskRepository.findById(id);
		
		if(optionalTask.isPresent())
			return optionalTask.get();
		else
			return null;
	}
	
	public List<Comment> getCommentsById(Long taskId) {
		Optional<Task> optionalTask = taskRepository.findById(taskId);
		if(optionalTask.isPresent())
			return optionalTask.get().getComments();
		else
			return null;
	}
	
	@Transactional
	public Comment saveTaskComment(Long taskId, Comment comment) {
		Task task = getById(taskId);
		if(task == null) return null;
		comment.setTask(task);
		Comment saveComment = commentRepository.save(comment);
		
		task.getComments().add(saveComment);
		
		taskRepository.save(task);
		
		return saveComment;
			
	}
	
	public List<Task> getByProjectIdAndStatus(Long projectId, String status){
		List<Task> tasks = taskRepository.findByProjectIdAndStatus(projectId, status);
		return tasks;
	}

	public Task getByUserId(Long userId) {
		return null;
	}

	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

}
