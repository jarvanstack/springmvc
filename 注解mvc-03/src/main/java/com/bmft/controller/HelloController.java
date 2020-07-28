package com.bmft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello3")//这里写请求的名称,
    //也可以在类上定义父类名称，然后拼接，但是不建议，因为不方便维护.
    public String test(Model model) {
        model.addAttribute("message", "hello SpringMVC Annotation");
        //return 的字符串在 springmvc-config.xml 中配置相关的bean
        //但是这里自动装配了，只需要给出相应的 jsp的名称即可.
        return "test";
    }
}
