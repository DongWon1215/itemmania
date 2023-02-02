package com.itemmania;

import com.itemmania.service.userService.MyMileageDetailListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
        Pageable pageable = PageRequest.of(0, 5, Sort.Direction.DESC, "mileageTime");
        System.out.println(myMileageDetailListService.getList(1, starDate, LocalDateTime.now(), pageable));
    }


}
