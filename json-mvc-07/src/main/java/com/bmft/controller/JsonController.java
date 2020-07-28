package com.bmft.controller;

import com.alibaba.fastjson.JSON;
import com.bmft.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JsonController {
    @GetMapping("/test01")
    public String test01(){
        User user = new User("张三", 11, "男");
        System.out.println("user: "+user);
        String s = JSON.toJSONString(user);
        System.out.println("JSON.toJSONString(user);:   "+s);
        return s; }

}
