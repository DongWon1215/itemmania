package com.itemmania.controller.boardController.boardList;


import com.itemmania.entity.GameServerEntity;
import com.itemmania.service.boardService.Search.BoardGameSearch;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
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
        /*게임리스트 값을 비동기로 보냄*/
        model.addAttribute("searchGame", boardGameSearch.getGameService());

        return "/getSearchGameList :: .gs_list";
    }


    @PostMapping("/getSearchServerList")
    public List<GameServerEntity> getSearchServerList(Model model) {
        /*서버리스트 값을 비동기로 보냄*/
        log.info("서버서치리스트");

        return boardGameSearch.getServerService();
    }


}
