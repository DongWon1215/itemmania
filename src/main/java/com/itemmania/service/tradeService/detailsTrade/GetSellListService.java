package com.itemmania.service.tradeService.detailsTrade;

import com.itemmania.entity.TradeEntity;
import com.itemmania.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSellListService {

    @Autowired
    private TradeRepository tradeRepository;

    public List<TradeEntity> getList(int userNum){
        return tradeRepository.findByTradeIsSuccessNullAndSellerMileage_UserNum_UserNum(userNum);
    }
}
