package com.itemmania.controller.userController;

import com.itemmania.domain.LoginRequest;
import com.itemmania.entity.UserEntity;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequestMapping("/apilogin")
public class ApiLoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String apiLogin(HttpServletRequest request, @RequestBody String Token)
    {
//        if(!userService.isExistUser(loginRequest.getUser_name(), loginRequest.getUser_password()))
//        return "/UserForm/registerForm";

//        UserEntity user = userService.getUser(loginRequest.getUser_name(), loginRequest.getUser_password());

        HttpSession session = request.getSession();

        session.setAttribute("kakaoAccessToken", Token);
//        session.setAttribute("userInfo",user);

        log.info("세션 정보 ==> " + Token);
//        log.info(TypeOf(Token));

//        String username = Token;

        return "index";
    }
}
