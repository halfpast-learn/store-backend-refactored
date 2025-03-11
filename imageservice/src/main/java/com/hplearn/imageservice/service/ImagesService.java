package com.hplearn.imageservice.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class ImagesService {
    public Resource findOne(Long id) {
        String imagePath = String.format("images/%d.jpg", id);
        File file = new File(imagePath);
        
        if (!file.exists()) {
            file = new File("images/missing.jpg");
        }
        
        return new FileSystemResource(file);
    }
} 