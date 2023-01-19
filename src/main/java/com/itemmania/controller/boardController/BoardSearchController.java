package com.itemmania.controller.boardController;


import com.itemmania.entity.BoardEntity;
import com.itemmania.service.boardService.Search.BoardSearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Log4j2
@Controller
public class BoardSearchController {


    @Autowired
    private BoardSearchService boardSearchService;

    @PostMapping("/boardSearch")
    public String getBoardSearch(Model model, @RequestParam(value = "search_type") String search_type,
                                 @RequestParam(value = "searchGameServer") String searchGameServer) {
        log.info("검색컨트롤러 들어옴");
        log.info(search_type);
        log.info(searchGameServer);

        List<BoardEntity> p_searchDataCheck = boardSearchService.getP_SearchDataCheck(search_type, searchGameServer, searchGameServer);
        List<BoardEntity> searchDataCheck = boardSearchService.getSearchDataCheck(search_type, searchGameServer, searchGameServer);
        log.info(p_searchDataCheck);
        log.info(searchDataCheck);


        model.addAttribute("boarList", p_searchDataCheck);
        model.addAttribute("boarPList", searchDataCheck);


        return "/board/boardList";
    }

}

