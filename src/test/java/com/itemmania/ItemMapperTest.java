package com.itemmania;

import com.itemmania.domain.ItemCountRequest;
import com.itemmania.mapper.ItemMapper;
import com.itemmania.repository.ItemRepository;
import com.itemmania.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemMapperTest {

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void getCountTest(){
        ItemCountRequest itemCountRequest = new ItemCountRequest();

        itemCountRequest.setItemNum(1);
        itemCountRequest.setUserNum(1);

        int count = itemMapper.getItemCount(itemCountRequest);

        System.out.println(count);
    }
}
