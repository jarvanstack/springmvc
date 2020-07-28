package com.bmft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 处理前端的数据
 * 建议使用注解规范和匹配前端的
 * 对前端的参数的名称
 */
@Controller
public class 数据处理02 {
    //建议使用注解 RequestParam来规范和前端的参数名的匹配
    @GetMapping("/test03")
    public String  test03(@RequestParam("name") String name, Model model){
        model.addAttribute("message","test03: "+name);

        return "test01";
    }
}
