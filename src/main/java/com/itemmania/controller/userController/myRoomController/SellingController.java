package com.itemmania.controller.userController.myRoomController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myroom/sell_ing")
public class SellingController {

    @GetMapping
    public String getMypageForm()
    {
        return "UserForm/myRoom/trade/sell_ing";
    }


}
