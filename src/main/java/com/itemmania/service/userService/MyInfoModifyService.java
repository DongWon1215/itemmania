package com.itemmania.service.userService;

import com.itemmania.domain.UserModifyRequest;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Log4j2
@Service
public class MyInfoModifyService {

    @Autowired
    private UserRepository userRepository;

    public int modifyUser(UserModifyRequest userModifyRequest){

        UserEntity user = userModifyRequest.toUserEntity();
        log.info("user......." + user);
        return userRepository.updateUserByUserNum(user.getUserPassword(), user.getUserPhoneNumber(), user.getUserEmail(), user.getUserBirth(), user.getUserNum());

    }

    public UserEntity selectUser(int userNum) {
        return userRepository.findById(userNum).get();
    }


}
