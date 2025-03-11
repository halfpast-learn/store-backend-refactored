package com.hplearn.tagservice.controller;

import com.hplearn.tagservice.dto.TagDto;
import com.hplearn.tagservice.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TagDto createTag(@RequestBody TagDto tagDto) {
        return tagService.createTag(tagDto);
    }

    @GetMapping("/{id}")
    public TagDto getTagById(@PathVariable Long id) {
        return tagService.getTagById(id);
    }

    @GetMapping
    public List<TagDto> getAllTags() {
        return tagService.getAllTags();
    }

    @PutMapping("/{id}")
    public TagDto updateTag(@PathVariable Long id, @RequestBody TagDto tagDto) {
        return tagService.updateTag(id, tagDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
    }
}
