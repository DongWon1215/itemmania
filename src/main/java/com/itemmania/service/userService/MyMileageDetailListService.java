package com.itemmania.service.userService;

import com.itemmania.domain.MyMileageDetailDTO;
import com.itemmania.entity.BuyEntity;
import com.itemmania.entity.PayEntity;
import com.itemmania.entity.TradeEntity;
import com.itemmania.repository.BuyRepository;
import com.itemmania.repository.PayRepository;
import com.itemmania.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MyMileageDetailListService {

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private PayRepository payRepository;

    @Autowired
    private BuyRepository buyRepository;

    public List<MyMileageDetailDTO> getList(int userNum, LocalDate startDate, LocalDate endDate){

        List<MyMileageDetailDTO> myMileageDetailDTOS = new ArrayList<>();
        List<TradeEntity> consumeList = tradeRepository.findByTradeIsSuccessTrueAndConsumerNum_UserNumAndTradeTimeBetween(userNum, startDate, endDate);
        List<TradeEntity> sellList = tradeRepository.findByTradeIsSuccessTrueAndSellerNum_UserNumAndTradeTimeBetween(userNum, startDate, endDate);
        List<PayEntity> payList = payRepository.findByUserNum_UserNumAndPayTimeBetween(userNum, startDate, endDate);
        List<BuyEntity> buyList = buyRepository.findByUserNum_UserNumAndTimeBetween(userNum, startDate, endDate);

        if(consumeList != null) {
            for (TradeEntity tradeEntity : consumeList) {
                myMileageDetailDTOS.add(new MyMileageDetailDTO(tradeEntity.getTradeAmount(), tradeEntity.getTradeTime(), false, "#구매 : " + tradeEntity.getBoardNum().getBoardTitle()));
            }
        }

        if(sellList != null) {

            for (TradeEntity tradeEntity : sellList) {
                myMileageDetailDTOS.add(new MyMileageDetailDTO(tradeEntity.getTradeAmount(), tradeEntity.getTradeTime(), true, "#판매 : " + tradeEntity.getBoardNum().getBoardTitle()));
            }
        }

        if(payList != null) {
            for (PayEntity payEntity : payList) {
                myMileageDetailDTOS.add(new MyMileageDetailDTO(payEntity.getPayAmount(), payEntity.getPayTime(), true, "#충전 : " + payEntity.getPayPayment()));
            }
        }

        if(buyList != null) {
            for (BuyEntity buyEntity : buyList) {
                myMileageDetailDTOS.add(new MyMileageDetailDTO(buyEntity.getPrice(), buyEntity.getTime(), false, "#프리미엄권 구매 : " + buyEntity.getBuyNum()));
            }
        }

        if(myMileageDetailDTOS != null) {
            myMileageDetailDTOS.sort(Comparator.comparing(MyMileageDetailDTO::getTime).reversed());
        }

        return myMileageDetailDTOS;
    }

}
