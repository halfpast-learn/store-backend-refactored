package com.hplearn.tagservice.service;

import com.hplearn.tagservice.dto.TagDto;
import java.util.List;
import java.util.Set;

public interface TagService {

    TagDto createTag(TagDto tagDto);

    TagDto getTagById(Long id);

    List<TagDto> getAllTags();

    TagDto updateTag(Long id, TagDto tagDto);

    void deleteTag(Long id);

    Set<Long> findItemIdsByTags(List<Long> tagIds);
}
