package com.itemmania.controller.userController;

import com.itemmania.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DoubleCheckorController {

    @Autowired
    private UserService userService;

    @PostMapping("/regist/doublecheck")
    public Boolean isOverlaped(@RequestBody String userName)
    {
        return userService.isExsitNickName(userName);
    }
}
