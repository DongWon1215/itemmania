package com.itemmania.service.userService;

import com.itemmania.mapper.UserMapper;
import com.itemmania.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

}
