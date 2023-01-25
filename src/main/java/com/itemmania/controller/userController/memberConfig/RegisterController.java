package com.itemmania.controller.userController.memberConfig;

import com.itemmania.domain.LoginRequest;
import com.itemmania.domain.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/regist")
public class RegisterController {

    @GetMapping
    public String registpage()
    {
        return "/UserForm/registerForm";
    }

}
