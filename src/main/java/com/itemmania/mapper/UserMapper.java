package com.itemmania.mapper;

import com.itemmania.domain.IdFindRequest;
import com.itemmania.domain.PasswordFindRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select user_name from user where user_name = #{userRealName} and user_birth = #{userBirth} and user_phone_number = #{userPhoneNumber}")
    String findIdByNameAndBirthAndPhoneNum(IdFindRequest idFindRequest);

    @Select("select user_real_name from user where user_name = #{userRealName} and user_birth = #{userBirth} and user_phone_number = #{userEmail}")
    String findIdByNameAndBirthAndEmail(PasswordFindRequest passwordFindRequest);

    @Select("select user_pass_word from user where user_name = #{userRealName} and user_birth = #{userBirth} and user_phone_number = #{userName}")
    String findPasswordByNameAndBirthAndPhoneNum(PasswordFindRequest passwordFindRequest);

    @Select("select user_pass_word from user where user_name = #{userRealName} and user_birth = #{userBirth} and user_phone_number = #{userEmail}")
    String findPasswordByNameAndBirthAndEmail(PasswordFindRequest passwordFindRequest);

}
