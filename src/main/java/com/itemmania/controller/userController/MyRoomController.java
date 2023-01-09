package com.itemmania.controller.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myroom")
public class MyRoomController {

    @GetMapping
    public String getMypageForm()
    {
        return "userForm/myRoomForm";
    }


}
