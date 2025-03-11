package com.hplearn.itemservice.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.hplearn.itemservice.dto.ItemDto;
import com.hplearn.itemservice.service.ItemService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/items")
@Tag(name = "Item", description = "Item API")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ItemDto saveItem(@RequestBody ItemDto itemDto) {
        return itemService.saveItem(itemDto);
    }

    @GetMapping
    public List<ItemDto> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/{id}")
    public ItemDto getItem(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    @GetMapping("/by-tags")
    public List<ItemDto> getItemsByTags(@RequestParam List<Long> tagIds) {
        return itemService.getItemsByTags(tagIds);
    }

    @PutMapping("/{id}")
    public ItemDto updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        return itemService.updateItem(id, itemDto);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
