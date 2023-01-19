package com.itemmania.repository;

import com.itemmania.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserNameAndUserPassword(String userName, String userPassword);

    boolean existsByUserNameAndUserPassword(String userName, String userPassword);

    boolean existsByUserName(String userName);

    UserEntity findByUserNameAndUserPhoneNumber(String userName, String userPhoneNumber);

    // 회원정보 수정 (마이룸 > 개인정보수정)
    @Transactional
    @Modifying
    @Query("""
            update UserEntity u set u.userRealName = ?1, u.userPassword = ?2, u.userPhoneNumber = ?3, u.userEmail = ?4
            where u.userNum = ?5""")
    int updateUserByUserNum(String userRealName, String userPassword, String userPhoneNumber, String userEmail, int userNum);








}
