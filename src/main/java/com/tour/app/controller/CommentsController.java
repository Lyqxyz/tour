package com.tour.app.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tour.app.model.entity.Comments;
import com.tour.app.model.entity.Contents;
import com.tour.app.model.entity.ResponseInfo;
import com.tour.app.model.mapper.CommentsMapper;
import com.tour.app.model.mapper.ContentMapper;
import com.tour.app.service.CommentsService;
import com.tour.app.untils.ReponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @Autowired
    CommentsMapper commentsMapper;

    @PostMapping("/comm/add")
    @ResponseBody
    public Object add(Comments comments){


        ResponseInfo add = commentsService.add(comments);

        return  add;

    }
    @PostMapping("/comm/update/{id}")
    @ResponseBody
    public Object update(Comments comments,@PathVariable("id") Integer id){


        comments.setCoid(id);
        commentsMapper.updateComments(comments);

        ResponseInfo ok = ReponseUtil.ok();
        ok.setMsg("更新成功");

        return  ok;

    }

    @ResponseBody
    @GetMapping("/comm/info/{pageSize}/{pageNum}")
    public Object all(@PathVariable(value = "pageSize")Integer pageSize,
                      @PathVariable(value = "pageNum")Integer pageNum){


        PageHelper.startPage(pageSize,pageNum);

        List<Comments> all = commentsMapper.all();


        PageInfo<Comments> pageInfo= new PageInfo<>(all);

        return pageInfo;

    }

    @ResponseBody
    @GetMapping("/comm/{uid}/{pageSize}/{pageNum}")
    public Object allByUser(@PathVariable("uid")Integer uid, @PathVariable(value = "pageSize")Integer pageSize,
                      @PathVariable(value = "pageNum")Integer pageNum){


        PageHelper.startPage(pageSize,pageNum);

        List<Comments> all = commentsMapper.allByUser(uid);

        PageInfo<Comments> pageInfo= new PageInfo<>(all);

        return pageInfo;

    }

    @ResponseBody
    @PostMapping(path = "/commstate/{id}")
    public Object updateState(Comments comments, @PathVariable(value = "id")Integer id){

        comments.setCoid(id);

        commentsMapper.updateById(comments);

        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("更新成功");

        return ok;

    }
    @ResponseBody
    @GetMapping(path = "/commstate/del/{id}")
    public Object del( @PathVariable(value = "id")Integer id){

        Integer del = commentsMapper.del(id);

        ResponseInfo ok = ReponseUtil.ok();

        ok.setMsg("删除成功");

        return ok;

    }

    @GetMapping("/comm/admin")
    public String allInfo(){


        return "admin/commentsTable";
    }

    @GetMapping("/comm/user")
    public String allByU(){


        return "admin/UserCommentsTable";
    }

}
