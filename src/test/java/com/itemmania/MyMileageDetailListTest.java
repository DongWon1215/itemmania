package com.itemmania;

import com.itemmania.domain.MyMileageDetailDTO;
import com.itemmania.domain.MyMileageDetailRequest;
import com.itemmania.service.mileageService.MileageViewService;
import com.itemmania.service.userService.MyMileageDetailListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

@SpringBootTest
public class MyMileageDetailListTest {

    @Autowired
    MileageViewService mileageViewService;

    @Test
    public void getList(){

        LocalDateTime starDate;
        starDate = LocalDateTime.of(1, 1, 1, 1,1);
        LocalDateTime endDate = LocalDateTime.now();

        MyMileageDetailRequest myMileageDetailRequest = new MyMileageDetailRequest();
        myMileageDetailRequest.setUserNum(1);
        myMileageDetailRequest.setStartDate(starDate);
        myMileageDetailRequest.setEndDate(endDate);

        System.out.println(mileageViewService.getMileageHistory(myMileageDetailRequest));
    }


}
