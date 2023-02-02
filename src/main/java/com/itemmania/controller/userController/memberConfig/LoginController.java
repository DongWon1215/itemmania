package com.itemmania.controller.userController.memberConfig;

import com.itemmania.entity.UserEntity;
import com.itemmania.service.boardService.Search.BoardGameSearch;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@Log4j2
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private BoardGameSearch boardGameSearch;


    @GetMapping
    public String loginPage(Model model) {
        model.addAttribute("searchGame", boardGameSearch.getGameService());
        model.addAttribute("searchServer", boardGameSearch.getServerService());

        return "userForm/userRegist/loginForm";
    }

    @PostMapping
    public String login(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("userpassword") String userpassword, Model model
    ) {

        if (!userService.isExistUser(username, userpassword))
            return "/UserForm/userRegist/registerForm";

        UserEntity user = userService.getUser(username, userpassword);

        HttpSession session = request.getSession();

        session.setAttribute("userInfo", user);

        log.info("세션 정보 ==> " + user);

        /*세션으로 만들면 데이터 무결서에 위배되어서 model로 보냄*/
        model.addAttribute("searchGame", boardGameSearch.getGameService());
        model.addAttribute("searchServer", boardGameSearch.getServerService());


        return "index";
    }
}