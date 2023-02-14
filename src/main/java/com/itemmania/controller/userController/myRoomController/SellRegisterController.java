package com.itemmania.controller.userController.myRoomController;

import com.itemmania.domain.board.TradeRequest;
import com.itemmania.entity.TradeEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.TradeRepository;
import com.itemmania.service.boardService.BoardInNameOutnumService;
import com.itemmania.service.tradeService.BoardStateChangeService;
import com.itemmania.service.tradeService.detailsTrade.TradeSellerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/myroom/sellRegister")
public class SellRegisterController {

    @Autowired
    private TradeSellerService tradeSellerService;

    @Autowired
    private BoardStateChangeService boardStateChangeService;

    @Autowired
    private TradeRepository tradeRepository;


/*
    @Autowired(required = false)
    private BoardInNameOutnumService boardInNameOutnumService;
*/


    @GetMapping
    public String getMypageForm(Model model, Principal principal) {

        log.info("Principal?" + principal.getName());

        /*   UserEntity userNum = boardInNameOutnumService.getUserNum(principal.getName());*/
     /*   log.info(userNum);
        List<TradeEntity> tradeSeller = tradeSellerService.getTradeSeller(userNum);
*/

        List<TradeEntity> tradeSeller = tradeSellerService.getTradeSeller();
        log.info("tradeSeller?" + tradeSeller);
        model.addAttribute("tradeSeller", tradeSeller);


        return "UserForm/myRoom/trade/sellRegister";
    }

    @PutMapping
    @ResponseBody
    public int setTradeDenai(@RequestBody String tradeRequest)
    {
        log.info("tradeRequest 정보 ======================>" + tradeRequest);

//        tradeSellerService.setTradeDenai(num);
        log.info("데이터 변경 됐냐?");

//        boardStateChangeService.boardTradeStateChange(0,);

        return 1;
    }

    @PostMapping
    @ResponseBody
    public int setTradeAccept(@RequestBody String tradeNum)
    {

        int tNum = Integer.parseInt(tradeNum);

        log.info("바꿀 게시판 번호 ================>" + tradeNum);

//        tradeSellerService.setTradeAccept(tNum);

        TradeEntity trade = tradeRepository.findByTradeNum(tNum);
        log.info("데이터 변경 됐냐?");

//        boardStateChangeService.boardTradeStateChange(1,trade.getBoardNum().getBoardNum());

        return 1;
    }

}
