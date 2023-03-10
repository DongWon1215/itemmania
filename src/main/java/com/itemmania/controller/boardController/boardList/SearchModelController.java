package com.itemmania.controller.boardController.boardList;


import com.itemmania.entity.GameServerEntity;
import com.itemmania.service.boardService.Search.BoardGameSearch;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@Controller
public class SearchModelController {

    @Autowired
    BoardGameSearch boardGameSearch;

    @PostMapping("/getSearchGameList")
    public String getSearchGameList(Model model) {
        log.info("게임서치리스트");
        /*게임리스트, 서버리스트를 값을 모델 사용으로 searchList.html 으로 보냄*/
        model.addAttribute("searchGame", boardGameSearch.getGameService());
        model.addAttribute("searchServer", boardGameSearch.getServerService());

        return "fragment/searchList";
    }
}
