package com.itemmania.trade;

import com.itemmania.entity.TradeEntity;
import com.itemmania.repository.TradeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 거래예약insert {


    @Autowired
    private TradeRepository tradeRepository;
    @Test
    public TradeEntity setTradeInsert(TradeEntity tradeEntity) {
        return tradeRepository.save(tradeEntity);
    }
}
