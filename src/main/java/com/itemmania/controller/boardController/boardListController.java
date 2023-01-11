package com.itemmania.controller.boardController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class boardListController {

    @GetMapping("/list_buy")
    public String getList() {
        return "/board/boardList";
    }
}
