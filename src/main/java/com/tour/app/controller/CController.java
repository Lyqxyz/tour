package com.tour.app.controller;

import com.tour.app.model.entity.C;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.service.CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CController {

    @Autowired
    CService cService;

    @PostMapping("/c/add")
    @ResponseBody
    public Object add(C c){

        ResponseInfo add = cService.add(c);

        return add;

    }

    @GetMapping("/c/all")
    @ResponseBody
    public Object all(){

        ResponseInfo add = cService.all();

        return add;

    }

    @GetMapping("/tcView")
    public String tcView(){

        return "admin/tags";
    }

}
