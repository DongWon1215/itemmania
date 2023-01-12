package com.itemmania.controller.chargeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trade/viewTest")
public class viewTestController {

    @GetMapping
    public String view(){
        return "chargeTest/viewTest";
    }
}
