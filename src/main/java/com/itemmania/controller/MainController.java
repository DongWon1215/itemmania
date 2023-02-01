package com.itemmania.controller;

import com.itemmania.service.IndexMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private IndexMainService indexMainService;

    @GetMapping("/")
    public String getIndexMain(
            Model model
    ){
        model.addAttribute("gameServer",indexMainService.getGameServer());
        return "index";
    }
}
