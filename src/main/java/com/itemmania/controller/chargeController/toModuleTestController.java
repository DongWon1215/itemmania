package com.itemmania.controller.chargeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/toModuleTest")
public class toModuleTestController {

    @GetMapping
    public String toModule(){
        return "/chargeTest/toModuleTest";
    }

}
