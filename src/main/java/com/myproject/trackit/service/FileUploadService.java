package com.myproject.trackit.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadService {
	
	private static final String FILE_DIRECTORY = "file:///D:/hiranProject/fileDir/";
	
	private static final String FILE_DIRECTORY1 = "D:/hiranProject/fileDir/";

	public void saveFile(MultipartFile file) throws IOException {
		
		Path filePath = Paths.get(FILE_DIRECTORY1 + file.getOriginalFilename());
		
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		
	}
	
    public Resource loadFileAsResource(String fileName) {
        try {
        	URI uri = new URI(FILE_DIRECTORY  + fileName);

            Resource resource = new UrlResource(uri);
            if(resource.exists()) {
                return resource;
            } else {
                throw new Exception();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

}