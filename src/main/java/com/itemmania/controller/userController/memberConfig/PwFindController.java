package com.itemmania.controller.userController.memberConfig;

import com.itemmania.domain.PasswordFindRequest;
import com.itemmania.repository.UserRepository;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequestMapping("/find/pw")
public class PwFindController {
    @Autowired
    private UserRepository userRepository;
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

//    @PutMapping
//    @ResponseBody
//    public int changePassword(@RequestBody )
//    {
//        return userRepository.updateUserPasswordByUserNameAndUserRealNameAndUserBirth();
//    }
}
