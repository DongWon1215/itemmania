package com.itemmania.controller.boardController.buy;


import com.itemmania.entity.BoardEntity;
import com.itemmania.service.boardService.BoardViewService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/view_buy")
public class BoardViewBuyController {

    @Autowired
    private BoardViewService boardViewService;


    @GetMapping
    public String getBoardViewBuy(Model model,
                                  @RequestParam(value = "boardTitle") String boardTitle,
                                  @RequestParam(value = "salePrice") String  salePrice) {
        log.info("BoardViewBuyController  들어옴");
        List<BoardEntity> listAll = boardViewService.getList();
        log.info(listAll);
        model.addAttribute("boardTitle", boardTitle);
        model.addAttribute("salePrice", salePrice);

        return ("board/buy/boardViewBuy");
    }

}
