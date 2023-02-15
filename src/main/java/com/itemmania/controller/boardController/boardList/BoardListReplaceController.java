package com.itemmania.controller.boardController.boardList;

import com.itemmania.entity.MileageEntity;
import com.itemmania.entity.TradeEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.TradeRepository;
import com.itemmania.service.mileageService.MileageInsertService;
import com.itemmania.service.tradeService.BoardStateChangeService;
import com.itemmania.service.tradeService.detailsTrade.TradeSellerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Log4j2
@RestController
public class BoardListReplaceController {


    @Autowired
    private BoardStateChangeService boardStateChangeService;

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private TradeSellerService tradeSellerService;

    @Autowired
    private MileageInsertService mileageInsertService;

    @PostMapping("/myroom/replace")
    public int setTradeDenai(HttpServletRequest request, @RequestBody String tradeNum)
    {
        tradeNum = tradeNum.substring(0, tradeNum.length() - 1);

        int tNum = Integer.parseInt(tradeNum);

        tradeSellerService.setTradeDenai(tNum);

        TradeEntity trade = tradeRepository.findByTradeNum(tNum);

        MileageEntity writerMileage = MileageEntity.builder().userNum(trade.getBoardNum().getUserNum())
                .mileageTime(LocalDateTime.now())
                .mileageType("구매취소")
                .mileageDescription("#구매취소 : " + trade.getBoardNum().getBoardNum())
                .mileageIn(0)
                .mileageOut(trade.getBoardNum().getSalePrice()).build();

        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("userInfo");

        MileageEntity requesterMileage = MileageEntity.builder().userNum(user)
                .mileageTime(LocalDateTime.now())
                .mileageType("구매취소")
                .mileageDescription("#구매취소 : " + trade.getBoardNum().getBoardNum())
                .mileageIn(trade.getBoardNum().getSalePrice())
                .mileageOut(0).build();
//
        mileageInsertService.setMileage(writerMileage);
        mileageInsertService.setMileage(requesterMileage);

        boardStateChangeService.boardTradeStateChange(0,trade.getBoardNum().getBoardNum());

        return 1;
    }

    @PostMapping("/myroom/accept")
    public int setTradeAccept(@RequestBody String tradeNum)
    {
        tradeNum = tradeNum.substring(0, tradeNum.length() - 1);

        int tNum = Integer.parseInt(tradeNum);

        tradeSellerService.setTradeAccept(tNum);

        TradeEntity trade = tradeRepository.findByTradeNum(tNum);

        boardStateChangeService.boardTradeStateChange(1,trade.getBoardNum().getBoardNum());

        return 1;
    }
}
