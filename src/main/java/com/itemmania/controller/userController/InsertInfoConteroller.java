package com.itemmania.controller.userController;

import com.itemmania.domain.UserDTO;
import com.itemmania.entity.UserEntity;
import com.itemmania.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/regist/insert")
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
    public UserEntity userData(@RequestBody UserDTO user)
    {
        if(userService.isExistUser(user.getUserName(),user.getUserPassword()))
            return null;

        return userService.insertUser(user.toUserEntity());
    }

}
