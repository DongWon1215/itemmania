package com.itemmania.controller.tradeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trade")
public class tradeTestController {

    @GetMapping
    public String trade(){
        return "tradeTest/test";
    }
}
