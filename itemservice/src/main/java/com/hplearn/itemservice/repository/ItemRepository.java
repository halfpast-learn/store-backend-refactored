package com.hplearn.itemservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hplearn.itemservice.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
