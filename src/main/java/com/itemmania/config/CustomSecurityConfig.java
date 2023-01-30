package com.itemmania.config;

import com.itemmania.security.CustomLoginSuccessHandle;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@Log4j2
public class CustomSecurityConfig {

    @Bean
    public SecurityFilterChain filterChai(HttpSecurity httpSecurity)throws Exception
    {
        httpSecurity.csrf().disable();

        httpSecurity.authorizeHttpRequests()
                .antMatchers("/board/**","/myroom/**").hasRole("USER")
                .anyRequest().permitAll();

        httpSecurity.formLogin().loginPage("/login").successHandler(successHandler());

        httpSecurity.logout().logoutUrl("/logout").logoutSuccessUrl("/");

        httpSecurity.rememberMe().key("123456789").rememberMeParameter("remember-me").tokenValiditySeconds(60*60*10);

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler()
    {
        return new CustomLoginSuccessHandle();
    }
}
