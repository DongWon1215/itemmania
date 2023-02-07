package com.itemmania.service.useService;

import com.itemmania.domain.ItemCountRequest;
import com.itemmania.entity.ItemEntity;
import com.itemmania.entity.UseEntity;
import com.itemmania.entity.UserEntity;
import com.itemmania.mapper.ItemMapper;
import com.itemmania.repository.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UseItemService {

    @Autowired
    private UseRepository useRepository;

    @Autowired
    private ItemMapper itemMapper;

    public UseEntity use(int useCount, UserEntity user, ItemEntity item){

        UseEntity useEntity = UseEntity.builder()
                .usedUnit(useCount)
                .usedTime(LocalDateTime.now())
                .itemNum(item)
                .userNum(user).build();

        return useRepository.save(useEntity);
    }

    public int getItemCount(ItemCountRequest itemCountRequest){
        return itemMapper.getItemCount(itemCountRequest);
    }

}
