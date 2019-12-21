package com.myproject.trackit.controller;

import java.util.UUID;
import java.nio.ByteBuffer;
import java.util.List;

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

//import antlr.collections.List;

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
		
		if(issueRequest.getName()== null || issueRequest.getName().isEmpty()) {
//			String uniqueID = UUID.randomUUID().toString();
			
			  UUID uniqueID = UUID.randomUUID();
			  long l = ByteBuffer.wrap(uniqueID.toString().getBytes()).getLong();
			  Long.toString(l, Character.MAX_RADIX);
			
			String issueName = "Issue for project id- "+issueRequest.getProjectId()+"-"+l;
			issueRequest.setName(issueName);
		}
			
		
		Issue issue = new Issue(issueRequest.getName(), issueRequest.getComment(),
			new Project(Integer.parseInt(issueRequest.getProjectId())));
		Issue saveIssue = issueService.saveIssue(issue);
		
		return new IssueResponse(Long.toString(saveIssue.getId()));
	}
	
	//get all issues
	@GetMapping(path="/issues")
	public List<Issue> getAllIssues() {
		return issueService.getAllIssues();
	}

	

}
