package com.itemmania.repository;

import com.itemmania.entity.BoardEntity;
import com.itemmania.entity.GameServerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameServerEntityRepository extends JpaRepository<GameServerEntity, Integer> {


    List<GameServerEntity> findAllBy();


    // 게임 출력 (검색시 사용)
//    List<GameServerEntity> findByGameServerNum(int serverNum);



}