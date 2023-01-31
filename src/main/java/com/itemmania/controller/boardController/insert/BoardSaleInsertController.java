package com.itemmania.controller.boardController.insert;


import com.itemmania.domain.board.BoardInsertRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
@Log4j2
@RequestMapping("/board/sale/insert")
public class BoardSaleInsertController {

    @GetMapping
    public String getBoard(
    ){
        return "/board/insert/boardSaleInsert";
    }

/*    @PostMapping
    public String getInsertForm(
            BoardInsertRequest boardInsertRequest
    ){

        log.info(">>>>>>>>>>>" + boardInsertRequest);
        String absolutePath = new File("").getAbsolutePath();
        log.info(">>> path : " + absolutePath);


        return "redirect:/board/boardList";
    }*/

}