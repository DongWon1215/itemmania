package com.itemmania.security;

import com.itemmania.entity.UserEntity;
import com.itemmania.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CustomUserDetail implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> member = userRepository.findByUserName(username);

        if(member.isEmpty())
            throw new UsernameNotFoundException("회원 정보를 찾을 수 없습니다");

        UserEntity userEntity = member.get();

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        if(!userEntity.isUserIsManager())
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        else
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        CustomUser user = new CustomUser(userEntity.getUserName(),userEntity.getUserPassword(),authorities,userEntity);

        return user;
    }
}
