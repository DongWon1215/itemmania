package com.itemmania.controller.userController.memberConfig;

import com.itemmania.domain.KakaoDTO;
import com.itemmania.domain.UserDTO;
import com.itemmania.entity.UserEntity;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/regist/insert")
@Log4j2
public class InsertInfoConteroller {

    @Autowired
    private UserService userService;

    @GetMapping
    public String ToInsertForm(HttpServletRequest request, Model model)
    {
        HttpSession session = request.getSession();

        KakaoDTO token = (KakaoDTO)session.getAttribute("kakaoData");

        if(token != null)
            model.addAttribute("data");

        return "/UserForm/userRegist/inputInfoForm";
    }

    @PostMapping
    @ResponseBody
    public UserEntity userData(@RequestBody UserDTO user)
    {
        log.info("데이터 =>" + user);

        if(userService.isExistUser(user.getUserName(),user.getUserPassword()))
//            return "/UserForm/userRegist/registerForm";
            return null;

        return userService.insertUser(user.toUserEntity());

//        return "/index";
    }

}
