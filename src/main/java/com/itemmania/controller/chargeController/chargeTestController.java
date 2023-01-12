package com.itemmania.controller.chargeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/charge")
public class chargeTestController {

    @GetMapping
    public String trade(){
        return "chargeTest/test";
    }

}

