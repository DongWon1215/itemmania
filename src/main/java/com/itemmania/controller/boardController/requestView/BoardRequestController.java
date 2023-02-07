package com.itemmania.controller.boardController.requestView;

import com.itemmania.service.boardService.BoardListService;
import com.itemmania.service.boardService.BoardViewService;
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
    private BoardListService boardListService;


    @GetMapping("/board/requestPage")
    public String getBoardRequest(
            @RequestParam(value = "boardNum") int boardNum, // 게시글번호
            @RequestParam(value = "deal") String dealCheck, // 판매,구매 구별
            Model model
    ) {
        log.info("BoardRequestController 들어옴");
        Model boardReq = model.addAttribute("boardReq", boardViewService.selectBoardView(boardNum));
        log.info("boardReq>>>>>>>>>>>>" + boardReq);
        Model boardList = model.addAttribute("boardList", boardListService.getAllList());
        log.info("boardList>>>>>>>>>>>>" + boardList);

        if (dealCheck.equals("sale")) {
            log.info("팝니다 요청페이지!!!! 들어감");
            return "/board/requestPage/boardSaleRequest";
        } else
            return "/errors/500";

    }

    @PostMapping("/board/requestPage")
    public void postBoardRequest(@RequestParam(value = "boardNum") int boardNum, @RequestParam(value = "deal") String dealCheck) {
        log.info("파라미터 확인 boardNum" + boardNum + "deal" + dealCheck);
        log.info("이이이이이이이이이");

        log.info("거래번호" +
                "구매 마일리지 내역" +
                "판매 마일리지 내역" +
                "거래 게시글 번호" +
                "거래 금액 (거래 비정상 종료시 0)" +
                "거래 수량" +
                "정상 종료 구분 (0:비정상 1:정상)" +
                "거래 종료 시간");





    }
}
