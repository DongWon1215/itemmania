package com.itemmania.controller.userController.myRoomController;

import com.itemmania.entity.BoardEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myroom/sellRegister")
public class SellRegisterController {



    @GetMapping
    public String getMypageForm(BoardEntity boardEntity, Model model) {





        return "userForm/myRoom/trade/sellRegister";
    }


}
