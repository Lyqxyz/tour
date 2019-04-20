package com.tour.app.controller;

import com.tour.app.untils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;

@Controller
public class TestController {

    @Autowired
    FileUploadUtil fileUploadUtil;

    @ResponseBody
    @GetMapping("/index")
    public String index(){

        return "hello world ！！！！";
    }
    @ResponseBody
    @PostMapping("/upload")
    public String upload(@PathParam(value = "file") MultipartFile file) throws IOException {

        String upload = fileUploadUtil.upload(file);

        System.out.println(upload);

        return upload;
    }

}
