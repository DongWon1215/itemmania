package com.itemmania.controller.boardController.boardList;


import com.itemmania.domain.BoardSearchOption;
import com.itemmania.domain.BoardSearchOptionVO;
import com.itemmania.service.boardService.Search.BoardSearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
public class BoardSearchController {

    @Autowired
    private BoardSearchService boardSearchService;

    /*@RequestMapping(value = "/board/boardList")*/
    @GetMapping("/board/boardList")
    public String getBoardSearch(Model model, BoardSearchOption searchOption) {

        log.info("컨트롤 겟 옵션" + searchOption);

        List<BoardSearchOptionVO> p_searchDataCheck = boardSearchService.getP_SearchDataCheck(searchOption);
        List<BoardSearchOptionVO> searchDataCheck = boardSearchService.getSearchDataCheck(searchOption);
        log.info("프리미엄 리스트" + p_searchDataCheck);
        log.info("일반 리스트" + searchDataCheck);


        //사용자가 입력한 게임서버
        model.addAttribute("searchGameServer", searchOption.getSearchGameServer());
        // 사용자가 입력할 때 선택한 라디오버튼(sale or buy)
        model.addAttribute("searchType", searchOption.getDeal());
        // 검색 결과를 토대로 출력한 프리미엄 리스트
        model.addAttribute("boarPList", p_searchDataCheck);
        // 검색 결과를 토대로 출력한 일반 리스트
        model.addAttribute("boarList", searchDataCheck);



        return "";
    }
}

