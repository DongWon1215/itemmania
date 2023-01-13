package com.itemmania.controller.userController;

import com.itemmania.domain.LoginRequest;
import com.itemmania.entity.UserEntity;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@Log4j2
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage()
    {
        return "userForm/loginForm";
    }

    @PostMapping
    public String login(HttpServletRequest request, @RequestBody LoginRequest loginRequest)
    {
        log.info("일단 들어오긴 했다");
        log.info("loginRequest = " + loginRequest);

        log.info("getUserName = " + loginRequest.getUser_name());
        log.info("getUserPassword = " + loginRequest.getUser_password());


        if(!userService.isExistUser(loginRequest.getUser_name(), loginRequest.getUser_password()))
            return "/UserForm/registerForm";

        UserEntity user = userService.getUser(loginRequest.getUser_name(), loginRequest.getUser_password());

        HttpSession session = request.getSession();

        session.setAttribute("userInfo",user);

        return "index";
    }
}
