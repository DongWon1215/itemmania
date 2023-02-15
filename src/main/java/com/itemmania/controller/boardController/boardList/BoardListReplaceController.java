package com.itemmania.controller.boardController.boardList;

import com.itemmania.entity.TradeEntity;
import com.itemmania.repository.TradeRepository;
import com.itemmania.service.tradeService.BoardStateChangeService;
import com.itemmania.service.tradeService.detailsTrade.TradeSellerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
public class BoardListReplaceController {


    @Autowired
    private BoardStateChangeService boardStateChangeService;

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private TradeSellerService tradeSellerService;

    @PostMapping("/myroom/replace")
    public int setTradeDenai(@RequestBody String tradeNum)
    {
        tradeNum = tradeNum.substring(0, tradeNum.length() - 1);

        int tNum = Integer.parseInt(tradeNum);

        tradeSellerService.setTradeDenai(tNum);

        TradeEntity trade = tradeRepository.findByTradeNum(tNum);

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
