package com.hplearn.imageservice.controller;

import com.hplearn.imageservice.service.ImagesService;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImagesController {
    private final ImagesService imagesService;

    public ImagesController(ImagesService imagesService) {
        this.imagesService = imagesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> findOne(@PathVariable Long id) {
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imagesService.findOne(id));
    }
} 