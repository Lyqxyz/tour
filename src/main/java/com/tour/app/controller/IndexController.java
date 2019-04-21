package com.tour.app.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tour.app.model.entity.Comments;
import com.tour.app.model.entity.Contents;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Spot;
import com.tour.app.model.mapper.CommentsMapper;
import com.tour.app.model.mapper.ContentMapper;
import com.tour.app.model.mapper.SpotMapper;
import com.tour.app.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class IndexController {


    @Autowired
    ContentService service;

    @Autowired
    ContentMapper contentMapper;

    @Autowired
    SpotMapper spotMapper;

    @Autowired
    CommentsMapper commentsMapper;

    @GetMapping(value = "/home")
    public String index(Model model){

        PageHelper.startPage(1,3);

        List<Contents> release = contentMapper.release();

        PageInfo<Contents> pageInfo= new PageInfo<>(release);



        PageHelper.startPage(1,4);

        List<Spot> all = spotMapper.all();

        model.addAttribute("spots",all);
        model.addAttribute("cons",pageInfo);

        return "index/index";
    }

    @GetMapping(path = "/detail/{id}")
    public String detail(@PathVariable(value = "id")Integer id,Model model){

        Contents contents = contentMapper.selectById(id);

        model.addAttribute("detail",contents);

        List<Comments> comments = commentsMapper.selectByCid(id);

        model.addAttribute("comments",comments);

        return "index/detail";

    }
}
