package com.itemmania.controller.userController;

import com.itemmania.domain.UserDTO;
import com.itemmania.entity.UserEntity;
import com.itemmania.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class InsertInfoConteroller {

    @Autowired
    private UserService userService;

    @GetMapping
    public String ToinsertForm()
    {
        return "/UserForm/inputInfoForm";
    }

    @PostMapping
    public UserEntity userData(@RequestBody UserDTO userDTO)
    {
        if(userService.isExistUser(userDTO.getUserName()))
            return null;



        return userService.insertUser(userDTO.toUserEntity());
    }

}
