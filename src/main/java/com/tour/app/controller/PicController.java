package com.tour.app.controller;

import com.tour.app.model.entity.Pic;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.mapper.PicMapper;
import com.tour.app.service.PicService;
import com.tour.app.untils.FileUploadUtil;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/pic")
public class PicController {

    @Autowired
    PicMapper picMapper;

    @Autowired
    PicService picService;

    @GetMapping("/add")
    public String add(){

        return "pic/addPic";
    }


    @ResponseBody
    @PostMapping("/addpic")
    public Object addpic(Pic pic,@RequestParam("file")MultipartFile[] files){

        ResponseInfo addpic = picService.addpic(pic, files);

        return addpic;
    }


    @ResponseBody
    @GetMapping("/del/{id}")
    public Object del(@PathVariable("id")Integer id){

        Integer del = picMapper.del(id);

        ResponseInfo ok = ReponseUtil.ok();
        ok.setMsg("删除成功");

        return ok;
    }


    @ResponseBody
    @GetMapping("/pid/{id}")
    public Object selectByPid(@PathVariable("id")Integer id){


        List<Pic> pics = picMapper.selectPic(id);

        return pics;
    }

    @GetMapping("/user/{id}")
    public String infoView(@PathVariable("id")Integer id, Model model){

        model.addAttribute("uid",id);

        return "pic/index";

    }

}
