package com.itemmania.mapper;

import com.itemmania.domain.IdFindRequest;
import com.itemmania.domain.PasswordChangeRequest;
import com.itemmania.domain.PasswordFindRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Mapper
public interface UserMapper {

    @Select("select user_name from user where user_real_name = #{userRealName} and user_birth = #{userBirth} and user_phone_number = #{userPhoneNumber}")
    String findIdByNameAndBirthAndPhoneNum(IdFindRequest idFindRequest);

    @Select("select user_real_name from user where user_real_name = #{userRealName} and user_birth = #{userBirth} and user_email = #{userEmail}")
    String findIdByNameAndBirthAndEmail(PasswordFindRequest passwordFindRequest);

    @Select("select user_password from user where user_real_name = #{userRealName} and user_birth = #{userBirth} and user_name = #{userName}")
    String findPasswordByNameAndBirthAndId(PasswordFindRequest passwordFindRequest);

    @Select("select user_password from user where user_name = #{userRealName} and user_birth = #{userBirth} and user_email = #{userEmail}")
    String findPasswordByNameAndBirthAndEmail(PasswordFindRequest passwordFindRequest);

    @Update("update user u set u.user_password = #{userPassword} where u.user_name = #{userName} and u.user_real_name = #{userRealName} and u.user_birth = #{userBirth}")
    int updateUserPasswordByUserNameAndUserRealNameAndUserBirth(PasswordChangeRequest passwordChangeRequest);

}
