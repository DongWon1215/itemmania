package com.itemmania.controller.boardController.requestView;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buy_request")
public class BoardBuyRequestController {

    @GetMapping
    public String getBoardViewBuy()
    {
        return "board/buy/boardBuyRequest";
    }

}
