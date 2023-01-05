package com.itemmania.repository;

import com.itemmania.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity,Integer> {

}
