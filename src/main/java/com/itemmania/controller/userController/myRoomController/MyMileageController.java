package com.itemmania.controller.userController.myRoomController;

import com.itemmania.entity.UserEntity;
import com.itemmania.service.mileageService.MileageViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/myroom/mymileage")
public class MyMileageController {

    @Autowired
    private MileageViewService mileageViewService;

    @GetMapping
    public String getMypageForm(HttpSession session, Model model)
    {
        UserEntity user = (UserEntity) session.getAttribute("userInfo");
        model.addAttribute("mileage", mileageViewService.getUserMileage(user.getUserNum()));
        return "UserForm/myRoom/myMileage";
    }


}
