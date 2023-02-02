package com.itemmania.repository;

import com.itemmania.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository  extends JpaRepository<ItemEntity, Integer> {
}
