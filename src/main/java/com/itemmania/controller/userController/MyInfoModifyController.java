package com.itemmania.controller.userController;

import com.itemmania.domain.UserModifyRequest;
import com.itemmania.service.userService.MyInfoModifyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequestMapping("/myroom/myinfo/modify")
public class MyInfoModifyController {

    @Autowired
    MyInfoModifyService myInfoModifyService;

    @GetMapping
    public String getMypageForm()
    {
        return "userForm/myRoom/myinfoModify";
    }

    @PostMapping
    public String modifyUser(UserModifyRequest req, RedirectAttributes rttr){
        log.info("UserRequest......." + req);
        rttr.addAttribute("UserNum", req.getUserNum());
        rttr.addFlashAttribute("msg", "modify");
        return "redirect:/myroom";
    }


}
