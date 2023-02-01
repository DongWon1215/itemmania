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
    private PasswordEncoder encoder;


    @GetMapping
    public String getMypageForm(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        log.info("UserModifyController......." + session.getAttribute("userInfo"));
        UserEntity user = (UserEntity) session.getAttribute("userInfo");
        model.addAttribute("user", user);
        return "userForm/myRoom/myinfoModify";

    }

    @PostMapping
    @ResponseBody
    public JSONObject modifyUser(UserModifyRequest req, HttpServletRequest request){

        log.info("userModifyRequest......." + req);
        req.setUserPassword(encoder.encode(req.getUserPassword()));

        UserEntity userInfo = req.toUserEntity();
        myInfoModifyService.modifyUser(req);

        JSONObject json = new JSONObject();
        json.put("userData",userInfo);

        HttpSession session = request.getSession();

        session.setAttribute("userInfo",userInfo);

        return json;
        // return "redirect:/myroom";

    }


}
