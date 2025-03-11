package com.hplearn.itemservice.entity;

import lombok.Data;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(nullable = true)
    private String description;

    @Column(nullable = true)
    private Double price;

    @ElementCollection
    @CollectionTable(name = "tag_item", joinColumns = @JoinColumn(name = "item_id"))
    @Column(name = "tag_id")
    private List<Long> tagIds;
}
