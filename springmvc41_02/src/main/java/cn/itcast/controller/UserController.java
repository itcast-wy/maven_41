package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @GetMapping("/toLogin")
    public String toLogin(){
        // 直接跳转到login.jsp
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){

        session.invalidate();
        // 如果失败,跳转到toLogin
        return "redirect:/toLogin.action";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session){

        // 判断用户名和密码是否正确
        // 如果正确,跳转到itemList
        if("zs".equals(username)&&"123".equals(password)){
            session.setAttribute("user",username);
            return "redirect:/itemList.action";
        }else{
            // 如果失败,跳转到toLogin
            return "redirect:/toLogin.action";
        }
    }
}
