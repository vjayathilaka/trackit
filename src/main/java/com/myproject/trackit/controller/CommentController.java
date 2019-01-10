package com.myproject.trackit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.trackit.domain.Comment;
import com.myproject.trackit.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping(path="/comments/{id}")
	public Comment getById(@PathVariable Long id) {
		return commentService.getById(id);
	}
	
	@PostMapping(path="/comments")
	public Comment saveComment(@RequestBody Comment comment) {
		return commentService.saveComment(comment);
	}

}
