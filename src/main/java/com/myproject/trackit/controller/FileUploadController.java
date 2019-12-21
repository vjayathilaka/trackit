package com.myproject.trackit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.trackit.domain.FileUploadResponse;
import com.myproject.trackit.service.FileUploadService;
import com.myproject.trackit.service.TaskService;

@CrossOrigin
@RestController
public class FileUploadController {
	
	private FileUploadService fileUploadService;
	
	private TaskService taskService;
	
	@Autowired
	public FileUploadController(FileUploadService fileUploadService, TaskService taskService) {
		this.fileUploadService = fileUploadService;
		this.taskService = taskService;
	}
	
	@PostMapping(value="/file/upload")
	public FileUploadResponse handleFileUpload(@RequestParam("projectFloorPlan") MultipartFile file) throws IOException {
		String fileName = fileUploadService.saveFile(file);
		
		return new FileUploadResponse(fileName);
	}
	
	
	public void handleFileDownload(@RequestParam("file") MultipartFile file) throws IOException {
		fileUploadService.saveFile(file);
	}
	
	@GetMapping(value="/file/download/task/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
    	
		Long taskId = Long.parseLong(fileName);
		
		Long projectId = taskService.getById(taskId).getProject().getId();
		
		String projectMapFileName = "floorPlan_"+projectId;
		
		return getFileResource(projectMapFileName, request);
    }
	
	@GetMapping(value="/file/download/issue/{fileName}")
    public ResponseEntity<Resource> downloadIssueFile(@PathVariable String fileName, HttpServletRequest request) {
    	
		Long id = Long.parseLong(fileName);

		String projectMapFileName = Long.toString(id);
		
		return getFileResource(projectMapFileName, request);
    }
	
	@GetMapping(value="/file/download/project/{fileName}")
    public ResponseEntity<Resource> downloadProjectFileMobile(@PathVariable String fileName, HttpServletRequest request) {
    	
		Long id = Long.parseLong(fileName);

		String projectMapFileName = "floorPlan_"+id;
		
		return getFileResource(projectMapFileName, request);
    }
	
	@GetMapping(value="/app/file/download/issue/{fileName}")
    public ResponseEntity<InputStreamResource> downloadIssueImage(@PathVariable String fileName, HttpServletRequest request) throws IOException {

		Resource imgFile = fileUploadService.loadFileAsResource(fileName);
	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.IMAGE_PNG)
	                .body(new InputStreamResource(imgFile.getInputStream()));
    }
	
	@GetMapping(value="/app/file/download/project/{fileName}")
    public ResponseEntity<InputStreamResource> downloadProjectImage(@PathVariable String fileName, HttpServletRequest request) throws IOException {
		Long id = Long.parseLong(fileName);

		String projectMapFileName = "floorPlan_"+id;
		
		Resource imgFile = fileUploadService.loadFileAsResource(projectMapFileName);
	        return ResponseEntity
	                .ok()
	                .contentType(MediaType.IMAGE_PNG)
	                .body(new InputStreamResource(imgFile.getInputStream()));
    }
	
	private ResponseEntity<Resource> getFileResource(String fileName , HttpServletRequest request) {
        Resource resource = fileUploadService.loadFileAsResource(fileName);

        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
	}

}
