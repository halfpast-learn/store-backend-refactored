package com.hplearn.tagservice.service;

import com.hplearn.tagservice.dto.TagDto;
import com.hplearn.tagservice.repository.TagRepository;
import com.hplearn.tagservice.mapper.TagMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    @Override
    public TagDto createTag(TagDto tagDto) {
        val tag = tagMapper.toEntity(tagDto);
        val savedTag = tagRepository.save(tag);
        return tagMapper.toDto(savedTag);
    }

    @Override
    public TagDto getTagById(Long id) {
        val tag = tagRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tag not found"));
        return tagMapper.toDto(tag);
    }

    @Override
    public List<TagDto> getAllTags() {
        return tagRepository.findAll().stream()
                .map(tagMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TagDto updateTag(Long id, TagDto tagDto) {
        val existingTag = tagRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tag not found"));
        existingTag.setName(tagDto.getName());
        val updatedTag = tagRepository.save(existingTag);
        return tagMapper.toDto(updatedTag);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Set<Long> findItemIdsByTags(List<Long> tagIds) {
        return tagRepository.findItemIdsByTagIds(tagIds);
    }

}
