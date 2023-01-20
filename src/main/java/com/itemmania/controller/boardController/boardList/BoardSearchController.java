package com.itemmania.controller.boardController.boardList;


import com.itemmania.entity.BoardEntity;
import com.itemmania.service.boardService.Search.BoardSearchService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
public class BoardSearchController {


    @Autowired
    private BoardSearchService boardSearchService;

    @RequestMapping(value = "/board/boardList", method = RequestMethod.GET)
    /*@GetMapping("/board/boardList")*/
    public void getBoardSearch(Model model, @PageableDefault(size = 5, sort = "boardNum", direction = Sort.Direction.DESC) Pageable pageable
            , @RequestParam(required = false, value = "deal") String search_type,
                               @RequestParam(required = false,value = "searchGameServer") String searchGameServer) {
        log.info("검색컨트롤러 들어옴");
        log.info(search_type);
        log.info(searchGameServer);

        Page<BoardEntity> p_searchDataCheck = boardSearchService.getP_SearchDataCheck(pageable, search_type, searchGameServer, searchGameServer);
        List<BoardEntity> searchDataCheck = boardSearchService.getSearchDataCheck(pageable, search_type, searchGameServer, searchGameServer);
        log.info(p_searchDataCheck);
        log.info(searchDataCheck);

        //사용자가 입력한 게임서버
        model.addAttribute("searchGameServer", searchGameServer);
        // 사용자가 입력할 때 선택한 라디오버튼(sale or buy)
        model.addAttribute("searchType", search_type);
        // 검색 결과를 토대로 출력한 프리미엄 리스트
        model.addAttribute("boarPList", searchDataCheck);
        // 검색 결과를 토대로 출력한 일반 리스트
        model.addAttribute("boarList", p_searchDataCheck);


        // 페이징된 현재 페이지 번호
        model.addAttribute("pageNum", pageable.getPageNumber());
        // 현재 페이지번호 +1을 한 다음페이지 값
        model.addAttribute("next", pageable.next().getPageNumber());
        // 현재 페이지번호 -1을 한 다음페이지 값
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        String url = "/board/boardList?{}";


    }

}

