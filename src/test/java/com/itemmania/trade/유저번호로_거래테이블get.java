package com.itemmania.trade;

import com.itemmania.service.tradeService.detailsTrade.TradeSellerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 유저번호로_거래테이블get {


    @Autowired
    private TradeSellerService tradeSellerService;


    @Test
    public void get테이블(){
//        tradeSellerService.getTradeSeller("5");
    }

}
