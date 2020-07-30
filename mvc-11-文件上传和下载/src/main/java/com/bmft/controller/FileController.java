package com.bmft.controller;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class FileController {
    //@RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
    //批量上传CommonsMultipartFile则为数组即可
    @ResponseBody//返回字符串即可,
    @RequestMapping("/upload.do")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file , HttpServletRequest request) throws IOException {

        //获取文件名 : file.getOriginalFilename();
        String uploadFileName = file.getOriginalFilename();

        //如果文件名为空，直接回到首页！
        if ("".equals(uploadFileName)){
            return "redirect:/index.jsp";
        }
        System.err.println("上传文件名 : "+uploadFileName);

        //上传路径保存设置
        String path = request.getSession().getServletContext().getRealPath("/") + "/upload";
        System.out.println("+++++++realpath = "+path);
        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("上传文件保存地址："+realPath);

        InputStream is = file.getInputStream(); //文件输入流\
        File file1 = new File(realPath, uploadFileName);
        if (!file1.getParentFile().exists()) {
            System.err.println("文件夹"+realPath+"不存在，新建文件夹");
            file1.getParentFile().mkdirs();
        }
        OutputStream os = new FileOutputStream(file1); //文件输出流

        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
        return uploadFileName+" OK";
    }
}
