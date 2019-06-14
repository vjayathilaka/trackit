package com.myproject.trackit.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.trackit.domain.Issue;

import com.myproject.trackit.repository.IssueRepository;

@Service
public class IssueService {
	
	@Autowired
	private IssueRepository issueRepository;
	
	
	public Issue getById(Long id) {	
		Optional<Issue> optionalIssue = issueRepository.findById(id);
		if(optionalIssue.isPresent())
			return optionalIssue.get();
		else
			return null;
	}
	

	
	public Issue getByUserId(Long userId) {
		return null;
	}

	public Issue saveIssue(Issue issue) {
		return issueRepository.save(issue);
	}
	

}
