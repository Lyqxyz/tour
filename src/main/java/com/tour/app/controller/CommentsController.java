package com.tour.app.controller;

import com.tour.app.model.entity.Comments;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @PostMapping("/comm/add")
    @ResponseBody
    public Object add(Comments comments){


        ResponseInfo add = commentsService.add(comments);

        return  add;

    }


}
