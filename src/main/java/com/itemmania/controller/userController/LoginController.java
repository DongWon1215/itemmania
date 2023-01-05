package com.itemmania.controller.userController;

import com.itemmania.entity.UserEntity;
import com.itemmania.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String login(HttpServletRequest request)
    {
//        UserEntity user = userService.getUser();


        HttpSession session = request.getSession();

//        session.setAttribute("userInfo",user);

        return "/";
    }
}
