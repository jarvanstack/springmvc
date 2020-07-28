package com.bmft.controller;

import com.bmft.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 提交的是一个对象04
 * 自动匹配，但是
 * 前端的参数名需要和后端的对象的字段名一致
 */
@Controller
public class 提交的是一个对象04 {
    @GetMapping("/test04")
    public String test04(User user, Model model) {
        model.addAttribute("message", user.toString());
        System.out.println(user);
        return "test01";
    }
}
