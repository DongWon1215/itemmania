package com.itemmania.repository;

import com.itemmania.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<UserEntity,Integer> {

}