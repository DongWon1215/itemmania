package com.itemmania.controller.boardController.requestView;

import com.itemmania.domain.trade.Trade_insert_VO;
import com.itemmania.entity.MileageEntity;
import com.itemmania.service.boardService.BoardListService;
import com.itemmania.service.boardService.BoardViewService;
import com.itemmania.service.tradeService.ScheduledService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@RequestMapping("/buy_request")
@Log4j2
public class BoardRequestController {

    @Autowired
    private BoardViewService boardViewService;

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
    public void postBoardRequest(Trade_insert_VO trade_insert_vo) {
        /*판매자 마일리지 내역*/
        /*판매자 마일리지 내역*/

        log.info("consumer"+trade_insert_vo.getConsumer_mileage());
        log.info("seller"+trade_insert_vo.getSeller_mileage());
        List<MileageEntity> seller_mileage = scheduledService.getSeller_Consumer_mileage(trade_insert_vo.getSeller_mileage());

        List<MileageEntity> consumer_mileage = scheduledService.getSeller_Consumer_mileage(trade_insert_vo.getConsumer_mileage());

        log.info("seller_mileage" + seller_mileage);
        log.info("consumer_mileage" + consumer_mileage);



        /*board_num:10
        seller_mileage:5
        consumer_mileage:6
        trade_amount:1000
        trade_unit:1
        saleNickName:노바*/


    }
}
