package com.itemmania.controller.boardController.requestView;

import com.itemmania.entity.MileageEntity;
import com.itemmania.entity.TradeEntity;
import com.itemmania.service.boardService.BoardListService;
import com.itemmania.service.boardService.BoardViewService;
import com.itemmania.service.tradeService.ScheduledService;
import com.itemmania.service.tradeService.TradeInsertService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/buy_request")
@Log4j2
public class BoardRequestController {

    @Autowired
    private BoardViewService boardViewService;

    @Autowired
    private TradeInsertService tradeInsertService;

    @Autowired
    private ScheduledService scheduledService;

    @Autowired
    private BoardListService boardListService;


    @GetMapping("/board/requestPage")
    public String getBoardRequest(
            @RequestParam(value = "boardNum") int boardNum, // 게시글번호
            @RequestParam(value = "deal") String dealCheck, // 판매,구매 구별
            Model model
    ) {
        log.info("BoardRequestController 들어옴");
        Model boardReq = model.addAttribute("boardReq", boardViewService.selectBoardView(boardNum));
        model.addAttribute("dealCheck", dealCheck);

        log.info("boardReq>>>>>>>>>>>>" + boardReq);


        if (dealCheck.equals("sale")) {
            log.info("팝니다 요청페이지!!!! 들어감");
            return "/board/requestPage/boardSaleRequest";
        } else
            return "/errors/500";

    }

    @PostMapping("/board/requestPage")
    public void postBoardRequest(TradeEntity tradeEntity) {

        /*trde테이블에 검색할 userNum*/
        /*로그인한 유저 6번*/
        log.info("consumer >>" + tradeEntity.getConsumerMileage().getMileageNum());
        /*게시글 작성유저 5번*/
        log.info("seller >>" + tradeEntity.getSellerMileage().getMileageNum());

        /*판매자, 구매자 마일리지 내역 PK*/
        MileageEntity seller_mileage = scheduledService.getSeller_Consumer_mileage(tradeEntity.getConsumerMileage().getMileageNum());
        MileageEntity consumer_mileage = scheduledService.getSeller_Consumer_mileage(tradeEntity.getSellerMileage().getMileageNum());


        log.info("seller_mileage" + seller_mileage);
        log.info("consumer_mileage" + consumer_mileage);

        tradeEntity.setSellerMileage(seller_mileage);
        tradeEntity.setConsumerMileage(consumer_mileage);


        log.info("set된 결과" + tradeEntity);

        tradeInsertService.setTradeInsert(tradeEntity);


    }
}
