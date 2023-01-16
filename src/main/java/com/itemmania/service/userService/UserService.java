package com.itemmania.service.userService;

import com.itemmania.domain.IdFindRequest;
import com.itemmania.domain.PasswordFindRequest;
import com.itemmania.entity.UserEntity;
import com.itemmania.mapper.UserMapper;
import com.itemmania.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    @Autowired(required = false)
    private UserRepository userRepository;

    @Autowired(required = false)
    private UserMapper userMapper;

    public UserEntity getUser(String userName, String userPassword)
    {
        return userRepository.findByUserNameAndUserPassword(userName, userPassword);
    }

    public boolean isExistUser(String userName, String userPassword)
    {
        return userRepository.existsByUserNameAndUserPassword(userName, userPassword);
    }

    public boolean isExsitNickName(String userName)
    {
        return userRepository.existsByUserName(userName);
    }

    public UserEntity insertUser(UserEntity userEntity)
    {
        return userRepository.save(userEntity);
    }

    public UserEntity findUserByNameAndPhoneNum(String userName, String phoneNum)
    {
        return userRepository.findByUserNameAndUserPhoneNumber(userName,phoneNum);
    }

    public String findIdByNameAndBirthAndPhoneNum(IdFindRequest idFindRequest)
    {
        return userMapper.findIdByNameAndBirthAndPhoneNum(idFindRequest);
    }

    public String findPasswordByNameAndBirthAndPhoneNum(PasswordFindRequest passwordFindRequest)
    {
        return userMapper.findPasswordByNameAndBirthAndPhoneNum(passwordFindRequest);
    }

}
