package com.itemmania.controller.userController.myRoomController;

import com.itemmania.domain.MyMileageDetailDTO;
import com.itemmania.domain.MyMileageDetailRequest;
import com.itemmania.service.userService.MyMileageDetailListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/myroom/mymileage/detail_list")
public class MyMileageDetailListController {

    @Autowired
    MyMileageDetailListService myMileageDetailListService;

    @GetMapping
    public String getMypageForm()
    {
        return "userForm/myRoom/myMileageDetailList";
    }

    @GetMapping("/test")
    @ResponseBody
    public List<MyMileageDetailDTO> getMyMileageDetail(MyMileageDetailRequest myMileageDetailRequest){
        return myMileageDetailListService.getList(myMileageDetailRequest.getUserNum(), myMileageDetailRequest.getStartDate(), myMileageDetailRequest.getEndDate());
    }

}