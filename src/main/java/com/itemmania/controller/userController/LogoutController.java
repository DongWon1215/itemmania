package com.itemmania.controller.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String Logout(HttpSession session)
    {
        session.invalidate();

        return "/";
    }
}
