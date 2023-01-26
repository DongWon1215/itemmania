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

        LocalDate starDate;
        starDate = LocalDate.of(0, 0, 0);
        System.out.println(myMileageDetailListService.getList(1, starDate, LocalDate.now()));
    }


}
