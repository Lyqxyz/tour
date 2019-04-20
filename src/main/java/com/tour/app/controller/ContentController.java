package com.tour.app.controller;

import com.tour.app.model.entity.Contents;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Users;
import com.tour.app.service.ContentService;
import com.tour.app.untils.FileUploadUtil;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;

@Controller
public class ContentController {

    @Autowired
    FileUploadUtil fileUploadUtil;

    @Autowired
    ContentService service;

    @PostMapping("/con/add")
    @ResponseBody
    public Object add(Contents contents, @PathParam("file")MultipartFile file, HttpSession session){

        Users user = (Users)session.getAttribute("user");
        try {
            String upload = fileUploadUtil.upload(file);
            contents.setThumbImg(upload);
            contents.setAuthorId(user.getUid());
            ResponseInfo add = service.add(contents);
            return add;
        } catch (IOException e) {

            ResponseInfo error = ReponseUtil.error();
            error.setMsg("文件上传失败");
            return error;
        }

    }

    @GetMapping("/con/addView")
    public String addView(){

        return "admin/content";
    }

}
