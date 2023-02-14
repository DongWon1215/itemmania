package com.itemmania.controller.userController.myRoomController;

import com.itemmania.domain.UserModifyRequest;
import com.itemmania.entity.UserEntity;
import com.itemmania.service.userService.MyInfoModifyService;
import com.itemmania.service.userService.MyInfoReadService;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequestMapping("/myroom/myinfo/modify")
public class MyInfoModifyController {

    @Autowired
    private MyInfoModifyService myInfoModifyService;

    @Autowired
    private MyInfoReadService myInfoReadService;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping
    public String getMypageForm(Model model, HttpServletRequest request){

        // 로그인한 user 정보 받아오기
        HttpSession session = request.getSession();
        log.info("UserModifyController......." + session.getAttribute("userInfo"));
        UserEntity user = (UserEntity) session.getAttribute("userInfo");
        model.addAttribute("user", user);

        // 회원수정 페이지 진입
        return "UserForm/myRoom/myinfoModify";

    }

    @PostMapping
    @ResponseBody
    public JSONObject modifyUser(@RequestBody UserModifyRequest req, HttpServletRequest request){


        log.info("userModifyRequest......." + req);

        // 수정하는 비밀번호 암호화 처리
        req.setUserPassword(encoder.encode(req.getUserPassword()));

        // userNum 으로 특정 유저 선택하여 회원수정
        myInfoModifyService.modifyUser(req);
        UserEntity userInfo = myInfoReadService.selectUser(req.getUserNum());

        // JSON 받기
        JSONObject json = new JSONObject();
        json.put("userData",userInfo);
        log.info("userInfo..................." + userInfo);

        // session userInfo 세팅하기
        HttpSession session = request.getSession();
        session.setAttribute("userInfo",userInfo);

        // JSON 반환
        return json;

    }


}
