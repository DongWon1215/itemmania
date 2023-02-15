package com.itemmania.service.tradeService.detailsTrade;

import com.itemmania.entity.TradeEntity;
import com.itemmania.repository.TradeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j2
@Service
public class GetSellListService {

    @Autowired
    private TradeRepository tradeRepository;

    public List<TradeEntity> getList(int userNum){
log.info("유저넘"+userNum);
        List<TradeEntity> byTradeIsSuccessNullAndSellerMileage_userNum_userNum = tradeRepository.findByTradeIsSuccessNullAndSellerMileage_UserNum_UserNum(userNum);

       log.info("get내역서비스"+byTradeIsSuccessNullAndSellerMileage_userNum_userNum);
        return byTradeIsSuccessNullAndSellerMileage_userNum_userNum;

    }
}
