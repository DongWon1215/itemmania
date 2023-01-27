package com.itemmania.repository;

import com.itemmania.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    boolean existsByUserEmail(String userEmail);
    UserEntity findByUserNameAndUserPassword(String userName, String userPassword);

    boolean existsByUserNameAndUserPassword(String userName, String userPassword);

    boolean existsByUserName(String userName);

    UserEntity findByUserNameAndUserPhoneNumber(String userName, String userPhoneNumber);

    UserEntity findByUserRealNameAndUserEmail(String userRealName, String userEmail);

    // 회원정보 수정 (마이룸 > 개인정보수정)
    @Transactional
    @Modifying
    @Query("""
            update UserEntity u set u.userPassword = ?1, u.userPhoneNumber = ?2, u.userEmail = ?3, u.userBirth = ?4
            where u.userNum = ?5""")
    int updateUserByUserNum(String userPassword, String userPhoneNumber, String userEmail, LocalDate userBirth, int userNum);









}
