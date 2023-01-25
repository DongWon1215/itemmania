package com.itemmania.controller.boardController;


import com.itemmania.service.boardService.BoardListService;
import com.itemmania.service.boardService.BoardViewService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Log4j2
public class BoardViewController {

    @Autowired
    private BoardViewService boardViewService;
    
    @Autowired
    private BoardListService boardListService;

    @GetMapping("/board/view")
    public String getBoardViewBuy(
            @RequestParam(value = "boardNum")int boardNum, // 게시글번호
            @RequestParam(value = "deal")String dealCheck, // 판매,구매 구별
            Model model
    ) {
        log.info("BoardVieController 들어옴");
        model.addAttribute("boardView",boardViewService.selectBoardView(boardNum));
        model.addAttribute("boardList",boardListService.getAllList());
        log.info("boardView");

        String buy = "buy";

        if (dealCheck.equals(buy)) {

            log.info("삽니다!!!! 들어감");
            return "/board/view/boardViewBuy";

        } else {
            log.info("팝니다!!!! 들어감");
            return "/board/view/boardViewSale";

        }

    }

/*

    @GetMapping("/board/view")
    public String getBoardViewSale(
            @RequestParam(value = "boardNum")int boardNum,
            Model model
    ) {
        log.info("BoardViewSaleController  들어옴");
        model.addAttribute("boardView",boardViewService.selectBoardView(boardNum));
        log.info("boardView");
        return "/board/view/boardViewSale";
    }
*/



}
