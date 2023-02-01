package com.itemmania.controller.userController.myRoomController;

import com.itemmania.entity.UserEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequestMapping("/myroom/myinfo/credit_rating")
public class MyInfoCreditRatingController {

    @GetMapping
    public String getMypageForm(Model model, HttpServletRequest request)
    {
        // 로그인한 user 정보 받아오기
        HttpSession session = request.getSession();
        log.info("UserModifyController......." + session.getAttribute("userInfo"));
        UserEntity user = (UserEntity) session.getAttribute("userInfo");
        model.addAttribute("user", user);
        
        // 신용등급 페이지 진입
        return "userForm/myRoom/myinfoCreditRating";
    }


}