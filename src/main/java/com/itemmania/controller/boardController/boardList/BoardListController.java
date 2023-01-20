package com.itemmania.controller.boardController.boardList;

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
public class BoardListController {
    @Autowired
    private BoardListService boardListService;

    @GetMapping("/board/boardList2")
    public void getsaleList(Model model, @RequestParam(value = "deal", required = false) String deal) {
        log.info("보드리스트 컨트롤러 들어옴보드리스트 컨트롤러 들어옴" + deal);
        boolean yes = true;
        boolean no = false;

        List<BoardEntity> dealCheck_PremiumList = boardListService.getDealCheckPremiumList(deal, yes);
        List<BoardEntity> dealCheckList = boardListService.getDealCheckList(deal, no);

        log.info("일반" + dealCheckList);
        log.info("프리미엄" + dealCheck_PremiumList);
        model.addAttribute("boarList", dealCheckList);
        model.addAttribute("boarPList", dealCheck_PremiumList);
    }
}
