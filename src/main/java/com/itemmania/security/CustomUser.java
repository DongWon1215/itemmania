package com.itemmania.security;

import com.itemmania.entity.UserEntity;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUser extends User {

    private UserEntity userEntity;

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, UserEntity userEntity) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userEntity = userEntity;
    }

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, UserEntity userEntity) {
        super(username, password, authorities);
        this.userEntity = userEntity;
    }
}
