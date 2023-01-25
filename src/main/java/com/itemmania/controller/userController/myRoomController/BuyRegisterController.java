package com.itemmania.controller.userController.myRoomController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myroom/buyRegister")
public class BuyRegisterController {

    @GetMapping
    public String getMypageForm()
    {
        return "userForm/myRoom/trade/buyRegister";
    }


}
