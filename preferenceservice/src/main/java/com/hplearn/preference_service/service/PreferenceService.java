package com.hplearn.preference_service.service;

import com.hplearn.preference_service.dto.PreferenceDto;

import java.util.List;

public interface PreferenceService {

    List<PreferenceDto> findAll();

    PreferenceDto findOne(Long id);

    PreferenceDto findByName(String name);

    List<Long> findTags(Long preferenceId);
}
