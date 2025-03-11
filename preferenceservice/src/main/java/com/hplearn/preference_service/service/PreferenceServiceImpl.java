package com.hplearn.preference_service.service;

import com.hplearn.preference_service.dto.PreferenceDto;
import com.hplearn.preference_service.entity.Preference;
import com.hplearn.preference_service.repository.PreferenceRepository;
import com.hplearn.preference_service.mapper.PreferenceMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository preferenceRepository;
    private final PreferenceMapper preferenceMapper;

    @Override
    public List<PreferenceDto> findAll() {
        return preferenceRepository.findAll().stream()
                .map(preferenceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PreferenceDto findOne(Long id) {
        return preferenceRepository.findById(id)
                .map(preferenceMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Preference not found"));
    }

    @Override
    public PreferenceDto findByName(String name) {
        return preferenceRepository.findByName(name)
                .map(preferenceMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Preference not found"));
    }

    @Override
    public List<Long> findTags(Long preferenceId) {
        return preferenceRepository.findById(preferenceId)
                .map(Preference::getTags)
                .orElseThrow(() -> new EntityNotFoundException("Preference not found"));
    }
}
