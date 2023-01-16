package com.itemmania.controller.boardController;

import com.itemmania.entity.BoardEntity;
import com.itemmania.service.boardService.BoardListService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Log4j2
@Controller
public class boardListController {
    @Autowired
    private BoardListService boardListService;

    @GetMapping("/board/boardList")
    public void getList(Model model) {
//        log.info("boardListController  들어옴");
        List<BoardEntity> listAll = boardListService.getList();
//        log.info(listAll);
  model.addAttribute("boardList", listAll);
    }
}
