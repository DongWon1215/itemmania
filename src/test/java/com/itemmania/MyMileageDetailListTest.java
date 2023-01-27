package com.itemmania;

import com.itemmania.service.userService.MyMileageDetailListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class MyMileageDetailListTest {

    @Autowired
    MyMileageDetailListService myMileageDetailListService;

    @Test
    public void getList(){

        LocalDateTime starDate;
        starDate = LocalDateTime.of(1, 1, 1, 1,1);
        System.out.println(myMileageDetailListService.getList(1, starDate, LocalDateTime.now()));
    }


}
