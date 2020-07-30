package com.bmft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@Controller
public class Download03 {
    @ResponseBody
    @RequestMapping("/download.do")
    public String downloads(HttpServletResponse response , HttpServletRequest request) throws Exception{
        System.out.println("==========start=========");
        //要下载的图片地址
        String  path = request.getSession().getServletContext().getRealPath("/download");
        String  fileName = "logo.png";
        System.out.println("===========path::"+path);
        System.out.println("request.getSession().getServletContext().::"+request.getSession().getServletContext().getContextPath());
        //1、设置response 响应头
//        response.reset(); //设置页面不缓存,清空buffer
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path,fileName);
        System.out.println("++++++++++file "+file);
        //2、 读取文件--输入流
        InputStream input=new FileInputStream(file);
        System.out.println("========文件流");
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();

        byte[] buff =new byte[1024];
        int index=0;
        //4、执行 写出操作
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        System.out.println("================end and return ==========");
        return fileName+" OK";
    }
}
