package com.itemmania.controller.boardController.boardList;


import com.itemmania.domain.search.BoardSearchOption;
import com.itemmania.domain.search.BoardSearchOptionVO;
import com.itemmania.service.boardService.Search.BoardSearch;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class BoardListAjaxController {

    @Autowired
    private BoardSearch boardSearch;

    @GetMapping("/board/boardListAjax")
    public List<BoardSearchOptionVO> getBoardAjax(BoardSearchOption searchOption) {

        log.info("서치옵션" + searchOption);
        List<BoardSearchOptionVO> searchDataCheck = boardSearch.getSearchDataCheck(searchOption);
        log.info("에이젝스 컨트롤러 리스트 " + searchDataCheck);


        return searchDataCheck;
    }
}
