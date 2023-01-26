package com.itemmania.controller.userController.memberConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/regist")
public class RegisterController {

    @GetMapping
    public String registpage()
    {
        return "/UserForm/userRegist/registerForm";
    }

}
