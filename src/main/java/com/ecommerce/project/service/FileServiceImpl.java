package com.ecommerce.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        // Getting file names of current / original file
        String originalFileName = file.getOriginalFilename();

        // Generating a unique file name
        String randomId = UUID.randomUUID().toString();
        String fileName = randomId.concat(originalFileName.substring(originalFileName.lastIndexOf('.')));
        // Using pathSeparator to guarantee OS portability
        String filePath = path + File.separator + fileName;

        // Checking if path exist and create if not
        File folder = new File(path);
        if (!folder.exists()) folder.mkdir();

        // Uploading to server
        Files.copy(file.getInputStream(), Paths.get(filePath));

        // Returning file name
        return fileName;
    }
}
