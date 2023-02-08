package com.itemmania.service.mileageService;

import com.itemmania.entity.MileageEntity;
import com.itemmania.mapper.MileageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MileageViewService {

    @Autowired
    private MileageMapper mileageMapper;

    public int getUserMileage(Integer userNum){
        return mileageMapper.getMileageCount(userNum);
    }

}
