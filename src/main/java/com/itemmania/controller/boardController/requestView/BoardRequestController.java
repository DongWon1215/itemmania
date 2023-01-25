package com.itemmania.controller.boardController.requestView;

import com.itemmania.service.boardService.BoardListService;
import com.itemmania.service.boardService.BoardViewService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
            @RequestParam(value = "boardNum")int boardNum, // 게시글번호
            @RequestParam(value = "deal")String dealCheck, // 판매,구매 구별
            Model model
    )
    {
        log.info("BoardRequestController 들어옴");
        model.addAttribute("boardReq",boardViewService.selectBoardView(boardNum));
        model.addAttribute("boardList",boardListService.getAllList());
        log.info("boardReq");

        String buy = "buy";

        if (dealCheck.equals(buy)) {

            log.info("삽니다 요청페이지!!!! 들어감");
            return "/board/requestPage/boardBuyRequest";

        } else {
            log.info("팝니다 요청페이지!!!! 들어감");
            return "/board/requestPage/boardSaleRequest";

        }


    }

}
