package com.itemmania.controller.userController.memberConfig;

import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Log4j2
public class DoubleCheckorController {

    @Autowired
    private UserService userService;

    @PostMapping("/regist/idDoublecheck")
    public Boolean isOverlaped(@RequestParam("userName") String userName)
    {
        log.info(userName);

        return userService.isExsitNickName(userName);
    }

    @PostMapping("/regist/emailDoublecheck")
    public Boolean isEmailExist(@RequestBody String userEmail)
    {
        log.info(userEmail);

        return userService.isExistEmail(userEmail);
    }
}
