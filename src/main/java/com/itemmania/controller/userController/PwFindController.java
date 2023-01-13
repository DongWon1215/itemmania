package com.itemmania.controller.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/find/pw")
public class PwFindController {

    @GetMapping
    public String findform()
    {
        return "/UserForm/pwFindForm";
    }
}
