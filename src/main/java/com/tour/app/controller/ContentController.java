package com.tour.app.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tour.app.model.entity.Contents;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Users;
import com.tour.app.model.mapper.ContentMapper;
import com.tour.app.service.ContentService;
import com.tour.app.untils.FileUploadUtil;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
public class ContentController {

    @Autowired
    FileUploadUtil fileUploadUtil;

    @Autowired
    ContentService service;

    @Autowired
    ContentMapper contentMapper;

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

    @ResponseBody
    @GetMapping(path = "/hits/{id}")
    public Object hits(@PathVariable(value = "id")Integer id){

        ResponseInfo hits = service.hits(id);

        return hits;

    }

    @ResponseBody
    @GetMapping(path = "/delete/{id}")
    public Object del(@PathVariable(value = "id")Integer id){

        Integer delete = contentMapper.delete(id);

        ResponseInfo ok = ReponseUtil.ok();
        ok.setMsg("删除成功");

        return ok;

    }

    @ResponseBody
    @PostMapping(path = "/state/{id}")
    public Object updateState(Contents contents, @PathVariable(value = "id")Integer id){

        contents.setCid(id);

        Integer integer = contentMapper.updataState(contents);

        ResponseInfo ok = ReponseUtil.ok();
        ok.setMsg("更新成功");

        return ok;

    }

    @ResponseBody
    @PostMapping(path = "/update/{id}")
    public Object update(Contents contents,@PathVariable(value = "id")Integer id
            ,@PathParam("file")MultipartFile file){

        contents.setCid(id);

        if(Objects.isNull(file)){

            contentMapper.updateById(contents);
            ResponseInfo ok = ReponseUtil.ok();
            ok.setMsg("更新成功");
            return ok;

        }else{

            try {
                String upload = fileUploadUtil.upload(file);
                contents.setThumbImg(upload);
                contentMapper.updateById(contents);
                ResponseInfo ok = ReponseUtil.ok();
                ok.setMsg("更新成功");
                return ok;
            } catch (IOException e) {
                ResponseInfo error = ReponseUtil.error();
                error.setMsg("文件上传失败");
                return error;
            }
        }

    }

    @GetMapping("/con/updateView")
    public String update(){

        return "admin/contentTable";

    }


    @ResponseBody
    @GetMapping(path = "/con/info/{pageSize}/{pageNum}")
    public Object info(@PathVariable(value = "pageSize")Integer pageSize,
                       @PathVariable(value = "pageNum")Integer pageNum){


        ResponseInfo release = service.release(pageSize,pageNum);


        return release;

    }

    @ResponseBody
    @GetMapping(path = "/con/all/{pageSize}/{pageNum}")
    public Object all(@PathVariable(value = "pageSize")Integer pageSize,
                       @PathVariable(value = "pageNum")Integer pageNum){


        PageHelper.startPage(pageSize,pageNum);

        List<Contents> all = contentMapper.all();

        PageInfo<Contents> pageInfo= new PageInfo<>(all);

        return pageInfo;

    }

    @ResponseBody
    @GetMapping(path = "/con/{uid}/{pageSize}/{pageNum}")
    public Object infoByUser(@PathVariable("uid")Integer id,
                             @PathVariable(value = "pageSize")Integer pageSize,
                       @PathVariable(value = "pageNum")Integer pageNum){


       PageHelper.startPage(pageSize,pageNum);

        List<Contents> contents = contentMapper.allById(id);

        PageInfo<Contents> pageInfo= new PageInfo<>(contents);

        return pageInfo;

    }

    @GetMapping("/search")
    public String search(@PathParam("key")String key, Model model){


        List<Contents> contents = contentMapper.selectByKey("%" + key + "%");

        model.addAttribute("contents",contents);


        return "index/search";

    }


    @GetMapping("/con/addView")
    public String addView(){

        return "admin/content";
    }

    @GetMapping("/con/info")
    public String info(){

        return "index/tourlog";
    }

    @GetMapping("/con/user")
    public String userInfo(){

        return "admin/userContent";
    }


}
