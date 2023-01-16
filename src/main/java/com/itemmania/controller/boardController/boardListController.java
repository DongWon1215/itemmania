package com.itemmania.controller.boardController;

import com.itemmania.entity.BoardEntity;
import com.itemmania.service.boardService.BoardListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@Controller
public class boardListController {
    @Autowired
    private BoardListService boardListService;

    @GetMapping("/board/boardList")
    public void getsaleList(Model model, @RequestParam(value = "deal", required = false) String deal) {
        log.info("보드리스트 컨트롤러 들어옴보드리스트 컨트롤러 들어옴" + deal);

        List<BoardEntity> dealCheckList = boardListService.getDealCheckList(deal);
        log.info(dealCheckList);
        model.addAttribute("boarList", dealCheckList);
    }
}
