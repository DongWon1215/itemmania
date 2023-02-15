package com.itemmania.service.mileageService;

import com.itemmania.entity.MileageEntity;
import com.itemmania.repository.MileageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MileageInsertService {

    @Autowired
    MileageRepository mileageRepository;


    public MileageEntity setMileage(MileageEntity mileageEntity) {

        MileageEntity saveAll = mileageRepository.save(mileageEntity);


        return saveAll;
    }


}
