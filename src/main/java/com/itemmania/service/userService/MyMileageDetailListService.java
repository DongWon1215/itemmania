package com.itemmania.service.userService;

import com.itemmania.entity.MileageEntity;
import com.itemmania.repository.BuyRepository;
import com.itemmania.repository.MileageRepository;
import com.itemmania.repository.PayRepository;
import com.itemmania.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MyMileageDetailListService {

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private PayRepository payRepository;

    @Autowired
    private BuyRepository buyRepository;

    @Autowired
    private MileageRepository mileageRepository;

    public Page<MileageEntity> getList(int userNum, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable){

//        List<MyMileageDetailDTO> myMileageDetailDTOS = new ArrayList<>();
//        List<TradeEntity> consumeList = tradeRepository.findByTradeIsSuccessTrueAndConsumerNum_UserNumAndTradeTimeBetween(userNum, startDate, endDate);
//        List<TradeEntity> sellList = tradeRepository.findByTradeIsSuccessTrueAndSellerNum_UserNumAndTradeTimeBetween(userNum, startDate, endDate);
//        List<PayEntity> payList = payRepository.findByUserNum_UserNumAndPayTimeBetween(userNum, startDate, endDate);
//        List<BuyEntity> buyList = buyRepository.findByUserNum_UserNumAndTimeBetween(userNum, startDate, endDate);
//
//        if(consumeList != null) {
//            for (TradeEntity tradeEntity : consumeList) {
//                myMileageDetailDTOS.add(new MyMileageDetailDTO(tradeEntity.getTradeAmount(), tradeEntity.getTradeTime(), false, "#구매 : " + tradeEntity.getBoardNum().getBoardTitle()));
//            }
//        }
//
//        if(sellList != null) {
//
//            for (TradeEntity tradeEntity : sellList) {
//                myMileageDetailDTOS.add(new MyMileageDetailDTO(tradeEntity.getTradeAmount(), tradeEntity.getTradeTime(), true, "#판매 : " + tradeEntity.getBoardNum().getBoardTitle()));
//            }
//        }
//
//        if(payList != null) {
//            for (PayEntity payEntity : payList) {
//                myMileageDetailDTOS.add(new MyMileageDetailDTO(payEntity.getPayAmount(), payEntity.getPayTime(), true, "#충전 : " + payEntity.getPayPayment()));
//            }
//        }
//
//        if(buyList != null) {
//            for (BuyEntity buyEntity : buyList) {
//                myMileageDetailDTOS.add(new MyMileageDetailDTO(buyEntity.getPrice(), buyEntity.getTime(), false, "#프리미엄권 구매 : " + buyEntity.getBuyNum()));
//            }
//        }
//
//        if(myMileageDetailDTOS != null) {
//            myMileageDetailDTOS.sort(Comparator.comparing(MyMileageDetailDTO::getTime).reversed());
//        }
//
//        return myMileageDetailDTOS;

        return mileageRepository.findByUserNum_UserNumAndMileageTimeBetween(userNum, startDate, endDate, pageable);
    }

}
