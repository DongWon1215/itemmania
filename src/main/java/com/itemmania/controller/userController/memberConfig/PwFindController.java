package com.itemmania.controller.userController.memberConfig;

import com.itemmania.domain.PasswordFindRequest;
import com.itemmania.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/find/pw")
public class PwFindController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String findform()
    {
        return "/UserForm/userRegist/pwFindForm";
    }

    @PostMapping
    @ResponseBody
    public String sendInfo(@RequestBody PasswordFindRequest findRequest)
    {
        String userPassword = userService.findPasswordByNameAndBirthAndPhoneNum(findRequest);

        if(userPassword == null)
            return "empty";

        return userPassword;
    }
}
