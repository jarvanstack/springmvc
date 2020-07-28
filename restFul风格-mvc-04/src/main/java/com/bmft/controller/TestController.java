package com.bmft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    @GetMapping("/test01/{a}/{b}")
    public String test01(@PathVariable int a ,@PathVariable int b , Model model){
        int result = a+b;
        model.addAttribute("message"," a + b = "+result);
        return "test01";
    }

    @PostMapping("/test01")
    public String test02(String a,  String b, Model model) {

        model.addAttribute("message", " test02 String a + b = " + a+b);

        return "test01";
    }
}
