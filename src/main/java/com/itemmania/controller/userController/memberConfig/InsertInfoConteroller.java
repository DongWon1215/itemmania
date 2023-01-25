package com.itemmania.controller.userController.memberConfig;

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

        String token = (String)session.getAttribute("Token");

        if(token != null)
            model.addAttribute("data");

        return "/UserForm/inputInfoForm";
    }

    @PostMapping
    public String userData(@RequestBody UserDTO user)
    {
        log.info("데이터 =>" + user);

        if(userService.isExistUser(user.getUserName(),user.getUserPassword()))
            return "/regist";

        userService.insertUser(user.toUserEntity());

        return "/index";
    }

}
