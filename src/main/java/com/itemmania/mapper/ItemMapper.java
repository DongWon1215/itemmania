package com.itemmania.mapper;

import com.itemmania.domain.ItemCountRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ItemMapper {

    Integer getItemCount(ItemCountRequest itemCountRequest);

}
