package com.itemmania.controller.userController.memberConfig;

import com.itemmania.domain.KakaoDTO;
import com.itemmania.domain.UserDTO;
import com.itemmania.entity.UserEntity;
import com.itemmania.repository.ItemRepository;
import com.itemmania.service.userService.UserService;
import lombok.extern.log4j.Log4j2;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.buf.UEncoder;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/regist/insert")
@Log4j2
public class InsertInfoConteroller {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public String ToInsertForm(HttpServletRequest request, Model model)
    {
        HttpSession session = request.getSession();

        KakaoDTO token = (KakaoDTO)session.getAttribute("kakaoData");

//        log.info("카카오 데이터 ->" + token);

        if(token != null)
            model.addAttribute("data",token);

        return "/UserForm/userRegist/inputInfoForm";
    }

    @PostMapping
    @ResponseBody
    public JSONObject userData(HttpServletRequest request,@RequestBody UserDTO user)
    {
        log.info("데이터 =>" + user);

        user.setUserPassword(encoder.encode(user.getUserPassword()));

        if(userService.isExistUser(user.getUserName(),user.getUserPassword()))
//            return "/UserForm/userRegist/registerForm";
            return null;

        UserEntity userInfo = user.toUserEntity();

        log.info(itemRepository.getReferenceById(1));
        log.info("유저인포 =============>"+userInfo);
        userService.insertUser(userInfo);

        JSONObject json = new JSONObject();
        json.put("userData",userInfo);

        HttpSession session = request.getSession();

        session.setAttribute("userInfo",userInfo);

        return json;
//        return "/index";
    }

}
