package com.itemmania.controller.userController;

import com.itemmania.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping
    public String login(HttpServletRequest request)
    {
        UserEntity user =;


        HttpSession session = request.getSession();

        session.setAttribute("",);

        return "/";
    }
}
