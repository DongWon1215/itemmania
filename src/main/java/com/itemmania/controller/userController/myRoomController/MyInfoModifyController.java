package com.itemmania.controller.userController.myRoomController;

import com.itemmania.domain.UserModifyRequest;
import com.itemmania.service.userService.MyInfoModifyService;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping
    public String getMypageForm(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        log.info("UserModifyController......." + session.getAttribute("userInfo"));
        model.addAttribute("user", myInfoModifyService.selectUser(2));
        return "userForm/myRoom/myinfoModify";

    }

    @PostMapping
    public String modifyUser(UserModifyRequest req, RedirectAttributes rttr, UserModifyRequest userModifyRequest){

        log.info("userModifyRequest......." + userModifyRequest);
        log.info("UserRequest......." + req);
        rttr.addAttribute("userNum", req.getUserNum());
        rttr.addFlashAttribute("msg", "modify");
        myInfoModifyService.modifyUser(req);
        return "redirect:/myroom";

    }


}
