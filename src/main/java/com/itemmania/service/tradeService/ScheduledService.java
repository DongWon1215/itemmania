package com.itemmania.service.tradeService;


import com.itemmania.entity.MileageEntity;
import com.itemmania.repository.MileageRepository;
import com.itemmania.repository.TradeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ScheduledService {
    /*board_num:10
    seller_mileage:5
    consumer_mileage:6
    trade_amount:1000
    trade_unit:1
    saleNickName:노바*/
    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    MileageRepository mileageRepository;

    public List<MileageEntity> getSeller_Consumer_mileage(int Seller_Consumer) {
        /*판매자, 구매자 마일리지 내역PK조회*/
        log.info("Seller_Consumer"+Seller_Consumer);
        List<MileageEntity> top1ByUserNum_userNum = mileageRepository.findTop1ByUserNum_UserNum(Seller_Consumer)
        log.info("top1ByUserNum_userNum" + top1ByUserNum_userNum);
        return top1ByUserNum_userNum;
    }


}
