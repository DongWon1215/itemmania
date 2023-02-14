package com.itemmania.controller.boardController.requestView;

import com.itemmania.entity.MileageEntity;
import com.itemmania.entity.TradeEntity;
import com.itemmania.service.boardService.BoardListService;
import com.itemmania.service.boardService.BoardViewService;
import com.itemmania.service.tradeService.BoardStateChangeService;
import com.itemmania.service.tradeService.TradeInsertService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
//@RequestMapping("/buy_request")
@Log4j2
public class BoardRequestController {

    @Autowired
    private BoardViewService boardViewService;


    @Autowired
    private BoardListService boardListService;

    @Autowired
    private TradeInsertService tradeInsertService;
    @Autowired
    private BoardStateChangeService boardStateChangeService;

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
            return "board/requestPage/boardSaleRequest";
        } else
            return "errors/500";

    }

    @PostMapping("/board/requestPage")
    public String postBoardRequest(HttpServletResponse response, TradeEntity tradeEntity) throws IOException {

        /*trde테이블에 검색할 userNum*/
        /*로그인한 유저 6번*/
        log.info("consumer >>" + tradeEntity.getConsumerMileage().getMileageNum());
        /*게시글 작성유저 5번*/
        log.info("seller >>" + tradeEntity.getSellerMileage().getMileageNum());
        /*

         */

        /* 판매자, 구매자 마일리지 내역 PK(userNum을 이용해서 mileage테이블 PK값을 가져오려 했는데 엔티티가 해줘서 불필요한 코드였음)
        int seller_mileage = scheduledService.getSeller_Consumer_mileage(tradeEntity.getConsumerMileage().getMileageNum());
        int consumer_mileage = scheduledService.getSeller_Consumer_mileage(tradeEntity.getSellerMileage().getMileageNum());

        log.info("seller_mileage" + seller_mileage);
        log.info("consumer_mileage" + consumer_mileage);

        tradeEntity.setSellerMileage2(seller_mileage);
        tradeEntity.setConsumerMileage2(consumer_mileage);
*/
        log.info("마일리지 PK가져온 입력전 데이터>>" + tradeEntity.toString());
        /*trade테이블에 저장*/
        TradeEntity insert = tradeInsertService.setTradeInsert(tradeEntity);
        log.info("insert>>" + insert);

        log.info("변경할 보드번호" + tradeEntity.getBoardNum());

        /*board_trade_status 상태값을 2로 변경*/
        boardStateChangeService.boardStateChange(tradeEntity.getBoardNum());
     /*   PrintWriter out = response.getWriter();
        out.println("<script>alert('" + "입력되었습니다." + "');</script> ");
        out.flush();*/

        return "UserForm/myRoom/trade/buyRegister";
    }
}
