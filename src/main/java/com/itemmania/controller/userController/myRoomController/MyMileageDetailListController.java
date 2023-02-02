package com.itemmania.controller.userController.myRoomController;

import com.itemmania.domain.MyMileageDetailDTO;
import com.itemmania.domain.MyMileageDetailRequest;
import com.itemmania.entity.MileageEntity;
import com.itemmania.service.userService.MyMileageDetailListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/myroom/mymileage/detail_list")
public class MyMileageDetailListController {

    @Autowired
    MyMileageDetailListService myMileageDetailListService;

    @GetMapping
    public String getMyPageForm()
    {
        return "userForm/myRoom/myMileageDetailList";
    }

    @GetMapping("/test")
    @ResponseBody
    public Page<MileageEntity> getMyMileageDetail(MyMileageDetailRequest myMileageDetailRequest, @PageableDefault(size = 5, sort = "mileageTime", direction = Sort.Direction.DESC) Pageable pageable){
        return myMileageDetailListService.getList(myMileageDetailRequest.getUserNum(), myMileageDetailRequest.getStartDate(), myMileageDetailRequest.getEndDate(), pageable);
    }

}