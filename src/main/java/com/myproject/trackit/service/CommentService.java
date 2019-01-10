package com.myproject.trackit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.trackit.domain.Comment;
import com.myproject.trackit.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public Comment getById(Long id) {
		Optional<Comment> optionalComment = commentRepository.findById(id);
		
		if(optionalComment.isPresent())
			return optionalComment.get();
		else 
			return null;
	}
	
	public Comment saveComment(Comment comment) {
		return commentRepository.save(comment);
	}

}
