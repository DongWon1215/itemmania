package com.itemmania.controller.userController;

import com.itemmania.domain.IdFindRequest;
import com.itemmania.domain.PasswordFindRequest;
import com.itemmania.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/find/pw")
public class PwFindController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String findform()
    {
        return "/UserForm/pwFindForm";
    }

    @PostMapping
    public void sendInfo(@RequestBody PasswordFindRequest findRequest, Model model)
    {
        String userPassword = userService.findPasswordByNameAndBirthAndPhoneNum(findRequest);

        model.addAttribute("userPw",userPassword);
    }
}
