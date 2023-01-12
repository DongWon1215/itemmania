package com.itemmania.controller.chargeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chargeModalTest")
public class chargeModalTestController {

    @GetMapping
    public String tradeModal(){
        return "chargeTest/chargeModalTest";
    }

}
