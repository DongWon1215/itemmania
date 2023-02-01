package com.itemmania.controller.userController.myRoomController;

import com.itemmania.entity.UserEntity;
import com.itemmania.service.userService.MyInfoReadService;
import com.itemmania.service.userService.MyRoomUserLeaveService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;

@Log4j2
@Controller
@RequestMapping("/myroom/user_leave")
public class MyRoomUserLeaveController {

    @Autowired
    private MyRoomUserLeaveService userLeaveService;

    @Autowired
    private MyInfoReadService myInfoReadService;

    @GetMapping
    public String getMypageForm(Model model, HttpServletRequest request)
    {
        // 로그인한 user 정보 받아오기
        HttpSession session = request.getSession();
        log.info("UserLeaveController......." + session.getAttribute("userInfo"));
        UserEntity user = (UserEntity) session.getAttribute("userInfo");
        model.addAttribute("user", user);

        // 회원탈퇴 페이지 진입
        return "userForm/myRoom/myRoomUserLeaveForm";
    }

    @PostMapping
    public String deleteUser(int userNum, @RequestParam("passwd") String passwd, RedirectAttributes rttr, HttpServletRequest request){

        // 로그인한 user 정보 받아오기
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity) session.getAttribute("userInfo");
        String userPassword = user.getUserPassword();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        log.info("passwd........................" + passwd);
        log.info("userPassword........................" + userPassword);

        // 사용자 입력 경우에 따른 회원탈퇴 처리
        // 1. 비밀번호 재확인 일치할 경우
        if(encoder.matches(passwd, userPassword)) {
            log.info("deleteUser.......... userPassword match..........");
            rttr.addFlashAttribute("msg", "success");
            userLeaveService.deleteUser(userNum);
            // session.invalidate();
            return "redirect:/myroom";

        // 2. 비밀번호 재확인 불일치 혹은 미입력일 경우
        } else if(!encoder.matches(passwd, userPassword) || passwd.isEmpty() || passwd == null){
            log.info("비밀번호 재확인......................");
            rttr.addFlashAttribute("msg", "password");
            return "redirect:/myroom/user_leave";

        // 3. 회원탈퇴 실패할 경우
        } else if(userLeaveService.deleteUser(userNum)!=1){
            rttr.addFlashAttribute("msg", "fail");
            return "redirect:/myroom/user_leave";

        // 4. 기타 디폴트
        } else {
            return "redirect:/myroom/user_leave";
        }

    }


}
