package com.itemmania.controller.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myroom/buy_ing")
public class BuyingController {

    @GetMapping
    public String getMypageForm()
    {
        return "userForm/myRoom/trade/buy_ing";
    }


}
