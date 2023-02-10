package com.itemmania.repository;

import com.itemmania.entity.GameEntity;
import com.itemmania.entity.TradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TradeRepository extends JpaRepository<TradeEntity, Integer> {


    /*tradeIsSuccess 값이 null인 것만 조회(거래 진행중 상태값 : null)*/
    List<TradeEntity> findAllByTradeIsSuccessNull();





}
