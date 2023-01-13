package com.itemmania.mapper;

import com.itemmania.domain.IdFindRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select user_name from user where user_name = #{} and user_birth = #{} and user_phone_number = #{}")
    String findIdByNameAndBirthAndPhoneNum(IdFindRequest idFindRequest);


}
