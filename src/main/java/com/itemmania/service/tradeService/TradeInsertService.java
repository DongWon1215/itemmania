package com.itemmania.service.tradeService;

import com.itemmania.domain.trade.Trade_insert_VO;
import com.itemmania.entity.TradeEntity;
import com.itemmania.repository.TradeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class TradeInsertService {

    @Autowired
    TradeRepository tradeRepository;


    public int setTradeInsert(Trade_insert_VO tradeInsert) {
        return tradeRepository.save(tradeInsert);


    }


}
