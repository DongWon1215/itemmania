package com.itemmania.controller.userController.myRoomController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myroom/sellRegister")
public class SellRegisterController {

    @GetMapping
    public String getMypageForm()
    {
        return "userForm/myRoom/trade/sellRegister";
    }


}
