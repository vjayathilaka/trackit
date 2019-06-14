package com.myproject.trackit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.trackit.domain.Issue;
import com.myproject.trackit.domain.IssueRequest;
import com.myproject.trackit.domain.IssueResponse;
import com.myproject.trackit.domain.Project;
import com.myproject.trackit.service.IssueService;

import antlr.collections.List;

@CrossOrigin
@RestController
public class IssueController {
	
	
	@Autowired
	private IssueService issueService;
	
	@GetMapping(path="/issues/{id}")
	public Issue getIssueById(@PathVariable Long id) {		
		return issueService.getById(id);
	}
	
	@PutMapping(path="issues")
	public Issue updateIssue(@RequestBody Issue issue) {
		return issueService.saveIssue(issue);
	}
	
	@PostMapping(path="issues")
	public IssueResponse saveIssue(@RequestBody IssueRequest issueRequest) {
		Issue issue = new Issue(issueRequest.getName(), issueRequest.getComment(),
			new Project(Integer.parseInt(issueRequest.getProjectId())));
		Issue saveIssue = issueService.saveIssue(issue);
		
		return new IssueResponse(Long.toString(saveIssue.getId()));
	}

	

}
