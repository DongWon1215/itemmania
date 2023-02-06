package com.itemmania.service.userService;

import com.itemmania.domain.IdFindRequest;
import com.itemmania.domain.PasswordChangeRequest;
import com.itemmania.domain.PasswordFindRequest;
import com.itemmania.entity.UserEntity;
import com.itemmania.mapper.UserMapper;
import com.itemmania.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public boolean isExistEmail(String userEmail)
    {
        return userRepository.existsByUserEmail(userEmail);
    }

    public UserEntity insertUser(UserEntity userEntity)
    {
        return userRepository.save(userEntity);
    }

    public UserEntity findUserByNameAndPhoneNum(String userName, String phoneNum)
    {
        return userRepository.findByUserNameAndUserPhoneNumber(userName,phoneNum);
    }

    public UserEntity findUserByNameAndEmail(String userName, String userEmail)
    {
        return userRepository.findByUserRealNameAndUserEmail(userName,userEmail);
    }

    public String findIdByNameAndBirthAndPhoneNum(IdFindRequest idFindRequest)
    {
        return userMapper.findIdByNameAndBirthAndPhoneNum(idFindRequest);
    }

    public String findPasswordByNameAndBirthAndPhoneNum(PasswordFindRequest passwordFindRequest)
    {
        return userMapper.findPasswordByNameAndBirthAndId(passwordFindRequest);
    }

    public int changePasswordByNameAndBirthAndID(PasswordChangeRequest passwordChangeRequest)
    {
        return userMapper.updateUserPasswordByUserNameAndUserRealNameAndUserBirth(passwordChangeRequest);
    }

    public Optional<UserEntity> findUserByuserNum(int userNum)
    {
        return userRepository.findById(userNum);
    }

}
