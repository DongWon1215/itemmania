package com.itemmania.controller.boardController;

import com.itemmania.entity.BoardEntity;
import com.itemmania.service.boardService.BoardListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@Controller
public class boardListController {
    @Autowired
    private BoardListService boardListService;

    @GetMapping("/board/boardList/{DealCheck}")
    public String getsaleList(Model model, @PathVariable("DealCheck") String DealCheck) {
        log.info("boardListController DealCheck  들어옴");
        List<BoardEntity> getsaleList = boardListService.getDealCheckList(DealCheck);
        log.info(getsaleList);
        model.addAttribute("boardList", getsaleList);

        return "/board/boardList";
    }

}
