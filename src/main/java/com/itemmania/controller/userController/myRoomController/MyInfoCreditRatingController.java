package com.itemmania.controller.userController.myRoomController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myroom/myinfo/credit_rating")
public class MyInfoCreditRatingController {

    @GetMapping
    public String getMypageForm()
    {
        return "userForm/myRoom/myinfoCreditRating";
    }


}