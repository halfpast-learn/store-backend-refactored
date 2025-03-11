package com.hplearn.preference_service.mapper;

import com.hplearn.preference_service.dto.PreferenceDto;
import com.hplearn.preference_service.entity.Preference;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PreferenceMapper {

    @Mapping(source = "preferenceId", target = "preferenceId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "tags", target = "tags")
    PreferenceDto toDto(Preference preference);

    @Mapping(source = "preferenceId", target = "preferenceId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "tags", target = "tags")
    Preference toEntity(PreferenceDto preferenceDto);
}
