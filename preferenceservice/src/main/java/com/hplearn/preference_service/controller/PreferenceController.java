package com.hplearn.preference_service.controller;

import com.hplearn.preference_service.dto.PreferenceDto;
import com.hplearn.preference_service.service.PreferenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/preferences")
@RequiredArgsConstructor
public class PreferenceController {

    private final PreferenceService preferenceService;

    @GetMapping
    public List<PreferenceDto> findAll() {
        return preferenceService.findAll();
    }

    @GetMapping("/{id}")
    public PreferenceDto findOne(@PathVariable Long id) {
        return preferenceService.findOne(id);
    }

    @GetMapping("/name/{name}")
    public PreferenceDto findByName(@PathVariable String name) {
        return preferenceService.findByName(name);
    }

    @GetMapping("/{id}/tags")
    public List<Long> findTags(@PathVariable Long id) {
        return preferenceService.findTags(id);
    }
}
