package com.itemmania.config;

import com.itemmania.security.CustomLoginSuccessHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Log4j2
public class CustomSecurityConfig {

    @Bean
public SecurityFilterChain filterChai(HttpSecurity httpSecurity)throws Exception
    {
        httpSecurity.csrf().disable();

        httpSecurity.authorizeHttpRequests().antMatchers("/").permitAll()
                .antMatchers("/board/**").hasRole("USER")
                .antMatchers("/myroom/**").hasRole("USER");

        httpSecurity.formLogin().loginPage("/login");

        httpSecurity.logout().logoutUrl("/logout").logoutSuccessUrl("/");

        httpSecurity.rememberMe().key("123456789").rememberMeParameter("remember-me").tokenValiditySeconds(60*60*10);

        return httpSecurity.build();
    }
}
