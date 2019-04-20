package com.tour.app.controller;

import com.tour.app.model.entity.C;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.entity.Tag;
import com.tour.app.service.CService;
import com.tour.app.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TagController {

    @Autowired
    TagService tagService;

    @PostMapping("/tag/add")
    @ResponseBody
    public Object add(Tag tag){

        ResponseInfo add = tagService.add(tag);

        return add;

    }

    @GetMapping("/tag/all")
    @ResponseBody
    public Object all(){

        ResponseInfo add = tagService.all();

        return add;

    }
}
