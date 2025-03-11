package com.hplearn.itemservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.hplearn.itemservice.dto.ItemDto;
import com.hplearn.itemservice.entity.Item;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(target = "itemId", ignore = true)
    Item toEntity(ItemDto dto);

    ItemDto toDto(Item entity);

    void updateEntityFromDto(ItemDto dto, @MappingTarget Item entity);
}
