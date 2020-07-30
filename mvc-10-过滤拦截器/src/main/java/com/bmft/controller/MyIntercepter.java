package com.bmft.controller;

import com.bmft.util.MyConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.bmft.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MyIntercepter {
    @PostMapping("/login.do")
    public String login(String username, String password, Model model, HttpServletRequest req){
        System.err.println(username);
        System.err.println(password);

        if (username != null && password != null && username.equals("admin") && password.equals("123456")) {
            HttpSession session = req.getSession();
            session.setAttribute(MyConst.userSession,new User(username,password));
            model.addAttribute(MyConst.userSession,username);
            return "main";
        }else {
            model.addAttribute("message","账号或密码错误");
            return "redirect:/index.jsp";
        }
    }

}
