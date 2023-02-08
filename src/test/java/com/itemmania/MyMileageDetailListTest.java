package com.itemmania;

import com.itemmania.domain.mileage.MyMileageDetailRequest;
import com.itemmania.service.mileageService.MileageViewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class MyMileageDetailListTest {

    @Autowired
    MileageViewService mileageViewService;

    @Test
    public void getList(){

        LocalDateTime starDate;
        starDate = LocalDateTime.of(2023, 2, 8, 1,1);
        LocalDateTime endDate = LocalDateTime.now();

        MyMileageDetailRequest myMileageDetailRequest = new MyMileageDetailRequest();
        myMileageDetailRequest.setUserNum(1);
        myMileageDetailRequest.setStartDate(starDate);
        myMileageDetailRequest.setEndDate(endDate);

        System.out.println(mileageViewService.getMileageHistory(myMileageDetailRequest));
    }


}
