package com.itemmania.controller.boardController.buy;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view_buy")
public class BoardViewBuyController {

    @GetMapping
    public String getBoardViewBuy()
    {
        return "board/boardViewBuy";
    }
}
