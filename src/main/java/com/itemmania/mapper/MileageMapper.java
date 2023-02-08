package com.itemmania.mapper;

import com.itemmania.domain.ItemCountRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MileageMapper {

    Integer getMileageCount(Integer userNum);

}
