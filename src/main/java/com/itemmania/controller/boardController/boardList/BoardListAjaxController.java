package com.itemmania.controller.boardController.boardList;


import com.itemmania.domain.BoardSearchOption;
import com.itemmania.domain.BoardSearchOptionVO;
import com.itemmania.service.boardService.Search.BoardSearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class BoardListAjaxController {

    @Autowired
    private BoardSearchService boardSearchService;

    @GetMapping("/board/boardListAjax")
    public List<BoardSearchOptionVO> getBoardAjax(Model model,
                                                  BoardSearchOption searchOption) {

        log.info("서치옵션" + searchOption);
        List<BoardSearchOptionVO> searchDataCheck = boardSearchService.getSearchDataCheck(searchOption.getP(), searchOption.getSize(), searchOption.getDeal(), searchOption.getSearchGameServer());
        log.info("에이젝스 컨트롤러 리스트 " + searchDataCheck);

        // 검색 결과를 토대로 출력한 일반 리스트
        model.addAttribute("boarAjaxList", searchDataCheck);


        return searchDataCheck;
    }
}
