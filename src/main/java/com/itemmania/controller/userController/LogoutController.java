package com.itemmania.controller.userController;

import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.http.parser.Authorization;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
@Log4j2
public class LogoutController {

    @GetMapping("/logout")
    public String Logout(HttpSession session)
    {
        if(session.getAttribute("kakaoAccessToken") != null)
        {
            kakaologout((String)session.getAttribute("kakaoAccessToken"));
            log.info("토큰 가져왔다");
        }

//        if(session.getAttribute("naverAccessToken") != null)
//            logout((String)session.getAttribute("naverAccessToken"));

        session.invalidate();

        return "index";
    }


    public Boolean kakaologout(String accessToken)
    {
        try
        {
            URL url = new URL("https://kapi.kakao.com/v1/user/logout");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer" + accessToken);

            int responseCode = conn.getResponseCode();
            log.info("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String result = "";
            String line = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println(result);

            return true;

        }
        catch (IOException e)
        {
            e.printStackTrace();
            log.info(accessToken);

            return false;
        }
    }
}
