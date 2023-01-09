package com.itemmania.controller.userController;

import com.itemmania.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @GetMapping
    public String getMypageForm()
    {
        return "UserForm/MypageForm";
    }


}
