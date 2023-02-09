package com.itemmania.service.tradeService;


import com.itemmania.entity.MileageEntity;
import com.itemmania.repository.MileageRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    MileageRepository mileageRepository;

    public MileageEntity getSeller_Consumer_mileage(int Seller_Consumer) {
        /*판매자, 구매자 마일리지 내역PK조회*/
        log.info("getSellerMileage" + Seller_Consumer);
        MileageEntity top1ByUserNum_userNum = mileageRepository.findTop1ByUserNum(Seller_Consumer);
        /*마일리지테이블에 담긴 userNum이 없으면 데이터 못받아옴*/
        log.info("top1ByUserNum_userNum" + top1ByUserNum_userNum);
        return top1ByUserNum_userNum;
    }

}
