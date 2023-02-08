package com.itemmania.controller.userController.myRoomController;

import com.itemmania.domain.ItemCountRequest;
import com.itemmania.entity.UserEntity;
import com.itemmania.service.mileageService.MileageViewService;
import com.itemmania.service.useService.UseItemService;
import com.itemmania.service.userService.MyInfoReadService;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequestMapping("myroom")
public class MyRoomController {

    @Autowired
    private MyInfoReadService myInfoReadService;

    @Autowired
    private UseItemService useItemService;

    @Autowired
    private MileageViewService mileageViewService;

    @GetMapping
    public String getMypageForm(HttpServletRequest request, Model model)
    {

        // 로그인한 user 정보 받아오기
        HttpSession session = request.getSession();
        log.info("UserModifyController......." + session.getAttribute("userInfo"));
        UserEntity user = (UserEntity) session.getAttribute("userInfo");
        int mileage = mileageViewService.getUserMileage(user.getUserNum());
        model.addAttribute("user", user);
        model.addAttribute("mileage", mileage);
        ItemCountRequest itemRequrest = new ItemCountRequest();
        itemRequrest.setItemNum(1);
        log.info("itemRequest =============>" + itemRequrest);
        itemRequrest.setUserNum(user.getUserNum());
        log.info("itemRequest =============>" + itemRequrest);

        model.addAttribute("itemNum", useItemService.getItemCount(itemRequrest));
        log.info("getItemCount =============>" +  useItemService.getItemCount(itemRequrest));
        log.info("myroom user............" + user);

        // 마이룸 페이지 진입
        return "userForm/myRoom/myRoomForm";
        
    }


}
