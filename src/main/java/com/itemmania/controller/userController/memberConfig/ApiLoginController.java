package com.itemmania.controller.userController.memberConfig;

import com.itemmania.domain.KakaoDTO;
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
@Log4j2
@ResponseBody
@RequestMapping("/apilogin")
public class ApiLoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String apiLogin(HttpServletRequest request, @RequestBody KakaoDTO Token)
    {
//        if(!userService.isExistUser(loginRequest.getUser_name(), loginRequest.getUser_password()))
//        return "/UserForm/registerForm";

//        UserEntity user = userService.getUser(loginRequest.getUser_name(), loginRequest.getUser_password());

        HttpSession session = request.getSession();

        if(userService.isExistEmail(Token.getAccount_email()))
        {
            session.setAttribute("userInfo",userService.findUserByNameAndEmail(Token.getProfile_nickname(),Token.getAccount_email()));
            return "/";
        }

        session.setAttribute("kakaoData", Token);
//        session.setAttribute("userInfo",user);

        log.info("세션 정보 ==> " + Token);

//        log.info(TypeOf(Token));

//        String username = Token;

        return "/regist";
    }
}
