package com.bmft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * model 最常用
 * ModelAndView 我们最开始的时候使用的,要实现接口，不常用
 * ModelMap Model的高级版，功能更多，但是我们最常用还是Model.
 */
@Controller
public class 数据返回的3种方式05 {

    @GetMapping("/method01")
    public String method01(Model model) {

        model.addAttribute("message", "数据返回的3种方式 - 01 Model");
        return "test01";
    }

    @GetMapping("/method03")
    public String method03(ModelMap modelMap) {

        modelMap.addAttribute("message", "数据返回的3种方式 - 03 modelMap");

        return "test01";
    }

}
