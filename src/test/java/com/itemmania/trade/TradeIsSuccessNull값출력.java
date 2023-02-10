package com.itemmania.trade;


import com.itemmania.entity.TradeEntity;
import com.itemmania.repository.TradeRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Log4j2
@SpringBootTest
public class TradeIsSuccessNull값출력 {

    @Autowired
    private TradeRepository tradeRepository;

    @Test
    public void aa() {

        List<TradeEntity> byTradeIsSuccessIsNull = tradeRepository.findAllByTradeIsSuccessNull();

        log.info("byTradeIsSuccessIsNull?" + byTradeIsSuccessIsNull);


    }
}
