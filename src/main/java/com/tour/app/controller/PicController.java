package com.tour.app.controller;

import com.tour.app.model.entity.Pic;
import com.tour.app.model.mapper.PicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pic")
public class PicController {

    @Autowired
    PicMapper picMapper;

    @GetMapping("/add")
    public String add(){

        return "pic/addPic";
    }

    @ResponseBody
    @GetMapping("/pid/{id}")
    public Object selectByPid(@PathVariable("id")Integer id){


        List<Pic> pics = picMapper.selectPic(id);

        return pics;
    }

}
