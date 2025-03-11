package com.hplearn.itemservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hplearn.itemservice.dto.ItemDto;
import com.hplearn.itemservice.entity.Item;
import com.hplearn.itemservice.repository.ItemRepository;
import com.hplearn.itemservice.mapper.ItemMapper;

import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemDto saveItem(ItemDto itemDto) {
        val item = itemMapper.toEntity(itemDto);
        val savedItem = itemRepository.save(item);
        return itemMapper.toDto(savedItem);
    }

    public List<ItemDto> getItems() {
        val items = itemRepository.findAll();
        return items.stream().map(this::convertToDto).toList();
    }

    public ItemDto getItem(Long id) {
        return itemRepository.findById(id)
                .map(this::convertToDto)
                .orElse(null);
    }

    public ItemDto updateItem(Long id, ItemDto itemDto) {
        val existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem == null) {
            return null;
        }

        itemMapper.updateEntityFromDto(itemDto, existingItem);
        val updatedItem = itemRepository.save(existingItem);
        return itemMapper.toDto(updatedItem);
    }

    public void deleteItem(Long id) {
        if (!itemRepository.existsById(id)) {
            return;
        }
        itemRepository.deleteById(id);
    }

    private ItemDto convertToDto(Item item) {
        return itemMapper.toDto(item);
    }

    public List<ItemDto> getItemsByTags(List<Long> tagIds) {
        return itemRepository.findAll().stream()
                .filter(item -> hasMatchingTag(item, tagIds))
                .map(this::convertToDto)
                .toList();
    }

    private boolean hasMatchingTag(Item item, List<Long> tagIds) {
        return item.getTagIds().stream().anyMatch(tagIds::contains);
    }
}
