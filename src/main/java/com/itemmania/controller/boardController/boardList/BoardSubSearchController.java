package com.itemmania.controller.boardController.boardList;


import com.itemmania.domain.BoardSearchOption;
import com.itemmania.domain.BoardSearchOptionVO;
import com.itemmania.service.boardService.Search.BoardSearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
public class BoardSubSearchController {

    @Autowired
    private BoardSearchService boardSearchService;

    @PostMapping("/boardList/subsearch")
    public void subsearch(Model model, BoardSearchOption boardSearchOption) {
        log.info("서브서치옵션" + boardSearchOption);


        List<BoardSearchOptionVO> p_searchDataCheck = boardSearchService.getP_SearchDataCheck(boardSearchOption);
        List<BoardSearchOptionVO> searchDataCheck = boardSearchService.getSearchDataCheck(boardSearchOption);
        log.info("서브서치 컨트롤러 리스트 " + searchDataCheck);

        model.addAttribute("boarPList", p_searchDataCheck);

        model.addAttribute("boarAjaxList", searchDataCheck);


    }

}
