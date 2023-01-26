package com.itemmania.controller.userController.memberConfig;

import com.itemmania.domain.IdFindRequest;
import com.itemmania.repository.UserRepository;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/find/id")
@Log4j2
public class IdFindController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping
    public String findform()
    {
        return "/UserForm/userRegist/idFindForm";
    }

    @PostMapping
    @ResponseBody
    public String sendInfo(@RequestBody IdFindRequest idFindRequest)
    {
//        log.info(idFindRequest);
        String userId = userService.findIdByNameAndBirthAndPhoneNum(idFindRequest);

        log.info(userId);

        if(userId == null)
            return "empty";

        return userId;
    }
}
