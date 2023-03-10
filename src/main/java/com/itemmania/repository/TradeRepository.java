package com.itemmania.repository;

import com.itemmania.entity.TradeEntity;
import com.itemmania.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TradeRepository extends JpaRepository<TradeEntity, Integer> {


    /*tradeIsSuccess 값이 null인 것만 조회(거래 진행중 상태값 : null)*/
    @Query("select t from TradeEntity t where t.tradeIsSuccess is null ")
    List<TradeEntity> findByTradeIsSuccessNull();

    TradeEntity findByTradeNum(Integer tradeNum);


    @Transactional
    @Modifying
    @Query("update TradeEntity t set t.tradeAmount = 0, t.tradeIsSuccess = 0, t.tradeTime = ?1 where t.tradeNum = ?2")
    int updateTradeAmountAndTradeIsSuccessAndTradeTimeByTradeNum(LocalDateTime tradeTime, Integer tradeNum);

    @Transactional
    @Modifying
    @Query("update TradeEntity t set t.tradeTime = ?1, t.tradeIsSuccess = 1 where t.tradeNum = ?2")
    int updateTradeTimeAndTradeIsSuccessByTradeNum(LocalDateTime tradeTime, Integer tradeNum);


    @Query("select t from TradeEntity t where t.consumerMileage.userNum = ?1 ")
    List<TradeEntity> findBySellerMileage_UserNum_UserNum(String userName);

    // 구매
    List<TradeEntity> findByTradeIsSuccessNullAndConsumerMileage_UserNum_UserNum(int userNum);

    // 판매
    List<TradeEntity> findByTradeIsSuccessNullAndSellerMileage_UserNum_UserNum(int userNum);
}
