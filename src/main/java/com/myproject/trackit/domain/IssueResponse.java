package com.myproject.trackit.domain;

public class IssueResponse {
	private String issueId;
    private String issueName;
    private String issueComment;

	public IssueResponse(String issueId) {
		this.issueId = issueId;
	}

	public IssueResponse(String issueId, String issueName, String issueComment) {
		super();
		this.issueId = issueId;
		this.issueName = issueName;
		this.issueComment = issueComment;
	}



	public String getIssueName() {
		return issueName;
	}



	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}



	public String getIssueComment() {
		return issueComment;
	}



	public void setIssueComment(String issueComment) {
		this.issueComment = issueComment;
	}



	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}
}
