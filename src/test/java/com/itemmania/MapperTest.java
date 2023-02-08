package com.itemmania;

import com.itemmania.domain.ItemCountRequest;
import com.itemmania.mapper.ItemMapper;
import com.itemmania.mapper.MileageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MapperTest {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private MileageMapper mileageMapper;

    @Test
    public void getItemCountTest(){
        ItemCountRequest itemCountRequest = new ItemCountRequest();

        itemCountRequest.setItemNum(1);
        itemCountRequest.setUserNum(1);

        int count = itemMapper.getItemCount(itemCountRequest);

        System.out.println(count);
    }

    @Test
    public void getMileageCountTest(){

        System.out.println(mileageMapper.getMileageCount(1));

    }
}
