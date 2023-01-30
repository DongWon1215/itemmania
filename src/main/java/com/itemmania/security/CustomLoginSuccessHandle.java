package com.itemmania.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
public class CustomLoginSuccessHandle implements AuthenticationSuccessHandler {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        CustomUser user = (CustomUser)authentication.getPrincipal();

        HttpSession session = request.getSession();

        log.info("userInfo ===========>" + user.getUserEntity());

        boolean passResult = encoder.matches(request.getParameter("password"),user.getPassword());

        if(passResult)
        {
            response.sendRedirect("/login?error");
        }

        session.setAttribute("userInfo",user.getUserEntity());

        response.sendRedirect("/myroom");
    }
}
