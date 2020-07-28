package com.bmft.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1. 实现接口Controller
 * 2.
 */
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //2.新建模型和视图
        ModelAndView modelAndView = new ModelAndView();
        //3.封装返回的对象
        modelAndView.addObject("message","HelloSpringMVC");
        //4.封装要跳转的视图，放到modelAndView中
        modelAndView.setViewName("hello");
        //返回mv
        return modelAndView;
    }
}
