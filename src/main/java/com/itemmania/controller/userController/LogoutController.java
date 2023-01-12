package com.itemmania.controller.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String Logout(HttpSession session)
    {
        "https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=vPoSYGCMBN6Ay_norea_&client_secret=DKSyDr31x8&access_token=c8ceMEJisO4Se7uGCEYKK1p52L93bHXLnaoETis9YzjfnorlQwEisqemfpKHUq2gY&service_provider=NAVER"
        session.invalidate();

        return "index";
    }
}
