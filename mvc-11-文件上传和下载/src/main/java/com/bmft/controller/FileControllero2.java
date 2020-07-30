package com.bmft.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class FileControllero2 {
    //@RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
    //批量上传CommonsMultipartFile则为数组即可

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("/upload2.do")
    @ResponseBody//返回字符串即可,
    public String  fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

        //上传路径保存设置
        String path = request.getSession().getServletContext().getRealPath("") + "/upload";
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdirs();
            System.err.println("mkdirs（）："+realPath);
        }
        //上传文件地址
        System.out.println("上传文件保存地址："+realPath);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(new File(realPath +"/"+ file.getOriginalFilename()));

        return file.getOriginalFilename()+"OK";
    }
}
