package com.itemmania.service.userService;

import com.itemmania.entity.UserEntity;
import com.itemmania.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyInfoReadService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity selectUser(int userNum) {
        return userRepository.findById(userNum).get();
    }

}
