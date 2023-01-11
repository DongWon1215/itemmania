package com.itemmania.controller.boardController.sale;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view_sale")
public class BoardViewSaleController {


    @GetMapping
    public String getBoardViewSale()
    {
        return "board/boardViewSale";
    }
}
