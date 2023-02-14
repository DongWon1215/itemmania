package com.itemmania.controller.userController.myRoomController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/myroom/buyRegister")
public class BuyRegisterController {

    @GetMapping
    public String getMypageForm(Module module, Principal principal) {
//        log.info("Principal?" + principal.getName());





        return "UserForm/myRoom/trade/buyRegister";
    }


}
