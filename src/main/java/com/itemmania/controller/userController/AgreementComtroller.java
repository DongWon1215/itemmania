package com.itemmania.controller.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agreement")
public class AgreementComtroller {
    @GetMapping
    public String goAgreementPage()
    {
        return "/UserForm/agreementForm";
    }
}
