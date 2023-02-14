package com.itemmania.controller.userController.myRoomController;

import com.itemmania.domain.mileage.MyMileageDetailDTO;
import com.itemmania.domain.mileage.MyMileageDetailRequest;
import com.itemmania.entity.MileageEntity;
import com.itemmania.service.mileageService.MileageViewService;
import com.itemmania.service.userService.MyMileageDetailListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@Controller
public class MyMileageDetailListController {

//    @Autowired
//    MyMileageDetailListService myMileageDetailListService;

    @Autowired
    private MileageViewService mileageViewService;

    @GetMapping("myroom/mymileage/detail_list")
    public String getMyPageForm()
    {
        return "UserForm/myRoom/myMileageDetailList";
    }

    @GetMapping("test5")
    @ResponseBody
    public List<MyMileageDetailDTO> getMyMileageDetail(MyMileageDetailRequest myMileageDetailRequest){

        log.info(myMileageDetailRequest + "@@@@@@@@@@@@@@@@");

        log.info(mileageViewService.getMileageHistory(myMileageDetailRequest));
        return mileageViewService.getMileageHistory(myMileageDetailRequest);
    }

}