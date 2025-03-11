package com.hplearn.tagservice.mapper;

import com.hplearn.tagservice.dto.TagDto;
import com.hplearn.tagservice.entity.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TagMapper {

    @Mapping(target = "itemIds", expression = "java(tag.getItemIds().stream().map(Long::longValue).collect(java.util.stream.Collectors.toList()))")
    TagDto toDto(Tag tag);

    @Mapping(target = "itemIds", ignore = true)
    Tag toEntity(TagDto tagDto);
}
