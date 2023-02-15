package com.itemmania;

import com.itemmania.entity.BoardEntity;
import com.itemmania.entity.MileageEntity;
import com.itemmania.entity.TradeEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.BoardRepository;
import com.itemmania.repository.MileageRepository;
import com.itemmania.repository.TradeRepository;
import com.itemmania.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class tradeTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private MileageRepository mileageRepository;

    @Test
    public void sellerTradeTest(){

        UserEntity seller = userRepository.findById(2).get();
        UserEntity consumer = userRepository.findById(1).get();

        BoardEntity boardEntity = boardRepository.findById(1).get();

        MileageEntity sellMileage = MileageEntity.builder()
                .mileageIn(boardEntity.getSalePrice())
                .mileageOut(0)
                .mileageType("판매")
                .userNum(seller)
                .mileageTime(LocalDateTime.now())
                .mileageDescription("#판매 : " + boardEntity.getBoardNum())
                .build();

        MileageEntity consumerMileage = MileageEntity.builder()
                .mileageIn(0)
                .mileageOut(boardEntity.getSalePrice())
                .mileageType("구매")
                .userNum(consumer)
                .mileageTime(LocalDateTime.now())
                .mileageDescription("#구매 : " + boardEntity.getBoardNum())
                .build();

        TradeEntity tradeEntity = TradeEntity.builder()
                .tradeTime(LocalDateTime.now())
                .tradeUnit(1)
                .tradeAmount(boardEntity.getSalePrice())
                .sellerMileage(sellMileage)
                .consumerMileage(consumerMileage)
                .boardNum(boardEntity)
                .build();

        mileageRepository.save(sellMileage);
        mileageRepository.save(consumerMileage);
        tradeRepository.save(tradeEntity);

    }
}
