package com.bmft.controller;


import com.alibaba.fastjson.JSON;
import com.bmft.pojo.User;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController//这个代表只返回字符串的，不经过视图解析器，这里也没有配置视图解析器.
public class AjaxController {

    @RequestMapping("/test01")//返回字符串数据
    public String test01(@Nullable String name) throws UnsupportedEncodingException {
        try {
            assert name != null;//后端接收中文数据：无论如何都只需要反编译一次.
            name = URLDecoder.decode(name,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.err.println("=======   "+name);
        if (name.equals("root")) {
            return URLEncoder.encode("超级管理员","utf-8");
        } else {
            return "用户错误";
        }
    }
    //返回页面 + 对象
    @RequestMapping("/test02")//遍历数据
    public String  test02() throws UnsupportedEncodingException {
        List<User> users = new ArrayList<>();
        users.add(new User("张三",13));
        users.add(new User("李四",13));
        users.add(new User("王二麻子",13));
        return JSON.toJSONString(users);//@RestController注解，将list转成json格式返回
        //因为@RestController的原因，将list转化为json格式返回
    }
    /**
     * 狂神不改的代码能跑否？？
     */
    @RequestMapping("/a2")
    public List<User> ajax2(){
        List<User> list = new ArrayList<>();
        list.add(new User("秦疆1号",3));
        list.add(new User("秦疆2号",3));
        list.add(new User("秦疆3号",3));
        return list; //由于@RestController注解，将list转成json格式返回
    }


}
