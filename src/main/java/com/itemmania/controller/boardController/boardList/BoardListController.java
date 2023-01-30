package com.itemmania.controller.boardController.boardList;


import com.itemmania.domain.BoardSearchOption;
import com.itemmania.domain.BoardSearchOptionVO;
import com.itemmania.service.boardService.Search.BoardSearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Log4j2
@Controller
public class BoardListController {

    @Autowired
    private BoardSearchService boardSearchService;

    @PostMapping("/board/boardList")
    public String subsearch(Model model, BoardSearchOption boardSearchOption) {
        log.info("서브서치옵션" + boardSearchOption);

        boolean boardTradeStatus = boardSearchOption.isBoardTradeStatus();
        log.info("검색타입 " + boardTradeStatus);


        List<BoardSearchOptionVO> p_searchDataCheck = boardSearchService.getP_SearchDataCheck(boardSearchOption);
        List<BoardSearchOptionVO> searchDataCheck = boardSearchService.getSearchDataCheck(boardSearchOption);
        log.info("서브서치 컨트롤러 리스트 " + searchDataCheck);
        //프리미엄, 일반 리스트
        model.addAttribute("boarPList", p_searchDataCheck);
        model.addAttribute("boarList", searchDataCheck);


        // 사용자가 검색한 게임서버 value
        model.addAttribute("searchGameServer", boardSearchOption.getSearchGameServer());

        // 검색당시 판매,구매인지
        model.addAttribute("searchType", boardSearchOption.getDeal());

        // 서브검색으로 선택된 신용등급
        model.addAttribute("userCreditScore", boardSearchOption.getUserCreditScore());

        //거래 상태 표시 value
        model.addAttribute("boardTradeStatus", boardTradeStatus);


        return "/board/boardList";

    }

}
