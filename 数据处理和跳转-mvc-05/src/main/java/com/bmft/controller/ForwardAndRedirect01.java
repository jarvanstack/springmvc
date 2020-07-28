package com.bmft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 1.转发和重定向的测试
 */
@Controller
public class ForwardAndRedirect01 {
    //默认 是转发
    @GetMapping("/test01")
    public String test01(Model model) {

        model.addAttribute("message", "test01转发默认或者显示定义 forward:");
        return "test01";
    }

    //重定向【这个可重点理解下】
    @GetMapping("/test02")
    public String test02(String a, String b, Model model) {

        model.addAttribute("message", "test02重定向 redirect:");

        return "redirect:/index.jsp";
    }
}
