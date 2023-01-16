package com.itemmania.controller.boardController;

import com.itemmania.entity.BoardEntity;
import com.itemmania.service.boardService.BoardListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class boardListController {
    @Autowired
    private BoardListService boardListService;

    @GetMapping("/board/boardList/{DealCheck}")
    public List<BoardEntity> getsaleList(Model model, @PathVariable("DealCheck") String DealCheck) {
        log.info("보드리스트 컨트롤러 들어옴보드리스트 컨트롤러 들어옴");
        // List<BoardEntity> getsaleList = boardListService.getDealCheckList(DealCheck);
        //model.addAttribute("boardList", getsaleList);
        List<BoardEntity> dealCheckList = boardListService.getDealCheckList(DealCheck);
        model.addAttribute("boarList", dealCheckList);
        return dealCheckList;
    }
}
