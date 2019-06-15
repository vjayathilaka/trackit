package com.myproject.trackit.domain;

public class FileUploadResponse {
	
	private String fileName;

	public FileUploadResponse(String fileName) {
		super();
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
