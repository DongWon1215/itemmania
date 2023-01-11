package com.itemmania.repository;

import com.itemmania.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserNameAndUserPassword(String userName, String userPassword);

    boolean existsByUserNameAndUserPassword(String userName, String userPassword);




}
