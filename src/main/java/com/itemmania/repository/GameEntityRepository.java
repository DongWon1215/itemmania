package com.itemmania.repository;


import com.itemmania.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameEntityRepository extends JpaRepository<GameEntity, Integer> {
    List<GameEntity> findAllBy();


}
